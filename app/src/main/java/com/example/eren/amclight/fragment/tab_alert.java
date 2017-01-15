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

import com.example.eren.amclight.CallNumber;
import com.example.eren.amclight.R;
import com.example.eren.amclight.page3;

@SuppressLint("ValidFragment")
public class tab_alert extends Fragment {
    public tab_alert(Context context) {
        mContext = context;
    }

    Context mContext;

    //data
    private boolean mDanger = false;
    private int danger_amount = 0;

    //ui
    private Button btn_page3_alert_slider;
    private SeekBar sb;
    private TextView tv_value;

    @Override
    public View onCreateView(LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_page3_alert, null);
        dataInit();
        uiInit(view);
        return view;
    }

    private void dataInit()
    {
        mDanger = false;
        danger_amount = 50;
    }

    private void uiInit(View view) {
        btn_page3_alert_slider = (Button) view.findViewById(R.id.page3_button_slider_alert);
        btn_page3_alert_slider.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v) {
                mDanger = !mDanger;
                if (mDanger)
                    btn_page3_alert_slider.setBackgroundResource(R.drawable.slider_on);
                else
                    btn_page3_alert_slider.setBackgroundResource(R.drawable.slider_off);
            }
        });
        if (mDanger)
            btn_page3_alert_slider.setBackgroundResource(R.drawable.slider_on);
        else
            btn_page3_alert_slider.setBackgroundResource(R.drawable.slider_off);

        tv_value = (TextView) view.findViewById(R.id.tv_page3_alert_value);

        sb = (SeekBar) view.findViewById(R.id.seekBar_page3_alert);
        sb.setProgress(danger_amount);
        tv_value.setText("Current Danger Amount : " + danger_amount);
        sb.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                danger_amount = progress;
                tv_value.setText("Current Danger Amount : " + danger_amount);
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
                if(danger_amount==100)
                {
                    doAlert();
                }
            }
        });
    }

    public void doAlert()
    {
        CallNumber mCallNumber = CallNumber.getInstance(mContext);
        mCallNumber.call();
    }
}