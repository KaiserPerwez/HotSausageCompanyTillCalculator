package com.hotsausagecompany.app.hotsausagecompanytillcalculator;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.widget.Toast;

import com.hotsausagecompany.app.hotsausagecompanytillcalculator.Menu;
import com.hotsausagecompany.app.hotsausagecompanytillcalculator.databaseHelper.DatabaseHelper;
import com.hotsausagecompany.app.hotsausagecompanytillcalculator.model.SalesDataModel;
import com.hotsausagecompany.app.hotsausagecompanytillcalculator.networking.ConnectionDetector;
import com.hotsausagecompany.app.hotsausagecompanytillcalculator.networking.SaveSalesData;
import com.hotsausagecompany.app.hotsausagecompanytillcalculator.services.InternetConnectionCheckerBackgroundService;

import java.util.Calendar;

public class AlarmReceiver extends BroadcastReceiver {

    @Override
    public void onReceive(Context context, Intent intent) {

        // For our recurring task, we'll just display a message
        Toast.makeText(context, "Alarm Receiver triggered", Toast.LENGTH_SHORT).show();

        int currentHour = Calendar.getInstance().get(Calendar.HOUR_OF_DAY);
        if (currentHour >= 6 || currentHour < 18) {
            //nothing to do
            Toast.makeText(context, "Inactive hours at alarm receiver", Toast.LENGTH_SHORT).show();
        } else {
            Toast.makeText(context, "Active hours at alarm receiver", Toast.LENGTH_SHORT).show();

            if (new ConnectionDetector(context).isConnectedToInternet()) {
                DatabaseHelper dbHelper = new DatabaseHelper(context);
                Cursor cursor = dbHelper.getUnsyncedSalesData();
                //int i=cursor.getCount();
                if (cursor != null && cursor.moveToFirst()) {
                    do {
                        SalesDataModel salesDataModel = Menu.convertCursorToSalesDataModel(cursor);
                        if (salesDataModel != null)
                            new SaveSalesData(context).saveDataOnline(salesDataModel);
                    } while (cursor.moveToNext());
                }
                dbHelper.close();
            }
        }
//        if(time is 6pm to 6am)
//        {
        //           Intent i = new Intent(context, InternetConnectionCheckerBackgroundService.class);
//            i.putExtra("name", "SurvivingwithAndroid");
        //         context.startService(i);
//        }
//        else {
//            Intent i = new Intent(context, InternetConnectionCheckerBackgroundService.class);
//            context.stopService(i);
//
//        }

    }
}