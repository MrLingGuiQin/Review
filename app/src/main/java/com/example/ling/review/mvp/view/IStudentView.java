package com.example.ling.review.mvp.view;

import com.example.ling.review.mvc.model.Student;

import java.util.List;

/**
 * ***************************************
 * statement:
 * author: LingGuiQin
 * date created : 2018/2/28 0028
 * ***************************************
 */
public interface IStudentView {

    // 展示学生数据
    void showStudents(List<Student> studentList);

    // 刷新学生数据
    void refreshStudents();

}
