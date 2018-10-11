package com.datacomp.magicfinmart.home;

import android.Manifest;
import android.app.ActivityOptions;
import android.app.Dialog;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.graphics.Typeface;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.provider.Settings;
import android.support.design.widget.NavigationView;
import android.support.v4.app.ActivityCompat;
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
import android.util.Pair;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.bumptech.glide.load.resource.drawable.GlideDrawable;
import com.bumptech.glide.request.animation.GlideAnimation;
import com.bumptech.glide.request.target.SimpleTarget;
import com.datacomp.magicfinmart.BaseActivity;
import com.datacomp.magicfinmart.R;
import com.datacomp.magicfinmart.change_password.ChangePasswordFragment;
import com.datacomp.magicfinmart.dashboard.DashboardFragment;
import com.datacomp.magicfinmart.generatelead.GenerateLeadActivity;
import com.datacomp.magicfinmart.helpfeedback.HelpFeedBackActivity;
import com.datacomp.magicfinmart.loan_fm.homeloan.loan_apply.HomeLoanApplyActivity;
import com.datacomp.magicfinmart.mps.KnowMoreMPSFragment;
import com.datacomp.magicfinmart.mps.MPSFragment;
import com.datacomp.magicfinmart.myaccount.MyAccountActivity;
import com.datacomp.magicfinmart.notification.NotificationActivity;
import com.datacomp.magicfinmart.notification.NotificationSmsActivity;
import com.datacomp.magicfinmart.onlineexpressloan.QuoteList.AppliedOnlineLoanListActivity;
import com.datacomp.magicfinmart.posp.POSPListFragment;
import com.datacomp.magicfinmart.posp.PospEnrollment;
import com.datacomp.magicfinmart.share_data.ShareDataFragment;
import com.datacomp.magicfinmart.splashscreen.SplashScreenActivity;
import com.datacomp.magicfinmart.underconstruction.UnderConstructionActivity;
import com.datacomp.magicfinmart.utility.CircleTransform;
import com.datacomp.magicfinmart.utility.Constants;
import com.datacomp.magicfinmart.vehicle_details.VehicleDetailFragment;
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
import magicfinmart.datacomp.com.finmartserviceapi.finmart.model.MenuItemEntity;
import magicfinmart.datacomp.com.finmartserviceapi.finmart.model.MenuMasterResponse;
import magicfinmart.datacomp.com.finmartserviceapi.finmart.model.NotifyEntity;
import magicfinmart.datacomp.com.finmartserviceapi.finmart.model.TrackingData;
import magicfinmart.datacomp.com.finmartserviceapi.finmart.model.UserConstantEntity;
import magicfinmart.datacomp.com.finmartserviceapi.finmart.requestentity.TrackingRequestEntity;
import magicfinmart.datacomp.com.finmartserviceapi.finmart.response.ConstantsResponse;
import magicfinmart.datacomp.com.finmartserviceapi.finmart.response.MpsResponse;
import magicfinmart.datacomp.com.finmartserviceapi.finmart.response.MyAcctDtlResponse;
import magicfinmart.datacomp.com.finmartserviceapi.finmart.response.UserConstatntResponse;

public class HomeActivity extends BaseActivity implements IResponseSubcriber, BaseActivity.PopUpListener, BaseActivity.PermissionListener {

    final String TAG = "HOME";
    private Toolbar toolbar;
    private NavigationView navigationView;
    private DrawerLayout drawerLayout;
    TextView textNotifyItemCount, txtEntityName, txtDetails, txtReferalCode, txtFbaID, txtPospNo;
    ImageView ivProfile;
    LoginResponseEntity loginResponseEntity;
    DBPersistanceController db;
    String versionNAme;
    PackageInfo pinfo;
    PrefManager prefManager;
    int forceUpdate;
    ConstantEntity constantEntity;
    AlertDialog mpsDialog;
    String[] permissionsRequired = new String[]{Manifest.permission.CALL_PHONE};
    UserConstantEntity userConstantEntity;
    MenuMasterResponse menuMasterResponse;

