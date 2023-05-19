/*
* Copyright 2017 The Android Open Source Project
*
* Licensed under the Apache License, Version 2.0 (the "License");
* you may not use this file except in compliance with the License.
* You may obtain a copy of the License at
*
*     http://www.apache.org/licenses/LICENSE-2.0
*
* Unless required by applicable law or agreed to in writing, software
* distributed under the License is distributed on an "AS IS" BASIS,
* WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
* See the License for the specific language governing permissions and
* limitations under the License.
*/

package com.example.policybosscaller.Utility

import android.app.Dialog
import android.content.Context
import android.content.DialogInterface
import android.graphics.drawable.ColorDrawable
import android.view.LayoutInflater
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AlertDialog

import com.google.android.material.snackbar.Snackbar


/**************** For Snackbar *********************************************/
fun View.showSnackbar(msgId: Int, length: Int) {
    showSnackbar(context.getString(msgId), length)
}

fun View.showSnackbar(view: View,msg: String) {

    Snackbar.make(view, msg, Snackbar.LENGTH_SHORT).show()
}


//fun View.showSnackbar(msg: String, length: Int) {
//    showSnackbar(msg, length, null, {})
//}

fun View.showSnackbar(message: String, duration: Int = Snackbar.LENGTH_SHORT) {
    Snackbar.make(this, message, duration).show()
}

fun View.showSnackbar(
        msgId: Int,
        length: Int,
        actionMessageId: Int,
        action: (View) -> Unit
) {
    showSnackbar(context.getString(msgId), length, context.getString(actionMessageId), action)
}

fun View.showSnackbar(
        msg: String,
        length: Int,
        actionMessage: CharSequence?,
        action: (View) -> Unit
) {
    val snackbar = Snackbar.make(this, msg, length)
    if (actionMessage != null) {
        snackbar.setAction(actionMessage) {
            action(this)
        }.show()
    }
}

/**************** For AlertDialog with Action *********************************************/

 fun View.toast(context: Context ,text: String) = Toast.makeText( context, text, Toast.LENGTH_SHORT).show()

fun basicAlert(view: View){

    val builder = AlertDialog.Builder(view.context)

//    with(builder)
//    {
//        setTitle("Androidly Alert")
//        setMessage("We have a message")
//        setPositiveButton("OK", DialogInterface.OnClickListener(function = positiveButtonClick))
//        setNegativeButton(android.R.string.no, negativeButtonClick)
//        setNeutralButton("Maybe", neutralButtonClick)
//        show()
//    }


}
