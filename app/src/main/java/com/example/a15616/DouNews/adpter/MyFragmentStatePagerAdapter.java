package com.example.a15616.DouNews.adpter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

import java.util.List;

/**
 * Created by hungryao on 12/21/2017.
 */

/**
 * 用来为viewpager提供title和fragment的适配器
 * */
public class MyFragmentStatePagerAdapter extends FragmentStatePagerAdapter {

    //fragment的列表
    private List<Fragment> fragmentList;
    //每一页的标题的列表
    private List<String> titleList;

    public MyFragmentStatePagerAdapter(FragmentManager fm, List<Fragment> fragmentList, List<String> titleList) {
        super(fm);
        this.fragmentList = fragmentList;
        this.titleList = titleList;
    }



    @Override
    public int getCount() {
        return fragmentList.size();
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return titleList.get(position);
    }

    @Override
    public Fragment getItem(int position) {
        return fragmentList.get(position);
    }
}
