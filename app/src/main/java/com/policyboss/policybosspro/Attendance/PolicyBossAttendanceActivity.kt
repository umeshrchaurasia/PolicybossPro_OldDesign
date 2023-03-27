package com.policyboss.policybosspro.Attendance

import android.Manifest
import android.annotation.SuppressLint
import android.content.Context
import android.content.Intent
import android.content.pm.PackageManager
import android.location.Location
import android.location.LocationManager
import android.os.Bundle
import android.os.Looper
import android.provider.Settings
import android.view.View
import android.widget.Button
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.core.app.ActivityCompat
import com.google.android.gms.location.*
import com.policyboss.policybosspro.databinding.ActivityPolicyBossAttendanceBinding
import java.util.*


class PolicyBossAttendanceActivity : AppCompatActivity() {

    private lateinit var mainBinding: ActivityPolicyBossAttendanceBinding
    private lateinit var mFusedLocationClient: FusedLocationProviderClient
    private val PERMISSION_ID = 42
    lateinit var btn_submit_attendance: Button


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        mainBinding = ActivityPolicyBossAttendanceBinding.inflate(layoutInflater)
        setContentView(mainBinding.root)

        mFusedLocationClient = LocationServices.getFusedLocationProviderClient(this)

        btn_submit_attendance = mainBinding.btnSubmitAttendance

        btn_submit_attendance.setVisibility(View.GONE);

        btn_submit_attendance.setOnClickListener {
            getLocation()
        }

        getLocation()
        mainBinding.btnLocation.setOnClickListener {
            getLocation()
        }
    }


    @SuppressLint("MissingPermission")
    private fun getLocation() {
        if (checkPermissions()) {
            if (isLocationEnabled()) {
                if (ActivityCompat.checkSelfPermission(
                        this,
                        android.Manifest.permission.ACCESS_FINE_LOCATION
                    ) != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(
                        this,
                        android.Manifest.permission.ACCESS_COARSE_LOCATION
                    ) != PackageManager.PERMISSION_GRANTED
                ) {
                    // TODO: Consider calling
                    //    ActivityCompat#requestPermissions
                    // here to request the missing permissions, and then overriding
                        //   public void onRequestPermissionsResult(int requestCode, String[] permissions,
                    //                                          int[] grantResults)
                    // to handle the case where the user grants the permission. See the documentation
                    // for ActivityCompat#requestPermissions for more details.
                    requestPermissions()
                    return
                }
                mFusedLocationClient.lastLocation.addOnCompleteListener(this) { task ->
                    val location: Location? = task.result
                    if (location == null) {

                        btn_submit_attendance.setVisibility(View.GONE);
                        Toast.makeText(this, "Location Not Found", Toast.LENGTH_SHORT).show()

                        mainBinding.apply {
                            tvLatitude.text = ""
                            tvLongitude.text = ""
                          //  tvCountryName.text = ""
                          //  tvLocality.text = ""
                          //  tvAddress.text = "  "

                        }
                        Toast.makeText(this, "Get Re-Location", Toast.LENGTH_SHORT).show()
                        requestNewLocationData()

                    }else
                    {
                        btn_submit_attendance.setVisibility(View.VISIBLE);
                        Toast.makeText(this, "Get Location", Toast.LENGTH_SHORT).show()

                        /* location with address
//                        val geocoder = Geocoder(this, Locale.getDefault())
//                        val list: List<Address> =
//                            geocoder.getFromLocation(location.latitude, location.longitude, 1)
//                        mainBinding.apply {
//                            tvLatitude.text = "Latitude\n${list[0].latitude}"
//                            tvLongitude.text = "Longitude\n${list[0].longitude}"
//                            tvCountryName.text = "Country Name\n${list[0].countryName}"
//                            tvLocality.text = "Locality\n${list[0].locality}"
//                            tvAddress.text = "Address\n${list[0].getAddressLine(0)}"
//                        }
                        */

                        mainBinding.apply {
                            tvLatitude.text = location.latitude.toString()
                            tvLongitude.text = location.longitude.toString()

                        }

                    }
                }
            } else {
                btn_submit_attendance.setVisibility(View.GONE);
                Toast.makeText(this, "Please turn on location", Toast.LENGTH_SHORT).show()
                val intent = Intent(Settings.ACTION_LOCATION_SOURCE_SETTINGS)
                startActivity(intent)
            }
        } else {
            requestPermissions()
        }
    }


    @SuppressLint("MissingPermission")
    private fun requestNewLocationData() {
        var mLocationRequest = LocationRequest()
        mLocationRequest.priority = LocationRequest.PRIORITY_HIGH_ACCURACY
        mLocationRequest.interval = 0
        mLocationRequest.fastestInterval = 0
        mLocationRequest.numUpdates = 1

        mFusedLocationClient = LocationServices.getFusedLocationProviderClient(this)
        mFusedLocationClient!!.requestLocationUpdates(
            mLocationRequest, mLocationCallback,
            Looper.myLooper()
        )
    }

    private val mLocationCallback = object : LocationCallback() {
        override fun onLocationResult(locationResult: LocationResult) {
            var mLastLocation: Location = locationResult.lastLocation

            btn_submit_attendance.setVisibility(View.VISIBLE);


            mainBinding.apply {
                tvLatitude.text = mLastLocation.latitude.toString()
                tvLongitude.text = mLastLocation.longitude.toString()

            }

//            findViewById<TextView>(R.id.tvLatitude).text = mLastLocation.latitude.toString()
//            findViewById<TextView>(R.id.tvLongitude).text = mLastLocation.longitude.toString()
        }
    }

    private fun isLocationEnabled():Boolean{
        val locationManager:LocationManager =
            getSystemService(Context.LOCATION_SERVICE) as LocationManager

        return locationManager.isProviderEnabled(LocationManager.GPS_PROVIDER) || locationManager.isProviderEnabled(LocationManager.NETWORK_PROVIDER)

    }

    private fun checkPermissions():Boolean{
        if(ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_COARSE_LOCATION) == PackageManager.PERMISSION_GRANTED &&
            ActivityCompat.checkSelfPermission(this,Manifest.permission.ACCESS_FINE_LOCATION)==PackageManager.PERMISSION_GRANTED)
        {
            return true
        }
        return false
    }


    private fun requestPermissions(){
        ActivityCompat.requestPermissions(
            this, arrayOf(
                android.Manifest.permission.ACCESS_FINE_LOCATION,
                android.Manifest.permission.ACCESS_COARSE_LOCATION),
            PERMISSION_ID
        )
    }

    @Override
    public override fun onRequestPermissionsResult(requestCode: Int, permissions: Array<String>, grantResults: IntArray)
    {
            super.onRequestPermissionsResult(requestCode, permissions, grantResults)


        if (requestCode == PERMISSION_ID ) {
            if ((grantResults.isNotEmpty() && grantResults[0] == PackageManager.PERMISSION_GRANTED)) {
                Toast.makeText(applicationContext,"Granted",Toast.LENGTH_SHORT).show()
                getLocation()
            }else
            {
                Toast.makeText(applicationContext,"Denied",Toast.LENGTH_SHORT).show()
            }
        }
    }



}