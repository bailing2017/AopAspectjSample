package com.bailing.aopaspectjsample.ui.activity;

import android.os.Bundle;
import com.bailing.aopaspectjsample.R;
import com.bailing.aopaspectjsample.ui.base.BaseActivity;
import com.bailing.aspectjlib.log.DebugTrace;

/**
 * 普通的Activity
 */
public class CommonActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_common);

        testAnnotatedMethod();
    }

    @DebugTrace
    private void testAnnotatedMethod() {
        try {
            Thread.sleep(10);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
