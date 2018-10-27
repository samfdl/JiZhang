package com.samfdl.jizhang;

import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private TabLayout tabLayout;

    private List<Integer> iconList = new ArrayList();
    private List<Integer> iconList1 = new ArrayList();

    private FragmentManager mFragmentManager = getSupportFragmentManager();
    private FragmentTransaction mFragmentTransaction;

    private WriteFragment mWriteFragment = new WriteFragment();
    private AccountFragment mAccountFragment = new AccountFragment();
    private MineFragment mMineFragment = new MineFragment();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tabLayout = findViewById(R.id.tabLayout);

        initTab();

        tabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                View icon = tab.getCustomView().findViewById(R.id.icon);
                icon.setBackgroundResource(iconList1.get(tab.getPosition()));
                TextView itemTv = tab.getCustomView().findViewById(R.id.text);
                itemTv.setTextColor(getResources().getColor(R.color.text_red));

                Fragment fragment = mWriteFragment;
                switch (tab.getPosition()) {
                    case 0:
                        fragment = mWriteFragment;
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
                View icon = tab.getCustomView().findViewById(R.id.icon);
                icon.setBackgroundResource(iconList.get(tab.getPosition()));
                TextView itemTv = tab.getCustomView().findViewById(R.id.text);
                itemTv.setTextColor(getResources().getColor(R.color.text_gray));
            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {
            }
        });
        tabLayout.getTabAt(0).select();
    }

    private void initTab() {
        List<String> textList = new ArrayList();
        textList.add("记账");
        textList.add("账户");
        textList.add("我的");
        iconList.add(R.mipmap.write);
        iconList.add(R.mipmap.account);
        iconList.add(R.mipmap.mine);
        iconList1.add(R.mipmap.write1);
        iconList1.add(R.mipmap.account1);
        iconList1.add(R.mipmap.mine1);
        for (int i = 0; i < 3; i++) {
            tabLayout.addTab(tabLayout.newTab(), false);
            TabLayout.Tab itemTab = tabLayout.getTabAt(i);
            if (itemTab != null) {
                itemTab.setCustomView(R.layout.item_main_tab_layout);
                View icon = itemTab.getCustomView().findViewById(R.id.icon);
                icon.setBackgroundResource(iconList.get(i));
                TextView itemTv = itemTab.getCustomView().findViewById(R.id.text);
                itemTv.setText(textList.get(i));
            }
        }
    }
}