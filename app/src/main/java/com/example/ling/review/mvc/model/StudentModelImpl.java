package com.example.ling.review.mvc.model;

import com.example.ling.review.R;

import java.util.ArrayList;
import java.util.List;

/**
 * ***************************************
 * statement: 数据模型层
 * author: LingGuiQin
 * date created : 2018/2/28 0028
 * ***************************************
 */
public class StudentModelImpl implements IStudentModel {

    private static List<Student> list = new ArrayList<>();

    static {
        list.add(new Student("小张", R.mipmap.ic_launcher));
        list.add(new Student("小明", R.mipmap.ic_launcher));
        list.add(new Student("小红", R.mipmap.ic_launcher));
    }

    @Override
    public void query(onQueryListener listener) {
        if (listener != null) {
            listener.onComplete(list);
        }
    }

    @Override
    public void addStudent(onAddStudentListener listener) {
        list.add(new Student("小凌", R.mipmap.ic_launcher));
        if (listener != null) {
            listener.onComplete();
        }
    }

    @Override
    public void deleteStudent(onDeleteStudentListener listener) {

        if (!list.isEmpty()) {
            list.remove(list.size() - 1);
        }

        if (listener != null) {
            listener.onComplete();
        }
    }
}
