package com.example.ling.aidlservice;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.os.RemoteException;
import android.support.annotation.Nullable;
import android.util.Log;



/**
 * ***************************************
 * statement:
 * author: LingGuiQin
 * date created : 2018/1/13 0013
 * ***************************************
 */
public class IRemoteService extends Service {
    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return mIBinder;
    }

    private IBinder mIBinder = new IMyAidlInterface.Stub() {
        @Override
        public int add(int num1, int num2) throws RemoteException {
            Log.e("TAG", "输出 mum1 =" + num1 + "num2 = " + num2);
            return num1 + num2;
        }
    };
}
