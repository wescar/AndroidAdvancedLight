package com.wanda.advancedlight.view;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.RadioGroup;
import android.widget.TextView;

import com.wanda.advancedlight.BaseActivity;
import com.wanda.advancedlight.R;

import java.util.List;

import butterknife.BindViews;
import butterknife.ButterKnife;

/**
 * Created by PC on 2018/8/9.
 */

public class FourActivity extends BaseActivity  implements View.OnClickListener{

    @BindViews({R.id.four_one})
    List<TextView> textViews;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_four);
        ButterKnife.bind(this);
        initView();
    }

    @Override
    public void initView() {
        textViews.get(0).setOnClickListener(this);
    }

    @Override
    public void initToolbar() {

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.four_one:
                startActivity(new Intent(FourActivity.this, RadioGroupActivity.class));
                break;
        }
    }
}
