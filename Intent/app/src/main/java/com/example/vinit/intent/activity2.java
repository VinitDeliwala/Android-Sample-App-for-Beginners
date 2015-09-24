package com.example.vinit.intent;

import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class activity2 extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_activity2);


        Bundle msg3 = getIntent().getExtras();
        if (msg3==null){
            return ;
        }
        String msg4 = msg3.getString("msg2");
        final TextView t2= (TextView) findViewById(R.id.t2);
        t2.setText(msg4);
    }
    public void Onclick(View view){
        Intent i = new Intent(this,MainActivity.class);
        final EditText e2 = (EditText) findViewById(R.id.e2);
        String msg11 = e2.getText().toString();
        i.putExtra("msg6",msg11);
        startActivity(i);
    }



    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_activity2, menu);
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
}
