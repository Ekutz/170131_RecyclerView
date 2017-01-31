package com.jspark.android.basiclist;

import java.util.ArrayList;
import java.util.Random;

/**
 * Created by jsPark on 2017. 1. 31..
 */

public class Data {

    private ArrayList<User> data;

    public Data() {
        data = new ArrayList<>();
        load();
    }

    public void load() {
        Random r = new Random();

        for (int i = 0; i < 100; i++) {
            User user = new User();

            user.id = i + 1;
            user.name = "홍길동 " + (i + 1);
            user.age = r.nextInt(80) + 10;

            data.add(user);
        }
    }

    public ArrayList<User> getData() {
        return data;
    }

}
