package magicfinmart.datacomp.com.finmartserviceapi.finmart.controller.health;

import magicfinmart.datacomp.com.finmartserviceapi.finmart.IResponseSubcriber;
import magicfinmart.datacomp.com.finmartserviceapi.finmart.model.HealthQuote;
import magicfinmart.datacomp.com.finmartserviceapi.finmart.model.HealthRequestEntity;
import magicfinmart.datacomp.com.finmartserviceapi.finmart.requestentity.HealthCompareRequestEntity;
import magicfinmart.datacomp.com.finmartserviceapi.finmart.requestentity.LoginRequestEntity;

/**
 * Created by Nilesh Birhade 09/02/18
 */

public interface IHealth {

    void getHealthQuote(HealthQuote quote, IResponseSubcriber iResponseSubcriber);

    void getHealthQuoteExp(HealthQuote quote, IResponseSubcriber iResponseSubcriber);

    void getHealthQuoteApplicationList(String fbaID, IResponseSubcriber iResponseSubcriber);

    void convertQuoteToApp(String healthRequestID, String insurerID, IResponseSubcriber iResponseSubcriber);

    void deleteQuote(String healthRequestID, IResponseSubcriber iResponseSubcriber);

    void compareQuote(HealthCompareRequestEntity compareRequestEntity, IResponseSubcriber iResponseSubcriber);
}
