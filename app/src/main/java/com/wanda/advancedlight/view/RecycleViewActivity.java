package com.wanda.advancedlight.view;

import android.content.DialogInterface;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AlertDialog;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.view.View;
import android.widget.Toast;

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
//        mRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        mRecyclerView.setLayoutManager(new StaggeredGridLayoutManager(4,StaggeredGridLayoutManager.VERTICAL));
        //设置item增加和删除时的动画
        mRecyclerView.setItemAnimator(new DefaultItemAnimator());

//        mRecyclerView.addItemDecoration(new DividerItemDecoration(this,DividerItemDecoration.VERTICAL));



        mRecyclerViewAdapter = new RecyclerViewAdapter(this,mList);

        mRecyclerViewAdapter.setOnItemClickListener(new RecyclerViewAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(View view, int position) {
                Toast.makeText(RecycleViewActivity.this, "点击第"+(position+1)+"条", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onItemLongClick(View view, final int position) {

                new AlertDialog.Builder(RecycleViewActivity.this)
                        .setTitle("确认删除吗？")
                        .setNegativeButton("取消",null)
                        .setPositiveButton("正确", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                mRecyclerViewAdapter.removeData(position);
                            }
                        }).show();
            }
        });
        mRecyclerView.setAdapter(mRecyclerViewAdapter);


    }

    @Override
    public void initToolbar() {

    }
}
