package com.prasunmondal.lib.android.downloadablefile

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val metadata = DownloadableFiles(
            applicationContext,
            "",
            "metadata.csv",
            "https://docs.google.com/spreadsheets/d/e/2PACX-1vRZQ28x7jpdIOzT2PA6iTCTcyTHM9tVPkv2ezuqd4LFOWu9SJqImGM7ML8ejdQB01SdjfTZnoHogzUt/pub?gid=1321322233&single=true&output=csv",
            "E203",
            "fetching metadata", {}
        )

        metadata.download()
    }

    fun showToast() {
        Toast.makeText(applicationContext, "Download Complete!", Toast.LENGTH_SHORT).show()
    }
}
