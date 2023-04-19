package com.policyboss.policybosspro.attendance

import android.Manifest
import android.R
import android.content.Context
import android.content.DialogInterface
import android.content.Intent
import android.content.pm.PackageManager
import android.location.Location
import android.net.Uri
import android.os.Bundle
import android.provider.Settings
import android.util.Log
import android.view.MenuItem
import android.view.View
import android.widget.Button
import android.widget.LinearLayout
import android.widget.Toast
import androidx.activity.result.contract.ActivityResultContracts
import androidx.appcompat.app.AppCompatActivity
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.policybosscaller.Utility.showSnackbar
import com.google.android.gms.location.FusedLocationProviderClient
import com.google.android.material.snackbar.Snackbar
import com.google.gson.Gson
import com.policyboss.policybosspro.APIState
import com.policyboss.policybosspro.attendance.viewmodel.pbAttendanceViewModel
import com.policyboss.policybosspro.attendance.viewmodel.pbAttendanceViewModelFactory
import com.policyboss.policybosspro.databinding.ActivityPolicyBossAttendanceBinding
import com.policyboss.policybosspro.utility.Constant

import com.policyboss.policybosspro.utility.LocationService
import com.policyboss.policybosspro.utility.UTILITY
import com.policyboss.policybosspro.utility.UtilityNew

import kotlinx.coroutines.launch
import magicfinmart.datacomp.com.finmartserviceapi.database.DBPersistanceController
import magicfinmart.datacomp.com.finmartserviceapi.finmart.model.LoginResponseEntity
import magicfinmart.datacomp.com.finmartserviceapi.finmart.requestentity.pbAttendance.pbAttendRequestEntity
import magicfinmart.datacomp.com.finmartserviceapi.finmart.retrobuilder.RetroHelper


class PolicyBossAttendanceActivity : AppCompatActivity(), LocationService.ILocation {

    private lateinit var mainBinding: ActivityPolicyBossAttendanceBinding
    private lateinit var layout : View
    lateinit var viewModel: pbAttendanceViewModel
    lateinit var loginResponseEntity: LoginResponseEntity

    lateinit var mAdapter: PolicyBossAttendanceAdapter
    lateinit var btn_submit_attendance: Button
    private val REQUEST_CODE_ASK_PERMISSIONS = 1111

    private lateinit  var locationService: LocationService
    var perms = arrayOf(
        Manifest.permission.ACCESS_FINE_LOCATION
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mainBinding = ActivityPolicyBossAttendanceBinding.inflate(layoutInflater)
        setContentView(mainBinding.root)
        layout = mainBinding.root


        setSupportActionBar(mainBinding.toolbar)
        supportActionBar?.apply {

            setDisplayShowHomeEnabled(true)
            setDisplayHomeAsUpEnabled(true)
            //setTitle("WebView Kotlin ")
        }

        // Initialize Sevice
        locationService = LocationService(this@PolicyBossAttendanceActivity,this@PolicyBossAttendanceActivity)


        btn_submit_attendance = mainBinding.btnSubmitAttendance

        btn_submit_attendance.setVisibility(View.VISIBLE);


        if(!checkPermission()){
            requestPermission()
        }

        init()

        setListener ()

        observePunchAttendance()
    }

    private fun init(){


        var repository = pbAttendanceRepository( RetroHelper.api)
        var viewModelFactory = pbAttendanceViewModelFactory(repository)
        viewModel = ViewModelProvider(this,viewModelFactory).get(pbAttendanceViewModel::class.java)


        loginResponseEntity = DBPersistanceController(this).getUserData()

        bindRecyclerView()

    }

    private fun bindRecyclerView(){

        mAdapter = PolicyBossAttendanceAdapter(ArrayList())
        mainBinding.rvAttendace.apply {

            setHasFixedSize(true)
            layoutManager = LinearLayoutManager(this@PolicyBossAttendanceActivity)
            adapter = mAdapter
        }
    }

    fun setListener (){

        btn_submit_attendance.setOnClickListener {
            // locationService.createLocationRequest()


        }


        mainBinding.btnLocation.setOnClickListener {

            if(mainBinding.tvLatitude.text.isEmpty()){
                requestFineLocationPermission()
            }else{

                val url = "https://pbtimes.policyboss.com/EIS/JSON_Test/app_data_push_test.php"

                var key = "K!R:|A*J$" + "P*"


                val attendRequestEntity =  pbAttendRequestEntity(

                    DeviceId = UTILITY.getDeviceID(this@PolicyBossAttendanceActivity),
                    UID = "107898",
                    key = key,
                    lat = mainBinding.tvLatitude.text.toString(),
                    lng = mainBinding.tvLatitude.text.toString(),
                    name = "knkk"
                )

                viewModel.getAttendance(Constant.pbAttendanceURL, attendRequestEntity)
            }


        }


    }


