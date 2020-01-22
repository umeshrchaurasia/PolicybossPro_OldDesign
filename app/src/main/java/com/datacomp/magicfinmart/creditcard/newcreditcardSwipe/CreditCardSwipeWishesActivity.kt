package com.datacomp.magicfinmart.creditcard.newcreditcardSwipe

import android.os.Bundle
import com.google.android.material.snackbar.Snackbar
import androidx.appcompat.app.AppCompatActivity
import com.datacomp.magicfinmart.R

import kotlinx.android.synthetic.main.activity_credit_card_swipe_wishes.*

class CreditCardSwipeWishesActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_credit_card_swipe_wishes)
        setSupportActionBar(toolbar)

        supportActionBar!!.setDisplayHomeAsUpEnabled(true)
        supportActionBar!!.setDisplayShowHomeEnabled(true)

    }

}
