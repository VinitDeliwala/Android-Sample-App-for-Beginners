package com.example.vinit.intenetservice;

import android.app.IntentService;
import android.content.Intent;
import android.util.Log;


/**
 * Created by Vinit on 4/19/2015.
 */
public class vickyIntent extends IntentService {

    private static final String Tag = "com.example.vinit.intenetservice";
    public vickyIntent() {
        super("VickyRocks");
    }

    @Override
    protected void onHandleIntent(Intent intent) {
        Log.i(Tag,"Its working");

    }
}
