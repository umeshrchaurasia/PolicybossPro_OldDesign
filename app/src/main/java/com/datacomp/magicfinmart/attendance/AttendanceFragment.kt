package com.datacomp.magicfinmart.attendance


import android.content.DialogInterface
import android.content.Intent
import android.content.pm.PackageManager
import android.location.Location
import android.net.Uri
import android.os.Build
import android.os.Bundle
import android.support.v4.app.ActivityCompat
import android.support.v4.content.ContextCompat
import android.support.v7.app.AlertDialog
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import com.datacomp.magicfinmart.BaseFragment
import com.datacomp.magicfinmart.R
import com.datacomp.magicfinmart.location.ILocationStateListener
import com.datacomp.magicfinmart.location.LocationTracker
import com.datacomp.magicfinmart.utility.ReadDeviceID
import kotlinx.android.synthetic.main.fragment_attendance.*
import magicfinmart.datacomp.com.finmartserviceapi.PrefManager
import magicfinmart.datacomp.com.finmartserviceapi.database.DBPersistanceController
import magicfinmart.datacomp.com.finmartserviceapi.dynamic_urls.DynamicController
import magicfinmart.datacomp.com.finmartserviceapi.dynamic_urls.model.CheckAppAccessEntity
import magicfinmart.datacomp.com.finmartserviceapi.dynamic_urls.response.CheckAppAccessResponse
import magicfinmart.datacomp.com.finmartserviceapi.finmart.APIResponse
import magicfinmart.datacomp.com.finmartserviceapi.finmart.IResponseSubcriber
import java.util.*


class AttendanceFragment : BaseFragment(), IResponseSubcriber, ILocationStateListener, View.OnClickListener {


    private val REQUEST_CODE_ASK_PERMISSIONS = 1111
    private var PERMISSION_DENIED = 0


    lateinit var mLocationTracker: LocationTracker
    lateinit var mLocation: Location

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
                    if (!fineLocation) {
                        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
                            showMessageOKCancel("Required permissions to proceed Magic-finmart..!",
                                    DialogInterface.OnClickListener { dialogInterface, i ->
                                        // finish();
                                        if (2 > PERMISSION_DENIED) {
                                            PERMISSION_DENIED++
                                            requestPermission()
                                        } else {
                                            dialogInterface.dismiss()
                                        }
                                    })
                        }
                    } else {
                        initialiseAndRetriveLocation()
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


    //region receive location

    override fun onLocationChanged(location: Location?) {

        if (mLocation == null) {
            showGoogleMap()
            return
        }
    }

    override fun onConnected() {

        mLocation = mLocationTracker.mLocation

        if (mLocation == null) {
            showGoogleMap()
            return
        }
    }

    override fun onConnectionFailed() {
        Toast.makeText(activity, "Enable to get your current Location, Try again", Toast.LENGTH_LONG).show()
    }

    //endregion


    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_attendance, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        btnAttendance.setOnClickListener(this)
    }

    override fun onClick(v: View?) {

        if (v?.id == R.id.btnAttendance) {

            if (mLocation == null) {
                showGoogleMap()
                return
            }

            mLocation?.let {
                if (distance(mLocation.latitude,
                                mLocation.longitude,
                                checkAppAccessEntity.lat.toDouble(),
                                checkAppAccessEntity.lng.toDouble()) < 0.3) {
                    //indoor
                    showDialog("Please wait..")
                    DynamicController(activity).indoorAttendance(attendanceRequest("Indoor"), this)
                } else {
                    //outdoor
                    showOutdoorAlertDialog()
                }
            }

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

    private fun showOutdoorAlertDialog() {
        var alertDialog = AlertDialog.Builder(activity!!)
        alertDialog.setTitle("Mark Outdoor Attendance")
        alertDialog.setMessage("Are you sure you want to mark Outdoor Attendance?")
        alertDialog.setPositiveButton("YES", DialogInterface.OnClickListener { dialog, which ->
            dialog.dismiss()
            showDialog("Please wait..")
            DynamicController(activity).outdoorAttendance(attendanceRequest("Outdoor"), this)
        })

        alertDialog.setNegativeButton("CANCEL", DialogInterface.OnClickListener { dialog, which ->
            dialog.dismiss()
        })

        var dialog = alertDialog.create()
        dialog.show()

    }

    private fun attendanceRequest(entryType: String): magicfinmart.datacomp.com.finmartserviceapi.dynamic_urls.requestentity.RegisterRequestEntity {
        var attendance = magicfinmart.datacomp.com.finmartserviceapi.dynamic_urls.requestentity.RegisterRequestEntity()

        attendance.uid = checkAppAccessEntity.uid
        attendance.hrmsid = checkAppAccessEntity.hrmsid
        attendance.lat = mLocation.latitude.toString()
        attendance.lng = mLocation.longitude.toString()
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
        showDialog("Checking App Access.., Please wait.")
        DynamicController(activity).checkAppAccess(getDeviceID(), getDeviceToken(), getUID(), this)
    }

    private fun initialiseAndRetriveLocation() {
        mLocationTracker = LocationTracker(activity)
        mLocationTracker.setLocationStateListener(this)
        mLocationTracker.init()
        mLocationTracker.onResume()
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

            if (response.result.isfirstlogin == 1) {

                checkAppAccessEntity = response.result

                if (checkPermission()) {
                    initialiseAndRetriveLocation()
                } else {
                    requestPermission()
                }
            }
        }
    }


    override fun OnFailure(t: Throwable?) {
        cancelDialog()
        Toast.makeText(activity, t?.message, Toast.LENGTH_LONG).show()
    }

    //endregion

}
