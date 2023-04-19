package com.policyboss.policybosspro.attendance.viewmodel


import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.policyboss.policybosspro.APIState
import com.policyboss.policybosspro.attendance.pbAttendanceRepository
import com.policyboss.policybosspro.oauthtoken.model.repository.OauthTokenRepository
import com.policyboss.policybosspro.utility.UTILITY
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.launch
import magicfinmart.datacomp.com.finmartserviceapi.finmart.requestentity.pbAttendance.pbAttendRequestEntity
import magicfinmart.datacomp.com.finmartserviceapi.finmart.response.AuthToken.OauthTokenResponse
import magicfinmart.datacomp.com.finmartserviceapi.finmart.response.PbAttendance.PbAttendanceResponse
import magicfinmart.datacomp.com.finmartserviceapi.finmart.response.PbAttendance.pbAttendResponse

class pbAttendanceViewModel (val pbRepository: pbAttendanceRepository) : ViewModel(){

    private var attendMutuableStateFlow : MutableStateFlow<APIState<pbAttendResponse>> = MutableStateFlow(
        APIState.Empty())

    // data is collected in OauthStateFlow variable, we have to get from here
    val attendStateFlow : StateFlow<APIState<pbAttendResponse>>
        get() = attendMutuableStateFlow


    fun getAttendance(url: String, pbAttendRequestEntity: pbAttendRequestEntity) = viewModelScope.launch {


        attendMutuableStateFlow.value = APIState.Loading()
        // delay(8000)
        try {

            pbRepository.getAttendance(url,pbAttendRequestEntity)
                .catch {

                }.collect{ data ->

                    if(data.isSuccessful){


                        if(data.body()?.Status?.uppercase().equals("SUCCESS")){
                            attendMutuableStateFlow.value = APIState.Success(data = data.body())
                        }else{
                            attendMutuableStateFlow.value = APIState.Failure(errorMessage = data.body()?.message ?: UTILITY.ErrorMessage)
                        }

                    }else{
                        attendMutuableStateFlow.value = APIState.Failure(errorMessage = UTILITY.ErrorMessage)
                    }

                }
        }catch (ex : Exception){

            attendMutuableStateFlow.value = APIState.Failure(errorMessage = UTILITY.ErrorMessage)

        }
    }


}