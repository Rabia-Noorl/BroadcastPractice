package com.migoinnovations.broadcastpractice

import android.content.BroadcastReceiver
import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.content.Intent
import android.content.IntentFilter
import android.net.ConnectivityManager
import android.os.Build
import android.util.Log
import androidx.annotation.RequiresApi
import androidx.core.content.ContextCompat.startForegroundService
import androidx.localbroadcastmanager.content.LocalBroadcastManager
import androidx.work.PeriodicWorkRequest
import androidx.work.PeriodicWorkRequestBuilder
import androidx.work.WorkManager
import java.util.concurrent.TimeUnit


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val myReceiver = MyReceiver()

        val filter = IntentFilter(ConnectivityManager.CONNECTIVITY_ACTION).apply {
            addAction(Intent.ACTION_POWER_DISCONNECTED)
            addAction(Intent.ACTION_POWER_CONNECTED)
        }
        registerReceiver(myReceiver, filter)

//        val myFilter = IntentFilter()
//        myFilter.addAction(Intent.ACTION_AIRPLANE_MODE_CHANGED)
//        this.registerReceiver(myReceiver, myFilter)

//        val batteryStatus: Intent? = IntentFilter(Intent.ACTION_BATTERY_CHANGED).let { ifilter ->
//            this.registerReceiver(null, ifilter)
//        }

//        LocalBroadcastManager.getInstance(this)
//            .registerReceiver(br, IntentFilter(Intent.ACTION_BATTERY_OKAY))


        val intent = Intent(this, MyService::class.java)
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            applicationContext.startForegroundService(intent)
        }

        // setUpWorker()
    }

    private fun setUpWorker() {
        val workerRequest = PeriodicWorkRequest.Builder(MyWorker::class.java, 1, TimeUnit.SECONDS)
            .build()
            WorkManager.getInstance(this).enqueue(workerRequest)
    }
}