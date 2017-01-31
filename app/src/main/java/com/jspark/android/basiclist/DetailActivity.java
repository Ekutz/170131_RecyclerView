package com.jspark.android.basiclist;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

public class DetailActivity extends AppCompatActivity {

    TextView txtNo, txtDay;
    int getNo;
    String getDay;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        txtNo = (TextView)findViewById(R.id.txtNO);
        txtDay = (TextView)findViewById(R.id.txtDay);

        Intent i = getIntent();
        Bundle bundle = i.getExtras();

        getNo = bundle.getInt("no");
        getDay = bundle.getString("day");

        txtNo.setText(""+getNo);
        txtDay.setText(getDay);
    }
}
