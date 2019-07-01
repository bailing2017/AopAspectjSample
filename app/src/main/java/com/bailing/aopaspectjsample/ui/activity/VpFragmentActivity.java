package com.bailing.aopaspectjsample.ui.activity;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.View;
import android.view.ViewGroup;

import com.bailing.aopaspectjsample.R;
import com.bailing.aopaspectjsample.ui.base.BaseActivity;
import com.bailing.aopaspectjsample.ui.fragment.vp.VpFragmentFirst;
import com.bailing.aopaspectjsample.ui.fragment.vp.VpFragmentSecond;
import com.bailing.aopaspectjsample.ui.fragment.vp.VpFragmentThird;

import java.util.ArrayList;
/*@DontAnalyticTrace*/
public class VpFragmentActivity extends BaseActivity {

    private ViewPager mViewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_vp_fragment);
        mViewPager = findViewById(R.id.view_pager);
        CommonFragmentAdapter adapter = new CommonFragmentAdapter(getSupportFragmentManager());
        adapter.addFragment(new VpFragmentFirst());
        adapter.addFragment(new VpFragmentSecond());
        adapter.addFragment(new VpFragmentThird());
        mViewPager.setAdapter(adapter);
    }

    public void control(View view) {
        if (mViewPager.getCurrentItem() ==0){
            mViewPager.setCurrentItem(2);
        }else if (mViewPager.getCurrentItem() == 2){
            mViewPager.setCurrentItem(0);
        }
    }

    public class CommonFragmentAdapter extends FragmentPagerAdapter {

        private ArrayList<Fragment> mFragments;

        public CommonFragmentAdapter(FragmentManager fm) {
            super(fm);
            mFragments = new ArrayList<>();
        }

        public void addFragment(Fragment fragment) {
            mFragments.add(fragment);
        }

        @Override
        public Fragment getItem(int arg0) {
            Fragment f = mFragments.get(arg0);
            if (f == null) {
            }
            return mFragments.get(arg0);
        }

        @Override
        public int getCount() {
            return mFragments.size();
        }

        @Override
        public void destroyItem(ViewGroup container, int position, Object object) {
            // Auto-generated method stub
            super.destroyItem(container, position, object);
        }
    }
}
