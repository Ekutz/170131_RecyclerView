package com.jspark.android.basiclist;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

/**
 * Created by jsPark on 2017. 1. 31..
 */

public class CustomAdapter extends BaseAdapter {

    LayoutInflater inflater;
    String data[];
    TextView txtNo, txtDay;

    // context 란 시스템 자원을 쓰기 위한 함수의 모임
    public CustomAdapter(String str[], Context context) {
        inflater = (LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE); // inflater는 xml을 java 코드로 바꿔주므로 무조건 필수
        data = str;
    }

    /** 사용하는 뷰의 총 개수
     *
     * @return 뷰에 들어갈 데이터의 길이
     */
    @Override
    public int getCount() {
        return data.length;
    }

    /** 선택된 리스트 아이템
     *
     * @param i index 값
     * @return 선택된 데이터
     */
    @Override
    public Object getItem(int i) {
        return data[i];
    }

    /** 아이템의 index 값
     *
     * @param i index 값
     * @return index 값
     */
    @Override
    public long getItemId(int i) {
        return i;
    }

    // 리스트뷰의 한 행 단위를 view라고 한다
    // 한 행을 개발자가 직접 만들어서 시스템에 넘겨주어야 한다

    /** 화면에 각 view가 보이는 순간에 호출된다
     *
     * @param i view의 index 값
     * @param view 보여지는 view
     * @param viewGroup
     * @return
     */
    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {

        // 한 행에 해당하는 레이아웃 xml을 뷰 객체로 만들어준다
        if(view==null) view = inflater.inflate(R.layout.list_item, null); // getView의 view를 쓰게 되면 한번에 보이는 i의 개수만큼만 inflate 되서 메모리를 절약할 수 있다

        txtNo = (TextView)view.findViewById(R.id.tv1); // inflate된 뷰를 통해서 findViewById를 사용한다
        txtDay = (TextView)view.findViewById(R.id.tv2);

        // view 내부 데이터 세팅
        txtNo.setText(""+(i+1)); // int -> String 캐스팅
        txtDay.setText(data[i]);

        // 완성된 view 반환
        return view;
    }

    public String getDay(int i) {
        return data[i];
    }

}
