package magicfinmart.datacomp.com.finmartserviceapi.loan_fm.model;

import android.os.Parcel;
import android.os.Parcelable;

public class LoanQuoteEntity implements Parcelable {
    /**
     * loan_requestID : 5
     * ID : 4170
     * PropertyID : 1
     * PropertyCost : 398900000
     * LoanTenure : 12
     * LoanRequired : 319120000
     * City : AHMEDABAD
     * ApplicantNme : Daniyal
     * Email : null
     * Contact : null
     * ApplicantGender : M
     * ApplicantSource : 1
     * ApplicantIncome : 235000
     * ApplicantObligations :
     * ApplicantDOB : 1985-04-12T00:00:00.000Z
     * CoApplicantYes : N
     * CoApplicantGender :
     * CoApplicantSource :
     * CoApplicantIncome :
     * CoApplicantObligations :
     * CoApplicantDOB : 0000-00-00
     * Turnover :
     * ProfitAfterTax :
     * Depreciation :
     * DirectorRemuneration :
     * CoApplicantTurnover :
     * CoApplicantProfitAfterTax :
     * CoApplicantDepreciation :
     * CoApplicantDirectorRemuneration :
     * empcode : RB40000428
     * BrokerId : 0
     * ProductId : 12
     * bank_id : null
     * roi_type : null
     * loan_eligible : null
     * processing_fee : null
     * api_source : null
     * created_at : 2017-04-06T12:26:16.000Z
     * updated_at : 2017-04-06T12:26:16.000Z
     * FBA_id : 35779
     * LoaniD : 21312
     * Type : PL
     * row_created_date : 2018-01-27T06:46:10.000Z
     * row_updateddate : null
     * quote_application_type : Quote
     * conversiondate : null
     */

    private int loan_requestID;
    private int ID;
    private int PropertyID;
    private int PropertyCost;
    private int LoanTenure;
    private int LoanRequired;
    private String City;
    private String ApplicantNme;
    private String Email;
    private String Contact;
    private String ApplicantGender;
    private int ApplicantSource;
    private int ApplicantIncome;
    private String ApplicantObligations;
    private String ApplicantDOB;
    private String CoApplicantYes;
    private String CoApplicantGender;
    private String CoApplicantSource;
    private String CoApplicantIncome;
    private String CoApplicantObligations;
    private String CoApplicantDOB;
    private String Turnover;
    private String ProfitAfterTax;
    private String Depreciation;
    private String DirectorRemuneration;
    private String CoApplicantTurnover;
    private String CoApplicantProfitAfterTax;
    private String CoApplicantDepreciation;
    private String CoApplicantDirectorRemuneration;
    private String empcode;
    private int BrokerId;
    private int ProductId;
    private String bank_id;
    private String roi_type;
    private String loan_eligible;
    private String processing_fee;
    private String api_source;
    private String created_at;
    private String updated_at;
    private int FBA_id;
    private int LoaniD;
    private String Type;
    private String row_created_date;
    private String row_updateddate;
    private String quote_application_type;
    private String conversiondate;


    protected LoanQuoteEntity(Parcel in) {
        loan_requestID = in.readInt();
        ID = in.readInt();
        PropertyID = in.readInt();
        PropertyCost = in.readInt();
        LoanTenure = in.readInt();
        LoanRequired = in.readInt();
        City = in.readString();
        ApplicantNme = in.readString();
        Email = in.readString();
        Contact = in.readString();
        ApplicantGender = in.readString();
        ApplicantSource = in.readInt();
        ApplicantIncome = in.readInt();
        ApplicantObligations = in.readString();
        ApplicantDOB = in.readString();
        CoApplicantYes = in.readString();
        CoApplicantGender = in.readString();
        CoApplicantSource = in.readString();
        CoApplicantIncome = in.readString();
        CoApplicantObligations = in.readString();
        CoApplicantDOB = in.readString();
        Turnover = in.readString();
        ProfitAfterTax = in.readString();
        Depreciation = in.readString();
        DirectorRemuneration = in.readString();
        CoApplicantTurnover = in.readString();
        CoApplicantProfitAfterTax = in.readString();
        CoApplicantDepreciation = in.readString();
        CoApplicantDirectorRemuneration = in.readString();
        empcode = in.readString();
        BrokerId = in.readInt();
        ProductId = in.readInt();
        bank_id = in.readString();
        roi_type = in.readString();
        loan_eligible = in.readString();
        processing_fee = in.readString();
        api_source = in.readString();
        created_at = in.readString();
        updated_at = in.readString();
        FBA_id = in.readInt();
        LoaniD = in.readInt();
        Type = in.readString();
        row_created_date = in.readString();
        row_updateddate = in.readString();
        quote_application_type = in.readString();
        conversiondate = in.readString();
    }

