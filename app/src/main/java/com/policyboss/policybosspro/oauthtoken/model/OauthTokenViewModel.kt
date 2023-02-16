package com.policyboss.policybosspro.oauthtoken.model

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.policyboss.policybosspro.APIState
import com.policyboss.policybosspro.utility.UTILITY
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch
import magicfinmart.datacomp.com.finmartserviceapi.finmart.response.AuthToken.OauthTokenResponse

class OauthTokenViewModel(val oauthTokenRepository: OauthTokenRepository) : ViewModel(){


    private val oauthMutuableStateFlow : MutableStateFlow<APIState<OauthTokenResponse>> = MutableStateFlow(APIState.Empty())

    // data is collected in OauthStateFlow variable, we have to get from here
    val OauthStateFlow : StateFlow<APIState<OauthTokenResponse>>
    get() = oauthMutuableStateFlow


    fun getAuthToken(ss_id : String) = viewModelScope.launch {


        var body = HashMap<String,String>()
        body.put("ss_id",ss_id)

        oauthMutuableStateFlow.value = APIState.Loading()
       // delay(8000)
        try {

            oauthTokenRepository.getAuthToken(body)
                .catch {

                }.collect{ data ->

                    if(data.isSuccessful){

                        oauthMutuableStateFlow.value = APIState.Success(data = data.body())
                    }else{
                        oauthMutuableStateFlow.value = APIState.Failure(errorMessage = UTILITY.ErrorMessage)
                    }

                }
        }catch (ex : Exception){

            oauthMutuableStateFlow.value = APIState.Failure(errorMessage = UTILITY.ErrorMessage)

        }
    }


}