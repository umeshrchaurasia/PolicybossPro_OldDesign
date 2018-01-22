package magicfinmart.datacomp.com.finmartserviceapi.finmart.controller.register;


import magicfinmart.datacomp.com.finmartserviceapi.finmart.IResponseSubcriber;
import magicfinmart.datacomp.com.finmartserviceapi.finmart.requestentity.RegisterRequestEntity;

/**
 * Created by Rajeev Ranjan on 22/01/2018.
 */

public interface IRegister {
    void generateOtp(String MobileNo, IResponseSubcriber iResponseSubcriber);

    void validateOtp(String MobileNo, String MobileOTP, IResponseSubcriber iResponseSubcriber);


    void getCityState(String PinCode, IResponseSubcriber iResponseSubcriber);

    void registerFba(RegisterRequestEntity registerRequestEntity, IResponseSubcriber iResponseSubcriber);
}
