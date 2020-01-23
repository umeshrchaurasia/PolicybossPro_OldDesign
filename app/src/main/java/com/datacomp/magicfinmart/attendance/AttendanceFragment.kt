package com.datacomp.magicfinmart.attendance


import android.app.Activity
import android.app.AlertDialog
import android.app.DatePickerDialog
import android.content.DialogInterface
import android.content.Intent
import android.content.pm.PackageManager
import android.location.Location
import android.net.Uri
import android.os.Bundle

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.LinearLayoutManager
import com.datacomp.magicfinmart.BaseFragment
import com.datacomp.magicfinmart.R
import com.datacomp.magicfinmart.home.HomeActivity
import com.datacomp.magicfinmart.location.LocationService
import com.datacomp.magicfinmart.location.LocationTracker
import com.datacomp.magicfinmart.utility.Constants
import com.datacomp.magicfinmart.utility.DateTimePicker
import com.datacomp.magicfinmart.utility.ReadDeviceID
import com.google.android.material.snackbar.Snackbar
import kotlinx.android.synthetic.main.fragment_attendance.*
import kotlinx.android.synthetic.main.layout_attendance_report.*
import kotlinx.android.synthetic.main.layout_location_of_attendance.*
import kotlinx.android.synthetic.main.layout_mark_attendance.*

import magicfinmart.datacomp.com.finmartserviceapi.PrefManager
import magicfinmart.datacomp.com.finmartserviceapi.database.DBPersistanceController
import magicfinmart.datacomp.com.finmartserviceapi.dynamic_urls.DynamicController
import magicfinmart.datacomp.com.finmartserviceapi.dynamic_urls.model.CheckAppAccessEntity
import magicfinmart.datacomp.com.finmartserviceapi.dynamic_urls.response.CheckAppAccessResponse
import magicfinmart.datacomp.com.finmartserviceapi.dynamic_urls.response.SwipeDetailResponse
import magicfinmart.datacomp.com.finmartserviceapi.finmart.APIResponse
import magicfinmart.datacomp.com.finmartserviceapi.finmart.IResponseSubcriber
import java.text.ParseException
import java.text.SimpleDateFormat
import java.util.*


class AttendanceFragment : BaseFragment(), IResponseSubcriber, View.OnClickListener, LocationService.ILocation {


    lateinit var locationService: LocationService
    private val REQUEST_CHECK_SETTINGS = 0x1
    private val REQUEST_CODE_ASK_PERMISSIONS = 1111
    private var PERMISSION_DENIED = 0

    internal var simpleDateFormat = SimpleDateFormat("dd-MMM-yyyy")
    lateinit var mLocationTracker: LocationTracker
      var mLocation: Location? = null

    var Type = 0
    // 1 : For Mark Attendance
    // 3:  Foe My Location

    lateinit var checkAppAccessEntity: CheckAppAccessEntity

    var perms = arrayOf(
            "android.permission.ACCESS_FINE_LOCATION"
    )

    //region permission
    private fun checkPermission(): Boolean {

        val fineLocation = ContextCompat.checkSelfPermission(context!!, perms[0])
        return fineLocation == PackageManager.PERMISSION_GRANTED

    }

    private fun requestPermission() {
        ActivityCompat.requestPermissions(activity!!, perms, REQUEST_CODE_ASK_PERMISSIONS)
    }

