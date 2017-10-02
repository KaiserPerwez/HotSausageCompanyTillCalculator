package com.hotsausagecompany.app.hotsausagecompanytillcalculator;

import android.app.AlarmManager;
import android.app.DownloadManager;
import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.Uri;
import android.os.Bundle;
import android.app.Activity;
import android.os.Environment;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;
import java.io.File;
import java.util.Calendar;
import java.util.TimeZone;


public class MainActivity extends Activity {

    // User name
    private EditText et_Username;
    // Password
    private EditText et_Password;
    // Sign In
    private Button bt_SignIn;
    // Message
    String dev;
    String fitzroy;
    String market;
    String birmingham;
    String york;
    String stevenage;
    String ipswich1;
    String ipswich2;
    String colchester;
    String bromley;
    String bath;
    String taunton;
    String clarks;
    String yeovil;
    String exeter;

    //alarm manager
    private PendingIntent pendingIntent;





    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


 /* Retrieve a PendingIntent that will perform a broadcast */
        Intent alarmIntent = new Intent(MainActivity.this, AlarmReceiver.class);
        pendingIntent = PendingIntent.getBroadcast(MainActivity.this, 0, alarmIntent, 0);

        startAt10();


       /* // Set the alarm to start at approximately 2:00 p.m.
        Calendar calendar = Calendar.getInstance();
        calendar.setTimeInMillis(System.currentTimeMillis());
        calendar.set(Calendar.HOUR_OF_DAY, 11);

// With setInexactRepeating(), you have to use one of the AlarmManager interval
// constants--in this case, AlarmManager.INTERVAL_DAY.
        alarmMgr.setInexactRepeating(AlarmManager.RTC_WAKEUP, calendar.getTimeInMillis(),
                AlarmManager.INTERVAL_DAY, alarmIntent);
*/

        //Check for Wifi State to launch file download
        ConnectivityManager connManager = (ConnectivityManager) getSystemService(CONNECTIVITY_SERVICE);
        NetworkInfo mWifi = connManager.getNetworkInfo(ConnectivityManager.TYPE_WIFI);
        if (mWifi.isConnected()){
            //initiate version.txt downloadmanager method
            //getVersionFromServer("http://www.hotsausagecompany.com/app/version.txt", "version.txt");
        }


        // Initialization
        et_Username = (EditText) findViewById(R.id.et_Username);
        et_Password = (EditText) findViewById(R.id.et_Password);
        bt_SignIn = (Button) findViewById(R.id.bt_SignIn);
        dev = "developer";
        fitzroy = "fitzroystreet";
        market = "marketstreet";
        birmingham = "birmingham";
        york = "york";
        stevenage = "stevenage";
        ipswich1 = "ipswich1";
        ipswich2 = "ipswich2";
        colchester = "colchester";
        bromley = "bromley";
        bath = "bath";
        taunton = "taunton";
        clarks = "clarks";
        yeovil = "yeovil";
        exeter = "exeter";

