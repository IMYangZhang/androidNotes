package com.example.androidnotes;

import android.content.Intent;
import android.content.IntentFilter;
import android.net.wifi.WifiManager;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;

import com.example.androidnotes.Broatcast.InternetBroatcastReceived;
import com.example.androidnotes.R;
import com.example.androidnotes.recyclerView.ActivityRecyclerView;
import com.example.androidnotes.recyclerView.model.DataInfo;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private static final String TAG = "MainActivity";
    private MyBroatcast myBroatcast; // wifi广播
    private Button btn_recyclerView;


    InternetBroatcastReceived internetBroatcastReceived;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initData();
        initListen();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        unregisterReceiver(internetBroatcastReceived);
    }


    private void initData() {
        myBroatcast = new MyBroatcast();

    }

    private void initListen() {
//        btn_recyclerView = findViewById(R.id.btn_recyclerView);
//        btn_recyclerView.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Intent intent = new Intent(MainActivity.this, ActivityRecyclerView.class);
//                startActivity(intent);
//            }
//        });
    }

    @Override
    public boolean dispatchTouchEvent(MotionEvent ev) {
        Log.i(TAG, "dispatchTouchEvent: "+ev.getAction());
        return super.dispatchTouchEvent(ev);
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
//        switch (event.getAction()) {
//            case MotionEvent.ACTION_MOVE:
//                Log.i(TAG, "onTouchEvent: ");
//        }
        Log.i(TAG, "onTouchEvent: "+ event.getAction());
        return super.onTouchEvent(event);
    }


    class MyBroatcast {
        public void init() {
            // 注册广播
            internetBroatcastReceived = new InternetBroatcastReceived(MainActivity.this);
            IntentFilter intentFilter = new IntentFilter();
            intentFilter.addAction(WifiManager.WIFI_STATE_CHANGED_ACTION);// 监听wifi状态 打开，关闭状态
//        intentFilter.addAction(WifiManager.SCAN_RESULTS_AVAILABLE_ACTION);// wifi扫描结果 扫描完成后会发送广播
            intentFilter.addAction(WifiManager.NETWORK_STATE_CHANGED_ACTION); // wifi信息 连接状态
            registerReceiver(internetBroatcastReceived, intentFilter);
        }
    }

}
