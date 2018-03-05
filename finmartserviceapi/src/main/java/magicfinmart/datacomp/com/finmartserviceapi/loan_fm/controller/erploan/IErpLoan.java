package magicfinmart.datacomp.com.finmartserviceapi.loan_fm.controller.erploan;


import magicfinmart.datacomp.com.finmartserviceapi.loan_fm.IResponseSubcriberERP;
import magicfinmart.datacomp.com.finmartserviceapi.loan_fm.requestentity.ErpLoanRequest;
import magicfinmart.datacomp.com.finmartserviceapi.loan_fm.requestentity.HomeLoanRequest;

/**
 * Created by IN-RB on 04-03-2018.
 */

public interface IErpLoan {

    void saveERPLoan(ErpLoanRequest erpLoanRequest, IResponseSubcriberERP iResponseSubcriber);
}
