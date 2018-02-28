package com.example.ling.review.mvp.presenter;

import com.example.ling.review.mvc.model.IStudentModel;
import com.example.ling.review.mvc.model.Student;
import com.example.ling.review.mvc.model.StudentModelImpl;
import com.example.ling.review.mvp.view.IStudentView;

import java.util.ArrayList;
import java.util.List;

/**
 * ***************************************
 * statement:
 * author: LingGuiQin
 * date created : 2018/2/28 0028
 * ***************************************
 */
public class StudentPresenter {

    IStudentView mStudentView;
    IStudentModel mStudentModel;

    public StudentPresenter(IStudentView studentView) {
        mStudentView = studentView;
        mStudentModel = new StudentModelImpl();
    }


    public void queryStudents() {
        mStudentModel.query(new IStudentModel.onQueryListener() {
            @Override
            public void onComplete(List<Student> students) {
                mStudentView.showStudents(students);
            }
        });
    }

    public void addStudent() {
        mStudentModel.addStudent(new IStudentModel.onAddStudentListener() {
            @Override
            public void onComplete() {
                mStudentView.refreshStudents();
            }
        });
    }

    public void deleteStudent() {
        mStudentModel.deleteStudent(new IStudentModel.onDeleteStudentListener() {
            @Override
            public void onComplete() {
                mStudentView.refreshStudents();
            }
        });
    }
}
