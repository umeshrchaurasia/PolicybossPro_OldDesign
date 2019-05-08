package magicfinmart.datacomp.com.finmartserviceapi.finmart.model;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by Rajeev Ranjan on 07/05/2019.
 */
public class MotorMyLeadEntity implements Parcelable {


    /**
     * Name : NA
     * LeadId : 186
     * FBAID : 1976
     * CRN :
     * ExpiryDate : 07/05/2019
     * Make : NA
     * Model : NA
     * RegNo : WB12AG5379
     */

    private String Name;
    private int LeadId;
    private int FBAID;
    private String CRN;
    private String ExpiryDate;
    private String Make;
    private String Model;
    private String RegNo;

    protected MotorMyLeadEntity(Parcel in) {
        Name = in.readString();
        LeadId = in.readInt();
        FBAID = in.readInt();
        CRN = in.readString();
        ExpiryDate = in.readString();
        Make = in.readString();
        Model = in.readString();
        RegNo = in.readString();
    }

    public static final Creator<MotorMyLeadEntity> CREATOR = new Creator<MotorMyLeadEntity>() {
        @Override
        public MotorMyLeadEntity createFromParcel(Parcel in) {
            return new MotorMyLeadEntity(in);
        }

        @Override
        public MotorMyLeadEntity[] newArray(int size) {
            return new MotorMyLeadEntity[size];
        }
    };

    public String getName() {
        return Name;
    }

    public void setName(String Name) {
        this.Name = Name;
    }

    public int getLeadId() {
        return LeadId;
    }

    public void setLeadId(int LeadId) {
        this.LeadId = LeadId;
    }

    public int getFBAID() {
        return FBAID;
    }

    public void setFBAID(int FBAID) {
        this.FBAID = FBAID;
    }

    public String getCRN() {
        return CRN;
    }

    public void setCRN(String CRN) {
        this.CRN = CRN;
    }

    public String getExpiryDate() {
        return ExpiryDate;
    }

    public void setExpiryDate(String ExpiryDate) {
        this.ExpiryDate = ExpiryDate;
    }

    public String getMake() {
        return Make;
    }

    public void setMake(String Make) {
        this.Make = Make;
    }

    public String getModel() {
        return Model;
    }

    public void setModel(String Model) {
        this.Model = Model;
    }

    public String getRegNo() {
        return RegNo;
    }

    public void setRegNo(String RegNo) {
        this.RegNo = RegNo;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(Name);
        dest.writeInt(LeadId);
        dest.writeInt(FBAID);
        dest.writeString(CRN);
        dest.writeString(ExpiryDate);
        dest.writeString(Make);
        dest.writeString(Model);
        dest.writeString(RegNo);
    }
}
