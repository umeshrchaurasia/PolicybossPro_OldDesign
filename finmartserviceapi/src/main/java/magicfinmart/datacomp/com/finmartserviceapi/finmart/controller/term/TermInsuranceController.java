package magicfinmart.datacomp.com.finmartserviceapi.finmart.controller.term;

import android.content.Context;

import java.net.ConnectException;
import java.net.SocketTimeoutException;
import java.net.UnknownHostException;
import java.util.HashMap;

import magicfinmart.datacomp.com.finmartserviceapi.database.DBPersistanceController;
import magicfinmart.datacomp.com.finmartserviceapi.finmart.IResponseSubcriber;
import magicfinmart.datacomp.com.finmartserviceapi.finmart.controller.creditcard.ICreditCard;
import magicfinmart.datacomp.com.finmartserviceapi.finmart.controller.masters.AsyncRblCityMaster;
import magicfinmart.datacomp.com.finmartserviceapi.finmart.requestbuilder.CreditCardRequestBuilder;
import magicfinmart.datacomp.com.finmartserviceapi.finmart.requestentity.CCICICIRequestEntity;
import magicfinmart.datacomp.com.finmartserviceapi.finmart.requestentity.CCRblRequestEntity;
import magicfinmart.datacomp.com.finmartserviceapi.finmart.requestentity.TermRequestEntity;
import magicfinmart.datacomp.com.finmartserviceapi.finmart.response.AppliedCreditCardResponse;
import magicfinmart.datacomp.com.finmartserviceapi.finmart.response.CCICICIResponse;
import magicfinmart.datacomp.com.finmartserviceapi.finmart.response.CCRblResponse;
import magicfinmart.datacomp.com.finmartserviceapi.finmart.response.CreditCardMasterResponse;
import magicfinmart.datacomp.com.finmartserviceapi.finmart.response.RblCityMasterResponse;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by Nilesh Birhade on 09/02/2018.
 */

public class TermInsuranceController implements ITermInsurance {


    Context mContext;

    public TermInsuranceController(Context context) {
        mContext = context;
    }


    @Override
    public void getTermQuoteApplicationList(int insurerID, IResponseSubcriber iResponseSubcriber) {

    }

    @Override
    public void getTermInsurer(TermRequestEntity entity, IResponseSubcriber iResponseSubcriber) {

    }
}
