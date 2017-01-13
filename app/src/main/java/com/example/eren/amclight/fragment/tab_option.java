package com.example.eren.amclight.fragment;

import android.content.Intent;
import android.support.v4.app.Fragment;
import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.FrameLayout;

import com.example.eren.amclight.page4_option1;
import com.example.eren.amclight.R;
import com.example.eren.amclight.page4_option4;

/**
 * Created by eren on 2017. 1. 3..
 */

public class tab_option extends Fragment implements View.OnClickListener {
    Context mContext;

    private FrameLayout option[] = new FrameLayout[5];
    private int[] framelayout_id = {R.id.option1, R.id.option2, R.id.option3, R.id.option4};

    public tab_option(Context context) {
        mContext = context;
    }

    @Override
    public View onCreateView(LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_page3_option, null);
        Log.e("tab_option", "111111");

        for(int i=0; i<4; i++)
        {
            option[i] = (FrameLayout) view.findViewById(framelayout_id[i]);
            option[i].setOnClickListener(this);
        }




        return view;
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.option1:
                Log.e("tab_option", "1");
                Intent in = new Intent(mContext, page4_option1.class);
                startActivity(in);
                break;
            case R.id.option2:
                Log.e("tab_option", "1");
                Intent in2 = new Intent(mContext, page4_option2.class);
                startActivity(in2);
                break;
            case R.id.option3:
                Log.e("tab_option", "1");
                Intent in3 = new Intent(mContext, page4_option1.class);
                startActivity(in3);
                break;
            case R.id.option4:
                Log.e("tab_option", "1");
                Intent in4 = new Intent(mContext, page4_option4.class);
                startActivity(in4);
                break;

        }
    }
}