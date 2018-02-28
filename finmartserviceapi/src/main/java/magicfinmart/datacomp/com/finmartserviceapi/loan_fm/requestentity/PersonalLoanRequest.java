package magicfinmart.datacomp.com.finmartserviceapi.loan_fm.requestentity;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by IN-RB on 10-02-2017.
 */

public class PersonalLoanRequest implements Parcelable{
    /**
     "quote_id": 567,
     "ApplicantDOB": "1997-01-19T00:00:00.000Z",
     "ApplicantGender": "F",
     "ApplicantIncome": 19200,
     "ApplicantNme": "test",
     "ApplicantObligations": "400",
     "ApplicantSource": "1",
     "BrokerId": "0",
     "LoanRequired": "500000",
     "LoanTenure": "4",
     "api_source": "",
     "empcode": "",
     "row_created_date": "2018-02-06T06:51:00.000Z",
     "row_updated_date": null,
     "quote_application_type": "Q",
     "conversiondate": null,
     "Type": "PSL",
     "TranType": 6,
     "RBStatus": null,
     "RBStatusDate": null,
     "ApplNumb": null,
     "ApplDate": null,
     "isActive": 1
     "StatusPercent": null

     */

    private int quote_id;
    private String ApplicantDOB;
    private String ApplicantGender;
    private String ApplicantIncome;
    private String ApplicantNme;
    private String ApplicantObligations;
    private String ApplicantSource;
    private String BrokerId;
    private String LoanRequired;
    private String LoanTenure;
    private String api_source;
    private String empcode;
    private String row_created_date;
    private String row_updated_date;
    private String quote_application_type;
    private String conversiondate;
    private String Type;
    private String RBStatus;
    private String RBStatusDate;
    private String ApplNumb;
    private String ApplDate;
    private String StatusPercent;
    private  String bank_image;
    private  String Contact;
    private  String progress_image;

    public PersonalLoanRequest() {
        this.quote_id=0;
        this.ApplicantDOB = "";
        this.ApplicantGender = "";
        this.ApplicantIncome = "";
        this.ApplicantNme="";
        this.ApplicantObligations = "0";
        this.ApplicantSource = "";
        this.BrokerId = "";
        this.LoanRequired = "";
        this.LoanTenure = "";
        this.api_source="";
        this.empcode="";
        this.row_created_date="";
        this.row_updated_date = "";
        this.quote_application_type = "";
        this.conversiondate = "";
        this.Type="";
        this.RBStatus = "";
        this.RBStatusDate = "";
        this.ApplNumb = "";
        this.ApplDate="";
        this.StatusPercent="";
        this.bank_image="";
        this.Contact="";
        this.progress_image="";

    }

    protected PersonalLoanRequest(Parcel in) {
        quote_id = in.readInt();
        ApplicantDOB = in.readString();
        ApplicantGender = in.readString();
        ApplicantIncome = in.readString();
        ApplicantNme = in.readString();
        ApplicantObligations = in.readString();
        ApplicantSource = in.readString();
        BrokerId = in.readString();
        LoanRequired = in.readString();
        LoanTenure = in.readString();
        api_source = in.readString();
        empcode = in.readString();
        row_created_date = in.readString();
        row_updated_date = in.readString();
        quote_application_type = in.readString();
        conversiondate = in.readString();
        Type = in.readString();
        RBStatus = in.readString();
        RBStatusDate = in.readString();
        ApplNumb = in.readString();
        ApplDate = in.readString();
        StatusPercent = in.readString();
        bank_image = in.readString();
        Contact= in.readString();
        progress_image=  in.readString();
    }

    public static final Creator<PersonalLoanRequest> CREATOR = new Creator<PersonalLoanRequest>() {
        @Override
        public PersonalLoanRequest createFromParcel(Parcel in) {
            return new PersonalLoanRequest(in);
        }

        @Override
        public PersonalLoanRequest[] newArray(int size) {
            return new PersonalLoanRequest[size];
        }
    };

    public int getQuote_id() {
        return quote_id;
    }

    public void setQuote_id(int quote_id) {
        this.quote_id = quote_id;
    }

    public String getApplicantDOB() {
        return ApplicantDOB;
    }

    public void setApplicantDOB(String applicantDOB) {
        ApplicantDOB = applicantDOB;
    }

    public String getApplicantGender() {
        return ApplicantGender;
    }

