package com.bailing.aopaspectjsample.ui.activity;

import android.os.Bundle;
import android.support.v4.app.FragmentTabHost;
import android.view.View;
import android.widget.TabHost;
import android.widget.TabWidget;
import android.widget.TextView;

import com.bailing.aopaspectjsample.R;
import com.bailing.aopaspectjsample.ui.base.BaseActivity;
import com.bailing.aopaspectjsample.ui.fragment.tabhost.TabHostFragmentFirst;
import com.bailing.aopaspectjsample.ui.fragment.tabhost.TabHostFragmentSecond;
import com.bailing.aopaspectjsample.ui.fragment.tabhost.TabHostFragmentThird;
//@DontAnalyticTrace
public class FragmentTabHostActivity extends BaseActivity implements TabHost.OnTabChangeListener {

    public FragmentTabHost tabHost;

    public static final String HOME = "home";
    public static final String PRODUCT = "product";
    public static final String MALL = "mall";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fragment_tab_host);

        initTabBar();
    }

    /**
     * 创建底部导航条
     */
    private void initTabBar() {
        tabHost =  findViewById(android.R.id.tabhost);
        TabWidget tabWidget = findViewById(android.R.id.tabs);
        tabHost.setup(this, getSupportFragmentManager(), R.id.tabcontent);
        //消除分隔线
        tabHost.getTabWidget().setDividerDrawable(android.R.color.transparent);
        tabHost.addTab(tabHost.newTabSpec(HOME).setIndicator(getIndicator(tabWidget, "1")),
            TabHostFragmentFirst.class, null);
        tabHost.addTab(tabHost.newTabSpec(PRODUCT).setIndicator(getIndicator(tabWidget, "2")),
            TabHostFragmentSecond.class, null);
        tabHost.addTab(tabHost.newTabSpec(MALL).setIndicator(getIndicator(tabWidget, "3")),
            TabHostFragmentThird.class, null);

        tabHost.setOnTabChangedListener(this);
    }

    private View getIndicator(final TabWidget tabWidget, String label) {
        View tabIndicator = getLayoutInflater().inflate(R.layout.tab, tabWidget, false);
        TextView tv =  tabIndicator.findViewById(R.id.tabBarTitle);
        tv.setText(label);
        return tabIndicator;
    }

    @Override
    public void onTabChanged(String tabId) {

    }
}