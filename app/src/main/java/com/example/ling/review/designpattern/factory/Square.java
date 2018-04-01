package com.example.ling.review.designpattern.factory;

/**
 * ***************************************
 * statement: 正方形
 * author: LingGuiQin
 * date created : 2018/3/7 0007
 * ***************************************
 */
public class Square implements Shape {
    @Override
    public void draw() {
        System.out.print("Inside Square::draw() method.");
    }
}
