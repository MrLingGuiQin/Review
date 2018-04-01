package com.example.ling.review.designpattern.factory;

/**
 * ***************************************
 * statement: 圆形
 * author: LingGuiQin
 * date created : 2018/3/7 0007
 * ***************************************
 */
public class Circle implements Shape {
    @Override
    public void draw() {
        System.out.print("Inside Circle::draw() method.");
    }
}
