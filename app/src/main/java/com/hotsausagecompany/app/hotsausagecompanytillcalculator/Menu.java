package com.hotsausagecompany.app.hotsausagecompanytillcalculator;

import android.app.Activity;
import android.content.Intent;
import android.database.Cursor;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.os.Environment;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.hotsausagecompany.app.hotsausagecompanytillcalculator.databaseHelper.DatabaseHelper;
import com.hotsausagecompany.app.hotsausagecompanytillcalculator.model.SalesDataModel;
import com.hotsausagecompany.app.hotsausagecompanytillcalculator.networking.SaveSalesData;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;



public class Menu extends Activity implements View.OnClickListener {

    Button btn;
    TextView totalview;


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);

        totalview = (TextView) findViewById(R.id.totalview);
        Calendar c = Calendar.getInstance();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
        String timestamp = sdf.format(c.getTimeInMillis());

        //Start of total file reader
        File filetext = new File(getBaseContext().getExternalFilesDir(Environment.DIRECTORY_DOCUMENTS), timestamp+"total.txt");
        double total =0.00;

        if(filetext.exists()) {
            try {
                BufferedReader br = new BufferedReader(new FileReader(filetext));
                String line;
                while ((line = br.readLine()) != null) {
                    Log.d("Read from file", line);
                    total += Double.parseDouble(line);
                    totalview.setText("£" + total/100);
                }
                br.close();
            } catch (IOException e) {
                System.out.println("error");
            }
        }
        else{
            Toast.makeText(getBaseContext(), "There is currently no Total", Toast.LENGTH_LONG).show();
        }
        //End of file reader

        Button nav_stockcheck = (Button) findViewById(R.id.stockcheck_nav);
        nav_stockcheck.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {

                Bundle b2 = getIntent().getExtras();
                String sitename = b2.getString("sitename");

                Intent stockIntent = new Intent(view.getContext(), StockCheck.class);
                Bundle b = new Bundle();
                b.putString("sitename", sitename);
                stockIntent.putExtras(b);
                startActivityForResult(stockIntent, 0);

            }

        });

        Button nav_till = (Button) findViewById(R.id.till_nav);
        nav_till.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {

                Bundle b3 = getIntent().getExtras();
                String sitename = b3.getString("sitename");

                Bundle b03 = getIntent().getExtras();
                String lastsale = b03.getString("lastsale");

                if (sitename.equals("birmingham")) {
                    Intent birminghamIntent = new Intent(view.getContext(), TillActivityBirmingham.class);
                    Bundle b4 = new Bundle();
                    b4.putString("sitename", sitename);
                    Bundle b04 = new Bundle();
                    b04.putString("lastsale", lastsale);
                    birminghamIntent.putExtras(b4);
                    birminghamIntent.putExtras(b04);
                    startActivityForResult(birminghamIntent, 0);
                }
                else {
                    Intent tillIntent = new Intent(view.getContext(), TillActivity.class);
                    Bundle b5 = new Bundle();
                    b5.putString("sitename", sitename);
                    Bundle b05 = new Bundle();
                    b05.putString("lastsale", lastsale);
                    tillIntent.putExtras(b5);
                    tillIntent.putExtras(b05);
                    startActivityForResult(tillIntent, 0);
                }
            }

        });

        Button nav_logout = (Button) findViewById(R.id.logout_nav);
        nav_logout.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                Intent logoutIntent = new Intent(view.getContext(), MainActivity.class);
                startActivityForResult(logoutIntent, 0);

            }

        });

        btn = (Button) findViewById(R.id.send);
        btn.setOnClickListener((View.OnClickListener) this);

    }

    @Override
    public void onClick(View v) {

        ConnectivityManager connManager = (ConnectivityManager) getSystemService(CONNECTIVITY_SERVICE);
        NetworkInfo mWifi = connManager.getNetworkInfo(ConnectivityManager.TYPE_WIFI);
        if (mWifi.isConnected()) {

            //TODO:Ftp handler code comented by kaiser
            //this is the execute for the ftp.class
//            Toast.makeText(getBaseContext(), "SYNCRONISING WITH DATABASE PLEASE WAIT!", Toast.LENGTH_LONG).show();
//            FtpHandler ftpHandler = new FtpHandler();
//            ftpHandler.setSitename(getIntent().getExtras().getString("sitename"));
//            ftpHandler.execute();
//            System.out.println("Site name is:" + getIntent().getExtras().getString("sitename"));
            //this is the execute for the ftp.class

            Toast.makeText(getBaseContext(), "Code modified by kaiser", Toast.LENGTH_LONG).show();
            //sync sqlite table with server . Its one by one but try all at once
            DatabaseHelper dbHelper= new DatabaseHelper(this);
            Cursor cursor=dbHelper.getUnsyncedSalesData();
            if (cursor.moveToFirst()) {
                do {
                    SalesDataModel salesDataModel=convertCursorToSalesDataModel(cursor);
                    new SaveSalesData(this).saveDataOnline(salesDataModel);
                } while (cursor.moveToNext());
            }
            dbHelper.close();
        }
        else{
            Toast.makeText(getBaseContext(), "NO WIFI CONNECTION PLEASE CHECK AND RETRY!", Toast.LENGTH_LONG).show();
        }

    }
