package com.example.ling.review.mvc;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.ling.review.R;
import com.example.ling.review.mvc.model.Student;

import java.util.List;

/**
 * ***************************************
 * statement:
 * author: LingGuiQin
 * date created : 2018/2/28 0028
 * ***************************************
 */
public class StudentAdapter extends BaseAdapter {

    private List<Student> mStudents;

    public StudentAdapter(List<Student> students) {
        mStudents = students;
    }

    @Override
    public int getCount() {
        return mStudents.isEmpty() ? 0 : mStudents.size();
    }

    @Override
    public Student getItem(int position) {
        return mStudents.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        ViewHolder viewHolder = null;
        View itemView = null;

        if (convertView == null) {
            viewHolder = new ViewHolder();
            itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_student, parent, false);
            viewHolder.mImageView = itemView.findViewById(R.id.img_student);
            viewHolder.mTextView = itemView.findViewById(R.id.tv_student);
            itemView.setTag(viewHolder);
        } else {
            itemView = convertView;
            viewHolder = (ViewHolder) itemView.getTag();
        }
        viewHolder.mTextView.setText(mStudents.get(position).getName());
        viewHolder.mImageView.setImageResource(mStudents.get(position).getImage());

        return itemView;
    }


    class ViewHolder {
        public TextView mTextView;
        public ImageView mImageView;
    }
}
