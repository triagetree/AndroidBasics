package com.example.pc.loginapp.viewmodel.sqlite;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

import com.example.pc.loginapp.viewmodel.sqlite.MyNewIntentService;

/**
 * Created by Pc on 07-08-2018.
 */

public class MyReceiver extends BroadcastReceiver{
    public MyReceiver(){

    }

    @Override
    public void onReceive(Context context, Intent intent){

        Intent intent1=new Intent(context,MyNewIntentService.class);
        context.startService(intent1);
    }
}
