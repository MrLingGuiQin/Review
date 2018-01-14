package com.example.ling.aidlservice;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.os.RemoteException;
import android.support.annotation.Nullable;

import java.util.ArrayList;
import java.util.List;


/**
 * ***************************************
 * statement: aidl自定义数据 service
 * author: LingGuiQin
 * date created : 2018/1/14 0014
 * ***************************************
 */
public class IRemotePersonService extends Service {

    private ArrayList<Person> mPersons;
    private IBinder mIBinder = new IListAidlInterface.Stub() {
        @Override
        public List<Person> addPerson(Person person) throws RemoteException {
            mPersons.add(person);
            return mPersons;
        }
    };

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        mPersons = new ArrayList<>();
        return mIBinder;
    }
}