    override fun onRequestPermissionsResult(requestCode: Int, permissions: Array<out String>, grantResults: IntArray) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults)

        when (requestCode) {

            REQUEST_CODE_ASK_PERMISSIONS ->
                if (grantResults.size > 0) {
                    val fineLocation = grantResults[0] == PackageManager.PERMISSION_GRANTED
                    if (fineLocation) {
                        // initialiseAndRetriveLocation()

                        locationService.createLocationRequest()
                    }

                }
        }
    }


    private fun showMessageOKCancel(message: String, okListener: DialogInterface.OnClickListener) {
        AlertDialog.Builder(context!!, R.style.AlertDialog_Theme)
                .setTitle("Retry")
                .setMessage(message)
                .setPositiveButton("OK", okListener) //.setNegativeButton("Cancel", null)
                .create()
                .show()
    }

    //endregion


    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_attendance, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


        // Initailize the Service Call and ServiceCallBack
        locationService = LocationService(activity)

        locationService.setLocationListener(this)

        val calendar = Calendar.getInstance()
        calendar.add(Calendar.DATE, -1)

        etFrom.setText(simpleDateFormat.format(calendar.getTime()))

        etTo.setText(simpleDateFormat.format(Calendar.getInstance().getTime()))
        btnAttendance.setOnClickListener(this)
        btnViewPunch.setOnClickListener(this)
        btnViewReport.setOnClickListener(this)
        btnViewLocation.setOnClickListener(this)
        btnGenerateReport.setOnClickListener(this)
        btnMyLoc.setOnClickListener(this)

        etFrom.setOnClickListener(datePickerDialogFrom)
        etTo.setOnClickListener(datePickerDialogTo)



        rvAttendace.layoutManager = LinearLayoutManager(activity)
        rvAttendace.setHasFixedSize(true)

        showDialog("Checking App Access.., Please wait.")
        DynamicController(activity).checkAppAccess(getDeviceID(), getDeviceToken(), getUID(), this)


    }

    override fun onClick(v: View?) {

        // For  View Mark Attendance
        if (v?.id == R.id.btnViewPunch) {


            if (ViewMarkAttendance.visibility == View.VISIBLE) {
                return
            }
            ViewMarkAttendance.visibility = View.VISIBLE
//            ViewReportAttendance.background.alpha =20
//            ViewLocationAttendance.background.alpha =20
            ViewReportAttendance.visibility = View.GONE
            ViewLocationAttendance.visibility = View.GONE

            showDialog("View the Attendance History...")
            DynamicController(activity).swipeDetailsTop(getDeviceID(), getDeviceToken(), getUID(), this)


            // For View Attendance Report
        } else if (v?.id == R.id.btnViewReport) {

            ViewReportAttendance.visibility = View.VISIBLE
            ViewMarkAttendance.visibility = View.GONE
            ViewLocationAttendance.visibility = View.GONE

            rvAttendace.visibility = View.GONE

            // For View  Location

        } else if (v?.id == R.id.btnViewLocation) {

            if (ViewLocationAttendance.visibility == View.VISIBLE) {
                return
            }
            ViewLocationAttendance.visibility = View.VISIBLE
            ViewMarkAttendance.visibility = View.GONE
            ViewReportAttendance.visibility = View.GONE

            rvAttendace.visibility = View.GONE
            txtViewlat.text = ""
            txtViewlog.text = ""
            txtType.text = ""

        } else if (v?.id == R.id.btnAttendance) {

            mLocation = null
            // region Mark Attendance

            Type = 1
            locationService.createLocationRequest()

            //endregion

        } else if (v?.id == R.id.btnGenerateReport) {

            // region Generate Report
            Type = 2
            var fromdt: Long = 0
            var todt: Long = 0
            try {
                val d1 = simpleDateFormat.parse(etFrom.text.toString())
                fromdt = d1.time

                val d2 = simpleDateFormat.parse(etTo.text.toString())
                todt = d2.time

                if (fromdt > todt) {

                    Snackbar.make(btnAttendance, "To date must be greater than From date", Snackbar.LENGTH_SHORT).show()
                }

            } catch (e: ParseException) {
                e.printStackTrace()
            }


            showDialog("Loading the Report...")
            DynamicController(activity).getAttendanceReport(getUID(), fromdt, todt, this)

            //endregion

        } else if (v?.id == R.id.btnMyLoc) {

            Type = 3
            locationService.createLocationRequest()

            //endregion
        }
    }

    private fun showGoogleMap() {
        try {
            val builder = AlertDialog.Builder(context!!)
            builder.setTitle("Oops! Your location not found.")
            builder.setMessage("Kindly go to google map , set your current location and try again.")
            val positiveText = "OK"
            builder.setPositiveButton(positiveText
            ) { dialog, which ->
                val uri = String.format(Locale.ENGLISH, "geo:%f,%f", 19.0857745, 72.8883218)
                val intent = Intent(Intent.ACTION_VIEW, Uri.parse(uri))
                startActivity(intent)
            }
            val dialog = builder.create()
            dialog.setCancelable(false)
            dialog.setCanceledOnTouchOutside(false)
            dialog.show()
        } catch (ex: Exception) {
            Toast.makeText(activity, "Please try again..", Toast.LENGTH_SHORT).show()
        }
    }

    private fun displayLocation(mLocation: Location) {
        txtViewlat.text = "" + mLocation?.latitude ?: "0"
        txtViewlog.text = "" + mLocation?.longitude ?: "0"
        mLocation?.let {
            if (distance(mLocation!!.latitude, mLocation!!.longitude, checkAppAccessEntity.lat.toDouble(), checkAppAccessEntity.lng.toDouble()) < 0.3) {
                //indoor
                txtType.text = "Indoor"


            } else {
                //outdoor
                txtType.text = "Outdoor"
            }
        }
    }

    private fun markAttendance(mLocation: Location) {
        mLocation?.let {
            if (distance(mLocation!!.latitude,
                            mLocation!!.longitude,
                            checkAppAccessEntity.lat.toDouble(),
                            checkAppAccessEntity.lng.toDouble()) < 0.3) {
                //indoor
                showDialog("Please wait..")
                DynamicController(activity).indoorAttendance(attendanceRequest("Indoor",mLocation), this)
            } else {
                //outdoor
                showOutdoorAlertDialog(mLocation)
            }
        }
    }

    private fun showOutdoorAlertDialog(mLocation: Location) {
        var alertDialog = AlertDialog.Builder(activity!!)
        alertDialog.setTitle("Mark Outdoor Attendance")
        alertDialog.setMessage("Are you sure you want to mark Outdoor Attendance?")
        alertDialog.setPositiveButton("YES", DialogInterface.OnClickListener { dialog, which ->
            dialog.dismiss()
            showDialog("Please wait..")
            DynamicController(activity).outdoorAttendance(attendanceRequest("Outdoor",mLocation), this)
        })

        alertDialog.setNegativeButton("CANCEL", DialogInterface.OnClickListener { dialog, which ->
            dialog.dismiss()
        })

        var dialog = alertDialog.create()
        dialog.show()

    }

    private fun attendanceRequest(entryType: String,mLocation: Location): magicfinmart.datacomp.com.finmartserviceapi.dynamic_urls.requestentity.RegisterRequestEntity {
        var attendance = magicfinmart.datacomp.com.finmartserviceapi.dynamic_urls.requestentity.RegisterRequestEntity()

        attendance.uid = checkAppAccessEntity.uid
        attendance.hrmsid = checkAppAccessEntity.hrmsid
        attendance.lat = mLocation?.latitude.toString()
        attendance.lng = mLocation?.longitude.toString()
        attendance.setDeviceId(ReadDeviceID(activity!!).androidID)
        attendance.setDeviceToken("")
        attendance.entrytype = entryType
        return attendance


    }

    /**
     * calculates the distance between two locations in MILES
     */
    private fun distance(lat1: Double, lng1: Double, lat2: Double, lng2: Double): Double {
        val earthRadius = 3958.75 // in miles, change to 6371 for kilometer output
        val dLat = Math.toRadians(lat2 - lat1)
        val dLng = Math.toRadians(lng2 - lng1)
        val sindLat = Math.sin(dLat / 2)
        val sindLng = Math.sin(dLng / 2)
        val a = Math.pow(sindLat, 2.0) + (Math.pow(sindLng, 2.0)
                * Math.cos(Math.toRadians(lat1)) * Math.cos(Math.toRadians(lat2)))
        val c = 2 * Math.atan2(Math.sqrt(a), Math.sqrt(1 - a))
        return earthRadius * c // output distance, in MILES
    }

    override fun onResume() {
        super.onResume()

    }

    private fun initialiseAndRetriveLocation() {
//        mLocationTracker = LocationTracker(activity)
//        mLocationTracker.setLocationStateListener(this)
//        mLocationTracker.init()
//        mLocationTracker.onResume()
    }

    private fun getUID(): String {
        return DBPersistanceController(activity).userConstantsData.userid
    }

    private fun getDeviceToken(): String {
        return PrefManager(activity).token
    }

    private fun getDeviceID(): String {
        return ReadDeviceID(activity).androidID
    }

    //region api response

    override fun OnSuccess(response: APIResponse?, message: String?) {
        cancelDialog()
        if (response is CheckAppAccessResponse) {

            if (response.result.isfirstlogin == 0) {

                checkAppAccessEntity = response.result

                if (checkPermission()) {
                    locationService.createLocationRequest()
                } else {
                    requestPermission()
                }
            } else {

                startActivityForResult(Intent(activity, AttendanceRegistraionActivity::class.java), 5)
            }
        } else if (response is SwipeDetailResponse) {

            if (response.statusNo == 0) {

                rvAttendace.visibility = View.VISIBLE
                rvAttendace.adapter = AttendanceAdapter(activity!!, response.swipeDetails)
            } else {
                rvAttendace.adapter = null
                Snackbar.make(btnAttendance, "No data available", Snackbar.LENGTH_SHORT).show()
            }
        }
    }


    override fun OnFailure(t: Throwable?) {
        cancelDialog()
        Toast.makeText(activity, t?.message, Toast.LENGTH_LONG).show()
    }


    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)

        when (requestCode) {

            5 ->
                if (data == null) {
                    (activity as HomeActivity).selectHome()
                }

            REQUEST_CHECK_SETTINGS ->
                when (resultCode) {
                    Activity.RESULT_OK -> locationService.startLocationUpdates()
                    Activity.RESULT_CANCELED -> locationService.stopLocationUpdates()

                }


        }


    }

    //endregion


    // region calander event
    protected var datePickerDialogFrom: View.OnClickListener = View.OnClickListener { view ->
        Constants.hideKeyBoard(view, activity)
        DateTimePicker.showDataPickerDialog(view.context, DatePickerDialog.OnDateSetListener { view, year, monthOfYear, dayOfMonth ->
            val calendar = Calendar.getInstance()
            calendar.set(year, monthOfYear, dayOfMonth)
            val currentDay = simpleDateFormat.format(calendar.time)
            etFrom.setText(currentDay)


        })
    }

    protected var datePickerDialogTo: View.OnClickListener = View.OnClickListener { view ->
        Constants.hideKeyBoard(view, activity)
        DateTimePicker.showDataPickerDialog(view.context) { view, year, monthOfYear, dayOfMonth ->
            val calendar = Calendar.getInstance()
            calendar.set(year, monthOfYear, dayOfMonth)
            val currentDay = simpleDateFormat.format(calendar.time)
            etTo.setText(currentDay)

        }
    }

    //endregion

    override fun getLocation(location: Location?) {

        if (location != null) {

            this.mLocation = location
            locationService.stopLocationUpdates()
            Toast.makeText(activity, "Location Callback" + location.getLatitude() + " And " + location.getLongitude(), Toast.LENGTH_SHORT).show();

            if (Type == 1) {

                markAttendance(location)
            } else if (Type == 3) {

                displayLocation(location)
            }
        }
    }


}
