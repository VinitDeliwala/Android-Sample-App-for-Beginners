package com.example.vinit.intenetservice;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.util.Log;

public class MyService extends Service {
    private static final String Tag = "com.example.vinit.intenetservice";

    public MyService() {
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        Log.i(Tag,"On Start Called");
        Runnable r = new Runnable() {
            @Override
            public void run() {
                for (int i=0;i<5;i++){
                    long futureTime= System.currentTimeMillis()+5000;
                    while(System.currentTimeMillis()<futureTime){
                        synchronized (this){
                            try{
                                wait(futureTime-System.currentTimeMillis());
                            }catch (Exception e){}
                        }
                    }
                }

            }
        };
        Thread th1 = new Thread(r);
        th1.start();
        return Service.START_STICKY;
    }

    @Override
    public void onDestroy() {
        Log.i(Tag,"On Destroy Called");
    }

    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }
}
