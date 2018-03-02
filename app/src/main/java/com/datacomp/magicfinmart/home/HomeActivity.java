package com.datacomp.magicfinmart.home;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.v4.app.Fragment;
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
import com.datacomp.magicfinmart.loan_fm.homeloan.loan_apply.HomeLoanApplyActivity;
import com.datacomp.magicfinmart.login.LoginActivity;
import com.datacomp.magicfinmart.myaccount.MyAccountActivity;
import com.datacomp.magicfinmart.notification.NotificationActivity;
import com.datacomp.magicfinmart.posp.PospEnrollment;
import com.datacomp.magicfinmart.underconstruction.UnderConstructionActivity;
import com.datacomp.magicfinmart.whatsnew.WhatsNewActivity;
import com.datacomp.magicfinmart.utility.Constants;

import java.util.List;

import magicfinmart.datacomp.com.finmartserviceapi.database.DBPersistanceController;

public class HomeActivity extends BaseActivity {

    final String TAG = "HOME";
    private Toolbar toolbar;
    private NavigationView navigationView;
    private DrawerLayout drawerLayout;
    TextView textNotifyItemCount;

    DBPersistanceController db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        // Initializing Toolbar and setting it as the actionbar
        toolbar = (Toolbar) findViewById(R.id.toolbar);
        //Initializing NavigationView
        navigationView = (NavigationView) findViewById(R.id.navigation_view);
        // Initializing Drawer Layout and ActionBarToggle
        drawerLayout = (DrawerLayout) findViewById(R.id.drawer);

        setSupportActionBar(toolbar);
        getSupportActionBar().setElevation(0);
        toolbar.setTitle("MAGIC FIN-MART");

        db = new DBPersistanceController(this);
        List<String> rtoDesc = db.getRTOListNames();

        // set first fragement selected.
        navigationView.getMenu().getItem(0).setChecked(true);

        if (savedInstanceState == null) {
            getSupportActionBar().setTitle("MAGIC FIN-MART");
            Fragment fragment = new DashboardFragment();
            getSupportFragmentManager().beginTransaction().replace(R.id.frame, fragment).commit();

        }

        //Setting Navigation View Item Selected Listener to handle the item click of the navigation menu
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
                     //   startActivity(new Intent(HomeActivity.this, HomeLoanApplyActivity.class));
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
                        startActivity(new Intent(HomeActivity.this, UnderConstructionActivity.class));
                        break;
                    case R.id.nav_helpfeedback:
                        startActivity(new Intent(HomeActivity.this, HelpFeedBackActivity.class));
                        break;

                    case R.id.nav_whatsnew:
                        startActivity(new Intent(HomeActivity.this, WhatsNewActivity.class));
                        break;

                    case R.id.nav_logout:
                        new DBPersistanceController(HomeActivity.this).logout();
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

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.dashboard_menu, menu);

        final MenuItem menuItem = menu.findItem(R.id.action_push_notification);

        View actionView = MenuItemCompat.getActionView(menuItem);
        textNotifyItemCount = (TextView) actionView.findViewById(R.id.notify_badge);
        textNotifyItemCount.setVisibility(View.GONE);

//        int PushCount = Integer.parseInt(sharedPreferences.getString(Utility.NOTIFICATION_COUNTER, "0"));
//
//        if (PushCount == 0) {
//            textNotifyItemCount.setVisibility(View.GONE);
//        } else {
//            textNotifyItemCount.setVisibility(View.VISIBLE);
//            textNotifyItemCount.setText("" + String.valueOf(PushCount));
//        }

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

}
