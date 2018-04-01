package com.example.ling.java;

import com.example.ling.java.interfaces.MyInterface;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Set;
import java.util.Vector;

/**
 * ***************************************
 * statement:
 * author: LingGuiQin
 * date created : 2018/3/2 0002
 * ***************************************
 */
public class Test {
    private ArrayList<Integer> mArrayList = new ArrayList<>();

    HashMap mHashMap;
    HashSet mHashSet;
    Set mSet;
    LinkedList mLinkedList;
    Vector mVector;

    public Test() {
        mArrayList.add(1);
        int i = mArrayList.get(0);
        TestJava2 testJava2 = new TestJava2(1);
        testJava2.test();
        String s;
        StringBuffer sb;
        StringBuilder sb2;
        MyInterface myInterface = new MyInterface() {
            @Override
            public void a() {

            }

            @Override
            public void b() {

            }

            @Override
            public void c() {

            }
        };
    }
}
