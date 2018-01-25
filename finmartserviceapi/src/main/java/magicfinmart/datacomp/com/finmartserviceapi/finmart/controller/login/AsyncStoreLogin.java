package magicfinmart.datacomp.com.finmartserviceapi.finmart.controller.login;

import android.content.Context;
import android.os.AsyncTask;

import io.realm.Realm;
import magicfinmart.datacomp.com.finmartserviceapi.finmart.model.LoginResponseEntity;

/**
 * Created by Nilesh Birhade on 29-11-2017.
 */

public class AsyncStoreLogin extends AsyncTask<Void, Void, Void> {

    Context mContext;
    LoginResponseEntity listCarMaster;

    public AsyncStoreLogin(Context context, LoginResponseEntity list) {
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
                    realm.delete(LoginResponseEntity.class);
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
