package magicfinmart.datacomp.com.finmartserviceapi.finmart.controller.pendingcases;

import magicfinmart.datacomp.com.finmartserviceapi.finmart.IResponseSubcriber;
import magicfinmart.datacomp.com.finmartserviceapi.finmart.model.HealthQuote;

/**
 * Created by Nilesh Birhade 09/02/18
 */

public interface IPendingCases {

    void getPendingCases(int count,int type,String fbaID, IResponseSubcriber iResponseSubcriber);

    void deletePending(String quoteType, int pendingID, IResponseSubcriber iResponseSubcriber);
}
