package com.example.ling.review.designpattern.factory;

/**
 * ***************************************
 * statement:
 * author: LingGuiQin
 * date created : 2018/3/7 0007
 * ***************************************
 */
public class TestFactory {

    public static void main(String[] args) {

        ShapeFactory shapeFactory = new ShapeFactory();

        // 绘制圆形图案
        Shape circle = shapeFactory.getShape("CIRCLE");
        circle.draw();

        // 绘制正方形图案
        Shape square = shapeFactory.getShape("SQUARE");
        square.draw();

        // 绘制长方形图案
        Shape rectangle = shapeFactory.getShape("RECTANGLE");
        rectangle.draw();
    }
}
