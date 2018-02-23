package com.example.ling.review.listview;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.ling.review.R;

import java.util.List;


/**
 * ***************************************
 * statement:
 * author: LingGuiQin
 * date created : 2018/2/8 0008
 * ***************************************
 */
public class MyAdapter extends BaseAdapter {

    private List<String> mData;

    public MyAdapter(List<String> data) {
        mData = data;
    }

    /**
     * 设置item的数量
     *
     * @return item的数量
     */
    @Override
    public int getCount() {
        return mData.size();
    }

    /**
     * 根据position 获取item数据
     *
     * @param position 位置
     * @return
     */
    @Override
    public String getItem(int position) {
        return mData.get(position);
    }

    /**
     * 根据position获取Item的id
     *
     * @param position 位置
     * @return
     */
    @Override
    public long getItemId(int position) {
        return position;
    }

    /**
     * 设置item显示的View
     *
     * @param position    位置
     * @param convertView 未显示在屏幕上的旧View
     * @param parent      listView
     * @return item填充的view
     */
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        View itemView = null;
        ViewHolder viewHolder = null;

        // 如果当前的convertView为null，则通过inflate产生一个view
        if (convertView == null) {
            itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_list_view, parent, false);
            // 创建ViewHolder对象，减少findViewById的次数
            viewHolder = new ViewHolder();
            viewHolder.textView = (TextView) itemView.findViewById(R.id.item_text);
            //用setTag的方法把viewHolder与itemView "绑定"在一起
            itemView.setTag(viewHolder);
        } else {
            // 如果当前的convertView !=null，则复用convertView
            itemView = convertView;
            viewHolder = (ViewHolder) itemView.getTag();
        }
        // textView设置文本信息
        viewHolder.textView.setText(mData.get(position));
        return itemView;
    }

    /**
     * ViewHolder内部类
     */
    public class ViewHolder {
        public TextView textView;
    }
}
