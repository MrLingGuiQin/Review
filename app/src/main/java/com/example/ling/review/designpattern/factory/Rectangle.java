package com.example.ling.review.designpattern.factory;

/**
 * ***************************************
 * statement: 长方形
 * author: LingGuiQin
 * date created : 2018/3/7 0007
 * ***************************************
 */
public class Rectangle implements Shape {
    @Override
    public void draw() {
        System.out.print("Inside Rectangle::draw() method.");
    }
}
