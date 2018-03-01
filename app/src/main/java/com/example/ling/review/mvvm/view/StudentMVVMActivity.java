package com.example.ling.review.mvvm.view;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Adapter;
import android.widget.Toast;

import com.example.ling.review.R;
import com.example.ling.review.databinding.ActivityStudentMvvmBinding;
import com.example.ling.review.mvc.model.IStudentModel;
import com.example.ling.review.mvc.model.Student;
import com.example.ling.review.mvc.model.StudentModelImpl;
import com.example.ling.review.mvvm.StudentMVVMAdapter;

import java.util.List;

public class StudentMVVMActivity extends AppCompatActivity {

    private ActivityStudentMvvmBinding mDataBinding;
    IStudentModel mStudentModel;
    private StudentMVVMAdapter mAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // 创建 StudentModelImpl
        mStudentModel = new StudentModelImpl();
        // 使用DataBinding
        mDataBinding = DataBindingUtil.setContentView(this, R.layout.activity_student_mvvm);
        mDataBinding.setController(new Controller());

        mStudentModel.query(new IStudentModel.onQueryListener() {
            @Override
            public void onComplete(List<Student> students) {
                mAdapter = new StudentMVVMAdapter(students);
                mDataBinding.lvStudent.setAdapter(mAdapter);
            }
        });
    }


    public class Controller {

        public void onClickAdd(View view) {
            mStudentModel.addStudent(new IStudentModel.onAddStudentListener() {
                @Override
                public void onComplete() {
                    mAdapter.notifyDataSetChanged();
                }
            });
        }

        public void onClickDelete(View view) {
            mStudentModel.deleteStudent(new IStudentModel.onDeleteStudentListener() {
                @Override
                public void onComplete() {
                    mAdapter.notifyDataSetChanged();
                }
            });
        }
    }
}
