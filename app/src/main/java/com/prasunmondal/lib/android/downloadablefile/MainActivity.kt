package com.prasunmondal.lib.android.downloadablefile

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.prasunmondal.lib.android.downloadfile.DownloadableFiles

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val metadata = DownloadableFiles(
            applicationContext,
            "https://docs.google.com/spreadsheets/d/e/2PACX-1vRZQ28x7jpdIOzT2PA6iTCTcyTHM9tVPkv2ezuqd4LFOWu9SJqImGM7ML8ejdQB01SdjfTZnoHogzUt/pub?gid=1321322233&single=true&output=csv",
            "",
            "metadata.csv",
            "E203",
            "fetching metadata"
        )

        metadata.download(applicationContext, {})
    }
}
