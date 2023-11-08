package com.policyboss.policybosspro.syncContact.Worker

import android.annotation.SuppressLint
import android.app.Dialog
import android.content.Context
import android.content.Intent
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.Window
import android.widget.*
import android.app.AlertDialog
import android.content.pm.PackageManager
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat
import androidx.viewpager.widget.PagerAdapter
import androidx.viewpager.widget.ViewPager
import com.google.android.material.snackbar.Snackbar
import com.policyboss.policybosspro.BaseActivity
import com.policyboss.policybosspro.R
import com.policyboss.policybosspro.analytics.WebEngageAnalytics
import com.policyboss.policybosspro.databinding.ActivityWelcomeSyncContactKotlinBinding
import com.policyboss.policybosspro.myaccount.MyAccountActivity
import com.policyboss.policybosspro.utility.NetworkUtils
import com.policyboss.policybosspro.webviews.CommonWebViewActivity
import com.webengage.sdk.android.WebEngage
import kotlinx.coroutines.*
import magicfinmart.datacomp.com.finmartserviceapi.PrefManager
import magicfinmart.datacomp.com.finmartserviceapi.database.DBPersistanceController
import magicfinmart.datacomp.com.finmartserviceapi.finmart.model.UserConstantEntity
import magicfinmart.datacomp.com.finmartserviceapi.finmart.requestentity.syncContact.SaveCheckboxRequestEntity
import magicfinmart.datacomp.com.finmartserviceapi.finmart.retrobuilder.RetroHelper


class WelcomeSyncContactActivityKotlin: BaseActivity() , View.OnClickListener {

    lateinit var binding: ActivityWelcomeSyncContactKotlinBinding
    private lateinit var dialogAnim : Dialog
    val TAG = "HORIZONEMP"

    private lateinit var dialog: Dialog
    lateinit var viewPager: ViewPager
    lateinit var myViewPagerAdapter: MyViewPagerAdapter
    private lateinit var onPageChangeListener: ViewPager.OnPageChangeListener

    lateinit var dotsLayout: LinearLayout
    lateinit var  layouts: IntArray
    lateinit var btnNext: Button
    lateinit var dot1: ImageView
    lateinit var dot2: ImageView
    lateinit var dot3: ImageView
    lateinit var txtprivacy: TextView
    lateinit  var txtterm: TextView


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

    var perms = arrayOf(
        "android.permission.READ_CONTACTS",
        "android.permission.READ_CALL_LOG"
    )
    val READ_CONTACTS_CODE = 101

    override fun onStart() {
        super.onStart()
        val weAnalytics = WebEngage.get().analytics()
        weAnalytics.screenNavigated("Welcome Sync Contact Screen")
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityWelcomeSyncContactKotlinBinding.inflate(layoutInflater)
        setContentView(binding.root)

        dialogAnim = Dialog(this)
        userConstantEntity = DBPersistanceController(this).userConstantsData

        prefManager = PrefManager(this@WelcomeSyncContactActivityKotlin)
        POSPNO = userConstantEntity.pospNo

        FBAID = userConstantEntity.fbaId

        viewPager = binding.viewPager
        init_widgets()
        setListener()
        myViewPagerAdapter = MyViewPagerAdapter(this@WelcomeSyncContactActivityKotlin)
        viewPager!!.adapter = myViewPagerAdapter


        showAnimDialog("Please Wait...")

        CoroutineScope(Dispatchers.IO).launch {
            try {

                getHorizonDetails()

            }catch (e: Exception){

                withContext(Dispatchers.Main) {
                    //   viewPager.visibility = View.VISIBLE
                    cancelAnimDialog()
                }
            }
        }

        onPageChangeListener = object : ViewPager.OnPageChangeListener{
            override fun onPageScrolled(
                position: Int,
                positionOffset: Float,
                positionOffsetPixels: Int
            ) {

            }

            override fun onPageSelected(position: Int) {

                //addBottomDots(position);
                current = position

                setSelectedDot(position + 1)
                // changing the next button text 'NEXT' / 'GOT IT'
                // changing the next button text 'NEXT' / 'GOT IT'
                if (position == layouts.size - 1) {
                    // last page. make button text to GOT IT
                    btnNext.text = "GET STARTED"
                    //  btnNext.setVisibility(View.GONE);
                    btnNext.isEnabled = false
                    btnNext.alpha = 0.4f
                    btnNext.tag = 0
                    ll_term.visibility = View.VISIBLE
                    txtsetting.visibility = View.VISIBLE


                    // btnSkip.setVisibility(View.VISIBLE);
                } else {
                    // still pages are left
                    ll_term.visibility = View.GONE
                    txtsetting.visibility = View.GONE
                    //btnNext.setVisibility(View.VISIBLE);
                    btnNext.tag = 1
                    btnNext.alpha = 1f
                    btnNext.text = "NEXT"
                    btnchkagree.isChecked = false
                    btnNext.isEnabled = true
                    //  btnNext.setVisibility(View.GONE);
                    // btnSkip.setVisibility(View.VISIBLE);
                }
            }

            override fun onPageScrollStateChanged(state: Int) {

            }

        }

        viewPage2Listener()
    }

