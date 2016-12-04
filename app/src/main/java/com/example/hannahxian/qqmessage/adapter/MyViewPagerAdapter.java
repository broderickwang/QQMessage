package com.example.hannahxian.qqmessage.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by hannahxian on 2016/12/4.
 */

public class MyViewPagerAdapter extends FragmentPagerAdapter {

    private final List<Fragment> fragments = new ArrayList<>();
    private final List<String > strings = new ArrayList<>();

    public MyViewPagerAdapter(FragmentManager fm) {
        super(fm);
    }

    public void addPager(Fragment fragment,String title){
        fragments.add(fragment);
        strings.add(title);
    }

    @Override
    public Fragment getItem(int position) {
        return fragments.get(position);
    }

    @Override
    public int getCount() {
        return fragments.size();
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return strings.get(position);
    }
}
