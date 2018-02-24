package magicfinmart.datacomp.com.finmartserviceapi.loan_fm.requestentity;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.SerializedName;

/**
 * Created by IN-RB on 27-01-2018.
 */

public class BLLoanRequest implements Parcelable {
    /**
     * loanamount : 500000
     * loaninterest : 12.49
     * product_id : 9
     * loanterm : 5
     * applicantname : test
     * email : test@test.com
     * contact : 1234567890
     * brokerid : 0
     * source : Demo APP
     */

    private int loanamount;
    private double loaninterest;
    private int product_id;
    private int loanterm;
    private String applicantname;
    private String email;
    private String contact;
    private String brokerid;
    private String source;

    public BLLoanRequest() {
    }

    public int getLoanamount() {
        return loanamount;
    }

    public void setLoanamount(int loanamount) {
        this.loanamount = loanamount;
    }

    public double getLoaninterest() {
        return loaninterest;
    }

    public void setLoaninterest(double loaninterest) {
        this.loaninterest = loaninterest;
    }

    public int getProduct_id() {
        return product_id;
    }

    public void setProduct_id(int product_id) {
        this.product_id = product_id;
    }

    public int getLoanterm() {
        return loanterm;
    }

    public void setLoanterm(int loanterm) {
        this.loanterm = loanterm;
    }

    public String getApplicantname() {
        return applicantname;
    }

    public void setApplicantname(String applicantname) {
        this.applicantname = applicantname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getContact() {
        return contact;
    }

    public void setContact(String contact) {
        this.contact = contact;
    }

    public String getBrokerid() {
        return brokerid;
    }

    public void setBrokerid(String brokerid) {
        this.brokerid = brokerid;
    }

    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(this.loanamount);
        dest.writeDouble(this.loaninterest);
        dest.writeInt(this.product_id);
        dest.writeInt(this.loanterm);
        dest.writeString(this.applicantname);
        dest.writeString(this.email);
        dest.writeString(this.contact);
        dest.writeString(this.brokerid);
        dest.writeString(this.source);
    }

    protected BLLoanRequest(Parcel in) {
        this.loanamount = in.readInt();
        this.loaninterest = in.readDouble();
        this.product_id = in.readInt();
        this.loanterm = in.readInt();
        this.applicantname = in.readString();
        this.email = in.readString();
        this.contact = in.readString();
        this.brokerid = in.readString();
        this.source = in.readString();
    }

    public static final Parcelable.Creator<BLLoanRequest> CREATOR = new Parcelable.Creator<BLLoanRequest>() {
        @Override
        public BLLoanRequest createFromParcel(Parcel source) {
            return new BLLoanRequest(source);
        }

        @Override
        public BLLoanRequest[] newArray(int size) {
            return new BLLoanRequest[size];
        }
    };
}
