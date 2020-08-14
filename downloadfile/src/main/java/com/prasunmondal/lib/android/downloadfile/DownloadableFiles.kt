package com.prasunmondal.lib.android.downloadfile

import android.content.Context
import android.os.Environment
import java.io.File

class DownloadableFiles(
    private val fileServerURL: String,
    subDirectory: String,
    fileName: String,
    private var downloadTitle: String,
    private val downloadDescription: String,
    private val onComplete: () -> Unit,
    private val context: Context
) {
    private var rootDir = context.getExternalFilesDir(Environment.DIRECTORY_DOWNLOADS).toString()
    private var localURL = "$rootDir/$subDirectory/$fileName"

    fun download() {
        DownloadUtil(context).enqueueDownload(
            context, fileServerURL, localURL,
            downloadTitle, downloadDescription,
            onComplete
        )
    }

    fun download(onComplete: () -> Unit) {
        DownloadUtil(context).enqueueDownload(
            context, fileServerURL, localURL,
            downloadTitle, downloadDescription,
            onComplete
        )
    }

    fun doesExist(): Boolean {
        val file = File(this.localURL)
        return file.exists()
    }

    fun getServerURL(): String {
        return fileServerURL
    }

    fun getLocalURL(): String {
        return localURL
    }
}