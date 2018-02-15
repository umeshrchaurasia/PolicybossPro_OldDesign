package magicfinmart.datacomp.com.finmartserviceapi.database;

import android.content.Context;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import io.realm.Realm;
import magicfinmart.datacomp.com.finmartserviceapi.R;
import magicfinmart.datacomp.com.finmartserviceapi.finmart.model.BikeMasterEntity;
import magicfinmart.datacomp.com.finmartserviceapi.finmart.model.CarMasterEntity;
import magicfinmart.datacomp.com.finmartserviceapi.finmart.model.CityMasterEntity;
import magicfinmart.datacomp.com.finmartserviceapi.finmart.model.GeneralinsuranceEntity;
import magicfinmart.datacomp.com.finmartserviceapi.finmart.model.HealthinsuranceEntity;
import magicfinmart.datacomp.com.finmartserviceapi.finmart.model.LifeinsuranceEntity;
import magicfinmart.datacomp.com.finmartserviceapi.finmart.model.LoginResponseEntity;
import magicfinmart.datacomp.com.finmartserviceapi.model.DashboardEntity;
import magicfinmart.datacomp.com.finmartserviceapi.model.HealthSumAssured;
import magicfinmart.datacomp.com.finmartserviceapi.model.PropertyInfoEntity;

/**
 * Created by Rajeev Ranjan on 04/01/2018.
 */

public class DBPersistanceController {

    private static final String EXTERNAL_LPG = "External Fitted LPG";
    private static final String EXTERNAL_CNG = "External Fitted CNG";
    Map<String, Integer> hashMapInsurence;
    HashMap<String, String> hashMapAddons;
    HashMap<Integer, Integer> hasMapCarInsuranceImage;
    Context mContext;
    Realm realm;

    public DBPersistanceController(Context mContext) {
        this.mContext = mContext;
        realm = Realm.getDefaultInstance();
    }

    //region RTO

    public ArrayList<String> getRTOListNames() {
        List<CityMasterEntity> list_Make = realm.where(CityMasterEntity.class).findAll();
        ArrayList listCity = new ArrayList();
        for (int i = 0; i < list_Make.size(); i++) {
            //listCity.add(list_Make.get(i).getRTO_CodeDiscription());
            //listCity.add(list_Make.get(i).getRTO_City());
            listCity.add(list_Make.get(i).getVehicleCity_RTOCode() + " - " + list_Make.get(i).getRTO_City());
        }
        return listCity;
    }


    public String getCityID(String cityName) {

        CityMasterEntity entity = realm.where(CityMasterEntity.class)
                .equalTo("RTO_City", cityName).findFirst();
        if (entity != null)
            return entity.getVehicleCity_Id();
        else
            return "";

    }

    public String getRTOCityName(String VehicleCity_Id) {

        CityMasterEntity entity = realm.where(CityMasterEntity.class)
                .equalTo("VehicleCity_Id", VehicleCity_Id).findFirst();

        if (entity != null)
            return entity.getVehicleCity_RTOCode() + " - " + entity.getRTO_City();
        else
            return "";

    }

    public CityMasterEntity getVehicleCity_Id(String RTO_City) {

        CityMasterEntity entity = realm.where(CityMasterEntity.class)
                .equalTo("RTO_City", RTO_City).findFirst();

        if (entity != null)
            return entity;
        else
            return null;

    }
    //endregion

    //region master car

    public List<String> getCarMakeModel() {
        List<String> listCarModel = new ArrayList<>();
        // List<ModelMasterEntity> listModelMaster = dbController.getMasterModel();
        List<CarMasterEntity> list = realm.where(CarMasterEntity.class).distinct("Model_ID");

        for (int i = 0; i < list.size(); i++) {
            CarMasterEntity entity = list.get(i);
            String carModel = entity.getMake_Name() + " , " + entity.getModel_Name();
            listCarModel.add(carModel);
        }

        return listCarModel;
    }

    public List<String> getMake() {
        List<String> listCarMake = new ArrayList<>();
        List<CarMasterEntity> list = realm.where(CarMasterEntity.class).distinct("Make_Name");
        for (int i = 0; i < list.size(); i++) {
            CarMasterEntity entity = list.get(i);
            String carModel = entity.getMake_Name();
            listCarMake.add(carModel);
        }

        return listCarMake;
    }

