package com.example.ling.review.designpattern.factory;

/**
 * ***************************************
 * statement: 图形生产工厂类
 * author: LingGuiQin
 * date created : 2018/3/7 0007
 * ***************************************
 */
public class ShapeFactory {

    public Shape getShape(String type) {
        if (type.equals("RECTANGLE")) {
            return new Rectangle();
        } else if (type.equals("SQUARE")) {
            return new Square();
        } else if (type.equals("CIRCLE")) {
            return new Circle();
        }
        return null;
    }

    public static Object getClass(Class<?extends Shape> clazz) {
        Object obj = null;

        try {
            obj = Class.forName(clazz.getName()).newInstance();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }

        return obj;
    }
}
