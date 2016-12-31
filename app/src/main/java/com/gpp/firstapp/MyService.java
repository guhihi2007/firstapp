package com.gpp.firstapp;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.support.annotation.Nullable;

/**
 * Created by Administrator on 2016/12/29.
 */

public class MyService extends Service {

    public static final String TAG="my_service";

    public void onCreate(){
        super.onCreate();
    }
    public int onStartCommand(Intent intent,int flag,int startId){
            return super.onStartCommand(intent,flag,startId);
    }
    public void onDestory(){
        super.onDestroy();
    }






    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }
}
