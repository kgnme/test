package com.example.eren.amclight;

import android.content.Intent;
import android.graphics.Typeface;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class page2 extends AppCompatActivity {

    private TextView tv_title;
    private Button btn_pair_device;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_page2);

        tv_title = (TextView) findViewById(R.id.page2_tv_title);
        Typeface typeFace = Typeface.createFromAsset(getAssets(), "font1.ttf");  //asset > fonts 폴더 내 폰트파일 적용
        tv_title.setTypeface(typeFace);

        btn_pair_device = (Button) findViewById(R.id.page2_btn_pair_device);
        btn_pair_device.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent in = new Intent(getApplicationContext(), page3.class);
                startActivity(in);
                finish();
            }
        });

    }
}
