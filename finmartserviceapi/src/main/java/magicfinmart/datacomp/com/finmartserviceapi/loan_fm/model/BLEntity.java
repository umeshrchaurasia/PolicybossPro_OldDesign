package magicfinmart.datacomp.com.finmartserviceapi.loan_fm.model;

import android.os.Parcel;
import android.os.Parcelable;

public class BLEntity implements Parcelable {

        /**
         * Bank_Id : 33
         * Bank_Code : KOTAK MAHINDRA
         * Bank_Name : KOTAK MAHINDRA BANK
         * roi : 11.49
         * pf : 2.00
         * pf_type : Percentage
         * Bank_Logo : http://erp.rupeeboss.com/Banklogo/kotak.png
         * processingfee : 10000
         * roi_type : Fixed
         */

        private int Bank_Id;
        private String Bank_Code;
        private String Bank_Name;
        private String roi;
        private String pf;
        private String pf_type;
        private String Bank_Logo;
        private double processingfee;
        private String roi_type;

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(this.Bank_Id);
        dest.writeString(this.Bank_Code);
        dest.writeString(this.Bank_Name);
        dest.writeString(this.roi);
        dest.writeString(this.pf);
        dest.writeString(this.pf_type);
        dest.writeString(this.Bank_Logo);
        dest.writeDouble(this.processingfee);
        dest.writeString(this.roi_type);
    }

    public BLEntity() {
    }

    protected BLEntity(Parcel in) {
        this.Bank_Id = in.readInt();
        this.Bank_Code = in.readString();
        this.Bank_Name = in.readString();
        this.roi = in.readString();
        this.pf = in.readString();
        this.pf_type = in.readString();
        this.Bank_Logo = in.readString();
        this.processingfee = in.readDouble();
        this.roi_type = in.readString();
    }

    public static final Parcelable.Creator<BLEntity> CREATOR = new Parcelable.Creator<BLEntity>() {
        @Override
        public BLEntity createFromParcel(Parcel source) {
            return new BLEntity(source);
        }

        @Override
        public BLEntity[] newArray(int size) {
            return new BLEntity[size];
        }
    };
}