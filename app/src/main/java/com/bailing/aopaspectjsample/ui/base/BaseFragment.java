package com.bailing.aopaspectjsample.ui.base;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * Desc:
 * Creator ling
 * Date:   2017/11/30 0030 17:36
 */

public abstract class BaseFragment extends Fragment {


    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        Log.e(getTAG(), "onAttach\n");
    }

    protected abstract String getTAG();

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.e(getTAG(), "onCreate\n");
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return super.onCreateView(inflater, container, savedInstanceState);
    }


    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        Log.e(getTAG(), "onActivityCreated\n");
    }

    @Override
    public void onStart() {
        super.onStart();
        Log.e(getTAG(), "onStart\n");
    }

    @Override
    public void onResume() {
        super.onResume();
        Log.e(getTAG(), "onResume");
    }

    @Override
    public void onPause() {
        super.onPause();
        Log.e(getTAG(), "onPause\n");
    }


    @Override
    public void onStop() {
        super.onStop();
        Log.e(getTAG(), "onStop\n");
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        Log.e(getTAG(), "onDestroyView\n");
    }


    @Override
    public void onDestroy() {
        super.onDestroy();
        Log.e(getTAG(), "onDestroy\n");
    }


    @Override
    public void onDetach() {
        super.onDetach();
        Log.e(getTAG(), "onDetach");
    }
}
