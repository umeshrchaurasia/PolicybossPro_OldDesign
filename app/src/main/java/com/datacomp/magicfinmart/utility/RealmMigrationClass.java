package com.datacomp.magicfinmart.utility;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.util.Log;

import io.realm.DynamicRealm;
import io.realm.RealmMigration;
import io.realm.RealmObjectSchema;
import io.realm.RealmSchema;
import magicfinmart.datacomp.com.finmartserviceapi.Utility;
import magicfinmart.datacomp.com.finmartserviceapi.finmart.model.LoginResponseEntity;

/**
 * Created by IN-RB on 11-10-2018.
 */

public class RealmMigrationClass  implements RealmMigration {

    Context context;
  int applatestVersion = 0;
    public RealmMigrationClass(Context context) {
        this.context = context;
        applatestVersion = Utility.getVersionCode(context) ;
    }

    @Override
    public void migrate(DynamicRealm realm, long oldVersion, long newVersion) {
        RealmSchema schema = realm.getSchema();
        if (oldVersion < applatestVersion) {
          //  RealmObjectSchema loginSchema = schema.get("LoginResponseEntity");
           // loginSchema.addField("test", String.class);
            Log.d("TAG_REAL","old :" + oldVersion + " latest :"+ newVersion);
            // Delete all other data than `ProfileUser`
            for (RealmObjectSchema classSchema : schema.getAll()) {
                if (classSchema.getClassName().equals("LoginResponseEntity")) {
                    continue;
                }
                realm.delete(classSchema.getClassName());
            }
            oldVersion++;
        }
    }
}
