package com.example.ling.review;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.ling.bean.ActivityBean;
import com.example.ling.review.base.BaseRecyclerViewHolder;

import java.util.List;

/**
 * ***************************************
 * statement:
 * author: LingGuiQin
 * date created : 2018/1/29 0029
 * ***************************************
 */
public class MainAdapter extends RecyclerView.Adapter<BaseRecyclerViewHolder> {
    private List<ActivityBean> mList;

    public MainAdapter(List<ActivityBean> list) {
        mList = list;
    }

    @Override
    public BaseRecyclerViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View inflate = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_main, parent, false);
        return new BaseRecyclerViewHolder(inflate);
    }

    @Override
    public void onBindViewHolder(final BaseRecyclerViewHolder holder, int position) {
        final ActivityBean bean = mList.get(position);
        holder.setText(R.id.btn_item_main, bean.title);
        holder.setOnClickListener(R.id.btn_item_main, new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                holder.getItemView().getContext().startActivity(bean.intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return mList.size();
    }
}
