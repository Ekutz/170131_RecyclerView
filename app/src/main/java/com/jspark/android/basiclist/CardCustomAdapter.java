package com.jspark.android.basiclist;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by jsPark on 2017. 1. 31..
 */

public class CardCustomAdapter extends RecyclerView.Adapter<CardCustomAdapter.CustomViewHolder> {

    ArrayList<User> user;
    Context context;
    public CardCustomAdapter(ArrayList<User> user, Context context) {
        this.user = user;
        this.context = context;
    }

    /** view를 생성해서 holder에 저장하는 메소드
     *
     * @param parent
     * @param viewType
     * @return
     */
    @Override
    public CustomViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_card_item, parent, false);
        CustomViewHolder cvh = new CustomViewHolder(view);
        return cvh;
    }

    // listView 의 getView() 대체 메소드
    @Override
    public void onBindViewHolder(CustomViewHolder holder, int position) {
        final User user = this.user.get(position);

        holder.txtId.setText(""+user.id);
        holder.txtName.setText(user.name);
        holder.txtAge.setText(""+user.age);

        holder.cv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(context, DetailActivity.class);
                i.putExtra("no", user.id);
                i.putExtra("day", user.name);
                context.startActivity(i);
            }
        });

        // 애니메이션!
        Animation animation = AnimationUtils.loadAnimation(context, android.R.anim.slide_in_left);
        holder.cv.setAnimation(animation);
    }

    @Override
    public int getItemCount() {
        return user.size();
    }


    // 리사이클러 뷰에서 사용하는 뷰 홀더 만들어 주기
    // 이 홀더를 부모 class의 extends에 generic으로 넣어준다
    public class CustomViewHolder extends RecyclerView.ViewHolder {

        TextView txtId, txtName, txtAge;
        CardView cv;

        public CustomViewHolder(View itemView) {
            super(itemView);
            txtId = (TextView)itemView.findViewById(R.id.txtId);
            txtName = (TextView)itemView.findViewById(R.id.txtName);
            txtAge = (TextView)itemView.findViewById(R.id.txtAge);

            cv = (CardView)itemView.findViewById(R.id.cardView);
        }
    }
}
