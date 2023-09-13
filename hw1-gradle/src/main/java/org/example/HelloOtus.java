package org.example;

import com.google.common.collect.ArrayListMultimap;
import com.google.common.collect.ListMultimap;

public class HelloOtus {
    public static void main(String[] args) {
        ListMultimap<String, String> multimap = ArrayListMultimap.create();

        multimap.put("John", "Adams");
        multimap.put("John", "Tyler");
        multimap.put("John", "Kennedy");

        System.out.println(multimap);
    }
}
