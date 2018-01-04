package magicfinmart.datacomp.com.finmartserviceapi.database;

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

    Realm realm;
    HashMap<String, Object> weakReference;
    private static final String DASHBOARD_TABLE = "dashboard_entity";

    public RealmDatabaseController(Realm realm) {
        this.realm = realm;
        weakReference = new HashMap<String, Object>();
    }

    public void insertDashboardTables(final List<DashboardEntity> dashboardEntities) {

        realm.executeTransactionAsync(new Realm.Transaction() {
            @Override
            public void execute(Realm realm) {
                realm.copyToRealmOrUpdate(dashboardEntities);
            }
        });
    }

    public List<DashboardEntity> getDashBoardList() {
        List<DashboardEntity> list = realm.where(DashboardEntity.class).findAllAsync();
        return list;
    }

    public List<DashboardEntity> makeDashboardTables() {
        List<DashboardEntity> dashboardEntities = new ArrayList<DashboardEntity>();
        dashboardEntities.add(new DashboardEntity("INSURANCE", 1, "PRIVATE CAR", "Best quotes for Private Car Insurance of your customers with instant policy.", 1));
        dashboardEntities.add(new DashboardEntity("INSURANCE", 2, "TWO WHEELER", "Best quotes for Two Wheeler Insurance of your customers with instant policy.", 2));
        return dashboardEntities;
    }
}
