package magicfinmart.datacomp.com.finmartserviceapi.finmart.model;

import android.os.Parcel;
import android.os.Parcelable;

public  class FastLaneDataEntity implements Parcelable {
        /**
         * Variant_Id : 4659
         * Variant_Name : CS GLX
         * VehicleCity_Id : 582
         * FastLaneId : 7172
         * Make_ID : 25
         * Model_ID : 202
         * Fuel_ID : 1
         * Make_Name : Tata
         * Model_Name : Indigo CS
         * Fuel_Type : Petrol
         * Seating_Capacity : 5
         * Cubic_Capacity : 1193
         * Manufacture_Year : 2010
         * Color : S GOLD
         * Registration_Number : MH04EQ2620
         * RTO_Code : 4
         * RTO_Name : THANE
         * Chassis_Number : MAT601652AWJ39560
         * Engin_Number : 475SI72JZYP76208
         * Registration_Date : 30/10/2010
         * Purchase_Date : 27/10/2010
         * ErrorMessage : 
         * FastlaneResponse : {"regn_no":"MH04EQ2620","state_cd":"MH","rto_cd":"4","rto_name":"THANE","chasi_no":"MAT601652AWJ39560","eng_no":"475SI72JZYP76208","regn_dt":"30/10/2010","purchase_dt":"27/10/2010","vh_class_desc":"LMV","fla_vh_class_desc":"LMV","vehicle_cd":"138004030108","maker_desc":"TMLTATAMOTORSLTD","fla_maker_desc":"TATA","maker_model":"INDIGOCSEGLXMPFIBSIV","fla_model_desc":"INDIGO","fla_variant":"CSGLX","color":"SGOLD","fuel_type_desc":"PETROL","fla_fuel_type_desc":"PETROL","cubic_cap":"1193","fla_cubic_cap":"1193","manu_yr":"2010","seat_cap":"5","fla_seat_cap":"5"}
         * FastlanePostResponse : 
         */

        private int Variant_Id;
        private String Variant_Name;
        private int VehicleCity_Id;
        private int FastLaneId;
        private int Make_ID;
        private int Model_ID;
        private int Fuel_ID;
        private String Make_Name;
        private String Model_Name;
        private String Fuel_Type;
        private int Seating_Capacity;
        private int Cubic_Capacity;
        private String Manufacture_Year;
        private String Color;
        private String Registration_Number;
        private int RTO_Code;
        private String RTO_Name;
        private String Chassis_Number;
        private String Engin_Number;
        private String Registration_Date;
        private String Purchase_Date;
        private String ErrorMessage;
        private String FastlaneResponse;
        private String FastlanePostResponse;

        public int getVariant_Id() {
            return Variant_Id;
        }

        public void setVariant_Id(int Variant_Id) {
            this.Variant_Id = Variant_Id;
        }

        public String getVariant_Name() {
            return Variant_Name;
        }

        public void setVariant_Name(String Variant_Name) {
            this.Variant_Name = Variant_Name;
        }

        public int getVehicleCity_Id() {
            return VehicleCity_Id;
        }

        public void setVehicleCity_Id(int VehicleCity_Id) {
            this.VehicleCity_Id = VehicleCity_Id;
        }

        public int getFastLaneId() {
            return FastLaneId;
        }

        public void setFastLaneId(int FastLaneId) {
            this.FastLaneId = FastLaneId;
        }

        public int getMake_ID() {
            return Make_ID;
        }

        public void setMake_ID(int Make_ID) {
            this.Make_ID = Make_ID;
        }

        public int getModel_ID() {
            return Model_ID;
        }

        public void setModel_ID(int Model_ID) {
            this.Model_ID = Model_ID;
        }

        public int getFuel_ID() {
            return Fuel_ID;
        }

        public void setFuel_ID(int Fuel_ID) {
            this.Fuel_ID = Fuel_ID;
        }

        public String getMake_Name() {
            return Make_Name;
        }

        public void setMake_Name(String Make_Name) {
            this.Make_Name = Make_Name;
        }

        public String getModel_Name() {
            return Model_Name;
        }

        public void setModel_Name(String Model_Name) {
            this.Model_Name = Model_Name;
        }

        public String getFuel_Type() {
            return Fuel_Type;
        }

        public void setFuel_Type(String Fuel_Type) {
            this.Fuel_Type = Fuel_Type;
        }

        public int getSeating_Capacity() {
            return Seating_Capacity;
        }

        public void setSeating_Capacity(int Seating_Capacity) {
            this.Seating_Capacity = Seating_Capacity;
        }

        public int getCubic_Capacity() {
            return Cubic_Capacity;
        }

        public void setCubic_Capacity(int Cubic_Capacity) {
            this.Cubic_Capacity = Cubic_Capacity;
        }

