package magicfinmart.datacomp.com.finmartserviceapi.loan_fm.requestentity;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by IN-RB on 27-01-2018.
 */

public class BLLoanRequest  implements Parcelable {


    /**
     * loanamount : 500000
     * loaninterest : 12.49
     * product_id : 9
     * loanterm : 5
     */

    private int loanamount;
    private double loaninterest;
    private int product_id;
    private int loanterm;

    private String fname;
    private String lname;

    protected BLLoanRequest(Parcel in) {
        loanamount = in.readInt();
        loaninterest = in.readDouble();
        product_id = in.readInt();
        loanterm = in.readInt();
        fname=in.readString();
        lname=in.readString();
    }

    public static final Creator<BLLoanRequest> CREATOR = new Creator<BLLoanRequest>() {
        @Override
        public BLLoanRequest createFromParcel(Parcel in) {
            return new BLLoanRequest(in);
        }

        @Override
        public BLLoanRequest[] newArray(int size) {
            return new BLLoanRequest[size];
        }
    };

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

    public String getFname() {
        return fname;
    }

    public void setFname(String fname) {
        this.fname = fname;
    }

    public String getLname() {
        return lname;
    }

    public void setLname(String lname) {
        this.lname = lname;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(loanamount);
        dest.writeDouble(loaninterest);
        dest.writeInt(product_id);
        dest.writeInt(loanterm);
        dest.writeString(fname);
        dest.writeString(lname);
    }
}
