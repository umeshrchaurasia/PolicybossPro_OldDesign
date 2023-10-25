package com.policyboss.policybosspro

import android.app.Dialog
import android.graphics.drawable.ColorDrawable
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.Window
import com.policyboss.policybosspro.databinding.ActivityBaseKotlinBinding
import com.policyboss.policybosspro.databinding.LayoutLoadingBinding
import com.policyboss.policybosspro.databinding.ProgressdialogLoadingBinding

open class BaseKotlinActivity : AppCompatActivity() {

    private lateinit var bindingMain : ActivityBaseKotlinBinding
    private lateinit var dialog : Dialog
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_base_kotlin)

        bindingMain = ActivityBaseKotlinBinding.inflate(layoutInflater)
        setContentView(bindingMain.root)

    }

    //region progress dialog

   open fun displayLoadingWithText(
        text: String? = "Loading...",

        cancelable: Boolean? = false,
    ) { // function -- context(parent (reference))

        var loadingLayout: ProgressdialogLoadingBinding? = null
        try {
            if (!this::dialog.isInitialized) {
                dialog = Dialog(this@BaseKotlinActivity)
                val requestWindowFeature = dialog.requestWindowFeature(Window.FEATURE_NO_TITLE)
                if (dialog.window != null) {

                    dialog.window!!.setBackgroundDrawable(ColorDrawable(0))

                }
                loadingLayout = ProgressdialogLoadingBinding.inflate(layoutInflater)
                dialog.setContentView(loadingLayout.root)
                // dialog!!.window!!.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))
                dialog.setCancelable(cancelable ?: false)

            }

            loadingLayout?.txtMessage?.text = text


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

    open fun hideLoading() {
        try {
            if (this.dialog != null) {
                dialog.dismiss()
            }
        } catch (e: Exception) {
        }
    }

    //endregion
}