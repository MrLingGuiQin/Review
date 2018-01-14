package com.example.ling.review.ipc.parcelable;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * ***************************************
 * statement:
 * author: LingGuiQin
 * date created : 2018/1/10 0010
 * ***************************************
 */
public class User3 implements Parcelable {
    public  transient String name = "Who am I？";  // 该表示表示不会序列化
    public int id;

    public User3(String name, int id) {
        this.name = name;
        this.id = id;
    }

    protected User3(Parcel in) {
        id = in.readInt();
    }

    @Override
    public String toString() {
        return "User3{" +
                "name='" + name + '\'' +
                ", id=" + id +
                '}';
    }

    public static final Creator<User3> CREATOR = new Creator<User3>() {
        @Override
        public User3 createFromParcel(Parcel in) {
            return new User3(in);
        }

        @Override
        public User3[] newArray(int size) {
            return new User3[size];
        }
    };

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(id);
    }
}
