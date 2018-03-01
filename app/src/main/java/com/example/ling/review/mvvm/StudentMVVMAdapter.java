package com.example.ling.review.mvvm;

import android.databinding.DataBindingUtil;
import android.databinding.ViewDataBinding;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.android.databinding.library.baseAdapters.BR;
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
public class StudentMVVMAdapter extends BaseAdapter {

    private List<Student> mStudents;

    public StudentMVVMAdapter(List<Student> students) {
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
            LayoutInflater inflater = LayoutInflater.from(parent.getContext());
            ViewDataBinding binding = DataBindingUtil.inflate(inflater, R.layout.item_student_mvvm, parent, false);
            itemView = binding.getRoot();
            viewHolder.mViewDataBinding = binding;
            itemView.setTag(viewHolder);
        } else {
            itemView = convertView;
            viewHolder = (ViewHolder) itemView.getTag();
        }
        viewHolder.mViewDataBinding.setVariable(BR.student, mStudents.get(position));
        viewHolder.mViewDataBinding.executePendingBindings();
        return itemView;
    }


    class ViewHolder {
        public ViewDataBinding mViewDataBinding;
    }
}
