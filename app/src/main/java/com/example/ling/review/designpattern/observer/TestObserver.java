package com.example.ling.review.designpattern.observer;

/**
 * ***************************************
 * statement:
 * author: LingGuiQin
 * date created : 2018/3/7 0007
 * ***************************************
 */
public class TestObserver {

    public static void main(String[] args) {
        AObserver aObserver = new AObserver();
        BObserver bObserver = new BObserver();
        CObserver cObserver = new CObserver();
        Subject subject = new Subject();
        subject.register(aObserver);
        subject.register(bObserver);
        subject.register(cObserver);
        subject.setMsg("我要刚更新新闻啦");
    }
}
