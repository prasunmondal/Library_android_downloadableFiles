package com.prasunmondal.lib.android.downloadablefile

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        Config.metadata.download(applicationContext, ::showToast)
    }

    fun showToast() {
        Toast.makeText(applicationContext, "Download Complete!", Toast.LENGTH_SHORT).show()
    }
}
