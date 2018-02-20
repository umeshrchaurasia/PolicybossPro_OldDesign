package magicfinmart.datacomp.com.finmartserviceapi.finmart.controller.pendingcases;

import magicfinmart.datacomp.com.finmartserviceapi.finmart.IResponseSubcriber;
import magicfinmart.datacomp.com.finmartserviceapi.finmart.model.HealthQuote;

/**
 * Created by Nilesh Birhade 09/02/18
 */

public interface IPendingCases {

    void getPendingCases(String fbaID, IResponseSubcriber iResponseSubcriber);

    void deletePending(int pendingID, IResponseSubcriber iResponseSubcriber);
}
