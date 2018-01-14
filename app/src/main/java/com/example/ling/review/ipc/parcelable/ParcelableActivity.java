package com.example.ling.review.ipc.parcelable;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.Toast;

import com.example.ling.review.R;


public class ParcelableActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_parcelable);
        final Intent intent = getIntent();
        final User3 user = intent.getParcelableExtra("user");
        Toast.makeText(this, user.toString(), Toast.LENGTH_SHORT).show();
    }
}
