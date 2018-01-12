package magicfinmart.datacomp.com.finmartserviceapi.master.controller;

import android.content.Context;
import android.os.AsyncTask;

import java.util.List;

import io.realm.Realm;
import magicfinmart.datacomp.com.finmartserviceapi.master.model.MasterBikeDataEntity;
import magicfinmart.datacomp.com.finmartserviceapi.master.model.VehicleMasterEntity;

/**
 * Created by Nilesh Birhade on 12-01-2018.
 */

public class AsyncRTOMaster extends AsyncTask<Void, Void, Void> {

    Context mContext;
    List<VehicleMasterEntity> listRTOMaster;

    public AsyncRTOMaster(Context context, List<VehicleMasterEntity> list) {
        listRTOMaster = list;
        mContext = context;
    }


    @Override
    protected Void doInBackground(Void... voids) {

        Realm realm = null;
        try {
            realm = Realm.getDefaultInstance();
            realm.executeTransactionAsync(new Realm.Transaction() {
                @Override
                public void execute(Realm realm) {
                    realm.copyToRealmOrUpdate(listRTOMaster);
                }
            });


        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (realm != null) {
                realm.close();
            }
        }
        return null;
    }

    @Override
    protected void onPostExecute(Void aVoid) {
        super.onPostExecute(aVoid);
    }
}
