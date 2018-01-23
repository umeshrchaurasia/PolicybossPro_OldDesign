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
import magicfinmart.datacomp.com.finmartserviceapi.model.DashboardEntity;
import magicfinmart.datacomp.com.finmartserviceapi.model.PropertyInfoEntity;

/**
 * Created by Rajeev Ranjan on 04/01/2018.
 */

public class DBPersistanceController {

    private static final String EXTERNAL_LPG = "External Fitted LPG";
    private static final String EXTERNAL_CNG = "External Fitted CNG";
    Map<String, Integer> hashMapInsurence;
    HashMap<String, String> hashMapAddons;
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
            listCity.add(list_Make.get(i).getRTO_CodeDiscription());
        }
        return listCity;
    }


    public String getCityID(String cityName) {

        CityMasterEntity entity = realm.where(CityMasterEntity.class)
                .equalTo("RTO_CodeDiscription", cityName).findFirst();

        if (entity != null)
            return entity.getVehicleCity_Id();
        else
            return "";

    }

    public String getRTOCityName(int VehicleCity_Id) {

        CityMasterEntity entity = realm.where(CityMasterEntity.class)
                .equalTo("VehicleCity_Id", VehicleCity_Id).findFirst();

        if (entity != null)
            return entity.getRTO_CodeDiscription();
        else
            return "";

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

    public String getModelID(String modelName) {
        CarMasterEntity entity = realm.where(CarMasterEntity.class).equalTo("Model_Name", modelName.trim()).findFirst();
        if (entity != null)
            return entity.getModel_ID();
        else
            return "";
    }

    public List<String> getVariantbyModelID(String modelID) {

        List<String> listCarVariant = new ArrayList<>();

        List<CarMasterEntity> list = realm.where(CarMasterEntity.class)
                .equalTo("Model_ID", modelID)
                .distinct("Variant_ID");

        for (int i = 0; i < list.size(); i++) {
            CarMasterEntity entity = list.get(i);
            String variant = entity.getVariant_Name() + " , ( " + entity.getCubic_Capacity() + "CC )";
            listCarVariant.add(variant);
        }

        return listCarVariant;

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

    public String getBikeModelID(String modelName) {
        BikeMasterEntity entity = realm.where(BikeMasterEntity.class).equalTo("Model_Name", modelName.trim()).findFirst();
        if (entity != null)
            return entity.getModel_ID();
        else
            return "";
    }

    public List<String> getBikeVariantbyModelID(int modelID) {

        List<String> listCarVariant = new ArrayList<>();

        List<BikeMasterEntity> list = realm.where(BikeMasterEntity.class)
                .equalTo("Model_ID", modelID)
                .distinct("Variant_ID");

        for (int i = 0; i < list.size(); i++) {
            BikeMasterEntity entity = list.get(i);
            String variant = entity.getVariant_Name() + " , ( " + entity.getCubic_Capacity() + "CC )";
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
            listCity.add(list_Make.get(i).getInsuName());
        }
        return listCity;
    }

    public List<HealthinsuranceEntity> getHealthList() {
        return realm.where(HealthinsuranceEntity.class).findAll();
    }

    public ArrayList<String> getGeneralListNames() {
        List<GeneralinsuranceEntity> list_Make = realm.where(GeneralinsuranceEntity.class).findAll();
        ArrayList listCity = new ArrayList();
        for (int i = 0; i < list_Make.size(); i++) {
            listCity.add(list_Make.get(i).getInsuName());
        }
        return listCity;
    }

    public List<GeneralinsuranceEntity> getGeneralList() {
        return realm.where(GeneralinsuranceEntity.class).findAll();
    }

    public ArrayList<String> getLifeListNames() {
        List<LifeinsuranceEntity> list_Make = realm.where(LifeinsuranceEntity.class).findAll();
        ArrayList listCity = new ArrayList();
        for (int i = 0; i < list_Make.size(); i++) {
            listCity.add(list_Make.get(i).getInsuName());
        }
        return listCity;
    }

    public List<LifeinsuranceEntity> getLifeList() {
        return realm.where(LifeinsuranceEntity.class).findAll();
    }

    //endregion

    //region Dashboard list

    public List<DashboardEntity> getInsurProductList() {
        List<DashboardEntity> dashboardEntities = new ArrayList<DashboardEntity>();
        dashboardEntities.add(new DashboardEntity("INSURANCE", 1, "PRIVATE CAR", "Best quotes for Private Car Insurance of your customers with instant policy.", R.drawable.private_car));
        dashboardEntities.add(new DashboardEntity("INSURANCE", 2, "TWO WHEELER", "Best quotes for Two Wheeler Insurance of your customers with instant policy.", R.drawable.two_wheeler));
        dashboardEntities.add(new DashboardEntity("INSURANCE", 3, "HEALTH INSURANCE", "Get quotes and compare benefits of health insurance from top insurance companies.", R.drawable.health_insurance));

        return dashboardEntities;
    }

    public List<DashboardEntity> getLoanProductList() {
        List<DashboardEntity> dashboardEntities = new ArrayList<DashboardEntity>();
        dashboardEntities.add(new DashboardEntity("LOANS", 4, "HOME LOAN", "Get best deals for Home Loan for your customers from over 20 providers.", R.drawable.private_car));
        dashboardEntities.add(new DashboardEntity("LOANS", 5, "PERSONAL LOAN", "Get best deals for Personal Loan for your customers from over 20 providers.", R.drawable.private_car));
        dashboardEntities.add(new DashboardEntity("LOANS", 6, "LOAN AGAINST PROPERTY", "Offer loans against property at attractive rates to your customers", R.drawable.private_car));
        dashboardEntities.add(new DashboardEntity("LOANS", 7, "CREDIT CARD", "Get lowest rate loan on your Credit Card from wide range of banks.", R.drawable.private_car));
        dashboardEntities.add(new DashboardEntity("LOANS", 8, "BALANCE TRANSFER", "Save huge money for your customers on their existing loans.", R.drawable.private_car));
        dashboardEntities.add(new DashboardEntity("LOANS", 9, "OTHER LOAN", "Get best deals for other Loans for your customers from over 20 providers.", R.drawable.private_car));

        return dashboardEntities;
    }

    public List<DashboardEntity> getMoreProductList() {
        List<DashboardEntity> dashboardEntities = new ArrayList<DashboardEntity>();

        dashboardEntities.add(new DashboardEntity("MORE SERVICES", 10, "FIN-PEACE", "A must for all your customers. A unique BEYOND LIFE services for your customer's peace of mind", R.drawable.private_car));
        dashboardEntities.add(new DashboardEntity("MORE SERVICES", 11, "HEALTH CHECK UP PLANS", "Offer a wide array of health check up plans from reputed diagnostics labs at discounted prices and free home collection", R.drawable.private_car));

        return dashboardEntities;
    }

    //endregion

    //region previous insurer

    public List<String> getInsurerList() {
        MapInsurence();
        ArrayList<String> insurenceList = new ArrayList<String>(hashMapInsurence.keySet());
        insurenceList.add(0, "Select Prev Insurer");
        return insurenceList;

    }

    public void MapInsurence() {
        hashMapInsurence = new TreeMap<String, Integer>();
        hashMapInsurence.put("Bajaj Allianz", 1);
        hashMapInsurence.put("Bharti Axa", 2);
        hashMapInsurence.put("Future Generali India", 4);
        hashMapInsurence.put("HDFC ERGO", 5);
        hashMapInsurence.put("ICICI Lombard", 6);
        hashMapInsurence.put("IFFCO Tokio", 7);
        hashMapInsurence.put("Universal Sompo", 19);
        hashMapInsurence.put("Liberty Videocon", 33);
        hashMapInsurence.put("Tata AIG", 11);
        hashMapInsurence.put("New India Assurance", 12);
        hashMapInsurence.put("Kotak Mahindra", 30);
        hashMapInsurence.put("Reliance General", 9);
        hashMapInsurence.put("Royal Sundaram", 10);
        hashMapInsurence.put("SBI General ", 17);
        hashMapInsurence.put("Shriram General ", 18);
        hashMapInsurence.put("National Insurance ", 8);
        hashMapInsurence.put("L & T General ", 15);
        hashMapInsurence.put("Cholamandalam MS General ", 3);
        hashMapInsurence.put("Raheja QBE General ", 16);
        hashMapInsurence.put("Liberty Videocon General ", 33);
        hashMapInsurence.put("Star Health Insurance", 26);
        hashMapInsurence.put("Magma HDI General ", 35);
        hashMapInsurence.put("The Oriental Insurance", 13);
        hashMapInsurence.put("United India Insurance ", 14);
        hashMapInsurence.put("Religare Health Insurance", 34);
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
}
