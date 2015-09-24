package com.example.vinit.bluetooth1;

import android.bluetooth.BluetoothAdapter;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Environment;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;
import java.io.File;
import java.io.InputStream;
import java.util.List;


public class MainActivity extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    private static final int DISCOVER_DURATION=300;
    private static final int REQUEST_BLU=1;

    public void sendViaBluetooth(View v) {
        BluetoothAdapter btAdapter = BluetoothAdapter.getDefaultAdapter();
        if (btAdapter == null) {
            Toast.makeText(this, "Bluetooth is not supported on this device", Toast.LENGTH_LONG).show();
        } else {
            enableBluetooth();
        }
    }

    public void enableBluetooth() {
        Intent discoveryIntent = new Intent(BluetoothAdapter.ACTION_REQUEST_ENABLE);
        discoveryIntent.putExtra(BluetoothAdapter.EXTRA_DISCOVERABLE_DURATION, DISCOVER_DURATION);
        startActivityForResult(discoveryIntent, REQUEST_BLU);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (resultCode == DISCOVER_DURATION && requestCode == REQUEST_BLU) {

            Intent intent = new Intent();
            intent.setAction(Intent.ACTION_SEND);
            intent.setType("text/plain");
            String imageUri = "drawable://" + R.drawable.md5sum;

            File f = new File(root+"imageUri");
            intent.putExtra(Intent.EXTRA_STREAM, Uri.fromFile(imageUri));


            PackageManager pm = getPackageManager();
            List<ResolveInfo> appsList = pm.queryIntentActivities(intent, 0);
            if (appsList.size() > 0)
            {
                String packageName = null;
                String className = null;
                boolean found = false;


                for (ResolveInfo info:appsList){
                    packageName = info.activityInfo.packageName;
                    if (packageName.equals("com.example.vinit.bluetooth1"))
                    {
                        className = info.activityInfo.name;
                        found = true;
                        break;// found
                    }
                    if (!found)
                    {
                        Toast.makeText(this, "Bluetooth is not found", Toast.LENGTH_LONG).show();
                    }
                    else
                    {
                        intent.setClassName(packageName, className);
                        startActivity(intent);
                    }
                }
            }
            else
            {
                Toast.makeText(this, "Bluetooth is cancelled", Toast.LENGTH_LONG).show();

            }
        }
    }
}
