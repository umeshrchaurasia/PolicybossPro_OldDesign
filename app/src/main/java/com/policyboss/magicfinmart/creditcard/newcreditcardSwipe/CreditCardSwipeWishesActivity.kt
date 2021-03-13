package com.policyboss.magicfinmart.creditcard.newcreditcardSwipe

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.policyboss.magicfinmart.R

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
