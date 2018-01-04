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
    HashMap<String, Object> weakReference;
    private static final String DASHBOARD_TABLE = "dashboard_entity";

    public RealmDatabaseController(Context mContext) {
        this.mContext = mContext;
        weakReference = new HashMap<String, Object>();
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
        return dashboardEntities;
    }

}