    //region method
    private fun init_widgets() {

        dot1 = binding.dot1
        dot2 = binding.dot2
        dot3 = binding.dot3

        layouts = intArrayOf(
            R.layout.sync_welcome_slide1,
            R.layout.sync_welcome_slide2,
            R.layout.sync_welcome_slide3
        )


        dotsLayout = binding.layoutDots

        btnNext = binding.btnNext
        btnchkagree = binding.chkagree
        btnchkcommunication_sms = binding.chkcommunicationSms
        btnchktele_call = binding.chkteleCall


        txtterm = binding.txtterm
        txtprivacy = binding.txtprivacy



        ll_term = binding.llTerm
        txtsetting = binding.txtsetting

        btnchkagree!!.tag = 0

        btnchkcommunication_sms!!.tag = 0
        btnchktele_call!!.tag = 0

//        btnNext.isEnabled = false
//        btnNext.alpha = 0.4f
        btnNext.tag = 0

        ll_term.visibility = View.GONE
        txtsetting.visibility =View.GONE
    }

    private fun setListener() {

        //    viewPager!!.addOnPageChangeListener(viewPagerPageChangeListener)
        btnNext.setOnClickListener(this)
        btnchkagree.setOnClickListener(this)

        btnchkcommunication_sms.setOnClickListener(this)
        btnchktele_call.setOnClickListener(this)

        txtprivacy.setOnClickListener(this)
        txtterm.setOnClickListener(this)

        txtsetting.setOnClickListener(this)

        // ll_term.setOnClickListener(this)
        //  ll_term.visibility = View.GONE
        btnchkagree!!.isChecked = false
        btnchkcommunication_sms!!.isChecked = false
        btnchktele_call!!.isChecked = false
    }

    private fun viewPage2Listener(){

        viewPager.addOnPageChangeListener(onPageChangeListener)
    }


    private fun setSelectedDot(current: Int) {

        dot1.setImageDrawable(ContextCompat.getDrawable(this@WelcomeSyncContactActivityKotlin,R.drawable.unselected_dot))
        dot2.setImageDrawable(ContextCompat.getDrawable(this@WelcomeSyncContactActivityKotlin,R.drawable.unselected_dot))
        dot3.setImageDrawable(ContextCompat.getDrawable(this@WelcomeSyncContactActivityKotlin,R.drawable.unselected_dot))

        when (current) {
            1 -> dot1.setImageDrawable(ContextCompat.getDrawable(this@WelcomeSyncContactActivityKotlin,R.drawable.indicator_active))
            2 -> dot2.setImageDrawable(ContextCompat.getDrawable(this@WelcomeSyncContactActivityKotlin,R.drawable.indicator_active))
            3 -> dot3.setImageDrawable(ContextCompat.getDrawable(this@WelcomeSyncContactActivityKotlin,R.drawable.indicator_active))
        }
    }


