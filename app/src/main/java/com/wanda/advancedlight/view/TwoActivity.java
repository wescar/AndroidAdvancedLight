package com.wanda.advancedlight.view;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.TextView;

import com.wanda.advancedlight.BaseActivity;
import com.wanda.advancedlight.R;

import java.util.List;

import butterknife.BindViews;
import butterknife.ButterKnife;

/**
 * Created by PC on 2018/7/31.
 */

public class TwoActivity extends BaseActivity implements View.OnClickListener{
    @BindViews({R.id.TextView1,R.id.TextView2})
    List<TextView> mLists;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_two);
        ButterKnife.bind(this);
        initView();
    }

    @Override
    public void initView() {
        mLists.get(0).setOnClickListener(this);
        mLists.get(1).setOnClickListener(this);
    }

    @Override
    public void initToolbar() {

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.TextView1:
                startActivity(new Intent(TwoActivity.this,MaterialDesignActivity.class));
                break;
            case R.id.TextView2:
                startActivity(new Intent(TwoActivity.this,CoordinatorLayoutActivity.class));
                break;
        }

    }
}
