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
import android.widget.TextView;

public class bottomFragment extends Fragment {

    private static TextView t11;
    private static TextView t12;

    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.bottom_fragment, container, false);
        t11=(TextView) view.findViewById(R.id.t1);
        t12=(TextView) view.findViewById(R.id.t2);
        return view;
    }

    public void setMeme(String top, String bottom) {
        t11.setText(top);
        t12.setText(bottom);
    }
}