package com.bailing.aopaspectjsample.ui.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
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

public class SingleFragment extends BaseFragment {

    private final String TAG = "TabHostFragmentFirst";
    @Override
    protected String getTAG() {
        return TAG;
    }
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container,
        @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_one, container, false);
        return view;
    }
}