    public List<String> getModel(String makeName) {

        List<String> listCarModel = new ArrayList<>();
        List<CarMasterEntity> list = realm.where(CarMasterEntity.class).equalTo("Make_Name", makeName.trim())
                .distinctValues("Model_Name")
                .findAll();
        for (int i = 0; i < list.size(); i++) {
            CarMasterEntity entity = list.get(i);
            String carModel = entity.getModel_Name();
            listCarModel.add(carModel);
        }
        return listCarModel;
    }

    public String getModelID(String modelName) {
        CarMasterEntity entity = realm.where(CarMasterEntity.class).equalTo("Model_Name", modelName.trim()).findFirst();
        if (entity != null)
            return entity.getModel_ID();
        else
            return "";
    }

    public List<String> getVariant(String make, String model, String fuelname) {

        List<String> listCarVariant = new ArrayList<>();
        List<CarMasterEntity> list = new ArrayList<>();
        listCarVariant.add("Varient");
        if (fuelname.equals("Petrol") || fuelname.equals("Diesel") || fuelname.equals("CNG")) {

            list = realm.where(CarMasterEntity.class)
                    .equalTo("Make_Name", make.trim())
                    .equalTo("Model_Name", model.trim())
                    .equalTo("Fuel_Name", fuelname.trim())
                    .distinct("Variant_ID");

        } else {
            list = realm.where(CarMasterEntity.class)
                    .equalTo("Make_Name", make.trim())
                    .equalTo("Model_Name", model.trim())
                    .equalTo("Fuel_Name", "Petrol")
                    .distinct("Variant_ID");
        }

        for (int i = 0; i < list.size(); i++) {
            CarMasterEntity entity = list.get(i);
            String variant = entity.getVariant_Name();
            listCarVariant.add(variant);
        }
        return listCarVariant;

    }

    public List<String> getVariantbyModelID(String modelID) {

        List<String> listCarVariant = new ArrayList<>();
        listCarVariant.add("Varient");
        List<CarMasterEntity> list = realm.where(CarMasterEntity.class)
                .equalTo("Model_ID", modelID)
                .distinct("Variant_ID");

        for (int i = 0; i < list.size(); i++) {
            CarMasterEntity entity = list.get(i);
            String variant = entity.getVariant_Name();
            listCarVariant.add(variant);
        }

        return listCarVariant;

    }

    public String getVarientCC(String make, String model, String varientName) {
        CarMasterEntity entity = realm.where(CarMasterEntity.class).equalTo("Make_Name", make.trim())
                .equalTo("Model_Name", model.trim())
                .equalTo("Variant_Name", varientName.trim()).findFirst();
        if (entity != null)
            return entity.getCubic_Capacity() + "CC";
        else
            return "";
    }

    public String getVariantID(String variantName, String modelName, String makeName) {
        CarMasterEntity entity = realm.where(CarMasterEntity.class).equalTo("Model_Name", modelName.trim())
                .equalTo("Variant_Name", variantName.trim())
                .equalTo("Make_Name", makeName.trim()).findFirst();

        if (entity != null)
            return entity.getVariant_ID();
        else
            return "";
    }

    public CarMasterEntity getVarientDetails(String varientId) {
        CarMasterEntity entity = realm.where(CarMasterEntity.class)
                .equalTo("Variant_ID", varientId).findFirst();

        if (entity != null)
            return entity;
        else
            return null;
    }

    //endregion

    //region fuel

    public List<String> getFuelTypeByModelId(String modelID) {
        List<String> fuelType = new ArrayList<>();
        fuelType.add("Fuel Type");
        List<CarMasterEntity> list = realm.where(CarMasterEntity.class)
                .equalTo("Model_ID", modelID)
                .distinct("Fuel_ID");

        for (int i = 0; i < list.size(); i++) {
            CarMasterEntity entity = list.get(i);
            String fuelName = "" + entity.getFuel_Name();
            fuelType.add(fuelName);
        }

        boolean isAddExternal = false;
        for (int i = 0; i < fuelType.size(); i++) {
            if (fuelType.get(i).equals("Petrol")) {
                isAddExternal = true;
                break;
            }
        }

        if (isAddExternal) {
            fuelType.add(EXTERNAL_LPG);
            fuelType.add(EXTERNAL_CNG);
        }

        return fuelType;
    }


    //endregion

    //region master Bike

