package com.jspark.android.basiclist;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    Button btnList, btnListH, btnRecy, btnDT;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnList = (Button)findViewById(R.id.btnLv);
        btnListH = (Button)findViewById(R.id.btnLvHolder);
        btnRecy = (Button)findViewById(R.id.btnRV);

        btnList.setOnClickListener(listener);
        btnListH.setOnClickListener(listener);
        btnRecy.setOnClickListener(listener);
    }

    View.OnClickListener listener = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            Intent i = null;
            switch (view.getId()) {
                case R.id.btnLv :
                    i = new Intent(MainActivity.this, ListActivity.class);
                    break;
                case R.id.btnLvHolder :
                    i = new Intent(MainActivity.this, ListHolderActivity.class);
                    break;
                case R.id.btnRV :
                    i = new Intent(MainActivity.this, RecyclerActivity.class);
                    break;
            }
            startActivity(i);
        }
    };
}
