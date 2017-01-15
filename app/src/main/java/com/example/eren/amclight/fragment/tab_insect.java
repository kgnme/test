package com.example.eren.amclight.fragment;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;

import com.example.eren.amclight.R;

@SuppressLint("ValidFragment")
public class tab_insect extends Fragment {
    public tab_insect(Context context) {
        mContext = context;
    }
    Context mContext;

    //data
    private boolean mInsect=false;

    //ui
    private Button btn_page3_insect_slider;
    private Button btn_page3_insect;
    private TextView tv_value;

    @Override
    public View onCreateView(LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_page3_insect, null);
        dataInit();
        uiInit(view);
        return view;
    }

    private void doInsectTrap()
    {
        mInsect = !mInsect;
        if(mInsect) {
            btn_page3_insect_slider.setBackgroundResource(R.drawable.slider_on);
            btn_page3_insect.setBackgroundResource(R.drawable.page3_image_insect_on);
            tv_value.setText("Insect Trap Status : ON");
        }
        else {
            btn_page3_insect_slider.setBackgroundResource(R.drawable.slider_off);
            btn_page3_insect.setBackgroundResource(R.drawable.page3_image_insect_off);
            tv_value.setText("Insect Trap Status : OFF");
        }
    }

    private void dataInit()
    {
        mInsect = false;
    }
    private void uiInit(View view)
    {
        btn_page3_insect = (Button) view.findViewById(R.id.page3_button_insect);
        btn_page3_insect.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                doInsectTrap();
            }
        });

        btn_page3_insect_slider = (Button) view.findViewById(R.id.page3_button_slider_insect);
        btn_page3_insect_slider.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                doInsectTrap();
            }
        });

        tv_value =  (TextView) view.findViewById(R.id.tv_page3_insect_value);

        if(mInsect) {
            tv_value.setText("Insect Trap Status : ON");
            btn_page3_insect_slider.setBackgroundResource(R.drawable.slider_on);
            btn_page3_insect.setBackgroundResource(R.drawable.page3_image_insect_on);
        }
        else {
            tv_value.setText("Insect Trap Status : OFF");
            btn_page3_insect_slider.setBackgroundResource(R.drawable.slider_off);
            btn_page3_insect.setBackgroundResource(R.drawable.page3_image_insect_off);
        }
    }
}