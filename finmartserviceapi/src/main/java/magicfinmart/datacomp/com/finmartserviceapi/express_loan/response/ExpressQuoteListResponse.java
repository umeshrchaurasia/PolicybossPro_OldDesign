package magicfinmart.datacomp.com.finmartserviceapi.express_loan.response;

import java.util.List;

import magicfinmart.datacomp.com.finmartserviceapi.express_loan.model.ExpressQuoteEntity;

import magicfinmart.datacomp.com.finmartserviceapi.finmart.APIResponse;
/**
 * Created by IN-RB on 03-04-2018.
 */

public class ExpressQuoteListResponse extends APIResponse {


    /**
     * Message : Success
     * Status : success
     * StatusNo : 0
     * MasterData : [{"ExpressLoanRequestId":24,"FullName":"test abc test","MobileNo":"9822945446","City":"Mumbai","LoanAmount":"500000","BankId":1,"LoanType":"car loan","CreatedDate":"03/04/2018","FBAID":12,"IsActive":1,"ApplicationID":"0","Bank_Id":1,"Bank_Name":"ADITYA BIRLA FINANCE LIMITED","Bank_Code":"ADITYA BIRLA","Document1":"http://erp.rupeeboss.com/Banklogo/a-birla.png"},{"ExpressLoanRequestId":23,"FullName":"test abc test","MobileNo":"0000000000","City":"Mumbai","LoanAmount":"500000","BankId":1,"LoanType":"car loan","CreatedDate":"03/04/2018","FBAID":12,"IsActive":1,"ApplicationID":"0","Bank_Id":1,"Bank_Name":"ADITYA BIRLA FINANCE LIMITED","Bank_Code":"ADITYA BIRLA","Document1":"http://erp.rupeeboss.com/Banklogo/a-birla.png"},{"ExpressLoanRequestId":22,"FullName":"test abc test","MobileNo":"9719152735","City":"Mumbai","LoanAmount":"500000","BankId":1,"LoanType":"car loan","CreatedDate":"03/04/2018","FBAID":12,"IsActive":1,"ApplicationID":"0","Bank_Id":1,"Bank_Name":"ADITYA BIRLA FINANCE LIMITED","Bank_Code":"ADITYA BIRLA","Document1":"http://erp.rupeeboss.com/Banklogo/a-birla.png"},{"ExpressLoanRequestId":21,"FullName":"test abc test","MobileNo":"0000000000","City":"Mumbai","LoanAmount":"500000","BankId":1,"LoanType":"car loan","CreatedDate":"03/04/2018","FBAID":12,"IsActive":1,"ApplicationID":"0","Bank_Id":1,"Bank_Name":"ADITYA BIRLA FINANCE LIMITED","Bank_Code":"ADITYA BIRLA","Document1":"http://erp.rupeeboss.com/Banklogo/a-birla.png"},{"ExpressLoanRequestId":20,"FullName":"test abc test","MobileNo":"0000000000","City":"Mumbai","LoanAmount":"500000","BankId":1,"LoanType":"car loan","CreatedDate":"03/04/2018","FBAID":12,"IsActive":1,"ApplicationID":"0","Bank_Id":1,"Bank_Name":"ADITYA BIRLA FINANCE LIMITED","Bank_Code":"ADITYA BIRLA","Document1":"http://erp.rupeeboss.com/Banklogo/a-birla.png"},{"ExpressLoanRequestId":19,"FullName":"test abc test","MobileNo":"9719152735","City":"Mumbai","LoanAmount":"500000","BankId":1,"LoanType":"car loan","CreatedDate":"03/04/2018","FBAID":12,"IsActive":1,"ApplicationID":"0","Bank_Id":1,"Bank_Name":"ADITYA BIRLA FINANCE LIMITED","Bank_Code":"ADITYA BIRLA","Document1":"http://erp.rupeeboss.com/Banklogo/a-birla.png"},{"ExpressLoanRequestId":18,"FullName":"test abc test","MobileNo":"9719152735","City":"Mumbai","LoanAmount":"500000","BankId":1,"LoanType":"car loan","CreatedDate":"03/04/2018","FBAID":12,"IsActive":1,"ApplicationID":"0","Bank_Id":1,"Bank_Name":"ADITYA BIRLA FINANCE LIMITED","Bank_Code":"ADITYA BIRLA","Document1":"http://erp.rupeeboss.com/Banklogo/a-birla.png"},{"ExpressLoanRequestId":17,"FullName":"test abc test","MobileNo":"8268378764","City":"Mumbai","LoanAmount":"500000","BankId":1,"LoanType":"car loan","CreatedDate":"03/04/2018","FBAID":12,"IsActive":1,"ApplicationID":"0","Bank_Id":1,"Bank_Name":"ADITYA BIRLA FINANCE LIMITED","Bank_Code":"ADITYA BIRLA","Document1":"http://erp.rupeeboss.com/Banklogo/a-birla.png"},{"ExpressLoanRequestId":16,"FullName":"test abc test","MobileNo":"8268378764","City":"Mumbai","LoanAmount":"500000","BankId":1,"LoanType":"car loan","CreatedDate":"03/04/2018","FBAID":12,"IsActive":1,"ApplicationID":"0","Bank_Id":1,"Bank_Name":"ADITYA BIRLA FINANCE LIMITED","Bank_Code":"ADITYA BIRLA","Document1":"http://erp.rupeeboss.com/Banklogo/a-birla.png"},{"ExpressLoanRequestId":15,"FullName":"test abc test","MobileNo":"8268378764","City":"Mumbai","LoanAmount":"500000","BankId":1,"LoanType":"car loan","CreatedDate":"03/04/2018","FBAID":12,"IsActive":1,"ApplicationID":"0","Bank_Id":1,"Bank_Name":"ADITYA BIRLA FINANCE LIMITED","Bank_Code":"ADITYA BIRLA","Document1":"http://erp.rupeeboss.com/Banklogo/a-birla.png"},{"ExpressLoanRequestId":14,"FullName":"test abc test","MobileNo":"9967192191","City":"Mumbai","LoanAmount":"500000","BankId":1,"LoanType":"car loan","CreatedDate":"03/04/2018","FBAID":12,"IsActive":1,"ApplicationID":"0","Bank_Id":1,"Bank_Name":"ADITYA BIRLA FINANCE LIMITED","Bank_Code":"ADITYA BIRLA","Document1":"http://erp.rupeeboss.com/Banklogo/a-birla.png"},{"ExpressLoanRequestId":13,"FullName":"testabc test","MobileNo":"9967192191","City":"Mumbai","LoanAmount":"500000","BankId":1,"LoanType":"car loan","CreatedDate":"03/04/2018","FBAID":12,"IsActive":1,"ApplicationID":"0","Bank_Id":1,"Bank_Name":"ADITYA BIRLA FINANCE LIMITED","Bank_Code":"ADITYA BIRLA","Document1":"http://erp.rupeeboss.com/Banklogo/a-birla.png"},{"ExpressLoanRequestId":10,"FullName":"Test 3","MobileNo":"55555 44444 22","City":"vi","LoanAmount":"21","BankId":1,"LoanType":"car loan","CreatedDate":"03/04/2018","FBAID":12,"IsActive":1,"ApplicationID":"123","Bank_Id":1,"Bank_Name":"ADITYA BIRLA FINANCE LIMITED","Bank_Code":"ADITYA BIRLA","Document1":"http://erp.rupeeboss.com/Banklogo/a-birla.png"},{"ExpressLoanRequestId":9,"FullName":"Test 2","MobileNo":"77788 44444 22","City":"vi","LoanAmount":"21","BankId":1,"LoanType":"car loan","CreatedDate":"02/04/2018","FBAID":12,"IsActive":1,"ApplicationID":"123","Bank_Id":1,"Bank_Name":"ADITYA BIRLA FINANCE LIMITED","Bank_Code":"ADITYA BIRLA","Document1":"http://erp.rupeeboss.com/Banklogo/a-birla.png"},{"ExpressLoanRequestId":7,"FullName":"Test 1","MobileNo":"88888 44444 22","City":"vidhyvihar","LoanAmount":"21","BankId":1,"LoanType":"car loan","CreatedDate":"02/04/2018","FBAID":12,"IsActive":1,"ApplicationID":null,"Bank_Id":1,"Bank_Name":"ADITYA BIRLA FINANCE LIMITED","Bank_Code":"ADITYA BIRLA","Document1":"http://erp.rupeeboss.com/Banklogo/a-birla.png"},{"ExpressLoanRequestId":8,"FullName":"Test 2","MobileNo":"77788 44444 22","City":"vi","LoanAmount":"21","BankId":1,"LoanType":"car loan","CreatedDate":"01/04/2018","FBAID":12,"IsActive":1,"ApplicationID":null,"Bank_Id":1,"Bank_Name":"ADITYA BIRLA FINANCE LIMITED","Bank_Code":"ADITYA BIRLA","Document1":"http://erp.rupeeboss.com/Banklogo/a-birla.png"}]
     */

    private String Message;
    private String Status;
    private int StatusNo;
    private List<ExpressQuoteEntity> MasterData;

    public String getMessage() {
        return Message;
    }

    public void setMessage(String Message) {
        this.Message = Message;
    }

    public String getStatus() {
        return Status;
    }

    public void setStatus(String Status) {
        this.Status = Status;
    }

    public int getStatusNo() {
        return StatusNo;
    }

    public void setStatusNo(int StatusNo) {
        this.StatusNo = StatusNo;
    }

    public List<ExpressQuoteEntity> getMasterData() {
        return MasterData;
    }

    public void setMasterData(List<ExpressQuoteEntity> MasterData) {
        this.MasterData = MasterData;
    }


}
