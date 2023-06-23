package com.policyboss.policybosspro.appcode

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import com.policyboss.policybosspro.APIState
import com.policyboss.policybosspro.appcode.model.repository.AppCodeRepository
import com.policyboss.policybosspro.appcode.model.viewmodel.AppCodeViewModel
import com.policyboss.policybosspro.appcode.model.viewmodel.AppCodeViewModelFactory
import com.policyboss.policybosspro.databinding.ActivityAppCodeBinding
import com.policyboss.policybosspro.utility.UTILITY
import kotlinx.coroutines.launch
import magicfinmart.datacomp.com.finmartserviceapi.database.DBPersistanceController
import magicfinmart.datacomp.com.finmartserviceapi.finmart.model.LoginResponseEntity
import magicfinmart.datacomp.com.finmartserviceapi.finmart.retrobuilder.RetroHelper

class AppCodeActivity : AppCompatActivity() {

    lateinit var binding : ActivityAppCodeBinding
    lateinit var viewModel: AppCodeViewModel

    lateinit var loginResponseEntity: LoginResponseEntity


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityAppCodeBinding.inflate(layoutInflater)
        setContentView(binding.root)

        init()
        setListner()

        if (loginResponseEntity != null) {
            if (loginResponseEntity.pospNo != null) {
                // calling API
                viewModel.getAuthToken(ss_id =loginResponseEntity.pospNo , deviceID = UTILITY.getDeviceID(this@AppCodeActivity))
            }
        }


        // displaying the response which we get from above API
        observe()

    }


    override fun onPause() {
        super.onPause()

    }

    private fun init(){


        var authRepository = AppCodeRepository( RetroHelper.api)
        var viewModelFactory = AppCodeViewModelFactory(authRepository)
        viewModel = ViewModelProvider(this,viewModelFactory).get(AppCodeViewModel::class.java)


        binding.txtOauthData.text = ""
        loginResponseEntity = DBPersistanceController(this).getUserData()

    }

      private fun setListner(){

          binding.imgClose.setOnClickListener {

              this@AppCodeActivity.finish()

          }
      }




    private fun observe(){


        lifecycleScope.launch{

            repeatOnLifecycle(Lifecycle.State.STARTED){
                //collect date from flow  Variable
                viewModel.OauthStateFlow.collect{

                    when(it){

                        is APIState.Loading ->{

                            showAnimDialog()
                        }
                        is APIState.Success ->{

                            cancelAnimDialog()

                            if(it != null){
                                it.data?.let{
                                    binding.txtOauthData.visibility = View.VISIBLE
                                    binding.txtOauthData.text = it.Token?: ""

                                }
                            }


                        }

                        is APIState.Failure -> {
                            cancelAnimDialog()
                            binding.txtOauthData.text = ""
                            binding.txtError.text = it.errorMessage
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

        binding.imgLoader.visibility = View.VISIBLE
//        Glide.with(this@OauthTokenActivity).load<Any>(R.drawable.loading_gif)
//            .asGif()
//            .crossFade()
//            .into(binding.imgLoader)

    }

    fun cancelAnimDialog(){


        binding.imgLoader.visibility = View.GONE
    }
}