public static SalesDataModel convertCursorToSalesDataModel(Cursor cursor){
    SalesDataModel salesDataModel;
    cursor.getInt(cursor.getColumnIndex(DatabaseHelper.COLUMN_ID));

    int ID = cursor.getInt(cursor.getColumnIndex(DatabaseHelper.COLUMN_ID));
    int STATUS = cursor.getInt(cursor.getColumnIndex(DatabaseHelper.COLUMN_STATUS));
    String DATECOL =cursor.getString(cursor.getColumnIndex(DatabaseHelper.COLUMN_DATECOL));
    String TIMECOL =cursor.getString(cursor.getColumnIndex(DatabaseHelper.COLUMN_TIMECOL));
    String SITE = cursor.getString(cursor.getColumnIndex(DatabaseHelper.COLUMN_SITE));
    String REGULAR = cursor.getString(cursor.getColumnIndex(DatabaseHelper.COLUMN_REGULAR));
    String REGULAR_AND_CHEESE = cursor.getString(cursor.getColumnIndex(DatabaseHelper.COLUMN_REGULAR_AND_CHEESE));
    String LARGE =cursor.getString(cursor.getColumnIndex(DatabaseHelper.COLUMN_LARGE));
    String LARGE_AND_CHEESE = cursor.getString(cursor.getColumnIndex(DatabaseHelper.COLUMN_LARGE_AND_CHEESE));
    String FOOTLONG = cursor.getString(cursor.getColumnIndex(DatabaseHelper.COLUMN_FOOTLONG));
    String FOOTLONG_AND_CHEESE = cursor.getString(cursor.getColumnIndex(DatabaseHelper.COLUMN_FOOTLONG_AND_CHEESE));
    String SPECIAL =cursor.getString(cursor.getColumnIndex(DatabaseHelper.COLUMN_SPECIAL));
    String SPECIAL_AND_CHEESE = cursor.getString(cursor.getColumnIndex(DatabaseHelper.COLUMN_SPECIAL_AND_CHEESE));
    String DRINK =cursor.getString(cursor.getColumnIndex(DatabaseHelper.COLUMN_DRINK));
    String EXTRA_CHEESE = cursor.getString(cursor.getColumnIndex(DatabaseHelper.COLUMN_EXTRA_CHEESE));
    String NO_BUN =cursor.getString(cursor.getColumnIndex(DatabaseHelper.COLUMN_NO_BUN));
    String HALF_REGULAR = cursor.getString(cursor.getColumnIndex(DatabaseHelper.COLUMN_HALF_REGULAR));
    String HALF_REGULAR_AND_CHEESE = cursor.getString(cursor.getColumnIndex(DatabaseHelper.COLUMN_HALF_REGULAR_AND_CHEESE));
    String HALF_LARGE =cursor.getString(cursor.getColumnIndex(DatabaseHelper.COLUMN_HALF_LARGE));
    String HALF_LARGE_AND_CHEESE = cursor.getString(cursor.getColumnIndex(DatabaseHelper.COLUMN_HALF_LARGE_AND_CHEESE));
    String HALF_FOOTLONG =cursor.getString(cursor.getColumnIndex(DatabaseHelper.COLUMN_HALF_FOOTLONG));
    String HALF_FOOTLONG_AND_CHEESE = cursor.getString(cursor.getColumnIndex(DatabaseHelper.COLUMN_HALF_FOOTLONG_AND_CHEESE));
    String HALF_SPECIAL = cursor.getString(cursor.getColumnIndex(DatabaseHelper.COLUMN_HALF_SPECIAL));
    String HALF_SPECIAL_AND_CHEESE = cursor.getString(cursor.getColumnIndex(DatabaseHelper.COLUMN_HALF_SPECIAL_AND_CHEESE));
    String HALF_DRINK = cursor.getString(cursor.getColumnIndex(DatabaseHelper.COLUMN_HALF_DRINK));
    String FULL_REGULAR = cursor.getString(cursor.getColumnIndex(DatabaseHelper.COLUMN_FULL_REGULAR));
    String FULL_REGULAR_AND_CHEESE = cursor.getString(cursor.getColumnIndex(DatabaseHelper.COLUMN_FULL_REGULAR_AND_CHEESE));
    String FULL_LARGE = cursor.getString(cursor.getColumnIndex(DatabaseHelper.COLUMN_FULL_LARGE));
    String FULL_LARGE_AND_CHEESE = cursor.getString(cursor.getColumnIndex(DatabaseHelper.COLUMN_FULL_LARGE_AND_CHEESE));
    String FULL_FOOTLONG = cursor.getString(cursor.getColumnIndex(DatabaseHelper.COLUMN_FULL_FOOTLONG));
    String FULL_FOOTLONG_AND_CHEESE = cursor.getString(cursor.getColumnIndex(DatabaseHelper.COLUMN_FULL_FOOTLONG_AND_CHEESE));
    String FULL_SPECIAL =cursor.getString(cursor.getColumnIndex(DatabaseHelper.COLUMN_FULL_SPECIAL));
    String FULL_SPECIAL_AND_CHEESE = cursor.getString(cursor.getColumnIndex(DatabaseHelper.COLUMN_FULL_SPECIAL_AND_CHEESE));
    String FULL_DRINK = cursor.getString(cursor.getColumnIndex(DatabaseHelper.COLUMN_FULL_DRINK));
    String STAFF_REGULAR = cursor.getString(cursor.getColumnIndex(DatabaseHelper.COLUMN_STAFF_REGULAR));
    String STAFF_REGULAR_AND_CHEESE = cursor.getString(cursor.getColumnIndex(DatabaseHelper.COLUMN_STAFF_REGULAR_AND_CHEESE));
    String STAFF_LARGE =cursor.getString(cursor.getColumnIndex(DatabaseHelper.COLUMN_STAFF_LARGE));
    String STAFF_LARGE_AND_CHEESE = cursor.getString(cursor.getColumnIndex(DatabaseHelper.COLUMN_STAFF_LARGE_AND_CHEESE));
    String STAFF_FOOTLONG = cursor.getString(cursor.getColumnIndex(DatabaseHelper.COLUMN_STAFF_FOOTLONG));
    String STAFF_FOOTLONG_AND_CHEESE = cursor.getString(cursor.getColumnIndex(DatabaseHelper.COLUMN_STAFF_FOOTLONG_AND_CHEESE));
    String STAFF_SPECIAL =cursor.getString(cursor.getColumnIndex(DatabaseHelper.COLUMN_STAFF_SPECIAL));
    String STAFF_SPECIAL_AND_CHEESE = cursor.getString(cursor.getColumnIndex(DatabaseHelper.COLUMN_STAFF_SPECIAL_AND_CHEESE));
    String STAFF_DRINK = cursor.getString(cursor.getColumnIndex(DatabaseHelper.COLUMN_STAFF_DRINK));
    String REGULAR_WASTE = cursor.getString(cursor.getColumnIndex(DatabaseHelper.COLUMN_REGULAR_WASTE));
    String LARGE_WASTE = cursor.getString(cursor.getColumnIndex(DatabaseHelper.COLUMN_LARGE_WASTE));
    String FOOTLONG_WASTE = cursor.getString(cursor.getColumnIndex(DatabaseHelper.COLUMN_FOOTLONG_WASTE));
    String SPECIAL_WASTE = cursor.getString(cursor.getColumnIndex(DatabaseHelper.COLUMN_SPECIAL_WASTE));
    String SMALL_BUN_WASTE = cursor.getString(cursor.getColumnIndex(DatabaseHelper.COLUMN_SMALL_BUN_WASTE));
    String LARGE_BUN_WASTE = cursor.getString(cursor.getColumnIndex(DatabaseHelper.COLUMN_LARGE_BUN_WASTE));
    String TOTAL =cursor.getString(cursor.getColumnIndex(DatabaseHelper.COLUMN_TOTAL));


    salesDataModel=new SalesDataModel(STATUS,DATECOL,TIMECOL,SITE,REGULAR,REGULAR_AND_CHEESE,LARGE,LARGE_AND_CHEESE,FOOTLONG,FOOTLONG_AND_CHEESE,SPECIAL,SPECIAL_AND_CHEESE,DRINK,EXTRA_CHEESE,NO_BUN, HALF_REGULAR,HALF_REGULAR_AND_CHEESE,HALF_LARGE,HALF_LARGE_AND_CHEESE,HALF_FOOTLONG,HALF_FOOTLONG_AND_CHEESE,HALF_SPECIAL,HALF_SPECIAL_AND_CHEESE,HALF_DRINK, FULL_REGULAR, FULL_REGULAR_AND_CHEESE, FULL_LARGE, FULL_LARGE_AND_CHEESE, FULL_FOOTLONG, FULL_FOOTLONG_AND_CHEESE, FULL_SPECIAL, FULL_SPECIAL_AND_CHEESE, FULL_DRINK, STAFF_REGULAR, STAFF_REGULAR_AND_CHEESE, STAFF_LARGE, STAFF_LARGE_AND_CHEESE, STAFF_FOOTLONG, STAFF_FOOTLONG_AND_CHEESE, STAFF_SPECIAL, STAFF_SPECIAL_AND_CHEESE, STAFF_DRINK, REGULAR_WASTE, LARGE_WASTE, FOOTLONG_WASTE, SPECIAL_WASTE, SMALL_BUN_WASTE, LARGE_BUN_WASTE,TOTAL);
    salesDataModel.setId(ID);
return salesDataModel;
}
}




















