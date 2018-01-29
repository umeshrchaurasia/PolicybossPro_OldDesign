package magicfinmart.datacomp.com.finmartserviceapi.finmart.controller.quoteapplication;

import magicfinmart.datacomp.com.finmartserviceapi.finmart.IResponseSubcriber;
import magicfinmart.datacomp.com.finmartserviceapi.finmart.requestentity.SaveMotorRequestEntity;
import magicfinmart.datacomp.com.finmartserviceapi.finmart.response.SaveQuoteResponse;
import magicfinmart.datacomp.com.finmartserviceapi.motor.APIResponse;

/**
 * Created by Nilesh Birhade on 25-01-2018.
 */

public interface IQuoteApp {


    void getQuoteAppList(String vehicleReqID, int fbaID, int productID, String crn, IResponseSubcriber iResponseSubcriber);

    void saveQuote(SaveMotorRequestEntity entity, IResponseSubcriber iResponseSubcriber);

    void convertQuoteToApp(String vehicleRequestID, IResponseSubcriber iResponseSubcriber);

    void deleteQuote(String vehicleRequestID, IResponseSubcriber iResponseSubcriber);
}