    public List<String> getBikeMakeModel() {
        List<String> listCarModel = new ArrayList<>();
        // List<ModelMasterEntity> listModelMaster = dbController.getMasterModel();
        List<BikeMasterEntity> list = realm.where(BikeMasterEntity.class).distinct("Model_ID");

        for (int i = 0; i < list.size(); i++) {
            BikeMasterEntity entity = list.get(i);
            String carModel = entity.getMake_Name() + " , " + entity.getModel_Name();
            listCarModel.add(carModel);
        }

        return listCarModel;
    }

    public String getBikeVarientCC(String make, String model, String varientName) {
        BikeMasterEntity entity = realm.where(BikeMasterEntity.class)
                .equalTo("Make_Name", make.trim())
                .equalTo("Model_Name", model.trim())
                .equalTo("Variant_Name", varientName.trim()).findFirst();
        if (entity != null)
            return entity.getCubic_Capacity() + "CC";
        else
            return "";
    }

    public String getBikeVarient(String varientName, String model ,String make) {
        BikeMasterEntity entity = realm.where(BikeMasterEntity.class)
                .equalTo("Make_Name", make.trim())
                .equalTo("Model_Name", model.trim())
                .equalTo("Variant_Name", varientName.trim()).findFirst();
        if (entity != null)
            return entity.getVariant_ID();
        else
            return "";
    }

    public BikeMasterEntity getBikeVarientDetails(String varientId) {
        BikeMasterEntity entity = realm.where(BikeMasterEntity.class)
                .equalTo("Variant_ID", varientId).findFirst();

        if (entity != null)
            return entity;
        else
            return null;
    }

    public String getBikeModelID(String modelName) {
        BikeMasterEntity entity = realm.where(BikeMasterEntity.class).equalTo("Model_Name", modelName.trim()).findFirst();
        if (entity != null)
            return entity.getModel_ID();
        else
            return "";
    }

    public List<String> getBikeVariantbyModelID(String modelID) {

        List<String> listCarVariant = new ArrayList<>();
        listCarVariant.add("Varient");
        List<BikeMasterEntity> list = realm.where(BikeMasterEntity.class)
                .equalTo("Model_ID", modelID)
                .distinct("Variant_ID");

        for (int i = 0; i < list.size(); i++) {
            BikeMasterEntity entity = list.get(i);
            String variant = entity.getVariant_Name() /*+ " , ( " + entity.getCubic_Capacity() + "CC )"*/;
            listCarVariant.add(variant);
        }

        return listCarVariant;

    }

    //endregion

    //region master insurance

    public ArrayList<String> getHealthListNames() {
        List<HealthinsuranceEntity> list_Make = realm.where(HealthinsuranceEntity.class).findAll();
        ArrayList listCity = new ArrayList();
        for (int i = 0; i < list_Make.size(); i++) {
            listCity.add(list_Make.get(i).getInsuShorName());
        }
        return listCity;
    }

    public List<HealthinsuranceEntity> getHealthList() {
        return realm.where(HealthinsuranceEntity.class).findAll();
    }

    public String getHealthListId(List<String> strings) {
        String text = "";
        for (String s : strings) {
            HealthinsuranceEntity entity = realm.where(HealthinsuranceEntity.class).equalTo("InsuShorName", s.trim()).findFirst();
            if (text.isEmpty()) {
                text = text + entity.getInsuID();
            } else {
                text = text + "," + entity.getInsuID();
            }
        }
        return text;
    }


    public ArrayList<String> getGeneralListNames() {
        List<GeneralinsuranceEntity> list_Make = realm.where(GeneralinsuranceEntity.class).findAll();
        ArrayList listCity = new ArrayList();
        for (int i = 0; i < list_Make.size(); i++) {
            listCity.add(list_Make.get(i).getInsuShorName());
        }
        return listCity;
    }

    public List<GeneralinsuranceEntity> getGeneralList() {
        return realm.where(GeneralinsuranceEntity.class).findAll();
    }

    public String getGeneralListId(List<String> strings) {
        String text = "";
        for (String s : strings) {
            GeneralinsuranceEntity entity = realm.where(GeneralinsuranceEntity.class).equalTo("InsuShorName", s.trim()).findFirst();
            if (text.isEmpty()) {
                text = text + entity.getInsuID();
            } else {
                text = text + "," + entity.getInsuID();
            }
        }
        return text;
    }


    public ArrayList<String> getLifeListNames() {
        List<LifeinsuranceEntity> list_Make = realm.where(LifeinsuranceEntity.class).findAll();
        ArrayList listCity = new ArrayList();
        for (int i = 0; i < list_Make.size(); i++) {
            listCity.add(list_Make.get(i).getInsuShorName());
        }
        return listCity;
    }

