package magicfinmart.datacomp.com.finmartserviceapi.finmart.controller.masters;

import android.content.Context;
import android.os.AsyncTask;

import io.realm.Realm;
import magicfinmart.datacomp.com.finmartserviceapi.PrefManager;
import magicfinmart.datacomp.com.finmartserviceapi.finmart.model.UserConstantEntity;

/**
 * Created by Nilesh Birhade on 29-11-2017.
 */

public class SyncUserConstatnt  {
    PrefManager prefManager;
    Context mContext;
   UserConstantEntity userConstantEntity;


    public SyncUserConstatnt(Context context, UserConstantEntity tempConstantEntity) {
        this.userConstantEntity = tempConstantEntity;
        mContext = context;
        prefManager = new PrefManager(mContext);
    }

    public void bindUserConstant()
    {
        Realm realm = null;
        try {
            realm = Realm.getDefaultInstance();
            realm.executeTransaction(new Realm.Transaction() {
                @Override
                public void execute(Realm realm) {
                    realm.copyToRealmOrUpdate(userConstantEntity);

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
