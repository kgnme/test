package com.example.eren.amclight.fragment;

import android.support.v4.app.Fragment;
import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.eren.amclight.R;

/**
 * Created by eren on 2017. 1. 3..
 */

public class tab_timer extends Fragment {
    Context mContext;

    public tab_timer(Context context) {
        mContext = context;
    }

    @Override
    public View onCreateView(LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_page3_timer, null);

        return view;
    }
}