package magicfinmart.datacomp.com.finmartserviceapi.dynamic_urls;

import java.util.HashMap;

import magicfinmart.datacomp.com.finmartserviceapi.dynamic_urls.requestentity.CertificateEntity;
import magicfinmart.datacomp.com.finmartserviceapi.dynamic_urls.requestentity.GenerateLeadRequestEntity;
import magicfinmart.datacomp.com.finmartserviceapi.dynamic_urls.requestentity.RegisterRequestEntity;
import magicfinmart.datacomp.com.finmartserviceapi.dynamic_urls.requestentity.UploadNCDRequestEntity;
import magicfinmart.datacomp.com.finmartserviceapi.finmart.IResponseSubcriber;
import okhttp3.MultipartBody;

/**
 * Created by Nilesh Birhade on 06-08-2018.
 */

public interface IDynamic {

    void getVehicleByVehicleNo(String vehicleNo, IResponseSubcriber iResponseSubcriber);

    void getVehicleByMobileNo(String mobileNo, IResponseSubcriber iResponseSubcriber);

    void saveGenerateLead(GenerateLeadRequestEntity entity, IResponseSubcriber iResponseSubcriber);

    void getNCD(IResponseSubcriber iResponseSubcriber);

    void uploadNCDDetails(UploadNCDRequestEntity entity, IResponseSubcriber iResponseSubcriber);


    void uploadNCDDocuments(MultipartBody.Part document, HashMap<String, String> body, final IResponseSubcriber iResponseSubcriber);

    void GetPospAppointmentLetter(CertificateEntity certificateEntity, IResponseSubcriber iResponseSubcriber);


    void sendUserBehaviour();

    //My Business
    void getMyBusiness(String id, IResponseSubcriber iResponseSubcriber);

    //Personal loan
    void getBankdetail_personalloan(String cityid, String Productid, IResponseSubcriber iResponseSubcriber);

    //Personal loan
    void getBankdetail_homeloan(String cityid, String Productid, IResponseSubcriber iResponseSubcriber);

    void checkAppAccess(String deviceID, String deviceToken, String uid, IResponseSubcriber iResponseSubcriber);

    void markAttendance(RegisterRequestEntity entity, IResponseSubcriber iResponseSubcriber);
}
