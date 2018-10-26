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

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private TabLayout tabLayout;

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
        tabLayout.setOnClickListener(this);

        mFragmentTransaction = mFragmentManager.beginTransaction();
        mFragmentTransaction.add(R.id.container, mWriteFragment, "ONE");
        mFragmentTransaction.commit();

        initTab();
    }

    private void initTab() {
        List<String> textList = new ArrayList();
        textList.add("记账");
        textList.add("账户");
        textList.add("我的");
        List<Integer> iconList = new ArrayList();
        iconList.add(R.mipmap.write);
        iconList.add(R.mipmap.account);
        iconList.add(R.mipmap.mine);
        for (int i = 0; i < 3; i++) {
            tabLayout.addTab(tabLayout.newTab());
            TabLayout.Tab itemTab = tabLayout.getTabAt(i);
            if (itemTab != null) {
                itemTab.setCustomView(R.layout.item_main_tab_layout);
                View icon = itemTab.getCustomView().findViewById(R.id.icon);
                icon.setBackgroundResource(iconList.get(i));
                TextView itemTv = itemTab.getCustomView().findViewById(R.id.text);
                itemTv.setText(textList.get(i));
            }
        }
//        tabLayout.getTabAt(0).getCustomView().setSelected(true);
    }

    @Override
    public void onClick(View view) {

        Fragment fragment = mWriteFragment;
        switch (view.getId()) {
//            case R.id.write_layout:
//                write_view.setBackgroundResource(R.mipmap.write1);
//                write_text.setTextColor(getResources().getColor(R.color.text_red));
//                fragment = mWriteFragment;
//                break;
//            case R.id.account_layout:
//                account_view.setBackgroundResource(R.mipmap.account1);
//                account_text.setTextColor(getResources().getColor(R.color.text_red));
//                fragment = mAccountFragment;
//                break;
//            case R.id.mine_layout:
//                mine_view.setBackgroundResource(R.mipmap.mine1);
//                mine_text.setTextColor(getResources().getColor(R.color.text_red));
//                fragment = mMineFragment;
//                break;
        }
        mFragmentTransaction = mFragmentManager.beginTransaction();
        mFragmentTransaction.replace(R.id.container, fragment, "TWO");
        mFragmentTransaction.commit();
    }
}