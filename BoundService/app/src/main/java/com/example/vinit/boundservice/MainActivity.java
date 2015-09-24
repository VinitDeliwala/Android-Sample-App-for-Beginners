package com.example.vinit.boundservice;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;
import android.os.IBinder;
import android.content.Context;
import android.content.Intent;
import android.content.ComponentName;
import android.content.ServiceConnection;
import com.example.vinit.boundservice.MyService.MyLocalBinder;



public class MainActivity extends ActionBarActivity {

    MyService ms1;
    boolean isBound=false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Intent i = new Intent(this,MyService.class);
        bindService(i,sc1,Context.BIND_AUTO_CREATE);
    }
    public void showTime(View view){
        String CurrentTime=ms1.getCurrentTime();
        TextView t1 = (TextView) findViewById(R.id.t1);
        t1.setText(CurrentTime);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
    private ServiceConnection sc1 = new ServiceConnection() {
        @Override
        public void onServiceConnected(ComponentName name, IBinder service) {
            MyLocalBinder binder =(MyLocalBinder) service;
            ms1 = binder.getService();
            isBound=true;

        }

        @Override
        public void onServiceDisconnected(ComponentName name) {
            isBound=false;

        }
    };
}
