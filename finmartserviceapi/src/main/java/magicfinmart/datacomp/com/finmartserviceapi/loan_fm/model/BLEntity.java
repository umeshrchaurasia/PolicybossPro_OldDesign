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

    protected BLEntity(Parcel in) {
        Bank_Id = in.readInt();
        Bank_Code = in.readString();
        Bank_Name = in.readString();
        roi = in.readString();
        pf = in.readString();
        pf_type = in.readString();
        Bank_Logo = in.readString();
        processingfee = in.readDouble();
        roi_type = in.readString();
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(Bank_Id);
        dest.writeString(Bank_Code);
        dest.writeString(Bank_Name);
        dest.writeString(roi);
        dest.writeString(pf);
        dest.writeString(pf_type);
        dest.writeString(Bank_Logo);
        dest.writeDouble(processingfee);
        dest.writeString(roi_type);
    }

    @Override
    public int describeContents() {
        return 0;
    }

    public static final Creator<BLEntity> CREATOR = new Creator<BLEntity>() {
        @Override
        public BLEntity createFromParcel(Parcel in) {
            return new BLEntity(in);
        }

        @Override
        public BLEntity[] newArray(int size) {
            return new BLEntity[size];
        }
    };

    public int getBank_Id() {
            return Bank_Id;
        }

        public void setBank_Id(int Bank_Id) {
            this.Bank_Id = Bank_Id;
        }

        public String getBank_Code() {
            return Bank_Code;
        }

        public void setBank_Code(String Bank_Code) {
            this.Bank_Code = Bank_Code;
        }

        public String getBank_Name() {
            return Bank_Name;
        }

        public void setBank_Name(String Bank_Name) {
            this.Bank_Name = Bank_Name;
        }

        public String getRoi() {
            return roi;
        }

        public void setRoi(String roi) {
            this.roi = roi;
        }

        public String getPf() {
            return pf;
        }

        public void setPf(String pf) {
            this.pf = pf;
        }

        public String getPf_type() {
            return pf_type;
        }

        public void setPf_type(String pf_type) {
            this.pf_type = pf_type;
        }

        public String getBank_Logo() {
            return Bank_Logo;
        }

        public void setBank_Logo(String Bank_Logo) {
            this.Bank_Logo = Bank_Logo;
        }

        public double getProcessingfee() {
            return processingfee;
        }

        public void setProcessingfee(double processingfee) {
            this.processingfee = processingfee;
        }

        public String getRoi_type() {
            return roi_type;
        }

        public void setRoi_type(String roi_type) {
            this.roi_type = roi_type;
        }
    }