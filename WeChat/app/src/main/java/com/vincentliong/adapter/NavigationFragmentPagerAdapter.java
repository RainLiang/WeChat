package com.vincentliong.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.view.ViewGroup;

import com.vincentliong.fragment.AddressBookFragment;
import com.vincentliong.fragment.DiscoverFragment;
import com.vincentliong.fragment.UserPageFragment;
import com.vincentliong.fragment.WeChatFragment;

import java.util.ArrayList;

/**
 * 底部导航的适配器
 * Created by RongMa on 16/3/23.
 */
public class NavigationFragmentPagerAdapter extends FragmentPagerAdapter
{
    private ArrayList<Fragment> list;

    public NavigationFragmentPagerAdapter(FragmentManager fm,ArrayList<Fragment> list) {
        super(fm);
        this.list=list;
    }


    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public Object instantiateItem(ViewGroup vg, int position) {
        return super.instantiateItem(vg, position);
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        super.destroyItem(container, position, object);
    }

    @Override
    public Fragment getItem(int position) {
        return list.get(position);
    }
}
