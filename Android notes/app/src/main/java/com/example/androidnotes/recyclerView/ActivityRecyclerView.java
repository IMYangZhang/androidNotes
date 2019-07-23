package com.example.androidnotes.recyclerView;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.example.androidnotes.R;
import com.example.androidnotes.recyclerView.adapter.firtstAdapter;
import com.example.androidnotes.recyclerView.model.DataInfo;

import java.util.ArrayList;
import java.util.List;

public class ActivityRecyclerView extends AppCompatActivity {

    private RecyclerView recyclerView;
    private List<DataInfo> lists;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recycler_view);
        recyclerView = findViewById(R.id.my_recyclerView);
        initData();
        initView();
    }

    private void initData(){
        lists = new ArrayList<>();
        lists.add(new DataInfo("a"));
        lists.add(new DataInfo("b"));
        lists.add(new DataInfo("c"));
        lists.add(new DataInfo("d"));
    }

    private void initView(){
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this); // 定义一个线性布局管理器
        recyclerView.setLayoutManager(linearLayoutManager); //  设置布局管理器
        recyclerView.setAdapter(new firtstAdapter(this,lists)); // 设置adapter
        // 设置动画
        // 设置分割线
    }
}
