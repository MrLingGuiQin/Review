package com.example.ling.review.asynctask;

import android.app.ProgressDialog;
import android.content.Context;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.Toast;

import java.lang.ref.WeakReference;


public class AsyncTaskActivity extends AppCompatActivity {
    private DownLoadFileTask mTask = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // 创建 DownLoadFileTask 实例
        mTask = new DownLoadFileTask(this);
        // 执行任务
        mTask.execute("参数1", "参数2", "参数3");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        // 取消 AsyncTask的任务
        mTask.cancel(true);
    }

    /**
     * 1、DownLoadFileTask 改为静态内部类，避免内存泄漏
     * 2、将Activity 包装成弱引用,避免内存泄漏
     */
    public static class DownLoadFileTask extends AsyncTask<String, Integer, String> {
        private WeakReference<AsyncTaskActivity> mWeakReference = null;
        private ProgressDialog mProgressDialog = null;
        private Context mContext = null;

        public DownLoadFileTask(AsyncTaskActivity activity) {
            mWeakReference = new WeakReference<>(activity);
        }

        /**
         * 运行在主线程，执行后台任务之前调用，通常用来做一些准备操作
         */
        @Override
        protected void onPreExecute() {
            mContext = mWeakReference.get();
            if (mContext != null) {
                mProgressDialog = new ProgressDialog(mContext);
                mProgressDialog.setCancelable(false);
                mProgressDialog.setTitle("任务正在执行中");
                mProgressDialog.setMessage("任务正在执行中，敬请期待...");
                mProgressDialog.setProgressStyle(ProgressDialog.STYLE_HORIZONTAL);
                mProgressDialog.setMax(200);
                mProgressDialog.show();
            }
        }

        /**
         * 运行在线程池中，执行后台耗时操作
         *
         * @param strings 参数
         * @return 结果
         */
        @Override
        protected String doInBackground(String... strings) {
            // 打印 mTask.execute();传递的参数
            StringBuilder builder = new StringBuilder();
            for (String string : strings) {
                builder.append(string).append(",");
            }
            Log.d("doInBackground", builder.toString());

            // 模拟下载
            int progress = 0;
            while (progress < 200) {
                try {
                    Thread.sleep(1000);   // 模拟耗时操作
                    progress += 10;
                    publishProgress(progress);// 更新进度，该方法调用后会触发 onProgressUpdate方法
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            publishProgress(progress);
            String msg = "文件下载成功！";
            return msg;
        }

        /**
         * 运行在主线程，用于更新进度，publishProgress方法执行后，会触发该方法
         *
         * @param values 进度值
         */
        @Override
        protected void onProgressUpdate(Integer... values) {
            if (mProgressDialog != null) {
                mProgressDialog.setProgress(values[0]);
            }
        }

        /**
         * 运行在主线程，后台任务执行完成后，将返回值传给该方法
         *
         * @param s 返回的结果
         */
        @Override
        protected void onPostExecute(String s) {
            if (mContext != null) {
                mProgressDialog.dismiss();
                Toast.makeText(mContext, s, Toast.LENGTH_SHORT).show();
            }
        }
    }
}
