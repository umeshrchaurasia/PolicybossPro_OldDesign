package com.policyboss.policybosspro.creditcard.newcreditcard

import android.os.Bundle

import com.policyboss.policybosspro.BaseActivity
import com.policyboss.policybosspro.R

import kotlinx.android.synthetic.main.activity_credit_card_input.*

class CreditCardInputActivity : BaseActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_credit_card_input)
        setSupportActionBar(toolbar)


    }

}
