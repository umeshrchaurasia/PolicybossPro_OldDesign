package com.datacomp.magicfinmart.home;

import android.app.Dialog;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.graphics.Typeface;
import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.content.LocalBroadcastManager;
import android.support.v4.view.GravityCompat;
import android.support.v4.view.MenuItemCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AlertDialog;
import android.support.v7.widget.Toolbar;
import android.text.SpannableString;
import android.text.style.StyleSpan;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.datacomp.magicfinmart.BaseActivity;
import com.datacomp.magicfinmart.R;
import com.datacomp.magicfinmart.change_password.ChangePasswordFragment;
import com.datacomp.magicfinmart.dashboard.DashboardFragment;
import com.datacomp.magicfinmart.helpfeedback.HelpFeedBackActivity;
import com.datacomp.magicfinmart.inspection.splash.SplashScreen;
import com.datacomp.magicfinmart.loan_fm.homeloan.loan_apply.HomeLoanApplyActivity;
import com.datacomp.magicfinmart.login.LoginActivity;
import com.datacomp.magicfinmart.mps.KnowMoreMPSFragment;
import com.datacomp.magicfinmart.mps.MPSFragment;
import com.datacomp.magicfinmart.myaccount.MyAccountActivity;
import com.datacomp.magicfinmart.notification.NotificationActivity;
import com.datacomp.magicfinmart.posp.PospEnrollment;
import com.datacomp.magicfinmart.share_data.ShareDataFragment;
import com.datacomp.magicfinmart.splashscreen.SplashScreenActivity;
import com.datacomp.magicfinmart.underconstruction.UnderConstructionActivity;
import com.datacomp.magicfinmart.utility.Constants;
import com.datacomp.magicfinmart.webviews.CommonWebViewActivity;
import com.datacomp.magicfinmart.whatsnew.WhatsNewActivity;

import java.io.IOException;
import java.util.List;

import magicfinmart.datacomp.com.finmartserviceapi.PrefManager;
import magicfinmart.datacomp.com.finmartserviceapi.Utility;
import magicfinmart.datacomp.com.finmartserviceapi.database.DBPersistanceController;
import magicfinmart.datacomp.com.finmartserviceapi.finmart.APIResponse;
import magicfinmart.datacomp.com.finmartserviceapi.finmart.IResponseSubcriber;
import magicfinmart.datacomp.com.finmartserviceapi.finmart.controller.masters.MasterController;
import magicfinmart.datacomp.com.finmartserviceapi.finmart.controller.register.RegisterController;
import magicfinmart.datacomp.com.finmartserviceapi.finmart.controller.tracking.TrackingController;
import magicfinmart.datacomp.com.finmartserviceapi.finmart.model.ConstantEntity;
import magicfinmart.datacomp.com.finmartserviceapi.finmart.model.LoginResponseEntity;
import magicfinmart.datacomp.com.finmartserviceapi.finmart.model.MpsDataEntity;
import magicfinmart.datacomp.com.finmartserviceapi.finmart.model.NotifyEntity;
import magicfinmart.datacomp.com.finmartserviceapi.finmart.model.TrackingData;
import magicfinmart.datacomp.com.finmartserviceapi.finmart.requestentity.TrackingRequestEntity;
import magicfinmart.datacomp.com.finmartserviceapi.finmart.response.ConstantsResponse;
import magicfinmart.datacomp.com.finmartserviceapi.finmart.response.MpsResponse;
import magicfinmart.datacomp.com.finmartserviceapi.finmart.response.MyAcctDtlResponse;

public class HomeActivity extends BaseActivity implements IResponseSubcriber, BaseActivity.PopUpListener {

    final String TAG = "HOME";
    private Toolbar toolbar;
    private NavigationView navigationView;
    private DrawerLayout drawerLayout;
    TextView textNotifyItemCount, txtEntityName, txtDetails, txtFbaCode;
    LoginResponseEntity loginResponseEntity;
    DBPersistanceController db;
    String versionNAme;
    PackageInfo pinfo;
    PrefManager prefManager;
    int forceUpdate;
    ConstantEntity constantEntity;
    AlertDialog mpsDialog;

