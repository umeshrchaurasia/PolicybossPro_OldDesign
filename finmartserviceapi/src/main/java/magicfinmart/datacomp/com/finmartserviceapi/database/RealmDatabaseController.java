package magicfinmart.datacomp.com.finmartserviceapi.database;

import android.content.Context;
import android.util.Log;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import io.realm.Realm;
import magicfinmart.datacomp.com.finmartserviceapi.model.DashboardEntity;

/**
 * Created by Rajeev Ranjan on 04/01/2018.
 */

public class RealmDatabaseController {

    public RealmDatabaseController() {

    }

    Context mContext;
    Realm realm;
    private static final String DASHBOARD_TABLE = "dashboard_entity";

    public RealmDatabaseController(Context mContext) {
        this.mContext = mContext;
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

    public List<DashboardEntity> getDashBoardList() {
        realm = Realm.getDefaultInstance();
        List<DashboardEntity> list = realm.where(DashboardEntity.class).findAll();
        return list;
    }

    public List<DashboardEntity> makeDashboardTables() {
        List<DashboardEntity> dashboardEntities = new ArrayList<DashboardEntity>();
        dashboardEntities.add(new DashboardEntity("INSURANCE", 1, "PRIVATE CAR", "Best quotes for Private Car Insurance of your customers with instant policy.", 1));
        dashboardEntities.add(new DashboardEntity("INSURANCE", 2, "TWO WHEELER", "Best quotes for Two Wheeler Insurance of your customers with instant policy.", 2));
        dashboardEntities.add(new DashboardEntity("INSURANCE", 3, "HEALTH INSURANCE", "Get quotes and compare benefits of health insurance from top insurance companies.", 3));

        dashboardEntities.add(new DashboardEntity("LOANS", 4, "HOME LOAN", "Get best deals for Home Loan for your customers from over 20 providers.", 2));
        dashboardEntities.add(new DashboardEntity("LOANS", 5, "PERSONAL LOAN", "Get best deals for Personal Loan for your customers from over 20 providers.", 2));
        dashboardEntities.add(new DashboardEntity("LOANS", 6, "LOAN AGAINST PROPERTY", "Offer loans against property at attractive rates to your customers", 2));
        dashboardEntities.add(new DashboardEntity("LOANS", 7, "CREDIT CARD", "Get lowest rate loan on your Credit Card from wide range of banks.", 2));
        dashboardEntities.add(new DashboardEntity("LOANS", 8, "BALANCE TRANSFER", "Save huge money for your customers on their existing loans.", 2));
        dashboardEntities.add(new DashboardEntity("LOANS", 9, "OTHER LOAN", "Get best deals for other Loans for your customers from over 20 providers.", 2));

        dashboardEntities.add(new DashboardEntity("MORE SERVICES", 10, "FIN-PEACE", "A must for all your customers. A unique BEYOND LIFE services for your customer's peace of mind", 2));
        dashboardEntities.add(new DashboardEntity("MORE SERVICES", 11, "HEALTH CHECK UP PLANS", "Offer a wide array of health check up plans from reputed diagnostics labs at discounted prices and free home collection", 2));

        return dashboardEntities;
    }

}
