package com.wanda.advancedlight.view;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.CardView;
import android.widget.SeekBar;

import com.wanda.advancedlight.BaseActivity;
import com.wanda.advancedlight.R;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by PC on 2018/7/30.
 */

public class CardViewActivity extends BaseActivity {

    @BindView(R.id.card_item)
    CardView mCareView;
    @BindView(R.id.sb_1)
    SeekBar seekBar1;
    @BindView(R.id.sb_2)
    SeekBar seekBar2;
    @BindView(R.id.sb_3)
    SeekBar seekBar3;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cardview);
        ButterKnife.bind(this);
        initView();
    }

    @Override
    public void initView() {

        seekBar1.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                mCareView.setRadius(progress);
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });
        seekBar2.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                mCareView.setCardElevation(progress);
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });
        seekBar3.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                mCareView.setContentPadding(progress,progress,progress,progress);
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });
    }

    @Override
    public void initToolbar() {

    }
}
