package com.bailing.aopaspectjsample.ui.fragment.vp;

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
 * Date:   2017/11/28 0028 10:20
 */

public class VpFragmentSecond extends BaseFragment {
    private final String TAG = "TabHostFragmentSecond";

    @Override
    protected String getTAG() {
        return TAG;
    }
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container,
        @Nullable Bundle savedInstanceState) {
        Log.e(getTAG(), "onCreateView\n");
        View view = inflater.inflate(R.layout.fragment_two, container, false);
        return view;
    }

    /**
     * 一个ViewPager承载多个页面的fragment
     *
     * @param isVisibleToUser
     */
    @Override
    public void setUserVisibleHint(boolean isVisibleToUser) {
        super.setUserVisibleHint(isVisibleToUser);
        Log.e(TAG, "setUserVisibleHint == " + isVisibleToUser);
    }
}