        bt_SignIn.setOnClickListener(new OnClickListener() {

            @Override
            public void onClick(View view) {



                // Stores User name
                String username = String.valueOf(et_Username.getText());
                // Stores Password
                String password = String.valueOf(et_Password.getText());

                // Validates the User name and Password for admin, admin
                if (username.equals("dev") && password.equals("dev123")) {

                    Toast.makeText(getBaseContext(), "Login Sucsessfull! Welcome App Developer!", Toast.LENGTH_LONG).show();
                    Intent devIntent = new Intent(view.getContext(), TillActivity.class);
                    Bundle b1 = new Bundle();
                    b1.putString("sitename", dev);
                    devIntent.putExtras(b1);
                    startActivityForResult(devIntent, 0);

                }
                else if (username.equals("marketstreet") && password.equals("market123")) {
                    Toast.makeText(getBaseContext(), "Login Sucsessfull! Welcome Market Street!", Toast.LENGTH_LONG).show();
                    Intent marketIntent = new Intent(view.getContext(), TillActivity.class);
                    Bundle b3 = new Bundle();
                    b3.putString("sitename", market);
                    marketIntent.putExtras(b3);
                    startActivityForResult(marketIntent, 0);
                }
                else if (username.equals("fitzroystreet") && password.equals("fitzroy123")) {
                    Toast.makeText(getBaseContext(), "Login Sucsessfull! Welcome Fitzroy Street!", Toast.LENGTH_LONG).show();
                    Intent fitzroyIntent = new Intent(view.getContext(), TillActivity.class);
                    Bundle b2 = new Bundle();
                    b2.putString("sitename", fitzroy);
                    fitzroyIntent.putExtras(b2);
                    startActivityForResult(fitzroyIntent, 0);
                }
                else if (username.equals("york") && password.equals("york123")) {
                    Toast.makeText(getBaseContext(), "Login Sucsessfull! Welcome York!", Toast.LENGTH_LONG).show();
                    Intent yorkIntent = new Intent(view.getContext(), TillActivity.class);
                    Bundle b5 = new Bundle();
                    b5.putString("sitename", york);
                    yorkIntent.putExtras(b5);
                    startActivityForResult(yorkIntent, 0);
                }
                else if (username.equals("ipswich1") && password.equals("ipswich1123")) {
                    Toast.makeText(getBaseContext(), "Login Sucsessfull! Welcome Ipswich1!", Toast.LENGTH_LONG).show();
                    Intent ipswich1Intent = new Intent(view.getContext(), TillActivity.class);
                    Bundle b7 = new Bundle();
                    b7.putString("sitename", ipswich1);
                    ipswich1Intent.putExtras(b7);
                    startActivityForResult(ipswich1Intent, 0);
                }
                else if (username.equals("ipswich2") && password.equals("ipswich2123")) {
                    Toast.makeText(getBaseContext(), "Login Sucsessfull! Welcome Ipswich2!", Toast.LENGTH_LONG).show();
                    Intent ipswich2Intent = new Intent(view.getContext(), TillActivity.class);
                    Bundle b8 = new Bundle();
                    b8.putString("sitename", ipswich2);
                    ipswich2Intent.putExtras(b8);
                    startActivityForResult(ipswich2Intent, 0);
                }
                else if (username.equals("colchester") && password.equals("colchester123")) {
                    Toast.makeText(getBaseContext(), "Login Sucsessfull! Welcome Colchester!", Toast.LENGTH_LONG).show();
                    Intent colchesterIntent = new Intent(view.getContext(), TillActivity.class);
                    Bundle b9 = new Bundle();
                    b9.putString("sitename", colchester);
                    colchesterIntent.putExtras(b9);
                    startActivityForResult(colchesterIntent, 0);
                }
                else if (username.equals("bromley") && password.equals("bromley123")) {
                    Toast.makeText(getBaseContext(), "Login Sucsessfull! Welcome Bromley!", Toast.LENGTH_LONG).show();
                    Intent bromleyIntent = new Intent(view.getContext(), TillActivity.class);
                    Bundle b10 = new Bundle();
                    b10.putString("sitename", bromley);
                    bromleyIntent.putExtras(b10);
                    startActivityForResult(bromleyIntent, 0);
                }
                else if (username.equals("bath") && password.equals("bath123")) {
                    Toast.makeText(getBaseContext(), "Login Sucsessfull! Welcome Bath!", Toast.LENGTH_LONG).show();
                    Intent bathIntent = new Intent(view.getContext(), TillActivity.class);
                    Bundle b11 = new Bundle();
                    b11.putString("sitename", bath);
                    bathIntent.putExtras(b11);
                    startActivityForResult(bathIntent, 0);
                }
                else if (username.equals("taunton") && password.equals("taunton123")) {
                    Toast.makeText(getBaseContext(), "Login Sucsessfull! Welcome Taunton!", Toast.LENGTH_LONG).show();
                    Intent tauntonIntent = new Intent(view.getContext(), TillActivity.class);
                    Bundle b12 = new Bundle();
                    b12.putString("sitename", taunton);
                    tauntonIntent.putExtras(b12);
                    startActivityForResult(tauntonIntent, 0);
                }
                else if (username.equals("exeter") && password.equals("exeter123")) {
                    Toast.makeText(getBaseContext(), "Login Sucsessfull! Welcome Exeter!", Toast.LENGTH_LONG).show();
                    Intent exeterIntent = new Intent(view.getContext(), TillActivity.class);
                    Bundle b13 = new Bundle();
                    b13.putString("sitename", exeter);
                    exeterIntent.putExtras(b13);
                    startActivityForResult(exeterIntent, 0);
                }
                else if (username.equals("stevenage") && password.equals("stevenage123")) {
                    Toast.makeText(getBaseContext(), "Login Sucsessfull! Welcome Stevenage!", Toast.LENGTH_LONG).show();
                    Intent stevenageIntent = new Intent(view.getContext(), TillActivity.class);
                    Bundle b14 = new Bundle();
                    b14.putString("sitename", stevenage);
                    stevenageIntent.putExtras(b14);
                    startActivityForResult(stevenageIntent, 0);
                }
                else if (username.equals("birmingham") && password.equals("birmingham123")) {
                    Toast.makeText(getBaseContext(), "Login Sucsessfull! Welcome Birmingham!", Toast.LENGTH_LONG).show();
                    Intent birminghamIntent = new Intent(view.getContext(), TillActivityBirmingham.class);
                    Bundle b4 = new Bundle();
                    b4.putString("sitename", birmingham);
                    birminghamIntent.putExtras(b4);
                    startActivityForResult(birminghamIntent, 0);
                }
                else if (username.equals("clarks") && password.equals("clarks123")) {
                    Toast.makeText(getBaseContext(), "Login Sucsessfull! Welcome Clarks Village!", Toast.LENGTH_LONG).show();
                    Intent clarksIntent = new Intent(view.getContext(), TillActivity.class);
                    Bundle b15 = new Bundle();
                    b15.putString("sitename", clarks);
                    clarksIntent.putExtras(b15);
                    startActivityForResult(clarksIntent, 0);
                }
                else if (username.equals("yeovil") && password.equals("yeovil123")) {
                    Toast.makeText(getBaseContext(), "Login Sucsessfull! Welcome Yeovil!", Toast.LENGTH_LONG).show();
                    Intent yeovilIntent = new Intent(view.getContext(), TillActivity.class);
                    Bundle b16 = new Bundle();
                    b16.putString("sitename", yeovil);
                    yeovilIntent.putExtras(b16);
                    startActivityForResult(yeovilIntent, 0);
                }
                else {
                    Toast.makeText(getBaseContext(), "LOGIN FAILED PLEASE CHECK DETAILS AND RETRY!!", Toast.LENGTH_LONG).show();
                }
            }


        });