    public static final Creator<LoanQuoteEntity> CREATOR = new Creator<LoanQuoteEntity>() {
        @Override
        public LoanQuoteEntity createFromParcel(Parcel in) {
            return new LoanQuoteEntity(in);
        }

        @Override
        public LoanQuoteEntity[] newArray(int size) {
            return new LoanQuoteEntity[size];
        }
    };

    public int getLoan_requestID() {
        return loan_requestID;
    }

    public void setLoan_requestID(int loan_requestID) {
        this.loan_requestID = loan_requestID;
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public int getPropertyID() {
        return PropertyID;
    }

    public void setPropertyID(int PropertyID) {
        this.PropertyID = PropertyID;
    }

    public int getPropertyCost() {
        return PropertyCost;
    }

    public void setPropertyCost(int PropertyCost) {
        this.PropertyCost = PropertyCost;
    }

    public int getLoanTenure() {
        return LoanTenure;
    }

    public void setLoanTenure(int LoanTenure) {
        this.LoanTenure = LoanTenure;
    }

    public int getLoanRequired() {
        return LoanRequired;
    }

    public void setLoanRequired(int LoanRequired) {
        this.LoanRequired = LoanRequired;
    }

    public String getCity() {
        return City;
    }

    public void setCity(String City) {
        this.City = City;
    }

    public String getApplicantNme() {
        return ApplicantNme;
    }

    public void setApplicantNme(String ApplicantNme) {
        this.ApplicantNme = ApplicantNme;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String Email) {
        this.Email = Email;
    }

    public String getContact() {
        return Contact;
    }

    public void setContact(String Contact) {
        this.Contact = Contact;
    }

    public String getApplicantGender() {
        return ApplicantGender;
    }

    public void setApplicantGender(String ApplicantGender) {
        this.ApplicantGender = ApplicantGender;
    }

    public int getApplicantSource() {
        return ApplicantSource;
    }

    public void setApplicantSource(int ApplicantSource) {
        this.ApplicantSource = ApplicantSource;
    }

    public int getApplicantIncome() {
        return ApplicantIncome;
    }

    public void setApplicantIncome(int ApplicantIncome) {
        this.ApplicantIncome = ApplicantIncome;
    }

    public String getApplicantObligations() {
        return ApplicantObligations;
    }

    public void setApplicantObligations(String ApplicantObligations) {
        this.ApplicantObligations = ApplicantObligations;
    }

    public String getApplicantDOB() {
        return ApplicantDOB;
    }

    public void setApplicantDOB(String ApplicantDOB) {
        this.ApplicantDOB = ApplicantDOB;
    }

    public String getCoApplicantYes() {
        return CoApplicantYes;
    }

    public void setCoApplicantYes(String CoApplicantYes) {
        this.CoApplicantYes = CoApplicantYes;
    }

    public String getCoApplicantGender() {
        return CoApplicantGender;
    }

    public void setCoApplicantGender(String CoApplicantGender) {
        this.CoApplicantGender = CoApplicantGender;
    }

    public String getCoApplicantSource() {
        return CoApplicantSource;
    }

    public void setCoApplicantSource(String CoApplicantSource) {
        this.CoApplicantSource = CoApplicantSource;
    }

    public String getCoApplicantIncome() {
        return CoApplicantIncome;
    }

    public void setCoApplicantIncome(String CoApplicantIncome) {
        this.CoApplicantIncome = CoApplicantIncome;
    }

    public String getCoApplicantObligations() {
        return CoApplicantObligations;
    }

    public void setCoApplicantObligations(String CoApplicantObligations) {
        this.CoApplicantObligations = CoApplicantObligations;
    }

    public String getCoApplicantDOB() {
        return CoApplicantDOB;
    }

    public void setCoApplicantDOB(String CoApplicantDOB) {
        this.CoApplicantDOB = CoApplicantDOB;
    }

    public String getTurnover() {
        return Turnover;
    }

    public void setTurnover(String Turnover) {
        this.Turnover = Turnover;
    }

    public String getProfitAfterTax() {
        return ProfitAfterTax;
    }

    public void setProfitAfterTax(String ProfitAfterTax) {
        this.ProfitAfterTax = ProfitAfterTax;
    }

    public String getDepreciation() {
        return Depreciation;
    }

    public void setDepreciation(String Depreciation) {
        this.Depreciation = Depreciation;
    }

    public String getDirectorRemuneration() {
        return DirectorRemuneration;
    }

    public void setDirectorRemuneration(String DirectorRemuneration) {
        this.DirectorRemuneration = DirectorRemuneration;
    }

    public String getCoApplicantTurnover() {
        return CoApplicantTurnover;
    }

    public void setCoApplicantTurnover(String CoApplicantTurnover) {
        this.CoApplicantTurnover = CoApplicantTurnover;
    }

    public String getCoApplicantProfitAfterTax() {
        return CoApplicantProfitAfterTax;
    }

    public void setCoApplicantProfitAfterTax(String CoApplicantProfitAfterTax) {
        this.CoApplicantProfitAfterTax = CoApplicantProfitAfterTax;
    }

    public String getCoApplicantDepreciation() {
        return CoApplicantDepreciation;
    }

    public void setCoApplicantDepreciation(String CoApplicantDepreciation) {
        this.CoApplicantDepreciation = CoApplicantDepreciation;
    }

    public String getCoApplicantDirectorRemuneration() {
        return CoApplicantDirectorRemuneration;
    }

    public void setCoApplicantDirectorRemuneration(String CoApplicantDirectorRemuneration) {
        this.CoApplicantDirectorRemuneration = CoApplicantDirectorRemuneration;
    }

    public String getEmpcode() {
        return empcode;
    }

    public void setEmpcode(String empcode) {
        this.empcode = empcode;
    }

    public int getBrokerId() {
        return BrokerId;
    }

    public void setBrokerId(int BrokerId) {
        this.BrokerId = BrokerId;
    }

    public int getProductId() {
        return ProductId;
    }

    public void setProductId(int ProductId) {
        this.ProductId = ProductId;
    }

    public String getBank_id() {
        return bank_id;
    }

    public void setBank_id(String bank_id) {
        this.bank_id = bank_id;
    }

    public String getRoi_type() {
        return roi_type;
    }

    public void setRoi_type(String roi_type) {
        this.roi_type = roi_type;
    }

    public String getLoan_eligible() {
        return loan_eligible;
    }

    public void setLoan_eligible(String loan_eligible) {
        this.loan_eligible = loan_eligible;
    }

    public String getProcessing_fee() {
        return processing_fee;
    }

    public void setProcessing_fee(String processing_fee) {
        this.processing_fee = processing_fee;
    }

    public String getApi_source() {
        return api_source;
    }

    public void setApi_source(String api_source) {
        this.api_source = api_source;
    }

    public String getCreated_at() {
        return created_at;
    }

    public void setCreated_at(String created_at) {
        this.created_at = created_at;
    }

    public String getUpdated_at() {
        return updated_at;
    }

    public void setUpdated_at(String updated_at) {
        this.updated_at = updated_at;
    }

    public int getFBA_id() {
        return FBA_id;
    }

    public void setFBA_id(int FBA_id) {
        this.FBA_id = FBA_id;
    }

    public int getLoaniD() {
        return LoaniD;
    }

    public void setLoaniD(int LoaniD) {
        this.LoaniD = LoaniD;
    }

    public String getType() {
        return Type;
    }

    public void setType(String Type) {
        this.Type = Type;
    }

    public String getRow_created_date() {
        return row_created_date;
    }

    public void setRow_created_date(String row_created_date) {
        this.row_created_date = row_created_date;
    }

    public String getRow_updateddate() {
        return row_updateddate;
    }

    public void setRow_updateddate(String row_updateddate) {
        this.row_updateddate = row_updateddate;
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


    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(loan_requestID);
        dest.writeInt(ID);
        dest.writeInt(PropertyID);
        dest.writeInt(PropertyCost);
        dest.writeInt(LoanTenure);
        dest.writeInt(LoanRequired);
        dest.writeString(City);
        dest.writeString(ApplicantNme);
        dest.writeString(Email);
        dest.writeString(Contact);
        dest.writeString(ApplicantGender);
        dest.writeInt(ApplicantSource);
        dest.writeInt(ApplicantIncome);
        dest.writeString(ApplicantObligations);
        dest.writeString(ApplicantDOB);
        dest.writeString(CoApplicantYes);
        dest.writeString(CoApplicantGender);
        dest.writeString(CoApplicantSource);
        dest.writeString(CoApplicantIncome);
        dest.writeString(CoApplicantObligations);
        dest.writeString(CoApplicantDOB);
        dest.writeString(Turnover);
        dest.writeString(ProfitAfterTax);
        dest.writeString(Depreciation);
        dest.writeString(DirectorRemuneration);
        dest.writeString(CoApplicantTurnover);
        dest.writeString(CoApplicantProfitAfterTax);
        dest.writeString(CoApplicantDepreciation);
        dest.writeString(CoApplicantDirectorRemuneration);
        dest.writeString(empcode);
        dest.writeInt(BrokerId);
        dest.writeInt(ProductId);
        dest.writeString(bank_id);
        dest.writeString(roi_type);
        dest.writeString(loan_eligible);
        dest.writeString(processing_fee);
        dest.writeString(api_source);
        dest.writeString(created_at);
        dest.writeString(updated_at);
        dest.writeInt(FBA_id);
        dest.writeInt(LoaniD);
        dest.writeString(Type);
        dest.writeString(row_created_date);
        dest.writeString(row_updateddate);
        dest.writeString(quote_application_type);
        dest.writeString(conversiondate);
    }
}