    private suspend fun getHorizonDetails(){


        withContext(Dispatchers.IO){

            // var url =  "https://horizon.policyboss.com:5443/sync_contacts" + "/contact_entry"

            var url = "https://horizon.policyboss.com:5443/sync_contact/get_sync_contact_agreements?ss_id=" + POSPNO +
                    "&device_code="+prefManager.getDeviceID()+"&app_version="+prefManager.getAppVersion()+"&fbaid="+FBAID


            val resultRespAsync = async { RetroHelper.api.getHorizonDetails(url) }
            val resultResp = resultRespAsync.await()
            if (resultResp.isSuccessful) {
                cancelAnimDialog()
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

                        if (!checkPermission()) {
                            requestPermission()
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
                cancelAnimDialog()
            }

        }

    }

    //region permission
    private fun checkPermission(): Boolean {
        val read_contact = ActivityCompat.checkSelfPermission(this@WelcomeSyncContactActivityKotlin, perms[0])
        val read_call_log = ActivityCompat.checkSelfPermission(this@WelcomeSyncContactActivityKotlin, perms[1])

        return (read_contact == PackageManager.PERMISSION_GRANTED) && (read_call_log == PackageManager.PERMISSION_GRANTED)
    }


    private fun requestPermission() {
        ActivityCompat.requestPermissions(this@WelcomeSyncContactActivityKotlin, perms, READ_CONTACTS_CODE)

    }
    //endregion
    fun showAnimDialog(msg: String? = ""){


        try {
            if (!this::dialog.isInitialized) {
                dialog = Dialog(this)
                dialog.requestWindowFeature(Window.FEATURE_NO_TITLE)
                dialog.setContentView(R.layout.progressdialog2_loading)
                dialog!!.window!!.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))
                dialog.setCancelable(false)

            }
            val txtMessage = dialog.findViewById<TextView>(R.id.txtMessage)

            txtMessage.text = msg


            //hide keyboard
            //view.context.hideKeyboard(view)

            dialog.let {
                if (!it.isShowing) {
                    it.show()
                }
            }

        } catch (e: Exception) {
            e.printStackTrace()
        }


    }

    fun cancelAnimDialog(){


        if (dialog != null) {
            dialog!!.dismiss()
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
                ss_id = Integer.parseInt(POSPNO),
                app_version = prefManager.appVersion,
                device_code = prefManager.deviceID

            )

            // val resultRespAsync1 =  RetroHelper.api.savecheckboxdetails(url,saveCheckboxRequestEntity)
            //  val resultResp = resultRespAsync.await()

            val resultRespAsync = async { RetroHelper.api.savecheckboxdetails(url,saveCheckboxRequestEntity) }
            val resultResp = resultRespAsync.await()

            if (resultResp.isSuccessful) {
                // cancelAnimDialog()
                Log.d(TAG, resultResp.toString())
                // delay(8000)
            }else{

                withContext(Dispatchers.Main) {
                    Log.d(TAG, resultResp.toString())
                    // viewPager.visibility = View.VISIBLE
                    // cancelAnimDialog()
                }
                //cancelAnimDialog()
            }

        }

    }

    //endregion
    override fun onClick(view: View?) {

        when (view!!.getId()) {
            btnNext.id -> {

                if (NetworkUtils.isNetworkAvailable(this@WelcomeSyncContactActivityKotlin)) {

                    //     btnchktele!!.isChecked && btnchkcommunication!!.isChecked &&
                    // if ( btnchkagree!!.isChecked ) {
                    current = current + 1
                    if (current < layouts.size) {
                        //move to next screen
                        viewPager.currentItem = current
                    } else {

                        // For Submit : Get Started
                        CoroutineScope(Dispatchers.IO).launch {
                            try { //showDialog()

                                savecheckboxdetails()

                            } catch (e: Exception) {

                                withContext(Dispatchers.Main) {
                                    //   viewPager.visibility = View.VISIBLE
                                    //   cancelAnimDialog()
                                }
                            }
                        }
                        trackSyncContactEvent("Get Started on Sync Contacts")
                        startActivity(Intent(this, SyncContactActivity::class.java))

                    }
                } else {
                    Snackbar.make(binding.root, "No Internet Connection", Snackbar.LENGTH_SHORT).show()
                }


                //  }
            }

            //   R.id.btn_skip -> startActivity(Intent(this, SyncContactActivity::class.java))

            txtprivacy.id -> {
            trackSyncContactEvent("Read Privacy Policy for Sync Contacts")

                    startActivity (
                    Intent(this, CommonWebViewActivity::class.java)
                        .putExtra(
                            "URL",
                            "https://www.policyboss.com//privacy-policy-policyboss-pro?app_version=" + prefManager.appVersion + "&device_code=" + prefManager.deviceID + "&ssid=" + POSPNO + "&fbaid=" + FBAID
                        )
                        .putExtra("NAME", "" + "privacy-policy")
                        .putExtra("TITLE", "" + "privacy-policy")
                    )
           }
            txtterm.id -> {
                trackSyncContactEvent("T&C Viewed for Sync Contacts")

                startActivity(
                    Intent(this, CommonWebViewActivity::class.java)
                        .putExtra(
                            "URL",
                            "https://www.policyboss.com/terms-condition?app_version=" + prefManager.appVersion + "&device_code=" + prefManager.deviceID + "&ssid=" + POSPNO + "&fbaid=" + FBAID
                        )
                        .putExtra("NAME", "" + "Terms & Conditions")
                        .putExtra("TITLE", "" + "Terms & Conditions")


                )
            }

            txtsetting.id -> {
                trackSyncContactEvent("Sync Contacts Setting")

                startActivity(

                    (Intent(this, MyAccountActivity::class.java))

                )
            }
//            tvClickHere.id -> SyncTermPopUp()

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

    override fun onDestroy() {
        super.onDestroy()


        if (::onPageChangeListener.isInitialized) {
            viewPager.removeOnPageChangeListener(onPageChangeListener)
        }
    }

    inner class MyViewPagerAdapter(private val context: Context) :
        PagerAdapter() {

        private val layoutInflater: LayoutInflater = context.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater

        override fun instantiateItem(container: ViewGroup, position: Int): Any {
            val view = layoutInflater.inflate(layouts[position], container, false)
            container.addView(view)
            return view
        }

        override fun getCount(): Int {
            return layouts.size
        }

        override fun isViewFromObject(view: View, obj: Any): Boolean {
            return view == obj
        }

        override fun destroyItem(container: ViewGroup, position: Int, obj: Any) {
            val view = obj as View
            container.removeView(view)
        }
    }

    private fun trackSyncContactEvent(strEvent: String) {
        // Create event attributes
        val eventAttributes: Map<String, Any> = HashMap()
        // Track the login event using WebEngageHelper
        WebEngageAnalytics.getInstance().trackEvent(strEvent, eventAttributes)
    }


}