package com.policyboss.policybosspro.utility

import android.content.Context
import android.net.Uri
import android.provider.MediaStore
import android.provider.OpenableColumns
import android.util.Log
import java.io.File
import java.io.FileOutputStream

object UTILITY {



        @JvmStatic
        fun getFilePath(context: Context, contentUri: Uri): String? {
            try {
                val filePathColumn = arrayOf(
                    MediaStore.Files.FileColumns._ID,
                    MediaStore.Files.FileColumns.TITLE,
                    MediaStore.Files.FileColumns.SIZE,
                    MediaStore.Files.FileColumns.DATE_ADDED,
                    MediaStore.Files.FileColumns.DISPLAY_NAME,
                )

                val returnCursor = contentUri.let { context.contentResolver.query(it, filePathColumn, null, null, null) }

                if (returnCursor != null) {

                    returnCursor.moveToFirst()
                    val nameIndex = returnCursor.getColumnIndexOrThrow(OpenableColumns.DISPLAY_NAME)
                    val name = returnCursor.getString(nameIndex)
                    val file = File(context.cacheDir, name)
                    val inputStream = context.contentResolver.openInputStream(contentUri)
                    val outputStream = FileOutputStream(file)
                    var read: Int
                    val maxBufferSize = 1 * 1024 * 1024
                    val bytesAvailable = inputStream!!.available()

                    val bufferSize = Math.min(bytesAvailable, maxBufferSize)
                    val buffers = ByteArray(bufferSize)

                    while (inputStream.read(buffers).also { read = it } != -1) {
                        outputStream.write(buffers, 0, read)
                    }

                    inputStream.close()
                    outputStream.close()
                    return file.absolutePath
                }
                else
                {
                    Log.d("","returnCursor is null")
                    return null
                }
            }
            catch (e: Exception) {
                Log.d("","exception caught at getFilePath(): $e")
                return null
            }
        }

       @JvmStatic
       fun isFileLessThan5MB(file: File): Boolean {
        val maxFileSize = 5 * 1024 * 1024
        val l = file.length()
        val fileSize = l.toString()
        val finalFileSize = fileSize.toInt()
        return finalFileSize >= maxFileSize
    }

}

