package com.policyboss.policybosspro.Rate

import android.content.Context

import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity


import com.google.android.play.core.review.ReviewInfo
import com.google.android.play.core.review.ReviewManagerFactory



import com.policyboss.policybosspro.R

class RateActivity : AppCompatActivity() {
  //  private val context: Context = this

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_rate)

        val button: Button = findViewById(R.id.button)
        button.setOnClickListener {
            showfeedbackDialog()
        }

        showfeedbackDialog()

    }

    private fun showfeedbackDialog() {
        val reviewManager = ReviewManagerFactory.create(applicationContext)
        reviewManager.requestReviewFlow().addOnCompleteListener {
            if (it.isSuccessful) {
                reviewManager.launchReviewFlow(this, it.result)
            }
        }
    }



}

