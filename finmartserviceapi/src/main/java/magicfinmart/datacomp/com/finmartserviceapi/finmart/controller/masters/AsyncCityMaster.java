package magicfinmart.datacomp.com.finmartserviceapi.finmart.controller.masters;

import android.content.Context;
import android.os.AsyncTask;

import java.util.List;

import io.realm.Realm;
import magicfinmart.datacomp.com.finmartserviceapi.finmart.model.CityMasterEntity;

/**
 * Created by Nilesh Birhade on 12-01-2018.
 */

public class AsyncCityMaster extends AsyncTask<Void, Void, Void> {

    Context mContext;
    List<CityMasterEntity> listRTOMaster;

    public AsyncCityMaster(Context context, List<CityMasterEntity> list) {
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
