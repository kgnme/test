package com.example.eren.amclight;

import android.Manifest;
import android.app.AlertDialog;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.util.TypedValue;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class page4_option4 extends AppCompatActivity implements View.OnClickListener {

    private Button bt_onoff;
    private Button bt_toolbar_back;

    private boolean all_state = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.page4_option4);
        bt_onoff = (Button) findViewById(R.id.page4_bt_onoff);
        bt_onoff.setOnClickListener(this);
        bt_toolbar_back = (Button) findViewById(R.id.page4_toolbar_bt_back);
        bt_toolbar_back.setOnClickListener(this);

        all_state = false;
        bt_onoff.setBackgroundResource(R.drawable.page4_image_power_off);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.page4_toolbar_bt_back:
                finish();
                break;
            case R.id.page4_bt_onoff:
                changeLightState();
                break;

        }
    }

    private void changeLightState()
    {
        all_state = !all_state;
        if(all_state)
        {
            bt_onoff.setBackgroundResource(R.drawable.page4_image_power_on);
        }
        else
        {
            bt_onoff.setBackgroundResource(R.drawable.page4_image_power_off);
        }

    }
}
