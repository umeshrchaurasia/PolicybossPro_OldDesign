package com.policyboss.policybosspro.login

import android.app.AlertDialog
import android.content.Intent
import android.os.Bundle
import android.os.CountDownTimer
import android.text.Editable
import android.text.TextWatcher
import android.util.Log
import android.view.KeyEvent
import android.view.View
import android.view.WindowManager
import android.widget.EditText
import android.widget.RadioButton
import android.widget.TextView
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import com.policyboss.policybosspro.APIState
import com.policyboss.policybosspro.BaseKotlinActivity
import com.policyboss.policybosspro.R
import com.policyboss.policybosspro.databinding.ActivityLoginNewBinding
import com.policyboss.policybosspro.databinding.LayoutLoginViaotpBinding
import com.policyboss.policybosspro.databinding.LayoutLoginViapasswordBinding
import com.policyboss.policybosspro.hideKeyboard
import com.policyboss.policybosspro.home.HomeActivity
import com.policyboss.policybosspro.login.model.Repository.LoginNewRepository
import com.policyboss.policybosspro.login.model.Repository.LoginNewViewModelFactory
import com.policyboss.policybosspro.login.model.viewmodel.LoginViewModel
import com.policyboss.policybosspro.showAlert
import com.policyboss.policybosspro.showKeyboard
import com.policyboss.policybosspro.utility.showToast
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import magicfinmart.datacomp.com.finmartserviceapi.LoginPrefManager
import magicfinmart.datacomp.com.finmartserviceapi.finmart.retrobuilder.RetroHelper

class LoginNewActivity : BaseKotlinActivity() {

    lateinit var binding:ActivityLoginNewBinding

    lateinit var bindingOTP :LayoutLoginViaotpBinding
  // private val loginViewModel by viewModels<LoginViewModel>()
  //  lateinit var loginViewModel: LoginViewModel

    lateinit var  loginViewModel: LoginViewModel

    lateinit var prefManager : LoginPrefManager

    lateinit var etLoginID : EditText

    var selectedLogin: LoginOption = LoginOption.NoData // Default value


    private var isPasswordObserving = false
    private var isDSASObserving = false
    private var isOTPVerifyObserving = false

    private lateinit var alertDialogPassword: AlertDialog

    private lateinit var alertDialogOTP : AlertDialog




    private var timer: CountDownTimer? = null

    private var resendTime = 20      // 20 sec after resend is Launched...

    private var isResendOTPUpdate = false

    //selected edittext position
    var selectedETPosition = 0    // For OTP EditText Dialog

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityLoginNewBinding.inflate(layoutInflater)
        setContentView(binding.root)

        //Default KeyBoard PopUp when EditText
       // this.window?.setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_ALWAYS_VISIBLE)

        init()

        radioButtonListner()

        // displaying the response which we get from above API
         observe()

