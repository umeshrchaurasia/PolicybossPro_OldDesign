package com.policyboss.policybosspro.syncContact.Worker


import android.annotation.SuppressLint
import android.app.Dialog
import android.content.Intent
import android.graphics.drawable.ColorDrawable
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.View.OnClickListener
import android.view.ViewGroup
import android.widget.*
import android.app.AlertDialog

import com.bumptech.glide.Glide
import com.policyboss.policybosspro.BaseActivity
import com.policyboss.policybosspro.R
import com.policyboss.policybosspro.databinding.ActivityWelcomeSyncContactNewBinding
import com.policyboss.policybosspro.databinding.DialogLoadingBinding
import com.policyboss.policybosspro.webviews.CommonWebViewActivity
import com.utility.finmartcontact.core.requestentity.CallLogRequestEntity
import kotlinx.coroutines.*
import magicfinmart.datacomp.com.finmartserviceapi.PrefManager
import magicfinmart.datacomp.com.finmartserviceapi.database.DBPersistanceController
import magicfinmart.datacomp.com.finmartserviceapi.dynamic_urls.response.CheckboxsaveResponse
import magicfinmart.datacomp.com.finmartserviceapi.finmart.model.UserConstantEntity
import magicfinmart.datacomp.com.finmartserviceapi.finmart.requestentity.syncContact.SaveCheckboxRequestEntity
import magicfinmart.datacomp.com.finmartserviceapi.finmart.retrobuilder.RetroHelper
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.Url

/**********************************
//NOT IN USED
**********************************/
class WelcomeSyncContactActivityNew : BaseActivity() , OnClickListener {

    lateinit var binding: ActivityWelcomeSyncContactNewBinding
    private lateinit var dialogAnim : Dialog
    val TAG = "HORIZONEMP"

//    lateinit var viewPager: ViewPager
   // lateinit var myViewPagerAdapter: MyViewPagerAdapter
   // lateinit var dotsLayout: LinearLayout
    lateinit var  layouts: IntArray
    lateinit var btnNext: Button

    lateinit var txtprivacy:TextView
    lateinit  var txtterm:TextView

    lateinit var tvClickHere:TextView
    var current = 0
    lateinit var btnchkagree: CheckBox
    lateinit var btnchkcommunication_sms: CheckBox
    lateinit var btnchktele_call: CheckBox

    lateinit  var ll_term: LinearLayout
    lateinit var  txtsetting:TextView

    var isContactSync_msg = 0
    lateinit var userConstantEntity: UserConstantEntity


   lateinit var shareProdSyncDialog: AlertDialog
    var POSPNO = ""
    var FBAID = ""

    lateinit var prefManager : PrefManager

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
       // setContentView(R.layout.activity_welcome_sync_contact_new)

        binding = ActivityWelcomeSyncContactNewBinding.inflate(layoutInflater)
        setContentView(binding.root)

        dialogAnim = Dialog(this)
        userConstantEntity = DBPersistanceController(this).userConstantsData

        POSPNO = userConstantEntity.pospNo

        FBAID = userConstantEntity.fbaId

        init_widgets()
        setListener()
     //   showAnimDialog("")
        CoroutineScope(Dispatchers.IO).launch {
            try {
                showDialog()

              getHorizonDetails()

            }catch (e: Exception){

                withContext(Dispatchers.Main) {
                 //   viewPager.visibility = View.VISIBLE
                    cancelAnimDialog()
                }
            }
        }

//        if (intent.getStringExtra("Is_Contact_Sync") != null) {
//            isContactSync = intent.getStringExtra("Is_Contact_Sync")!!
//        }

    }

    private fun init_widgets() {
/*
        layouts = intArrayOf(
            R.layout.sync_welcome_slide1,
            R.layout.sync_welcome_slide2,
            R.layout.sync_welcome_slide3
        )*/
       // viewPager = binding.viewPager
       // viewPager.visibility = GONE
      //  dotsLayout = binding.layoutDots

        btnNext = binding.btnNext
        btnchkagree = binding.chkagree
        btnchkcommunication_sms = binding.chkcommunicationSms
        btnchktele_call = binding.chkteleCall


        txtterm = binding.txtterm
        txtprivacy = binding.txtprivacy

        tvClickHere = binding.tvClickHere

        ll_term = binding.llTerm
        btnchkagree!!.tag = 0

        btnchkcommunication_sms!!.tag = 0
        btnchktele_call!!.tag = 0

        btnNext.isEnabled = false
        btnNext.alpha = 0.4f
        btnNext.tag = 0
    }

    private fun setListener() {
     //   myViewPagerAdapter = MyViewPagerAdapter()
     //   viewPager!!.adapter = myViewPagerAdapter

    //    viewPager!!.addOnPageChangeListener(viewPagerPageChangeListener)
        btnNext.setOnClickListener(this)
        btnchkagree.setOnClickListener(this)

        btnchkcommunication_sms.setOnClickListener(this)
        btnchktele_call.setOnClickListener(this)

        txtprivacy.setOnClickListener(this)
        txtterm.setOnClickListener(this)

        tvClickHere.setOnClickListener(this)

        ll_term.setOnClickListener(this)
      //  ll_term.visibility = View.GONE
        btnchkagree!!.isChecked = false
        btnchkcommunication_sms!!.isChecked = false
        btnchktele_call!!.isChecked = false
    }
