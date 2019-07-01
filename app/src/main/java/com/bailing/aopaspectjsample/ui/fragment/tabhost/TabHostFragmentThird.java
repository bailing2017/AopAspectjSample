package com.bailing.aopaspectjsample.ui.fragment.tabhost;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.bailing.aopaspectjsample.R;
import com.bailing.aopaspectjsample.ui.base.BaseFragment;

/**
 * Desc:
 * Creator ling
 * Date:   2017/11/28 0028 10:21
 */

public class TabHostFragmentThird extends BaseFragment {

    private final String TAG = "TabHostFragmentThird";
    @Override
    protected String getTAG() {
        return TAG;
    }
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container,
        @Nullable Bundle savedInstanceState) {
        Log.e(getTAG(), "onCreateView\n");
        View view = inflater.inflate(R.layout.fragment_three, container, false);
        return view;
    }


    /**
     * 一个Activity承载多个Fragment Tab 的情况，Tab间切换并不会触发 onResume和onPause,触发的是
     * onHiddenChanged(boolean hidden) TabHost
     *
     * @param hidden false 则表示显示，true则表示隐藏
     */
    @Override
    public void onHiddenChanged(boolean hidden) {
        super.onHiddenChanged(hidden);
        Log.e(TAG, "onHiddenChanged == " + hidden);
    }
}
