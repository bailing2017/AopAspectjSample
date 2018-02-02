package com.bailing.aopaspectjsample;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import com.bailing.aopaspectjsample.ui.activity.CommonActivity;
import com.bailing.aopaspectjsample.ui.base.BaseActivity;
import com.bailing.aopaspectjsample.ui.activity.WithFragmentActivity;
import com.bailing.aopaspectjsample.ui.activity.FragmentTabHostActivity;
import com.bailing.aopaspectjsample.ui.activity.VpFragmentActivity;


public class MainActivity extends BaseActivity implements View.OnClickListener {
    private static final String TAG = "MainActivity";
    private Button btnAct, btnFragment, btnTabHost, btnVp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        btnAct = findViewById(R.id.btn_activity);
        btnFragment = findViewById(R.id.btn_activity_fragment);
        btnTabHost = findViewById(R.id.btn_tab_fragment);
        btnVp = findViewById(R.id.btn_vp_fragment);

        btnAct.setOnClickListener(this);
        btnFragment.setOnClickListener(this);
        btnTabHost.setOnClickListener(this);
        btnVp.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_activity:
                startActivity(new Intent(this, CommonActivity.class));
                break;
            case R.id.btn_activity_fragment:
                startActivity(new Intent(this, WithFragmentActivity.class));
                break;
            case R.id.btn_tab_fragment:
                startActivity(new Intent(this, FragmentTabHostActivity.class));
                break;
            case R.id.btn_vp_fragment:
                startActivity(new Intent(this, VpFragmentActivity.class));
                break;
        }
    }
}
