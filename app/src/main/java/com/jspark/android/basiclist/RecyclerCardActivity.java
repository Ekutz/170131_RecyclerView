package com.jspark.android.basiclist;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;

public class RecyclerCardActivity extends AppCompatActivity {

    ArrayList<User> user = null;
    RecyclerView rcView = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recycler_card);

        Data data = new Data();
        user = data.getData();

        rcView = (RecyclerView)findViewById(R.id.rcCard);

        CardCustomAdapter adapter = new CardCustomAdapter(user, RecyclerCardActivity.this);

        rcView.setAdapter(adapter);

        rcView.setLayoutManager(new LinearLayoutManager(RecyclerCardActivity.this));
    }


}
