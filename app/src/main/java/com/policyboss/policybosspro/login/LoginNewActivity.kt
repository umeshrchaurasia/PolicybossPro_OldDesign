package com.policyboss.policybosspro.login

import android.app.AlertDialog
import android.content.DialogInterface
import android.content.Intent
import android.content.pm.PackageManager
import android.os.Build
import android.os.Build.VERSION
import android.os.Bundle
import android.os.CountDownTimer
import android.text.Editable
import android.text.TextWatcher
import android.util.Log
import android.view.View
import android.view.View.OnClickListener
import android.widget.Button
import android.widget.EditText
import android.widget.RadioButton
import android.widget.TextView
import androidx.core.app.ActivityCompat
import androidx.core.widget.doOnTextChanged
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import com.google.android.material.snackbar.Snackbar
import com.policyboss.policybosspro.APIState
import com.policyboss.policybosspro.BaseKotlinActivity
import com.policyboss.policybosspro.BuildConfig
import com.policyboss.policybosspro.R
import com.policyboss.policybosspro.analytics.WebEngageAnalytics
import com.policyboss.policybosspro.databinding.ActivityLoginNewBinding
import com.policyboss.policybosspro.databinding.LayoutLoginViaotpBinding
import com.policyboss.policybosspro.databinding.LayoutLoginViapasswordBinding
import com.policyboss.policybosspro.helpfeedback.raiseticketDialog.RaiseTicketDialogActivity
import com.policyboss.policybosspro.hideKeyboard
import com.policyboss.policybosspro.home.HomeActivity
import com.policyboss.policybosspro.login.model.Repository.LoginNewRepository
import com.policyboss.policybosspro.login.model.Repository.LoginNewViewModelFactory
import com.policyboss.policybosspro.login.model.viewmodel.LoginViewModel
import com.policyboss.policybosspro.register.RegisterActivity
import com.policyboss.policybosspro.showAlert
import com.policyboss.policybosspro.showKeyboard
import com.policyboss.policybosspro.utility.Constants
import com.policyboss.policybosspro.utility.NetworkUtils.Companion.isNetworkAvailable
import com.policyboss.policybosspro.utility.ValidationUtil
import com.policyboss.policybosspro.utility.showToast
import com.policyboss.policybosspro.webviews.PrivacyWebViewActivity
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import magicfinmart.datacomp.com.finmartserviceapi.LoginPrefManager
import magicfinmart.datacomp.com.finmartserviceapi.PrefManager
import magicfinmart.datacomp.com.finmartserviceapi.Utility
import magicfinmart.datacomp.com.finmartserviceapi.database.DBPersistanceController
import magicfinmart.datacomp.com.finmartserviceapi.finmart.retrobuilder.RetroHelper

class LoginNewActivity : BaseKotlinActivity(), OnClickListener {

    lateinit var binding:ActivityLoginNewBinding

    //region Declaration
    lateinit var  loginViewModel: LoginViewModel

    lateinit var loginPrefManager : LoginPrefManager
    lateinit var prefManager: PrefManager


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

    //   User weUser;
    var enable_pro_signupurl = ""

    var perms = arrayOf(
        "android.permission.CAMERA",
        "android.permission.WRITE_EXTERNAL_STORAGE",
        "android.permission.READ_EXTERNAL_STORAGE",
        "android.permission.READ_CONTACTS",
        "android.permission.READ_CALL_LOG",
        "android.permission.POST_NOTIFICATIONS",
        "android.permission.READ_MEDIA_IMAGES"
    )

    //endregion

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityLoginNewBinding.inflate(layoutInflater)
        setContentView(binding.root)


        //region OnCreate Content
        //Default KeyBoard PopUp when EditText
       // this.window?.setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_ALWAYS_VISIBLE)

        init()

        setListener()

        radioButtonListner()

        // displaying the response which we get from above API
         observe()

        if (!checkPermission()) {
            requestPermission()
        }

        if (!isNetworkAvailable(this)) {
            Snackbar.make(binding.root, getString(R.string.noInternet), Snackbar.LENGTH_SHORT).show()
            return
        }else{
        // Verify SignUp User
        loginViewModel.getusersignup(appVersion = prefManager.appVersion,
            deviceCode = prefManager.deviceID
            )
        }

