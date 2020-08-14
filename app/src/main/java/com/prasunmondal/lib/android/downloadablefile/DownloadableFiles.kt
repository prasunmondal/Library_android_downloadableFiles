package com.prasunmondal.lib.android.downloadablefile

import android.content.Context
import android.os.Environment
import java.io.File

class DownloadableFiles(
    context: Context,
    private val serverURL: String,
    childDir: String, fileName: String,
    private var downloadTitle: String, private val downloadDescription: String
) {
    private val rootDir = context.getExternalFilesDir(Environment.DIRECTORY_DOWNLOADS).toString()
    private var localURL: String = "$rootDir/$childDir/$fileName"

    fun download(context: Context, onComplete: () -> Unit) {
        DownloadUtil(context).enqueueDownload(
            context, serverURL, localURL,
            downloadTitle, downloadDescription,
            onComplete
        )
    }

    fun doesExist(): Boolean {
        val file = File(this.localURL)
        return file.exists()
    }
}