    private fun observePunchAttendance(){


        lifecycleScope.launch{

            repeatOnLifecycle(Lifecycle.State.STARTED){
                //collect date from flow  Variable
                viewModel.attendStateFlow.collect{

                    when(it){

                        is APIState.Loading ->{

                            showAnimDialog()
                        }
                        is APIState.Success ->{

                            cancelAnimDialog()

                            if(it != null){
                                it.data?.let{
                                    layout.showSnackbar(
                                         it.message ?: "Attendance marked successfully..",
                                        Snackbar.LENGTH_SHORT,
                                    )

                                    mAdapter.setData(it.Details)

                                }
                            }


                        }

                        is APIState.Failure -> {
                            cancelAnimDialog()
                            mainBinding.tvLongitude.text = ""
                            mainBinding.tvLatitude.text = ""

                            layout.showSnackbar(
                                ""+ it.errorMessage.toString(),
                                Snackbar.LENGTH_SHORT,
                                )
                        }

                        is APIState.Empty ->{
                            cancelAnimDialog()
                        }
                    }


                }
            }
        }
    }


    //region Get permission and Location
    private fun checkPermission(): Boolean {
        val fine_location = ActivityCompat.checkSelfPermission(this, perms.get(0))

        return fine_location == PackageManager.PERMISSION_GRANTED
    }

    private fun requestPermission() {
        ActivityCompat.requestPermissions(this, perms, REQUEST_CODE_ASK_PERMISSIONS)
    }

    override fun getLocation(location: Location?) {
        if (location != null) {
            locationService.stopLocationUpdates()

            mainBinding.tvLatitude.text = location.latitude.toString()
            mainBinding.tvLongitude.text = location.longitude.toString()

            mainBinding.btnLocation.text = "Submit Attendance"
            mainBinding.btnLocation.setBackgroundColor(
                ContextCompat.getColor(
                this@PolicyBossAttendanceActivity,
                R.color.system_accent1_1000
            )
            )

        }
    }

    fun requestFineLocationPermission() = fineLocationPermissionLauncher.launch(  Manifest.permission.ACCESS_FINE_LOCATION)

  //  endregion


    private  val fineLocationPermissionLauncher = registerForActivityResult(ActivityResultContracts.RequestPermission()){

            isGranted ->
        // Do something if permission granted
        if (isGranted) {
            Log.i("DEBUG", "permission granted")

            locationService.createLocationRequest()



        } else {
            Log.i("DEBUG", "permission denied")
            //binding.tvCallLogInfo.setImageDrawable(ContextCompat.getDrawable(this@SettingActivity, R.drawable.circular_exclaimlayer))

            layout.showSnackbar(
                "Required for PolicyBoss Pro to get Location",
                Snackbar.LENGTH_INDEFINITE,
                "ALLOW"){

                UtilityNew.settingDialog(context = this, ::settingDialogAction)

            }
        }
    }



    fun settingDialogAction( strType : String, dialog : DialogInterface){


        when(strType){

            "Y" -> {

                dialog.dismiss()
                openSetting(context =this)

            }

            "N" -> {

                dialog.dismiss()

            }

        }

    }
    fun openSetting(context: Context){
        val intent = Intent(Settings.ACTION_APPLICATION_DETAILS_SETTINGS)
        intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK)
        val uri = Uri.fromParts("package", context.packageName, null)
        intent.data = uri
        context.startActivity(intent)
    }

    // region commented



//    private val mLocationCallback = object : LocationCallback() {
//        override fun onLocationResult(locationResult: LocationResult) {
//            var mLastLocation: Location = locationResult.lastLocation
//
//            btn_submit_attendance.setVisibility(View.VISIBLE);
//
//
//            mainBinding.apply {
//                tvLatitude.text = mLastLocation.latitude.toString()
//                tvLongitude.text = mLastLocation.longitude.toString()
//
//            }
//
//
//        }
//    }
//
//    private fun isLocationEnabled():Boolean{
//        val locationManager: LocationManager =
//            getSystemService(Context.LOCATION_SERVICE) as LocationManager
//
//        return locationManager.isProviderEnabled(LocationManager.GPS_PROVIDER) || locationManager.isProviderEnabled(LocationManager.NETWORK_PROVIDER)
//
//    }
//
//    private fun checkPermissions():Boolean{
//        if(ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_COARSE_LOCATION) == PackageManager.PERMISSION_GRANTED &&
//            ActivityCompat.checkSelfPermission(this,Manifest.permission.ACCESS_FINE_LOCATION)==PackageManager.PERMISSION_GRANTED)
//        {
//            return true
//        }
//        return false
//    }
//
//
//    private fun requestPermissions(){
//        ActivityCompat.requestPermissions(
//            this, arrayOf(
//                android.Manifest.permission.ACCESS_FINE_LOCATION,
//                android.Manifest.permission.ACCESS_COARSE_LOCATION),
//            PERMISSION_ID
//        )
//    }

    //endregion

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.home -> {
                onBackPressed()
                return true
            }
        }
        return super.onOptionsItemSelected(item)
    }

    fun showAnimDialog(){

        mainBinding.imgLoader.visibility = View.VISIBLE

    }

    fun cancelAnimDialog(){


        mainBinding.imgLoader.visibility = View.GONE
    }

    override fun onBackPressed() {
        super.onBackPressed()
        finish()
    }

    override fun onDestroy() {
        super.onDestroy()
        locationService.stopLocationUpdates()
    }



}