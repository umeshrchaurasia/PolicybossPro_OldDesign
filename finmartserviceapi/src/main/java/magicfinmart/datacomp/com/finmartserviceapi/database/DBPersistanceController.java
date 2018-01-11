package magicfinmart.datacomp.com.finmartserviceapi.database;

import android.content.Context;
import android.util.Log;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import io.realm.Realm;
import magicfinmart.datacomp.com.finmartserviceapi.R;
import magicfinmart.datacomp.com.finmartserviceapi.master.model.MasterBikeDataEntity;
import magicfinmart.datacomp.com.finmartserviceapi.master.model.MasterDataEntity;
import magicfinmart.datacomp.com.finmartserviceapi.model.DashboardEntity;

/**
 * Created by Rajeev Ranjan on 04/01/2018.
 */

public class DBPersistanceController {

    private static final String EXTERNAL_LPG = "External Fitted LPG";
    private static final String EXTERNAL_CNG = "External Fitted CNG";

    Context mContext;
    Realm realm;


    public DBPersistanceController() {

    }

    public DBPersistanceController(Context mContext) {
        this.mContext = mContext;
        realm = Realm.getDefaultInstance();
    }


    public void setDashboardEntities(final List<DashboardEntity> dashboardEntities) {

        try {
            realm = Realm.getDefaultInstance();
            realm.executeTransactionAsync(new Realm.Transaction() {
                @Override
                public void execute(Realm realm) {
                    realm.copyToRealmOrUpdate(dashboardEntities);
                }
            }, new Realm.Transaction.OnSuccess() {
                @Override
                public void onSuccess() {
                    // Transaction was a success.
                    Log.d("RealmDatabase", "success");
                }
            }, new Realm.Transaction.OnError() {
                @Override
                public void onError(Throwable error) {
                    // Transaction failed and was automatically canceled.
                    Log.d("RealmDatabase", "failure - " + error.getMessage());
                }
            });


        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (realm != null) {
                realm.close();
            }
        }

       /* realm.executeTransactionAsync(new Realm.Transaction() {
            @Override
            public void execute(Realm bgRealm) {
                realm.copyToRealmOrUpdate(dashboardEntities);
            }
        }, new Realm.Transaction.OnSuccess() {
            @Override
            public void onSuccess() {
                // Transaction was a success.
                Log.d("RealmDatabase", "success");
            }
        }, new Realm.Transaction.OnError() {
            @Override
            public void onError(Throwable error) {
                // Transaction failed and was automatically canceled.
                Log.d("RealmDatabase", "failure - " + error.getMessage());
            }
        });*/

        /*realm.executeTransactionAsync(new Realm.Transaction() {
            @Override
            public void execute(Realm realm) {
                realm.copyToRealmOrUpdate(dashboardEntities);
            }
        });*/
    }

    //region master car
    public List<String> getCarMakeModel() {
        List<String> listCarModel = new ArrayList<>();
        // List<ModelMasterEntity> listModelMaster = dbController.getMasterModel();
        List<MasterDataEntity> list = realm.where(MasterDataEntity.class).distinct("Model_ID");

        for (int i = 0; i < list.size(); i++) {
            MasterDataEntity entity = list.get(i);
            String carModel = entity.getMake_Name() + " , " + entity.getModel_Name();
            listCarModel.add(carModel);
        }

        return listCarModel;
    }

    public int getModelID(String modelName) {
        MasterDataEntity entity = realm.where(MasterDataEntity.class).equalTo("Model_Name", modelName.trim()).findFirst();
        if (entity != null)
            return entity.getModel_ID();
        else
            return 0;
    }

    public List<String> getVariantbyModelID(int modelID) {

        List<String> listCarVariant = new ArrayList<>();

        List<MasterDataEntity> list = realm.where(MasterDataEntity.class)
                .equalTo("Model_ID", modelID)
                .distinct("Variant_ID");

        for (int i = 0; i < list.size(); i++) {
            MasterDataEntity entity = list.get(i);
            String variant = entity.getVariant_Name() + " , ( " + entity.getCubic_Capacity() + "CC )";
            listCarVariant.add(variant);
        }

        return listCarVariant;

    }

    //endregion

    //region fuel

    public List<String> getFuelTypeByModelId(int modelID) {
        List<String> fuelType = new ArrayList<>();

        List<MasterDataEntity> list = realm.where(MasterDataEntity.class)
                .equalTo("Model_ID", modelID)
                .distinct("Fuel_ID");

        for (int i = 0; i < list.size(); i++) {
            MasterDataEntity entity = list.get(i);
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

    public int getVariantID(String variantName, String modelName, String makeName) {
        MasterDataEntity entity = realm.where(MasterDataEntity.class).equalTo("Model_Name", modelName.trim())
                .equalTo("Variant_Name", variantName.trim())
                .equalTo("Make_Name", makeName.trim()).findFirst();

        if (entity != null)
            return entity.getVariant_ID();
        else
            return 0;
    }

    //endregion

    //region master Bike
    public List<String> getBikeMakeModel() {
        List<String> listCarModel = new ArrayList<>();
        // List<ModelMasterEntity> listModelMaster = dbController.getMasterModel();
        List<MasterBikeDataEntity> list = realm.where(MasterBikeDataEntity.class).distinct("Model_ID");

        for (int i = 0; i < list.size(); i++) {
            MasterBikeDataEntity entity = list.get(i);
            String carModel = entity.getMake_Name() + " , " + entity.getModel_Name();
            listCarModel.add(carModel);
        }

        return listCarModel;
    }

    public int getBikeModelID(String modelName) {
        MasterBikeDataEntity entity = realm.where(MasterBikeDataEntity.class).equalTo("Model_Name", modelName.trim()).findFirst();
        if (entity != null)
            return entity.getModel_ID();
        else
            return 0;
    }

    public List<String> getBikeVariantbyModelID(int modelID) {

        List<String> listCarVariant = new ArrayList<>();

        List<MasterBikeDataEntity> list = realm.where(MasterBikeDataEntity.class)
                .equalTo("Model_ID", modelID)
                .distinct("Variant_ID");

        for (int i = 0; i < list.size(); i++) {
            MasterBikeDataEntity entity = list.get(i);
            String variant = entity.getVariant_Name() + " , ( " + entity.getCubic_Capacity() + "CC )";
            listCarVariant.add(variant);
        }

        return listCarVariant;

    }

    //endregion

    //region Dashboard list

    public List<DashboardEntity> getInsurProductList() {
        List<DashboardEntity> dashboardEntities = new ArrayList<DashboardEntity>();
        dashboardEntities.add(new DashboardEntity("INSURANCE", 1, "PRIVATE CAR", "Best quotes for Private Car Insurance of your customers with instant policy.", R.drawable.private_car));
        dashboardEntities.add(new DashboardEntity("INSURANCE", 2, "TWO WHEELER", "Best quotes for Two Wheeler Insurance of your customers with instant policy.", R.drawable.private_car));
        dashboardEntities.add(new DashboardEntity("INSURANCE", 3, "HEALTH INSURANCE", "Get quotes and compare benefits of health insurance from top insurance companies.", R.drawable.private_car));

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
}
