package com.wanda.advancedlight.view;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.design.widget.Snackbar;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.app.ActionBar;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.support.v7.widget.Toolbar;
import android.view.View;

import com.wanda.advancedlight.BaseActivity;
import com.wanda.advancedlight.R;
import com.wanda.advancedlight.presenter.FragmentAdapter;
import com.wanda.advancedlight.presenter.RecyclerViewAdapter;
import com.wanda.advancedlight.view.fragment.ListFragment;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by PC on 2018/7/31.
 */

public class CoordinatorLayoutActivity extends BaseActivity {


    private ViewPager mViewPager;
    private TabLayout mTabLayout;
    List<String> mList = new ArrayList<>();

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_coordinatorlayout);
        mList.add("1");
        mList.add("2");
        mList.add("3");
        mList.add("4");
//        initView();
        initCoordinatorLayout();
    }

    private void initCoordinatorLayout() {
        Toolbar toolbar  = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        CollapsingToolbarLayout collapsingToolbarLayout = (CollapsingToolbarLayout) findViewById(R.id.collapsing_toolbar);
        collapsingToolbarLayout.setTitle("移动执法");
        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new StaggeredGridLayoutManager(1,StaggeredGridLayoutManager.VERTICAL));
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setAdapter(new RecyclerViewAdapter(CoordinatorLayoutActivity.this,mList));
    }

    @Override
    public void initView() {

        final ActionBar ab = getSupportActionBar();
        ab.setDisplayHomeAsUpEnabled(true);
        mViewPager = (ViewPager) findViewById(R.id.viewpager);
        initViewPager();
    }

    @Override
    public void initToolbar() {

    }

    private void initViewPager(){
        mTabLayout = (TabLayout) findViewById(R.id.tabs);
        List<String> titles = new ArrayList<>();
        titles.add("精选");
        titles.add("精选");
        titles.add("精选");
        titles.add("精选");
        titles.add("精选");
        titles.add("精选");
        titles.add("精选");
        titles.add("精选");
        titles.add("精选");
        titles.add("精选");
        titles.add("精选");

        for (int i=0;i<titles.size();i++){
            mTabLayout.addTab(mTabLayout.newTab().setText(titles.get(i)));
        }
        List<Fragment> fragments= new ArrayList<>();
        for (int i=0;i<titles.size();i++){
            fragments.add(new ListFragment());
        }

        FragmentAdapter mFragmentAdapteradaper = new FragmentAdapter(getSupportFragmentManager(),fragments,titles);

        mViewPager.setAdapter(mFragmentAdapteradaper);
        mTabLayout.setupWithViewPager(mViewPager);
        mTabLayout.setTabsFromPagerAdapter(mFragmentAdapteradaper);

    }

    public void checkin(View view){
        Snackbar.make(view,"点击成功",Snackbar.LENGTH_SHORT).show();
    }
}
