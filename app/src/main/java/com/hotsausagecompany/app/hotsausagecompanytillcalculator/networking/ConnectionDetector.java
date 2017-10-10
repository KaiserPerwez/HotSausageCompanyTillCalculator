package com.hotsausagecompany.app.hotsausagecompanytillcalculator.networking;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;

/**
 * Created by Admin on 09-10-2017.
 */

public class ConnectionDetector {
    private Context _context;

    public ConnectionDetector(Context context) {
        this._context = context;
    }

    public boolean isConnectedToInternet() {
        ConnectivityManager connectivityManager = (ConnectivityManager) _context.getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo networkInfoWifi = connectivityManager.getNetworkInfo(ConnectivityManager.TYPE_WIFI);
//        if(networkInfoWifi.getState()==NetworkInfo.State.CONNECTED){
//
//        }
        if (networkInfoWifi.isConnected()) {
            return true;
        }
        return false;
    }
}
