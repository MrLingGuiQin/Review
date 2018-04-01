package com.example.ling.review.wifi;

import android.content.Context;
import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;

/**
 * ***************************************
 * statement:
 * author: LingGuiQin
 * date created : 2018/3/8 0008
 * ***************************************
 */
public class WifiTest {
    Context mContext;

    public WifiTest(Context context) {
        mContext = context;
        // 取得WifiManager对象
        WifiManager mWifiManager = (WifiManager) context
                .getSystemService(Context.WIFI_SERVICE);
        mWifiManager.isWifiEnabled();
        // 取得WifiInfo对象
        WifiInfo mWifiInfo = mWifiManager.getConnectionInfo();
        WifiManager.WifiLock mWifiLock;

        new Thread(new Runnable() {
            @Override
            public void run() {

            }
        }).start();


    }


}
