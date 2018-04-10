package com.example.a15616.DouNews.activity;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.GravityCompat;
import android.support.v4.view.ViewPager;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.widget.Toast;

import com.example.a15616.DouNews.adpter.MyFragmentStatePagerAdapter;
import com.example.a15616.DouNews.fragment.ListFragment;
import com.example.a15616.DouNews.R;
import com.example.a15616.DouNews.fragment.VideoFragment;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private TabLayout mTabLayout;

    private ViewPager mViewPager;

    private DrawerLayout mDrawerLayout;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Toolbar toolbar = (Toolbar) findViewById(R.id.tool_bar);
        setSupportActionBar(toolbar);
        final ActionBar actionBar = getSupportActionBar();
        actionBar.setHomeAsUpIndicator(R.drawable.menu_16);
        actionBar.setDisplayHomeAsUpEnabled(true);

        mViewPager = (ViewPager) findViewById(R.id.view_pager);
        mDrawerLayout = (DrawerLayout) findViewById(R.id.main_drawer);
        NavigationView navigationView = (NavigationView) findViewById(R.id.main_navigation_view);
        if (navigationView != null) {
            navigationView.setNavigationItemSelectedListener(
                    new NavigationView.OnNavigationItemSelectedListener() {
                        @Override
                        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                            item.setChecked(true);
                            String title = item.getTitle().toString();
                            Toast.makeText(getApplicationContext(), title, Toast.LENGTH_SHORT).show();
                            mDrawerLayout.closeDrawers();
                            return true;
                        }
                    }
            );
        }

        initViewPager();
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                mDrawerLayout.openDrawer(GravityCompat.START);
                return true;
        }
        return super.onOptionsItemSelected(item);
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

    public void startActivity() {
        Intent intent = new Intent(MainActivity.this, DetailActivity.class);
        startActivity(intent);
    }

}
