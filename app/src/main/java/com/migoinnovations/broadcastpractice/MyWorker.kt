package com.migoinnovations.broadcastpractice

import android.content.Context
import android.util.Log
import android.widget.Toast
import androidx.work.WorkManager
import androidx.work.Worker
import androidx.work.WorkerParameters

class MyWorker(private val context: Context, params:WorkerParameters):Worker(context,params){
    override fun doWork(): Result {
        Log.e("workerCall","From worker its working")
        return Result.success()
    }
}