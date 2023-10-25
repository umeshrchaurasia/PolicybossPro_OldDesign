package com.policyboss.policybosspro

import android.content.Context
import android.view.View
import android.view.inputmethod.InputMethodManager
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.snackbar.Snackbar

import java.math.RoundingMode
import java.net.Inet4Address
import java.net.NetworkInterface
import java.net.SocketException
import java.text.DecimalFormat
import java.util.*



/**************** For Alert *********************************************/
fun Context.showAlert(msg: String) {

    Toast.makeText(this,msg, Toast.LENGTH_SHORT).show()
}

fun Context.showSnackbar(view: View, msg: String?) {
    Snackbar.make(view, msg ?: "Something went wrong", Snackbar.LENGTH_SHORT).show()
}

fun Context.hideKeyboard(view: View) {
    val imm = this.getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
    imm.hideSoftInputFromWindow(view.windowToken, 0)
}

 fun Context.twoDecimalFormat(value: Double): String {
    val df = DecimalFormat("#.##")
    df.roundingMode = RoundingMode.DOWN
    return df.format(value)
}

fun Context.showKeyboard(etOtp: EditText) {
    etOtp.requestFocus()
    val inputMethodManager: InputMethodManager =
        this.getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
    inputMethodManager.showSoftInput(etOtp, InputMethodManager.SHOW_IMPLICIT)
}

fun Context.showKeyboard(view: View) {
    val inputMethodManager =
        getSystemService(AppCompatActivity.INPUT_METHOD_SERVICE) as InputMethodManager
    inputMethodManager.showSoftInput(view, InputMethodManager.SHOW_IMPLICIT)

}

fun Context.getLocalIpAddress(): String? {
    try {
        val en = NetworkInterface.getNetworkInterfaces()
        while (en.hasMoreElements()) {
            val enumIpAddress = en.nextElement().inetAddresses
            while (enumIpAddress.hasMoreElements()) {
                val inetAddress = enumIpAddress.nextElement()
                if (!inetAddress.isLoopbackAddress && inetAddress is Inet4Address) {
                    return inetAddress.hostAddress
                }
            }
        }
    } catch (ex: SocketException) {
        ex.printStackTrace()
    }
    return null
}

fun Context.getUniqueID(): String = UUID.randomUUID().toString()



