package com.example.androidnotes;

import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.DhcpInfo;
import android.net.NetworkInfo;
import android.net.wifi.SupplicantState;
import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import java.lang.ref.WeakReference;

import static android.content.Context.WIFI_SERVICE;

public class InternetBroatcastReceived extends BroadcastReceiver {
    WifiManager mWifiManager;

    public InternetBroatcastReceived(Context context) {

        mWifiManager = (WifiManager) context.getApplicationContext()
                .getSystemService(WIFI_SERVICE);
    }

    static final String TAG = "BroatcastReceived";

    @Override
    public void onReceive(Context context, Intent intent) {

        String action = intent.getAction();
        Log.i(TAG, "begin: " + action);
        switch (action) {
            case WifiManager.WIFI_STATE_CHANGED_ACTION:
                int wifiState = intent.getIntExtra(WifiManager.EXTRA_WIFI_STATE, -1);
                //对wifi的状态进行处理
                switch (wifiState) {
                    case WifiManager.WIFI_STATE_ENABLED:
                        //wifi已经打开..
                        Log.i(TAG, "onReceive: wifi已经打开");
                        break;
                    case WifiManager.WIFI_STATE_ENABLING:
                        //wifi打开中..
                        Log.i(TAG, "onReceive: wifi打开中");
                        break;
                    case WifiManager.WIFI_STATE_DISABLED:
                        //wifi关闭了..
                        Log.i(TAG, "onReceive: wifi关闭了");
                        break;
                    case WifiManager.WIFI_STATE_DISABLING:
                        //wifi关闭中..
                        Log.i(TAG, "onReceive: wifi关闭中");
                        break;
                    case WifiManager.WIFI_STATE_UNKNOWN:
                        //未知状态..
                        Log.i(TAG, "onReceive: 未知状态");
                        break;
                }
                break;
            case WifiManager.NETWORK_STATE_CHANGED_ACTION:
                NetworkInfo info = intent.getParcelableExtra(WifiManager.EXTRA_NETWORK_INFO);

                if (info.isConnected()) {
                    WifiManager wifiManager = (WifiManager) context.getApplicationContext().getSystemService(Context.WIFI_SERVICE);
                    Log.i(TAG, "onReceive: " + int2ip(wifiManager.getDhcpInfo().ipAddress));
                }
                break;
            case WifiManager.SCAN_RESULTS_AVAILABLE_ACTION:

                Log.i(TAG, "onReceive: WIFI扫描结果 " + intent.getBooleanExtra(WifiManager.EXTRA_RESULTS_UPDATED, false));
                // TODO 扫描到wifi后的操作
                break;
            default:
                Log.i(TAG, "onReceive: " + "none");
        }
    }

    public static String int2ip(int ipInt) {
        StringBuilder sb = new StringBuilder();
        sb.append(ipInt & 0xFF).append(".");
        sb.append((ipInt >> 8) & 0xFF).append(".");
        sb.append((ipInt >> 16) & 0xFF).append(".");
        sb.append((ipInt >> 24) & 0xFF);
        return sb.toString();
    }

}
