package com.samfdl.jizhang.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.samfdl.jizhang.R;

import java.util.List;

public class PayCategoryAdapter extends RecyclerView.Adapter<PayCategoryAdapter.ItemViewHolder> {
    private Context mContext;

    private List<String> mData;

    public PayCategoryAdapter(Context context, List<String> data) {
        mContext = context;
        this.mData = data;
    }

    @Override
    public ItemViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_pay_category, parent, false);
        ItemViewHolder viewHolder = new ItemViewHolder(v);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ItemViewHolder viewHolder, int i) {
        viewHolder.text.setText(mData.get(i));
    }

    @Override
    public int getItemCount() {
        return mData == null ? 0 : mData.size();
    }

    public class ItemViewHolder extends RecyclerView.ViewHolder {
        TextView text;

        public ItemViewHolder(View itemView) {
            super(itemView);
            text = itemView.findViewById(R.id.text);
        }
    }
}