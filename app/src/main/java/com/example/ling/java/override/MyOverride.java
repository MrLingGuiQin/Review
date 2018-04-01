package com.example.ling.java.override;

/**
 * ***************************************
 * statement: 重写
 * 重写是子类对父类的允许访问的方法的实现过程进行重新编写, 返回值和形参都不能改变。即外壳不变，核心重写！
 * author: LingGuiQin
 * date created : 2018/3/2 0002
 * ***************************************
 */
public class MyOverride {

    public class Animal {
        public void move() {
            System.out.println("动物可以移动");
        }
    }

    public class Dog extends Animal {
        // 这里就是重写了父类 move 方法里面的具体实现
        @Override
        public void move() {
            System.out.println("狗可以跑和走");
        }
    }

}
