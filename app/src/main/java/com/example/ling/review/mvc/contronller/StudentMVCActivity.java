package com.example.ling.review.mvc.contronller;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

import com.example.ling.review.R;
import com.example.ling.review.mvc.StudentAdapter;
import com.example.ling.review.mvc.model.IStudentModel;
import com.example.ling.review.mvc.model.Student;
import com.example.ling.review.mvc.model.StudentModelImpl;

import java.util.List;

public class StudentMVCActivity extends AppCompatActivity implements View.OnClickListener {

    private Button mBtnAdd;
    private Button mBtnDelete;
    private IStudentModel mStudentModel;
    private ListView mListView;
    private List<Student> mStudents;
    private StudentAdapter mAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_student);
        mBtnAdd = findViewById(R.id.btn_add_student);
        mBtnDelete = findViewById(R.id.btn_delete_student);
        mListView = findViewById(R.id.lv_student);
        mBtnAdd.setOnClickListener(this);
        mBtnDelete.setOnClickListener(this);

        mStudentModel = new StudentModelImpl();
        mStudentModel.query(new IStudentModel.onQueryListener() {
            @Override
            public void onComplete(List<Student> students) {
                mStudents = students;
            }
        });

        mAdapter = new StudentAdapter(mStudents);
        mListView.setAdapter(mAdapter);
    }


    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_add_student:
                mStudentModel.addStudent(new IStudentModel.onAddStudentListener() {
                    @Override
                    public void onComplete() {
                        mAdapter.notifyDataSetChanged();
                    }
                });
                break;

            case R.id.btn_delete_student:
                mStudentModel.deleteStudent(new IStudentModel.onDeleteStudentListener() {
                    @Override
                    public void onComplete() {
                        mAdapter.notifyDataSetChanged();
                    }
                });
                break;
            default:
                break;
        }
    }
}
