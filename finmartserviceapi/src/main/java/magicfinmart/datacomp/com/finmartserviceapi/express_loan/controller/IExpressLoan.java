package magicfinmart.datacomp.com.finmartserviceapi.express_loan.controller;

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
}
