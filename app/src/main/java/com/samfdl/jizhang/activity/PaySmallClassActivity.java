package com.samfdl.jizhang.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.LinearLayout;

import com.samfdl.jizhang.App;
import com.samfdl.jizhang.R;
import com.samfdl.jizhang.adapter.SmallClassAdapter;
import com.samfdl.jizhang.database.DaoSession;
import com.samfdl.jizhang.database.SmallClass;
import com.samfdl.jizhang.database.SmallClassDao;

import java.util.ArrayList;
import java.util.List;

/**
 * 支出小类别管理
 */
public class PaySmallClassActivity extends AppCompatActivity implements View.OnClickListener {
    // 左上角返回按钮
    private LinearLayout back;

    private RecyclerView classList;

    private List<SmallClass> listData = new ArrayList<>();

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
        SmallClassDao smallClassDao = daoSession.getSmallClassDao();
        listData = smallClassDao.queryBuilder().where(SmallClassDao.Properties.BigclassId.eq(
                getIntent().getLongExtra("bigclassId", 0))).list();
        SmallClassAdapter smallClassAdapter = new SmallClassAdapter(listData);
        smallClassAdapter.setOnItemClickListener(new SmallClassAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(View view, int position) {
//                Intent intent = new Intent(PaySmallClassActivity.this, PaySmallClassActivity.class);
//                switch (position) {
//                    case 1:
//                        intent = new Intent(PaySmallClassActivity.this, PaySmallClassActivity.class);
//                        break;
//                }
//                startActivity(intent);
            }
        });
        classList.setAdapter(smallClassAdapter);
    }

    @Override
    public void onClick(View v) {
        finish();
    }
}