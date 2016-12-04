package com.example.hannahxian.qqmessage.activities;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;

import com.example.hannahxian.qqmessage.R;
import com.example.hannahxian.qqmessage.adapter.MyViewPagerAdapter;
import com.example.hannahxian.qqmessage.fragements.ShopFragement;

import butterknife.Bind;
import butterknife.ButterKnife;

public class SelectGoods extends AppCompatActivity {


    @Bind(R.id.tabLayout)
    TabLayout tabLayout;
    @Bind(R.id.toolBar)
    Toolbar toolBar;
    @Bind(R.id.main_viewpager)
    ViewPager mainViewpager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_select_goods);
        ButterKnife.bind(this);

        initViewPager();
        initTab();
    }

    private void initViewPager(){
        MyViewPagerAdapter viewAdapter = new MyViewPagerAdapter(getSupportFragmentManager());
        viewAdapter.addPager(new ShopFragement(),"one");
        viewAdapter.addPager(new ShopFragement(),"two");
        viewAdapter.addPager(new ShopFragement(),"three");

        mainViewpager.setAdapter(viewAdapter);
    }

    private void initTab() {
        tabLayout.addTab(tabLayout.newTab().setText("TabOne"));
        tabLayout.addTab(tabLayout.newTab().setText("TabTwo"));
        tabLayout.addTab(tabLayout.newTab().setText("TabThree"));

        tabLayout.setupWithViewPager(mainViewpager);
    }
}
