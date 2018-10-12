package com.datacomp.magicfinmart.utility;

import android.content.Context;
import android.util.Log;

import io.realm.DynamicRealm;
import io.realm.RealmMigration;
import io.realm.RealmObjectSchema;
import io.realm.RealmSchema;
import magicfinmart.datacomp.com.finmartserviceapi.Utility;

/**
 * Created by IN-RB on 11-10-2018.
 */

public class RealmMigrationClass implements RealmMigration {

    Context context;
    int applatestVersion = 0;

    public RealmMigrationClass(Context context) {
        this.context = context;
        applatestVersion = Utility.getVersionCode(context);
    }

    @Override
    public void migrate(DynamicRealm realm, long oldVersion, long newVersion) {
        RealmSchema schema = realm.getSchema();


        if (oldVersion != 0) {
            if (oldVersion < applatestVersion) {
                //  RealmObjectSchema loginSchema = schema.get("LoginResponseEntity");
                // loginSchema.addField("test", String.class);
                Log.d("TAG_REAL", "old :" + oldVersion + " latest :" + newVersion);
                // Delete all other data than `ProfileUser`
                for (RealmObjectSchema classSchema : schema.getAll()) {
                    if (classSchema.getClassName().equals("LoginResponseEntity")) {
                        continue;
                    }
                    realm.delete(classSchema.getClassName());
                }
                oldVersion++;
            }
        } else if(oldVersion == 0)
        {
            RealmObjectSchema userConstant = schema.get("UserConstantEntity")
                        .addField("AddPospVisible", String.class)
                        .addField("userid", String.class)
                        .addField("marketinghomepopupid", String.class)
                        .addField("marketinghometitle", String.class)
                        .addField("marketinghomedesciption", String.class)
                        .addField("marketinghomemaxcount", String.class)
                        .addField("marketinghomeenabled", String.class)
                        .addField("marketinghometransfertype", String.class)
                        .addField("marketinghomeurl", String.class);
        }
//        else {
//            if (!schema.contains("LoginResponseEntity")) {
//                schema.create("LoginResponseEntity");
//                oldVersion++;
//            }
//            else {
//                RealmObjectSchema userConstant = schema.get("UserConstantEntity")
//                        .addField("AddPospVisible", String.class)
//                        .addField("userid", String.class)
//                        .addField("marketinghomepopupid", String.class)
//                        .addField("marketinghometitle", String.class)
//                        .addField("marketinghomedesciption", String.class)
//                        .addField("marketinghomemaxcount", String.class)
//                        .addField("marketinghomeenabled", String.class)
//                        .addField("marketinghometransfertype", String.class)
//                        .addField("marketinghomeurl", String.class);
//
//
//
//
//            }
//        }
    }
}
