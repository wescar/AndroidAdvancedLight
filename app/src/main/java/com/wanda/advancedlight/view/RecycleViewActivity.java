package com.wanda.advancedlight.view;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.wanda.advancedlight.BaseActivity;
import com.wanda.advancedlight.R;
import com.wanda.advancedlight.presenter.RecyclerViewAdapter;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by PC on 2018/7/30.
 */

public class RecycleViewActivity extends BaseActivity {

    @BindView(R.id.recyclerView)
    public RecyclerView mRecyclerView;

    private RecyclerViewAdapter mRecyclerViewAdapter;

    private List<String> mList;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recyclerview);
        ButterKnife.bind(this);
        initData();
        initView();
    }

    private void initData() {
        mList = new ArrayList<>();
        for (int i=0;i<20;i++){
            mList.add(""+i);
        }
    }

    @Override
    public void initView() {

        //设置布局管理器
        mRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        //设置item增加和删除时的动画
        mRecyclerView.setItemAnimator(new DefaultItemAnimator());

        mRecyclerViewAdapter = new RecyclerViewAdapter(this,mList);

        mRecyclerView.setAdapter(mRecyclerViewAdapter);

    }

    @Override
    public void initToolbar() {

    }
}
