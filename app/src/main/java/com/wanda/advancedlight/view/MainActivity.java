package com.wanda.advancedlight.view;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.wanda.advancedlight.BaseActivity;
import com.wanda.advancedlight.R;

import java.util.List;

import butterknife.BindViews;
import butterknife.ButterKnife;


public class MainActivity extends BaseActivity {

    @BindViews({R.id.chapter_first,R.id.chapter_two,R.id.chapter_three,R.id.chapter_four})
    List<Button> Button;

    @Override
    protected void onCreate( Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        initView();
    }

    @Override
    public void initView() {

        Button.get(0).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this,FirstActivity.class));
            }
        });
        Button.get(1).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this,TwoActivity.class));
            }
        });
        Button.get(2).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this,ThreeActivity.class));
            }
        });
        Button.get(3).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this,FourActivity.class));
            }
        });
    }

    @Override
    public void initToolbar() {

    }
}
