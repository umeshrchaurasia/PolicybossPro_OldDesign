package magicfinmart.datacomp.com.finmartserviceapi.finmart.requestentity;

import android.os.Parcel;
import android.os.Parcelable;

public class UltralakshaRequestEntity implements Parcelable {


    /**
     * PolicyTerm : 20
     * InsuredGender : F
     * Is_TabaccoUser : False
     * SumAssured : 10000000
     * InsuredDOB : 01-12-1980
     * ContactName : Mayuri Tikale
     * ContactEmail : mayuri.tikale@policyboss.com
     * ContactMobile : 9699579052
     * Frequency : Yearly
     */

    private int PolicyTerm;
    private String InsuredGender;
    private String Is_TabaccoUser;
    private long SumAssured;
    private String InsuredDOB;
    private String ContactName;
    private String ContactEmail;
    private String ContactMobile;
    private String Frequency;
    private int FBAID;
    private int PkRequestId;
    private String QuoteApplicationStatus;
    private String CreatedDate;
    private String CRN;





    public UltralakshaRequestEntity() {
    }

    protected UltralakshaRequestEntity(Parcel in) {
        PolicyTerm = in.readInt();
        InsuredGender = in.readString();
        Is_TabaccoUser = in.readString();
        SumAssured = in.readLong();
        InsuredDOB = in.readString();
        ContactName = in.readString();
        ContactEmail = in.readString();
        ContactMobile = in.readString();
        Frequency = in.readString();
        FBAID = in.readInt();
        PkRequestId = in.readInt();
        QuoteApplicationStatus = in.readString();
        CreatedDate = in.readString();
        CRN = in.readString();
    }

    public static final Creator<UltralakshaRequestEntity> CREATOR = new Creator<UltralakshaRequestEntity>() {
        @Override
        public UltralakshaRequestEntity createFromParcel(Parcel in) {
            return new UltralakshaRequestEntity(in);
        }

        @Override
        public UltralakshaRequestEntity[] newArray(int size) {
            return new UltralakshaRequestEntity[size];
        }
    };

    public int getPolicyTerm() {
        return PolicyTerm;
    }

    public void setPolicyTerm(int policyTerm) {
        PolicyTerm = policyTerm;
    }

    public String getInsuredGender() {
        return InsuredGender;
    }

    public void setInsuredGender(String insuredGender) {
        InsuredGender = insuredGender;
    }

    public String getIs_TabaccoUser() {
        return Is_TabaccoUser;
    }

    public void setIs_TabaccoUser(String is_TabaccoUser) {
        Is_TabaccoUser = is_TabaccoUser;
    }

    public long getSumAssured() {
        return SumAssured;
    }

    public void setSumAssured(long sumAssured) {
        SumAssured = sumAssured;
    }

    public String getInsuredDOB() {
        return InsuredDOB;
    }

    public void setInsuredDOB(String insuredDOB) {
        InsuredDOB = insuredDOB;
    }

    public String getContactName() {
        return ContactName;
    }

    public void setContactName(String contactName) {
        ContactName = contactName;
    }

    public String getContactEmail() {
        return ContactEmail;
    }

    public void setContactEmail(String contactEmail) {
        ContactEmail = contactEmail;
    }

    public String getContactMobile() {
        return ContactMobile;
    }

    public void setContactMobile(String contactMobile) {
        ContactMobile = contactMobile;
    }

    public String getFrequency() {
        return Frequency;
    }

    public void setFrequency(String frequency) {
        Frequency = frequency;
    }

    public int getFBAID() {
        return FBAID;
    }

    public void setFBAID(int FBAID) {
        this.FBAID = FBAID;
    }

    public int getPkRequestId() {
        return PkRequestId;
    }

    public void setPkRequestId(int pkRequestId) {
        PkRequestId = pkRequestId;
    }

    public String getQuoteApplicationStatus() {
        return QuoteApplicationStatus;
    }

    public void setQuoteApplicationStatus(String quoteApplicationStatus) {
        QuoteApplicationStatus = quoteApplicationStatus;
    }

    public String getCreatedDate() {
        return CreatedDate;
    }

    public void setCreatedDate(String createdDate) {
        CreatedDate = createdDate;
    }

    public String getCRN() {
        return CRN;
    }

    public void setCRN(String CRN) {
        this.CRN = CRN;
    }


    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(PolicyTerm);
        dest.writeString(InsuredGender);
        dest.writeString(Is_TabaccoUser);
        dest.writeLong(SumAssured);
        dest.writeString(InsuredDOB);
        dest.writeString(ContactName);
        dest.writeString(ContactEmail);
        dest.writeString(ContactMobile);
        dest.writeString(Frequency);
        dest.writeInt(FBAID);
        dest.writeInt(PkRequestId);
        dest.writeString(QuoteApplicationStatus);
        dest.writeString(CreatedDate);
        dest.writeString(CRN);
    }
}