        binding.includeLoginNew.btnNext.setOnClickListener {

           // loginViewModel.getLoginDetailHorizon("124970") //ss_id="124970"
            //validateNextButton()


            hideKeyboard(binding.root)
            if(etLoginID.text.isNotBlank() && selectedLogin == LoginOption.OTP){

                 //05temp
                loginViewModel.getotpLoginHorizon(etLoginID.text.toString())

//                if (!this::alertDialogOTP.isInitialized) {
//
//                    showOTPDialog(mobNo = "909099")
//
//                }else{
//
//                    if(!alertDialogOTP.isShowing){
//                        showOTPDialog(mobNo = "909099")
//                    }
//                }



            }else if(etLoginID.text.isNotBlank() && selectedLogin == LoginOption.Password){
                showPasswordDialog(strUserID = etLoginID.text.toString().trim())
            }
            else{
                showAlert("Please Enter User ID")
            }

        }



    }


    //region method
    private fun init(){


        setEnableNextButton(false)


        etLoginID = binding.includeLoginNew.etEmail
        prefManager = LoginPrefManager(this@LoginNewActivity)
        var loginRepository = LoginNewRepository(RetroHelper.api)

        var  viewModelFactory = LoginNewViewModelFactory(loginRepository, prefManager)

         loginViewModel = ViewModelProvider(this,viewModelFactory).get(LoginViewModel ::class.java)



    }



    //region Radio Button for Login Type
    fun setEnableNextButton(bln : Boolean){

        if(bln){
            binding.includeLoginNew.btnNext.apply {
                isEnabled = bln
                alpha = 1f   // Set alpha back to 1 (100% opacity)
            }
        }else{
            binding.includeLoginNew.btnNext.apply {
                isEnabled = bln
                alpha = 0.5f   ///Set alpha to 0.5 (50% transparency)
            }
        }

    }


    private fun radioButtonListner(){

        // Listen for changes in the RadioGroup
        binding.includeLoginNew.radioGroup.setOnCheckedChangeListener { group, checkedId ->
            // Check if any radio button is selected
            val selectedRadioButton = findViewById<RadioButton>(checkedId)

            if (selectedRadioButton != null) {

                // Handle the selected radio button (e.g., display a toast with the selected text)

                setEnableNextButton(bln = true)
                selectedLogin = when(selectedRadioButton.id){
                    R.id.rbOtp -> LoginOption.OTP
                    R.id.rbPassword -> LoginOption.Password
                    // Add more cases as needed for other RadioButtons
                    else ->LoginOption.NoData
                }
            }
        }
    }

    //endregion

    private fun observe() {

        //region  Login Using OTP Alert
        lifecycleScope.launch {

            repeatOnLifecycle(Lifecycle.State.CREATED) {

                loginViewModel.otpLoginStateFlow.collect {

                        when (it) {
                            is APIState.Loading -> {
                                // showAnimDialog()
                                displayLoadingWithText()

                            }

                            is APIState.Success -> {


                                hideLoading()
                                if (it != null) {

                                    var mobileNo = it.data?.Msg?.Mobile_No?:0
                                    // showAlert(prefManager.getSSIDByOTP())

                                    showOTPDialog(mobNo = mobileNo.toString())
                                }
                            }

                            is APIState.Failure -> {
                                hideLoading()
                                Log.d("Error", it.errorMessage.toString())
                                showToast(it.errorMessage.toString())


                            }

                            is APIState.Empty -> {
                                hideLoading()
                            }
                        }

                }


            }


        }
        //endregion

        // region otp Verification Horizon
        lifecycleScope.launch{

            repeatOnLifecycle(Lifecycle.State.CREATED){

                loginViewModel.otpVerificationStateFlow.collect{

                    when(it){
                        is  APIState.Loading -> {
                            // showAnimDialog()
                            displayLoadingWithText()

                        }

                        is APIState.Success -> {


                            hideLoading()
                            if (it != null) {



                            }else{
                                showToast(it.errorMessage.toString())
                            }
                        }

                        is APIState.Failure -> {
                            hideLoading()
                            Log.d("Error",it.errorMessage.toString())

                            if (this@LoginNewActivity::alertDialogOTP.isInitialized){
                                if(alertDialogOTP.isShowing){
                                    alertDialogOTP.dismiss()
                                }

                            }

                            showOTPDialog(mobNo = loginViewModel.getOtpMobileNo(), errorMsg = "InValid OTP")
                          //  showToast(it.errorMessage.toString())


                        }

                        is APIState.Empty ->{


                        }
                    }
                }




            }


        }
        //endregion

        //region Login Using Id and Password Alert
        lifecycleScope.launch{

            repeatOnLifecycle(Lifecycle.State.CREATED){

               if(!isPasswordObserving) {
                   isPasswordObserving = true

                   loginViewModel.authLoginStateFlow.collect{

                       when(it){
                           is  APIState.Loading -> {
                               // showAnimDialog()
                               displayLoadingWithText()

                           }

                           is APIState.Success -> {

                             // Call Horizon DSSS API

                           }

                           is APIState.Failure -> {
                               hideLoading()
                               Log.d("Error",it.errorMessage.toString())
                               showToast(it.errorMessage.toString())


                           }

                           is APIState.Empty ->{
                               hideLoading()
                           }
                       }
                   }
               }





            }


        }

        //endregion

        // region DSAS Horizon Last Api. IF we got success than go toHome Page

        lifecycleScope.launch{

            repeatOnLifecycle(Lifecycle.State.CREATED){

                loginViewModel.LoginStateFlow.collect{

                    when(it){
                        is  APIState.Loading -> {

                            //displayLoadingWithText()

                        }

                        is APIState.Success -> {


                            hideLoading()
                            if(it != null){


                                showAlert("Login is Successfully...")

                                this@LoginNewActivity.finish()
                                startActivity(Intent(this@LoginNewActivity,HomeActivity::class.java))


                            }
                        }

                        is APIState.Failure -> {
                            hideLoading()
                            Log.d("LoginResp erro",it.errorMessage.toString())


                            showAlert(it.errorMessage.toString())
                        }

                        is APIState.Empty ->{

                        }
                    }
                }




            }


        }

        //endregion


    }



    //region Alert Dialog

    private fun showOTPDialogODL_LOGIC(mobNo : String) {

//        isResendOTPUpdate = false
//        var binding = LayoutLoginViaotpBinding.inflate(layoutInflater)
//
//        if (!this::alertDialogOTP.isInitialized) {
//
//
//            alertDialogOTP = AlertDialog.Builder(this, R.style.CustomDialog)
//                .setView(binding.root)
//                .create()
//
//        }
//
//        if(!alertDialogOTP.isShowing){
//
//            alertDialogOTP = AlertDialog.Builder(this, R.style.CustomDialog)
//                .setView(binding.root)
//                .create()
//
//            binding.txtResend.apply {
//                isEnabled = false
//                alpha = 0.4f   // Set alpha back to 1 (100% opacity)
//            }
//            binding.txtError.visibility = View.GONE
//            binding.txtTextDtl.text = "We have sent you One-Time Password on ${mobNo}"
//
//            //region Commented
////                binding.etOTP.addTextChangedListener(object : TextWatcher {
////                    override fun beforeTextChanged(
////                        s: CharSequence?,
////                        start: Int,
////                        count: Int,
////                        after: Int
////                    ) {
////
////                    }
////
////                    override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
////
////                        // val otpText = s.toString()
////                        binding.txtError.visibility = View.GONE
////                    }
////
////                    override fun afterTextChanged(s: Editable?) {
////                        // This method is called after the text is changed.
////                    }
////                })
//            //endregion
//
//            val edittextTextWatcher = object : TextWatcher {
//                override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {
//
//                }
//
//                override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
//
//                }
//
//                override fun afterTextChanged(s: Editable?) {
//
//                    if (s?.length ?: 0 > 0) {
//
//                        when (selectedETPosition) {
//                            0 -> {
//                                //select next edittext
//                                selectedETPosition = 1
//                                showKeyboard(binding.etOtp2)
//                                binding.etOtp1.setBackgroundResource(R.drawable.text_handle_done)
//                            }
//                            1 -> {
//                                //select next edittext
//                                selectedETPosition = 2
//                                showKeyboard(binding.etOtp3)
//                                binding.etOtp2.setBackgroundResource(R.drawable.text_handle_done)
//                            }
//                            2 -> {
//                                //select next edittext
//                                selectedETPosition = 3
//                                showKeyboard(binding.etOtp4)
//                                binding.etOtp3.setBackgroundResource(R.drawable.text_handle_done)
//
//                            }
//                            3 -> {
//                                binding.etOtp4.setBackgroundResource(R.drawable.text_handle_done)
//                                hideKeyboard(binding.etOtp4)
//                            }
//                        }
//
//                    } else {
//                        when (selectedETPosition) {
//                            3 -> {
//                                selectedETPosition = 2
//                                showKeyboard(binding.etOtp3)
//                                binding.etOtp4.setBackgroundResource(R.drawable.text_handle)
//                            }
//                            2 -> {
//                                selectedETPosition = 1
//                                showKeyboard(binding.etOtp2)
//                                binding.etOtp3.setBackgroundResource(R.drawable.text_handle)
//
//                            }
//                            1 -> {
//                                selectedETPosition = 0
//                                showKeyboard(binding.etOtp1)
//                                binding.etOtp2.setBackgroundResource(R.drawable.text_handle)
//
//                            }
//                            0 -> {
//                                binding.etOtp1.setBackgroundResource(R.drawable.text_handle)
//
//                            }
//                        }
//                    }
//                }
//            }
//
//
//            binding.etOtp1.addTextChangedListener(edittextTextWatcher)
//            binding.etOtp2.addTextChangedListener(edittextTextWatcher)
//            binding.etOtp3.addTextChangedListener(edittextTextWatcher)
//            binding.etOtp4.addTextChangedListener(edittextTextWatcher)
//
//            binding.btnSubmit.setOnClickListener {
//
//                var inputOtp = binding.etOtp1.text.toString() + binding.etOtp2.text.toString() +
//                        binding.etOtp3.text.toString() + binding.etOtp4.text.toString()
//
//
//                if (inputOtp.length == 4) {
//
//                    // Called Api
//                    cancelTimer()
//                    hideKeyboard(binding.btnSubmit)
//                    loginViewModel.otpVerifyHorizon(inputOtp)
//
//                }
//                else if(inputOtp.length == 0){
//                    binding.txtError.visibility = View.VISIBLE
//                    binding.txtError.text = "Please Enter OTP"
//                }
//
//                else {
//
//                    //region EditText error display
//                    binding.etOtp1.setBackgroundResource(R.drawable.text_handle_error)
//                    binding.etOtp2.setBackgroundResource(R.drawable.text_handle_error)
//                    binding.etOtp3.setBackgroundResource(R.drawable.text_handle_error)
//                    binding.etOtp4.setBackgroundResource(R.drawable.text_handle_error)
//
//                    binding.txtError.visibility = View.VISIBLE
//                    binding.txtError.text = "Invalid OTP Entered."
//
//                    //endregion
//
//                }
//
//
//
//
//            }
//            binding.imgClose.setOnClickListener {
//                alertDialogOTP.dismiss()
//                // Cancel the existing timer if it's running
//                cancelTimer()
//
//                binding.etOtp1.removeTextChangedListener(edittextTextWatcher)
//                binding.etOtp2.removeTextChangedListener(edittextTextWatcher)
//                binding.etOtp3.removeTextChangedListener(edittextTextWatcher)
//                binding.etOtp4.removeTextChangedListener(edittextTextWatcher)
//
//            }
//
//
//
//            binding.txtResend.setOnClickListener{
//
//
//                loginViewModel.otpResendHorizon(etLoginID.text.toString())
//
//                binding.progessBar.visibility = View.VISIBLE
//                binding.txtResend.apply {
//                    isEnabled = false
//                    alpha = 0.4f   // Set alpha back to 1 (100% opacity)
//                }
//                binding.btnSubmit.apply{
//                    isEnabled = false
//                    alpha = 0.4f
//                }
//                lifecycleScope.launch {
//
//                    //region delay for showng Loader
//                    delay(3000) // 3 seconds delay
//                    // Hide the progressBar
//                    binding.progessBar.visibility = View.GONE
//                    binding.txtResend.apply {
//                        isEnabled = true
//                        alpha = 1f   // Set alpha back to 1 (100% opacity)
//                    }
//                    binding.btnSubmit.apply{
//                        isEnabled = true
//                        alpha = 1f
//                    }
//
//                    //endregion
//
//                }
//
//                cancelTimer()
//
//
//                startTimerCountdown(binding.txtcountdownTimer, binding.txtResend)
//
//
//            }
//
//            startTimerCountdown(binding.txtcountdownTimer, binding.txtResend)
//            alertDialogOTP.show()
//            alertDialogOTP.setCancelable(false)
//
//
//        }
//



    }

    private fun showOTPDialog(mobNo : String) {

        isResendOTPUpdate = false
        var binding = LayoutLoginViaotpBinding.inflate(layoutInflater)

        alertDialogOTP = AlertDialog.Builder(this, R.style.CustomDialog)
            .setView(binding.root)
            .create()

        binding.txtResend.apply {
            isEnabled = false
            alpha = 0.4f   // Set alpha back to 1 (100% opacity)
        }
        binding.txtError.visibility = View.GONE
        binding.txtTextDtl.text = "We have sent you One-Time Password on ${mobNo}"
        binding.etOtp1.requestFocus()



        val edittextTextWatcher = object : TextWatcher {
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {

            }

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {

                binding.txtError.visibility = View.GONE
            }

            override fun afterTextChanged(s: Editable?) {

                if (s?.length ?: 0 > 0) {

                    when (selectedETPosition) {
                        0 -> {
                            //select next edittext
                            selectedETPosition = 1
                            showKeyboard(binding.etOtp2)
                            binding.etOtp1.setBackgroundResource(R.drawable.text_handle_done)
                        }

                        1 -> {
                            //select next edittext
                            selectedETPosition = 2
                            showKeyboard(binding.etOtp3)
                            binding.etOtp2.setBackgroundResource(R.drawable.text_handle_done)
                        }

                        2 -> {
                            //select next edittext
                            selectedETPosition = 3
                            showKeyboard(binding.etOtp4)
                            binding.etOtp3.setBackgroundResource(R.drawable.text_handle_done)

                        }

                        3 -> {
                            binding.etOtp4.setBackgroundResource(R.drawable.text_handle_done)
                            hideKeyboard(binding.etOtp4)
                        }
                    }

                } else {
                    when (selectedETPosition) {
                        3 -> {
                            selectedETPosition = 2
                            showKeyboard(binding.etOtp3)
                            binding.etOtp4.setBackgroundResource(R.drawable.text_handle)
                        }

                        2 -> {
                            selectedETPosition = 1
                            showKeyboard(binding.etOtp2)
                            binding.etOtp3.setBackgroundResource(R.drawable.text_handle)

                        }

                        1 -> {
                            selectedETPosition = 0
                            showKeyboard(binding.etOtp1)
                            binding.etOtp2.setBackgroundResource(R.drawable.text_handle)

                        }

                        0 -> {
                            binding.etOtp1.setBackgroundResource(R.drawable.text_handle)

                        }
                    }
                }
            }
        }


        binding.etOtp1.addTextChangedListener(edittextTextWatcher)
        binding.etOtp2.addTextChangedListener(edittextTextWatcher)
        binding.etOtp3.addTextChangedListener(edittextTextWatcher)
        binding.etOtp4.addTextChangedListener(edittextTextWatcher)

        binding.btnSubmit.setOnClickListener {

            var inputOtp = binding.etOtp1.text.toString() + binding.etOtp2.text.toString() +
                    binding.etOtp3.text.toString() + binding.etOtp4.text.toString()


            if (inputOtp.length == 4) {

                // Called Api
                cancelTimer()
                hideKeyboard(binding.btnSubmit)
                loginViewModel.otpVerifyHorizon(inputOtp)

            } else if (inputOtp.length == 0) {
                binding.txtError.visibility = View.VISIBLE
                binding.txtError.text = "Please Enter OTP"
            } else {

                //region EditText error display
                binding.etOtp1.setBackgroundResource(R.drawable.text_handle_error)
                binding.etOtp2.setBackgroundResource(R.drawable.text_handle_error)
                binding.etOtp3.setBackgroundResource(R.drawable.text_handle_error)
                binding.etOtp4.setBackgroundResource(R.drawable.text_handle_error)

                binding.txtError.visibility = View.VISIBLE
                binding.txtError.text = "Invalid OTP Entered."

                //endregion

            }


        }
        binding.imgClose.setOnClickListener {
            alertDialogOTP.dismiss()
            // Cancel the existing timer if it's running
            cancelTimer()

            binding.etOtp1.removeTextChangedListener(edittextTextWatcher)
            binding.etOtp2.removeTextChangedListener(edittextTextWatcher)
            binding.etOtp3.removeTextChangedListener(edittextTextWatcher)
            binding.etOtp4.removeTextChangedListener(edittextTextWatcher)

        }



        binding.txtResend.setOnClickListener {


            loginViewModel.otpResendHorizon(etLoginID.text.toString())

            binding.progessBar.visibility = View.VISIBLE
            binding.txtResend.apply {
                isEnabled = false
                alpha = 0.4f   // Set alpha back to 1 (100% opacity)
            }
            binding.btnSubmit.apply {
                isEnabled = false
                alpha = 0.4f
            }
            cancelTimer()

            lifecycleScope.launch {

                //region delay for showng Loader
                delay(3000) // 3 seconds delay
                // Hide the progressBar
                binding.progessBar.visibility = View.GONE
                binding.txtResend.apply {
                    isEnabled = true
                    alpha = 1f   // Set alpha back to 1 (100% opacity)
                }
                binding.btnSubmit.apply {
                    isEnabled = true
                    alpha = 1f
                }

                //endregion


            }
            startTimerCountdown(binding.txtcountdownTimer, binding.txtResend)







        }

        startTimerCountdown(binding.txtcountdownTimer, binding.txtResend)
        alertDialogOTP.show()
        alertDialogOTP.setCancelable(false)


    }

    //region Alert when Error Message is Come ...Only for Error Handling
    private fun showOTPDialog(mobNo : String,errorMsg : String = "") {

        isResendOTPUpdate = false
        var binding = LayoutLoginViaotpBinding.inflate(layoutInflater)

            alertDialogOTP = AlertDialog.Builder(this@LoginNewActivity, R.style.CustomDialogWithoutAnim)
                .setView(binding.root)
                .create()

            binding.txtResend.apply {
                isEnabled = false
                alpha = 0.4f   // Set alpha back to 1 (100% opacity)
            }

            binding.txtError.visibility = View.GONE
            binding.txtTextDtl.text = "We have sent you One-Time Password on ${mobNo}"

            if(errorMsg.isNotEmpty()){
                binding.txtError.visibility = View.VISIBLE
                binding.txtError.text = errorMsg
            }

        val edittextTextWatcher = object : TextWatcher {
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {

            }

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {

                binding.txtError.visibility = View.GONE
            }

            override fun afterTextChanged(s: Editable?) {

                if (s?.length ?: 0 > 0) {

                    when (selectedETPosition) {
                        0 -> {
                            //select next edittext
                            selectedETPosition = 1
                            showKeyboard(binding.etOtp2)
                            binding.etOtp1.setBackgroundResource(R.drawable.text_handle_done)
                        }

                        1 -> {
                            //select next edittext
                            selectedETPosition = 2
                            showKeyboard(binding.etOtp3)
                            binding.etOtp2.setBackgroundResource(R.drawable.text_handle_done)
                        }

                        2 -> {
                            //select next edittext
                            selectedETPosition = 3
                            showKeyboard(binding.etOtp4)
                            binding.etOtp3.setBackgroundResource(R.drawable.text_handle_done)

                        }

                        3 -> {
                            binding.etOtp4.setBackgroundResource(R.drawable.text_handle_done)
                            hideKeyboard(binding.etOtp4)
                        }
                    }

                } else {
                    when (selectedETPosition) {
                        3 -> {
                            selectedETPosition = 2
                            showKeyboard(binding.etOtp3)
                            binding.etOtp4.setBackgroundResource(R.drawable.text_handle)
                        }

                        2 -> {
                            selectedETPosition = 1
                            showKeyboard(binding.etOtp2)
                            binding.etOtp3.setBackgroundResource(R.drawable.text_handle)

                        }

                        1 -> {
                            selectedETPosition = 0
                            showKeyboard(binding.etOtp1)
                            binding.etOtp2.setBackgroundResource(R.drawable.text_handle)

                        }

                        0 -> {
                            binding.etOtp1.setBackgroundResource(R.drawable.text_handle)

                        }
                    }
                }
            }
        }

        binding.etOtp1.addTextChangedListener(edittextTextWatcher)
            binding.etOtp2.addTextChangedListener(edittextTextWatcher)
            binding.etOtp3.addTextChangedListener(edittextTextWatcher)
            binding.etOtp4.addTextChangedListener(edittextTextWatcher)

        binding.btnSubmit.setOnClickListener {

                if (binding.etOTP.text.isNotBlank()) {
                    cancelTimer()
                    loginViewModel.otpVerifyHorizon(binding.etOTP.text.toString())

                } else {

                    binding.txtError.visibility = View.VISIBLE
                    binding.txtError.text = "Please Enter OTP"
                }

            }
            binding.imgClose.setOnClickListener {
                alertDialogOTP.dismiss()
                // Cancel the existing timer if it's running
                cancelTimer()

                binding.etOtp1.removeTextChangedListener(edittextTextWatcher)
                binding.etOtp2.removeTextChangedListener(edittextTextWatcher)
                binding.etOtp3.removeTextChangedListener(edittextTextWatcher)
                binding.etOtp4.removeTextChangedListener(edittextTextWatcher)


            }



            binding.txtResend.setOnClickListener{


                loginViewModel.otpResendHorizon(etLoginID.text.toString())

                binding.progessBar.visibility = View.VISIBLE
                binding.txtResend.apply {
                    isEnabled = false
                    alpha = 0.4f   // Set alpha back to 1 (100% opacity)
                }
                binding.btnSubmit.apply {
                    isEnabled = false
                    alpha = 0.4f
                }
                cancelTimer()

                lifecycleScope.launch {

                    //region delay for showng Loader
                    delay(3000) // 3 seconds delay
                    // Hide the progressBar
                    binding.progessBar.visibility = View.GONE
                    binding.txtResend.apply {
                        isEnabled = true
                        alpha = 1f   // Set alpha back to 1 (100% opacity)
                    }
                    binding.btnSubmit.apply {
                        isEnabled = true
                        alpha = 1f
                    }

                    //endregion


                }
                startTimerCountdown(binding.txtcountdownTimer, binding.txtResend)

            }

            startTimerCountdown(binding.txtcountdownTimer, binding.txtResend, remainingTime = loginViewModel.remaingTime)
            alertDialogOTP.show()
            alertDialogOTP.setCancelable(false)





    }

     //endregion


    private fun showPasswordDialog(strUserID : String) {

        //var binding: LayoutLoginViapasswordBinding? = null

        var binding = LayoutLoginViapasswordBinding.inflate(layoutInflater)
         if (!this::alertDialogPassword.isInitialized) {

                alertDialogPassword = AlertDialog.Builder(this, R.style.CustomDialog)
                    .setView(binding.root)
                    .setCancelable(false)
                    .create()

            }


        if(!alertDialogPassword.isShowing) {
            this.showKeyboard(binding.etPassword)
            binding.etPassword.setText("")
            binding.imgClose.setOnClickListener {
                alertDialogPassword.dismiss()
            }
            binding.txtError.visibility = View.GONE
            binding.txtError.text = ""

            binding.btnSubmit.setOnClickListener {

                if(binding.etPassword.text.isNullOrBlank()){

                    binding.txtError.visibility = View.VISIBLE
                    binding.txtError.text = "Enter Password"
                }else {

                    alertDialogPassword.dismiss()
                    isPasswordObserving = false
                    loginViewModel.getAuthLoginHorizon(
                        strUserID.trim(),
                        binding.etPassword.text.toString()
                    )

                }


            }



            alertDialogPassword.show()
            alertDialogPassword.setCancelable(false)
        }



    }

    //endregion

    //region Not in Used
    fun openAlertViaNextButton(){

//        val checkedRadioButtonId = binding.includeLoginNew.radioGroup.checkedRadioButtonId
//
//        if (checkedRadioButtonId == -1) {
//            // No radio button is selected, display a warning message
//
//            showAlert("Please Select Login Via")
//        } else {
//
//
//            when(selectedLogin){
//
//                LoginOption.OTP -> {
//                    showOTPDialog(mobNo = "90")
//                }
//                LoginOption.Password -> {
//                    showPasswordDialog(strUserID = etLoginID.text.toString().trim())
//
//                }
//                LoginOption.NoData ->{
//
//                }
//            }
//        }
    }
    //endregion

    //endregion



    // region CountDown Timmer
    private fun startTimerCountdown(txtTimer : TextView,txtResend : TextView,  remainingTime: Long= 0L ) {

        var totalTimeInMillis : Long = 0L
        var totalMainTimeInMillis : Long =  2 * 60 * 1000L
        if(remainingTime == 0L){
             totalTimeInMillis =  2 * 60 * 1000
        }else{
             totalTimeInMillis =  remainingTime
        }
          // 2 minutes in milliseconds

        val totalResendTimes = resendTime.times(1000)  // same as  30 * 1000

        // Variable to keep track of elapsed time
        var elapsedTime = 0L
        var elapsedMainTime = 0L
        timer = object : CountDownTimer(totalTimeInMillis, 1000) {

            var blnResendOTP = false
            override fun onTick(millisUntilFinished: Long) {

                runOnUiThread {
                    val seconds = (millisUntilFinished / 1000) % 60
                    val minutes = (millisUntilFinished / (1000 * 60)) % 60
                    val formattedTime = String.format("%02d:%02d", minutes, seconds)

                    txtTimer.text = "" + formattedTime

                    // Calculate elapsed tim
                    elapsedTime = totalTimeInMillis - millisUntilFinished
                    // Update the ViewModel
                    loginViewModel.remaingTime = totalTimeInMillis - elapsedTime

                    elapsedMainTime = totalMainTimeInMillis - millisUntilFinished

                    if (!blnResendOTP) {
              // we req elapse time form Original Start Time ie 2 min hence we store in totalMainTimeInMillis and totalMainTimeInMillis
                        if (elapsedMainTime >= totalResendTimes) {
                            txtResend.apply {
                                isEnabled = true
                                alpha = 1f   // Set alpha back to 1 (100% opacity)
                            }
                            blnResendOTP = true

                        }
                    }


                }

            }

            override fun onFinish() {

                txtTimer.text = "00:00"
                if(alertDialogOTP.isShowing){
                    alertDialogOTP.dismiss()
                }


            }

        }
         timer?.start()
    }

    private fun cancelTimer() {
        timer?.cancel()

        timer = null // Set the timer to null to indicate that it's no longer active
    }

    //endregion
    override fun onDestroy() {
        super.onDestroy()
        binding.includeLoginNew.radioGroup.setOnCheckedChangeListener(null)
    }

    override fun onKeyUp(keyCode: Int, event: KeyEvent): Boolean {

        if (keyCode == KeyEvent.ACTION_DOWN) {
            return true
        } else {
            return super.onKeyUp(keyCode, event)
        }
    }


    enum class LoginOption {
        OTP,
        Password,
        NoData
    }




}