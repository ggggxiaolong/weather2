package com.example.mrtan.weather.util;

import android.app.Application;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.wifi.WifiManager;
import android.telephony.TelephonyManager;

import javax.inject.Inject;
import javax.inject.Singleton;

import rx.Observable;
import rx.functions.Func1;
import rx.subjects.BehaviorSubject;

@Singleton
public class NetworkStatus extends BroadcastReceiver {

    private final ConnectivityManager mConnectivityManager;
    private final WifiManager mWifiManager;
    //BehaviorSubject会发送离订阅最近的上一个值，没有上一个值的时候会发送默认值。
    private final BehaviorSubject<Boolean> mOnchangeSubject = BehaviorSubject.create();

    @Inject
    public NetworkStatus(Application ctx){
        mConnectivityManager = (ConnectivityManager) ctx.getSystemService(Context.CONNECTIVITY_SERVICE);
        mWifiManager = (WifiManager) ctx.getSystemService(Context.WIFI_SERVICE);
    }

    public Observable<Boolean> onChange() {
        return mOnchangeSubject.distinctUntilChanged();
    }

    public Observable<Void> onConnect() {
        return mOnchangeSubject.filter(new Func1<Boolean, Boolean>() {
            @Override
            public Boolean call(Boolean aBoolean) {
                return aBoolean;
            }
        }).map(new Func1<Boolean, Void>() {
            @Override
            public Void call(Boolean aBoolean) {
                return null;
            }
        });
    }

    public Observable<Void> onDisconnect() {
        return mOnchangeSubject.filter(new Func1<Boolean, Boolean>() {
            @Override
            public Boolean call(Boolean aBoolean) {
                return !aBoolean;
            }
        }).map(new Func1<Boolean, Void>() {
            @Override
            public Void call(Boolean aBoolean) {
                return null;
            }
        });
    }

    @Override
    public void onReceive(Context context, Intent intent) {
        boolean isInternetConnected = isConnected();
        mOnchangeSubject.onNext(isInternetConnected);
    }

    private boolean isConnected() {
        return isGoodConnected();
    }

    public boolean isGoodConnected() {
        NetworkInfo networkInfo = mConnectivityManager.getActiveNetworkInfo();
        return networkInfo != null && isGoodConnection(networkInfo);
    }

    private boolean isGoodConnection(NetworkInfo networkInfo) {
        return networkInfo.isConnected() && (isGoodWifiConnection(networkInfo) || isGoodCellularConnection(networkInfo));
    }

    private boolean isGoodCellularConnection(NetworkInfo networkInfo) {
        int networkType = networkInfo.getSubtype();
        return networkType != TelephonyManager.NETWORK_TYPE_GPRS
                && networkType != TelephonyManager.NETWORK_TYPE_EDGE
                && networkType != TelephonyManager.NETWORK_TYPE_CDMA
                && networkType != TelephonyManager.NETWORK_TYPE_1xRTT
                && networkType != TelephonyManager.NETWORK_TYPE_IDEN;

    }

    private boolean isGoodWifiConnection(NetworkInfo networkInfo) {
       return (networkInfo.getType() == ConnectivityManager.TYPE_WIFI)
               && (WifiManager.calculateSignalLevel(mWifiManager.getConnectionInfo().getRssi(), 4) > 0);
    }

}
