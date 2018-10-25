package com.samfdl.jizhang;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

/**
 * Created by sam on 2017/12/1.
 */
public class WriteFragment extends Fragment implements View.OnClickListener {
    private Button create;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_write, container, false);
        create = rootView.findViewById(R.id.create);
        create.setOnClickListener(this);
        return rootView;
    }

    @Override
    public void onClick(View view) {
        Intent intent = new Intent();
//        intent.setClass(getActivity(), CreateActivity.class);
        startActivity(intent);
    }
}