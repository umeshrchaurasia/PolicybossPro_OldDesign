package com.utility.finmartcontact.home.Worker

import android.app.NotificationManager
import android.content.ContentResolver
import android.content.Context
import android.database.Cursor
import android.net.Uri
import android.provider.ContactsContract
import android.util.Log
import androidx.work.CoroutineWorker
import androidx.work.Data
import androidx.work.WorkerParameters
import com.policyboss.policybosspro.syncContact.Worker.ContactHelper

import com.policyboss.policybosspro.utility.Constant
import com.utility.finmartcontact.core.model.ContactlistEntity
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext


/**
 * Created by Rahul on 10/06/2022.
 */
class ContactLog1WorkManager(
   val context: Context, workerParameters: WorkerParameters,

    ) : CoroutineWorker(context, workerParameters) {

    private val TAG = "CALL_LOG_CONTACT"
    private val notificationManager =
        context.getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager


    override suspend fun doWork(): Result {
        return try {
            Log.d("CallLogWorker", "Run work manager")
            //Do Your task here

           var ContactCount = callContactTask()


            // Log.d("CallLogWorker", callLogList.toString())
            val outPutData: Data = Data.Builder()
                .putString(Constant.KEY_result, "${ContactCount}")
                .build()
            Result.success(outPutData)
        }
        catch (e: Exception) {
            Log.d(TAG, "exception in doWork1 ${e.message}")
            val errorData: Data = Data.Builder()
                .putString(Constant.KEY_error_result, "Data Not Uploaded.Please Try Again.")
                .build()
            Result.failure(errorData)

        }

    }

    private suspend fun callContactTask() : Int {

        var ContactCount = 0

        //region Comment : Not In Used
     //   var strbody = "Contact is Uploading Please wait.."
     //   var strResultbody = "Successfully Uploaded.."
      //  setForeground(createForegroundInfo(0, 0, strbody))

        //endregion


        // region getting Input Data
        val fbaid = inputData.getInt(Constant.KEY_fbaid, 0)
        val ssid = inputData.getString(Constant.KEY_ssid)
        val parentid = inputData.getString(Constant.KEY_parentid)
        val deviceID = inputData.getString(Constant.KEY_deviceid) ?: ""

        var tfbaid = ""
        var tsub_fba_id = ""
       // var getAllContactDetails : MutableList<Contact> = ArrayList()
        var getAllContactDetails = ArrayList<String>()

        if (parentid.isNullOrEmpty() || parentid.equals("0")) {

            tfbaid = fbaid.toString()
            tsub_fba_id = parentid.toString()

        } else {
            tfbaid = parentid.toString()
            tsub_fba_id = fbaid.toString()
        }

        //endregion
      //  delay(2000)

        withContext(Dispatchers.IO) {

            var url =  "https://horizon.policyboss.com:5443/sync_contacts" + "/contact_entry"

           // refreshData()
            var contactlist = getContactList()

            ContactCount = contactlist.size



            var subcontactlist: List<ContactlistEntity>

            if (contactlist != null && contactlist!!.size > 0) {

                try{
                   // getAllContactDetails = getQuery().find()

                    ContactHelper.getContact(context.applicationContext)

//                    var contactDetails =   ContactHelper.getContactDetails(context.applicationContext)
//
//                    Log.d(TAG, "\n\nCONTACT DETAILS ID: ${contactDetails.contactId} email: ${contactDetails.emailList}  Phone: ${contactDetails.phoneList} Address: ${contactDetails.addressList}" +
//                            " company: ${contactDetails.company}   address: ${contactDetails.addressList}   "
//
//                    )

                }catch (ex :Exception ){

                    Log.d("Error" , ex.message.toString())
                }



                for (i in 0..contactlist!!.size - 1 step 1000) {

                    Log.d(TAG, "CallLog Number of data jumped ${i}")

                    subcontactlist = contactlist!!.filter { it.id > i && it.id <= (1000 + i) }


                    /*
                      // region calling to server


                    val contactRequestEntity = ContactLeadRequestEntity(
                        fbaid = tfbaid,
                        ssid = ssid!!,
                        sub_fba_id = tsub_fba_id,
                        contactlist = subcontactlist,
                        raw_data = Gson().toJson(getAllContactDetails),
                        device_id = deviceID
                    )


                    Log.d(Constant.TAG_SAVING_CONTACT_LOG,Gson().toJson(getAllContactDetails) )

                        val resultResp = RetroHelper.api.saveContactLead(url, contactRequestEntity)


                        if (resultResp.isSuccessful) {



                           // delay(8000)

                        }else{

                            Log.d(TAG, resultResp.toString())
                        }


                        //endregion

                     */


                }

            }

        }

        return ContactCount
    }



    private  fun getContactList(): MutableList<ContactlistEntity> {

        var contactlist: MutableList<ContactlistEntity> = ArrayList<ContactlistEntity>()
        var templist: MutableList<String> = ArrayList<String>()
        var phones: Cursor? = null


        val PROJECTION = arrayOf(
            ContactsContract.Data._ID,
            ContactsContract.RawContacts._ID,
            ContactsContract.Data.RAW_CONTACT_ID,
            ContactsContract.Contacts._ID,
            ContactsContract.Contacts.DISPLAY_NAME,
            ContactsContract.CommonDataKinds.Phone.PHOTO_URI,
            ContactsContract.CommonDataKinds.Phone.NUMBER,

            ContactsContract.CommonDataKinds.Email.ADDRESS,
             ContactsContract.Data.MIMETYPE,
            ContactsContract.Data.DATA1
        )

        val uri = ContactsContract.CommonDataKinds.Phone.CONTENT_URI
        val filter =
            "" + ContactsContract.Contacts.HAS_PHONE_NUMBER + " > 0 and " + ContactsContract.CommonDataKinds.Phone.TYPE + "=" + ContactsContract.CommonDataKinds.Phone.TYPE_MOBILE
        val order =
            ContactsContract.Contacts.DISPLAY_NAME + " ASC"// LIMIT " + limit + " offset " + lastId + "";

        phones = applicationContext.contentResolver.query(uri, PROJECTION, filter, null, order)




        ///////////////////////////


        val regex = Regex("[^.0-9]")

        phones.let {

            if (phones != null && phones!!.getCount() > 0) {
                try {
                    var i = 1
                    while (phones.moveToNext()) {




                        val id: String? =
                            phones.getString(phones.getColumnIndexOrThrow(ContactsContract.Data._ID))
//                        val id: String ? =
//                            phones.getString(phones.getColumnIndexOrThrow(ContactsContract.Contacts._ID))


//                       var contactDetails = ContactHelper.getContactDetails(context.applicationContext, id?: "0")
//
//                        Log.d(TAG, "\nCONTACT DETAILS ID: ${contactDetails.contactId} email: ${contactDetails.emailList}  Phone: ${contactDetails.phoneList} Address: ${contactDetails.addressList} company: ${contactDetails.company}     "
//
//                        )
                        var name =
                            "" + phones.getString(
                                phones.getColumnIndex(ContactsContract.Contacts.DISPLAY_NAME) ?: 0
                            )
                        var phoneNumber =
                            "" + phones.getString(
                                phones.getColumnIndex(ContactsContract.CommonDataKinds.Phone.NUMBER)
                                    ?: 0
                            )





                         // getEmailAddress(contentResolver = applicationContext.contentResolver , contactId = id ?: "0" )

                          //  getPhoneNumbers(contentResolver = applicationContext.contentResolver , contactId = id ?: "0" )


                        phoneNumber = regex.replace(phoneNumber, "") // works
                        //.replace("\\s".toRegex(), "")

                        if (phoneNumber.length >= 10) {

                            phoneNumber = phoneNumber.takeLast(10)
                            // check whether the number alreday added to list or not

                            if (!templist!!.contains(phoneNumber)) {
                                templist?.add(phoneNumber)

                                val selectUser = ContactlistEntity(
                                    name = name,
                                    mobileno = phoneNumber,
                                    id = i
                                )
                               // Log.i(TAG, "Key ID: " + i + " Name: " + name + " Mobile: " + phoneNumber + "\n");
                                contactlist.add(selectUser)

                            }


                        }


                    }
                } catch (e: InterruptedException) {
                    e.printStackTrace()
                } catch (e: Exception) {
                    e.printStackTrace()
                }

            }
        }



        return contactlist


    }


    fun getEmailAddress(contentResolver: ContentResolver, contactId: String = "0"): String? {

        // Set up the query to retrieve the email address
        val emailUri: Uri = ContactsContract.CommonDataKinds.Email.CONTENT_URI
        val projection = arrayOf(ContactsContract.CommonDataKinds.Email.ADDRESS)
        val selection = ContactsContract.CommonDataKinds.Email.CONTACT_ID + " = ?"
        val selectionArgs = arrayOf(contactId)

        // Execute the query
        val cursor = contentResolver.query(emailUri, projection, selection, selectionArgs, null)

        // Retrieve the email address from the query results
        var emailAddress: String? = null
        if (cursor != null && cursor.moveToFirst()) {
            val columnIndex = cursor.getColumnIndex(ContactsContract.CommonDataKinds.Email.ADDRESS)
            emailAddress = cursor.getString(columnIndex)
            Log.d(TAG, "EMAIL func :- " + emailAddress)
            cursor.close()
        }
        return emailAddress
    }

    fun getPhoneNumbers(contentResolver: ContentResolver, contactId: String): List<String>? {

        // Set up the query to retrieve the phone numbers
        val phoneUri = ContactsContract.CommonDataKinds.Phone.CONTENT_URI
        val projection = arrayOf(ContactsContract.CommonDataKinds.Phone.NUMBER)
        val selection = ContactsContract.CommonDataKinds.Phone.CONTACT_ID + " = ?"
        val selectionArgs = arrayOf(contactId)

        // Execute the query
        val cursor = contentResolver.query(phoneUri, projection, selection, selectionArgs, null)

        // Retrieve the phone numbers from the query results
        val phoneNumbers: MutableList<String> = ArrayList()
        if (cursor != null && cursor.moveToFirst()) {
            do {
                val columnIndex =
                    cursor.getColumnIndex(ContactsContract.CommonDataKinds.Phone.NUMBER)
                val phoneNumber = cursor.getString(columnIndex)
                phoneNumbers.add(phoneNumber)
            } while (cursor.moveToNext())
            cursor.close()

            Log.d(TAG, "Phone func :- " + phoneNumbers.first() +" " + phoneNumbers.last())
        }


        return phoneNumbers
    }


}