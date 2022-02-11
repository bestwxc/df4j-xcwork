package com.df4j.xcwork.base;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        List list2 = new ArrayList();
        Class class1 = list.getClass();
        Class class2 = list2.getClass();

        System.out.println(list.getClass());
        System.out.println(list2.getClass());
    }
}
