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
    private int SumAssured;
    private String InsuredDOB;
    private String ContactName;
    private String ContactEmail;
    private String ContactMobile;
    private String Frequency;




    private int FBAID;

    public int getPolicyTerm() {
        return PolicyTerm;
    }

    public void setPolicyTerm(int PolicyTerm) {
        this.PolicyTerm = PolicyTerm;
    }

    public String getInsuredGender() {
        return InsuredGender;
    }

    public void setInsuredGender(String InsuredGender) {
        this.InsuredGender = InsuredGender;
    }

    public String getIs_TabaccoUser() {
        return Is_TabaccoUser;
    }

    public void setIs_TabaccoUser(String Is_TabaccoUser) {
        this.Is_TabaccoUser = Is_TabaccoUser;
    }

    public int getSumAssured() {
        return SumAssured;
    }

    public void setSumAssured(int SumAssured) {
        this.SumAssured = SumAssured;
    }

    public String getInsuredDOB() {
        return InsuredDOB;
    }

    public void setInsuredDOB(String InsuredDOB) {
        this.InsuredDOB = InsuredDOB;
    }

    public String getContactName() {
        return ContactName;
    }

    public void setContactName(String ContactName) {
        this.ContactName = ContactName;
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

    public String getFrequency() {
        return Frequency;
    }

    public void setFrequency(String Frequency) {
        this.Frequency = Frequency;
    }

    public int getFBAID() {
        return FBAID;
    }

    public void setFBAID(int FBAID) {
        this.FBAID = FBAID;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(this.PolicyTerm);
        dest.writeString(this.InsuredGender);
        dest.writeString(this.Is_TabaccoUser);
        dest.writeInt(this.SumAssured);
        dest.writeString(this.InsuredDOB);
        dest.writeString(this.ContactName);
        dest.writeString(this.ContactEmail);
        dest.writeString(this.ContactMobile);
        dest.writeString(this.Frequency);
        dest.writeInt(this.FBAID);
    }

    public UltralakshaRequestEntity() {
    }

    protected UltralakshaRequestEntity(Parcel in) {
        this.PolicyTerm = in.readInt();
        this.InsuredGender = in.readString();
        this.Is_TabaccoUser = in.readString();
        this.SumAssured = in.readInt();
        this.InsuredDOB = in.readString();
        this.ContactName = in.readString();
        this.ContactEmail = in.readString();
        this.ContactMobile = in.readString();
        this.Frequency = in.readString();
        this.FBAID = in.readInt();
    }

    public static final Parcelable.Creator<UltralakshaRequestEntity> CREATOR = new Parcelable.Creator<UltralakshaRequestEntity>() {
        @Override
        public UltralakshaRequestEntity createFromParcel(Parcel source) {
            return new UltralakshaRequestEntity(source);
        }

        @Override
        public UltralakshaRequestEntity[] newArray(int size) {
            return new UltralakshaRequestEntity[size];
        }
    };
}
