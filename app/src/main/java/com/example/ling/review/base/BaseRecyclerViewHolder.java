package com.example.ling.review.base;


import android.graphics.Bitmap;
import android.support.annotation.ColorRes;
import android.support.v7.widget.RecyclerView;
import android.util.SparseArray;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class BaseRecyclerViewHolder extends RecyclerView.ViewHolder {

    private SparseArray<View> viewArray;//缓存view

    public BaseRecyclerViewHolder(View view) {
        super(view);
        viewArray = new SparseArray<>();
    }


    /**
     * 根据传入的view id找view
     *
     * @param viewId
     * @param <T>
     * @return
     */
    public <T extends View> T getView(int viewId) {
        View view = viewArray.get(viewId);
        if (view == null) {
            view = itemView.findViewById(viewId);
            viewArray.put(viewId, view);
        }
        return (T) view;
    }


    public View getItemView() {
        return itemView;
    }


    /**
     * 为TextView设置CharSequence
     *
     * @param viewId
     * @param text
     * @return
     */
    public BaseRecyclerViewHolder setText(int viewId, CharSequence text) {
        TextView view = getView(viewId);
        view.setText(text);
        return this;
    }

    /**
     * 为TextView设置字体颜色
     *
     * @param viewId
     * @param colorId R.color.xxxx
     * @return
     */
    public BaseRecyclerViewHolder setTextColor(int viewId, @ColorRes int colorId) {
        TextView view = getView(viewId);
        view.setTextColor(view.getContext().getResources().getColor(colorId));
        return this;
    }

    /**
     * 为ImageView设置图片
     *
     * @param viewId
     * @param drawableId
     * @return
     */
    public BaseRecyclerViewHolder setImageResource(int viewId, int drawableId) {
        ImageView view = getView(viewId);
        view.setImageResource(drawableId);
        return this;
    }

    /**
     * 为ImageView设置图片
     *
     * @param viewId
     * @param bm
     * @return
     */
    public BaseRecyclerViewHolder setImageBitmap(int viewId, Bitmap bm) {
        ImageView view = getView(viewId);
        view.setImageBitmap(bm);
        return this;
    }

    /**
     * 设置View的显示隐藏
     *
     * @param viewId
     * @param isVisible
     * @return
     */
    public BaseRecyclerViewHolder setVisible(int viewId, boolean isVisible) {
        View view = getView(viewId);
        if (view != null) {
            view.setVisibility(isVisible ? View.VISIBLE : View.GONE);
        }
        return this;
    }

    /**
     * 设置字体的颜色
     *
     * @param viewId
     * @param
     * @return
     */
    public BaseRecyclerViewHolder setColor(int viewId, int color) {
        TextView view = getView(viewId);
        view.setTextColor(view.getContext().getResources().getColor(color));
        return this;
    }

    /**
     * 设置View的监听事件
     *
     * @param viewId
     * @param listener
     * @return
     */
    public BaseRecyclerViewHolder setOnClickListener(int viewId, View.OnClickListener listener) {
        View view = getView(viewId);
        if (view != null) {
            view.setOnClickListener(listener);
        }
        return this;
    }
}