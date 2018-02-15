package magicfinmart.datacomp.com.finmartserviceapi.loan_fm.controller.mainloan;

import magicfinmart.datacomp.com.finmartserviceapi.loan_fm.IResponseSubcriberFM;
import magicfinmart.datacomp.com.finmartserviceapi.loan_fm.requestentity.FmHomeLoanRequest;
import magicfinmart.datacomp.com.finmartserviceapi.loan_fm.requestentity.FmPersonalLoanRequest;

/**
 * Created by IN-RB on 31-01-2018.
 */

public interface IMainLoan {

    void getHLQuoteApplicationData(String fbaid, String type, IResponseSubcriberFM iResponseSubcriber);

    void saveHLQuoteData(FmHomeLoanRequest fmHomeLoanRequest, IResponseSubcriberFM iResponseSubcriber);

    void savePLQuoteData(FmPersonalLoanRequest fmPersonalLoanRequest, IResponseSubcriberFM iResponseSubcriber);

    void getPLQuoteApplication(String fbaid, IResponseSubcriberFM iResponseSubcriber);
}
