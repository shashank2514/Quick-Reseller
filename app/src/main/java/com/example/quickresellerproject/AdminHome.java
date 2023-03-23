package com.example.quickresellerproject;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ProgressBar;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class AdminHome extends AppCompatActivity {


    private RecyclerView mRecyclerView;
    private AdminAdapter mAdapter;
    private RecyclerView.LayoutManager mLayoutManager;
    public DatabaseReference databaseReference;
    FirebaseUser firebaseUser;
    FirebaseAuth auth;
    ProgressBar progressBar;
    public ArrayList<AdminItem> bookitem;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin_home);

        bookitem=new ArrayList<>();
        databaseReference= FirebaseDatabase.getInstance().getReference("Posts");


        mRecyclerView = findViewById(R.id.recyclerView);
        mRecyclerView.setHasFixedSize(true);
        mLayoutManager = new LinearLayoutManager(this);
        mAdapter = new AdminAdapter(bookitem);

        mRecyclerView.setLayoutManager(mLayoutManager);
        mRecyclerView.setAdapter(mAdapter);

//        progressBar = findViewById(R.id.progress_bar);
//        progressBar.setVisibility(View.VISIBLE);

        auth=FirebaseAuth.getInstance();
        firebaseUser =auth.getCurrentUser();


        databaseReference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                for(DataSnapshot dataSnapshot:snapshot.getChildren()){
                    for(DataSnapshot dataSnapshot1:dataSnapshot.getChildren()){
                        ReadWriteItemDetails post=dataSnapshot1.getValue(ReadWriteItemDetails.class);

                        Date dt = new Date();
                        SimpleDateFormat dateFormat;
                        dateFormat = new SimpleDateFormat("dd/MM/yyyy");
                        String date=""+dateFormat.format(dt);

                        bookitem.add(new AdminItem(post.name,post.description,post.price,date,post.Image_url));
                    }

                }
//                progressBar.setVisibility(View.GONE);
                mAdapter.notifyDataSetChanged();
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });

        mAdapter.setOnItemClickListener(new AdminAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(int position){
                Intent i=new Intent(getApplicationContext(),AdminItemInfo.class);
                i.putExtra("name",bookitem.get(position).getItemName());
                i.putExtra("description",bookitem.get(position).getItemDescription());
                i.putExtra("price",bookitem.get(position).getItemPrice());
                i.putExtra("date",bookitem.get(position).getItemDate());
                i.putExtra("imgUrl",bookitem.get(position).getImageUrl());
                startActivity(i);
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu2,menu);


        MenuItem AboutItem=menu.findItem(R.id.action_about_app);
        MenuItem logoutItem=menu.findItem(R.id.action_logout);



        AboutItem.setOnMenuItemClickListener(new MenuItem.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(@NonNull MenuItem menuItem) {
                Intent i = new Intent(getApplicationContext(),About_Us.class);
                startActivity(i);
                return false;
            }
        });




        logoutItem.setOnMenuItemClickListener(new MenuItem.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(@NonNull MenuItem menuItem) {
                FirebaseAuth.getInstance().signOut();
                Intent i=new Intent(getApplicationContext(),login.class);
                startActivity(i);
                finish();
                return false;
            }
        });


        return super.onCreateOptionsMenu(menu);
    }

}