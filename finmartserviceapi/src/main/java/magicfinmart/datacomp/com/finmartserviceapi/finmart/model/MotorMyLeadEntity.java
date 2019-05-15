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
    private String LeadId;
    private int FBAID;
    private String CRN;
    private String ExpiryDate;
    private String Make;
    private String Model;
    private String RegNo;
    private String ss_id;
    private  int leadtype;


    protected MotorMyLeadEntity(Parcel in) {
        Name = in.readString();
        LeadId = in.readString();
        FBAID = in.readInt();
        CRN = in.readString();
        ExpiryDate = in.readString();
        Make = in.readString();
        Model = in.readString();
        RegNo = in.readString();
        ss_id = in.readString();
        leadtype = in.readInt();
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(Name);
        dest.writeString(LeadId);
        dest.writeInt(FBAID);
        dest.writeString(CRN);
        dest.writeString(ExpiryDate);
        dest.writeString(Make);
        dest.writeString(Model);
        dest.writeString(RegNo);
        dest.writeString(ss_id);
        dest.writeInt(leadtype);
    }

    @Override
    public int describeContents() {
        return 0;
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

    public void setName(String name) {
        Name = name;
    }

    public String getLeadId() {
        return LeadId;
    }

    public void setLeadId(String leadId) {
        LeadId = leadId;
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

    public void setExpiryDate(String expiryDate) {
        ExpiryDate = expiryDate;
    }

    public String getMake() {
        return Make;
    }

    public void setMake(String make) {
        Make = make;
    }

    public String getModel() {
        return Model;
    }

    public void setModel(String model) {
        Model = model;
    }

    public String getRegNo() {
        return RegNo;
    }

    public void setRegNo(String regNo) {
        RegNo = regNo;
    }

    public String getSs_id() {
        return ss_id;
    }

    public void setSs_id(String ss_id) {
        this.ss_id = ss_id;
    }

    public int getLeadtype() {
        return leadtype;
    }

    public void setLeadtype(int leadtype) {
        this.leadtype = leadtype;
    }





}
