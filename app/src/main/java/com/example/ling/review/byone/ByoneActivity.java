package com.example.ling.review.byone;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.constraint.ConstraintLayout;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.example.ling.review.R;

/**
 * ***************************************
 * statement:
 * author: LingGuiQin
 * date created : 2018/4/1 0001
 * ***************************************
 */
public class ByoneActivity extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.byone_view);
        ImageView imageView = findViewById(R.id.blue_arrow);
        ConstraintLayout.LayoutParams layoutParams = (ConstraintLayout.LayoutParams) imageView.getLayoutParams();
        layoutParams.horizontalBias = 0.75F;
        imageView.setLayoutParams(layoutParams);
    }



}
