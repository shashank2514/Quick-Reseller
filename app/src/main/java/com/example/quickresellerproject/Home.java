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

public class Home extends AppCompatActivity {

    private RecyclerView mRecyclerView;
    private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager mLayoutManager;
    public ArrayList<BookItem> bookitem;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        bookitem=new ArrayList<>();
        bookitem.add(new BookItem("Book","Descrption1","Price1","Date1"));
        bookitem.add(new BookItem("car","Descrption1","Price1","Date1"));
        bookitem.add(new BookItem("Tv","Descrption1","Price1","Date1"));
        bookitem.add(new BookItem("camera","Descrption1","Price1","Date1"));
        bookitem.add(new BookItem("Ac","Descrption1","Price1","Date1"));
        bookitem.add(new BookItem("Phone","Descrption1","Price1","Date1"));
        bookitem.add(new BookItem("Headphones","Descrption1","Price1","Date1"));

        mRecyclerView = findViewById(R.id.recyclerView);
        mRecyclerView.setHasFixedSize(true);
        mLayoutManager = new LinearLayoutManager(this);
        mAdapter = new BookAdapter(bookitem);

        mRecyclerView.setLayoutManager(mLayoutManager);
        mRecyclerView.setAdapter(mAdapter);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu,menu);

        MenuItem menuItem=menu.findItem(R.id.action_search);
        MenuItem PostItem=menu.findItem(R.id.action_post);
        MenuItem AboutItem=menu.findItem(R.id.action_about_app);
        MenuItem ContactItem=menu.findItem(R.id.action_contact_us);
        MenuItem infoItem=menu.findItem(R.id.action_item_info);

        PostItem.setOnMenuItemClickListener(new MenuItem.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(@NonNull MenuItem menuItem) {
                Intent i = new Intent(getApplicationContext(),PostItem.class);
                startActivity(i);
                return false;
            }
        });

        AboutItem.setOnMenuItemClickListener(new MenuItem.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(@NonNull MenuItem menuItem) {
                Intent i = new Intent(getApplicationContext(),About_Us.class);
                startActivity(i);
                return false;
            }
        });

        infoItem.setOnMenuItemClickListener(new MenuItem.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(@NonNull MenuItem menuItem) {
                Intent i = new Intent(getApplicationContext(),item_info.class);
                startActivity(i);
                return false;
            }
        });

        ContactItem.setOnMenuItemClickListener(new MenuItem.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(@NonNull MenuItem menuItem) {
                Intent i = new Intent(getApplicationContext(),contact_us.class);
                startActivity(i);
                return false;
            }
        });

        SearchView searchView= (SearchView) menuItem.getActionView();
        searchView.setQueryHint("Type here to search");

        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String s) {
                ArrayList<BookItem> filteredbookitem=new ArrayList<>();
                for(BookItem book:bookitem){
                    if(book.getItemName().toLowerCase().contains(s.toLowerCase(


                    ))){
                        filteredbookitem.add(book);
                    }

                }
                mAdapter = new BookAdapter(filteredbookitem);
                mRecyclerView.setAdapter(mAdapter);
                return false;
            }

            @Override
            public boolean onQueryTextChange(String s) {

                return false;
            }
        });

        return super.onCreateOptionsMenu(menu);
    }
}