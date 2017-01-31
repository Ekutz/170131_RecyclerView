package com.jspark.android.basiclist;

import android.content.Context;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Random;

public class ListHolderActivity extends AppCompatActivity {

    ArrayList<User> data;
    ListView listHolder;
    CustomHolderAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_holder);

        data = new ArrayList<>();

        load();

        listHolder = (ListView)findViewById(R.id.lvHolder);

        adapter = new CustomHolderAdapter(data, ListHolderActivity.this);

        listHolder.setAdapter(adapter);

        listHolder.setOnItemClickListener(listener);
    }

    private void load() {

        Random r = new Random();

        for(int i=0;i<100;i++) {
            User user = new User();

            user.id = i+1;
            user.name = "홍길동 " + (i+1);
            user.age = r.nextInt(80) + 10;

            data.add(user);
        }
    }

    public class CustomHolderAdapter extends BaseAdapter {

        ArrayList<User> data;
        LayoutInflater inflater;

        public CustomHolderAdapter(ArrayList<User> user, Context context) {
            data = user;
            inflater = (LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        }

        @Override
        public int getCount() {
            return data.size();
        }

        @Override
        public Object getItem(int i) {
            return data.get(i);
        }

        @Override
        public long getItemId(int i) {
            return i;
        }

        @Override
        public View getView(int i, View view, ViewGroup viewGroup) {
            Holder holder = new Holder();

            if(view==null) {
                view = inflater.inflate(R.layout.list_holder_item, null);
                holder = new Holder();

                holder.txtId = (TextView)view.findViewById(R.id.txtId);
                holder.txtName = (TextView)view.findViewById(R.id.txtName);
                holder.txtAge = (TextView)view.findViewById(R.id.txtAge);

                view.setTag(holder); // 홀더 통째로 집어넣기
            } else {
                holder = (Holder)view.getTag();
            }

            User user = data.get(i);

            holder.txtId.setText(""+user.id);
            holder.txtName.setText(user.name);
            holder.txtAge.setText(""+user.age);

            return view;
        }

        public String getName(int i) {

            User user = data.get(i);

            String name = user.getName();

            return name;
        }

        public int getAge(int i) {

            User user = data.get(i);

            int age = user.getAge();

            return age;
        }

        // 각 뷰에서 사용되는 위젯을 재사용하기 위한 클래스
        class Holder {
            public TextView txtId, txtName, txtAge;
        }
    }

    AdapterView.OnItemClickListener listener = new AdapterView.OnItemClickListener() {
        @Override
        public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
            Toast.makeText(ListHolderActivity.this, adapter.getName(i)+" 의 id는 "+(adapter.getItemId(i)+1)+"이고 나이는 "+adapter.getAge(i)+" 입니다", Toast.LENGTH_SHORT).show();
        }
    };
}
