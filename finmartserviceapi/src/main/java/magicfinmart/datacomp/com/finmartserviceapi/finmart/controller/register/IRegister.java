package magicfinmart.datacomp.com.finmartserviceapi.finmart.controller.register;


import java.util.HashMap;
import java.util.Map;

import magicfinmart.datacomp.com.finmartserviceapi.finmart.IResponseSubcriber;
import magicfinmart.datacomp.com.finmartserviceapi.finmart.requestentity.RegisterRequestEntity;
import okhttp3.MultipartBody;

/**
 * Created by Rajeev Ranjan on 22/01/2018.
 */

public interface IRegister {
    void generateOtp(String MobileNo, IResponseSubcriber iResponseSubcriber);

    void validateOtp(String MobileNo, String MobileOTP, IResponseSubcriber iResponseSubcriber);


    void getCityState(String PinCode, IResponseSubcriber iResponseSubcriber);

    void registerFba(RegisterRequestEntity registerRequestEntity, IResponseSubcriber iResponseSubcriber);

    void getPospDetails(IResponseSubcriber iResponseSubcriber);

    void enrollPosp(RegisterRequestEntity registerRequestEntity, IResponseSubcriber iResponseSubcriber);

    void getIFSC(String IfscCode, IResponseSubcriber iResponseSubcriber);

    void saveAccDtl(RegisterRequestEntity registerRequestEntity, IResponseSubcriber iResponseSubcriber);

    void uploadDocuments(MultipartBody.Part document, HashMap<String, String> body, final IResponseSubcriber iResponseSubcriber);

    void newUploadDocuments(MultipartBody.Part document, int FBAID, int DocType, String DocName, final IResponseSubcriber iResponseSubcriber);

    void getMyAcctDtl(String FBAID, IResponseSubcriber iResponseSubcriber);

    void getNotificationData(String FBAID, IResponseSubcriber iResponseSubcriber);

}
