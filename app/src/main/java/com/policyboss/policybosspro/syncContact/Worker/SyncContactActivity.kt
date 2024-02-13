package com.policyboss.policybosspro.syncContact.Worker

import android.Manifest
import android.app.Dialog
import android.content.Intent
import android.content.pm.PackageManager
import android.graphics.drawable.ColorDrawable
import android.net.Uri
import android.os.Bundle
import android.provider.Settings
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.ProgressBar
import android.widget.TextView
import android.app.AlertDialog
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat
import androidx.work.*
import com.bumptech.glide.Glide
import com.google.android.material.snackbar.Snackbar
import com.policyboss.policybosspro.BaseActivity
import com.policyboss.policybosspro.BuildConfig
import com.policyboss.policybosspro.R
import com.policyboss.policybosspro.databinding.ActivitySyncContactBinding
import com.policyboss.policybosspro.databinding.DialogLoadingBinding
import com.policyboss.policybosspro.utility.Constant
import com.policyboss.policybosspro.utility.NetworkUtils
import com.policyboss.policybosspro.utility.UTILITY
import com.policyboss.policybosspro.webviews.CommonWebViewActivity
import com.utility.finmartcontact.home.Worker.CallLogWorkManager
import com.utility.finmartcontact.home.Worker.ContactLogWorkManager
import com.webengage.sdk.android.WebEngage
import magicfinmart.datacomp.com.finmartserviceapi.PrefManager
import magicfinmart.datacomp.com.finmartserviceapi.Utility
import magicfinmart.datacomp.com.finmartserviceapi.database.DBPersistanceController

import magicfinmart.datacomp.com.finmartserviceapi.finmart.model.UserConstantEntity
import com.policyboss.policybosspro.analytics.WebEngageAnalytics
class SyncContactActivity : BaseActivity(), View.OnClickListener {

    lateinit var binding: ActivitySyncContactBinding
    private lateinit var dialogAnim : Dialog
    val REQUEST_PERMISSION_SETTING = 102
    val READ_CONTACTS_CODE = 101
    var currentProgress = 0
    var maxProgress = 0
    var remainderProgress = 0

    var  maxProgressContact = 0
    var remainderProgressContact = 0

    lateinit var progressBar: ProgressBar
    lateinit var progressBarServer: ProgressBar
    var progress_circular : ProgressBar? = null
    lateinit var  txtPercent :TextView
    lateinit var  txtPercentServer :TextView

    private val TAG = "CALL_LOG"

    var isContactWorkFinished = false
    var isCallLogWorkFinished = false

    var perms = arrayOf(
        "android.permission.READ_CONTACTS",
        "android.permission.READ_CALL_LOG"
    )

  //  lateinit var loginResponseEntity: LoginResponseEntity
    lateinit var userConstantEntity: UserConstantEntity

    lateinit var prefManager:PrefManager

    override fun onStart() {
        super.onStart()
        val weAnalytics = WebEngage.get().analytics()
        weAnalytics.screenNavigated("Sync Contact Screen")
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //  setContentView(R.layout.activity_sync_contact)
        binding = ActivitySyncContactBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setSupportActionBar(binding.toolbar)
        supportActionBar!!.apply {

            setDisplayShowHomeEnabled(true)
            setDisplayHomeAsUpEnabled(true)
            setTitle("Sync Contact & Call Log")
        }
        progressBar = binding.includedSyncContact.progressBar
        progressBarServer = binding.includedSyncContact.progressBarServer
        progress_circular = findViewById(R.id.progress_circular)
        txtPercent =  binding.includedSyncContact.txtPercent
        txtPercentServer =  binding.includedSyncContact.txtPercentServer

        dialogAnim = Dialog(this)

     //   loginResponseEntity = DBPersistanceController(this).userData
        userConstantEntity = DBPersistanceController(this).userConstantsData

        prefManager = PrefManager(this)

         isContactWorkFinished = false
          isCallLogWorkFinished = false

        if (!checkPermission()) {
            requestPermission()
        }else{
            if (NetworkUtils.isNetworkAvailable(this@SyncContactActivity)) {
                initData()
                setOneTimeRequestWithCoroutine()
            } else {
                Snackbar.make( binding.root, getString(R.string.noInternet), Snackbar.LENGTH_SHORT).show()
            }

        }

    }