    public String getlifeListId(List<String> strings) {
        String text = "";
        for (String s : strings) {
            LifeinsuranceEntity entity = realm.where(LifeinsuranceEntity.class).equalTo("InsuShorName", s.trim()).findFirst();
            if (text.isEmpty()) {
                text = text + entity.getInsuID();
            } else {
                text = text + "," + entity.getInsuID();
            }
        }
        return text;
    }

    //endregion

    //region Dashboard list

    public List<DashboardEntity> getInsurProductList() {
        List<DashboardEntity> dashboardEntities = new ArrayList<DashboardEntity>();
        dashboardEntities.add(new DashboardEntity("INSURANCE", 1, "PRIVATE CAR", "Best quotes for Private Car Insurance of your customers with instant policy.", R.drawable.private_car));
        dashboardEntities.add(new DashboardEntity("INSURANCE", 10, "TWO WHEELER", "Best quotes for Two Wheeler Insurance of your customers with instant policy.", R.drawable.two_wheeler));
        dashboardEntities.add(new DashboardEntity("INSURANCE", 3, "HEALTH INSURANCE", "Get quotes and compare benefits of health insurance from top insurance companies.", R.drawable.health_insurance));

        return dashboardEntities;
    }

    public List<DashboardEntity> getLoanProductList() {
        List<DashboardEntity> dashboardEntities = new ArrayList<DashboardEntity>();
        dashboardEntities.add(new DashboardEntity("LOANS", 4, "HOME LOAN", "Get best deals for Home Loan for your customers from over 20 providers.", R.drawable.home_loan));
        dashboardEntities.add(new DashboardEntity("LOANS", 5, "PERSONAL LOAN", "Get best deals for Personal Loan for your customers from over 20 providers.", R.drawable.personal_loan));
        dashboardEntities.add(new DashboardEntity("LOANS", 6, "LOAN AGAINST PROPERTY", "Offer loans against property at attractive rates to your customers", R.drawable.loan_against_property));
        dashboardEntities.add(new DashboardEntity("LOANS", 7, "CREDIT CARD", "Get lowest rate loan on your Credit Card from wide range of banks.", R.drawable.credit_card));
        dashboardEntities.add(new DashboardEntity("LOANS", 8, "BALANCE TRANSFER", "Save huge money for your customers on their existing loans.", R.drawable.balance_transfer));
        dashboardEntities.add(new DashboardEntity("LOANS", 9, "OTHER LOAN", "Get best deals for other Loans for your customers from over 20 providers.", R.drawable.quick_lead));

        return dashboardEntities;
    }

    public List<DashboardEntity> getMoreProductList() {
        List<DashboardEntity> dashboardEntities = new ArrayList<DashboardEntity>();

        dashboardEntities.add(new DashboardEntity("MORE SERVICES", 2, "FIN-PEACE", "A must for all your customers. A unique BEYOND LIFE services for your customer's peace of mind", R.drawable.fin_peace));
        dashboardEntities.add(new DashboardEntity("MORE SERVICES", 11, "HEALTH CHECK UP PLANS", "Offer a wide array of health check up plans from reputed diagnostics labs at discounted prices and free home collection", R.drawable.health_checkup_plan));

        return dashboardEntities;
    }

    //endregion

    //region previous insurer

    public List<String> getInsurerList() {
        MapInsurence();
        ArrayList<String> insurenceList = new ArrayList<String>(hashMapInsurence.keySet());
        insurenceList.add(0, "Prev Insurer");
        return insurenceList;

    }

    public void MapInsurence() {
        hashMapInsurence = new TreeMap<String, Integer>();
        hashMapInsurence.put("Bajaj", 1);
        hashMapInsurence.put("Bharti", 2);
        hashMapInsurence.put("HDFC", 5);
        hashMapInsurence.put("ICICI", 6);
        hashMapInsurence.put("IFFCO", 7);
        hashMapInsurence.put("Kotak", 30);
        hashMapInsurence.put("L & T Ins. ", 15);
        hashMapInsurence.put("Liberty Videocon", 33);
        hashMapInsurence.put("Magma", 35);
        hashMapInsurence.put("National ", 8);
        hashMapInsurence.put("New India", 12);
        hashMapInsurence.put("Oriental", 13);
        hashMapInsurence.put("Raheja", 16);
        hashMapInsurence.put("Reliance", 9);
        hashMapInsurence.put("Sundaram", 10);
        hashMapInsurence.put("SBI General ", 17);
        hashMapInsurence.put("Shriram ", 18);
        hashMapInsurence.put("Tata AIG", 11);
        hashMapInsurence.put("United", 14);

        /*
            Following not shown in FINMART
        hashMapInsurence.put("Future Gen", 4);
        hashMapInsurence.put("Universal", 19);
        hashMapInsurence.put("Cholamandalam", 3);
        hashMapInsurence.put("Star Health Insurance", 26);
        hashMapInsurence.put("Religare Health Insurance", 34);
  */

    }

