package com.korai.study.ch07;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class AbstractMain01 {
    public static void main(String[] args) {
        List<String> names = new ArrayList<>();
        ArrayList<String> n = (ArrayList<String>) names;
        names.add("김준일");
        names.add("김준이");
        names.add("김준삼");
        System.out.println(names);

        List<String> names2 = new LinkedList<>();
        names2.add("김준일");
        names2.add("김준이");
        names2.add("김준삼");
        System.out.println(names2);

        List<List<String>> lists = new ArrayList<>();
        double[][] doubles = new double[2][2];
        lists.add(new ArrayList<>());
        lists.add(new LinkedList<>());
        lists.add(new ArrayList<>());
        lists.get(0).get(0);
        List<String> strings = lists.get(0);
        String str = lists.get(0).get(0);

        double d = 10;
        int i = (int) d;


    }
}
