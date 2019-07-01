package com.example.androidnotes;

import android.content.IntentFilter;
import android.net.wifi.WifiManager;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;

import com.example.androidnotes.Broatcast.InternetBroatcastReceived;
import com.example.androidnotes.R;

public class MainActivity extends AppCompatActivity {

    private MyBroatcast myBroatcast; // wifi广播

    InternetBroatcastReceived internetBroatcastReceived;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
        initData();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        unregisterReceiver(internetBroatcastReceived);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    private void initData(){
        myBroatcast = new MyBroatcast();
    }

    class MyBroatcast{
        public void init(){
            // 注册广播
            internetBroatcastReceived  = new InternetBroatcastReceived(MainActivity.this);
            IntentFilter intentFilter=new IntentFilter();
            intentFilter.addAction(WifiManager.WIFI_STATE_CHANGED_ACTION);// 监听wifi状态 打开，关闭状态
//        intentFilter.addAction(WifiManager.SCAN_RESULTS_AVAILABLE_ACTION);// wifi扫描结果 扫描完成后会发送广播
            intentFilter.addAction(WifiManager.NETWORK_STATE_CHANGED_ACTION); // wifi信息 连接状态
            registerReceiver(internetBroatcastReceived,intentFilter);
        }
    }

}
