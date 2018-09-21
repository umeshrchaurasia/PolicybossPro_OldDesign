package magicfinmart.datacomp.com.finmartserviceapi.loan_fm.requestentity;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by Rajeev Ranjan on 19/09/2018.
 */

public class HomeLoanApplyRequestEntity implements Parcelable {

    /**
     * name :
     * gender :
     * occupation :
     * dob :
     * loanEMI :
     * pan :
     * mobileNo :
     * loanAmnt :
     * emailId :
     * loanTenure : 0
     * empCode :
     * applnSource :
     * rbaSource :
     * bankId : 0
     * brokerId : 0
     * quoteId : 0
     * productId : 0
     * pinCode :
     * applnId : 0
     * dc_fba_reg :
     * isApplnComplete : 0
     * isApplnConfirm : 0
     * fbA_Reg_Id :
     * quote_id :
     */

    private String name;
    private String gender;
    private String occupation;
    private String dob;
    private String loanEMI;
    private String pan;
    private String mobileNo;
    private String loanAmnt;
    private String emailId;
    private int loanTenure;
    private String empCode;
    private String applnSource;
    private String rbaSource;
    private int bankId;
    private int brokerId;
    private int quoteId;
    private int productId;
    private String pinCode;
    private int applnId;
    private String dc_fba_reg;
    private int isApplnComplete;
    private int isApplnConfirm;
    private String fbA_Reg_Id;
    private String quote_id;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getOccupation() {
        return occupation;
    }

    public void setOccupation(String occupation) {
        this.occupation = occupation;
    }

    public String getDob() {
        return dob;
    }

    public void setDob(String dob) {
        this.dob = dob;
    }

    public String getLoanEMI() {
        return loanEMI;
    }

    public void setLoanEMI(String loanEMI) {
        this.loanEMI = loanEMI;
    }

    public String getPan() {
        return pan;
    }

    public void setPan(String pan) {
        this.pan = pan;
    }

    public String getMobileNo() {
        return mobileNo;
    }

    public void setMobileNo(String mobileNo) {
        this.mobileNo = mobileNo;
    }

    public String getLoanAmnt() {
        return loanAmnt;
    }

    public void setLoanAmnt(String loanAmnt) {
        this.loanAmnt = loanAmnt;
    }

    public String getEmailId() {
        return emailId;
    }

    public void setEmailId(String emailId) {
        this.emailId = emailId;
    }

    public int getLoanTenure() {
        return loanTenure;
    }

    public void setLoanTenure(int loanTenure) {
        this.loanTenure = loanTenure;
    }

    public String getEmpCode() {
        return empCode;
    }

    public void setEmpCode(String empCode) {
        this.empCode = empCode;
    }

    public String getApplnSource() {
        return applnSource;
    }

    public void setApplnSource(String applnSource) {
        this.applnSource = applnSource;
    }

    public String getRbaSource() {
        return rbaSource;
    }

    public void setRbaSource(String rbaSource) {
        this.rbaSource = rbaSource;
    }

    public int getBankId() {
        return bankId;
    }

    public void setBankId(int bankId) {
        this.bankId = bankId;
    }

    public int getBrokerId() {
        return brokerId;
    }

    public void setBrokerId(int brokerId) {
        this.brokerId = brokerId;
    }

    public int getQuoteId() {
        return quoteId;
    }

    public void setQuoteId(int quoteId) {
        this.quoteId = quoteId;
    }

    public int getProductId() {
        return productId;
    }

    public void setProductId(int productId) {
        this.productId = productId;
    }

    public String getPinCode() {
        return pinCode;
    }

    public void setPinCode(String pinCode) {
        this.pinCode = pinCode;
    }

    public int getApplnId() {
        return applnId;
    }

    public void setApplnId(int applnId) {
        this.applnId = applnId;
    }

    public String getDc_fba_reg() {
        return dc_fba_reg;
    }

    public void setDc_fba_reg(String dc_fba_reg) {
        this.dc_fba_reg = dc_fba_reg;
    }

    public int getIsApplnComplete() {
        return isApplnComplete;
    }

    public void setIsApplnComplete(int isApplnComplete) {
        this.isApplnComplete = isApplnComplete;
    }

    public int getIsApplnConfirm() {
        return isApplnConfirm;
    }

    public void setIsApplnConfirm(int isApplnConfirm) {
        this.isApplnConfirm = isApplnConfirm;
    }

    public String getFbA_Reg_Id() {
        return fbA_Reg_Id;
    }

    public void setFbA_Reg_Id(String fbA_Reg_Id) {
        this.fbA_Reg_Id = fbA_Reg_Id;
    }

    public String getQuote_id() {
        return quote_id;
    }

    public void setQuote_id(String quote_id) {
        this.quote_id = quote_id;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.name);
        dest.writeString(this.gender);
        dest.writeString(this.occupation);
        dest.writeString(this.dob);
        dest.writeString(this.loanEMI);
        dest.writeString(this.pan);
        dest.writeString(this.mobileNo);
        dest.writeString(this.loanAmnt);
        dest.writeString(this.emailId);
        dest.writeInt(this.loanTenure);
        dest.writeString(this.empCode);
        dest.writeString(this.applnSource);
        dest.writeString(this.rbaSource);
        dest.writeInt(this.bankId);
        dest.writeInt(this.brokerId);
        dest.writeInt(this.quoteId);
        dest.writeInt(this.productId);
        dest.writeString(this.pinCode);
        dest.writeInt(this.applnId);
        dest.writeString(this.dc_fba_reg);
        dest.writeInt(this.isApplnComplete);
        dest.writeInt(this.isApplnConfirm);
        dest.writeString(this.fbA_Reg_Id);
        dest.writeString(this.quote_id);
    }

    public HomeLoanApplyRequestEntity() {
    }

    protected HomeLoanApplyRequestEntity(Parcel in) {
        this.name = in.readString();
        this.gender = in.readString();
        this.occupation = in.readString();
        this.dob = in.readString();
        this.loanEMI = in.readString();
        this.pan = in.readString();
        this.mobileNo = in.readString();
        this.loanAmnt = in.readString();
        this.emailId = in.readString();
        this.loanTenure = in.readInt();
        this.empCode = in.readString();
        this.applnSource = in.readString();
        this.rbaSource = in.readString();
        this.bankId = in.readInt();
        this.brokerId = in.readInt();
        this.quoteId = in.readInt();
        this.productId = in.readInt();
        this.pinCode = in.readString();
        this.applnId = in.readInt();
        this.dc_fba_reg = in.readString();
        this.isApplnComplete = in.readInt();
        this.isApplnConfirm = in.readInt();
        this.fbA_Reg_Id = in.readString();
        this.quote_id = in.readString();
    }

    public static final Parcelable.Creator<HomeLoanApplyRequestEntity> CREATOR = new Parcelable.Creator<HomeLoanApplyRequestEntity>() {
        @Override
        public HomeLoanApplyRequestEntity createFromParcel(Parcel source) {
            return new HomeLoanApplyRequestEntity(source);
        }

        @Override
        public HomeLoanApplyRequestEntity[] newArray(int size) {
            return new HomeLoanApplyRequestEntity[size];
        }
    };
}
