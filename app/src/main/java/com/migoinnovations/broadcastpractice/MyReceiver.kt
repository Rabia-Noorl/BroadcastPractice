package com.migoinnovations.broadcastpractice

import android.content.BroadcastReceiver
import android.content.Context
import android.widget.Toast

import android.content.Intent
import android.content.Intent.ACTION_POWER_DISCONNECTED
import android.util.Log

public class MyReceiver : BroadcastReceiver() {
    override fun onReceive(context: Context?, intent: Intent) {

        val action =  intent?.action
        when(action){
            Intent.ACTION_POWER_DISCONNECTED ->{
                Toast.makeText(context, "From broadcast its DISCONNECTED", Toast.LENGTH_SHORT).show()
            }
            Intent.ACTION_POWER_CONNECTED ->{
                Toast.makeText(context, "From broadcast its CONNECTED", Toast.LENGTH_SHORT).show()

            }
        }
    }
}