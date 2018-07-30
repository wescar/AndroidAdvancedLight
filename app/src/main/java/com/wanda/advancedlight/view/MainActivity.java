package com.wanda.advancedlight.view;

import android.content.Intent;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.wanda.advancedlight.BaseActivity;
import com.wanda.advancedlight.R;

import butterknife.BindView;
import butterknife.ButterKnife;


public class MainActivity extends BaseActivity {

    @BindView(R.id.chapter_first)
    public Button Button1;

    @Override
    protected void onCreate( Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        initView();
    }

    @Override
    public void initView() {

        Button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this,NewFeaturesActivity.class));
            }
        });
    }

    @Override
    public void initToolbar() {

    }
}
