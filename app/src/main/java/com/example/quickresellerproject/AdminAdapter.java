package com.example.quickresellerproject;


import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class AdminAdapter extends RecyclerView.Adapter<AdminAdapter.ExampleViewHolder> {

    private ArrayList<AdminItem> mExampleList;


    public static class ExampleViewHolder extends RecyclerView.ViewHolder {
        public TextView mItemName;
        public TextView mItemDescription;
        public TextView mItemPrice;
        public TextView mItemDate;

        public ExampleViewHolder(View itemView) {
            super(itemView);

            mItemName=itemView.findViewById(R.id.item_name);
            mItemDescription=itemView.findViewById(R.id.item_description);
            mItemPrice = itemView.findViewById(R.id.item_price);
            mItemDate = itemView.findViewById(R.id.item_date);
        }
    }

    public AdminAdapter(ArrayList<AdminItem> exampleList) {
        mExampleList = exampleList;
    }

    @Override
    public AdminAdapter.ExampleViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.book_item, parent, false);
        AdminAdapter.ExampleViewHolder evh = new AdminAdapter.ExampleViewHolder(v);
        return evh;
    }

    @Override
    public void onBindViewHolder(@NonNull ExampleViewHolder holder, int position) {
        AdminItem currentItem = mExampleList.get(position);
        holder.mItemName.setText(currentItem.getItemName());
        holder.mItemDescription.setText(currentItem.getItemDescription());
        holder.mItemPrice.setText(currentItem.getItemPrice());
        holder.mItemDate.setText(currentItem.getItemDate());
    }


    @Override
    public int getItemCount() {
        return mExampleList.size();
    }
}
