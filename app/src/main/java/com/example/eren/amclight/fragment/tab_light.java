package com.example.eren.amclight.fragment;

import android.annotation.SuppressLint;
import android.support.v4.app.Fragment;
import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;

import com.example.eren.amclight.R;

@SuppressLint("ValidFragment")
public class tab_light extends Fragment {
    public tab_light(Context context) {
        mContext = context;
    }
    Context mContext;

    //data
    private boolean mLight=false;
    private int light_intensity=0;

    //ui
    private Button btn_page3_light_slider;
    private SeekBar sb;
    private TextView tv_value;

    @Override
    public View onCreateView(LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_page3_light, null);
        dataInit();
        uiInit(view);
        return view;
    }
    private void dataInit()
    {
        light_intensity = 50;
        mLight = false;
    }
    private void uiInit(View view)
    {
        btn_page3_light_slider = (Button) view.findViewById(R.id.page3_button_slider_light);
        btn_page3_light_slider.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mLight = !mLight;
                if(mLight)
                    btn_page3_light_slider.setBackgroundResource(R.drawable.slider_on);
                else
                    btn_page3_light_slider.setBackgroundResource(R.drawable.slider_off);
            }
        });
        if(mLight)
            btn_page3_light_slider.setBackgroundResource(R.drawable.slider_on);
        else
            btn_page3_light_slider.setBackgroundResource(R.drawable.slider_off);

        tv_value =  (TextView) view.findViewById(R.id.tv_page3_light_value);
        tv_value.setText("Current Light Intensity : " + light_intensity);

        sb = (SeekBar) view.findViewById(R.id.seekBar_page3_light);
        sb.setProgress(light_intensity);

        sb.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                light_intensity = progress;
                tv_value.setText("Current Light Intensity : " + light_intensity);
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
                Toast.makeText(mContext, "Light Intensity : " + light_intensity, Toast.LENGTH_SHORT).show();
            }
        });
    }
}