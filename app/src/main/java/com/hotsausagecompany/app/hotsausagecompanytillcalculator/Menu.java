package com.hotsausagecompany.app.hotsausagecompanytillcalculator;

import android.app.Activity;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.os.Environment;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;
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

            //this is the execute for the ftp.class
            Toast.makeText(getBaseContext(), "SYNCRONISING WITH DATABASE PLEASE WAIT!", Toast.LENGTH_LONG).show();
            FtpHandler ftpHandler = new FtpHandler();
            ftpHandler.setSitename(getIntent().getExtras().getString("sitename"));
            ftpHandler.execute();
            System.out.println("Site name is:" + getIntent().getExtras().getString("sitename"));
            //this is the execute for the ftp.class



        }
        else{
            Toast.makeText(getBaseContext(), "NO WIFI CONNECTION PLEASE CHECK AND RETRY!", Toast.LENGTH_LONG).show();
        }

    }




}
