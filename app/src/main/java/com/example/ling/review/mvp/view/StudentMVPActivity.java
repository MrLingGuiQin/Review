package com.example.ling.review.mvp.view;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;

import com.example.ling.review.R;
import com.example.ling.review.mvc.StudentAdapter;
import com.example.ling.review.mvc.model.IStudentModel;
import com.example.ling.review.mvc.model.Student;
import com.example.ling.review.mvc.model.StudentModelImpl;
import com.example.ling.review.mvp.presenter.StudentPresenter;

import java.util.List;

public class StudentMVPActivity extends AppCompatActivity implements View.OnClickListener, IStudentView {

    private Button mBtnAdd;
    private Button mBtnDelete;
    private ListView mListView;
    private StudentAdapter mAdapter;
    private StudentPresenter mStudentPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_student);
        mBtnAdd = findViewById(R.id.btn_add_student);
        mBtnDelete = findViewById(R.id.btn_delete_student);
        mListView = findViewById(R.id.lv_student);
        mBtnAdd.setOnClickListener(this);
        mBtnDelete.setOnClickListener(this);

        // 创建中间者
        mStudentPresenter = new StudentPresenter(this);

        // 通过中间者去请求查询学生数据
        mStudentPresenter.queryStudents();
    }

    @Override
    public void showStudents(List<Student> studentList) {
        mAdapter = new StudentAdapter(studentList);
        mListView.setAdapter(mAdapter);
    }

    @Override
    public void refreshStudents() {
        mAdapter.notifyDataSetChanged();
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_add_student:
                mStudentPresenter.addStudent();
                break;

            case R.id.btn_delete_student:
                mStudentPresenter.deleteStudent();
                break;
            default:
                break;
        }
    }
}
