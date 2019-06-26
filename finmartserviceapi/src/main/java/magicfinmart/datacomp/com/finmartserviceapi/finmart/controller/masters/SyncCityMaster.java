package magicfinmart.datacomp.com.finmartserviceapi.finmart.controller.masters;

import android.content.Context;
import android.os.AsyncTask;

import java.util.List;

import io.realm.Realm;
import magicfinmart.datacomp.com.finmartserviceapi.PrefManager;
import magicfinmart.datacomp.com.finmartserviceapi.finmart.model.CityMasterEntity;

/**
 * Created by Nilesh Birhade on 12-01-2018.
 */

public class SyncCityMaster  {
    PrefManager prefManager;
    Context mContext;
    List<CityMasterEntity> listRTOMaster;

    public SyncCityMaster(Context context, List<CityMasterEntity> list) {
        listRTOMaster = list;
        mContext = context;
        prefManager = new PrefManager(mContext);
    }


    public void binCityMaster(){
        Realm realm = null;
        try {
            realm = Realm.getDefaultInstance();
            realm.executeTransaction(new Realm.Transaction() {
                @Override
                public void execute(Realm realm) {
                    realm.copyToRealmOrUpdate(listRTOMaster);
                    prefManager.setIsRtoMasterUpdate(false);
                }
            });




        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (realm != null) {
                realm.close();
            }
        }

    }


}
