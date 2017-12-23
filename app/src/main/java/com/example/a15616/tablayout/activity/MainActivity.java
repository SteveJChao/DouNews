package com.example.a15616.tablayout.activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Build;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.widget.Button;

import com.example.a15616.tablayout.adpter.MyFragmentStatePagerAdapter;
import com.example.a15616.tablayout.fragment.ListFragment;
import com.example.a15616.tablayout.R;
import com.example.a15616.tablayout.fragment.VideoFragment;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private TabLayout mTabLayout;

    private ViewPager mViewPager;

    private Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Toolbar toolbar = (Toolbar) findViewById(R.id.tool_bar);
        setSupportActionBar(toolbar);

        mViewPager = (ViewPager) findViewById(R.id.view_pager);
        initViewPager();


    }

    public void initViewPager() {
        mTabLayout = (TabLayout) findViewById(R.id.tab_layout);
        List<String> titleList = new ArrayList<>();
        titleList.add("Music");
        titleList.add("Video");
        titleList.add("News");
        titleList.add("Sports");
        titleList.add("Tech");
        titleList.add("community");

        //为每一页添加标题
        for (int i = 0; i < titleList.size(); i++) {
            mTabLayout.addTab(mTabLayout.newTab().setText(titleList.get(i)));
        }
        //为每一页的碎片列表添加碎片
        List<Fragment> fragmentList = new ArrayList<>();
        for (int i = 0; i < titleList.size(); i++) {
            fragmentList.add(new ListFragment());
        }

        fragmentList.remove(1);
        fragmentList.add(1, new VideoFragment());

        //把viewPager和fragment加载到fragmentAdapter
        MyFragmentStatePagerAdapter mFragmentStatePagerAdapter =
                new MyFragmentStatePagerAdapter(getSupportFragmentManager(), fragmentList, titleList);
        mViewPager.setAdapter(mFragmentStatePagerAdapter);
        mTabLayout.setupWithViewPager(mViewPager);
        mTabLayout.setTabsFromPagerAdapter(mFragmentStatePagerAdapter);
    }

    public void startIntent() {
        Intent intent = new Intent(MainActivity.this, DetailActivity.class);
        startActivity(intent);
    }

}
