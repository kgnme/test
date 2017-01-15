package com.example.eren.amclight;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;

import com.github.lzyzsd.circleprogress.CircleProgress;

public class page4_option2 extends AppCompatActivity {
    //data
    private int battery_amount=0;

    //ui
    private SeekBar sb;
    private TextView tv_battery_remaining;
    private CircleProgress cp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.page4_option2);

        dataInit();
        uiInit();
    }

    private void dataInit()
    {
        battery_amount = 50;
    }
    private void uiInit()
    {
        TextView tv_toolbar_title = (TextView) findViewById(R.id.page4_toolbar_tv_title);
        tv_toolbar_title.setText("Battery");
        Button bt_toolbar_back = (Button) findViewById(R.id.page4_toolbar_bt_back);
        bt_toolbar_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        cp = (CircleProgress) findViewById(R.id.page4_cp_battery);
        tv_battery_remaining = (TextView) findViewById(R.id.page4_tv_battery_remaining);

        sb = (SeekBar) findViewById(R.id.seekBar_page3_battery);
        sb.setProgress(battery_amount);
        sb.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                setBatteryAmountTextView(progress);
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
                Toast.makeText(getApplicationContext(), "Remainin : " + battery_amount + "%", Toast.LENGTH_SHORT).show();
            }
        });
        setBatteryAmountTextView(battery_amount);
    }

    private void setBatteryAmountTextView(int progress)
    {
        battery_amount = progress;

        cp.setProgress(battery_amount);

        int remain_hour=0;
        int remain_minute=0;

        remain_hour = progress*3/60;
        remain_minute = (progress*3)%60;

        tv_battery_remaining.setText("Remaining : " + remain_hour + "h " + remain_minute + "m");

    }


}
