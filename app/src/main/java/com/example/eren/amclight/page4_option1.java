package com.example.eren.amclight;

import android.Manifest;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.util.TypedValue;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class page4_option1 extends AppCompatActivity implements View.OnClickListener {

    private Button bt_call;
    private TextView bt_call_edit_number;

    private TextView tv_call_number;
    private TextView tv_call_name;

    private AlertDialog dialog_change_number;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.page4_option1);

        TextView tv_toolbar_title = (TextView) findViewById(R.id.page4_toolbar_tv_title);
        tv_toolbar_title.setText("Sos Number");
        Button bt_toolbar_back = (Button) findViewById(R.id.page4_toolbar_bt_back);
        bt_toolbar_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        bt_call = (Button) findViewById(R.id.page4_bt_call);

        bt_call_edit_number = (TextView) findViewById(R.id.page4_bt_editcall);
        bt_call.setOnClickListener(this);

        bt_call_edit_number.setOnClickListener(this);

        tv_toolbar_title = (TextView) findViewById(R.id.page4_toolbar_tv_title);
        tv_call_name = (TextView) findViewById(R.id.page4_sos_tv_callname);
        tv_call_number = (TextView) findViewById(R.id.page4_sos_tv_callnumber);
        tv_toolbar_title.setText("SOS Number");
        tv_call_name.setText("911");
        tv_call_number.setText("119");
        changeButtonImage();
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.page4_bt_call:
                callnumber();
                break;
            case R.id.page4_bt_editcall:
                dialog_change_number = createDialog();
                dialog_change_number.show();
                return;
        }
    }

    public void callnumber() {
        Intent intent = new Intent(Intent.ACTION_CALL);
        intent.setData(Uri.parse("tel:900..."));
        if (ActivityCompat.checkSelfPermission(this, Manifest.permission.CALL_PHONE) != PackageManager.PERMISSION_GRANTED) {
            ActivityCompat.requestPermissions(this,
                    new String[]{Manifest.permission.CALL_PHONE},
                    1);
            return;
        }
        Toast.makeText(getApplicationContext(),"Calling", Toast.LENGTH_SHORT).show();
//        startActivity(intent);
    }

    private void changeButtonImage()
    {
        Log.e("asdf", tv_call_number.getText().toString().trim());
        if(tv_call_number.getText().toString().trim().equals("119"))
        {
            tv_call_number.setTextSize(TypedValue.COMPLEX_UNIT_SP, 40);
            bt_call.setBackgroundResource(R.drawable.page3_image_call);
        }
        else
        {
            tv_call_number.setTextSize(TypedValue.COMPLEX_UNIT_SP, 18);
            bt_call.setBackgroundResource(R.drawable.page3_image_call2);
        }
    }

    private AlertDialog createDialog() {
        final View innerView = getLayoutInflater().inflate(R.layout.page4_option1_set_number_dialog, null);
        AlertDialog.Builder mBuilder = new AlertDialog.Builder(this);
        mBuilder.setView(innerView);

        ((EditText)innerView.findViewById(R.id.page4_dialog_et_name)).setText(tv_call_name.getText().toString().trim());
        ((EditText)innerView.findViewById(R.id.page4_dialog_et_number)).setText(tv_call_number.getText().toString().trim());

        Button dialog_ok = (Button) innerView.findViewById(R.id.page4_dialog_bt_ok);
        dialog_ok.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                tv_call_name.setText(((EditText)innerView.findViewById(R.id.page4_dialog_et_name)).getText().toString());
                tv_call_number.setText(((EditText)innerView.findViewById(R.id.page4_dialog_et_number)).getText().toString());
                changeButtonImage();
                dialog_change_number.dismiss();
            }
        });
        Button dialog_cancle = (Button) innerView.findViewById(R.id.page4_dialog_bt_cancle);
        dialog_cancle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialog_change_number.dismiss();
            }
        });

        return mBuilder.create();
    }
}
