package magicfinmart.datacomp.com.finmartserviceapi.master.response;

import android.os.Parcel;
import android.os.Parcelable;

import magicfinmart.datacomp.com.finmartserviceapi.motor.APIResponse;


public class FastLaneResponse extends APIResponse {


    /**
     * FLResponse : {"Chassis_Number":"MEEJSRGW4F4001351","Color":"A STEEL","Cubic_Capacity":1461,"Engin_Number":"E013652","ErrorMessage":"","FastLaneId":944,"FastLaneResponseVariable":{"chasi_no":"MEEJSRGW4F4001351","color":"ASTEEL","cubic_cap":"1461","eng_no":"E013652","fla_cubic_cap":"1461","fla_fuel_type_desc":"DIESEL","fla_maker_desc":"RENAULT","fla_model_desc":"LODGY","fla_seat_cap":"8","fla_variant":"RXZ","fla_vh_class_desc":"LMV","fuel_type_desc":"DIESEL","maker_desc":"RENAULTNISSANAUTOINDIAP.L","maker_model":"RENAULTLODGYDCIRXZJSRKF7","manu_yr":"2015","purchase_dt":"27/8/2015","regn_dt":"31/8/2015","regn_no":"MH46AP1109","rto_cd":"46","rto_name":"PANVEL","seat_cap":"8","state_cd":"MH","vehicle_cd":"134005030215","vh_class_desc":"L.M.V.(JEEP/GYPSY)"},"Fuel_ID":2,"Fuel_Type":"Diesel","Make_ID":32,"Make_Name":"Renault","Manufacture_Year":"2015","Model_ID":791,"Model_Name":"LODGY","Purchase_Date":"27/8/2015","RTO_Code":46,"RTO_Name":"PANVEL","Registration_Date":"31/8/2015","Registration_Number":"MH46AP1109","Seating_Capacity":8,"Variant_Id":3173,"Variant_Name":"RXZ","VehicleCity_Id":628}
     */

    private FLResponseBean FLResponse;

    public FLResponseBean getFLResponse() {
        return FLResponse;
    }

    public void setFLResponse(FLResponseBean FLResponse) {
        this.FLResponse = FLResponse;
    }

    public static class FLResponseBean implements Parcelable {
        public static final Parcelable.Creator<FLResponseBean> CREATOR = new Parcelable.Creator<FLResponseBean>() {
            @Override
            public FLResponseBean createFromParcel(Parcel source) {
                return new FLResponseBean(source);
            }

            @Override
            public FLResponseBean[] newArray(int size) {
                return new FLResponseBean[size];
            }
        };
        /**
         * Chassis_Number : MEEJSRGW4F4001351
         * Color : A STEEL
         * Cubic_Capacity : 1461
         * Engin_Number : E013652
         * ErrorMessage :
         * FastLaneId : 944
         * FastLaneResponseVariable : {"chasi_no":"MEEJSRGW4F4001351","color":"ASTEEL","cubic_cap":"1461","eng_no":"E013652","fla_cubic_cap":"1461","fla_fuel_type_desc":"DIESEL","fla_maker_desc":"RENAULT","fla_model_desc":"LODGY","fla_seat_cap":"8","fla_variant":"RXZ","fla_vh_class_desc":"LMV","fuel_type_desc":"DIESEL","maker_desc":"RENAULTNISSANAUTOINDIAP.L","maker_model":"RENAULTLODGYDCIRXZJSRKF7","manu_yr":"2015","purchase_dt":"27/8/2015","regn_dt":"31/8/2015","regn_no":"MH46AP1109","rto_cd":"46","rto_name":"PANVEL","seat_cap":"8","state_cd":"MH","vehicle_cd":"134005030215","vh_class_desc":"L.M.V.(JEEP/GYPSY)"}
         * Fuel_ID : 2
         * Fuel_Type : Diesel
         * Make_ID : 32
         * Make_Name : Renault
         * Manufacture_Year : 2015
         * Model_ID : 791
         * Model_Name : LODGY
         * Purchase_Date : 27/8/2015
         * RTO_Code : 46
         * RTO_Name : PANVEL
         * Registration_Date : 31/8/2015
         * Registration_Number : MH46AP1109
         * Seating_Capacity : 8
         * Variant_Id : 3173
         * Variant_Name : RXZ
         * VehicleCity_Id : 628
         */

        private String Chassis_Number;
        private String Color;
        private int Cubic_Capacity;
        private String Engin_Number;
        private String ErrorMessage;
        private int FastLaneId;
        private FastLaneResponseVariableBean FastLaneResponseVariable;
        private int Fuel_ID;
        private String Fuel_Type;
        private int Make_ID;
        private String Make_Name;
        private String Manufacture_Year;
        private int Model_ID;
        private String Model_Name;
        private String Purchase_Date;
        private int RTO_Code;
        private String RTO_Name;
        private String Registration_Date;
        private String Registration_Number;
        private int Seating_Capacity;
        private int Variant_Id;
        private String Variant_Name;
        private int VehicleCity_Id;

