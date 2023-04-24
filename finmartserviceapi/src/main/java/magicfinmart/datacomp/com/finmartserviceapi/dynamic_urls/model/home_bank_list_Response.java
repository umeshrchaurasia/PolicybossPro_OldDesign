package magicfinmart.datacomp.com.finmartserviceapi.dynamic_urls.model;

import java.util.List;

import magicfinmart.datacomp.com.finmartserviceapi.finmart.APIResponse;

public class home_bank_list_Response extends APIResponse {

    /**
     * data : [{"Age":"22-60 years","Bank_Id":"33","Bank_Name":"KOTAK MAHINDRA BANK","Bank_URL":"https://erp.rupeeboss.com/Banklogo/kotak.png","Best_ROI":"8.95%","Foreclosure_charges":"NIL","LTV":"Below 50Lakhs-85%  Above 50Lakhs- 75%","Loan_Amt":"Rs.30 lakhs-30 crore","Min_Cibil_Score":"650","Min_Salary":"Rs.35000 net pm","Min_Work_Exp":"2 year","Per_Lac_EMI":"Rs.897","Prepayment_charges":"NIL","Processing_Fees":"Rs.10000+ GST Rs.5000(Women applicants)","Product_Id":"12","Product_Name":"Home Loan","Product_Type":"Normal","Seqment":"Salaried","Tenure":"3-20 years"},{"Age":"22-65 years","Bank_Id":"33","Bank_Name":"KOTAK MAHINDRA BANK","Bank_URL":"https://erp.rupeeboss.com/Banklogo/kotak.png","Best_ROI":"8.95%-9.10%","Foreclosure_charges":"Lock in period is 6 month  4% of Principal Outstanding +4% on amount prepaid in last 12 months","LTV":"75%","Loan_Amt":"Rs.30 lakhs-30 crore","Min_Cibil_Score":"650","Min_Salary":"Rs.75000 net pm","Min_Work_Exp":"3 year","Per_Lac_EMI":"Rs.1011 - Rs.1020","Prepayment_charges":"Lock in period is 6 month  4% of Principal Outstanding +4% on amount prepaid in last 12 months","Processing_Fees":"0.50% + GST Rs.5000 (Women applicants)","Product_Id":"12","Product_Name":"Home Loan","Product_Type":"Normal","Seqment":"Self Employed","Tenure":"3-15 years"},{"Age":"23-62 years","Bank_Id":"53","Bank_Name":"YES BANK","Bank_URL":"https://erp.rupeeboss.com/Banklogo/yes.png","Best_ROI":"9.5%","Foreclosure_charges":"NIL","LTV":"Upto 30 lakhs=90% 30 lakhs-75 lakhs=80% Above 75 lakhs=75%","Loan_Amt":"Rs.25 lakhs-No upper limit","Min_Cibil_Score":"650","Min_Salary":"Rs.25000 net pm","Min_Work_Exp":"2 year","Per_Lac_EMI":"Rs.822","Prepayment_charges":"NIL","Processing_Fees":"0.50% Min- Rs.10000","Product_Id":"12","Product_Name":"Home Loan","Product_Type":"Normal","Seqment":"Salaried","Tenure":"Max 35 years"},{"Age":"23-65 years","Bank_Id":"53","Bank_Name":"YES BANK","Bank_URL":"http://erp.rupeeboss.com/Banklogo/yes.png","Best_ROI":"9.5%","Foreclosure_charges":"NIL","LTV":"Upto 30 lakhs =90% 30 lakhs-75 lakhs = 80% Above 75 lakhs=75%","Loan_Amt":"Rs.25 lakhs-No upper limit","Min_Cibil_Score":"650","Min_Salary":"Rs.25000 net pm","Min_Work_Exp":"2 year","Per_Lac_EMI":"Rs.841","Prepayment_charges":"NIL","Processing_Fees":"0.50% Min- Rs.10000","Product_Id":"12","Product_Name":"Home Loan","Product_Type":"Normal","Seqment":"Self Employed","Tenure":"SEP/SENP-30 years NRI-25 years"},{"Age":"23-62 years","Bank_Id":"53","Bank_Name":"YES BANK","Bank_URL":"http://erp.rupeeboss.com/Banklogo/yes.png","Best_ROI":"9.50%-10.50% for Formal Income 10.50%-11.75% for Semi-formal(Cash salary,cheque salary,partial income docs,etc) 11.75%-12.50% for Informal Income(Only a bank statement required along with KYC)","Foreclosure_charges":"NIL","LTV":"Upto 30 lakhs=90% 30 lakhs-75 lakhs=80%  Above 75 lakhs = 75%","Loan_Amt":"Rs.1 lakh-50 lakhs","Min_Cibil_Score":"0, -1, 650","Min_Salary":"Rs.9000 net pm","Min_Work_Exp":"3 year","Per_Lac_EMI":"Rs.822","Prepayment_charges":"NIL","Processing_Fees":"0.75%-1% Min-Rs.10000","Product_Id":"12","Product_Name":"Home Loan","Product_Type":"Affordable","Seqment":"Salaried","Tenure":"Max 35 years"},{"Age":"23-65 years","Bank_Id":"53","Bank_Name":"YES BANK","Bank_URL":"http://erp.rupeeboss.com/Banklogo/yes.png","Best_ROI":"9.50%- 10.50% for Formal Income  10.50%- 11.75% for Semi-formal (Cash salary,cheque salary,partial income docs,etc) 11.75%- 12.50% for Informal Income (Only a bank statement required along with KYC)","Foreclosure_charges":"NIL","LTV":"Upto 30 lakhs = 90%  30 lakhs - 75 lakhs = 80% Above 75 lakhs = 75%","Loan_Amt":"Rs.1 lakh-50 lakhs","Min_Cibil_Score":"0, -1, 650","Min_Salary":"Rs.9000 net pm","Min_Work_Exp":"3 year","Per_Lac_EMI":"Rs.841","Prepayment_charges":"NIL","Processing_Fees":"0.75%-1% Min- Rs.10000","Product_Id":"12","Product_Name":"Home Loan","Product_Type":"Affordable","Seqment":"Self Employed","Tenure":"SEP/SENP-30 years NRI-25 years"}]
     * message : Success
     * status_Id : 0
     */

    private String message;
    private int status_Id;
    private List<Home_bankdetailEntity> data;

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

    public List<Home_bankdetailEntity> getData() {
        return data;
    }

    public void setData(List<Home_bankdetailEntity> data) {
        this.data = data;
    }


}
