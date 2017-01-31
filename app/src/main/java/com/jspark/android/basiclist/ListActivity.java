package com.jspark.android.basiclist;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

public class ListActivity extends AppCompatActivity {

    ListView listView;
    CustomAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list);

/* 제일 기본적인 리스트뷰 정의법

        // 리스트뷰 정의
        listView = (ListView)findViewById(R.id.listView);

        // 아답터 정의
        ArrayAdapter<String> adapter = null;

        // 아답터 세팅
        listView.setAdapter(adapter);
*/

        String arr[] = {"mon", "tue", "wed", "thur", "fri", "sat", "sun"};

        // 리스트뷰 정의
        listView = (ListView)findViewById(R.id.listView);

        // 아답터 정의
        //ArrayAdapter<String> adapter = new ArrayAdapter<>(ListActivity.this, android.R.layout.simple_list_item_1, arr);
        adapter = new CustomAdapter(arr, this);

        // 아답터 세팅
        listView.setAdapter(adapter);

        listView.setOnItemClickListener(listener);
    }

    AdapterView.OnItemClickListener listener = new AdapterView.OnItemClickListener() {
        @Override
        public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
            Intent intent = new Intent(ListActivity.this, DetailActivity.class);
            intent.putExtra("no", i+1);
            intent.putExtra("day", adapter.getDay(i));
            startActivity(intent);
        }
    };
}