        public FLResponseBean() {
        }

        protected FLResponseBean(Parcel in) {
            this.Chassis_Number = in.readString();
            this.Color = in.readString();
            this.Cubic_Capacity = in.readInt();
            this.Engin_Number = in.readString();
            this.ErrorMessage = in.readString();
            this.FastLaneId = in.readInt();
            this.FastLaneResponseVariable = in.readParcelable(FastLaneResponseVariableBean.class.getClassLoader());
            this.Fuel_ID = in.readInt();
            this.Fuel_Type = in.readString();
            this.Make_ID = in.readInt();
            this.Make_Name = in.readString();
            this.Manufacture_Year = in.readString();
            this.Model_ID = in.readInt();
            this.Model_Name = in.readString();
            this.Purchase_Date = in.readString();
            this.RTO_Code = in.readInt();
            this.RTO_Name = in.readString();
            this.Registration_Date = in.readString();
            this.Registration_Number = in.readString();
            this.Seating_Capacity = in.readInt();
            this.Variant_Id = in.readInt();
            this.Variant_Name = in.readString();
            this.VehicleCity_Id = in.readInt();
        }

        public String getChassis_Number() {
            return Chassis_Number;
        }

        public void setChassis_Number(String Chassis_Number) {
            this.Chassis_Number = Chassis_Number;
        }

        public String getColor() {
            return Color;
        }

        public void setColor(String Color) {
            this.Color = Color;
        }

        public int getCubic_Capacity() {
            return Cubic_Capacity;
        }

        public void setCubic_Capacity(int Cubic_Capacity) {
            this.Cubic_Capacity = Cubic_Capacity;
        }

        public String getEngin_Number() {
            return Engin_Number;
        }

        public void setEngin_Number(String Engin_Number) {
            this.Engin_Number = Engin_Number;
        }

        public String getErrorMessage() {
            return ErrorMessage;
        }

        public void setErrorMessage(String ErrorMessage) {
            this.ErrorMessage = ErrorMessage;
        }

        public int getFastLaneId() {
            return FastLaneId;
        }

        public void setFastLaneId(int FastLaneId) {
            this.FastLaneId = FastLaneId;
        }

        public FastLaneResponseVariableBean getFastLaneResponseVariable() {
            return FastLaneResponseVariable;
        }

        public void setFastLaneResponseVariable(FastLaneResponseVariableBean FastLaneResponseVariable) {
            this.FastLaneResponseVariable = FastLaneResponseVariable;
        }

        public int getFuel_ID() {
            return Fuel_ID;
        }

        public void setFuel_ID(int Fuel_ID) {
            this.Fuel_ID = Fuel_ID;
        }

        public String getFuel_Type() {
            return Fuel_Type;
        }

        public void setFuel_Type(String Fuel_Type) {
            this.Fuel_Type = Fuel_Type;
        }

        public int getMake_ID() {
            return Make_ID;
        }

        public void setMake_ID(int Make_ID) {
            this.Make_ID = Make_ID;
        }

        public String getMake_Name() {
            return Make_Name;
        }

        public void setMake_Name(String Make_Name) {
            this.Make_Name = Make_Name;
        }

        public String getManufacture_Year() {
            return Manufacture_Year;
        }

        public void setManufacture_Year(String Manufacture_Year) {
            this.Manufacture_Year = Manufacture_Year;
        }

        public int getModel_ID() {
            return Model_ID;
        }

        public void setModel_ID(int Model_ID) {
            this.Model_ID = Model_ID;
        }

        public String getModel_Name() {
            return Model_Name;
        }

        public void setModel_Name(String Model_Name) {
            this.Model_Name = Model_Name;
        }

        public String getPurchase_Date() {
            return Purchase_Date;
        }

