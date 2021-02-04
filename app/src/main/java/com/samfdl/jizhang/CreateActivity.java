package com.samfdl.jizhang;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;

import com.samfdl.jizhang.database.BigClass;
import com.samfdl.jizhang.database.BigClassDao;
import com.samfdl.jizhang.database.DaoSession;

import java.util.ArrayList;
import java.util.List;

public class CreateActivity extends AppCompatActivity {
    private TabLayout tabLayout;

    private FragmentManager mFragmentManager = getSupportFragmentManager();
    private FragmentTransaction mFragmentTransaction;

    private PayFragment mPayFragment = new PayFragment();
    private AccountFragment mAccountFragment = new AccountFragment();
    private MineFragment mMineFragment = new MineFragment();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create);

        tabLayout = findViewById(R.id.tabLayout);

        initTab();

        initUser();
    }

    private void initTab() {
        List<String> textList = new ArrayList();
        textList.add("支出");
        textList.add("收入");
        textList.add("转账");
        textList.add("借贷");
        for (int i = 0; i < 4; i++) {
            tabLayout.addTab(tabLayout.newTab(), false);
            TabLayout.Tab itemTab = tabLayout.getTabAt(i);
            if (itemTab != null) {
                itemTab.setText(textList.get(i));
            }
        }

        tabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                Fragment fragment = mPayFragment;
                switch (tab.getPosition()) {
                    case 0:
                        fragment = mPayFragment;
                        break;
                    case 1:
                        fragment = mAccountFragment;
                        break;
                    case 2:
                        fragment = mMineFragment;
                        break;
                }
                mFragmentTransaction = mFragmentManager.beginTransaction();
                mFragmentTransaction.replace(R.id.container, fragment, "TWO");
                mFragmentTransaction.commit();
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {
            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {
            }
        });
        tabLayout.getTabAt(0).select();
    }

    private void initUser() {
        DaoSession daoSession = ((App) getApplication()).getDaoSession();
        BigClassDao bigClassDao = daoSession.getBigClassDao();

        String bigClasses[] = {"费用", "用品", "行路", "食物", "住宿", "衣服", "购物", "娱乐", "医教", "居家", "人情"};
        for (int i = 0; i < bigClasses.length; i++) {
            BigClass bigClass = new BigClass();
            bigClass.setClassName(bigClasses[i]);
            bigClassDao.insert(bigClass);
        }
    }
}