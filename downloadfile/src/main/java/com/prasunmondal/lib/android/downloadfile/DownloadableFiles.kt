package com.prasunmondal.lib.android.downloadfile

import android.content.Context
import android.os.Environment
import java.io.File

class DownloadableFiles(
    private val fileServerURL: String,
    private val subDirectory: String,
    private val fileName: String,
    private var downloadTitle: String,
    private val downloadDescription: String,
    private val onComplete: () -> Unit
) {
    private var rootDir = ""
    private var localURL = ""

    private fun formLocalURLs(context: Context, subDirectory: String, fileName: String) {
        if(localURL.isEmpty()) {
            println("Setting Directories ----------------------")
            rootDir = context.getExternalFilesDir(Environment.DIRECTORY_DOWNLOADS).toString()
            localURL = "$rootDir/$subDirectory/$fileName"
        }
    }

    fun download(context: Context) {
        formLocalURLs(context, subDirectory, fileName)
        DownloadUtil(context).enqueueDownload(
            context, fileServerURL, localURL,
            downloadTitle, downloadDescription,
            onComplete
        )
    }

    fun download(context: Context, onComplete: () -> Unit) {
        formLocalURLs(context, subDirectory, fileName)
        DownloadUtil(context).enqueueDownload(
            context, fileServerURL, localURL,
            downloadTitle, downloadDescription,
            onComplete
        )
    }

    fun doesExist(context: Context): Boolean {
        formLocalURLs(context, subDirectory, fileName)
        val file = File(this.localURL)
        return file.exists()
    }

    fun getServerURL(context: Context): String {
        formLocalURLs(context, subDirectory, fileName)
        return fileServerURL
    }

    fun getLocalURL(context: Context): String {
        formLocalURLs(context, subDirectory, fileName)
        return localURL
    }
}