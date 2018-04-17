package magicfinmart.datacomp.com.finmartserviceapi.express_loan.controller;

import magicfinmart.datacomp.com.finmartserviceapi.express_loan.requestentity.RBLPesonalLoanReqEntity;
import magicfinmart.datacomp.com.finmartserviceapi.express_loan.requestentity.SaveExpressLoanRequestEntity;
import magicfinmart.datacomp.com.finmartserviceapi.finmart.IResponseSubcriber;
import magicfinmart.datacomp.com.finmartserviceapi.finmart.requestentity.CCRblRequestEntity;

/**
 * Created by IN-RB on 03-04-2018.
 */

public interface IExpressLoan {

    void getExpressQuoteList(String FBAID,  IResponseSubcriber iResponseSubcriber);

    void getExpressLoanList(  IResponseSubcriber iResponseSubcriber);

    void saveExpressLoan(SaveExpressLoanRequestEntity saveExpressLoanRequestEntity, IResponseSubcriber iResponseSubcriber);

    /////  RBL ///////

    void saveRblPersonalLoan(RBLPesonalLoanReqEntity rblPesonalLoanReqEntity, IResponseSubcriber iResponseSubcriber);

    void getRblCalc(String LnAmt, String TnrMths, IResponseSubcriber iResponseSubcriber);
}