    public BroadcastReceiver mHandleMessageReceiver = new BroadcastReceiver() {

        @Override
        public void onReceive(Context context, Intent intent) {

            if (intent.getAction() != null && intent.getAction().equalsIgnoreCase(Utility.PUSH_BROADCAST_ACTION)) {
                int notifyCount = prefManager.getNotificationCounter();

                if (notifyCount == 0) {
                    textNotifyItemCount.setVisibility(View.GONE);
                } else {
                    textNotifyItemCount.setVisibility(View.VISIBLE);
                    textNotifyItemCount.setText("" + String.valueOf(notifyCount));
                }
            }

        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        registerPopUp(this);
        // Initializing Toolbar and setting it as the actionbar
        toolbar = (Toolbar) findViewById(R.id.toolbar);
        //Initializing NavigationView
        navigationView = (NavigationView) findViewById(R.id.navigation_view);
        // Initializing Drawer Layout and ActionBarToggle
        drawerLayout = (DrawerLayout) findViewById(R.id.drawer);

        setSupportActionBar(toolbar);
        getSupportActionBar().setElevation(0);
        toolbar.setTitle("MAGIC FIN-MART");
        try {
            pinfo = getPackageManager().getPackageInfo(getPackageName(), 0);
            versionNAme = pinfo.versionName;
        } catch (PackageManager.NameNotFoundException e) {
            e.printStackTrace();
        }


        try {
            Utility.getMacAddress(this);
        } catch (IOException e) {
            e.printStackTrace();
        }
        db = new DBPersistanceController(this);
        loginResponseEntity = db.getUserData();
        prefManager = new PrefManager(this);

        getNotificationAction();

        if (loginResponseEntity != null) {
            init_headers();

        }

        List<String> rtoDesc = db.getRTOListNames();


        if (savedInstanceState == null) {
            selectHome();


        }


        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            // This method will trigger on item Click of navigation menu
            @Override
            public boolean onNavigationItemSelected(MenuItem menuItem) {
                //Checking if the item is in checked state or not, if not make it in checked state
                if (menuItem.isChecked()) menuItem.setChecked(false);
                else menuItem.setChecked(true);
                //Closing drawer on item click
                drawerLayout.closeDrawers();
                //Check to see which item was being clicked and perform appropriate action
                Fragment fragment = null;
                switch (menuItem.getItemId()) {
                    //Replacing the main content with ContentFragment Which is our Inbox View;
                    case R.id.nav_home:
                        fragment = new DashboardFragment();
                        getSupportActionBar().setTitle("MAGIC FIN-MART");
                        //Toast.makeText(HomeActivity.this, "Dashboard", Toast.LENGTH_SHORT).show();
                        break;
                    case R.id.nav_sharedata:
                        fragment = new ShareDataFragment();
                        getSupportActionBar().setTitle("SHARE DATA");
                        break;
                    case R.id.nav_changepassword:
                        fragment = new ChangePasswordFragment();
                        getSupportActionBar().setTitle("CHANGE PASSWORD");
                        break;
                    // For rest of the options we just show a toast on click .
                    case R.id.nav_myaccount:
                        new TrackingController(HomeActivity.this).sendData(new TrackingRequestEntity(new TrackingData("My ACCOUNT : My ACCOUNT button in menu "), Constants.MY_ACCOUNT), null);
                        startActivity(new Intent(HomeActivity.this, MyAccountActivity.class));
                        //  startActivity(new Intent(HomeActivity.this, HomeLoanApplyActivity.class));
                        // fragment = new BasFragment();
                        // getSupportActionBar().setTitle("BAS 2016-17");
                        // Toast.makeText(HomeActivity.this, "my_account", Toast.LENGTH_SHORT).show();

                        //startActivity(new Intent(HomeActivity.this, MyAccountActivity.class));


                        break;

                    case R.id.nav_pospenrollment:
                        startActivity(new Intent(HomeActivity.this, PospEnrollment.class));
                        new TrackingController(HomeActivity.this).sendData(new TrackingRequestEntity(new TrackingData("Posp Enrollment : posp enrollment button in menu "), Constants.POSP), null);
                        break;

                    case R.id.nav_homeloanApplication:
                        startActivity(new Intent(HomeActivity.this, HomeLoanApplyActivity.class));
                        break;
                    case R.id.nav_offlineQuotes:
                        startActivity(new Intent(HomeActivity.this, UnderConstructionActivity.class));
                        new TrackingController(HomeActivity.this).sendData(new TrackingRequestEntity(new TrackingData("Offline Quotes : Offline Quotes button in menu "), Constants.OFFLINE_QUOTES), null);
                        break;
                    case R.id.nav_myBusiness:
                        startActivity(new Intent(HomeActivity.this, UnderConstructionActivity.class));
                        new TrackingController(HomeActivity.this).sendData(new TrackingRequestEntity(new TrackingData("My Business : My Business button in menu "), Constants.MY_BUSINESS), null);
                        break;
                    case R.id.nav_referFriend:
                        startActivity(new Intent(HomeActivity.this, UnderConstructionActivity.class));
                        new TrackingController(HomeActivity.this).sendData(new TrackingRequestEntity(new TrackingData("Refer A Friend : Refer A Friend button in menu "), Constants.REFER), null);
                        break;
                    case R.id.nav_mps:
                        // DialogMPS();
                        showDialog();
                        new MasterController(HomeActivity.this).getMpsData(HomeActivity.this);

                        // new TrackingController(HomeActivity.this).sendData(new TrackingRequestEntity(new TrackingData("MPS : MPS button in menu "), Constants.MPS), null);
                        //startActivity(new Intent(HomeActivity.this, UnderConstructionActivity.class));
                        break;
                    case R.id.nav_helpfeedback:
                        startActivity(new Intent(HomeActivity.this, HelpFeedBackActivity.class));
                        new TrackingController(HomeActivity.this).sendData(new TrackingRequestEntity(new TrackingData("HELP & FEEDBACK : HELP & FEEDBACK button in menu "), Constants.HELP), null);
                        break;
                    case R.id.nav_posptraining:
                        startActivity(new Intent(HomeActivity.this, com.datacomp.magicfinmart.pospapp.login.LoginActivity.class));
                        new TrackingController(HomeActivity.this).sendData(new TrackingRequestEntity(new TrackingData("POPS TRAINING : POPS TRAINING button in menu "), Constants.POSP_TRAINING), null);
                        break;
                    case R.id.nav_selfinspection:
                        startActivity(new Intent(HomeActivity.this, SplashScreen.class));
                        new TrackingController(HomeActivity.this).sendData(new TrackingRequestEntity(new TrackingData("INSPECTION : INSPECTION button in menu "), Constants.INSPECTION), null);
                        break;

                    case R.id.nav_whatsnew:
                        startActivity(new Intent(HomeActivity.this, WhatsNewActivity.class));
                        new TrackingController(HomeActivity.this).sendData(new TrackingRequestEntity(new TrackingData("Whats New : Whats New button in menu "), Constants.WHATSNEW), null);
                        break;

                    case R.id.nav_logout:
                        dialogLogout(HomeActivity.this);
                        break;

                    default:
                        break;
                }

                if (fragment != null) {
                    android.support.v4.app.FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
                    fragmentTransaction.replace(R.id.frame, fragment);
                    fragmentTransaction.commit();

                    return true;
                }
                return false;
            }
        });

