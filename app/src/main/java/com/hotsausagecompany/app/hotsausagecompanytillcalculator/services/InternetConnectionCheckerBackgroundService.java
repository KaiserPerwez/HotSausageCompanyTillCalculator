package com.hotsausagecompany.app.hotsausagecompanytillcalculator.services;

import android.app.IntentService;
import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.support.annotation.IntDef;
import android.support.annotation.Nullable;

/**
 * Created by Admin on 10-10-2017.
 */

public class InternetConnectionCheckerBackgroundService extends IntentService {

    public InternetConnectionCheckerBackgroundService() {
        super("internetCheckerBgServiceName");
    }

    @Override
    protected void onHandleIntent(@Nullable Intent intent) {

    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        //TODO: restart the service
       startService(new Intent(this.getApplicationContext(),InternetConnectionCheckerBackgroundService.class));
    }
}
