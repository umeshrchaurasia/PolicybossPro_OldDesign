package magicfinmart.datacomp.com.finmartserviceapi.loan_fm.controller.personalloan;

import magicfinmart.datacomp.com.finmartserviceapi.loan_fm.IResponseSubcriber;
import magicfinmart.datacomp.com.finmartserviceapi.loan_fm.requestentity.PersonalLoanRequest;

/**
 * Created by IN-RB on 15-01-2018.
 */

public interface IPersonalLoan {

    void getPersonalLoan(PersonalLoanRequest personalLoanRequest, IResponseSubcriber iResponseSubcriber);

    void getPersonalQuote(int ProductId, String BrokerID,String EmpCode, IResponseSubcriber iResponseSubcriber);
}
