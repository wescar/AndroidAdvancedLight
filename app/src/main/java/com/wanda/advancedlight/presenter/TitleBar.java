package com.wanda.advancedlight.presenter;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Color;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.wanda.advancedlight.R;

/**
 * Created by PC on 2018/8/1.
 */

public class TitleBar extends RelativeLayout {

    private ImageView iv_titleBar_left;
    private TextView tv_titleBar_title;
    private TextView tv_titleBar_right;
    private RelativeLayout layout_titleBar_rootLayout;
    private int mColor = Color.BLUE;
    private String titleName = "";
    private int mTextColor = Color.WHITE;

    public TitleBar(Context context) {
        super(context);
        initView(context);
    }



    public TitleBar(Context context, AttributeSet attrs) {
        super(context, attrs);
        TypedArray mTypedArray = context.obtainStyledAttributes(attrs,R.styleable.TitleBar);
        mColor = mTypedArray.getColor(R.styleable.TitleBar_title_bg,Color.BLUE);
        mTextColor = mTypedArray.getColor(R.styleable.TitleBar_title_text_color,Color.WHITE);
        titleName = mTypedArray.getString(R.styleable.TitleBar_title_text);
        mTypedArray.recycle();

        initView(context);
    }

    public TitleBar(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        initView(context);
    }

    private void initView(Context context) {

        LayoutInflater.from(context).inflate(R.layout.top_title_bar,this,true);
        iv_titleBar_left = (ImageView) findViewById(R.id.iv_titleBar_left);
        tv_titleBar_title = (TextView) findViewById(R.id.tv_titleBar_title);
        tv_titleBar_right = (TextView) findViewById(R.id.tv_titleBar_right);
        layout_titleBar_rootLayout = (RelativeLayout) findViewById(R.id.layout_titleBar_rootLayout);
        layout_titleBar_rootLayout.setBackgroundColor(mColor);
        tv_titleBar_title.setTextColor(mTextColor);

    }

    public void setTitle(String titleName){
        if (!TextUtils.isEmpty(titleName)){
            tv_titleBar_title.setText(titleName);
        }
    }
    public void setLeftListener(OnClickListener onClickListener){
        iv_titleBar_left.setOnClickListener(onClickListener);

    }
    public void setRightListener(OnClickListener onClickListener){
        tv_titleBar_right.setOnClickListener(onClickListener);
    }
}
