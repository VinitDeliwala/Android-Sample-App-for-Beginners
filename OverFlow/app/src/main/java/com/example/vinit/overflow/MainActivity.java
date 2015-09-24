package com.example.vinit.overflow;

import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.ImageView;


public class MainActivity extends ActionBarActivity {

    private TextView t1;
    private ImageView i1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        t1 = (TextView) findViewById(R.id.textView);
        i1 = (ImageView) findViewById(R.id.imageView);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        RelativeLayout main_view =(RelativeLayout) findViewById(R.id.main_view);

        switch (item.getItemId()){
            case R.id.menu_red:
                if(item.isChecked())
                    item.setChecked(false);
                else
                    item.setChecked(true);

                main_view.setBackgroundColor(Color.RED);
                t1.setText("RED");
                i1.setBackgroundResource(R.drawable.img);
                return true;
            case R.id.menu_blue:
                if(item.isChecked())
                    item.setChecked(false);
                else
                    item.setChecked(true);

                main_view.setBackgroundColor(Color.BLUE);
                i1.setBackgroundResource(R.drawable.img1);
                t1.setText("Blueeeeeeee");
                return true;
            case R.id.menu_yellow:
                if(item.isChecked())
                    item.setChecked(false);
                else
                    item.setChecked(true);

                main_view.setBackgroundColor(Color.YELLOW);
                t1.setText("Yellooooowwww");
                i1.setBackgroundResource(R.drawable.img2);
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
        }
}