    //region broadcast receiver
    public BroadcastReceiver mHandleMessageReceiver = new BroadcastReceiver() {

        @Override
        public void onReceive(Context context, Intent intent) {

            if (intent.getAction() != null) {
                if (intent.getAction().equalsIgnoreCase(Utility.PUSH_BROADCAST_ACTION)) {
                    int notifyCount = prefManager.getNotificationCounter();

                    if (notifyCount == 0) {
                        textNotifyItemCount.setVisibility(View.GONE);
                    } else {
                        textNotifyItemCount.setVisibility(View.VISIBLE);
                        textNotifyItemCount.setText("" + String.valueOf(notifyCount));
                    }
                } else if (intent.getAction().equalsIgnoreCase(Utility.USER_PROFILE_ACTION)) {
                    String PROFILE_PATH = intent.getStringExtra("PROFILE_PATH");

                    Glide.with(HomeActivity.this)
                            .load(Uri.parse(PROFILE_PATH))
                            .placeholder(R.drawable.finmart_user_icon)
                            .diskCacheStrategy(DiskCacheStrategy.NONE)
                            .skipMemoryCache(true)
                            .override(64, 64)
                            .transform(new CircleTransform(HomeActivity.this)) // applying the image transformer
                            .into(ivProfile);

                } else if (intent.getAction().equalsIgnoreCase(Utility.USER_DASHBOARD)) {

                }
            }

        }
    };

    //endregion

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        registerPopUp(this);
        registerPermission(this);
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
        userConstantEntity = db.getUserConstantsData();
        prefManager = new PrefManager(this);

        getNotificationAction();

        init_headers();


        if (savedInstanceState == null) {
            selectHome();
        }

        if (loginResponseEntity != null) {

            new MasterController(this).getMenuMaster(this);
            new MasterController(this).geUserConstant(1, this);
            new MasterController(this).getConstants(this);
            new MasterController(this).getInsuranceSubType(this);
        }


        //region navigation click
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

                Constants.hideKeyBoard(drawerLayout, HomeActivity.this);
                Fragment fragment = null;

                //hide keyboard
                Constants.hideKeyBoard(drawerLayout, HomeActivity.this);
                if (menuMasterResponse != null) {
                    for (MenuItemEntity menuItemEntity : menuMasterResponse.getMasterData().getMenu()) {
                        int sequence = Integer.parseInt(menuItemEntity.getSequence());
                        sequence = (sequence * 100) + 1;
                        if (menuItem.getItemId() == sequence) {
                            startActivity(new Intent(HomeActivity.this, CommonWebViewActivity.class)
                                    .putExtra("URL", menuItemEntity.getLink())
                                    .putExtra("NAME", menuItemEntity.getMenuname())
                                    .putExtra("TITLE", menuItemEntity.getMenuname()));
                            return true;
                        }
                    }
                }


