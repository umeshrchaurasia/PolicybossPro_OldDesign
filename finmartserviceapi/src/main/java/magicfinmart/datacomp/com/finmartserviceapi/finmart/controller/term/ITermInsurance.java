package magicfinmart.datacomp.com.finmartserviceapi.finmart.controller.term;

import magicfinmart.datacomp.com.finmartserviceapi.finmart.IResponseSubcriber;
import magicfinmart.datacomp.com.finmartserviceapi.finmart.requestentity.TermFinmartRequest;

/**
 * Created by Nilesh Birhade on 05-04-2018.
 */

public interface ITermInsurance {

    void getTermQuoteApplicationList(int insurerID, IResponseSubcriber iResponseSubcriber);

    void getTermInsurer(TermFinmartRequest termRequestEntity, IResponseSubcriber iResponseSubcriber);
}
