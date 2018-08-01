package com.wanda.advancedlight.view;

import android.animation.Animator;
import android.animation.AnimatorInflater;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.wanda.advancedlight.BaseActivity;
import com.wanda.advancedlight.R;
import com.wanda.advancedlight.presenter.CustomView;
import com.wanda.advancedlight.presenter.TitleBar;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by PC on 2018/7/31.
 */

public class ViewSlidingActivity extends BaseActivity {

    @BindView(R.id.custom_view)
    CustomView mCustomView;
    @BindView(R.id.textview)
    TextView textView;
    @BindView(R.id.title)
    TitleBar titleBar;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_viewsliding);
        ButterKnife.bind(this);
        initView();
    }

    @Override
    public void initView() {
        titleBar.setTitle("自定义组合控件");
        titleBar.setLeftListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(ViewSlidingActivity.this, "点击左键", Toast.LENGTH_SHORT).show();
            }
        });
        titleBar.setRightListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(ViewSlidingActivity.this, "点击确定", Toast.LENGTH_SHORT).show();
            }
        });

//      在xml中使用属性东西
        Animator animator = AnimatorInflater.loadAnimator(this,R.animator.scale);
        animator.setTarget(mCustomView);
        animator.start();


//        //View动画
//        Animation animation = AnimationUtils.loadAnimation(this,R.anim.translate);
//        mCustomView.setAnimation(animation);

//        //属性动画
//        ObjectAnimator.ofFloat(textView,"translationX",0,300,0).setDuration(10000).start();

//        //组合动画
//        ObjectAnimator mObjectAnimator = ObjectAnimator.ofFloat(textView,"translationX",0,300);
//        ObjectAnimator mObjectAnimator1 = ObjectAnimator.ofFloat(textView,"scaleX",0,3);
//        ObjectAnimator mObjectAnimator3 = ObjectAnimator.ofFloat(textView,"rotationX",100,203);
//        AnimatorSet set = new AnimatorSet();
//        set.setDuration(10000);
//        set.play(mObjectAnimator).with(mObjectAnimator1).after(mObjectAnimator3);
//        set.start();
//

//        //动画的监听
//        ObjectAnimator mObjectAnimator = ObjectAnimator.ofFloat(textView,"translationX",0,300);
//        mObjectAnimator.addListener(new Animator.AnimatorListener() {
//            @Override
//            public void onAnimationStart(Animator animation) {
//                textView.setText("开始");
//            }
//
//            @Override
//            public void onAnimationEnd(Animator animation) {
//                textView.setText("开始1");
//            }
//
//            @Override
//            public void onAnimationCancel(Animator animation) {
//
//            }
//
//            @Override
//            public void onAnimationRepeat(Animator animation) {
//
//            }
//        });
//        mObjectAnimator.setDuration(10000);
//        mObjectAnimator.start();


//        //ValueAnimator 数值发生器（栗子：支付宝数字的变化）
//        ValueAnimator mValueAnimator = ValueAnimator.ofInt(0,100);
//        mValueAnimator.setTarget(mCustomView);
//        mValueAnimator.setDuration(10000).start();
//        mValueAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
//            @Override
//            public void onAnimationUpdate(ValueAnimator animation) {
////                Float mFloat = (Float) animation.getAnimatedValue();
//                int value = (Integer)animation.getAnimatedValue(); //获取动画的值
//                textView.setText(value+"");
//
//            }
//        });
//        mValueAnimator.start();
    }

    @Override
    public void initToolbar() {

    }
}