    public String getInsurername(int insurerID) {
        MapInsurence();
        String insName = "";
        for (Map.Entry<String, Integer> entity : hashMapInsurence.entrySet()) {
            if (entity.getValue() == insurerID) {
                insName = entity.getKey();
                break;
            }

        }
        return insName;
    }

    public int getInsurenceID(String insurenceName) {
        MapInsurence();
        return hashMapInsurence.get(insurenceName);
    }
    //endregion

    //region Addon

    public void MapAddons() {
        hashMapAddons.put("addon_ambulance_charge_cover", "Ambulance Charge Cover");
        hashMapAddons.put("addon_consumable_cover", "Consumable Cover");
        hashMapAddons.put("addon_daily_allowance_cover", "Daily Allowance Cover");
        hashMapAddons.put("addon_engine_protector_cover", "Engine Protection Cover");
        hashMapAddons.put("addon_hospital_cash_cover", "Hospital Cash Cover");
        hashMapAddons.put("addon_hydrostatic_lock_cover", "Hydrostatic Lock Cover");
        hashMapAddons.put("addon_inconvenience_allowance_cover", "Inconvinenience Allowance Cover");
        hashMapAddons.put("addon_invoice_price_cover", "Invoice Price Cover");
        hashMapAddons.put("addon_key_lock_cover", "Key Lock Cover");
        hashMapAddons.put("addon_losstime_protection_cover", "Loss Time Protection");
        hashMapAddons.put("addon_medical_expense_cover", "Medical Expense");
        hashMapAddons.put("addon_ncb_protection_cover", "NCB Protection");
        hashMapAddons.put("addon_passenger_assistance_cover", "Passenger Assistance");
        hashMapAddons.put("addon_personal_belonging_loss_cover", "Personal Belonging-Loss Cover");
        hashMapAddons.put("addon_road_assist_cover", "24X7 RoadSide Assistance");
        hashMapAddons.put("addon_rodent_bite_cover", "Rodent bite Cover");
        hashMapAddons.put("addon_tyre_coverage_cover", "Tyre Coverage");
        hashMapAddons.put("addon_windshield_cover", "Windshield Protection");
        hashMapAddons.put("addon_zero_dep_cover", "Zero Depriciation");

    }

    public String getAddonName(String addonName) {
        hashMapAddons = new HashMap<String, String>();
        MapAddons();
        return hashMapAddons.get(addonName);
    }

    public String getAddonKey(String selectedName) {
        hashMapAddons = new HashMap<String, String>();
        MapAddons();
        String AddOnName = "";
        for (Map.Entry<String, String> item : hashMapAddons.entrySet()) {
            if (item.getValue().matches(selectedName)) {
                AddOnName = item.getKey();
                break;
            }
        }

        return AddOnName;
    }
    //endregion

    //region Proprtyinfo Loan
    public List<PropertyInfoEntity> getLoanPropertyInfoList() {
        List<PropertyInfoEntity> propertyInfoEntity = new ArrayList<PropertyInfoEntity>();
        propertyInfoEntity.add(new PropertyInfoEntity(1, "Property Identified & ready to occupy"));
        propertyInfoEntity.add(new PropertyInfoEntity(2, "In Search Of Property"));
        propertyInfoEntity.add(new PropertyInfoEntity(3, "Resale Property"));
        propertyInfoEntity.add(new PropertyInfoEntity(4, "For Construction"));
        propertyInfoEntity.add(new PropertyInfoEntity(5, "Property identified - Under Construction"));
        propertyInfoEntity.add(new PropertyInfoEntity(6, "LAP"));
        return propertyInfoEntity;
    }