        public String getManufacture_Year() {
            return Manufacture_Year;
        }

        public void setManufacture_Year(String Manufacture_Year) {
            this.Manufacture_Year = Manufacture_Year;
        }

        public String getColor() {
            return Color;
        }

        public void setColor(String Color) {
            this.Color = Color;
        }

        public String getRegistration_Number() {
            return Registration_Number;
        }

        public void setRegistration_Number(String Registration_Number) {
            this.Registration_Number = Registration_Number;
        }

        public int getRTO_Code() {
            return RTO_Code;
        }

        public void setRTO_Code(int RTO_Code) {
            this.RTO_Code = RTO_Code;
        }

        public String getRTO_Name() {
            return RTO_Name;
        }

        public void setRTO_Name(String RTO_Name) {
            this.RTO_Name = RTO_Name;
        }

        public String getChassis_Number() {
            return Chassis_Number;
        }

        public void setChassis_Number(String Chassis_Number) {
            this.Chassis_Number = Chassis_Number;
        }

        public String getEngin_Number() {
            return Engin_Number;
        }

        public void setEngin_Number(String Engin_Number) {
            this.Engin_Number = Engin_Number;
        }

        public String getRegistration_Date() {
            return Registration_Date;
        }

        public void setRegistration_Date(String Registration_Date) {
            this.Registration_Date = Registration_Date;
        }

        public String getPurchase_Date() {
            return Purchase_Date;
        }

        public void setPurchase_Date(String Purchase_Date) {
            this.Purchase_Date = Purchase_Date;
        }

        public String getErrorMessage() {
            return ErrorMessage;
        }

        public void setErrorMessage(String ErrorMessage) {
            this.ErrorMessage = ErrorMessage;
        }

        public String getFastlaneResponse() {
            return FastlaneResponse;
        }

        public void setFastlaneResponse(String FastlaneResponse) {
            this.FastlaneResponse = FastlaneResponse;
        }

        public String getFastlanePostResponse() {
            return FastlanePostResponse;
        }

        public void setFastlanePostResponse(String FastlanePostResponse) {
            this.FastlanePostResponse = FastlanePostResponse;
        }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(this.Variant_Id);
        dest.writeString(this.Variant_Name);
        dest.writeInt(this.VehicleCity_Id);
        dest.writeInt(this.FastLaneId);
        dest.writeInt(this.Make_ID);
        dest.writeInt(this.Model_ID);
        dest.writeInt(this.Fuel_ID);
        dest.writeString(this.Make_Name);
        dest.writeString(this.Model_Name);
        dest.writeString(this.Fuel_Type);
        dest.writeInt(this.Seating_Capacity);
        dest.writeInt(this.Cubic_Capacity);
        dest.writeString(this.Manufacture_Year);
        dest.writeString(this.Color);
        dest.writeString(this.Registration_Number);
        dest.writeInt(this.RTO_Code);
        dest.writeString(this.RTO_Name);
        dest.writeString(this.Chassis_Number);
        dest.writeString(this.Engin_Number);
        dest.writeString(this.Registration_Date);
        dest.writeString(this.Purchase_Date);
        dest.writeString(this.ErrorMessage);
        dest.writeString(this.FastlaneResponse);
        dest.writeString(this.FastlanePostResponse);
    }

    public FastLaneDataEntity() {
    }

    protected FastLaneDataEntity(Parcel in) {
        this.Variant_Id = in.readInt();
        this.Variant_Name = in.readString();
        this.VehicleCity_Id = in.readInt();
        this.FastLaneId = in.readInt();
        this.Make_ID = in.readInt();
        this.Model_ID = in.readInt();
        this.Fuel_ID = in.readInt();
        this.Make_Name = in.readString();
        this.Model_Name = in.readString();
        this.Fuel_Type = in.readString();
        this.Seating_Capacity = in.readInt();
        this.Cubic_Capacity = in.readInt();
        this.Manufacture_Year = in.readString();
        this.Color = in.readString();
        this.Registration_Number = in.readString();
        this.RTO_Code = in.readInt();
        this.RTO_Name = in.readString();
        this.Chassis_Number = in.readString();
        this.Engin_Number = in.readString();
        this.Registration_Date = in.readString();
        this.Purchase_Date = in.readString();
        this.ErrorMessage = in.readString();
        this.FastlaneResponse = in.readString();
        this.FastlanePostResponse = in.readString();
    }

    public static final Parcelable.Creator<FastLaneDataEntity> CREATOR = new Parcelable.Creator<FastLaneDataEntity>() {
        @Override
        public FastLaneDataEntity createFromParcel(Parcel source) {
            return new FastLaneDataEntity(source);
        }

        @Override
        public FastLaneDataEntity[] newArray(int size) {
            return new FastLaneDataEntity[size];
        }
    };
}