    override fun onClick(view: View?) {
        when(view!!.id){



        }
    }

    override fun onBackPressed() {
        super.onBackPressed()
    }

    fun initData(){

        currentProgress =0
        maxProgress = 0
        binding.includedSyncContact.progressBar!!.setProgress(currentProgress)
        binding.includedSyncContact.progressBarServer!!.setProgress(currentProgress)
        binding.includedSyncContact.lySync.visibility = View.VISIBLE

        binding.includedSyncContact.txtPercent.text = "0%"

        binding.includedSyncContact.txtMessage.text = ""
        binding.includedSyncContact.txtCount.text = ""

        binding.includedSyncContact.txtMessageSsid.text=""


        var msg1 : String = "FBA ID :- "+ userConstantEntity.fbaId + " , SS ID :- "+ userConstantEntity!!.pospNo
        binding.includedSyncContact.txtMessageSsid.text = msg1


        binding.includedSyncContact.txtProgressMessage.visibility = View.VISIBLE
        binding.includedSyncContact.txtProgressMessage.text = Constant.CONTACT_LOG_DataFetching


        //05
       // showAnimDialog("")

    }

    fun successOfContact(msg : String?){

        binding.includedSyncContact.txtCount.text = msg ?: ""
        binding.includedSyncContact.imgFetchData.setImageResource(R.drawable.circular_checklayer)

        // val errormsg: String? = opData.getString(Constant.KEY_error_result)
        binding.includedSyncContact.txtProgressMessage.visibility = View.VISIBLE
        binding.includedSyncContact.txtProgressMessage.text = Constant.CONTACT_LOG_DataSending


        binding.includedSyncContact.txtPercent.text ="100%"
        binding.includedSyncContact.progressBar!!.max = 100
        binding.includedSyncContact.progressBar!!.setProgress(100)
    }
    private fun setOneTimeRequestWithCoroutine() {


        binding.includedSyncContact.lySync.visibility = View.VISIBLE
        binding.includedSyncContact.txtMessage.visibility = View.VISIBLE
        val workManager: WorkManager = WorkManager.getInstance(applicationContext)

        //callLogList: MutableList<CallLogEntity>

        val data: Data = Data.Builder()
            .putInt(Constant.KEY_fbaid, Integer.parseInt(userConstantEntity.fbaId))
            .putString(Constant.KEY_parentid, userConstantEntity.parentid)
            .putString(Constant.KEY_ssid, userConstantEntity!!.pospNo)
            .putString(Constant.KEY_deviceid, UTILITY.getDeviceID(this@SyncContactActivity))
            .putString(Constant.KEY_appversion, prefManager.appVersion)

            .build()


//        WorkManager.getInstance(this)
//            .beginUniqueWork("CallLogWorkManager", ExistingWorkPolicy.APPEND_OR_REPLACE,
//                OneTimeWorkRequest.from(CallLogWorkManager::class.java)).enqueue().state
//            .observe(this) { state ->
//                Log.d(TAGCALL, "CallLogWorkManager: $state")
//            }

        val constraintNetworkType: Constraints = Constraints.Builder()
            .setRequiredNetworkType(NetworkType.CONNECTED)
            .build()


        val callLogWorkRequest: OneTimeWorkRequest =
            OneTimeWorkRequest.Builder(CallLogWorkManager::class.java)
                .addTag(Constant.TAG_SAVING_CALL_LOG)
                .setInputData(data)
                .build()


        val ContactWorkRequest: OneTimeWorkRequest =
            OneTimeWorkRequest.Builder(ContactLogWorkManager::class.java)
                .addTag(Constant.TAG_SAVING_CONTACT_LOG)
                .setInputData(data)
                .build()


        //region Photo commented
//        val contactPhotRequest: OneTimeWorkRequest =
//            OneTimeWorkRequest.Builder(ContactPhotoWorkManager::class.java)
//                .addTag(Constant.TAG_SAVING_CONTACT_PHOTO_LOG)
//                .setInputData(data)
//                .build()

        //endregion
        // Todo : For Chain (Parallel Chaining)

        // region parallel chain commented
//        val parallelWorks: MutableList<OneTimeWorkRequest> = mutableListOf<OneTimeWorkRequest>()
//        parallelWorks.add(ContactWorkRequest)
//        parallelWorks.add(callLogWorkRequest)
//      //  parallelWorks.add(contactPhotRequest)
//        workManager.beginWith(parallelWorks)
//            .enqueue()

        //endregion

        workManager.beginWith(ContactWorkRequest)
           .then(callLogWorkRequest)
            .enqueue()




        //region  First Call -> ContactLog : Fetching the data

        workManager.getWorkInfoByIdLiveData(ContactWorkRequest.id)
            .observe(this,{workInfo: WorkInfo? ->


                // txtMessage.text = workInfo.state.name


                if(workInfo != null ) {


                    //region progress
                    val progress = workInfo.progress
                    val valueprogress = progress.getInt(Constant.CONTACT_LOG_Progress, 0)
                    val valueMaxProgress = progress.getInt(Constant.CONTACT_LOG_MAXProgress, 0)
                    updateProgrees(valueprogress, valueMaxProgress)
                    Log.d(
                        TAG,
                        "MaxProgress Progress :--> ${valueMaxProgress} and currentProgress :  ${valueprogress}"
                    )
                    //  endregion


                    if (workInfo.state.isFinished) {

                        if (workInfo.state == WorkInfo.State.SUCCEEDED){

                            // region After Success of Contact
                            val opData: Data = workInfo.outputData
                            val msg: String? = opData.getString(Constant.KEY_result)

                            successOfContact(msg)
                           // isContactWorkFinished = true
                            //checkContactAndCallLogTasksFinished()  //for parallel call

                            //endregion

                        }else if (workInfo.state == WorkInfo.State.FAILED){

                            // region Extract the error message from workInfo.outputData
                            val errorData = workInfo.outputData
                            val errorMessage = errorData.getString(Constant.KEY_error_result)

                            errorMessage(opMessage = errorMessage.toString())
                            // Handle failure here
                            workManager.cancelWorkById(ContactWorkRequest.id)
                            //endregion
                        }



                    }


                }



            })


        // endregion


        //region Second Call -> CallLog : sending to Server
        workManager.getWorkInfoByIdLiveData(callLogWorkRequest.id)
            .observe(this, { workInfo: WorkInfo? ->


                // txtMessage.text = workInfo.state.name

                if (workInfo != null) {

                    val progress = workInfo.progress
                    val valueprogress = progress.getInt(Constant.CALL_LOG_Progress, 0)
                    val valueMaxProgress = progress.getInt(Constant.CALL_LOG_MAXProgress, 0)
                     updateServerProgrees(valueprogress, valueMaxProgress)  // Requirement :-->  no need to show prog
                    Log.d(
                        TAG,
                        "MaxProgress Progress :--> ${valueMaxProgress} and currentProgress :  ${valueprogress}"
                    )
                    if (workInfo.state.isFinished) {

                        if (workInfo.state == WorkInfo.State.SUCCEEDED) {

                            // region After Success of CallLog
                            val opData: Data = workInfo.outputData
                            val msg: String? = opData.getString(Constant.KEY_result)

                            Log.d(TAG, workInfo.state.name + "\n\n" + msg)

                            binding.includedSyncContact.txtProgressMessage.visibility = View.GONE
                            binding.includedSyncContact.imgSendToServer.setImageResource(R.drawable.circular_checklayer)


                            if (msg.isNullOrEmpty()) {
                                saveMessage()
                            } else {
                                saveMessage(msg)
                            }

                            //isCallLogWorkFinished = true
                            //checkContactAndCallLogTasksFinished()  //for parallel call
                            //endregion

                        } else if (workInfo.state == WorkInfo.State.FAILED) {

                            // region Extract the error message from workInfo.outputData
                            val errorData = workInfo.outputData
                            val errorMessage = errorData.getString(Constant.KEY_error_result)

                            errorMessage(opMessage = errorMessage.toString())
                            // Handle failure here
                            workManager.cancelWorkById(ContactWorkRequest.id)
                            //endregion
                        }


                    }


                }


            })

        //endregion








    }

