package com.policyboss.policybosspro.login.model.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.policyboss.policybosspro.APIState
import magicfinmart.datacomp.com.finmartserviceapi.LoginPrefManager
import com.policyboss.policybosspro.login.model.Repository.LoginNewRepository
import com.policyboss.policybosspro.utility.UTILITY
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.launch
import magicfinmart.datacomp.com.finmartserviceapi.finmart.response.LoginNew.LoginNewResponse_DSAS_Horizon

class LoginViewModel( private val loginNewRepository: LoginNewRepository,
                      private val loginPrefManager: LoginPrefManager
): ViewModel() {


    private  var loginMutuableStateFlow : MutableStateFlow<APIState<LoginNewResponse_DSAS_Horizon>> = MutableStateFlow(APIState.Empty())

    val LoginStateFlow : StateFlow<APIState<LoginNewResponse_DSAS_Horizon>>
        get() = loginMutuableStateFlow

    fun  getLoginDetailHorizon(ss_id : String) = viewModelScope.launch {

//        var body =HashMap<String,String>()
//        body.put("ss_id",ss_id)

        loginMutuableStateFlow.value = APIState.Loading()

        try {

            loginNewRepository.getLoginHorizonDetails(ss_id)
                .catch {
                    loginMutuableStateFlow.value = APIState.Failure(errorMessage = it.message.toString())
                }.collect{  data ->
                    if (data.isSuccessful){
                        if(data.body()?.status?.uppercase().equals("SUCCESS"))
                        {
                            loginPrefManager.saveLoginHorizonResponse(data.body())
                            loginMutuableStateFlow.value = APIState.Success(data = data.body())
                        }
                        else{
                            loginMutuableStateFlow.value = APIState.Failure(errorMessage ="No Data Found")
                        }
                    }
                    else
                    {
                        loginMutuableStateFlow.value = APIState.Failure(errorMessage ="No Data Found")
                    }
                }


        }catch (ex : Exception){

            loginMutuableStateFlow.value = APIState.Failure(errorMessage = UTILITY.ErrorMessage)
        }

    }

}

