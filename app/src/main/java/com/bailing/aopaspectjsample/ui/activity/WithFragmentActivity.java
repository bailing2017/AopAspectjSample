package com.bailing.aopaspectjsample.ui.activity;

import android.os.Bundle;
import com.bailing.aopaspectjsample.R;
import com.bailing.aopaspectjsample.ui.base.BaseActivity;
import com.bailing.aopaspectjsample.ui.fragment.SingleFragment;
import com.bailing.aspectjlib.page.DontAnalyticTrace;

/**
 * 带有Fragment的Activity
 */
@DontAnalyticTrace
public class WithFragmentActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_with_fragment);

        getSupportFragmentManager().beginTransaction()
            .replace(R.id.fragment_container, new SingleFragment())
            .commit();
    }
}
