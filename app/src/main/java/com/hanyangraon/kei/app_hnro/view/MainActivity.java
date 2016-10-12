package com.hanyangraon.kei.app_hnro.view;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.hanyangraon.kei.app_hnro.HnroActivity;
import com.hanyangraon.kei.app_hnro.R;
import com.hanyangraon.kei.app_hnro.view.ff14.FF14_daily_lottery_Activity;

public class MainActivity extends HnroActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        setOnClickListener(R.id.btn_goto_ff14_daily_lottery);
    }

    @Override
    public void onClick(View view) {
        int id = view.getId();

        switch (id) {
            case R.id.btn_goto_ff14_daily_lottery:
                startActivity(new Intent(this, FF14_daily_lottery_Activity.class));
                break;
        }
    }
}
