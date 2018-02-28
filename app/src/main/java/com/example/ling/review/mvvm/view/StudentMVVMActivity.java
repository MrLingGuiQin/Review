package com.example.ling.review.mvvm.view;

import android.databinding.DataBindingUtil;
import android.databinding.ViewDataBinding;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.ling.review.R;

public class StudentMVVMActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // 使用DataBinding
       DataBindingUtil.setContentView(this, R.layout.activity_student_mvvm);
    }
}
