package com.example.eren.amclight.fragment;

import android.annotation.SuppressLint;
import android.os.Build;
import android.os.CountDownTimer;
import android.support.v4.app.Fragment;
import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.TimePicker;
import android.widget.Toast;

import com.example.eren.amclight.R;

@SuppressLint("ValidFragment")
public class tab_timer extends Fragment{
    public tab_timer(Context context) {
        mContext = context;
    }

    private Context mContext;

    //ui
    private TimePicker tp;
    private Button btn_start;
    private TextView tv_time_remaining;
    private CountDownTimer cdt;

    //data
    private boolean mTimer;
    private int mHour;
    private int mMinute;

    @Override
    public View onCreateView(LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_page3_timer, null);
        dataInit();
        uiInit(view);
        return view;
    }

    private void timer()
    {
        int dstTime = 60000*(tpTime(1)*60 + tpTime(2));
        if(dstTime == 0)
        {
            Toast.makeText(mContext,"Please check time picker.", Toast.LENGTH_SHORT).show();
            return;
        }

        mTimer = !mTimer;
        if(mTimer)
        {
            cdt = new CountDownTimer(dstTime, 500)
            {
                public void onTick(long millisUntilFinished)
                {
                    int remain_time = (int) millisUntilFinished / 1000;
                    int remain_hour = remain_time/3600;
                    int remain_minute= (remain_time - remain_hour*3600)/60;
                    int remain_second= remain_time%60;
                    tv_time_remaining.setText("Timer started.\n" + "It turns off after " + remain_hour + ":" + remain_minute + ":" + remain_second);
                }

                public void onFinish() {
                    mTimer = false;
                    btn_start.setText("Start");
                    tv_time_remaining.setText("Here is time remaining field");
                }
            }.start();
            btn_start.setText("Stop");
        }
        else
        {
            cdt.cancel();
            tv_time_remaining.setText("Timer Stopped.\nHere is time remaining field");
            btn_start.setText("Start");
        }
    }

    private int tpTime(int option)
    {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            if(option==1)
                return tp.getHour();
            if(option==2)
                return tp.getMinute();
        }
        else
        {
            if(option==1)
                return tp.getCurrentHour();
            if(option==2)
                return tp.getCurrentMinute();
        }
        return 0;
    }
    private void dataInit()
    {
        mTimer = false;
        mHour = 0;
        mMinute = 0;
    }
    private void uiInit(View view)
    {
        tv_time_remaining = (TextView) view.findViewById(R.id.page3_tv_time_remaining);
        tv_time_remaining.setText("Here is time remaining field");
        tp = (TimePicker) view.findViewById(R.id.timePicker);
        tp.setIs24HourView(true);

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            tp.setHour(mHour);
            tp.setMinute(mMinute);
        }
        else
        {
            tp.setCurrentHour(mHour);
            tp.setCurrentHour(mMinute);
        }

        btn_start = (Button) view.findViewById(R.id.page3_button_timer_start);
        btn_start.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                timer();
            }
        });
        if(mTimer) btn_start.setText("Stop");
        else        btn_start.setText("Start");
    }
}