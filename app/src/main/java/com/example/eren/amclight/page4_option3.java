package com.example.eren.amclight;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class page4_option3 extends AppCompatActivity {

    private TextView tv_selected;
    private Button btlist[] = new Button[9];
    private int[] btlist_id = {R.id.page4_btlist_1, R.id.page4_btlist_2, R.id.page4_btlist_3, R.id.page4_btlist_4,
            R.id.page4_btlist_5, R.id.page4_btlist_6, R.id.page4_btlist_7, R.id.page4_btlist_8, R.id.page4_btlist_9};



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.page4_option3);

        dataInit();
        uiInit();
    }
    private void dataInit(){
    }
    private void uiInit()
    {
        TextView tv_toolbar_title = (TextView) findViewById(R.id.page4_toolbar_tv_title);
        tv_toolbar_title.setText("Bluetooth");
        Button bt_toolbar_back = (Button) findViewById(R.id.page4_toolbar_bt_back);
        bt_toolbar_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        tv_selected = (TextView) findViewById(R.id.page4_option3_selected);

        for(int i=0; i<9; i++)
        {
            btlist[i] = (Button) findViewById(btlist_id[i]);
            final int finalI = i;
            btlist[i].setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    tv_selected.setText("Selected Device : " + btlist[finalI].getText().toString());
                }
            });
        }

    }

}
