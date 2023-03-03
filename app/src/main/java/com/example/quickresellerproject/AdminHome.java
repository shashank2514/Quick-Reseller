package com.example.quickresellerproject;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.SearchView;

import java.util.ArrayList;

public class AdminHome extends AppCompatActivity {


    private RecyclerView mRecyclerView;
    private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager mLayoutManager;
    public ArrayList<AdminItem> bookitem;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin_home);

        bookitem=new ArrayList<>();
        bookitem.add(new AdminItem("car","Descrption1","Price1","Date1"));
        bookitem.add(new AdminItem("car","Descrption1","Price1","Date1"));
        bookitem.add(new AdminItem("bike","Descrption1","Price1","Date1"));
        bookitem.add(new AdminItem("tv","Descrption1","Price1","Date1"));
        bookitem.add(new AdminItem("ac","Descrption1","Price1","Date1"));
        bookitem.add(new AdminItem("fridge","Descrption1","Price1","Date1"));
        bookitem.add(new AdminItem("Book","Descrption1","Price1","Date1"));

        mRecyclerView = findViewById(R.id.recyclerView);
        mRecyclerView.setHasFixedSize(true);
        mLayoutManager = new LinearLayoutManager(this);
        mAdapter = new AdminAdapter(bookitem);

        mRecyclerView.setLayoutManager(mLayoutManager);
        mRecyclerView.setAdapter(mAdapter);
    }

}