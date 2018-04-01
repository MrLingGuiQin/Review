package com.example.ling.review.designpattern.observer;

import java.util.ArrayList;
import java.util.List;

/**
 * ***************************************
 * statement: 被观察者
 * author: LingGuiQin
 * date created : 2018/3/7 0007
 * ***************************************
 */
public class Subject {
    private List<Observer> mObserverList = new ArrayList<>();

    public void register(Observer observer) {
        mObserverList.add(observer);
    }

    public void unRegister(Observer observer) {
        mObserverList.remove(mObserverList);
    }

    public void setMsg(String msg) {
        notifyAllChange(msg);
    }

    public void notifyAllChange(String msg) {
        for (Observer observer : mObserverList) {
            observer.update(msg);
        }
    }
}
