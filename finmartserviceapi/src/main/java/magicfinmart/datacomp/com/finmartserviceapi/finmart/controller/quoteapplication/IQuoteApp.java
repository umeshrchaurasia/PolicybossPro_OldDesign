package magicfinmart.datacomp.com.finmartserviceapi.finmart.controller.quoteapplication;

import magicfinmart.datacomp.com.finmartserviceapi.finmart.IResponseSubcriber;

/**
 * Created by Nilesh Birhade on 25-01-2018.
 */

public interface IQuoteApp {

    void getQuoteAppList(String vehicleReqID, int fbaID, int productID, String crn, IResponseSubcriber iResponseSubcriber);
}
