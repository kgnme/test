package com.example.eren.amclight;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class page4_option3 extends AppCompatActivity {

    private TextView tv_battery_remaining;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.page4_option3);

        TextView tv_toolbar_title = (TextView) findViewById(R.id.page4_toolbar_tv_title);
        tv_toolbar_title.setText("Bluetooth");
        Button bt_toolbar_back = (Button) findViewById(R.id.page4_toolbar_bt_back);
        bt_toolbar_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

    }


}
