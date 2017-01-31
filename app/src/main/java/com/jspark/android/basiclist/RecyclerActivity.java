package com.jspark.android.basiclist;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;

public class RecyclerActivity extends AppCompatActivity {

    ArrayList<User> userData = null;
    RecyclerView recycleView = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recycler);

        Data data = new Data();
        userData = data.getData();

        recycleView = (RecyclerView)findViewById(R.id.RcView);

        RecyclerCustomAdapter rca = new RecyclerCustomAdapter(userData, R.layout.recycler_holder_item);

        recycleView.setAdapter(rca);

        recycleView.setLayoutManager(new LinearLayoutManager(RecyclerActivity.this));
    }


}