        ActionBarDrawerToggle actionBarDrawerToggle = new ActionBarDrawerToggle(this,
                drawerLayout,
                toolbar,
                R.string.openDrawer,
                R.string.closeDrawer) {

            @Override
            public void onDrawerClosed(View drawerView) {
                // Code here will be triggered once the drawer closes as we dont want anything to happen so we leave this blank
                super.onDrawerClosed(drawerView);
            }

            @Override
            public void onDrawerOpened(View drawerView) {
                // Code here will be triggered once the drawer open as we dont want anything to happen so we leave this blank
                super.onDrawerOpened(drawerView);
            }
        };

        //Setting the actionbarToggle to drawer layout
        drawerLayout.setDrawerListener(actionBarDrawerToggle);
        //calling sync state is necessay or else your hamburger icon wont show up
        actionBarDrawerToggle.syncState();
    }

    public void selectHome() {
        getSupportActionBar().setTitle("MAGIC FIN-MART");
        Fragment fragment = new DashboardFragment();
        getSupportFragmentManager().beginTransaction().replace(R.id.frame, fragment).commit();
    }

    // endregion


    private void init_headers() {
        View headerView = navigationView.getHeaderView(0);
        txtEntityName = (TextView) headerView.findViewById(R.id.txtEntityName);
        txtDetails = (TextView) headerView.findViewById(R.id.txtDetails);
        //txtFbaCode = (TextView) headerView.findViewById(R.id.txtFbaCode);

        txtEntityName.setText("Magic Finmart  v" + versionNAme);
        txtDetails.setText("" + loginResponseEntity.getFullName()
                + " (FBA ID : " + loginResponseEntity.getFBAId() + ")");
        //txtFbaCode.setText("FBA ID - " + loginResponseEntity.getFBAId());

        if (db.getAccountData() == null) {
            new RegisterController(HomeActivity.this).getMyAcctDtl(String.valueOf(loginResponseEntity.getFBAId()), HomeActivity.this);
        }
    }

    @Override
    public void onBackPressed() {
        if (isNavDrawerOpen()) {
            closeNavDrawer();
        } else {
            dialogExit();
            //super.onBackPressed();
        }
    }

    protected boolean isNavDrawerOpen() {
        return drawerLayout != null && drawerLayout.isDrawerOpen(GravityCompat.START);
    }

    protected void closeNavDrawer() {
        if (drawerLayout != null) {
            drawerLayout.closeDrawer(GravityCompat.START);
        }
    }

    private void getNotificationAction() {

        // region Activity Open Usnig Notification

        if (getIntent().getExtras() != null) {


            // step1: boolean verifyLogin = prefManager.getIsUserLogin();
            // region verifyUser : when user logout and when Apps in background
            if (loginResponseEntity == null) {

                NotifyEntity notifyEntity = getIntent().getExtras().getParcelable(Utility.PUSH_NOTIFY);
                if (notifyEntity == null) {
                    return;
                }

                if (notifyEntity.getNotifyFlag().matches("WB")) {

                    prefManager.setSharePushWebURL(notifyEntity.getWeb_url());
                    prefManager.setSharePushWebTitle(notifyEntity.getWeb_title());

                }
                prefManager.setSharePushType(notifyEntity.getNotifyFlag());

                Intent intent = new Intent(this, SplashScreenActivity.class);
                startActivity(intent);
                finish();


            }
            //endregion

            //  region step2: For Notification come via Login for user credential  (step2 perform after step1)
            else if (getIntent().getStringExtra(Utility.PUSH_LOGIN_PAGE) != null) {
                String pushLogin = getIntent().getStringExtra(Utility.PUSH_LOGIN_PAGE);
                if (pushLogin.equals("555")) {

                    String type = prefManager.getSharePushType();
                    String web_url = prefManager.getSharePushWebURL();
                    String web_title = prefManager.getSharePushWebTitle();
                    String web_name = "";
                    prefManager.clearNotification();

                    if (type.matches("NL")) {
                        Intent intent = new Intent(this, NotificationActivity.class);
                        startActivity(intent);

                    } else if (type.matches("WB")) {

                        startActivity(new Intent(HomeActivity.this, CommonWebViewActivity.class)
                                .putExtra("URL", web_url)
                                .putExtra("NAME", web_name)
                                .putExtra("TITLE", web_title));

                    }
                }

            }
            //endregion

            // region user already logged in and app in forground
            else if (getIntent().getExtras().getParcelable(Utility.PUSH_NOTIFY) != null) {
                NotifyEntity notificationEntity = getIntent().getExtras().getParcelable(Utility.PUSH_NOTIFY);
                if (notificationEntity.getNotifyFlag().matches("NL")) {
                    Intent intent = new Intent(this, NotificationActivity.class);
                    startActivity(intent);
                } else if (notificationEntity.getNotifyFlag().matches("WB")) {
                    String web_url = notificationEntity.getWeb_url();
                    String web_title = notificationEntity.getWeb_title();
                    String web_name = "";
                    startActivity(new Intent(HomeActivity.this, CommonWebViewActivity.class)
                            .putExtra("URL", web_url)
                            .putExtra("NAME", web_name)
                            .putExtra("TITLE", web_title));

                }
            }
            //endregion

        }

        ///

        //endregion
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.dashboard_menu, menu);

        final MenuItem menuItem = menu.findItem(R.id.action_push_notification);

        View actionView = MenuItemCompat.getActionView(menuItem);
        textNotifyItemCount = (TextView) actionView.findViewById(R.id.notify_badge);
        textNotifyItemCount.setVisibility(View.GONE);

        int PushCount = prefManager.getNotificationCounter();

        if (PushCount == 0) {
            textNotifyItemCount.setVisibility(View.GONE);
        } else {
            textNotifyItemCount.setVisibility(View.VISIBLE);
            textNotifyItemCount.setText("" + String.valueOf(PushCount));
        }

        actionView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                onOptionsItemSelected(menuItem);


            }
        });


        return true;

    }


    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        Intent intent;
        switch (item.getItemId()) {

            case R.id.action_push_notification:
                intent = new Intent(HomeActivity.this, NotificationActivity.class);
                startActivityForResult(intent, Constants.REQUEST_CODE);
                break;

        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    public void OnSuccess(APIResponse response, String message) {
        cancelDialog();
        if (response instanceof MpsResponse) {

            if (response.getStatusNo() == 0) {

                prefManager.removeMps();
                prefManager.setMPS(((MpsResponse) response).getMasterData());
                if (loginResponseEntity.getIsFirstLogin() == 1) {
                    DialogMPS();
                } else {
                    DialogMPS();
                }

            }
        } else if (response instanceof MyAcctDtlResponse) {
            if (response.getStatusNo() == 0) {
                if (((MyAcctDtlResponse) response).getMasterData().get(0) != null) {
                    db.updateMyAccountData(((MyAcctDtlResponse) response).getMasterData().get(0));
                }
            }
        }
        if (response instanceof ConstantsResponse) {
            constantEntity = ((ConstantsResponse) response).getMasterData();
            if (response.getStatusNo() == 0) {

                //region check for new vwesion
                int serverVersionCode = Integer.parseInt(((ConstantsResponse) response).getMasterData().getVersionCode());
                if (pinfo != null && pinfo.versionCode < serverVersionCode) {
                    forceUpdate = Integer.parseInt(((ConstantsResponse) response).getMasterData().getIsForceUpdate());
                    if (forceUpdate == 1) {
                        // forced update app
                        openPopUp(navigationView, "UPDATE", "New version available on play store!!!! Please update.", "OK", false);
                    } else {
                        // aap with less version but not forced update
                        if (prefManager.getUpdateShown()) {
                            prefManager.setIsUpdateShown(false);
                            openPopUp(navigationView, "UPDATE", "New version available on play store!!!! Please update.", "OK", true);
                        }
                    }

                    if (new DBPersistanceController(this).getUserData().getIsFirstLogin() == 1) {
                        for (Fragment frg :
                                getSupportFragmentManager().getFragments()) {

                            if (frg instanceof MPSFragment || frg instanceof KnowMoreMPSFragment) {
                                if (!frg.isVisible()) {
                                    Log.d("TAG", "CONSTANTS");
                                    //DialogMPS();
                                }
                            }
                        }
                    }

                } else if (((ConstantsResponse) response).getMasterData().
                        getMPSStatus().toLowerCase().equalsIgnoreCase("p")) {

                    /*for (Fragment frg :
                            getSupportFragmentManager().getFragments()) {

                        if (frg instanceof MPSFragment || frg instanceof KnowMoreMPSFragment) {
                            if (!frg.isVisible()) {
                                if (prefManager.getMps() != null) {
                                    DialogMPS();
                                }
                            }
                        } else {
                            if (prefManager.getMps() != null) {
                                DialogMPS();
                            }
                        }
                    }*/

                }
                //endregion

                hideNavigationItem();
            }
        }


    }

    @Override
    public void OnFailure(Throwable t) {
        cancelDialog();
        openPopUp(toolbar, "Message", "" + t.getMessage(), "OK", true);
    }

    @Override
    public void onPositiveButtonClick(Dialog dialog, View view) {
        dialog.cancel();
    }

    @Override
    public void onCancelButtonClick(Dialog dialog, View view) {
        dialog.cancel();
    }

    @Override
    protected void onResume() {
        super.onResume();

        if (prefManager.getMps() == null) {
            //new MasterController(HomeActivity.this).getMpsData(HomeActivity.this);
        }

        // set first fragement selected.
        selectHome();


        new MasterController(this).getConstants(this);

        LocalBroadcastManager.getInstance(HomeActivity.this).registerReceiver(mHandleMessageReceiver, new IntentFilter(Utility.PUSH_BROADCAST_ACTION));

    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        LocalBroadcastManager.getInstance(this).unregisterReceiver(mHandleMessageReceiver);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == Constants.REQUEST_CODE) {
            if (data != null) {
                int Counter = prefManager.getNotificationCounter();
                textNotifyItemCount.setText("" + Counter);
                textNotifyItemCount.setVisibility(View.GONE);

            }

        }
    }

    public void hideNavigationItem() {
        Menu nav_Menu = navigationView.getMenu();
        if (Utility.checkPospTrainingStatus(this) == 1)
            nav_Menu.findItem(R.id.nav_posptraining).setVisible(true);
        else
            nav_Menu.findItem(R.id.nav_posptraining).setVisible(false);
    }

    //region mps dialog

    public void DialogMPS() {
        if (prefManager.getMps() != null) {
            AlertDialog.Builder mpsAlertBuilder;
            mpsAlertBuilder = new AlertDialog.Builder(this);
            mpsAlertBuilder.setCancelable(true);
            // builder.setTitle("PREMIUM DETAIL");
            LayoutInflater inflater = this.getLayoutInflater();
            View view = inflater.inflate(R.layout.layout_dialog_mps, null);
            mpsAlertBuilder.setView(view);

            if (mpsDialog == null) {
                mpsDialog = mpsAlertBuilder.create();
            }

            TextView txtDesc = (TextView) view.findViewById(R.id.txtDesc);
            TextView txtKnowMore = (TextView) view.findViewById(R.id.txtKnowMore);
            TextView txtGetMPS = (TextView) view.findViewById(R.id.txtGetMPS);
            TextView txtLater = (TextView) view.findViewById(R.id.txtLater);

            txtDesc.setText("");
            txtDesc.append(getResources().getString(R.string.mps_popup_text));

            String amount = " \u20B9" + prefManager.getMps().getTotalAmt() + "/- ";
            SpannableString ss1 = new SpannableString(amount);
            ss1.setSpan(new StyleSpan(Typeface.BOLD), 0, ss1.length(), 0);
            String normalText = getResources().getString(R.string.mps_popup_text);
            txtDesc.setText("");
            txtDesc.append(normalText);
            txtDesc.append(ss1);
            txtDesc.append("(Incl. GST) only");

            txtLater.setTag(R.id.txtLater, mpsDialog);
            txtGetMPS.setTag(R.id.txtGetMPS, mpsDialog);
            txtKnowMore.setTag(R.id.txtKnowMore, mpsDialog);

            txtKnowMore.setOnClickListener(onClickListener);
            txtGetMPS.setOnClickListener(onClickListener);
            txtLater.setOnClickListener(onClickListener);

            if (!mpsDialog.isShowing())
                mpsDialog.show();
        }

    }

    View.OnClickListener onClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {

            switch (v.getId()) {
                case R.id.txtKnowMore:
                    ((AlertDialog) v.getTag(R.id.txtKnowMore)).dismiss();
                    android.support.v4.app.FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
                    fragmentTransaction.replace(R.id.frame, new KnowMoreMPSFragment());
                    fragmentTransaction.commit();
                    break;
                case R.id.txtGetMPS:
                    ((AlertDialog) v.getTag(R.id.txtGetMPS)).dismiss();
                    redirectMPS();

                    break;
                case R.id.txtLater:
                    ((AlertDialog) v.getTag(R.id.txtLater)).dismiss();
                    break;

            }
        }
    };

    public void redirectMPS() {
        android.support.v4.app.FragmentTransaction fragmentTransaction;
        fragmentTransaction = getSupportFragmentManager().beginTransaction();
        fragmentTransaction.replace(R.id.frame, new MPSFragment());
        fragmentTransaction.commit();
    }
    //endregion
}
