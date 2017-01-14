package com.example.eren.amclight.fragment;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.eren.amclight.R;

/**
 * Created by eren on 2017. 1. 3..
 */

public class tab_alert extends Fragment {
    Context mContext;

    public tab_alert(Context context) {
        mContext = context;
    }

    @Override
    public View onCreateView(LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_page3_alert, null);
aa;
        return view;
    }
}