package com.example.quickresellerproject;


import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class AdminAdapter extends RecyclerView.Adapter<AdminAdapter.ExampleViewHolder> {


    private AdminAdapter.OnItemClickListener mListener;

    public interface OnItemClickListener {
        void onItemClick(int position);
    }
    public void setOnItemClickListener(AdminAdapter.OnItemClickListener listener) {
        mListener = listener;
    }


    private ArrayList<AdminItem> mExampleList;


    public static class ExampleViewHolder extends RecyclerView.ViewHolder {
        public TextView mItemName;
        public TextView mItemDescription;
        public TextView mItemPrice;
        public TextView mItemDate;


        public ExampleViewHolder(View itemView ,final AdminAdapter.OnItemClickListener listener) {
            super(itemView);

            mItemName=itemView.findViewById(R.id.item_name);
            mItemPrice = itemView.findViewById(R.id.item_price);
            mItemDate = itemView.findViewById(R.id.item_date);

            itemView.setOnClickListener(new View.OnClickListener() {
                public void onClick(View v) {
                    if (listener != null) {
                        int position = getAdapterPosition();
                        if (position != RecyclerView.NO_POSITION) {
                            listener.onItemClick(position);
                        }
                    }
                }
            });
        }
    }

    public AdminAdapter(ArrayList<AdminItem> exampleList) {
        mExampleList = exampleList;
    }

    @Override
    public AdminAdapter.ExampleViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.book_item, parent, false);
        AdminAdapter.ExampleViewHolder evh = new AdminAdapter.ExampleViewHolder(v,mListener);
        return evh;
    }

    @Override
    public void onBindViewHolder(AdminAdapter.ExampleViewHolder holder, int position) {
        AdminItem currentItem = mExampleList.get(position);
        holder.mItemName.setText(currentItem.getItemName());
        String priceval="Price: "+currentItem.getItemPrice()+"$";
        holder.mItemPrice.setText(priceval);
        String dateVal="Date: "+currentItem.getItemDate();
        holder.mItemDate.setText(dateVal);
    }

    @Override
    public int getItemCount() {
        return mExampleList.size();
    }
}