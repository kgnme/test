package com.example.eren.amclight.fragment;

import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.example.eren.amclight.R;


public class tab_light extends Fragment {
    Context mContext;

    public tab_light(Context context) {
        mContext = context;
    }
    private boolean lighton;
    private Button btn_page3_light_slider;

    @Override
    public View onCreateView(LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_page3_light, null);
        lighton = true;
        btn_page3_light_slider = (Button) view.findViewById(R.id.page3_button_slider);
        btn_page3_light_slider.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                lighton = !lighton;
                if(lighton)
                    btn_page3_light_slider.setBackgroundResource(R.drawable.slider_on);
                else
                    btn_page3_light_slider.setBackgroundResource(R.drawable.slider_off);
            }
        });
        btn_page3_light_slider.callOnClick();

        return view;
    }
}