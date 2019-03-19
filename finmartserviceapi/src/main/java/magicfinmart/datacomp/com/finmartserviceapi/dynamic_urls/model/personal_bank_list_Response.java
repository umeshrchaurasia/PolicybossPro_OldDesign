package magicfinmart.datacomp.com.finmartserviceapi.dynamic_urls.model;

import java.util.List;

import magicfinmart.datacomp.com.finmartserviceapi.finmart.APIResponse;

/**
 * Created by IN-RB on 13-03-2019.
 */

public class personal_bank_list_Response extends APIResponse {


    /**
     * data : [{"Age":"21 - 60 years","Bank_Id":"33","Bank_Name":"KOTAK MAHINDRA BANK","Bank_URL":"http://erp.rupeeboss.com/Banklogo/kotak.png","Best_ROI":"13.50%","Foreclosure_charges":"Lock in period is 12 months. Post 12 months, 5%+GST on Principal outstanding","Loan_Amt":"Rs.50000 - 25 lakhs","Min_Cibil_Score":"625","Min_Salary":"Rs.25000 net pm","Min_Work_Exp":"1 year","Per_Lac_EMI":"Rs.2301","Prepayment_charges":"NA","Processing_Fees":"Upto 2.50% + GST","Product_Id":"9","Product_Name":"Personal Loan","Seqment":"Salaried","Tenure":"1 - 5 years"},{"Age":"21 - 60 years","Bank_Id":"20","Bank_Name":"HDFC BANK LTD","Bank_URL":"http://erp.rupeeboss.com/Banklogo/hdfc.png","Best_ROI":"11.25%","Foreclosure_charges":"Lock in period is 12 months. 13-24 months - 4% of Principal O/s  25-36 months - 3% of Principal O/s   > 36 months - 2% of Principal O/s","Loan_Amt":"Rs.50000 - 40 lakhs","Min_Cibil_Score":"650","Min_Salary":"Rs.20000 net pm","Min_Work_Exp":"1 year","Per_Lac_EMI":"Rs.2187","Prepayment_charges":"NA","Processing_Fees":"Upto 2.25% + GST. Min Rs.1999","Product_Id":"9","Product_Name":"Personal Loan","Seqment":"Salaried","Tenure":"1 - 5 years"},{"Age":"25 - 60 years","Bank_Id":"43","Bank_Name":"RBL Bank Limited","Bank_URL":"http://erp.rupeeboss.com/Banklogo/rbl_bank.jpg","Best_ROI":"13.99%","Foreclosure_charges":"Lock in period is 12 months  13-18 months - 5% of Principal O/s   > 18 months - 3% of Principal O/s","Loan_Amt":"1 lakh - 20 lakhs","Min_Cibil_Score":"685","Min_Salary":"Rs.25000 net pm","Min_Work_Exp":"1 year","Per_Lac_EMI":"Rs.2326","Prepayment_charges":"NA","Processing_Fees":"Upto 2%","Product_Id":"9","Product_Name":"Personal Loan","Seqment":"Salaried","Tenure":"1 - 5 years"},{"Age":"22 - 58 years","Bank_Id":"51","Bank_Name":"TATA CAPITAL HOUSING FINANCE LIMITED","Bank_URL":"http://erp.rupeeboss.com/Banklogo/tata-capital.png","Best_ROI":"11.75%","Foreclosure_charges":"4.5% of the principal outstanding + GST","Loan_Amt":"Rs.75000 - 25 lakhs","Min_Cibil_Score":"650","Min_Salary":"Rs.25000 net pm","Min_Work_Exp":"1 year","Per_Lac_EMI":"Rs.2212","Prepayment_charges":"Lock in period is 6 months.  Zero charges - part pre-pay  loan up to 25 % of the loan amount.  Fee of 2% (of the amount paid) + GST is applicable beyond 25% of the principal outstanding.","Processing_Fees":"Upto 2%","Product_Id":"9","Product_Name":"Personal Loan","Seqment":"Salaried","Tenure":"1 - 6 years"}]
     * message : Success
     * status_Id : 0
     */

    private String message;
    private int status_Id;
    private List<Personal_bankdetailEntity> data;

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public int getStatus_Id() {
        return status_Id;
    }

    public void setStatus_Id(int status_Id) {
        this.status_Id = status_Id;
    }

    public List<Personal_bankdetailEntity> getData() {
        return data;
    }

    public void setData(List<Personal_bankdetailEntity> data) {
        this.data = data;
    }

}
