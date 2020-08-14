package com.prasunmondal.lib.android.downloadfile

import android.content.Context
import android.os.Environment
import java.io.File

class DownloadableFiles(
    private val fileServerURL: String,
    subDirectory: String, fileName: String,
    private var downloadTitle: String, private val downloadDescription: String,
    context: Context
) {
    private val rootDir = context.getExternalFilesDir(Environment.DIRECTORY_DOWNLOADS).toString()
    private var localURL: String = "$rootDir/$subDirectory/$fileName"

    fun download(context: Context, onComplete: () -> Unit) {
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
}