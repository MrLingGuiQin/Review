package com.example.ling.review.ipc.serializable;

import java.io.Serializable;

/**
 * ***************************************
 * statement:
 * author: LingGuiQin
 * date created : 2018/1/4 0004
 * ***************************************
 */
public class User implements Serializable {
    public String name;
    public int id;

    public User(String name, int id) {
        this.name = name;
        this.id = id;
    }
}
