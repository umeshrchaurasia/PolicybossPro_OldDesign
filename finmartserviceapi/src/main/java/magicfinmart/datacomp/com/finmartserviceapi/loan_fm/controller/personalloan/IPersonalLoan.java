package magicfinmart.datacomp.com.finmartserviceapi.loan_fm.controller.personalloan;

import magicfinmart.datacomp.com.finmartserviceapi.loan_fm.IResponseSubcriber;
import magicfinmart.datacomp.com.finmartserviceapi.loan_fm.requestentity.BLLoanRequest;
import magicfinmart.datacomp.com.finmartserviceapi.loan_fm.requestentity.PersonalLoanRequest;

/**
 * Created by IN-RB on 15-01-2018.
 */

public interface IPersonalLoan {

    void getPersonalLoan(PersonalLoanRequest personalLoanRequest, IResponseSubcriber iResponseSubcriber);

    void getBLQuote(BLLoanRequest blLoanRequest, IResponseSubcriber iResponseSubcriber);
}
