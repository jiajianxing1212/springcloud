package com.maisel.serverproducer;

import java.util.ArrayList;
import java.util.List;

/**
 * @aucthor:jjx
 * @Create:2019-02-12 14:56
 */
public class TestMain2 {
    public static void main(String[] args) {
        /*TestMain.main(args);
        System.out.println("hello word!"+22222);*/
        add();

    }

    public static void add(){
        List list = new ArrayList(1000);
        for (int i = 0; i < 10000; i++) {
            list.add(i + " ");
        }
        for (Object o : list) {
            System.out.println(o);
        }
    }

}
