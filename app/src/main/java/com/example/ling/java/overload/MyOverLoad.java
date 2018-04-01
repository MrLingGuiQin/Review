package com.example.ling.java.overload;

/**
 * ***************************************
 * statement: 重载(overloading) 是在一个类里面，方法名字相同，而参数不同。返回类型可以相同也可以不同。
 * author: LingGuiQin
 * date created : 2018/3/2 0002
 * ***************************************
 */
public class MyOverLoad {
    private static int i = 1;
    private static double l = 3.1415;
    private static String k = "我是栗子";

    //参数类型不同
    public void test(int a) {
        System.out.println("你输入了整数:" + a);
    }

    public void test(double a) {
        System.out.println("你输入了浮点数:" + a);
    }

    public void test(String a) {
        System.out.println("你输入了字符串:" + a);
    }

    public static void main(String[] args) {
        MyOverLoad lizi = new MyOverLoad();
        lizi.test(i);
        lizi.test(l);
        lizi.test(k);
    }

}
