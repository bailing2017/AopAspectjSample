package com.bailing.aopaspectjsample.ui.base;

import android.support.v4.app.Fragment;
import android.util.Log;

/**
 * Desc:
 * Creator ling
 * Date:   2017/11/30 0030 17:36
 */

public class BaseFragment extends Fragment {

    private final String TAG = getClass().getCanonicalName();

    @Override
    public void onResume() {
        super.onResume();
        Log.e(TAG, "onResume start");
        Log.e(TAG, "onResume end");
    }

    @Override
    public void onPause() {
        super.onPause();
        Log.e(TAG, "onPause start");
        Log.e(TAG, "onPause end");
    }
}
