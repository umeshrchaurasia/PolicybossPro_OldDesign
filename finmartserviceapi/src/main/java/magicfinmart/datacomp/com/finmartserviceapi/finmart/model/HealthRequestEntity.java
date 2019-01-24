package magicfinmart.datacomp.com.finmartserviceapi.finmart.model;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.List;

public class HealthRequestEntity implements Parcelable  {
    /**
     * HealthRequestId : 13
     * crn : 2132132
     * CityID : 1020
     * ContactEmail : pramod.parit@rupeeboss.com
     * ContactMobile : 9930089092
     * ContactName : pramod parit
     * DeductibleAmount : 0
     * ExistingCustomerReferenceID : 0
     * HealthType : Health
     * MaritalStatusID : 1
     * PolicyFor : Family
     * PolicyTermYear : 1
     * ProductID : 2
     * SessionID : 0
     * SourceType : APP
     * SumInsured : 300000
     * SupportsAgentID : 2
     * FBAID : 123
     * agent_source : App
     * Quote_Application_Status : Q
     * conversion_date : null
     * created_date : 2018-02-09T05:23:51.000Z
     * updated_date : null
     * isActive : 1
     * MemberList : [{"HealthMemberListId":"37","MemberDOB":"07-06-1984","MemberGender":"M","MemberNumber":"1","MemberTypeID":"1","HealthRequestId":"13"},{"HealthMemberListId":"38","MemberDOB":"07-06-1989","MemberGender":"F","MemberNumber":"2","MemberTypeID":"2","HealthRequestId":"13"},{"HealthMemberListId":"39","MemberDOB":"29-04-2017","MemberGender":"F","MemberNumber":"5","MemberTypeID":"3","HealthRequestId":"13"}]
     */

    private int HealthRequestId;
    private String crn;
    private int CityID;
    private String ContactEmail;
    private String ContactMobile;
    private String ContactName;
    private int DeductibleAmount;
    private int ExistingCustomerReferenceID;
    private String HealthType;
    private int MaritalStatusID;
    private String PolicyFor;
    private int PolicyTermYear;
    private int ProductID;
    private int SessionID;
    private String SourceType;
    private String SumInsured;
    private int SupportsAgentID;
    private int FBAID;
    private String agent_source;
    private String Quote_Application_Status;
    private String conversion_date;
    private String created_date;
    private String updated_date;
    private int isActive;
    private List<MemberListEntity> MemberList;
    private int selectedPrevInsID;
    private int pincode;
    private String PBStatus;
    private int StatusPercent;

    private String comment;

    protected HealthRequestEntity(Parcel in) {
        HealthRequestId = in.readInt();
        crn = in.readString();
        CityID = in.readInt();
        ContactEmail = in.readString();
        ContactMobile = in.readString();
        ContactName = in.readString();
        DeductibleAmount = in.readInt();
        ExistingCustomerReferenceID = in.readInt();
        HealthType = in.readString();
        MaritalStatusID = in.readInt();
        PolicyFor = in.readString();
        PolicyTermYear = in.readInt();
        ProductID = in.readInt();
        SessionID = in.readInt();
        SourceType = in.readString();
        SumInsured = in.readString();
        SupportsAgentID = in.readInt();
        FBAID = in.readInt();
        agent_source = in.readString();
        Quote_Application_Status = in.readString();
        conversion_date = in.readString();
        created_date = in.readString();
        updated_date = in.readString();
        isActive = in.readInt();
        MemberList = in.createTypedArrayList(MemberListEntity.CREATOR);
        selectedPrevInsID = in.readInt();
        pincode = in.readInt();
        PBStatus = in.readString();
        StatusPercent = in.readInt();
        comment = in.readString();
    }

    public static final Creator<HealthRequestEntity> CREATOR = new Creator<HealthRequestEntity>() {
        @Override
        public HealthRequestEntity createFromParcel(Parcel in) {
            return new HealthRequestEntity(in);
        }

        @Override
        public HealthRequestEntity[] newArray(int size) {
            return new HealthRequestEntity[size];
        }
    };

    public int getStatusPercent() {
        return StatusPercent;
    }

    public void setStatusPercent(int statusPercent) {
        StatusPercent = statusPercent;
    }

    public String getPBStatus() {
        return PBStatus;
    }

    public void setPBStatus(String PBStatus) {
        this.PBStatus = PBStatus;
    }

    public int getPincode() {
        return pincode;
    }

    public void setPincode(int pincode) {
        this.pincode = pincode;
    }

    public int getSelectedPrevInsID() {
        return selectedPrevInsID;
    }

    public void setSelectedPrevInsID(int selectedPrevInsID) {
        this.selectedPrevInsID = selectedPrevInsID;
    }

    public int getHealthRequestId() {
        return HealthRequestId;
    }

    public void setHealthRequestId(int HealthRequestId) {
        this.HealthRequestId = HealthRequestId;
    }

    public String getCrn() {
        return crn;
    }

    public void setCrn(String crn) {
        this.crn = crn;
    }

    public int getCityID() {
        return CityID;
    }

    public void setCityID(int CityID) {
        this.CityID = CityID;
    }

    public String getContactEmail() {
        return ContactEmail;
    }

    public void setContactEmail(String ContactEmail) {
        this.ContactEmail = ContactEmail;
    }

