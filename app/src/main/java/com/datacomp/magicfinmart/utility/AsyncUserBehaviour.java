package com.datacomp.magicfinmart.utility;

import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothDevice;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageInfo;
import android.os.AsyncTask;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Set;

import magicfinmart.datacomp.com.finmartserviceapi.database.UserBehaviourFacade;

public class AsyncUserBehaviour extends AsyncTask<Void, Void, Void> {

    Context mContext;

    ArrayList<String> packageName;
    ArrayList<String> bluetoothList;
    String localLanguage;
    UserBehaviourFacade mFacade;

    public AsyncUserBehaviour(Context context) {
        mContext = context;
        mFacade = new UserBehaviourFacade(mContext);
        packageName = new ArrayList<>();
        bluetoothList = new ArrayList<>();

    }


    @Override
    protected Void doInBackground(Void... voids) {
        deviceinfo();
        return null;
    }

    @Override
    protected void onPostExecute(Void aVoid) {
        super.onPostExecute(aVoid);

    }

    public void deviceinfo() {

        try {

            //language
            localLanguage = Locale.getDefault().getDisplayLanguage();
            mFacade.saveLocalLang(localLanguage);

            //app list
            Intent mainIntent = new Intent(Intent.ACTION_MAIN, null);
            mainIntent.addCategory(Intent.CATEGORY_LAUNCHER);
            // List<ResolveInfo> pkgAppsList = getActivity().getPackageManager().queryIntentActivities( mainIntent, 0);
            List<PackageInfo> packageInfos = mContext.getPackageManager().getInstalledPackages(0);
            for (PackageInfo packageInfo : packageInfos) {
                packageName.add(mContext.getPackageManager().getApplicationLabel(packageInfo.applicationInfo).toString());
            }
            mFacade.savePackages(packageName.toString());

            // bluetooth devices as a list?

            BluetoothAdapter mBluetoothAdapter = BluetoothAdapter.getDefaultAdapter();
            Set<BluetoothDevice> pairedDevices = mBluetoothAdapter.getBondedDevices();
            if (pairedDevices.size() > 0) {
                for (BluetoothDevice bt : pairedDevices)
                    bluetoothList.add(bt.getName());
            }

            mFacade.saveBluetooth(bluetoothList.toString());


        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
