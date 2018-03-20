package com.datacomp.magicfinmart.home;

import android.app.Dialog;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.content.LocalBroadcastManager;
import android.support.v4.view.GravityCompat;
import android.support.v4.view.MenuItemCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.datacomp.magicfinmart.BaseActivity;
import com.datacomp.magicfinmart.R;
import com.datacomp.magicfinmart.dashboard.DashboardFragment;
import com.datacomp.magicfinmart.helpfeedback.HelpFeedBackActivity;
import com.datacomp.magicfinmart.loan_fm.homeloan.application.HomeLoanApplicationActivity;
import com.datacomp.magicfinmart.login.LoginActivity;
import com.datacomp.magicfinmart.myaccount.MyAccountActivity;
import com.datacomp.magicfinmart.notification.NotificationActivity;
import com.datacomp.magicfinmart.posp.PospEnrollment;
import com.datacomp.magicfinmart.underconstruction.UnderConstructionActivity;
import com.datacomp.magicfinmart.utility.Constants;
import com.datacomp.magicfinmart.webviews.CommonWebViewActivity;
import com.datacomp.magicfinmart.whatsnew.WhatsNewActivity;

import java.util.List;

import magicfinmart.datacomp.com.finmartserviceapi.PrefManager;
import magicfinmart.datacomp.com.finmartserviceapi.Utility;
import magicfinmart.datacomp.com.finmartserviceapi.database.DBPersistanceController;
import magicfinmart.datacomp.com.finmartserviceapi.finmart.APIResponse;
import magicfinmart.datacomp.com.finmartserviceapi.finmart.IResponseSubcriber;
import magicfinmart.datacomp.com.finmartserviceapi.finmart.controller.masters.MasterController;
import magicfinmart.datacomp.com.finmartserviceapi.finmart.model.LoginResponseEntity;
import magicfinmart.datacomp.com.finmartserviceapi.finmart.model.NotifyEntity;
import magicfinmart.datacomp.com.finmartserviceapi.finmart.response.MpsResponse;

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
    NotifyEntity notifyEntity;
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
        db = new DBPersistanceController(this);
        loginResponseEntity = db.getUserData();
        prefManager = new PrefManager(this);
        init_headers();
        List<String> rtoDesc = db.getRTOListNames();

        // set first fragement selected.
        navigationView.getMenu().getItem(0).setChecked(true);

        if (savedInstanceState == null) {
            getSupportActionBar().setTitle("MAGIC FIN-MART");
            Fragment fragment = new DashboardFragment();
            getSupportFragmentManager().beginTransaction().replace(R.id.frame, fragment).commit();

        }

        getNotificationAction();
        //   Setting Navigation View Item Selected Listener to handle the item click of the navigation menu
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
                        Toast.makeText(HomeActivity.this, "Dashboard", Toast.LENGTH_SHORT).show();
                        break;
                    // For rest of the options we just show a toast on click .
                    case R.id.nav_myaccount: {

                        startActivity(new Intent(HomeActivity.this, MyAccountActivity.class));
                        //  startActivity(new Intent(HomeActivity.this, HomeLoanApplyActivity.class));
                        // fragment = new BasFragment();
                        // getSupportActionBar().setTitle("BAS 2016-17");
                        // Toast.makeText(HomeActivity.this, "my_account", Toast.LENGTH_SHORT).show();

                        //startActivity(new Intent(HomeActivity.this, MyAccountActivity.class));


                        break;
                    }
                    case R.id.nav_pospenrollment: {
                        startActivity(new Intent(HomeActivity.this, PospEnrollment.class));
                        break;
                    }
                    case R.id.nav_homeloanApplication:
                        startActivity(new Intent(HomeActivity.this, HomeLoanApplicationActivity.class));
                        break;
                    case R.id.nav_offlineQuotes:
                        startActivity(new Intent(HomeActivity.this, UnderConstructionActivity.class));
                        break;
                    case R.id.nav_myBusiness:
                        startActivity(new Intent(HomeActivity.this, UnderConstructionActivity.class));
                        break;
                    case R.id.nav_referFriend:
                        startActivity(new Intent(HomeActivity.this, UnderConstructionActivity.class));
                        break;
                    case R.id.nav_mps:
                        showDialog();
                        new MasterController(HomeActivity.this).getMpsData(HomeActivity.this);
                        //startActivity(new Intent(HomeActivity.this, UnderConstructionActivity.class));
                        break;
                    case R.id.nav_helpfeedback:
                        startActivity(new Intent(HomeActivity.this, HelpFeedBackActivity.class));
                        break;

                    case R.id.nav_whatsnew:
                        startActivity(new Intent(HomeActivity.this, WhatsNewActivity.class));
                        break;

                    case R.id.nav_logout:
                        new DBPersistanceController(HomeActivity.this).logout();
                        new PrefManager(HomeActivity.this).deletePospInfo();
                        Intent intent = new Intent(HomeActivity.this, LoginActivity.class);
                        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                        startActivity(intent);
                        finish();
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

    private void init_headers() {
        View headerView = navigationView.getHeaderView(0);
        txtEntityName = (TextView) headerView.findViewById(R.id.txtEntityName);
        txtDetails = (TextView) headerView.findViewById(R.id.txtDetails);
        txtFbaCode = (TextView) headerView.findViewById(R.id.txtFbaCode);

        txtEntityName.setText("Magic Finmart v" + versionNAme);
        txtDetails.setText("" + loginResponseEntity.getFullName());
        txtFbaCode.setText("FBA ID - " + loginResponseEntity.getFBAId());

    }

    @Override
    public void onBackPressed() {
        if (isNavDrawerOpen()) {
            closeNavDrawer();
        } else {
            super.onBackPressed();
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


            boolean verifyLogin = prefManager.getIsUserLogin();
            // region verifyUser : when user logout and when Apps in background
            if (verifyLogin == false || loginResponseEntity == null) {
                //username and password are present, do your stuff
               NotifyEntity notifyEntity = getIntent().getExtras().getParcelable(Utility.PUSH_NOTIFY);
               if(notifyEntity == null)
               {
                   return;
               }

                if (notifyEntity.getNotifyFlag().matches("WB")) {

                    prefManager.setSharePushWebURL(notifyEntity.getWeb_url());
                    prefManager.setSharePushWebTitle(notifyEntity.getWeb_title());

                }
                prefManager.setSharePushType(notifyEntity.getNotifyFlag());

                Intent intent = new Intent(this, LoginActivity.class);
                startActivity(intent);
                finish();

            }
            //endregion

            // region For Notification come via Login for user credential
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
            else if (getIntent().getStringExtra(Utility.PUSH_NOTIFY) != null) {
                String type = getIntent().getStringExtra(Utility.PUSH_NOTIFY);
                if (type.matches("NL")) {
                    Intent intent = new Intent(this, NotificationActivity.class);
                    startActivity(intent);
                } else if (type.matches("WB")) {
                    String web_url = prefManager.getSharePushWebURL();
                    String web_title = prefManager.getSharePushWebTitle();
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
        if (response instanceof MpsResponse) {
            cancelDialog();
            if (response.getStatusNo() == 0) {
                if (((MpsResponse) response).getMasterData().getPaymentURL() != null) {
                    startActivity(new Intent(this, CommonWebViewActivity.class)
                            .putExtra("URL", ((MpsResponse) response).getMasterData().getPaymentURL())
                            .putExtra("NAME", "MPS")
                            .putExtra("TITLE", "MPS"));
                }
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
                int  Counter =  prefManager.getNotificationCounter()  ;
                textNotifyItemCount.setText("" +Counter);
                textNotifyItemCount.setVisibility(View.GONE);

            }

        }
    }
}
