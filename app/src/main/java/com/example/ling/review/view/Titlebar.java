package com.example.ling.review.view;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Color;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.example.ling.review.R;


/**
 * ***************************************
 * statement:
 * author: LingGuiQin
 * date created : 2018/3/10 0010
 * ***************************************
 */
public class Titlebar extends RelativeLayout {
    private View mRootView;
    private TextView mTextView;
    private int mTextColor;
    private int mBackground;
    private String mText;

    public Titlebar(Context context) {
        this(context, null);
    }


    public Titlebar(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public Titlebar(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        TypedArray array = context.obtainStyledAttributes(attrs, R.styleable.titlebar);
        mTextColor = array.getColor(R.styleable.titlebar_title_color, Color.WHITE);
        mBackground = array.getColor(R.styleable.titlebar_background_color, Color.BLUE);
        mText = array.getString(R.styleable.titlebar_title_text);
        array.recycle();
        initView();
    }

    private void initView() {
        LayoutInflater.from(getContext()).inflate(R.layout.title_bar, this);
        mRootView = findViewById(R.id.view_title_root);
        mTextView = findViewById(R.id.txt_title_text);
        mRootView.setBackgroundColor(mBackground);
        mTextView.setText(mText);
        mTextView.setTextColor(mTextColor);
    }
}
