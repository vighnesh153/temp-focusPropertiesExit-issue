package com.example.tvtestviewscompose

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.util.Log

class MyBroadcastReceiver : BroadcastReceiver() {
    override fun onReceive(context: Context?, intent: Intent) {
        Log.d(TAG, "onReceive: intent.action=${intent.action}")
        Log.d(TAG, "onReceive: intent.extras=${intent.extras}")
        Log.d(TAG, "onReceive: intent.extras=${intent.extras}")
    }
}

object Intents {
    const val PUBLISH_CONTINUATION = "com.example.tvtestviewscompose.publish.continuation"
}