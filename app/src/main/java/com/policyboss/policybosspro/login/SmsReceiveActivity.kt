package com.policyboss.policybosspro.login

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.policyboss.policybosspro.R

import android.content.IntentFilter

import android.util.Log
import android.widget.Toast

import com.google.android.gms.auth.api.phone.SmsRetriever

import java.util.regex.Pattern




class SmsReceiveActivity : AppCompatActivity() {

    private var intentFilter: IntentFilter? = null
    private var smsReceiver: SMSReceiver? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sms_receive)

        // Init Sms Retriever >>>>
        initSmsListener()
        initBroadCast()
    }

    private fun initBroadCast() {
        intentFilter = IntentFilter(SmsRetriever.SMS_RETRIEVED_ACTION)
        smsReceiver = SMSReceiver()
        smsReceiver?.setOTPListener(object : SMSReceiver.OTPReceiveListener {
            override fun onOTPReceived(otp: String?) {
                showToast("OTP Received: $otp")
            }
        })
    }


    private fun initSmsListener() {
        val client = SmsRetriever.getClient(this)
        client.startSmsRetriever()
    }


    override fun onResume() {
        super.onResume()
        registerReceiver(smsReceiver, intentFilter)
    }

    override fun onPause() {
        super.onPause()
        unregisterReceiver(smsReceiver)
    }


    override fun onDestroy() {
        super.onDestroy()
        smsReceiver = null
    }

    private fun showToast(msg: String?) {
        Toast.makeText(this, msg, Toast.LENGTH_SHORT).show()
    }
}