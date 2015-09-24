package com.example.vinit.happybdaynida;
import android.content.Context;
import android.graphics.Color;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.transition.TransitionManager;
import android.util.Log;
import android.view.Gravity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.view.MotionEvent;
import android.view.GestureDetector;
import android.support.v4.view.GestureDetectorCompat;
import android.widget.Button;
import android.view.View;
import org.w3c.dom.Text;
import android.view.GestureDetector;
import android.view.GestureDetector.SimpleOnGestureListener;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import android.widget.Toast;


public class MainActivity extends ActionBarActivity implements GestureDetector.OnGestureListener,GestureDetector.OnDoubleTapListener {

    private TextView t1;
    private TextView t2;
    private GestureDetectorCompat gestureDetector;
    private Button b1;
    ViewGroup main_view;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        main_view = (ViewGroup) findViewById(R.id.main_view);

        t1 = (TextView) findViewById(R.id.t1);
        t2 = (TextView) findViewById(R.id.t2);
        b1 =  (Button) findViewById(R.id.b1);
        this.gestureDetector = new GestureDetectorCompat(this,this);
        gestureDetector.setOnDoubleTapListener(this);

        b1.setOnClickListener(
                new Button.OnClickListener(){
                    public void onClick(View v) {
                        t1.setText("- EveryOne");
                        t1.setTextColor(Color.parseColor("#ff0000"));
                        t2.setTextColor(Color.parseColor("#ff0000"));
                        t2.setText("Happy B'day !!");
                        main_view.setBackgroundResource(R.drawable.nida5);
                        b1.setText("Hold Me!!");
                        moveButton1();
                    }
                }
        );
        b1.setOnLongClickListener(
                new Button.OnLongClickListener(){
                    public boolean onLongClick(View v){
                        t1.setTextColor(Color.parseColor("#ff0000"));
                        t2.setTextColor(Color.parseColor("#ffffff"));
                        t1.setText("-Last Benchers");
                        b1.setText("Tap Screen");
                        main_view.setBackgroundResource(R.drawable.nida3);
                        moveButton();
                        return true;
                    }
                }
        );
    }
    @Override
    public boolean onSingleTapConfirmed(MotionEvent e) {
        t1.setText("-Lady gAnG");
        main_view.setBackgroundResource(R.drawable.nida1);
        b1.setText("Double-TapScreen");
        t1.setTextColor(Color.parseColor("#ffffff"));
        t2.setTextColor(Color.parseColor("#ffffff"));
        moveButton2();
        return false;
    }

    @Override
    public boolean onDoubleTap(MotionEvent e) {
        t1.setText("DoubleTap");
        return false;
    }

    @Override
    public boolean onDoubleTapEvent(MotionEvent e) {
        t1.setText("-CrAzY eTrX Ppl");
        main_view.setBackgroundResource(R.drawable.nida4);
        b1.setText("Swipe Me  ->");
        t1.setTextColor(Color.parseColor("#006699"));
        t2.setTextColor(Color.parseColor("#006699"));
        return true;
    }

    @Override
    public boolean onDown(MotionEvent e) {
        return true;
    }

    @Override
    public void onShowPress(MotionEvent e) {

    }

    @Override
    public boolean onSingleTapUp(MotionEvent e) {
        return true;
    }

    @Override
    public boolean onScroll(MotionEvent e1, MotionEvent e2, float distanceX, float distanceY) {
//        b1.setText("Swipe Me  <-");
        return true;
    }

    @Override
    public void onLongPress(MotionEvent e) {
        main_view.setBackgroundResource(R.drawable.nida9);
        b1.setText("Finish");
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        this.gestureDetector.onTouchEvent(event);
        return super.onTouchEvent(event);
    }
    private final int GESTURE_THRESHOULD = 100;
    private final int GESTURE_VELOCITY_THRESHOULD = 100;
    private String TAG = "TranslatorSwipeTouch";

    @Override
    public boolean onFling(MotionEvent event1,MotionEvent event2,float velocityx,float velocityy)
    {
        try
        {
            float diffx=event2.getX()-event1.getX();
            float diffy=event2.getY()-event1.getY();

            if(Math.abs(diffx)>Math.abs(diffy))
            {
                if(Math.abs(diffx)>GESTURE_THRESHOULD && Math.abs(velocityx)>GESTURE_VELOCITY_THRESHOULD)
                {
                    if(diffx>0)
                    {
                        onSwipeRight();
                    }
                    else
                    {
                        onSwipeLeft();
                    }
                }
            }
            else
            {
                if(Math.abs(diffy)>GESTURE_THRESHOULD && Math.abs(velocityy)>GESTURE_VELOCITY_THRESHOULD)
                {
                    if(diffy>0)
                    {
                        onSwipeBottom();
                    }
                    else
                    {
                        onSwipeTop();
                    }
                }
            }
        }
        catch(Exception e)
        {
            Log.d(TAG, ""+e.getMessage());
        }
        return false;
    }

    public void onSwipeRight()
    {
        //Toast.makeText(this.getClass().get, "top", Toast.LENGTH_SHORT).show();
        Log.i(TAG, "Right");
        b1.setText("Swipe Me  <-");
        t1.setText("- pArtner in cRiMe");
        t1.setTextColor(Color.parseColor("#ff0000"));
        t2.setTextColor(Color.parseColor("#ff0000"));
        main_view.setBackgroundResource(R.drawable.nida10);
    }
    public void onSwipeLeft()
    {
        Log.i(TAG, "Left");
        b1.setText("Swipe Me Up");
        t1.setText("- iNcredible Day");
        t1.setTextColor(Color.parseColor("#ffffff"));
        t2.setTextColor(Color.parseColor("#ffffff"));
        main_view.setBackgroundResource(R.drawable.sun);
        //Toast.makeText(MainActivity.this, "top", Toast.LENGTH_SHORT).show();
    }

    public void onSwipeTop()
    {
        Log.i(TAG, "Top");
        t1.setText("- chOti tOtA ");
        b1.setText("Swipe Me Down");
        t1.setTextColor(Color.parseColor("#ffffff"));
        t2.setTextColor(Color.parseColor("#ffffff"));
        main_view.setBackgroundResource(R.drawable.best);
        //Toast.makeText(MainActivity.this, "top", Toast.LENGTH_SHORT).show();
    }

    public void onSwipeBottom()
    {
        Log.i(TAG, "Bottom");
        b1.setText("Happy Bday");
        t1.setText("- V Love u");
        t1.setTextColor(Color.parseColor("#ff0000"));
        t2.setTextColor(Color.parseColor("#ff0000"));
        main_view.setBackgroundResource(R.drawable.end);
        //Toast.makeText(MyActivity.this, "top", Toast.LENGTH_SHORT).show();
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

    public void moveButton(){

        View b1 = findViewById(R.id.b1);

        TransitionManager.beginDelayedTransition(main_view);

        RelativeLayout.LayoutParams positionRules = new RelativeLayout.LayoutParams(
                RelativeLayout.LayoutParams.WRAP_CONTENT,RelativeLayout.LayoutParams.WRAP_CONTENT);
        positionRules.addRule(RelativeLayout.ALIGN_PARENT_TOP,RelativeLayout.TRUE);
        positionRules.addRule(RelativeLayout.ALIGN_PARENT_RIGHT, RelativeLayout.TRUE);
        b1.setLayoutParams(positionRules);
        ViewGroup.LayoutParams sizeRules = b1.getLayoutParams();
        sizeRules.width=225;
        sizeRules.height=200;
        b1.setLayoutParams(sizeRules);
    }
    public void moveButton1(){

        View b1 = findViewById(R.id.b1);

        TransitionManager.beginDelayedTransition(main_view);

        RelativeLayout.LayoutParams positionRules = new RelativeLayout.LayoutParams(
                RelativeLayout.LayoutParams.WRAP_CONTENT,RelativeLayout.LayoutParams.WRAP_CONTENT);
        positionRules.addRule(RelativeLayout.ALIGN_PARENT_BOTTOM,RelativeLayout.TRUE);
        positionRules.addRule(RelativeLayout.ALIGN_PARENT_RIGHT, RelativeLayout.TRUE);
        b1.setLayoutParams(positionRules);
        ViewGroup.LayoutParams sizeRules = b1.getLayoutParams();
        sizeRules.width=225;
        sizeRules.height=200;
        b1.setLayoutParams(sizeRules);
    }
    public void moveButton2(){

        View b1 = findViewById(R.id.b1);

        TransitionManager.beginDelayedTransition(main_view);

        RelativeLayout.LayoutParams positionRules = new RelativeLayout.LayoutParams(
                RelativeLayout.LayoutParams.WRAP_CONTENT,RelativeLayout.LayoutParams.WRAP_CONTENT);
        positionRules.addRule(RelativeLayout.ALIGN_PARENT_TOP,RelativeLayout.TRUE);
        positionRules.addRule(RelativeLayout.ALIGN_PARENT_LEFT, RelativeLayout.TRUE);
        b1.setLayoutParams(positionRules);
        ViewGroup.LayoutParams sizeRules = b1.getLayoutParams();
        sizeRules.width=225;
        sizeRules.height=200;
        b1.setLayoutParams(sizeRules);
    }


}