    public void setApplicantGender(String applicantGender) {
        ApplicantGender = applicantGender;
    }

    public String getApplicantIncome() {
        return ApplicantIncome;
    }

    public void setApplicantIncome(String applicantIncome) {
        ApplicantIncome = applicantIncome;
    }

    public String getApplicantNme() {
        return ApplicantNme;
    }

    public void setApplicantNme(String applicantNme) {
        ApplicantNme = applicantNme;
    }

    public String getApplicantObligations() {
        return ApplicantObligations;
    }

    public void setApplicantObligations(String applicantObligations) {
        ApplicantObligations = applicantObligations;
    }

    public String getApplicantSource() {
        return ApplicantSource;
    }

    public void setApplicantSource(String applicantSource) {
        ApplicantSource = applicantSource;
    }

    public String getBrokerId() {
        return BrokerId;
    }

    public void setBrokerId(String brokerId) {
        BrokerId = brokerId;
    }

    public String getLoanRequired() {
        return LoanRequired;
    }

    public void setLoanRequired(String loanRequired) {
        LoanRequired = loanRequired;
    }

    public String getLoanTenure() {
        return LoanTenure;
    }

    public void setLoanTenure(String loanTenure) {
        LoanTenure = loanTenure;
    }

    public String getApi_source() {
        return api_source;
    }

    public void setApi_source(String api_source) {
        this.api_source = api_source;
    }

    public String getEmpcode() {
        return empcode;
    }

    public void setEmpcode(String empcode) {
        this.empcode = empcode;
    }

    public String getRow_created_date() {
        return row_created_date;
    }

    public void setRow_created_date(String row_created_date) {
        this.row_created_date = row_created_date;
    }

    public String getRow_updated_date() {
        return row_updated_date;
    }

    public void setRow_updated_date(String row_updated_date) {
        this.row_updated_date = row_updated_date;
    }

    public String getQuote_application_type() {
        return quote_application_type;
    }

    public void setQuote_application_type(String quote_application_type) {
        this.quote_application_type = quote_application_type;
    }

    public String getConversiondate() {
        return conversiondate;
    }

    public void setConversiondate(String conversiondate) {
        this.conversiondate = conversiondate;
    }

    public String getType() {
        return Type;
    }

    public void setType(String type) {
        Type = type;
    }

    public String getRBStatus() {
        return RBStatus;
    }

    public void setRBStatus(String RBStatus) {
        this.RBStatus = RBStatus;
    }

    public String getRBStatusDate() {
        return RBStatusDate;
    }

    public void setRBStatusDate(String RBStatusDate) {
        this.RBStatusDate = RBStatusDate;
    }

    public String getApplNumb() {
        return ApplNumb;
    }

    public void setApplNumb(String applNumb) {
        ApplNumb = applNumb;
    }

    public String getApplDate() {
        return ApplDate;
    }

    public void setApplDate(String applDate) {
        ApplDate = applDate;
    }

    public String getStatusPercent() {
        return StatusPercent;
    }

    public void setStatusPercent(String statusPercent) {
        StatusPercent = statusPercent;
    }

    public String getbank_image() {
        return bank_image;
    }

    public void setbank_image(String bank_image) {
        bank_image = bank_image;
    }

    public String getContact() {
        return Contact;
    }

    public void setContact(String contact) {
        Contact = contact;
    }

    public String getProgress_image() {
        return progress_image;
    }

    public void setProgress_image(String progress_image) {
        this.progress_image = progress_image;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(quote_id);
        dest.writeString(ApplicantDOB);
        dest.writeString(ApplicantGender);
        dest.writeString(ApplicantIncome);
        dest.writeString(ApplicantNme);
        dest.writeString(ApplicantObligations);
        dest.writeString(ApplicantSource);
        dest.writeString(BrokerId);
        dest.writeString(LoanRequired);
        dest.writeString(LoanTenure);
        dest.writeString(api_source);
        dest.writeString(empcode);
        dest.writeString(row_created_date);
        dest.writeString(row_updated_date);
        dest.writeString(quote_application_type);
        dest.writeString(conversiondate);
        dest.writeString(Type);
        dest.writeString(RBStatus);
        dest.writeString(RBStatusDate);
        dest.writeString(ApplNumb);
        dest.writeString(ApplDate);
        dest.writeString(StatusPercent);
        dest.writeString(bank_image);
        dest.writeString(Contact);
        dest.writeString(progress_image);
    }
}
