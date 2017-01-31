package com.jspark.android.basiclist;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by jsPark on 2017. 1. 31..
 */

public class RecyclerCustomAdapter extends RecyclerView.Adapter<RecyclerCustomAdapter.CustomViewHolder> {

    ArrayList<User> user;

    // 각 뷰에서 사용되는 layout xml의 아이디
    int itemLayout;

    public RecyclerCustomAdapter(ArrayList<User> user, int itemLayout) {
        this.user = user;
        this.itemLayout = itemLayout;
    }

    /** view를 생성해서 holder에 저장하는 메소드
     *
     * @param parent
     * @param viewType
     * @return
     */
    @Override
    public CustomViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(itemLayout, parent, false);
        CustomViewHolder cvh = new CustomViewHolder(view);
        return cvh;
    }

    // listView 의 getView() 대체 메소드
    @Override
    public void onBindViewHolder(CustomViewHolder holder, int position) {
        User user = this.user.get(position);

        holder.txtId.setText(""+user.id);
        holder.txtName.setText(user.name);
        holder.txtAge.setText(""+user.age);
    }

    @Override
    public int getItemCount() {
        return user.size();
    }


    // 리사이클러 뷰에서 사용하는 뷰 홀더 만들어 주기
    // 이 홀더를 부모 class의 extends에 generic으로 넣어준다
    public class CustomViewHolder extends RecyclerView.ViewHolder {

        TextView txtId, txtName, txtAge;

        public CustomViewHolder(View itemView) {
            super(itemView);
            txtId = (TextView)itemView.findViewById(R.id.txtId);
            txtName = (TextView)itemView.findViewById(R.id.txtName);
            txtAge = (TextView)itemView.findViewById(R.id.txtAge);
        }
    }
}
