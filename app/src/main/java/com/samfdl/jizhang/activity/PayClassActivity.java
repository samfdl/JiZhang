package com.samfdl.jizhang.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.LinearLayout;

import com.samfdl.jizhang.App;
import com.samfdl.jizhang.R;
import com.samfdl.jizhang.adapter.BigClassAdapter;
import com.samfdl.jizhang.database.BigClass;
import com.samfdl.jizhang.database.BigClassDao;
import com.samfdl.jizhang.database.DaoSession;

import java.util.ArrayList;
import java.util.List;

/**
 * 支出类别管理
 */
public class PayClassActivity extends AppCompatActivity implements View.OnClickListener {
    // 左上角返回按钮
    private LinearLayout back;

    private RecyclerView classList;

    private List<BigClass> listData = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pay_class);

        back = findViewById(R.id.back);
        back.setOnClickListener(this);

        classList = findViewById(R.id.class_list);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        classList.setLayoutManager(linearLayoutManager);

        DaoSession daoSession = ((App) getApplication()).getDaoSession();
        BigClassDao bigClassDao = daoSession.getBigClassDao();
        listData = bigClassDao.queryBuilder().list();
        BigClassAdapter bigClassAdapter = new BigClassAdapter(listData);
        bigClassAdapter.setOnItemClickListener(new BigClassAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(View view, int position) {
                Intent intent = new Intent(PayClassActivity.this, PaySmallClassActivity.class);
                intent.putExtra("bigclassId", listData.get(position).getId());
                startActivity(intent);
            }
        });
        classList.setAdapter(bigClassAdapter);
    }

    @Override
    public void onClick(View v) {
        finish();
    }
}