        //endregion

    }

    // region method

    //region initialization
    private fun init(){


        setEnableNextButton(false)



        loginPrefManager = LoginPrefManager(this@LoginNewActivity)
        prefManager = PrefManager(this@LoginNewActivity)

        //region set Repository and VieModel
        var loginRepository = LoginNewRepository(RetroHelper.api)

        var  viewModelFactory = LoginNewViewModelFactory(loginRepository, loginPrefManager)

         loginViewModel = ViewModelProvider(this,viewModelFactory).get(LoginViewModel ::class.java)

        //endregion

        //   weUser = WebEngage.get().user();

       // clear UserConstant Entity....
        DBPersistanceController(this).clearUserData()
        prefManager.deviceID = Utility.getDeviceId(this@LoginNewActivity.getApplicationContext())

        prefManager.appVersion = "policyboss-" + BuildConfig.VERSION_NAME

    }

    private fun setListener() {

        binding.includeLoginNew.btnNext.setOnClickListener(this)
        binding.includeLoginNew.tvSignUp.setOnClickListener(this)
        binding.includeLoginNew.btnSignIn.setOnClickListener(this)
        binding.includeLoginNew.tvForgotPass.setOnClickListener(this)
        binding.includeLoginNew.lyRaiseTicket.setOnClickListener(this)
        binding.includeLoginNew.txtterm.setOnClickListener(this)
        binding.includeLoginNew.txtprivacy.setOnClickListener(this)
    }

    //endregion

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

    //region Alert when Error Message is Come ...Only for Wrong OTP handling. ie when Otp Open again
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


    private fun dialogForgotPassword() {
        val builder = AlertDialog.Builder(this@LoginNewActivity)
        builder.setCancelable(true)
        // builder.setTitle("FORGOT PASSWORD");

        val view = this.layoutInflater.inflate(R.layout.layout_forgot_password, null)
        builder.setView(view)
        val dialog = builder.create()
        dialog.show()
        val etEmail = view.findViewById<View>(R.id.etEmail) as EditText
        val btnReset = view.findViewById<View>(R.id.btnReset) as Button

        btnReset.setOnClickListener {
            if (!ValidationUtil.isValidEmailID(etEmail)) {
                etEmail.error = "Invalid Email ID"
                etEmail.isFocusable = true
                //return;
            } else {
                dialog.dismiss()

                //05 temp pending
                displayLoadingWithText(text = "Retrieving password...")
               // LoginController(this@LoginActivity)
                //    .forgotPassword(etEmail.text.toString(), this@LoginActivity)
               loginViewModel.forgotPassword(emailID = etEmail.text.toString(),
                                             appVersion = prefManager.appVersion,
                                              deviceCode = prefManager.deviceID )
            }
        }
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

        bindingPassword.tilPwd.hint = ""

        bindingPassword.etPassword.doOnTextChanged { text, start, before, count ->

            if(text!!.length >0){
                bindingPassword.txtError.visibility = View.GONE
                bindingPassword.txtError.text = ""
                bindingPassword.etPassword.setBackgroundResource(R.drawable.rect_lightgray_shape)
            }
        }
        bindingPassword.btnSubmit.setOnClickListener {

            if (bindingPassword.etPassword.text.isNullOrBlank()) {

                bindingPassword.txtError.visibility = View.VISIBLE
                bindingPassword.txtError.text = "Enter Password"

                bindingPassword.etPassword.setBackgroundResource(R.drawable.rect_error_shape)
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

    //region Observation OF Api using Flow
    private fun observe() {

        //region  is UserSignUp
        lifecycleScope.launch {

            repeatOnLifecycle(Lifecycle.State.CREATED) {

                loginViewModel.getsignUpStateFlow.collect {

                    when (it) {
                        is APIState.Loading -> {
                            // showAnimDialog()
                            displayLoadingWithText()

                        }

                        is APIState.Success -> {


                            hideLoading()
                            if (it != null) {

                                //pospurl

                                enable_pro_signupurl = it.data?.MasterData?.get(0)?.enable_pro_pospurl?: ""
                                prefManager.enableProPOSPurl = enable_pro_signupurl

                                //add sub user

                                //add sub user
                                val getenable_pro_Addsubuser_url = it.data?.MasterData?.get(0)?.enable_pro_Addsubuser_url?: ""
                                prefManager.enablePro_ADDSUBUSERurl = getenable_pro_Addsubuser_url

                            }
                        }

                        is APIState.Failure -> {
                            hideLoading()


                        }

                        is APIState.Empty -> {
                            hideLoading()
                        }
                    }

                }


            }


        }
        //endregion

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

        //region  Forgot Password
        lifecycleScope.launch {

            repeatOnLifecycle(Lifecycle.State.CREATED) {

                loginViewModel.forgotPasswordStateFlow.collect {

                    when (it) {
                        is APIState.Loading -> {
                            // showAnimDialog()
                            displayLoadingWithText()

                        }

                        is APIState.Success -> {


                            hideLoading()
                            showAlert(it.data?.message?:"Email has been sent on your registered Email address")
                        }

                        is APIState.Failure -> {
                            hideLoading()


                        }

                        is APIState.Empty -> {
                            hideLoading()
                        }
                    }

                }


            }


        }
        //endregion
    }

    //endregion

    //region permission
    private fun checkPermission(): Boolean {
        val camera = ActivityCompat.checkSelfPermission(applicationContext, perms[0])
        val WRITE_EXTERNAL = ActivityCompat.checkSelfPermission(applicationContext, perms[1])
        val READ_EXTERNAL = ActivityCompat.checkSelfPermission(applicationContext, perms[2])
        val READ_CONTACTS = ActivityCompat.checkSelfPermission(applicationContext, perms[3])
        val READ_CALL_LOG = ActivityCompat.checkSelfPermission(applicationContext, perms[4])
        val POST_NOTIFICATION = ActivityCompat.checkSelfPermission(applicationContext, perms[5])
        val READ_MEDIA_IMAGE = ActivityCompat.checkSelfPermission(applicationContext, perms[6])
        return if (VERSION.SDK_INT >= Build.VERSION_CODES.TIRAMISU) {
            camera == PackageManager.PERMISSION_GRANTED && READ_MEDIA_IMAGE == PackageManager.PERMISSION_GRANTED && POST_NOTIFICATION == PackageManager.PERMISSION_GRANTED
        } else if (VERSION.SDK_INT >= Build.VERSION_CODES.Q) {
            camera == PackageManager.PERMISSION_GRANTED && READ_EXTERNAL == PackageManager.PERMISSION_GRANTED && POST_NOTIFICATION == PackageManager.PERMISSION_GRANTED
        } else {
            camera == PackageManager.PERMISSION_GRANTED && WRITE_EXTERNAL == PackageManager.PERMISSION_GRANTED && READ_EXTERNAL == PackageManager.PERMISSION_GRANTED && READ_CONTACTS == PackageManager.PERMISSION_GRANTED && READ_CALL_LOG == PackageManager.PERMISSION_GRANTED
        }
    }

    private fun checkRationale() {
        if (checkRationalePermission()) {
            //Show Information about why you need the permission
            requestPermission()
        } else {

        }
    }

    private fun checkRationalePermission(): Boolean {
        val camera =
            ActivityCompat.shouldShowRequestPermissionRationale(this@LoginNewActivity, perms[0])
        val write_external = ActivityCompat.shouldShowRequestPermissionRationale(
            this@LoginNewActivity,
            perms[1]
        )
        val read_external = ActivityCompat.shouldShowRequestPermissionRationale(
            this@LoginNewActivity,
            perms[2]
        )
        val read_contacts = ActivityCompat.shouldShowRequestPermissionRationale(
            this@LoginNewActivity,
            perms[3]
        )
        val read_call_log = ActivityCompat.shouldShowRequestPermissionRationale(
            this@LoginNewActivity,
            perms[4]
        )
        val read_media_image = ActivityCompat.shouldShowRequestPermissionRationale(
            this@LoginNewActivity,
            perms[6]
        )

        // boolean minSdk29 = Build.VERSION.SDK_INT >= Build.VERSION_CODES.Q;
        return if (VERSION.SDK_INT >= Build.VERSION_CODES.TIRAMISU) {
            camera || read_media_image || read_contacts || read_call_log
        } else if (VERSION.SDK_INT >= Build.VERSION_CODES.Q) {
            camera || read_external || read_contacts || read_call_log
        } else {
            camera || write_external || read_external || read_contacts || read_call_log
        }
    }


    private fun requestPermission() {
        ActivityCompat.requestPermissions(
            this,
            perms,
            Constants.PERMISSION_CAMERA_STORACGE_CONSTANT
        )
    }




    private fun showMessageOKCancel(message: String, okListener: DialogInterface.OnClickListener) {
        AlertDialog.Builder(this@LoginNewActivity, R.style.AlertDialog_Theme)
            .setCancelable(false)
            .setTitle("Retry")
            .setMessage(message)
            .setPositiveButton("OK", okListener) //.setNegativeButton("Cancel", null)
            .create()
            .show()
    }

    //endregion

    //region Event
    override fun onClick(view: View?) {


        when(view?.id){

            binding.includeLoginNew.tvForgotPass.id ->{
                dialogForgotPassword()
            }

            binding.includeLoginNew.btnNext.id ->{
                hideKeyboard(binding.root)

                if (!isNetworkAvailable(this)) {
                    Snackbar.make(view, getString(R.string.noInternet), Snackbar.LENGTH_SHORT).show()
                    return
                }else{

                    if(binding.includeLoginNew.etEmail.text.isNotBlank() && selectedLogin == LoginOption.OTP){
                        loginViewModel.getotpLoginHorizon(binding.includeLoginNew.etEmail.text.trim().toString())

                    }
                    else if(binding.includeLoginNew.etEmail.text.isNotBlank() && selectedLogin == LoginOption.Password){
                        showPasswordDialog(strUserID = binding.includeLoginNew.etEmail.text.toString().trim())
                    }
                    else{
                        showAlert("Please Enter User ID")
                    }

                    //region Comented for testing purpose
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
                    //endregion
                }

            }

            binding.includeLoginNew.tvSignUp.id ->{

                if (!isNetworkAvailable(this)) {
                    Snackbar.make(view, getString(R.string.noInternet), Snackbar.LENGTH_SHORT)
                        .show()
                    return
                }

                if (enable_pro_signupurl != null) {
                    if (enable_pro_signupurl.isEmpty()) {
                        startActivity(Intent(this, RegisterActivity::class.java))
                    } else {
                        val signupurl: String =
                            enable_pro_signupurl + "&app_version=" + prefManager.getAppVersion() + "&device_code=" + prefManager.getDeviceID() + "&ssid=&fbaid="
                        Utility.loadWebViewUrlInBrowser(this@LoginNewActivity, signupurl)
                    }
                } else {
                    startActivity(Intent(this, RegisterActivity::class.java))
                }


                trackEvent("")
            }

            binding.includeLoginNew.lyRaiseTicket.id ->{

           val url =
                    "https://origin-cdnh.policyboss.com/fmweb/Ticketing/ticket_login.html?landing_page=login_page&app_version=" + prefManager.appVersion + "&device_code=" + prefManager.deviceID + "&ssid=&fbaid="
                Log.d("URL", "Raise Ticket URL: $url")


                startActivity(
                    Intent(this, RaiseTicketDialogActivity::class.java)
                        .putExtra("URL", url)
                )
            }

            binding.includeLoginNew.txtprivacy.id ->{

                startActivity(
                    Intent(this, PrivacyWebViewActivity::class.java)
                        .putExtra(
                            "URL",
                            "https://www.policyboss.com/privacy-policy-policyboss-pro?app_version=" + prefManager.appVersion + "&device_code=" + prefManager.deviceID + "&ssid=&fbaid="
                        )
                        .putExtra("NAME", "" + "privacy-policy")
                        .putExtra("TITLE", "" + "privacy-policy")
                )

            }

            binding.includeLoginNew.txtterm.id ->{

                startActivity(
                    Intent(this, PrivacyWebViewActivity::class.java)
                        .putExtra(
                            "URL",
                            "https://www.policyboss.com/terms-condition?app_version=" + prefManager.appVersion + "&device_code=" + prefManager.deviceID + "&ssid=&fbaid="
                        )
                        .putExtra("NAME", "" + "Terms & Conditions")
                        .putExtra("TITLE", "" + "Terms & Conditions")
                )

            }


        }
    }
    override fun onDestroy() {
        super.onDestroy()
        binding.includeLoginNew.radioGroup.setOnCheckedChangeListener(null)
    }

    //endregion

    //region Other
    private fun trackEvent(status: String) {
        // Create event attributes
        val eventAttributes: MutableMap<String, Any> = HashMap()
        eventAttributes["Sign"] = status // Add any relevant attributes

        // Track the login event using WebEngageHelper
        WebEngageAnalytics.getInstance().trackEvent("Sign Up Initiated", eventAttributes)
    }

    //region comment
//    override fun onKeyUp(keyCode: Int, event: KeyEvent): Boolean {
//
//        if (keyCode == KeyEvent.KEYCODE_BACK) {
//            return true
//        } else {
//            return super.onKeyUp(keyCode, event)
//        }
//    }

    //endregion
    enum class LoginOption {
        OTP,
        Password,
        NoData
    }

    //endregion




}