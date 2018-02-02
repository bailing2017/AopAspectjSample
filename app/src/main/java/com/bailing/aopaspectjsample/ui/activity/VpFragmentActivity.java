package com.bailing.aopaspectjsample.ui.activity;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.ViewGroup;
import com.bailing.aopaspectjsample.R;
import com.bailing.aopaspectjsample.ui.base.BaseActivity;
import com.bailing.aopaspectjsample.ui.fragment.vp.VpFragmentFirst;
import com.bailing.aopaspectjsample.ui.fragment.vp.VpFragmentSecond;
import com.bailing.aopaspectjsample.ui.fragment.vp.VpFragmentThird;
import com.bailing.aspectjlib.page.DontAnalyticTrace;
import java.util.ArrayList;
@DontAnalyticTrace
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