        public void setPurchase_Date(String Purchase_Date) {
            this.Purchase_Date = Purchase_Date;
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

        public String getRegistration_Date() {
            return Registration_Date;
        }

        public void setRegistration_Date(String Registration_Date) {
            this.Registration_Date = Registration_Date;
        }

        public String getRegistration_Number() {
            return Registration_Number;
        }

        public void setRegistration_Number(String Registration_Number) {
            this.Registration_Number = Registration_Number;
        }

        public int getSeating_Capacity() {
            return Seating_Capacity;
        }

        public void setSeating_Capacity(int Seating_Capacity) {
            this.Seating_Capacity = Seating_Capacity;
        }

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

        @Override
        public int describeContents() {
            return 0;
        }

        @Override
        public void writeToParcel(Parcel dest, int flags) {
            dest.writeString(this.Chassis_Number);
            dest.writeString(this.Color);
            dest.writeInt(this.Cubic_Capacity);
            dest.writeString(this.Engin_Number);
            dest.writeString(this.ErrorMessage);
            dest.writeInt(this.FastLaneId);
            dest.writeParcelable(this.FastLaneResponseVariable, flags);
            dest.writeInt(this.Fuel_ID);
            dest.writeString(this.Fuel_Type);
            dest.writeInt(this.Make_ID);
            dest.writeString(this.Make_Name);
            dest.writeString(this.Manufacture_Year);
            dest.writeInt(this.Model_ID);
            dest.writeString(this.Model_Name);
            dest.writeString(this.Purchase_Date);
            dest.writeInt(this.RTO_Code);
            dest.writeString(this.RTO_Name);
            dest.writeString(this.Registration_Date);
            dest.writeString(this.Registration_Number);
            dest.writeInt(this.Seating_Capacity);
            dest.writeInt(this.Variant_Id);
            dest.writeString(this.Variant_Name);
            dest.writeInt(this.VehicleCity_Id);
        }

        public static class FastLaneResponseVariableBean implements Parcelable {
            public static final Creator<FastLaneResponseVariableBean> CREATOR = new Creator<FastLaneResponseVariableBean>() {
                @Override
                public FastLaneResponseVariableBean createFromParcel(Parcel source) {
                    return new FastLaneResponseVariableBean(source);
                }

                @Override
                public FastLaneResponseVariableBean[] newArray(int size) {
                    return new FastLaneResponseVariableBean[size];
                }
            };
            /**
             * chasi_no : MEEJSRGW4F4001351
             * color : ASTEEL
             * cubic_cap : 1461
             * eng_no : E013652
             * fla_cubic_cap : 1461
             * fla_fuel_type_desc : DIESEL
             * fla_maker_desc : RENAULT
             * fla_model_desc : LODGY
             * fla_seat_cap : 8
             * fla_variant : RXZ
             * fla_vh_class_desc : LMV
             * fuel_type_desc : DIESEL
             * maker_desc : RENAULTNISSANAUTOINDIAP.L
             * maker_model : RENAULTLODGYDCIRXZJSRKF7
             * manu_yr : 2015
             * purchase_dt : 27/8/2015
             * regn_dt : 31/8/2015
             * regn_no : MH46AP1109
             * rto_cd : 46
             * rto_name : PANVEL
             * seat_cap : 8
             * state_cd : MH
             * vehicle_cd : 134005030215
             * vh_class_desc : L.M.V.(JEEP/GYPSY)
             */

            private String chasi_no;
            private String color;
            private String cubic_cap;
            private String eng_no;
            private String fla_cubic_cap;
            private String fla_fuel_type_desc;
            private String fla_maker_desc;
            private String fla_model_desc;
            private String fla_seat_cap;
            private String fla_variant;
            private String fla_vh_class_desc;
            private String fuel_type_desc;
            private String maker_desc;
            private String maker_model;
            private String manu_yr;
            private String purchase_dt;
            private String regn_dt;
            private String regn_no;
            private String rto_cd;
            private String rto_name;
            private String seat_cap;
            private String state_cd;
            private String vehicle_cd;
            private String vh_class_desc;

            public FastLaneResponseVariableBean() {
            }

            protected FastLaneResponseVariableBean(Parcel in) {
                this.chasi_no = in.readString();
                this.color = in.readString();
                this.cubic_cap = in.readString();
                this.eng_no = in.readString();
                this.fla_cubic_cap = in.readString();
                this.fla_fuel_type_desc = in.readString();
                this.fla_maker_desc = in.readString();
                this.fla_model_desc = in.readString();
                this.fla_seat_cap = in.readString();
                this.fla_variant = in.readString();
                this.fla_vh_class_desc = in.readString();
                this.fuel_type_desc = in.readString();
                this.maker_desc = in.readString();
                this.maker_model = in.readString();
                this.manu_yr = in.readString();
                this.purchase_dt = in.readString();
                this.regn_dt = in.readString();
                this.regn_no = in.readString();
                this.rto_cd = in.readString();
                this.rto_name = in.readString();
                this.seat_cap = in.readString();
                this.state_cd = in.readString();
                this.vehicle_cd = in.readString();
                this.vh_class_desc = in.readString();
            }

            public String getChasi_no() {
                return chasi_no;
            }

            public void setChasi_no(String chasi_no) {
                this.chasi_no = chasi_no;
            }

            public String getColor() {
                return color;
            }

            public void setColor(String color) {
                this.color = color;
            }

            public String getCubic_cap() {
                return cubic_cap;
            }

            public void setCubic_cap(String cubic_cap) {
                this.cubic_cap = cubic_cap;
            }

            public String getEng_no() {
                return eng_no;
            }

            public void setEng_no(String eng_no) {
                this.eng_no = eng_no;
            }

            public String getFla_cubic_cap() {
                return fla_cubic_cap;
            }

            public void setFla_cubic_cap(String fla_cubic_cap) {
                this.fla_cubic_cap = fla_cubic_cap;
            }

            public String getFla_fuel_type_desc() {
                return fla_fuel_type_desc;
            }

            public void setFla_fuel_type_desc(String fla_fuel_type_desc) {
                this.fla_fuel_type_desc = fla_fuel_type_desc;
            }

            public String getFla_maker_desc() {
                return fla_maker_desc;
            }

            public void setFla_maker_desc(String fla_maker_desc) {
                this.fla_maker_desc = fla_maker_desc;
            }

            public String getFla_model_desc() {
                return fla_model_desc;
            }

            public void setFla_model_desc(String fla_model_desc) {
                this.fla_model_desc = fla_model_desc;
            }

            public String getFla_seat_cap() {
                return fla_seat_cap;
            }

            public void setFla_seat_cap(String fla_seat_cap) {
                this.fla_seat_cap = fla_seat_cap;
            }

            public String getFla_variant() {
                return fla_variant;
            }

            public void setFla_variant(String fla_variant) {
                this.fla_variant = fla_variant;
            }

            public String getFla_vh_class_desc() {
                return fla_vh_class_desc;
            }

            public void setFla_vh_class_desc(String fla_vh_class_desc) {
                this.fla_vh_class_desc = fla_vh_class_desc;
            }

            public String getFuel_type_desc() {
                return fuel_type_desc;
            }

            public void setFuel_type_desc(String fuel_type_desc) {
                this.fuel_type_desc = fuel_type_desc;
            }

            public String getMaker_desc() {
                return maker_desc;
            }

            public void setMaker_desc(String maker_desc) {
                this.maker_desc = maker_desc;
            }

            public String getMaker_model() {
                return maker_model;
            }

            public void setMaker_model(String maker_model) {
                this.maker_model = maker_model;
            }

            public String getManu_yr() {
                return manu_yr;
            }

            public void setManu_yr(String manu_yr) {
                this.manu_yr = manu_yr;
            }

            public String getPurchase_dt() {
                return purchase_dt;
            }

            public void setPurchase_dt(String purchase_dt) {
                this.purchase_dt = purchase_dt;
            }

            public String getRegn_dt() {
                return regn_dt;
            }

            public void setRegn_dt(String regn_dt) {
                this.regn_dt = regn_dt;
            }

            public String getRegn_no() {
                return regn_no;
            }

            public void setRegn_no(String regn_no) {
                this.regn_no = regn_no;
            }

            public String getRto_cd() {
                return rto_cd;
            }

            public void setRto_cd(String rto_cd) {
                this.rto_cd = rto_cd;
            }

            public String getRto_name() {
                return rto_name;
            }

            public void setRto_name(String rto_name) {
                this.rto_name = rto_name;
            }

            public String getSeat_cap() {
                return seat_cap;
            }

            public void setSeat_cap(String seat_cap) {
                this.seat_cap = seat_cap;
            }

            public String getState_cd() {
                return state_cd;
            }

            public void setState_cd(String state_cd) {
                this.state_cd = state_cd;
            }

            public String getVehicle_cd() {
                return vehicle_cd;
            }

            public void setVehicle_cd(String vehicle_cd) {
                this.vehicle_cd = vehicle_cd;
            }

            public String getVh_class_desc() {
                return vh_class_desc;
            }

            public void setVh_class_desc(String vh_class_desc) {
                this.vh_class_desc = vh_class_desc;
            }

            @Override
            public int describeContents() {
                return 0;
            }

            @Override
            public void writeToParcel(Parcel dest, int flags) {
                dest.writeString(this.chasi_no);
                dest.writeString(this.color);
                dest.writeString(this.cubic_cap);
                dest.writeString(this.eng_no);
                dest.writeString(this.fla_cubic_cap);
                dest.writeString(this.fla_fuel_type_desc);
                dest.writeString(this.fla_maker_desc);
                dest.writeString(this.fla_model_desc);
                dest.writeString(this.fla_seat_cap);
                dest.writeString(this.fla_variant);
                dest.writeString(this.fla_vh_class_desc);
                dest.writeString(this.fuel_type_desc);
                dest.writeString(this.maker_desc);
                dest.writeString(this.maker_model);
                dest.writeString(this.manu_yr);
                dest.writeString(this.purchase_dt);
                dest.writeString(this.regn_dt);
                dest.writeString(this.regn_no);
                dest.writeString(this.rto_cd);
                dest.writeString(this.rto_name);
                dest.writeString(this.seat_cap);
                dest.writeString(this.state_cd);
                dest.writeString(this.vehicle_cd);
                dest.writeString(this.vh_class_desc);
            }
        }
    }
}
