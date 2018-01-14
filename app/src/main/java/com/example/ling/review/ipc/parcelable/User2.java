package com.example.ling.review.ipc.parcelable;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * ***************************************
 * statement:
 * author: LingGuiQin
 * date created : 2018/1/4 0004
 * ***************************************
 */
public class User2 implements Parcelable {

    public String name;
    public int id;

    public User2(String name, int id) {
        this.name = name;
        this.id = id;
    }


    /**
     * 反序列话的过程
     */
    public static final Creator<User2> CREATOR = new Creator<User2>() {

        // 从序列化的对象中创建原始对象
        @Override
        public User2 createFromParcel(Parcel in) {
            return new User2(in);
        }

        // 创建指定长度原始对象的数组
        @Override
        public User2[] newArray(int size) {
            return new User2[size];
        }
    };

    /**
     * 返回当前对象的内容描述
     *
     * @return 0 不返回 （几乎所有情况）、1 返回
     */
    @Override
    public int describeContents() {
        return 0;
    }


    /**
     * 对象序列化写到 Parcel 容器中
     *
     * @param dest  容器
     * @param flags 0 不返回（几乎所有情况）、 1 表示当前对象需要作为返回值返回，不能立即释放资源
     */
    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(name);
        dest.writeInt(id);
    }

    /**
     * 对象反序列化 从Parcel 容器中读取创建原始对象
     *
     * @param in 容器
     */
    protected User2(Parcel in) {
        name = in.readString();
        id = in.readInt();
    }
}
