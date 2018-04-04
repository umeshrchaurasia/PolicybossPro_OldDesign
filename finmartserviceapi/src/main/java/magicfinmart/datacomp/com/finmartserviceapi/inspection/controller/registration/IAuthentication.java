package magicfinmart.datacomp.com.finmartserviceapi.inspection.controller.registration;


import magicfinmart.datacomp.com.finmartserviceapi.inspection.IResponseSubcribe;
import magicfinmart.datacomp.com.finmartserviceapi.inspection.entity.VehRegRequestEntity;

/**
 * Created by Nilesh Birhade on 14-12-2017.
 */

public interface IAuthentication {

    void registerVehicle(VehRegRequestEntity regRequestEntity, final IResponseSubcribe iResponseSubcriber);

    void getOtp(String mobile, final IResponseSubcribe iResponseSubcriber);

    void verifyOtp(String mobile, String verify_otp, final IResponseSubcribe iResponseSubcriber);
}
