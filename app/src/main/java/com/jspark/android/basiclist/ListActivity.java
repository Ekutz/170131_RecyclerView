package com.jspark.android.basiclist;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ListView;

public class ListActivity extends AppCompatActivity {

    ListView listView;

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
        CustomAdapter adapter = new CustomAdapter(arr, this);

        // 아답터 세팅
        listView.setAdapter(adapter);
    }
}