    // region Permission Handling

    private fun checkPermission(): Boolean {
        val read_contact = ActivityCompat.checkSelfPermission(this@SyncContactActivity, perms[0])
        val read_call_log = ActivityCompat.checkSelfPermission(this@SyncContactActivity, perms[1])

        return (read_contact == PackageManager.PERMISSION_GRANTED) && (read_call_log == PackageManager.PERMISSION_GRANTED)
    }


    private fun requestPermission() {
        ActivityCompat.requestPermissions(this@SyncContactActivity, perms, READ_CONTACTS_CODE)

    }

    private fun checkRationalePermission(): Boolean {
        val readContact =
            ActivityCompat.shouldShowRequestPermissionRationale(
                this@SyncContactActivity,
                Manifest.permission.READ_CONTACTS
            )

        val readCallLog =
            ActivityCompat.shouldShowRequestPermissionRationale(
                this@SyncContactActivity,
                Manifest.permission.READ_CALL_LOG
            )

        return readContact && readCallLog
    }

    fun permissionAlert() {
        val builder = AlertDialog.Builder(this)
        builder.setTitle("Need  Permission")
        builder.setMessage("This App Required Contact & Call Log Permissions.")
        //builder.setPositiveButton("OK", DialogInterface.OnClickListener(function = x))

        builder.setPositiveButton("Ok") { dialog, which ->


            dialog.cancel()
            val intent = Intent(Settings.ACTION_APPLICATION_DETAILS_SETTINGS)
            val uri = Uri.fromParts("package", packageName, null)
            intent.data = uri
            startActivityForResult(intent, REQUEST_PERMISSION_SETTING)

        }



        builder.show()
    }



