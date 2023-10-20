package com.policyboss.policybosspro.login

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import com.policyboss.policybosspro.APIState
import com.policyboss.policybosspro.databinding.ActivityLoginNewBinding
import com.policyboss.policybosspro.login.model.Repository.LoginNewRepository
import com.policyboss.policybosspro.login.model.Repository.LoginNewViewModelFactory
import com.policyboss.policybosspro.login.model.viewmodel.LoginViewModel
import com.policyboss.policybosspro.utility.showToast
import kotlinx.coroutines.launch
import magicfinmart.datacomp.com.finmartserviceapi.LoginPrefManager
import magicfinmart.datacomp.com.finmartserviceapi.finmart.retrobuilder.RetroHelper

class LoginNewActivity : AppCompatActivity() {

    lateinit var binding:ActivityLoginNewBinding

  // private val loginViewModel by viewModels<LoginViewModel>()
  //  lateinit var loginViewModel: LoginViewModel

    lateinit var  loginViewModel: LoginViewModel

    lateinit var prefManager : LoginPrefManager

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityLoginNewBinding.inflate(layoutInflater)
        setContentView(binding.root)


        init()

        // displaying the response which we get from above API
        observe()

        binding.includeLogin.btnSignIn.setOnClickListener {

            loginViewModel.getLoginDetailHorizon(ss_id="124970")
        }
    }


    private fun init(){

        prefManager = LoginPrefManager(this@LoginNewActivity)
        var loginRepository = LoginNewRepository(RetroHelper.api)

        var  viewModelFactory = LoginNewViewModelFactory(loginRepository, prefManager)

      loginViewModel = ViewModelProvider(this,viewModelFactory).get(LoginViewModel ::class.java)


    }
    private fun observe() {

        lifecycleScope.launch{

            repeatOnLifecycle(Lifecycle.State.STARTED){

                loginViewModel.LoginStateFlow.collect{

                    when(it){
                        is  APIState.Loading -> {
                            showAnimDialog()
                            showToast("Loading...")
                        }

                        is APIState.Success -> {


                            cancelAnimDialog()
                            if(it != null){
                                showToast(it.data?.status.toString())

                               // var response = it.data
                                Log.d("LoginResp POSP No",
                                    prefManager.getSSID()
                                )
                                Log.d("LoginResp emp name",(prefManager.getEmpData()?.Alternate_Number ?: "").toString())
                            }
                        }

                        is APIState.Failure -> {
                            cancelAnimDialog()
                            Log.d("LoginResp erro",it.errorMessage.toString())

                        }

                        is APIState.Empty ->{
                            cancelAnimDialog()
                        }
                    }
                }
            }
        }
    }

    fun showAnimDialog(){


//        Glide.with(this@OauthTokenActivity).load<Any>(R.drawable.loading_gif)
//            .asGif()
//            .crossFade()
//            .into(binding.imgLoader)

    }

    fun cancelAnimDialog(){


//        binding.imgLoader.visibility = View.GONE
    }
}