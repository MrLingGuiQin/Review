package com.example.ling.review.listview;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ListView;

import com.example.ling.review.R;

import java.util.ArrayList;
import java.util.List;

public class ListViewActivity extends AppCompatActivity {

    private ListView mListView;
    private List<String> mData;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_view);
        mListView = findViewById(R.id.list_view);

        //创建40条数据
        mData = new ArrayList<>();
        for (int i = 0; i < 40; i++) {
            mData.add("我是数据" + i);
        }

        // 设置adapter
        mListView.setAdapter(new MyAdapter(mData));
    }

}
