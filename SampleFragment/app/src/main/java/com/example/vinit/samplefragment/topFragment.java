package com.example.vinit.samplefragment;

/**
 * Created by Vinit on 4/17/2015.
 */
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.View;
import android.view.ViewGroup;
import android.view.LayoutInflater;
import android.app.Activity;
import android.widget.Button;
import android.widget.EditText;


public class topFragment extends Fragment {

    private static EditText t1;
    private static EditText t2;

    topless activityCommander;

    public interface topless{
        public void CreateMeme(String top, String bottom);
    }

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        try{
            activityCommander = (topless) activity;
        }
        catch (ClassCastException e){
            throw new ClassCastException(activity.toString());
        }
    }
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.top_fragment,container,false);
        t1 = (EditText) view.findViewById(R.id.topText);
        t2 = (EditText) view.findViewById(R.id.bottomText);
        final Button b1= (Button) view.findViewById(R.id.b1);

        b1.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        buttonClicked(v);
                    }
                }
        );

        return view;

    }
    public void buttonClicked(View view){
        activityCommander.CreateMeme(t1.getText().toString(), t2.getText().toString());
    }
}
