package com.example.ling.review.ipc.aidl;

import android.content.ComponentName;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.IBinder;
import android.os.RemoteException;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.example.ling.aidlservice.IMyAidlInterface;
import com.example.ling.review.R;

/**
 * ***************************************
 * statement: 传递基本数据类型 Aidl
 * author: LingGuiQin
 * date created : 2018/1/13 0013
 * ***************************************
 */
public class AidlActivity extends AppCompatActivity implements View.OnClickListener {

    private EditText mEditText1;
    private EditText mEditText2;
    private TextView mTxtResult;
    private Button mBtnCount;
    private IMyAidlInterface mIMyAidl;
    private ServiceConnection conn = new ServiceConnection() {
        @Override
        public void onServiceConnected(ComponentName name, IBinder service) {
            Log.d("TAG", "绑定服务连接成功");
            mIMyAidl = IMyAidlInterface.Stub.asInterface(service);
        }

        @Override
        public void onServiceDisconnected(ComponentName name) {
            mIMyAidl = null;
            Log.d("TAG", "绑定服务连接失败");
        }
    };

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_aidl);
        initView();
        bindService();
    }

    private void initView() {
        mEditText1 = findViewById(R.id.et_num1);
        mEditText2 = findViewById(R.id.et_num2);
        mTxtResult = findViewById(R.id.txt_result);
        mBtnCount = findViewById(R.id.btn_aidl_count);
        mBtnCount.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.btn_aidl_count) {
            int num1 = Integer.parseInt(mEditText1.getText().toString());
            int num2 = Integer.parseInt(mEditText2.getText().toString());
            try {
                int res = mIMyAidl.add(num1, num2);
                mTxtResult.setText(String.valueOf(res));
            } catch (RemoteException e) {
                e.printStackTrace();
            }
            return;
        }
    }

    private void bindService() {
        final Intent intent = new Intent();
        final ComponentName componentName = new ComponentName("com.example.ling.aidlservice",
                "com.example.ling.aidlservice.IRemoteService");
        intent.setComponent(componentName);
        bindService(intent, conn, BIND_AUTO_CREATE);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        unbindService(conn);

    }
}