/*
    private fun setSelectedDot(current: Int) {
      //  binding.dot1.setImageDrawable(ContextCompat.getDrawable(this, R.drawable.unselected_dot))
      //  binding.dot2.setImageDrawable(ContextCompat.getDrawable(this, R.drawable.unselected_dot))
      //  binding.dot3.setImageDrawable(ContextCompat.getDrawable(this, R.drawable.unselected_dot))
        /*
        when (current) {
            1 -> binding.dot1.setImageDrawable(
                ContextCompat.getDrawable(
                    this,
                    R.drawable.indicator_active
                )
            )
            2 -> binding.dot2.setImageDrawable(
                ContextCompat.getDrawable(
                    this,
                    R.drawable.indicator_active
                )
            )
            3 -> binding.dot3.setImageDrawable(
                ContextCompat.getDrawable(
                    this,
                    R.drawable.indicator_active
                )
            )
        }*/
    }*/

    private suspend fun getHorizonDetails(){

        withContext(Dispatchers.IO){

           // var url =  "https://horizon.policyboss.com:5443/sync_contacts" + "/contact_entry"

            var url = "https://horizon.policyboss.com:5443/sync_contact/get_sync_contact_agreements?ss_id=" + POSPNO
            val resultRespAsync = async { RetroHelper.api.getHorizonDetails(url) }
             val resultResp = resultRespAsync.await()
            if (resultResp.isSuccessful) {
                cancelDialog()
                Log.d(TAG, resultResp.toString())
                if(resultResp.body()?.Status.equals("Success")){

                    var Horizon_sync_contact_agree_Response = resultResp.body()
                    isContactSync_msg = Horizon_sync_contact_agree_Response?.Msg?.size?:0




                    withContext(Dispatchers.Main){

                        var is_call = ""
                        var is_sms  = ""
                        is_call = Horizon_sync_contact_agree_Response?.Msg?.get(isContactSync_msg-1)?.is_call?:""
                        is_sms = Horizon_sync_contact_agree_Response?.Msg?.get(isContactSync_msg-1)?.is_sms?:""

                        if(is_call.equals("yes")){
                                btnchktele_call.isChecked = true

                            }else
                        {
                                btnchktele_call.isChecked = false
                        }

                        if(is_sms.equals("yes")){
                                btnchkcommunication_sms.isChecked = true
                            }else
                        {
                            btnchkcommunication_sms.isChecked = false
                        }



                    }
                }else{
                    withContext(Dispatchers.Main) {
                        Log.d(TAG, resultResp.toString())
                       // viewPager.visibility = View.VISIBLE
                        cancelAnimDialog()
                    }
                }


                // delay(8000)



            }else{

                withContext(Dispatchers.Main) {
                    Log.d(TAG, resultResp.toString())
                   // viewPager.visibility = View.VISIBLE
                    cancelAnimDialog()
                }
                cancelDialog()
            }

        }

    }

    @SuppressLint("SuspiciousIndentation")
    private suspend fun savecheckboxdetails(){

        withContext(Dispatchers.IO){

            // var url =  "https://horizon.policyboss.com:5443/sync_contacts" + "/contact_entry"
            var url = "https://horizon.policyboss.com:5443/postservicecall/sync_contacts/online_agreement"


            var smschk ="no"

            var telechk ="no"

               if(btnchkcommunication_sms!!.isChecked){
                   smschk="yes"
               }else{
                   smschk="no"
               }

               if(btnchktele_call!!.isChecked){
                   telechk="yes"
               }else{
                   telechk="no"
               }

            val saveCheckboxRequestEntity = SaveCheckboxRequestEntity(

                fba_id = Integer.parseInt(FBAID),
                is_sms = smschk,
                is_call = telechk,
                online_agreement = "online_agreement",
                ss_id = Integer.parseInt(POSPNO) ,
                app_version = prefManager.appVersion,
                device_code = prefManager.deviceID
            )

          // val resultRespAsync1 =  RetroHelper.api.savecheckboxdetails(url,saveCheckboxRequestEntity)
          //  val resultResp = resultRespAsync.await()

            val resultRespAsync = async { RetroHelper.api.savecheckboxdetails(url,saveCheckboxRequestEntity) }
            val resultResp = resultRespAsync.await()

            if (resultResp.isSuccessful) {
                cancelDialog()
                Log.d(TAG, resultResp.toString())
                           // delay(8000)
            }else{

                withContext(Dispatchers.Main) {
                    Log.d(TAG, resultResp.toString())
                    // viewPager.visibility = View.VISIBLE
                    cancelAnimDialog()
                }
                cancelDialog()
            }

        }

    }

        //  viewpager change listener


    override fun onClick(view: View?) {

        when (view!!.getId()) {
            btnNext.id -> {
           //     btnchktele!!.isChecked && btnchkcommunication!!.isChecked &&
                if ( btnchkagree!!.isChecked ) {
                    // current = current + 1
                    // if (current < layouts.size) {
                    // move to next screen
                    //     viewPager.currentItem = current
                    //  } else {


                        CoroutineScope(Dispatchers.IO).launch {
                            try { //showDialog()

                              savecheckboxdetails()

                            }catch (e: Exception){

                                withContext(Dispatchers.Main) {
                                 //   viewPager.visibility = View.VISIBLE
                                 //   cancelAnimDialog()
                                }
                            }
                        }
                           startActivity(Intent(this, SyncContactActivity::class.java))
                    //  }
                }
            }

         //   R.id.btn_skip -> startActivity(Intent(this, SyncContactActivity::class.java))

            txtprivacy.id -> startActivity(
                Intent(this, CommonWebViewActivity::class.java)
                    .putExtra(
                        "URL",
                        "https://www.policyboss.com/privacy-policy-policyboss-pro?app_version="+prefManager.getAppVersion()+"&device_code="+prefManager.getDeviceID()+"&ssid=&fbaid="
                    )
                    .putExtra("NAME", "" + "privacy-policy")
                    .putExtra("TITLE", "" + "privacy-policy")
            )
            txtterm.id -> startActivity(
                Intent(this, CommonWebViewActivity::class.java)
                    .putExtra("URL", "https://www.policyboss.com/terms-condition?app_version="+prefManager.getAppVersion()+"&device_code="+prefManager.getDeviceID()+"&ssid=&fbaid=")
                    .putExtra("NAME", "" + "Terms & Conditions")
                    .putExtra("TITLE", "" + "Terms & Conditions")
            )
            tvClickHere.id -> SyncTermPopUp()

            btnchkagree.id -> if (btnchkagree!!.tag != "1") {
                if (btnchkagree!!.isChecked ) {
                    btnNext.isEnabled = true
                 //   btnNext.alpha = 1f

                 //   btnNext.setVisibility(View.VISIBLE);
                    btnNext.tag = 1
                    btnNext.alpha = 1f
                  //  btnNext.text = "NEXT"
                } else {
                    btnNext.isEnabled = false
                    btnNext.alpha = 0.4f
                }
            }

//            btnchktele.id -> if (btnchktele!!.tag != "1") {
//                if (btnchktele!!.isChecked && btnchkcommunication!!.isChecked && btnchkagree!!.isChecked ) {
//                    btnNext.isEnabled = true
//                //    btnNext.alpha = 1f
//                    //btnNext.setVisibility(View.VISIBLE);
//                    btnNext.tag = 1
//                    btnNext.alpha = 1f
//                  //  btnNext.text = "NEXT"
//                } else {
//                    btnNext.isEnabled = false
//                    btnNext.alpha = 0.4f
//                }
//            }
//            btnchkcommunication.id -> if (btnchkcommunication!!.tag != "1") {
//                if (btnchktele!!.isChecked && btnchkcommunication!!.isChecked && btnchkagree!!.isChecked ) {
//                    btnNext.isEnabled = true
//                //    btnNext.alpha = 1f
//                    //btnNext.setVisibility(View.VISIBLE);
//                    btnNext.tag = 1
//                    btnNext.alpha = 1f
//                //    btnNext.text = "NEXT"
//                } else {
//                    btnNext.isEnabled = false
//                    btnNext.alpha = 0.4f
//                }
//            }


        }
    }

    fun showAnimDialog(msg: String){

        if(!dialogAnim.isShowing) {
            val dialogLoadingBinding = DialogLoadingBinding.inflate(layoutInflater)
            dialogAnim.setContentView(dialogLoadingBinding.root)
            Glide.with(this).load<Any>(R.drawable.loading_gif)
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


    fun SyncTermPopUp() {

        if (this::shareProdSyncDialog.isInitialized  && shareProdSyncDialog.isShowing()) {
            return
        }

        val builder = AlertDialog.Builder(this@WelcomeSyncContactActivityNew)
        val txtTitle: TextView
        val txtMessage: TextView
        val btnShare: Button
        val ivCross: ImageView
        val inflater = this.layoutInflater
        val dialogView = inflater.inflate(R.layout.layout_syncterm_popup, null)
        builder.setView(dialogView)
        shareProdSyncDialog = builder.create()
        // set the custom dialog components - text, image and button
        txtTitle = dialogView.findViewById<View>(R.id.txtTitle) as TextView
        txtMessage = dialogView.findViewById<View>(R.id.txtMessage) as TextView
        btnShare = dialogView.findViewById<View>(R.id.btnShare) as Button
        ivCross = dialogView.findViewById<View>(R.id.ivCross) as ImageView
      //  txtTitle.text = ""
     //   txtMessage.text = ""

        // txtMessage.setText(getResources().getString(R.string.myaccount_update));
        ivCross.setOnClickListener { shareProdSyncDialog.dismiss() }

        shareProdSyncDialog.setCancelable(true)
        shareProdSyncDialog.setCanceledOnTouchOutside(true)
        shareProdSyncDialog.show()
        //  alertDialog.getWindow().setLayout(900, 600);

        // for user define height and width..
    }


}