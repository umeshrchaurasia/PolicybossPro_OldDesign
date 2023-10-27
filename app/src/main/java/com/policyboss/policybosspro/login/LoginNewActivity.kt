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
import android.widget.RadioButton
import android.widget.TextView
import androidx.core.widget.doOnTextChanged
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



    var selectedLogin: LoginOption = LoginOption.NoData // Default value


    private var isPasswordObserving = false
    private var isDSASObserving = false
    private var isOTPVerifyObserving = false

    private lateinit var alertDialogPassword: AlertDialog

    private lateinit var alertDialogOTP : AlertDialog




    private var timer: CountDownTimer? = null

    private var resendTime = 60      // 60 sec after resend is Launched...

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
            if(binding.includeLoginNew.etEmail.text.isNotBlank() && selectedLogin == LoginOption.OTP){

                 //05temp
                loginViewModel.getotpLoginHorizon(binding.includeLoginNew.etEmail.text.trim().toString())

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



            }else if(binding.includeLoginNew.etEmail.text.isNotBlank() && selectedLogin == LoginOption.Password){
                showPasswordDialog(strUserID = binding.includeLoginNew.etEmail.text.toString().trim())
            }
            else{
                showAlert("Please Enter User ID")
            }

        }



    }


    //region method
    private fun init(){


        setEnableNextButton(false)



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

    fun maskPhoneNumber(phoneNumber: String): String {
        if (phoneNumber.length < 10) {
            // Handle cases where the phone number is not long enough to mask
            return phoneNumber
        }

        val maskedDigits = "******"
        val lastDigits = phoneNumber.takeLast(4)
        val maskedPortion = maskedDigits + lastDigits

        return maskedPortion
    }

    //region Alert Dialog



    private fun showOTPDialog(  mobNo : String) {

        selectedETPosition = 0
        isResendOTPUpdate = false
        var bindingOTP = LayoutLoginViaotpBinding.inflate(layoutInflater)

        alertDialogOTP = AlertDialog.Builder(this, R.style.CustomDialog)
            .setView(bindingOTP.root)
            .create()

//        binding.txtResend.apply {
//            isEnabled = false
//            alpha = 0.4f   // Set alpha back to 1 (100% opacity)
//        }
        bindingOTP.txtResend.visibility = View.GONE

        bindingOTP.txtError.visibility = View.GONE
        bindingOTP.txtTextDtl.text = "We have sent you One-Time Password on ${maskPhoneNumber(mobNo)}"
        bindingOTP.etOtp1.requestFocus()

       // showKeyboard( binding.etOtp1)


        //region EditText TextWatcher
        val edittextTextWatcher = object : TextWatcher {
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {

            }

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {

                bindingOTP.txtError.visibility = View.GONE
            }

            override fun afterTextChanged(s: Editable?) {

                if (s?.length ?: 0 > 0) {

                    when (selectedETPosition) {
                        0 -> {
                            //select next edittext
                            selectedETPosition = 1
                            showKeyboard(bindingOTP.etOtp2)
                            bindingOTP.etOtp1.setBackgroundResource(R.drawable.text_handle_done)
                        }

                        1 -> {
                            //select next edittext
                            selectedETPosition = 2
                            showKeyboard(bindingOTP.etOtp3)
                            bindingOTP.etOtp2.setBackgroundResource(R.drawable.text_handle_done)
                        }

                        2 -> {
                            //select next edittext
                            selectedETPosition = 3
                            showKeyboard(bindingOTP.etOtp4)
                            bindingOTP.etOtp3.setBackgroundResource(R.drawable.text_handle_done)

                        }

                        3 -> {
                            bindingOTP.etOtp4.setBackgroundResource(R.drawable.text_handle_done)
                            hideKeyboard(bindingOTP.etOtp4)
                        }
                    }

                } else {
                    when (selectedETPosition) {
                        3 -> {
                            selectedETPosition = 2
                            showKeyboard(bindingOTP.etOtp3)
                            bindingOTP.etOtp4.setBackgroundResource(R.drawable.text_handle)
                        }

                        2 -> {
                            selectedETPosition = 1
                            showKeyboard(bindingOTP.etOtp2)
                            bindingOTP.etOtp3.setBackgroundResource(R.drawable.text_handle)

                        }

                        1 -> {
                            selectedETPosition = 0
                            showKeyboard(bindingOTP.etOtp1)
                            bindingOTP.etOtp2.setBackgroundResource(R.drawable.text_handle)

                        }

                        0 -> {
                            bindingOTP.etOtp1.setBackgroundResource(R.drawable.text_handle)

                        }
                    }
                }
            }
        }
        //endregion

        bindingOTP.etOtp1.addTextChangedListener(edittextTextWatcher)
        bindingOTP.etOtp2.addTextChangedListener(edittextTextWatcher)
        bindingOTP.etOtp3.addTextChangedListener(edittextTextWatcher)
        bindingOTP.etOtp4.addTextChangedListener(edittextTextWatcher)

        bindingOTP.btnSubmit.setOnClickListener {

            //region OTP Verification Handling
            var inputOtp = bindingOTP.etOtp1.text.toString() + bindingOTP.etOtp2.text.toString() +
                    bindingOTP.etOtp3.text.toString() + bindingOTP.etOtp4.text.toString()


            if (inputOtp.length == 4) {

                // Called Api
                cancelTimer()
                hideKeyboard(bindingOTP.btnSubmit)
                loginViewModel.otpVerifyHorizon(inputOtp)

            } else if (inputOtp.length == 0) {
                bindingOTP.txtError.visibility = View.VISIBLE
                bindingOTP.txtError.text = "Please Enter OTP"
            } else {

                //region EditText error display
                bindingOTP.etOtp1.setBackgroundResource(R.drawable.text_handle_error)
                bindingOTP.etOtp2.setBackgroundResource(R.drawable.text_handle_error)
                bindingOTP.etOtp3.setBackgroundResource(R.drawable.text_handle_error)
                bindingOTP.etOtp4.setBackgroundResource(R.drawable.text_handle_error)

                bindingOTP.txtError.visibility = View.VISIBLE
                bindingOTP.txtError.text = "Invalid OTP Entered."

                //endregion

            }

            //endregion


        }

        bindingOTP.imgClose.setOnClickListener {
            alertDialogOTP.dismiss()
            // Cancel the existing timer if it's running
            cancelTimer()

            bindingOTP.etOtp1.removeTextChangedListener(edittextTextWatcher)
            bindingOTP.etOtp2.removeTextChangedListener(edittextTextWatcher)
            bindingOTP.etOtp3.removeTextChangedListener(edittextTextWatcher)
            bindingOTP.etOtp4.removeTextChangedListener(edittextTextWatcher)

        }



        bindingOTP.txtResend.setOnClickListener {

            //region Resend OTP
            loginViewModel.otpResendHorizon(binding.includeLoginNew.etEmail.text.trim().toString())

            bindingOTP.progessBar.visibility = View.VISIBLE
//            binding.txtResend.apply {
//                isEnabled = false
//                alpha = 0.4f   // Set alpha back to 1 (100% opacity)
//            }
            bindingOTP.txtResend.visibility = View.GONE
            bindingOTP.btnSubmit.apply {
                isEnabled = false
                alpha = 0.4f
            }
            cancelTimer()

            lifecycleScope.launch {

                //region delay for showng Loader
                delay(3000) // 3 seconds delay
                // Hide the progressBar
                bindingOTP.progessBar.visibility = View.GONE
//                binding.txtResend.apply {
//                    isEnabled = true
//                    alpha = 1f   // Set alpha back to 1 (100% opacity)
//                }
                bindingOTP.txtResend.visibility = View.VISIBLE
                bindingOTP.btnSubmit.apply {
                    isEnabled = true
                    alpha = 1f
                }

                //endregion


            }
            startTimerCountdown(bindingOTP.txtcountdownTimer, bindingOTP.txtResend)

            //endregion


        }

        startTimerCountdown(bindingOTP.txtcountdownTimer, bindingOTP.txtResend)
        alertDialogOTP.show()
        alertDialogOTP.setCancelable(false)


    }

    //region Alert when Error Message is Come ...Only for Error Handling
    private fun showOTPDialog(mobNo : String,errorMsg : String = "") {

        selectedETPosition = 0
        isResendOTPUpdate = false
        var bindingOTP = LayoutLoginViaotpBinding.inflate(layoutInflater)

            alertDialogOTP = AlertDialog.Builder(this@LoginNewActivity, R.style.CustomDialogWithoutAnim)
                .setView(bindingOTP.root)
                .create()

//            binding.txtResend.apply {
//                isEnabled = false
//                alpha = 0.4f   // Set alpha back to 1 (100% opacity)
//            }
            bindingOTP.txtResend.visibility = View.GONE
            bindingOTP.txtError.visibility = View.GONE
            bindingOTP.txtTextDtl.text = "We have sent you One-Time Password on ${maskPhoneNumber(mobNo)}"
             bindingOTP.etOtp1.requestFocus()

            if(errorMsg.isNotEmpty()){
                bindingOTP.txtError.visibility = View.VISIBLE
                bindingOTP.txtError.text = errorMsg
            }

        //region EditText TextWatcher
        val edittextTextWatcher = object : TextWatcher {
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {

            }

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {

                bindingOTP.txtError.visibility = View.GONE
            }

            override fun afterTextChanged(s: Editable?) {

                if (s?.length ?: 0 > 0) {

                    when (selectedETPosition) {
                        0 -> {
                            //select next edittext
                            selectedETPosition = 1
                            showKeyboard(bindingOTP.etOtp2)
                            bindingOTP.etOtp1.setBackgroundResource(R.drawable.text_handle_done)
                        }

                        1 -> {
                            //select next edittext
                            selectedETPosition = 2
                            showKeyboard(bindingOTP.etOtp3)
                            bindingOTP.etOtp2.setBackgroundResource(R.drawable.text_handle_done)
                        }

                        2 -> {
                            //select next edittext
                            selectedETPosition = 3
                            showKeyboard(bindingOTP.etOtp4)
                            bindingOTP.etOtp3.setBackgroundResource(R.drawable.text_handle_done)

                        }

                        3 -> {
                            bindingOTP.etOtp4.setBackgroundResource(R.drawable.text_handle_done)
                            hideKeyboard(bindingOTP.etOtp4)
                        }
                    }

                } else {
                    when (selectedETPosition) {
                        3 -> {
                            selectedETPosition = 2
                            showKeyboard(bindingOTP.etOtp3)
                            bindingOTP.etOtp4.setBackgroundResource(R.drawable.text_handle)
                        }

                        2 -> {
                            selectedETPosition = 1
                            showKeyboard(bindingOTP.etOtp2)
                            bindingOTP.etOtp3.setBackgroundResource(R.drawable.text_handle)

                        }

                        1 -> {
                            selectedETPosition = 0
                            showKeyboard(bindingOTP.etOtp1)
                            bindingOTP.etOtp2.setBackgroundResource(R.drawable.text_handle)

                        }

                        0 -> {
                            bindingOTP.etOtp1.setBackgroundResource(R.drawable.text_handle)

                        }
                    }
                }
            }
        }
        //endregion

            bindingOTP.etOtp1.addTextChangedListener(edittextTextWatcher)
            bindingOTP.etOtp2.addTextChangedListener(edittextTextWatcher)
            bindingOTP.etOtp3.addTextChangedListener(edittextTextWatcher)
            bindingOTP.etOtp4.addTextChangedListener(edittextTextWatcher)

        bindingOTP.btnSubmit.setOnClickListener {

               //region OTP Verification Handling
            var inputOtp = bindingOTP.etOtp1.text.toString() + bindingOTP.etOtp2.text.toString() +
                    bindingOTP.etOtp3.text.toString() + bindingOTP.etOtp4.text.toString()


            if (inputOtp.length == 4) {

                // Called Api
                cancelTimer()
                hideKeyboard(bindingOTP.btnSubmit)
                loginViewModel.otpVerifyHorizon(inputOtp)

            } else if (inputOtp.length == 0) {
                bindingOTP.txtError.visibility = View.VISIBLE
                bindingOTP.txtError.text = "Please Enter OTP"
            } else {

                //region EditText error display
                bindingOTP.etOtp1.setBackgroundResource(R.drawable.text_handle_error)
                bindingOTP.etOtp2.setBackgroundResource(R.drawable.text_handle_error)
                bindingOTP.etOtp3.setBackgroundResource(R.drawable.text_handle_error)
                bindingOTP.etOtp4.setBackgroundResource(R.drawable.text_handle_error)

                bindingOTP.txtError.visibility = View.VISIBLE
                bindingOTP.txtError.text = "Invalid OTP Entered."

                //endregion

            }

            //endregion

            }
            bindingOTP.imgClose.setOnClickListener {
                alertDialogOTP.dismiss()
                // Cancel the existing timer if it's running
                cancelTimer()

                bindingOTP.etOtp1.removeTextChangedListener(edittextTextWatcher)
                bindingOTP.etOtp2.removeTextChangedListener(edittextTextWatcher)
                bindingOTP.etOtp3.removeTextChangedListener(edittextTextWatcher)
                bindingOTP.etOtp4.removeTextChangedListener(edittextTextWatcher)


            }



            bindingOTP.txtResend.setOnClickListener{

                loginViewModel.otpResendHorizon(binding.includeLoginNew.etEmail.text.trim().toString())

                bindingOTP.progessBar.visibility = View.VISIBLE
//                binding.txtResend.apply {
//                    isEnabled = false
//                    alpha = 0.4f   // Set alpha back to 1 (100% opacity)
//                }
                bindingOTP.txtResend.visibility = View.GONE
                bindingOTP.btnSubmit.apply {
                    isEnabled = false
                    alpha = 0.4f
                }
                cancelTimer()

                lifecycleScope.launch {

                    //region delay for showng Loader
                    delay(3000) // 3 seconds delay
                    // Hide the progressBar
                    bindingOTP.progessBar.visibility = View.GONE
//                    binding.txtResend.apply {
//                        isEnabled = true
//                        alpha = 1f   // Set alpha back to 1 (100% opacity)
//                    }
                    bindingOTP.txtResend.visibility = View.VISIBLE
                    bindingOTP.btnSubmit.apply {
                        isEnabled = true
                        alpha = 1f
                    }

                    //endregion


                }
                startTimerCountdown(bindingOTP.txtcountdownTimer, bindingOTP.txtResend)

            }

            startTimerCountdown(bindingOTP.txtcountdownTimer, bindingOTP.txtResend, remainingTime = loginViewModel.remaingTime)
            alertDialogOTP.show()
            alertDialogOTP.setCancelable(false)





    }

     //endregion


    private fun showPasswordDialog(strUserID : String) {

        //var binding: LayoutLoginViapasswordBinding? = null

        var bindingPassword = LayoutLoginViapasswordBinding.inflate(layoutInflater)

        alertDialogPassword = AlertDialog.Builder(this, R.style.CustomDialog)
            .setView(bindingPassword.root)
            .setCancelable(false)
            .create()

        this.showKeyboard(bindingPassword.etPassword)
        bindingPassword.etPassword.setText("")
        bindingPassword.imgClose.setOnClickListener {
            alertDialogPassword.dismiss()
        }
        bindingPassword.txtError.visibility = View.GONE
        bindingPassword.txtError.text = ""

        bindingPassword.etPassword.doOnTextChanged { text, start, before, count ->

            if(text!!.length >0){
                bindingPassword.txtError.visibility = View.GONE
                bindingPassword.txtError.text = ""
            }
        }
        bindingPassword.btnSubmit.setOnClickListener {

            if (bindingPassword.etPassword.text.isNullOrBlank()) {

                bindingPassword.txtError.visibility = View.VISIBLE
                bindingPassword.txtError.text = "Enter Password"
            } else {

                alertDialogPassword.dismiss()
                isPasswordObserving = false
                loginViewModel.getAuthLoginHorizon(
                    binding.includeLoginNew.etEmail.text.trim().toString(),
                    bindingPassword.etPassword.text.toString()
                )

            }


        }



        alertDialogPassword.show()
        alertDialogPassword.setCancelable(false)


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
//                            txtResend.apply {
//                                isEnabled = true
//                                alpha = 1f   // Set alpha back to 1 (100% opacity)
//                            }
                            txtResend.visibility = View.VISIBLE


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

        if (keyCode == KeyEvent.KEYCODE_BACK) {
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