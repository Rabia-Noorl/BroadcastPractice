package com.migoinnovations.broadcastpractice

import android.app.Service
import android.content.Intent
import android.os.IBinder
import android.util.Log
import android.widget.Toast
import java.security.Provider

public class MyService: Service() {

    override fun onCreate() {
        Thread {
            while (true) {
                Log.e("Service", "Service is running...")
                try {
                    Thread.sleep(1000)
                } catch (e: InterruptedException) {
                    e.printStackTrace()
                }
            }
        }.start()
        super.onCreate()
    }


//    override fun onStartCommand(intent: Intent?, flags: Int, startId: Int): Int {
//        Thread {
//            while (true) {
//                Log.e("Service", "Service is running...")
//                try {
//                    Thread.sleep(1000)
//                } catch (e: InterruptedException) {
//                    e.printStackTrace()
//                }
//            }
//        }.start()
//
//        return super.onStartCommand(intent, flags, startId)
//    }

    override fun onBind(p0: Intent?): IBinder? {
        TODO("Not yet implemented")
    }
}