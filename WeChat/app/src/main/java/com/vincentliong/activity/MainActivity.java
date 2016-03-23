package com.vincentliong.activity;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.view.ViewPager;
import android.view.Menu;
import android.view.ViewConfiguration;
import android.view.Window;
import android.widget.RadioGroup;

import com.vincentliong.R;
import com.vincentliong.adapter.NavigationFragmentPagerAdapter;
import com.vincentliong.fragment.AddressBookFragment;
import com.vincentliong.fragment.DiscoverFragment;
import com.vincentliong.fragment.UserPageFragment;
import com.vincentliong.fragment.WeChatFragment;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;


/**
 * 思路:
 * 滑动页面的时候,在ViewPager页面切换的时候,设置RadioGroup的条目选择
 * 在RadioGroup的事件监听中,将UI进行修改
 */
public class MainActivity extends FragmentActivity implements RadioGroup.OnCheckedChangeListener, ViewPager.OnPageChangeListener {
    private ViewPager mViewPager;
    private RadioGroup mNavigationBar;
    private ArrayList<Fragment> fragments;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setOverflowButtonAlways();
        getActionBar().setDisplayShowHomeEnabled(false);
        //初始化界面组件
        initView();
        //初始化ViewPager
        initViewPager();
    }

    private void initViewPager() {
        WeChatFragment weChatFragment = new WeChatFragment();
        AddressBookFragment addressBookFragment = new AddressBookFragment();
        DiscoverFragment discoverFragment = new DiscoverFragment();
        UserPageFragment userPageFragment = new UserPageFragment();
        fragments = new ArrayList<Fragment>();
        fragments.add(weChatFragment);
        fragments.add(addressBookFragment);
        fragments.add(discoverFragment);
        fragments.add(userPageFragment);
        //设置适配器
        mViewPager.setAdapter(new NavigationFragmentPagerAdapter(getSupportFragmentManager(),fragments));
        mViewPager.setCurrentItem(0);
        mViewPager.addOnPageChangeListener(this);
    }

    private void initView() {
        mViewPager = (ViewPager) findViewById(R.id.vpager_main);
        mNavigationBar = (RadioGroup) findViewById(R.id.rg_tab_bar);
        mNavigationBar.setOnCheckedChangeListener(this);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main_menu, menu);
        return true;
    }
    @Override
    public void onCheckedChanged(RadioGroup group, int checkedId) {
        switch (checkedId)
        {
            case R.id.rb_weixin:
                mViewPager.setCurrentItem(0,false);
                break;
            case R.id.rb_address:
                mViewPager.setCurrentItem(1,false);
                break;
            case R.id.rb_discover:
                mViewPager.setCurrentItem(2,false);
                break;
            case R.id.rb_settings:
                mViewPager.setCurrentItem(3,false);
                break;
        }
    }

    @Override
    public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

    }

    @Override
    public void onPageSelected(int position) {
        switch (position)
        {
            case 0:
                mNavigationBar.check(R.id.rb_weixin);
                break;
            case 1:
                mNavigationBar.check(R.id.rb_address);
                break;
            case 2:
                mNavigationBar.check(R.id.rb_discover);
                break;
            case 3:
                mNavigationBar.check(R.id.rb_settings);
                break;
        }
    }

    @Override
    public void onPageScrollStateChanged(int state) {

    }


    /**
     * 让overflow按钮一直出现
     */
    private void setOverflowButtonAlways()
    {
        ViewConfiguration viewConfiguration = ViewConfiguration.get(this);
        try {
            Field menuKey = ViewConfiguration.class.getDeclaredField("sHasPermanentMenuKey");
            menuKey.setAccessible(true);
            menuKey.setBoolean(viewConfiguration, false);
        } catch (NoSuchFieldException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
    }

    @Override
    public boolean onMenuOpened(int featureId, Menu menu) {
        if(featureId == Window.FEATURE_ACTION_BAR && menu != null)
        {
            if(menu.getClass().getSimpleName().equals("MenuBuilder"))
            {
                try {
                    Method method = menu.getClass().getDeclaredMethod("setOptionalIconsVisible",Boolean.TYPE);
                    method.setAccessible(true);
                    method.invoke(menu,true);
                } catch (NoSuchMethodException e) {
                    e.printStackTrace();
                } catch (InvocationTargetException e) {
                    e.printStackTrace();
                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                }
            }
        }
        return super.onMenuOpened(featureId, menu);
    }
}
