package com.datacomp.magicfinmart;

import android.support.multidex.MultiDexApplication;

import com.crashlytics.android.Crashlytics;
import com.datacomp.magicfinmart.analytics.AnalyticsTrackers;
import com.datacomp.magicfinmart.utility.RealmMigrationClass;
import com.google.android.gms.analytics.GoogleAnalytics;
import com.google.android.gms.analytics.HitBuilders;
import com.google.android.gms.analytics.StandardExceptionParser;
import com.google.android.gms.analytics.Tracker;


import org.matomo.sdk.Matomo;
import org.matomo.sdk.TrackerBuilder;
import org.matomo.sdk.extra.TrackHelper;

import io.fabric.sdk.android.Fabric;
import io.realm.Realm;
import io.realm.RealmConfiguration;
import magicfinmart.datacomp.com.finmartserviceapi.Utility;
import magicfinmart.datacomp.com.finmartserviceapi.database.DBPersistanceController;

public class MyApplication extends MultiDexApplication {

    public static final String TAG = MyApplication.class
            .getSimpleName();
    private static MyApplication mInstance;

    private org.matomo.sdk.Tracker mMamatoTracker;

    @Override
    public void onCreate() {
        super.onCreate();
        Fabric.with(this, new Crashlytics());

        //region Realm Initialization
        Realm.init(this);
        RealmConfiguration config = new RealmConfiguration.Builder()
                .name("magicfinmart.realm")                // user defined name
                .schemaVersion(Utility.getVersionCode(this))

                //.migration(new RealmMigrationClass(this))
                .deleteRealmIfMigrationNeeded()
                .build();
        Realm.setDefaultConfiguration(config);
        //endregion

        //region google analytics Initialization

        mInstance = this;
        AnalyticsTrackers.initialize(this);
        AnalyticsTrackers.getInstance().get(AnalyticsTrackers.Target.APP);

        //endregion

    }



    public synchronized org.matomo.sdk.Tracker getTracker() {
        if (mMamatoTracker == null) {
            mMamatoTracker = TrackerBuilder.createDefault("http://domain.tld/matomo.php", 138).build(Matomo.getInstance(this));
        }

        return mMamatoTracker;
    }


    public static synchronized MyApplication getInstance() {
        return mInstance;
    }

    public synchronized Tracker getGoogleAnalyticsTracker() {
        AnalyticsTrackers analyticsTrackers = AnalyticsTrackers.getInstance();
        return analyticsTrackers.get(AnalyticsTrackers.Target.APP);
    }

    /***
     * Tracking screen view
     *
     * @param screenName screen name to be displayed on GA dashboard
     */
    public void trackScreenView(String screenName) {
        Tracker t = getGoogleAnalyticsTracker();

        // Set screen name.
        t.setScreenName(screenName);

        // Send a screen view.
        t.send(new HitBuilders.ScreenViewBuilder().build());

        GoogleAnalytics.getInstance(this).dispatchLocalHits();
    }

    /***
     * Tracking exception
     *
     * @param e exception to be tracked
     */
    public void trackException(Exception e) {
        if (e != null) {
            Tracker t = getGoogleAnalyticsTracker();

            t.send(new HitBuilders.ExceptionBuilder()
                    .setDescription(
                            new StandardExceptionParser(this, null)
                                    .getDescription(Thread.currentThread().getName(), e))
                    .setFatal(false)
                    .build()
            );
        }
    }

    /***
     * Tracking event
     *
     * @param category event category
     * @param action   action of the event
     * @param label    label
     */
    public void trackEvent(String category, String action, String label) {
        Tracker t = getGoogleAnalyticsTracker();
        int FBA_ID = 0;
        DBPersistanceController dbPersistanceController = new DBPersistanceController(this);

        if (dbPersistanceController.getUserData() != null)
            FBA_ID = dbPersistanceController.getUserData().getFBAId();
        // Build and send an Event.
        t.send(new HitBuilders.EventBuilder().setCategory(category).setAction(action).setLabel(label).setValue(FBA_ID).build());


        if (mMamatoTracker == null) {
            mMamatoTracker = getTracker();
        }

        TrackHelper.track().event(category, action);


    }


}