                switch (menuItem.getItemId()) {

                    case R.id.nav_generateLead:
                        startActivity(new Intent(HomeActivity.this, GenerateLeadActivity.class));
                        break;

                    //added by Nilesh
                    case R.id.nav_vehicleinfo:
                        getSupportActionBar().setTitle("VEHICLE DETAIL");
                        fragment = new VehicleDetailFragment();
                        break;

                    case R.id.nav_expressLoan:
                        startActivity(new Intent(HomeActivity.this, AppliedOnlineLoanListActivity.class));
                        break;
                    //Replacing the main content with ContentFragment Which is our Inbox View;
                    case R.id.nav_yesbankbot:
                        startActivity(new Intent(HomeActivity.this, CommonWebViewActivity.class)
                                .putExtra("URL", "https://yesbankbot.buildquickbots.com/chat/rupeeboss/staff/?userid=" + String.valueOf(loginResponseEntity.getFBAId()) + "&usertype=FBA&vkey=b34f02e9-8f1c")
                                .putExtra("NAME", "" + "YES BANK BOT")
                                .putExtra("TITLE", "" + "YES BANK BOT"));

                        break;
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
                    case R.id.nav_addposp:
                        fragment = new POSPListFragment();
                        getSupportActionBar().setTitle("POSP List");
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
                    /*case R.id.nav_posptraining:
                        startActivity(new Intent(HomeActivity.this, com.datacomp.magicfinmart.pospapp.login.LoginActivity.class));
                        new TrackingController(HomeActivity.this).sendData(new TrackingRequestEntity(new TrackingData("POPS TRAINING : POPS TRAINING button in menu "), Constants.POSP_TRAINING), null);
                        break;
                    case R.id.nav_selfinspection:
                        startActivity(new Intent(HomeActivity.this, SplashScreen.class));
                        // startActivity(new Intent(HomeActivity.this, PreviewVideoActivity.class));
                        new TrackingController(HomeActivity.this).sendData(new TrackingRequestEntity(new TrackingData("INSPECTION : INSPECTION button in menu "), Constants.INSPECTION), null);
                        break;*/

                    case R.id.nav_whatsnew:
                        startActivity(new Intent(HomeActivity.this, WhatsNewActivity.class));
                        new TrackingController(HomeActivity.this).sendData(new TrackingRequestEntity(new TrackingData("Whats New : Whats New button in menu "), Constants.WHATSNEW), null);
                        break;
                    case R.id.nav_franchise:
                        startActivity(new Intent(HomeActivity.this, CommonWebViewActivity.class)
                                .putExtra("URL", "http://erp.rupeeboss.com/FM/Franchise_Agreement.pdf")
                                .putExtra("NAME", "FRANCHISE_AGREEMENT")
                                .putExtra("TITLE", "FRANCHISE AGREEMENT"));
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
        //regionend

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

    private void addDynamicMenu(List<MenuItemEntity> list) {
        Menu menu = navigationView.getMenu();

        for (int i = 1; i <= list.size() && (list.get(i - 1).getIsActive() == 1); i++) {
            int sequence = Integer.parseInt(list.get(i - 1).getSequence());
            sequence = (sequence * 100) + 1;
            final MenuItem menuItem = menu.add(R.id.dashboard_menu_group, sequence, sequence, list.get(i - 1).getMenuname());
            Glide.with(this)
                    .load(list.get(i - 1).getIconimage())
                    .into(new SimpleTarget<GlideDrawable>() {
                        @Override
                        public void onResourceReady(GlideDrawable resource, GlideAnimation<? super GlideDrawable> glideAnimation) {
                            menuItem.setIcon(resource);
                        }
                    });


        }

        /*final MenuItem menuItem = menu.add(R.id.dashboard_menu_group, R.id.nav_myaccount, 0, "itemid");
        Glide.with(this)
                .load("https://cdn0.iconfinder.com/data/icons/small-n-flat/24/678110-sign-info-128.png")
                .into(new SimpleTarget<GlideDrawable>() {
                    @Override
                    public void onResourceReady(GlideDrawable resource, GlideAnimation<? super GlideDrawable> glideAnimation) {
                        menuItem.setIcon(resource);
                    }
                });*/
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
        txtReferalCode = (TextView) headerView.findViewById(R.id.txtReferalCode);
        txtFbaID = (TextView) headerView.findViewById(R.id.txtFbaID);
        txtPospNo = (TextView) headerView.findViewById(R.id.txtPospNo);
        ivProfile = (ImageView) headerView.findViewById(R.id.ivProfile);

        ivProfile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                    Intent shareIntent = new Intent(HomeActivity.this, MyAccountActivity.class);
                    Pair[] pairs = new Pair[1];
                    pairs[0] = new Pair<View, String>(ivProfile, "profileTransition");
                    ActivityOptions options = ActivityOptions.makeSceneTransitionAnimation(HomeActivity.this, pairs);
                    startActivity(shareIntent, options.toBundle());
                } else {
                    startActivity(new Intent(HomeActivity.this, MyAccountActivity.class));
                }


            }
        });

        txtEntityName.setText("v" + versionNAme);

        if (loginResponseEntity != null) {

            txtDetails.setText("" + loginResponseEntity.getFullName());
            txtFbaID.setText("Fba Id - " + loginResponseEntity.getFBAId());
            txtReferalCode.setText("Referral Code - " + loginResponseEntity.getReferer_code());
        } else {
            txtDetails.setText("");
            txtFbaID.setText("Fba Id - ");
            txtReferalCode.setText("Referral Code - ");
        }
        if (userConstantEntity != null) {
            txtPospNo.setText("Posp No - " + userConstantEntity.getPospselfid());

            Glide.with(HomeActivity.this)
                    .load(Uri.parse(userConstantEntity.getLoansendphoto()))
                    .placeholder(R.drawable.circle_placeholder)
                    .diskCacheStrategy(DiskCacheStrategy.NONE)
                    .skipMemoryCache(true)
                    .override(64, 64)
                    .transform(new CircleTransform(HomeActivity.this)) // applying the image transformer
                    .into(ivProfile);
        } else {
            txtPospNo.setText("");
            Glide.with(HomeActivity.this)
                    .load(R.drawable.finmart_user_icon)
                    .placeholder(R.drawable.circle_placeholder)
                    .transform(new CircleTransform(HomeActivity.this)) // applying the image transformer
                    .diskCacheStrategy(DiskCacheStrategy.NONE)
                    .skipMemoryCache(true)
                    .override(64, 64)
                    .into(ivProfile);
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

            // For getting User Click Action
            if (getIntent().getExtras().getParcelable(Utility.PUSH_NOTIFY) != null) {
                NotifyEntity notifyEntity = getIntent().getExtras().getParcelable(Utility.PUSH_NOTIFY);
                String MESSAGEID = notifyEntity.getMessage_id();

                new RegisterController(HomeActivity.this).getUserClickActionOnNotification(MESSAGEID, null);
            }
            // step1: boolean verifyLogin = prefManager.getIsUserLogin();
            // region verifyUser : when user logout and when Apps in background
            if (loginResponseEntity == null) {

                NotifyEntity notifyEntity = getIntent().getExtras().getParcelable(Utility.PUSH_NOTIFY);
                if (notifyEntity == null) {
                    return;
                }

                prefManager.setPushNotifyPreference(notifyEntity);
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

                    NotifyEntity notifyEntity;
                    String type = "", title = "", body = "", web_url = "", web_title = "", web_name = "";
                    if (prefManager.getPushNotifyPreference() != null) {
                        notifyEntity = prefManager.getPushNotifyPreference();

                        type = notifyEntity.getNotifyFlag();
                        title = notifyEntity.getTitle();
                        body = notifyEntity.getBody();
                        web_url = notifyEntity.getWeb_url();
                        web_title = notifyEntity.getWeb_title();

                    }

                    prefManager.clearNotification();

                    if (type.matches("NL")) {
                        Intent intent = new Intent(this, NotificationActivity.class);
                        startActivity(intent);

                    } else if (type.matches("MSG")) {

                        startActivity(new Intent(HomeActivity.this, NotificationSmsActivity.class)
                                .putExtra("NOTIFY_TITLE", title)
                                .putExtra("NOTIFY_BODY", body));

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
                } else if (notificationEntity.getNotifyFlag().matches("MSG")) {

                    String title = notificationEntity.getTitle();
                    String body = notificationEntity.getBody();

                    startActivity(new Intent(HomeActivity.this, NotificationSmsActivity.class)
                            .putExtra("NOTIFY_TITLE", title)
                            .putExtra("NOTIFY_BODY", body));

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

        //  SearchView actionView = (SearchView) menuItem.getActionView();

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

            case R.id.action_call:
                if (constantEntity.getHelpNumber() != null) {

                    if (ActivityCompat.checkSelfPermission(HomeActivity.this, permissionsRequired[0]) != PackageManager.PERMISSION_GRANTED) {

                        if (ActivityCompat.shouldShowRequestPermissionRationale(HomeActivity.this, permissionsRequired[0])) {
                            //Show Information about why you need the permission
                            ActivityCompat.requestPermissions(HomeActivity.this, permissionsRequired, Constants.PERMISSION_CALLBACK_CONSTANT);

                        } else {
                            //Previously Permission Request was cancelled with 'Dont Ask Again',
                            // Redirect to Settings after showing Information about why you need the permission

                            permissionAlert(navigationView, "Need Call Permission", "This app needs Call permission.");


                        }
                    } else {

                        ConfirmAlert("Calling", getResources().getString(R.string.RM_Calling) + " " + userConstantEntity.getManagName());

                    }
                }


                break;
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
        } else if (response instanceof UserConstatntResponse) {
            if (response.getStatusNo() == 0) {
                if (((UserConstatntResponse) response).getMasterData() != null) {
                    //db.updateUserConstatntData(((UserConstatntResponse) response).getMasterData());
                    userConstantEntity = ((UserConstatntResponse) response).getMasterData();
                    init_headers();
                }
            }
        } else if (response instanceof ConstantsResponse) {
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
        } else if (response instanceof MenuMasterResponse) {
            if (response.getStatusNo() == 0) {
                menuMasterResponse = (MenuMasterResponse) response;
                prefManager.storeMenuDashboard(menuMasterResponse);
                addDynamicMenu(menuMasterResponse.getMasterData().getMenu());
                //refreshDashboard();


                Intent dashboardIntent = new Intent(Utility.USER_DASHBOARD);
                //dashboardIntent.putExtra("USER_DASHBOARD", ((MenuMasterResponse) response).getMasterData());
                LocalBroadcastManager.getInstance(HomeActivity.this).sendBroadcast(dashboardIntent);
            }
        }


    }

    private void refreshDashboard() {
        /*Intent profileIntent = new Intent(Utility.USER_DASHBOARD);
        profileIntent.putExtra("USER_DASHBOARD", ((MenuMasterResponse) response).getMasterData().get(0).getPrv_file());

        LocalBroadcastManager.getInstance(HomeActivity.this).sendBroadcast(profileIntent);*/

    }

    @Override
    public void OnFailure(Throwable t) {
        cancelDialog();
        //openPopUp(toolbar, "Message", "" + t.getMessage(), "OK", true);
    }

    @Override
    public void onPositiveButtonClick(Dialog dialog, View view) {
        //dialog.cancel();
        openAppMarketPlace();
    }

    @Override
    public void onCancelButtonClick(Dialog dialog, View view) {

        if (forceUpdate == 1) {

        } else {
            dialog.cancel();
        }
    }

    private void openAppMarketPlace() {
        final String appPackageName = this.getPackageName(); // getPackageName() from Context or Activity object
        try {
            startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("market://details?id=" + appPackageName)));
        } catch (android.content.ActivityNotFoundException anfe) {
            startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("https://play.google.com/store/apps/details?id=" + appPackageName)));
        }
        new TrackingController(this).sendData(new TrackingRequestEntity(new TrackingData("Update : User open marketplace  "), "Update"), null);
    }

    @Override
    protected void onResume() {
        super.onResume();

        if (prefManager.getMps() == null) {
            //new MasterController(HomeActivity.this).getMpsData(HomeActivity.this);
        }

        // set first fragement selected.
        //selectHome();


        LocalBroadcastManager.getInstance(HomeActivity.this).registerReceiver(mHandleMessageReceiver, new IntentFilter(Utility.PUSH_BROADCAST_ACTION));

        LocalBroadcastManager.getInstance(HomeActivity.this)
                .registerReceiver(mHandleMessageReceiver, new IntentFilter(Utility.USER_PROFILE_ACTION));

        LocalBroadcastManager.getInstance(HomeActivity.this)
                .registerReceiver(mHandleMessageReceiver,
                        new IntentFilter(Utility.USER_DASHBOARD));

    }


    @Override
    protected void onDestroy() {
        super.onDestroy();
        LocalBroadcastManager.getInstance(this).unregisterReceiver(mHandleMessageReceiver);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        Log.d("RESULT", "Activity");
        if (requestCode == Constants.REQUEST_CODE) {
            if (data != null) {
                int Counter = prefManager.getNotificationCounter();
                textNotifyItemCount.setText("" + Counter);
                textNotifyItemCount.setVisibility(View.GONE);

            }

        }
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, String permissions[], int[] grantResults) {

        switch (requestCode) {
            case Constants.PERMISSION_CALLBACK_CONSTANT:
                if (grantResults.length > 0) {

                    //boolean writeExternal = grantResults[0] == PackageManager.PERMISSION_GRANTED;
                    boolean call_phone = grantResults[0] == PackageManager.PERMISSION_GRANTED;

                    if (call_phone) {


//                        Intent intentCalling = new Intent(Intent.ACTION_CALL);
//                        intentCalling.setData(Uri.parse("tel:" + db.getConstantsData().getHelpNumber()));
//                        if (ActivityCompat.checkSelfPermission(this, Manifest.permission.CALL_PHONE) != PackageManager.PERMISSION_GRANTED) {
//                            // TODO: Consider calling
//
//                            return;
//                        }
//                        startActivity(intentCalling);

                        ConfirmAlert("Calling", getResources().getString(R.string.RM_Calling) + " " + userConstantEntity.getManagName());


                    }

                }
                break;
        }
    }

    public void hideNavigationItem() {
        Menu nav_Menu = navigationView.getMenu();
        if (Utility.checkPospTrainingStatus(this) == 1)
            nav_Menu.findItem(R.id.nav_posptraining).setVisible(false);
        else
            nav_Menu.findItem(R.id.nav_posptraining).setVisible(false);

        //todo : check key from userconstant to hide add posp
        if (userConstantEntity.getAddPospVisible() != null && !userConstantEntity.getAddPospVisible().equals("")) {
            int visibility = Integer.parseInt(userConstantEntity.getAddPospVisible());
            if (visibility == 1)
                nav_Menu.findItem(R.id.nav_addposp).setVisible(true);
            else
                nav_Menu.findItem(R.id.nav_addposp).setVisible(false);
        }

    }


    public void ConfirmAlert(String Title, String strBody) {
        try {
            AlertDialog.Builder builder = new AlertDialog.Builder(HomeActivity.this);
            builder.setTitle(Title);

            builder.setMessage(strBody);
            String positiveText = "Call";
            String NegativeText = "Cancel";
            builder.setPositiveButton(positiveText,
                    new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {


                            if (ActivityCompat.checkSelfPermission(HomeActivity.this, Manifest.permission.CALL_PHONE) != PackageManager.PERMISSION_GRANTED) {
                                // TODO: Consider calling
                                //    ActivityCompat#requestPermissions
                                // here to request the missing permissions, and then overriding
                                //   public void onRequestPermissionsResult(int requestCode, String[] permissions,
                                //                                          int[] grantResults)
                                // to handle the case where the user grants the permission. See the documentation
                                // for ActivityCompat#requestPermissions for more details.
                                return;
                            }
                            Intent intentCalling = new Intent(Intent.ACTION_CALL);
                            intentCalling.setData(Uri.parse("tel:" + constantEntity.getHelpNumber()));
                            startActivity(intentCalling);
                        }
                    });

            builder.setNegativeButton(NegativeText,
                    new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            dialog.dismiss();
                        }
                    });
            final android.support.v7.app.AlertDialog dialog = builder.create();
            dialog.setCancelable(false);
            dialog.setCanceledOnTouchOutside(false);
            dialog.show();
        } catch (Exception ex) {
            Toast.makeText(this, "Please try again..", Toast.LENGTH_SHORT).show();
        }
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

    @Override
    public void onGrantButtonClick(View view) {

        Intent intent = new Intent(Settings.ACTION_APPLICATION_DETAILS_SETTINGS);
        Uri uri = Uri.fromParts("package", getPackageName(), null);
        intent.setData(uri);
        startActivityForResult(intent, Constants.REQUEST_PERMISSION_SETTING);

    }
    //endregion
}
