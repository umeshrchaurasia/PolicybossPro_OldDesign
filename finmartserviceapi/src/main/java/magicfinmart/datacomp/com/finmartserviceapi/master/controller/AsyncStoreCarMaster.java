package magicfinmart.datacomp.com.finmartserviceapi.master.controller;

import android.content.Context;
import android.os.AsyncTask;

import java.util.List;

import io.realm.Realm;
import magicfinmart.datacomp.com.finmartserviceapi.master.model.MasterDataEntity;

/**
 * Created by Nilesh Birhade on 29-11-2017.
 */

public class AsyncStoreCarMaster extends AsyncTask<Void, Void, Void> {

    Context mContext;
    List<MasterDataEntity> listCarMaster;

    public AsyncStoreCarMaster(Context context, List<MasterDataEntity> list) {
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
