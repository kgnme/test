package com.example.eren.amclight;

import android.Manifest;
import android.app.AlertDialog;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
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

import org.w3c.dom.Text;

public class page4_option2 extends AppCompatActivity {

    private TextView tv_battery_remaining;
    private TextView tv_toolbar_title;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.page4_option2);

        TextView tv_toolbar_title = (TextView) findViewById(R.id.page4_toolbar_tv_title);
        tv_toolbar_title.setText("Battery");
        Button bt_toolbar_back = (Button) findViewById(R.id.page4_toolbar_bt_back);
        bt_toolbar_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });


        tv_battery_remaining = (TextView) findViewById(R.id.page4_tv_battery_remaining);


    }


}
