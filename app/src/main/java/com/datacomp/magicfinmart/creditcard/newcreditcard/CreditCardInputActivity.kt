package com.datacomp.magicfinmart.creditcard.newcreditcard

import android.os.Bundle

import android.support.v7.app.AppCompatActivity
import com.datacomp.magicfinmart.BaseActivity
import com.datacomp.magicfinmart.R

import kotlinx.android.synthetic.main.activity_credit_card_input.*

class CreditCardInputActivity : BaseActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_credit_card_input)
        setSupportActionBar(toolbar)


    }

}