    public int getPropertyId(String propName) {

        PropertyInfoEntity entity = realm.where(PropertyInfoEntity.class).equalTo("Property_Type", propName).findFirst();
        if (entity != null) {
            return entity.getProperty_Id();
        }
        return 0;
    }
    //endregion

    //region login data

    public void storeUserData(LoginResponseEntity loginResponseEntity) {
        realm.beginTransaction();
        realm.delete(LoginResponseEntity.class);
        realm.copyToRealm(loginResponseEntity);
        realm.commitTransaction();
    }

    public void logout() {
        realm.beginTransaction();
        realm.delete(LoginResponseEntity.class);
        realm.commitTransaction();
    }

    public LoginResponseEntity getUserData() {
        LoginResponseEntity entity = realm.where(LoginResponseEntity.class).findFirst();
        if (entity != null)
            return entity;
        else
            return null;
    }


    //endregion

    //region insurance image mapping

    public void MapCarInsuranceImage() {

        hasMapCarInsuranceImage.put(1, R.drawable.carins1);
        hasMapCarInsuranceImage.put(2, R.drawable.carins2);
        hasMapCarInsuranceImage.put(3, R.drawable.carins3);
        hasMapCarInsuranceImage.put(4, R.drawable.carins4);
        hasMapCarInsuranceImage.put(5, R.drawable.carins5);
        hasMapCarInsuranceImage.put(6, R.drawable.carins6);
        hasMapCarInsuranceImage.put(7, R.drawable.carins7);
        hasMapCarInsuranceImage.put(8, R.drawable.carins8);
        hasMapCarInsuranceImage.put(9, R.drawable.carins9);
        hasMapCarInsuranceImage.put(10, R.drawable.carins10);
        hasMapCarInsuranceImage.put(11, R.drawable.carins11);
        hasMapCarInsuranceImage.put(12, R.drawable.carins12);
        hasMapCarInsuranceImage.put(14, R.drawable.carins14);
        hasMapCarInsuranceImage.put(15, R.drawable.carins15);
        hasMapCarInsuranceImage.put(16, R.drawable.carins16);
        hasMapCarInsuranceImage.put(17, R.drawable.carins17);
        hasMapCarInsuranceImage.put(18, R.drawable.carins18);
        hasMapCarInsuranceImage.put(19, R.drawable.carins19);
        hasMapCarInsuranceImage.put(26, R.drawable.carins26);
        hasMapCarInsuranceImage.put(30, R.drawable.carins30);
        hasMapCarInsuranceImage.put(33, R.drawable.carins33);
        hasMapCarInsuranceImage.put(34, R.drawable.carins34);
        hasMapCarInsuranceImage.put(35, R.drawable.carins35);

        hasMapCarInsuranceImage.put(36, R.drawable.carins35);
        hasMapCarInsuranceImage.put(37, R.drawable.carins35);
        hasMapCarInsuranceImage.put(38, R.drawable.carins35);
        hasMapCarInsuranceImage.put(39, R.drawable.carins35);
        hasMapCarInsuranceImage.put(40, R.drawable.carins35);
    }

    public int getInsurerImage(int insurerID) {

        hasMapCarInsuranceImage = new HashMap<Integer, Integer>();
        MapCarInsuranceImage();
        if (hasMapCarInsuranceImage.get(insurerID) != null)
            return hasMapCarInsuranceImage.get(insurerID);
        else
            return R.drawable.carins35;
    }
    //endregion


    //region sum assured
    public List<HealthSumAssured> getSumAssured() {
        List<HealthSumAssured> list = new ArrayList<HealthSumAssured>();
        list.add(new HealthSumAssured("1 Lac", 100000, false));
        list.add(new HealthSumAssured("2 Lac", 200000, false));
        list.add(new HealthSumAssured("3 Lac", 300000, false));
        list.add(new HealthSumAssured("5 Lac", 500000, false));
        list.add(new HealthSumAssured("6 Lac", 600000, false));
        list.add(new HealthSumAssured("8 Lac", 800000, false));
        list.add(new HealthSumAssured("10 Lac", 1000000, false));
        list.add(new HealthSumAssured("15 Lac", 1500000, false));
        list.add(new HealthSumAssured("20 Lac", 2000000, false));
        list.add(new HealthSumAssured("25 Lac", 2500000, false));
        list.add(new HealthSumAssured("50 Lac", 5000000, false));
        list.add(new HealthSumAssured("100 Lac", 10000000, false));
        return list;
    }

    //endregion
}
