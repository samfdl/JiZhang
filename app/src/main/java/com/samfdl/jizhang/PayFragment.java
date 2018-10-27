package com.samfdl.jizhang;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.TextView;

import com.samfdl.jizhang.activity.PayCategoryActivity;

/**
 * Created by sam on 2018/10/27.
 */
public class PayFragment extends Fragment implements View.OnClickListener {
    private View icon;
    private TextView kind;
    private EditText sum;

    private TextView classify;

    private RecyclerView normal_kind;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_pay, container, false);

        icon = rootView.findViewById(R.id.icon);
        kind = rootView.findViewById(R.id.kind);
        kind.setOnClickListener(this);
        sum = rootView.findViewById(R.id.sum);

        classify = rootView.findViewById(R.id.classify);

        normal_kind = rootView.findViewById(R.id.normal_kind);

        return rootView;
    }

    @Override
    public void onClick(View view) {
        Intent intent = new Intent();
        intent.setClass(getActivity(), PayCategoryActivity.class);
        startActivity(intent);
    }
}