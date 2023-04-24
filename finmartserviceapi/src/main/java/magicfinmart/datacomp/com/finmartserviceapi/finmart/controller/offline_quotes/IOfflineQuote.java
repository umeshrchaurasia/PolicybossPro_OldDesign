package magicfinmart.datacomp.com.finmartserviceapi.finmart.controller.offline_quotes;

import java.util.HashMap;

import magicfinmart.datacomp.com.finmartserviceapi.finmart.IResponseSubcriber;
import magicfinmart.datacomp.com.finmartserviceapi.finmart.requestentity.SaveHealthRequestEntity;
import magicfinmart.datacomp.com.finmartserviceapi.finmart.requestentity.SaveMotorRequestEntity;
import magicfinmart.datacomp.com.finmartserviceapi.finmart.requestentity.TermFinmartRequest;
import okhttp3.MultipartBody;

/**
 * Created by Rajeev Ranjan on 05/11/2018.
 */

public interface IOfflineQuote {

    //region old offline

    void getOfflineInput(IResponseSubcriber iResponseSubcriber);

    void createQuote(String ProductName, String ProductDiscription, String id, IResponseSubcriber iResponseSubcriber);

    void uploadDocuments(MultipartBody.Part document, HashMap<String, String> body, IResponseSubcriber iResponseSubcriber);

    void getOfflineQuote(IResponseSubcriber iResponseSubcriber);

    //endregion

    //region individual offline quote

    void getOfflineMotorList(String count,String product_id, IResponseSubcriber iResponseSubcriber);

    void saveMotorOffline(SaveMotorRequestEntity entity, IResponseSubcriber iResponseSubcriber);

    void getOfflineHealthList( String fba_id,int count, IResponseSubcriber iResponseSubcriber);

    void saveHealthOffline(SaveHealthRequestEntity entity, IResponseSubcriber iResponseSubcriber);
    //Life
    void getTermInsurer_offline(TermFinmartRequest termRequestEntity, IResponseSubcriber iResponseSubcriber);
    void getTermQuoteApplicationList_offline(int insurerID, int count, String type, IResponseSubcriber iResponseSubcriber);
    //endregion

}

