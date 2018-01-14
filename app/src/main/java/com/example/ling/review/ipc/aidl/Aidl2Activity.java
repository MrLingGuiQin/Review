package com.example.ling.review.ipc.aidl;

import android.content.ComponentName;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.IBinder;
import android.os.RemoteException;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.example.ling.aidlservice.IListAidlInterface;
import com.example.ling.aidlservice.Person;
import com.example.ling.review.R;

import java.util.List;


/**
 * ***************************************
 * statement: 传递自定义数据类型person  Aidl
 * author: LingGuiQin
 * date created : 2018/1/13 0013
 * ***************************************
 */
public class Aidl2Activity extends AppCompatActivity {

    private TextView mTxtResult;
    private IListAidlInterface mIListAidlInterface;

    private ServiceConnection conn = new ServiceConnection() {
        @Override
        public void onServiceConnected(ComponentName name, IBinder service) {
            mIListAidlInterface = IListAidlInterface.Stub.asInterface(service);
        }

        @Override
        public void onServiceDisconnected(ComponentName name) {
            mIListAidlInterface = null;
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_aidl2);
        initView();
        bindService();
    }

    private void initView() {
        mTxtResult = findViewById(R.id.txt_result);
    }

    private void bindService() {
        final Intent intent = new Intent();
        final ComponentName componentName = new ComponentName("com.example.ling.aidlservice",
                "com.example.ling.aidlservice.IRemotePersonService");
        intent.setComponent(componentName);
        bindService(intent, conn, BIND_AUTO_CREATE);
    }

    public void onClickAddPerson(View view) {

        try {
            List<Person> persons = mIListAidlInterface.addPerson(new Person("ling", 18));
            mTxtResult.setText(persons.toString());
        } catch (RemoteException e) {
            e.printStackTrace();
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        unbindService(conn);
    }
}
