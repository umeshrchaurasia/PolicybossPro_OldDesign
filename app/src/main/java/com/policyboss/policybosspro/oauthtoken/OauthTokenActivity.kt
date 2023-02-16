package com.policyboss.policybosspro.oauthtoken

import android.app.Dialog
import android.graphics.drawable.ColorDrawable
import android.opengl.Visibility
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import com.bumptech.glide.Glide
import com.policyboss.policybosspro.APIState
import com.policyboss.policybosspro.R
import com.policyboss.policybosspro.databinding.ActivityOauthTokenBinding
import com.policyboss.policybosspro.databinding.DialogLoadingBinding
import com.policyboss.policybosspro.oauthtoken.model.OauthTokenRepository
import com.policyboss.policybosspro.oauthtoken.model.OauthTokenViewModel
import com.policyboss.policybosspro.oauthtoken.model.OauthTokenViewModelFactory
import com.policyboss.policybosspro.utility.UTILITY
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch
import magicfinmart.datacomp.com.finmartserviceapi.Utility
import magicfinmart.datacomp.com.finmartserviceapi.finmart.retrobuilder.RetroHelper

class OauthTokenActivity : AppCompatActivity() {

    lateinit var binding : ActivityOauthTokenBinding
    lateinit var viewModel: OauthTokenViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityOauthTokenBinding.inflate(layoutInflater)
        setContentView(binding.root)

        init()
        setListner()

        // calling API
        viewModel.getAuthToken(ss_id = "0", deviceID = UTILITY.getDeviceID(this@OauthTokenActivity))

        // displaying the response which we get from above API
        observe()

    }

    private fun init(){


        var authRepository = OauthTokenRepository( RetroHelper.api)
        var viewModelFactory = OauthTokenViewModelFactory(authRepository)
        viewModel = ViewModelProvider(this,viewModelFactory).get(OauthTokenViewModel::class.java)


    }

      private fun setListner(){

          binding.imgClose.setOnClickListener {

              this@OauthTokenActivity.finish()

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

                            it.data?.let{
                                binding.txtOauthData.visibility = View.VISIBLE
                                binding.txtOauthData.text = it.Token?: ""

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