package com.hotsausagecompany.app.hotsausagecompanytillcalculator;

import android.content.Context;
import android.os.AsyncTask;
import android.widget.Toast;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import it.sauronsoftware.ftp4j.FTPClient;

public class FtpHandlerStock extends AsyncTask<Void, Void, Void> {
    /*********  work only for Dedicated IP ***********/
    static final String FTP_HOST= "107.180.26.70";

    /*********  FTP USERNAME ***********/
    static final String FTP_USER = "app@on2designs.com";

    /*********  FTP PASSWORD ***********/
    static final String FTP_PASS  ="Appftp1986";

    String status = "FTP wasn't attempted";

    String sitename="not set";

    public void setSitename(String sitename){
        this.sitename=sitename;
    }

    public String getSitename(){
        return this.sitename;
    }

    public String doFtpTransfer(){
        doInBackground();
        return this.status;
    }

    @Override
    protected Void doInBackground(Void... params) {
        Calendar c = Calendar.getInstance();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
        String timestamp = sdf.format(c.getTimeInMillis());

        File f = new File("/storage/sdcard0/android/data/com.hotsausagecompany.app.hotsausagecompanytillcalculator/files/Documents/"+timestamp+"StockCheck.txt");

        // Upload sdcard file
        FTPClient client = new FTPClient();

        try {

            client.connect(FTP_HOST, 21);
            client.login(FTP_USER, FTP_PASS);
            client.setType(FTPClient.TYPE_BINARY);
            client.changeDirectory("/" + sitename + "/");

            client.upload(f);


            this.status="File transfer successful";


        } catch (Exception e) {
            this.status="Fail 1: "+e.getMessage();
            e.printStackTrace();
            try {
                client.disconnect(true);
            } catch (Exception e2) {
                e2.printStackTrace();
                this.status+="Fail 2: "+e2.getMessage();
            }

        }

        return null;
    }


}
