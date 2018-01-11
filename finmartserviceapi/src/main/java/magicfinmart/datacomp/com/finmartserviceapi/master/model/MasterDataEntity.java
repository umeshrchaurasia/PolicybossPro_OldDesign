package magicfinmart.datacomp.com.finmartserviceapi.master.model;

import io.realm.RealmObject;

public class MasterDataEntity extends RealmObject {
    /**
     * Cubic_Capacity : 5935
     * ExShowroomPrice : 19000000
     * Fuel_ID : 1
     * Make_ID : 1
     * Make_Name : Aston Martin
     * Model_ID : 1
     * Model_ID1 : 1
     * Model_Name : DB9
     * Seating_Capacity : 2
     * Variant_ID : 1
     * Variant_Name : Coupe
     */

    private String Cubic_Capacity;
    private String ExShowroomPrice;
    private int Fuel_ID;
    private int Make_ID;
    private String Make_Name;
    private int Model_ID;
    private int Model_ID1;
    private String Model_Name;
    private String Seating_Capacity;
    private int Variant_ID;
    private String Variant_Name;
    /**
     * Fuel_Name : Petrol
     * Product_Id : 1
     */

    private String Fuel_Name;
    private int Product_Id;

    public String getCubic_Capacity() {
        return Cubic_Capacity;
    }

    public void setCubic_Capacity(String Cubic_Capacity) {
        this.Cubic_Capacity = Cubic_Capacity;
    }

    public String getExShowroomPrice() {
        return ExShowroomPrice;
    }

    public void setExShowroomPrice(String ExShowroomPrice) {
        this.ExShowroomPrice = ExShowroomPrice;
    }

    public int getFuel_ID() {
        return Fuel_ID;
    }

    public void setFuel_ID(int Fuel_ID) {
        this.Fuel_ID = Fuel_ID;
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

    public int getModel_ID() {
        return Model_ID;
    }

    public void setModel_ID(int Model_ID) {
        this.Model_ID = Model_ID;
    }

    public int getModel_ID1() {
        return Model_ID1;
    }

    public void setModel_ID1(int Model_ID1) {
        this.Model_ID1 = Model_ID1;
    }

    public String getModel_Name() {
        return Model_Name;
    }

    public void setModel_Name(String Model_Name) {
        this.Model_Name = Model_Name;
    }

    public String getSeating_Capacity() {
        return Seating_Capacity;
    }

    public void setSeating_Capacity(String Seating_Capacity) {
        this.Seating_Capacity = Seating_Capacity;
    }

    public int getVariant_ID() {
        return Variant_ID;
    }

    public void setVariant_ID(int Variant_ID) {
        this.Variant_ID = Variant_ID;
    }

    public String getVariant_Name() {
        return Variant_Name;
    }

    public void setVariant_Name(String Variant_Name) {
        this.Variant_Name = Variant_Name;
    }

    public String getFuel_Name() {
        return Fuel_Name;
    }

    public void setFuel_Name(String Fuel_Name) {
        this.Fuel_Name = Fuel_Name;
    }

    public int getProduct_Id() {
        return Product_Id;
    }

    public void setProduct_Id(int Product_Id) {
        this.Product_Id = Product_Id;
    }
}