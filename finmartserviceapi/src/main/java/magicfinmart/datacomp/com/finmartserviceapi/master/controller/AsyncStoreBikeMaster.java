package magicfinmart.datacomp.com.finmartserviceapi.master.controller;

import android.content.Context;
import android.os.AsyncTask;


import java.util.List;

import io.realm.Realm;
import magicfinmart.datacomp.com.finmartserviceapi.master.model.MasterBikeDataEntity;

/**
 * Created by Nilesh Birhade on 29-11-2017.
 */

public class AsyncStoreBikeMaster extends AsyncTask<Void, Void, Void> {

    Context mContext;
    List<MasterBikeDataEntity> listCarMaster;

    public AsyncStoreBikeMaster(Context context, List<MasterBikeDataEntity> list) {
        listCarMaster = list;
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
                    realm.copyToRealmOrUpdate(listCarMaster);
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
