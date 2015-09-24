package com.example.vinit.listview;

import android.view.View;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import android.content.Context;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Collections;
import java.util.Map;
import java.util.WeakHashMap;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import android.app.Activity;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.widget.ImageView;


/**
 * Created by Vinit on 4/20/2015.
 */
public class custom extends ArrayAdapter<String>{

    public custom(Context context, String foods[]) {

        super(context,R.layout.custom_row, foods);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        LayoutInflater l12 = LayoutInflater.from(getContext());
        View Customview = l12.inflate(R.layout.custom_row,parent,false);

        String singleFooditem = getItem(position);
        TextView t1=(TextView) Customview.findViewById(R.id.t2);
        ImageView i1=(ImageView) Customview.findViewById(R.id.im1);

        t1.setText(singleFooditem);
        if (singleFooditem=="Vinit"){
            i1.setImageResource(R.drawable.img);
        }
        else if (singleFooditem=="Krishna") {
            i1.setImageResource(R.drawable.img1);
        }
        else if (singleFooditem=="Anjali") {
            i1.setImageResource(R.drawable.img5);
        }
        else if (singleFooditem=="Sid") {
            i1.setImageResource(R.drawable.img2);
        }
        else if (singleFooditem=="Anjali") {
            i1.setImageResource(R.drawable.img5);
        }
        else {
            i1.setImageResource(R.drawable.img);
        }

        return Customview;

    }
}
