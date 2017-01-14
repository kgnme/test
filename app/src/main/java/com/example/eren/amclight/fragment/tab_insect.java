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

public class tab_insect extends Fragment {
    public tab_insect(Context context) {
        mContext = context;
    }
    Context mContext;



    @Override
    public View onCreateView(LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_page3_insect, null);

        return view;
    }
}