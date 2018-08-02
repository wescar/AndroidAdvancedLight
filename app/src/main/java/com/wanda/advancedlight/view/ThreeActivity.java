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
 * View体系与自定义View
 * Created by PC on 2018/7/31.
 */

public class ThreeActivity extends BaseActivity implements View.OnClickListener{


    @BindViews({R.id.TextView1})
    List<TextView> mLists;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_three);
        ButterKnife.bind(this);
        initView();
    }

    @Override
    public void initView() {
        mLists.get(0).setOnClickListener(this);

    }

    @Override
    public void initToolbar() {

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.TextView1:
                startActivity(new Intent(ThreeActivity.this,ViewSlidingActivity.class));
                break;
        }
    }
}
