package com.samfdl.jizhang;

import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private LinearLayout write_layout, account_layout, mine_layout;
    private View write_view, account_view, mine_view;
    private TextView write_text, account_text, mine_text;

    private FragmentManager mFragmentManager = getFragmentManager();
    private FragmentTransaction mFragmentTransaction;

    private WriteFragment mWriteFragment = new WriteFragment();
    private AccountFragment mAccountFragment = new AccountFragment();
    private MineFragment mMineFragment = new MineFragment();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        write_layout = findViewById(R.id.write_layout);
        write_layout.setOnClickListener(this);
        account_layout = findViewById(R.id.account_layout);
        account_layout.setOnClickListener(this);
        mine_layout = findViewById(R.id.mine_layout);
        mine_layout.setOnClickListener(this);

        write_view = findViewById(R.id.write_view);
        account_view = findViewById(R.id.account_view);
        mine_view = findViewById(R.id.mine_view);

        write_text = findViewById(R.id.write_text);
        account_text = findViewById(R.id.account_text);
        mine_text = findViewById(R.id.mine_text);

        mFragmentTransaction = mFragmentManager.beginTransaction();
        mFragmentTransaction.add(R.id.container, mWriteFragment, "ONE");
        mFragmentTransaction.commit();
    }

    @Override
    public void onClick(View view) {
        write_view.setBackgroundResource(R.mipmap.write);
        account_view.setBackgroundResource(R.mipmap.account);
        mine_view.setBackgroundResource(R.mipmap.mine);

        write_text.setTextColor(getResources().getColor(R.color.text_gray));
        account_text.setTextColor(getResources().getColor(R.color.text_gray));
        mine_text.setTextColor(getResources().getColor(R.color.text_gray));

        Fragment fragment = mWriteFragment;
        switch (view.getId()) {
            case R.id.write_layout:
                write_view.setBackgroundResource(R.mipmap.write1);
                write_text.setTextColor(getResources().getColor(R.color.text_red));
                fragment = mWriteFragment;
                break;
            case R.id.account_layout:
                account_view.setBackgroundResource(R.mipmap.account1);
                account_text.setTextColor(getResources().getColor(R.color.text_red));
                fragment = mAccountFragment;
                break;
            case R.id.mine_layout:
                mine_view.setBackgroundResource(R.mipmap.mine1);
                mine_text.setTextColor(getResources().getColor(R.color.text_red));
                fragment = mMineFragment;
                break;
        }
        mFragmentTransaction = mFragmentManager.beginTransaction();
        mFragmentTransaction.replace(R.id.container, fragment, "TWO");
        mFragmentTransaction.commit();
    }
}