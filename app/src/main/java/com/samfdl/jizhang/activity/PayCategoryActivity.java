package com.samfdl.jizhang.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.LinearLayout;

import com.samfdl.jizhang.R;
import com.samfdl.jizhang.adapter.PayCategoryAdapter;

import java.util.ArrayList;
import java.util.List;

public class PayCategoryActivity extends AppCompatActivity implements View.OnClickListener {
    // 左上角返回按钮
    private LinearLayout back;

    private RecyclerView categoryList;

    private RecyclerView category;

    private PayCategoryAdapter payCategoryAdapter;
    private List<String> listData = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pay_category);

        back = findViewById(R.id.back);
        back.setOnClickListener(this);

        categoryList = findViewById(R.id.categoryList);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        categoryList.setLayoutManager(linearLayoutManager);

        listData.add("常用");
        listData.add("餐饮");
        listData.add("交通");
        payCategoryAdapter = new PayCategoryAdapter(this, listData);
        categoryList.setAdapter(payCategoryAdapter);

        category = findViewById(R.id.category);
//        category.setLayoutManager(linearLayoutManager);
    }

    @Override
    public void onClick(View v) {
        finish();
    }
}