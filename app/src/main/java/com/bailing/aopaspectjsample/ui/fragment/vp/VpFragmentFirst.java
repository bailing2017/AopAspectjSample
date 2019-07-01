package com.bailing.aopaspectjsample.ui.fragment.vp;

import android.graphics.Bitmap;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.bailing.aopaspectjsample.R;
import com.bailing.aopaspectjsample.ui.base.BaseFragment;

/**
 * Desc:
 * Creator ling
 * Date:   2017/11/27 0027 16:57
 */

public class VpFragmentFirst extends BaseFragment {

    private final String TAG = "TabHostFragmentFirst";

    @Override
    protected String getTAG() {
        return TAG;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        Log.e(getTAG(), "onCreateView\n");
        View view = inflater.inflate(R.layout.fragment_one, container, false);
        return view;
    }

    /**
     * 一个ViewPager承载多个页面的fragment
     *
     * @param isVisibleToUser true 显示，false 隐藏
     */
    @Override
    public void setUserVisibleHint(boolean isVisibleToUser) {
        super.setUserVisibleHint(isVisibleToUser);
        Log.e(TAG, "setUserVisibleHint ==" + isVisibleToUser);

        ImageView iv = new ImageView(getContext());

    }
}
