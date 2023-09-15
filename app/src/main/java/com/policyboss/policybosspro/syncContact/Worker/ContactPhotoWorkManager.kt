package com.policyboss.policybosspro.syncContact.Worker

import android.content.ContentUris
import android.content.Context
import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.net.Uri
import android.os.Environment
import android.provider.ContactsContract
import android.util.Log
import androidx.work.CoroutineWorker
import androidx.work.Data
import androidx.work.WorkerParameters
import com.policyboss.policybosspro.syncContact.Worker.model.sendPhotoUriData
import com.policyboss.policybosspro.utility.Constant
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import magicfinmart.datacomp.com.finmartserviceapi.Utility
import magicfinmart.datacomp.com.finmartserviceapi.database.DBPersistanceController
import magicfinmart.datacomp.com.finmartserviceapi.finmart.retrobuilder.RetroHelper
import okhttp3.MediaType
import okhttp3.MediaType.Companion.toMediaType
import okhttp3.MediaType.Companion.toMediaTypeOrNull
import okhttp3.MultipartBody
import okhttp3.RequestBody
import okhttp3.RequestBody.Companion.asRequestBody
import java.io.ByteArrayInputStream
import java.io.File
import java.io.FileOutputStream
import java.io.IOException
import java.io.InputStream

class ContactPhotoWorkManager(

    val context: Context, workerParameters: WorkerParameters
) : CoroutineWorker(context,workerParameters) {

    private val TAG = "Photo_LOG_CONTACT"
    override suspend fun doWork(): Result {


        return try {
            Log.d("CallLogWorker", "Run work manager")
            //Do Your task here
            withContext(Dispatchers.IO) {
                photoContactTask()
            }
            val outPutData: Data = Data.Builder()
                .putString(Constant.KEY_result, "Photo Uploaded Successfully..")
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



    private suspend fun photoContactTask(){


        val contactIdsWithPhotos = getAllContactsWithPhotos(context )


        val myData  = mutableListOf<Bitmap>()
        for (contactId in contactIdsWithPhotos) {
            val inputStream = openPhoto(context, contactId.contactId)

            //val inputStream = openDisplayPhoto(context, contactId)
            val bitmap = BitmapFactory.decodeStream(inputStream)



            if (bitmap != null) {
                // Use the bitmap for contacts with photos as needed
                Log.d("CONTACT", " Count ${bitmap?.toString()?.length ?: 0}  ")
                myData.add(bitmap)
            } else {
                // Handle the case where the contact does not have a valid display photo
                Log.d("CONTACT", " No Data  ")
            }

        }
        Log.d(TAG, " Count ${myData.toString().length}  ")
        sendPhotoUriList(photoList = myData)
    }

    fun getAllContactsWithPhotos(context: Context): List<ContactInfo> {
        val contactsWithPhotos = mutableListOf<ContactInfo>()

        val projection = arrayOf(
            ContactsContract.Contacts._ID,
            ContactsContract.Contacts.DISPLAY_NAME_PRIMARY
        )
        val selection = "${ContactsContract.Contacts.PHOTO_URI} IS NOT NULL"
        val selectionArgs = null

        context.contentResolver.query(
            ContactsContract.Contacts.CONTENT_URI,
            projection,
            selection,
            selectionArgs,
            null
        )?.use { cursor ->
            while (cursor.moveToNext()) {
                val contactId = cursor.getLong(cursor.getColumnIndexOrThrow(ContactsContract.Contacts._ID))
                val displayName = cursor.getString(cursor.getColumnIndexOrThrow(ContactsContract.Contacts.DISPLAY_NAME_PRIMARY))

                val mobileNumbers = mutableListOf<String>()

                val phoneProjection = arrayOf(
                    ContactsContract.CommonDataKinds.Phone.NUMBER
                )
                val phoneSelection = "${ContactsContract.CommonDataKinds.Phone.CONTACT_ID} = ?"
                val phoneSelectionArgs = arrayOf(contactId.toString())

                context.contentResolver.query(
                    ContactsContract.CommonDataKinds.Phone.CONTENT_URI,
                    phoneProjection,
                    phoneSelection,
                    phoneSelectionArgs,
                    null
                )?.use { phoneCursor ->
                    while (phoneCursor.moveToNext()) {
                        val phoneNumber = phoneCursor.getString(phoneCursor.getColumnIndexOrThrow(
                            ContactsContract.CommonDataKinds.Phone.NUMBER))
                        mobileNumbers.add(phoneNumber)
                    }
                }

                contactsWithPhotos.add(ContactInfo(contactId, displayName, mobileNumbers))
            }
        }

        return contactsWithPhotos
    }

    fun openPhoto(context: Context, contactId: Long): InputStream? {
        val contactUri: Uri = ContentUris.withAppendedId(ContactsContract.Contacts.CONTENT_URI, contactId)

        // Try opening the display photo
        val displayPhotoUri: Uri = Uri.withAppendedPath(contactUri, ContactsContract.Contacts.Photo.DISPLAY_PHOTO)
        try {
            // val contentResolver: ContentResolver = context.contentResolver
            val fd = context.contentResolver.openAssetFileDescriptor(displayPhotoUri, "r")
            if (fd != null) {
                return fd.createInputStream()
            }
        } catch (e: IOException) {
            // Failed to open display photo, proceed to retrieve thumbnail photo
        }

        // If display photo retrieval fails, try retrieving the thumbnail photo
        val photoUri: Uri = Uri.withAppendedPath(contactUri, ContactsContract.Contacts.Photo.CONTENT_DIRECTORY)
        val cursor = context.contentResolver.query(
            photoUri,
            arrayOf(ContactsContract.Contacts.Photo.PHOTO),
            null, null, null
        )

        cursor?.use {
            if (it.moveToFirst()) {
                val data = it.getBlob(0)
                if (data != null) {
                    return ByteArrayInputStream(data)
                }
            }
        }

        return null
    }


    private suspend fun sendPhotoUriList(photoList : MutableList<Bitmap>) {

       val dbPersistanceController = DBPersistanceController(context)
       val loginEntity = dbPersistanceController.getUserData()
        lateinit var part : MultipartBody.Part
        lateinit var body : HashMap<String,String>
        val url = "http://inv.policyboss.com/api/ncd-fba-document-upload"
        // PhotoUriData
//        photoList.forEach{ photoData ->
//
//
//        }

        val photoData = photoList.first()

        withContext(Dispatchers.IO) {




            var file =bitmapToFile(context,photoData!!)
            //  Log.d(Constant.TAG_SAVING_CONTACT_LOG, "Count${bitmap?.toString() ?: ""} ")


                part = Utility.getMultipartImage(file)
                body = Utility.getBody(
                    context,
                    loginEntity.getFBAId(),
                    1,
                    "FBAPhotograph",
                    loginEntity.getPOSPNo(),
                    "",
                    "DeviceID"
                )
//                RegisterController(context).uploadDocuments(
//                    part,
//                    body,
//                    null
//                )


                file?.let {

                   // part  = getMultipartImage(it)
                   // body = getMultiPartBody()

                   // Log.d(Constant.TAG_SAVING_CONTACT_LOG, "Count${part.toString().length } ")

                    try {
                        val resultResp = RetroHelper.api.uploadContactsPhotoDoc(
                            //url =  url,
                            doc = part,
                            partMap =  body)



                        if(resultResp?.isSuccessful?: false){

                            Log.d(Constant.TAG_SAVING_CONTACT_LOG,"DOC UPLOADED Done")
                        }else{
                            Log.d(Constant.TAG_SAVING_CONTACT_LOG,"Failiure")
                        }
                    }catch (ex : Exception){
                        Log.d(Constant.TAG_SAVING_CONTACT_LOG,"DOC UPLOADED ERROR" + ex.message)
                    }


                    // val resultResp = RetroHelper.api.saveCallLog(url, callLogRequestEntity)
                }



        }
    }
    private suspend fun sendPhotoUriList1(photoList : MutableList<sendPhotoUriData>) {

//        lateinit var part : MultipartBody.Part
//        lateinit var body : HashMap<String,String>
//        val url = "http://inv.policyboss.com/api/ncd-fba-document-upload"
//        // PhotoUriData
//        photoList.forEach{ photoData ->
//
//            withContext(Dispatchers.IO) {
//
//
//                 var file =bitmapToFile(context,bitmap!!)
//              //  Log.d(Constant.TAG_SAVING_CONTACT_LOG, "Count${bitmap?.toString() ?: ""} ")
//
//
//
//                file?.let {
//
//                    part  = getMultipartImage(it)
//                    body = getMultiPartBody()
//
//                    Log.d(Constant.TAG_SAVING_CONTACT_LOG, "Count${part.toString().length } ")
//
//                    val resultResp = RetroHelper.api.uploadContactsPhotoDoc(
//                        url =  url,
//                        doc = part,
//                        partMap =  body)
//
//
//
//                    if(resultResp?.isSuccessful?: false){
//
//                       Log.d(Constant.TAG_SAVING_CONTACT_LOG,"Done")
//                    }else{
//                        Log.d(Constant.TAG_SAVING_CONTACT_LOG,"Failiure")
//                    }
//
//                   // val resultResp = RetroHelper.api.saveCallLog(url, callLogRequestEntity)
//                }
//
//
//
//            }
//        }


    }

    private  fun getMultiPartBody() : HashMap<String, String> {

        val body = hashMapOf<String, String>()
//+ (0..1000).random()
        body["guid"] = "12345"
        body["DocType"] = "jpg"

        return body
    }

    fun getMultipartImage(file: File): MultipartBody.Part {
//        val imgBody: RequestBody = file.asRequestBody("image/*".toMediaTypeOrNull())
//        val imgFile: MultipartBody.Part =
//            MultipartBody.Part.createFormData("DocFile", file.name, imgBody)
//        return imgFile



        val imgBody: RequestBody = RequestBody.create("image/*".toMediaType(), file)
        val imgFile: MultipartBody.Part = MultipartBody.Part.createFormData("DocFile", file.name, imgBody)
        return imgFile
    }


    fun bitmapToFile(context: Context, bitmap: Bitmap): File? {
        val cacheDir = context.getExternalFilesDir(Environment.DIRECTORY_PICTURES)

        val fileName = System.currentTimeMillis().toString()
        val imageFile = File(cacheDir, fileName)

        return try {
            val fileOutputStream = FileOutputStream(imageFile)
            bitmap.compress(Bitmap.CompressFormat.JPEG, 100, fileOutputStream)
            fileOutputStream.flush()
            fileOutputStream.close()
            imageFile
        } catch (e: IOException) {
            e.printStackTrace()
            null
        }
    }

}

data class ContactInfo(
    val contactId: Long,
    val displayName: String,
    val mobileNumbers: List<String>
)