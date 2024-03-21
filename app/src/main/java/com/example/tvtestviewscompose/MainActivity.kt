package com.example.tvtestviewscompose

import android.content.Context
import android.content.IntentFilter
import android.os.Build
import android.os.Bundle
import android.util.Log
import androidx.annotation.RequiresApi
import androidx.fragment.app.FragmentActivity

/**
 * Loads [MainFragment].
 */
class MainActivity : FragmentActivity() {

    private lateinit var myBroadcastReceiver: MyBroadcastReceiver

    @RequiresApi(Build.VERSION_CODES.O)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        Log.d(TAG, "onCreate: Starting app...")

        val intentFilter = IntentFilter()
        intentFilter.addAction(Intents.PUBLISH_CONTINUATION)

        myBroadcastReceiver = MyBroadcastReceiver()
    }
}