    override fun onRequestPermissionsResult(
        requestCode: Int,
        permissions: Array<out String>,
        grantResults: IntArray
    ) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults)
        when (requestCode) {
            READ_CONTACTS_CODE -> {

                if (grantResults.isEmpty() || grantResults[0] == PackageManager.PERMISSION_GRANTED
                    && grantResults[1] == PackageManager.PERMISSION_GRANTED) {
                    // syncContactNumber()
                    // getCallDetails(this)

                    if (NetworkUtils.isNetworkAvailable(this@SyncContactActivity)) {
                        initData()
                        setOneTimeRequestWithCoroutine()
                    } else {
                      Snackbar.make(binding.root, "No Internet Connection", Snackbar.LENGTH_SHORT).show()
                    }

                }else{

                    permissionAlert()
                }
            }
        }
    }

// endregion

     fun showAnimDialog(msg: String){

        if(!dialogAnim.isShowing) {
            val dialogLoadingBinding = DialogLoadingBinding.inflate(layoutInflater)
            dialogAnim.setContentView(dialogLoadingBinding.root)

            dialogLoadingBinding.txtMessage1.visibility = View.VISIBLE
            dialogLoadingBinding.txtMessage1.text = "Please Wait While We Sync Your Contactly Afresh!"

            Glide.with(this).load<Any>(R.drawable.loading_spinner)
                .asGif()
                .crossFade()
                .into(dialogLoadingBinding.imgLoader)
            if (dialogAnim.window != null) {

                dialogAnim!!.window!!.setBackgroundDrawable(ColorDrawable(0))

            }

            dialogAnim.setCancelable(false)
            dialogAnim.show()
        }
    }

    fun cancelAnimDialog(){

        if(dialogAnim.isShowing){

            dialogAnim.dismiss()
        }
    }


    fun successAlert(

    ) {
        val builder = AlertDialog.Builder(this@SyncContactActivity, R.style.CustomDialog);
        val btnClose: Button
        val txtHdr: TextView
        val txtMessage: TextView
        val inflater = this.layoutInflater
        val dialogView = inflater.inflate(R.layout.layout_success_message, null)
        builder.setView(dialogView)
        val alertDialog = builder.create()

        btnClose = dialogView.findViewById(R.id.btnClose)
        txtMessage = dialogView.findViewById(R.id.txtMessage)
        txtHdr = dialogView.findViewById(R.id.txtHdr)
       // txtHdr.text = "" + strhdr
      //  txtMessage.text = "" + strBody

        btnClose.setOnClickListener {
            alertDialog.dismiss()
            this@SyncContactActivity.finish()
            var leaddetail = ""
            val append_lead =
                "&ip_address=&mac_address=&app_version=" + prefManager.appVersion + "&device_id="+prefManager.deviceID+ "&login_ssid="
            leaddetail = userConstantEntity.leadDashUrl + append_lead

            startActivity(Intent(this, CommonWebViewActivity::class.java)
                .putExtra("URL", "" + leaddetail)
                .putExtra("NAME", "" + "Sync Contact DashBoard")
                .putExtra("TITLE", "" + "Sync Contact DashBoard"))

        }
        alertDialog.setCancelable(false)
        alertDialog.show()

    }
    private fun updateProgrees(currentProg : Int , maxProg : Int){

        binding.includedSyncContact.progressBar!!.max = maxProg
        binding.includedSyncContact.progressBar!!.setProgress(currentProg)

        if(maxProg >0){
            binding.includedSyncContact.txtPercent.text = "${(currentProg*100)/maxProg} %"
        }

    }

    private fun updateServerProgrees(currentProg : Int , maxProg : Int){

        binding.includedSyncContact.progressBarServer!!.max = maxProg
        binding.includedSyncContact.progressBarServer!!.setProgress(currentProg)

        if(maxProg >0){
            binding.includedSyncContact.txtPercentServer.text = "${(currentProg*100)/maxProg} %"
        }

    }

    private fun saveMessage(opMessage : String = "Data Save Successfully..."){


        trackSyncContactEvent();
        successAlert()

        binding.includedSyncContact.txtPercentServer.text ="100%"
        binding.includedSyncContact.progressBarServer!!.max = 100
        binding.includedSyncContact.progressBarServer!!.setProgress(100)

        progress_circular!!.visibility = View.INVISIBLE

    }
    fun checkContactAndCallLogTasksFinished() {
        if (isContactWorkFinished && isCallLogWorkFinished) {
            // Both tasks are finished, show the success alert
               trackSyncContactEvent();
                successAlert()

        }
    }

    private fun errorMessage(opMessage : String = "Data not Uploade. Please Try Again..."){


        binding.includedSyncContact.txtProgressMessage.text = opMessage

        binding.includedSyncContact.txtProgressMessage.setTextColor(ContextCompat.getColor(this, R.color.red_button))
        //cancelAnimDialog()
        binding.includedSyncContact.lyTotal.visibility = View.GONE
        binding.includedSyncContact.txtPercent.text = "0%"
        binding.includedSyncContact.txtPercentServer.text = "0%"

        progress_circular!!.visibility = View.INVISIBLE

    }


    private fun trackSyncContactEvent() {
        // Create event attributes
        val eventAttributes: Map<String, Any> = HashMap()
        // Track the login event using WebEngageHelper
        WebEngageAnalytics.getInstance().trackEvent("Sync Contacts completed", eventAttributes)
    }


}





