package com.example.ling.review.view;

import android.content.Context;
import android.util.AttributeSet;
import android.util.Log;
import android.util.SparseArray;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.Scroller;

import com.example.ling.review.R;

/**
 * ***************************************
 * statement: 自定义ViewPager
 * author: LingGuiQin
 * date created : 2018/3/10 0010
 * ***************************************
 */
public class MyViewPager extends ViewGroup {

    private int[] images = new int[]{R.mipmap.launcher_01, R.mipmap.launcher_02, R.mipmap.launcher_03,
            R.mipmap.launcher_04, R.mipmap.launcher_05};

    private GestureDetector mDetector;
    private Scroller mScroller;

    public MyViewPager(Context context) {
        super(context);
        initView();
    }

    public MyViewPager(Context context, AttributeSet attrs) {
        super(context, attrs);
        initView();
    }

    public MyViewPager(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        initView();
    }

    private void initView() {
        for (int image : images) {
            ImageView imageView = new ImageView(getContext());
            imageView.setBackgroundResource(image);
            this.addView(imageView);
        }

        mDetector = new GestureDetector(getContext(), new GestureDetector.SimpleOnGestureListener() {
            @Override
            public boolean onScroll(MotionEvent e1, MotionEvent e2, float distanceX, float distanceY) {
                scrollBy((int) distanceX, 0);
                return super.onScroll(e1, e2, distanceX, distanceY);
            }
        });

        mScroller = new Scroller(getContext());
    }

    @Override
    protected void onLayout(boolean changed, int l, int t, int r, int b) {
        for (int i = 0; i < images.length; i++) {
            this.getChildAt(i).layout(i * getWidth(), t, (i + 1) * getWidth(), b);
        }
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        mDetector.onTouchEvent(event);
        switch (event.getAction()) {
            case MotionEvent.ACTION_DOWN:
                break;
            case MotionEvent.ACTION_MOVE:
                break;
            case MotionEvent.ACTION_UP:
                int scrollX = getScrollX();
                //你滑动的距离加上屏幕的一半，除以屏幕宽度，如果你滑动距离超过了屏幕的一半，这个pos就加1
                int pos = (scrollX + getWidth() / 2) / getWidth();
                Log.e("ScrollX = ", "pos = " + pos + " scrollX = " + scrollX + "  ;getWidth =" + getWidth());
                //滑到最后一张的时候，不能出边界
                if (pos >= images.length) {
                    pos = images.length - 1;
                }

                //绝对滑动，直接滑到指定的x值
                //scrollTo(pos * getWidth(), 0);
                //自然滑动,从手滑到的地方开始，滑动距离是页面宽度减去滑到的距离，时间由路程的大小来决定
                mScroller.startScroll(scrollX, 0, pos * getWidth() - scrollX, 0, Math.abs(pos * getWidth()));
                invalidate();
                break;
            default:
                break;
        }
        return true;
    }

    @Override
    public void computeScroll() {
        if (mScroller.computeScrollOffset()) {
            scrollTo(mScroller.getCurrX(), 0);
            postInvalidate();
        }
    }
}
