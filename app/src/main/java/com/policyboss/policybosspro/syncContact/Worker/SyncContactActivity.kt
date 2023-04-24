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
import androidx.appcompat.app.AlertDialog
import androidx.core.app.ActivityCompat
import androidx.work.*
import com.bumptech.glide.Glide
import com.google.android.material.snackbar.Snackbar
import com.policyboss.policybosspro.BaseActivity
import com.policyboss.policybosspro.R
import com.policyboss.policybosspro.databinding.ActivitySyncContactBinding
import com.policyboss.policybosspro.databinding.DialogLoadingBinding
import com.policyboss.policybosspro.utility.Constant
import com.policyboss.policybosspro.utility.NetworkUtils
import com.policyboss.policybosspro.utility.UTILITY
import com.policyboss.policybosspro.webviews.CommonWebViewActivity
import com.utility.finmartcontact.home.Worker.CallLogWorkManager
import com.utility.finmartcontact.home.Worker.ContactLogWorkManager
import magicfinmart.datacomp.com.finmartserviceapi.database.DBPersistanceController
import magicfinmart.datacomp.com.finmartserviceapi.finmart.model.LoginResponseEntity
import magicfinmart.datacomp.com.finmartserviceapi.finmart.model.UserConstantEntity

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

    var progressBar: ProgressBar? = null
    var progress_circular : ProgressBar? = null
    lateinit var  txtPercent :TextView

    var perms = arrayOf(
        "android.permission.READ_CONTACTS",
        "android.permission.READ_CALL_LOG"
    )

    lateinit var loginResponseEntity: LoginResponseEntity
    lateinit var userConstantEntity: UserConstantEntity
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
        progressBar = findViewById(R.id.progressBar)
        progress_circular = findViewById(R.id.progress_circular)
        txtPercent = findViewById(R.id.txtPercent)

        dialogAnim = Dialog(this)

        loginResponseEntity = DBPersistanceController(this).userData
        userConstantEntity = DBPersistanceController(this).userConstantsData


      //  binding.includedSyncContact.CvSync.setOnClickListener(this)

      //  binding.includedSyncContact.CvLeaddashboard.setOnClickListener(this)

        if (!checkPermission()) {
            requestPermission()
        }else{
            if (NetworkUtils.isNetworkAvailable(this@SyncContactActivity)) {
                initData()
                setOneTimeRequestWithCoroutine()
            } else {
                Snackbar.make( binding.includedSyncContact.CvSync, getString(R.string.noInternet), Snackbar.LENGTH_SHORT).show()
            }

        }

    }

    override fun onClick(view: View?) {
        when(view!!.id){

/*
        R.id.CvSync -> {

            //region commented
            if (!checkPermission()) {
                requestPermission()
            }
            else {

                // syncContactNumber()
                // API For Contact

                if (NetworkUtils.isNetworkAvailable(this@SyncContactActivity)) {
                    initData()
                    setOneTimeRequestWithCoroutine()
                } else {
                    Snackbar.make( binding.includedSyncContact.CvSync, "No Internet Connection", Snackbar.LENGTH_SHORT).show()
                }


            }


            //endregion



        }*/
//        R.id.CvLeaddashboard -> {
//            startActivity(Intent(this, CommonWebViewActivity::class.java) // .putExtra("URL", "https://bo.magicfinmart.com/motor-lead-details/" + String.valueOf(loginResponseEntity.getFBAId()))
//                .putExtra("URL", "" + userConstantEntity.leadDashUrl)
//                .putExtra("NAME", "" + "Lead DashBoard")
//                .putExtra("TITLE", "" + "Lead DashBoard"))
//        }


        }
    }


    fun initData(){

        currentProgress =0
        maxProgress = 0
        binding.includedSyncContact.progressBar!!.setProgress(currentProgress)
        binding.includedSyncContact.progressBarButton.visibility = View.VISIBLE
        binding.includedSyncContact.lySync.visibility = View.VISIBLE
        binding.includedSyncContact.CvSync.isEnabled = false
        binding.includedSyncContact.txtPercent.text = "0%"

        binding.includedSyncContact.txtMessage.text = ""
        binding.includedSyncContact.txtCount.text = ""

        //05
       // showAnimDialog("")

    }

    private fun setOneTimeRequestWithCoroutine() {


        binding.includedSyncContact.lySync.visibility = View.VISIBLE
        binding.includedSyncContact.txtMessage.visibility = View.VISIBLE
        val workManager: WorkManager = WorkManager.getInstance(applicationContext)

        //callLogList: MutableList<CallLogEntity>

        val data: Data = Data.Builder()
            .putInt(Constant.KEY_fbaid, loginResponseEntity.fbaId)
            .putString(Constant.KEY_parentid, userConstantEntity.parentid)
            .putString(Constant.KEY_ssid, userConstantEntity!!.pospNo)
            .putString(Constant.KEY_deviceid, UTILITY.getDeviceID(this@SyncContactActivity))
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
                .addTag(Constant.TAG_SAVING_CALL_LOG)
                .setInputData(data)
                .build()

        // Todo : For Chain (Parallel Chaining)
        val parallelWorks: MutableList<OneTimeWorkRequest> = mutableListOf<OneTimeWorkRequest>()
        parallelWorks.add(ContactWorkRequest)
        parallelWorks.add(callLogWorkRequest)
        workManager.beginWith(parallelWorks)
            .enqueue()



        workManager.getWorkInfoByIdLiveData(callLogWorkRequest.id)
            .observe(this, { workInfo: WorkInfo? ->


                // txtMessage.text = workInfo.state.name

                if (workInfo != null) {

                    val progress = workInfo.progress
                    val valueprogress = progress.getInt(Constant.CALL_LOG_Progress, 0)
                    val valueMaxProgress = progress.getInt(Constant.CALL_LOG_MAXProgress, 0)
                   updateProgrees(valueprogress, valueMaxProgress)  // Requirement :-->  no need to show prog
                    Log.d(
                        "CALL_LOG",
                        "MaxProgress Progress :--> ${valueMaxProgress} and currentProgress :  ${valueprogress}"
                    )
                    if (workInfo.state.isFinished) {
                        val opData: Data = workInfo.outputData
                        val msg: String? = opData.getString(Constant.KEY_result)
                        val errormsg: String? = opData.getString(Constant.KEY_error_result)
                        Log.d("CALL_LOG", workInfo.state.name + "\n\n" + msg)


                        if (!errormsg.isNullOrEmpty()) {
                            //  errormsg?.let { saveMessage(it) }
                            errorMessage(errormsg)
                        } else {

                            if (msg.isNullOrEmpty()) {
                                saveMessage()
                            } else {
                                saveMessage(msg)
                            }
                        }


                    }


                }


            })


        //region Commented :-- contact Progress Not Showing


        workManager.getWorkInfoByIdLiveData(ContactWorkRequest.id)
            .observe(this,{workInfo: WorkInfo? ->


                // txtMessage.text = workInfo.state.name

                if(workInfo != null ){

                    //region commented
                    //          val progress = workInfo.progress
                    //                   val valueprogress = progress.getInt(Constant.CONTACT_LOG_Progress, 0)
//                    val valueMaxProgress = progress.getInt(Constant.CONTACT_LOG_MAXProgress, 0)
//                    updateProgrees(valueprogress,valueMaxProgress)
                    //  Log.d("CALL_LOG", "MaxProgress Progress :--> ${valueMaxProgress} and currentProgress :  ${valueprogress}")
                    //endregion

                    if( workInfo.state.isFinished){
                        val opData : Data = workInfo.outputData
                        val msg : String? = opData.getString(Constant.KEY_result)

                        binding.includedSyncContact.txtCount.text = msg?: ""

                        //region commented
//                        if(!errormsg.isNullOrEmpty()){
//                            //  errormsg?.let { saveMessage(it) }
//                            errorMessage(errormsg)
//                        }else{
//                            if(msg.isNullOrEmpty()){
//                                saveMessage()
//                            }else{
//                                saveMessage(msg)
//                            }
//                        }
                        //endregion




                    }


                }



            })



        // endregion



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
                      Snackbar.make(binding.includedSyncContact.CvSync, "No Internet Connection", Snackbar.LENGTH_SHORT).show()
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
            startActivity(Intent(this, CommonWebViewActivity::class.java) // .putExtra("URL", "https://bo.magicfinmart.com/motor-lead-details/" + String.valueOf(loginResponseEntity.getFBAId()))
                .putExtra("URL", "" + userConstantEntity.leadDashUrl)
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

    private fun saveMessage(opMessage : String = "Data Save Successfully..."){

      //binding.includedSyncContact.txtMessage.text = opMessage

        successAlert()
        cancelAnimDialog()

       // binding.includedSyncContact.CvSync.isEnabled = true

        binding.includedSyncContact.txtPercent.text ="100%"
        binding.includedSyncContact.progressBar!!.max = 100
        binding.includedSyncContact.progressBar!!.setProgress(100)
        binding.includedSyncContact.progressBarButton.visibility = View.GONE
        progress_circular!!.visibility = View.GONE

    }

    private fun errorMessage(opMessage : String = "Data not Uploade. Please Try Again..."){


        binding.includedSyncContact.txtMessage.text = opMessage
        cancelAnimDialog()

     // binding.includedSyncContact.CvSync.isEnabled = true
        binding.includedSyncContact.progressBarButton.visibility = View.GONE
        progress_circular!!.visibility = View.GONE
    }




}