    public String getContactMobile() {
        return ContactMobile;
    }

    public void setContactMobile(String ContactMobile) {
        this.ContactMobile = ContactMobile;
    }

    public String getContactName() {
        return ContactName;
    }

    public void setContactName(String ContactName) {
        this.ContactName = ContactName;
    }

    public int getDeductibleAmount() {
        return DeductibleAmount;
    }

    public void setDeductibleAmount(int DeductibleAmount) {
        this.DeductibleAmount = DeductibleAmount;
    }

    public int getExistingCustomerReferenceID() {
        return ExistingCustomerReferenceID;
    }

    public void setExistingCustomerReferenceID(int ExistingCustomerReferenceID) {
        this.ExistingCustomerReferenceID = ExistingCustomerReferenceID;
    }

    public String getHealthType() {
        return HealthType;
    }

    public void setHealthType(String HealthType) {
        this.HealthType = HealthType;
    }

    public int getMaritalStatusID() {
        return MaritalStatusID;
    }

    public void setMaritalStatusID(int MaritalStatusID) {
        this.MaritalStatusID = MaritalStatusID;
    }

    public String getPolicyFor() {
        return PolicyFor;
    }

    public void setPolicyFor(String PolicyFor) {
        this.PolicyFor = PolicyFor;
    }

    public int getPolicyTermYear() {
        return PolicyTermYear;
    }

    public void setPolicyTermYear(int PolicyTermYear) {
        this.PolicyTermYear = PolicyTermYear;
    }

    public int getProductID() {
        return ProductID;
    }

    public void setProductID(int ProductID) {
        this.ProductID = ProductID;
    }

    public int getSessionID() {
        return SessionID;
    }

    public void setSessionID(int SessionID) {
        this.SessionID = SessionID;
    }

    public String getSourceType() {
        return SourceType;
    }

    public void setSourceType(String SourceType) {
        this.SourceType = SourceType;
    }

    public String getSumInsured() {
        return SumInsured;
    }

    public void setSumInsured(String SumInsured) {
        this.SumInsured = SumInsured;
    }

    public int getSupportsAgentID() {
        return SupportsAgentID;
    }

    public void setSupportsAgentID(int SupportsAgentID) {
        this.SupportsAgentID = SupportsAgentID;
    }

    public int getFBAID() {
        return FBAID;
    }

    public void setFBAID(int FBAID) {
        this.FBAID = FBAID;
    }

    public String getAgent_source() {
        return agent_source;
    }

    public void setAgent_source(String agent_source) {
        this.agent_source = agent_source;
    }

    public String getQuote_Application_Status() {
        return Quote_Application_Status;
    }

    public void setQuote_Application_Status(String Quote_Application_Status) {
        this.Quote_Application_Status = Quote_Application_Status;
    }

    public String getConversion_date() {
        return conversion_date;
    }

    public void setConversion_date(String conversion_date) {
        this.conversion_date = conversion_date;
    }

    public String getCreated_date() {
        return created_date;
    }

    public void setCreated_date(String created_date) {
        this.created_date = created_date;
    }

    public String getUpdated_date() {
        return updated_date;
    }

    public void setUpdated_date(String updated_date) {
        this.updated_date = updated_date;
    }

    public int getIsActive() {
        return isActive;
    }

    public void setIsActive(int isActive) {
        this.isActive = isActive;
    }

    public List<MemberListEntity> getMemberList() {
        return MemberList;
    }

    public void setMemberList(List<MemberListEntity> MemberList) {
        this.MemberList = MemberList;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }
    public HealthRequestEntity() {

        CityID = 0;
        ContactEmail = "";
        ContactMobile = "";
        ContactName = "";
        DeductibleAmount = 0;
        ExistingCustomerReferenceID = 0;
        HealthType = "Health";
        MaritalStatusID = 1;
        PolicyFor = "";
        PolicyTermYear = 1;
        ProductID = 2;
        SessionID = 0;
        SourceType = "APP";
        SumInsured = "";
        SupportsAgentID = 2;
        MemberList = null;

    }


    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(HealthRequestId);
        dest.writeString(crn);
        dest.writeInt(CityID);
        dest.writeString(ContactEmail);
        dest.writeString(ContactMobile);
        dest.writeString(ContactName);
        dest.writeInt(DeductibleAmount);
        dest.writeInt(ExistingCustomerReferenceID);
        dest.writeString(HealthType);
        dest.writeInt(MaritalStatusID);
        dest.writeString(PolicyFor);
        dest.writeInt(PolicyTermYear);
        dest.writeInt(ProductID);
        dest.writeInt(SessionID);
        dest.writeString(SourceType);
        dest.writeString(SumInsured);
        dest.writeInt(SupportsAgentID);
        dest.writeInt(FBAID);
        dest.writeString(agent_source);
        dest.writeString(Quote_Application_Status);
        dest.writeString(conversion_date);
        dest.writeString(created_date);
        dest.writeString(updated_date);
        dest.writeInt(isActive);
        dest.writeTypedList(MemberList);
        dest.writeInt(selectedPrevInsID);
        dest.writeInt(pincode);
        dest.writeString(PBStatus);
        dest.writeInt(StatusPercent);
        dest.writeString(comment);
    }
}