package com.policyboss.policybosspro.scanqrcode

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import com.google.zxing.Result
import com.policyboss.policybosspro.BaseActivity
import com.policyboss.policybosspro.R
import com.policyboss.policybosspro.databinding.ActivityScanqrBinding
import me.dm7.barcodescanner.zxing.ZXingScannerView

class scanActivity : BaseActivity(), View.OnClickListener, ZXingScannerView.ResultHandler {


    lateinit var binding: ActivityScanqrBinding
    lateinit var btn_scan: Button
    lateinit var url: String

    var contentFrame: ViewGroup? = null
    private  var mScannerView: ZXingScannerView? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding  = ActivityScanqrBinding.inflate(layoutInflater)

        setContentView(binding.root)

        contentFrame = binding.contentFrame
   //    val hasFlash= packageManager.hasSystemFeature(PackageManager.FEATURE_CAMERA_FLASH)
        url = intent.getStringExtra("url").toString()

        btn_scan = binding.btnScan
        btn_scan.setOnClickListener(this)
    }

    override fun onClick(view: View?) {
        when (view!!.getId()) {
            R.id.btn_scan -> {
                QrScanner()
            }
        }
    }

    override fun handleResult(rawResult: Result?) {
        Log.d("TAG_SCANNER",  "Barcode scan result " + rawResult!!.text)

        val i = Intent()
        System.out.println("ScanActivity=" + rawResult!!.text)
        i.putExtra("data", rawResult!!.text)
        setResult(RESULT_OK, i)
        var data_value=  rawResult!!.text


       // showDialog( data_value,scanActivity::class.java)

        // ConfirmMoreServiceAlert();
        //  startActivity(new Intent(HomeActivity.this, scanActivity.class));
//        startActivity(
//            Intent(this@scanActivity, CommonWebViewActivity::class.java).putExtra(
//                "URL",
//                        url,
//            ).putExtra("NAME", "Scan").putExtra("TITLE", "Scan")
//        )


      //  finish()

    }
    override fun onResume() {
        super.onResume()
        QrScanner()
    }

    override fun onPause() {
        super.onPause()
         mScannerView?.stopCamera()           // Stop camera on pause
    }

    override fun onBackPressed() {

        super.onBackPressed()
        setResult(0);
        finish();
    }

    fun QrScanner() {
        mScannerView = ZXingScannerView(this) // Programmatically initialize the scanner view
        contentFrame?.addView(mScannerView)
        //setContentView(mScannerView);
        mScannerView?.setResultHandler(this) // Register ourselves as a handler for scan results.
        mScannerView?.startCamera() // Start camera
    }
}