        //imagebutton for update file download
        ImageButton update = (ImageButton) findViewById(R.id.update);
        update.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {

                ConnectivityManager connManager2 = (ConnectivityManager) getSystemService(CONNECTIVITY_SERVICE);
                NetworkInfo mWifi2 = connManager2.getNetworkInfo(ConnectivityManager.TYPE_WIFI);
                if (mWifi2.isConnected()){
                    //version checker and APP UPDATE launcher

                        Toast.makeText(getBaseContext(), "UPDATE IS DOWNLOADING PLEASE WAIT!", Toast.LENGTH_LONG).show();
                        startDownload("http://www.hotsausagecompany.com/app/app-release.apk", "app-release.apk");

                }
                else {
                    Toast.makeText(getBaseContext(), "UPDATE FAILED! YOU ARE NOT CONNECTED TO THE INTERNET!!", Toast.LENGTH_LONG).show();
                }


            }

        });

    }





    //method for download app-release.apk from server
    public void startDownload(String url ,String fileName)
    {
        Log.d("Download Url", url);
        DownloadManager.Request request = new DownloadManager.Request(Uri.parse(url));
        request.setTitle("Hot Sausage Company App");
        request.setDescription(fileName + " is downloading..");
        request.setDestinationInExternalPublicDir(Environment.DIRECTORY_DOWNLOADS, fileName);
        DownloadManager downloadManager = (DownloadManager) getSystemService(Context.DOWNLOAD_SERVICE);
        long myDownloadReference = downloadManager.enqueue(request);
        registerReceiver(onComplete, new IntentFilter(DownloadManager.ACTION_DOWNLOAD_COMPLETE));
    }

    //receive notification that download has completed
    BroadcastReceiver onComplete=new BroadcastReceiver() {
        public void onReceive(Context ctxt, Intent intent) {
            //initiate APK installation
            //APK will be deleted when new version of the app boots
            //delete called at the top of oncreate method
            File apkFile = new File("/sdcard/download/app-release.apk");
            Intent ExecuteIntent = new Intent(Intent.ACTION_VIEW);
            ExecuteIntent.setDataAndType(Uri.fromFile(apkFile), "application/vnd.android.package-archive");
            startActivity(ExecuteIntent);
        }
    };


    public void startAt10() {
        AlarmManager manager = (AlarmManager) getSystemService(Context.ALARM_SERVICE);
        int interval = 1000 * 60 * 20;

        /* Set the alarm to start at 10:30 AM */
        Calendar calendar = Calendar.getInstance();
        calendar.setTimeZone(TimeZone.getTimeZone("London"));
        calendar.setTimeInMillis(System.currentTimeMillis());
        calendar.set(Calendar.HOUR_OF_DAY, 12);
        calendar.set(Calendar.MINUTE, 40);

        /* Repeating on every 20 minutes interval */
        manager.setRepeating(AlarmManager.RTC_WAKEUP, calendar.getTimeInMillis(),
                1000 * 60 * 20, pendingIntent);

        Toast.makeText(getBaseContext(), "Alarm has been set!", Toast.LENGTH_SHORT).show();
    }


}