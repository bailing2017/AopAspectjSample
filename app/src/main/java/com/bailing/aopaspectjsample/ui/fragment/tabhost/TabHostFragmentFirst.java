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
 * Date:   2017/11/27 0027 16:57
 */

public class TabHostFragmentFirst extends BaseFragment {

    private final String TAG = "TabHostFragmentFirst";

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container,
        @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_one, container, false);
        return view;
    }

    /**
     * 一个Activity承载多个Fragment Tab 的情况，Tab间切换并不会触发 onResume和onPause,触发的是
     * onHiddenChanged(boolean hidden)
     *
     * @param hidden
     */
    @Override
    public void onHiddenChanged(boolean hidden) {
        super.onHiddenChanged(hidden);
        Log.e(TAG, "onHiddenChanged start");
        Log.e(TAG, "onHiddenChanged end");
    }

}
