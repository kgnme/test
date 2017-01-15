package com.example.eren.amclight;

import android.Manifest;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.support.v4.app.ActivityCompat;
import android.widget.Toast;


public class CallNumber
{
    private Context mContext;
    private volatile static CallNumber mCallNumber;

    private CallNumber(Context c)
    {
        mContext = c;
    }

    public static CallNumber getInstance(Context c)
    {
        if(mCallNumber == null) {
            mCallNumber= new CallNumber(c);
        }
        return mCallNumber;
    }

    public void call()
    {
        Toast.makeText(mContext,"Calling", Toast.LENGTH_SHORT).show();
        Intent intent = new Intent(Intent.ACTION_CALL);
        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        intent.setData(Uri.parse("tel:900..."));
        mContext.startActivity(intent);
    }
}
