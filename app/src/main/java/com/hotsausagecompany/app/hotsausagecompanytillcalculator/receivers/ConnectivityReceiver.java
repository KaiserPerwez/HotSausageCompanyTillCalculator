package com.hotsausagecompany.app.hotsausagecompanytillcalculator.receivers;

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

/**
 * Created by Admin on 10-10-2017.
 */

public class ConnectivityReceiver extends BroadcastReceiver {
    @Override
    public void onReceive(Context context, Intent intent) {
        Toast.makeText(context, "Connectivity Changed", Toast.LENGTH_SHORT).show();
        if (new ConnectionDetector(context).isConnectedToInternet()) {
            //initiate version.txt downloadmanager method
            //getVersionFromServer("http://www.hotsausagecompany.com/app/version.txt", "version.txt");
            DatabaseHelper dbHelper = new DatabaseHelper(context);
            Cursor cursor = dbHelper.getUnsyncedSalesData();
            int i=cursor.getCount();
            Toast.makeText(context, "Uploading "+i+" data to online server", Toast.LENGTH_SHORT).show();
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
}
