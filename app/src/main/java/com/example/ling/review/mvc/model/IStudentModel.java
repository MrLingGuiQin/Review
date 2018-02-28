package com.example.ling.review.mvc.model;

import java.util.List;

/**
 * ***************************************
 * statement:
 * author: LingGuiQin
 * date created : 2018/2/28 0028
 * ***************************************
 */
public interface IStudentModel {

    /**
     * 查询所有学生
     * @param listener
     */
    void query(onQueryListener listener);

    /**
     * 添加学生
     * @param listener
     */
    void addStudent(onAddStudentListener listener);

    /**
     * 删除学生
     * @param listener
     */
    void deleteStudent(onDeleteStudentListener listener);

    /**
     * 查询学生回调
     */
    interface onQueryListener{
        void onComplete(List<Student> students);
    }

    /**
     * 添加学生回调
     */
    interface onAddStudentListener{
        void onComplete();
    }

    /**
     * 删除学生回调
     */
    interface onDeleteStudentListener{
        void onComplete();
    }

}
