package com.samfdl.jizhang;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.samfdl.jizhang.activity.PayClassActivity;
import com.samfdl.jizhang.adapter.MineAdapter;

import java.util.ArrayList;

/**
 * Created by sam on 2017/12/1.
 */
public class MineFragment extends Fragment {
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_mine, container, false);

        RecyclerView recyclerView = rootView.findViewById(R.id.settings_list);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this.getContext());
        recyclerView.setLayoutManager(linearLayoutManager);

        ArrayList list = new ArrayList<String>();
        list.add("支出类别管理");
        list.add("收入类别管理");
        MineAdapter mineAdapter = new MineAdapter(list);
        mineAdapter.setOnItemClickListener(new MineAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(View view, int position) {
                Intent intent = new Intent(MineFragment.this.getContext(), PayClassActivity.class);
                switch (position) {
                    case 1:
                        intent = new Intent(MineFragment.this.getContext(), PayClassActivity.class);
                        break;
                }
                startActivity(intent);
            }
        });
        recyclerView.setAdapter(mineAdapter);

        return rootView;
    }
}