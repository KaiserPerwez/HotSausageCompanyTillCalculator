package com.hotsausagecompany.app.hotsausagecompanytillcalculator;

import android.os.AsyncTask;

import java.io.File;
import java.text.SimpleDateFormat;
        import java.util.Calendar;

        import it.sauronsoftware.ftp4j.FTPClient;

public class FtpHandler extends AsyncTask<Void, Void, Void> {
    /*********  work only for Dedicated IP ***********/
    static final String FTP_HOST= "107.180.26.70";

    /*********  FTP USERNAME ***********/
    static final String FTP_USER = "app@on2designs.com";

    /*********  FTP PASSWORD ***********/
    static final String FTP_PASS  ="Appftp1986";

    String status = "FTP wasn't attempted";

    String sitename="not set";


    String time;

    @Override
    protected Void doInBackground(Void... params) {
        Calendar c = Calendar.getInstance();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
        String timestamp = sdf.format(c.getTimeInMillis());

        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyyMMdd");
        Calendar cal = Calendar.getInstance();
        cal.add(Calendar.DATE, -1);
        String timestamp1 = dateFormat.format(cal.getTime());

        Calendar cal2 = Calendar.getInstance();
        cal2.add(Calendar.DATE, -2);
        String timestamp2 = dateFormat.format(cal2.getTime());

        Calendar cal3 = Calendar.getInstance();
        cal3.add(Calendar.DATE, -3);
        String timestamp3 = dateFormat.format(cal3.getTime());

        Calendar cal4 = Calendar.getInstance();
        cal4.add(Calendar.DATE, -4);
        String timestamp4 = dateFormat.format(cal4.getTime());

        Calendar cal5 = Calendar.getInstance();
        cal5.add(Calendar.DATE, -5);
        String timestamp5 = dateFormat.format(cal5.getTime());

        Calendar cal6 = Calendar.getInstance();
        cal6.add(Calendar.DATE, -6);
        String timestamp6 = dateFormat.format(cal6.getTime());

        SimpleDateFormat stf = new SimpleDateFormat("HHmm");

        time = stf.format(c.getTimeInMillis());
        int timeInt = Integer.parseInt(time);

        File f = new File("/storage/sdcard0/android/data/com.hotsausagecompany.app.hotsausagecompanytillcalculator/files/Documents/"+timestamp+"SalesData.txt");
        File f1 = new File("/storage/sdcard0/android/data/com.hotsausagecompany.app.hotsausagecompanytillcalculator/files/Documents/"+timestamp1+"SalesData.txt");
        File f2 = new File("/storage/sdcard0/android/data/com.hotsausagecompany.app.hotsausagecompanytillcalculator/files/Documents/"+timestamp2+"SalesData.txt");
        File f3 = new File("/storage/sdcard0/android/data/com.hotsausagecompany.app.hotsausagecompanytillcalculator/files/Documents/"+timestamp3+"SalesData.txt");
        File f4 = new File("/storage/sdcard0/android/data/com.hotsausagecompany.app.hotsausagecompanytillcalculator/files/Documents/"+timestamp4+"SalesData.txt");
        File f5 = new File("/storage/sdcard0/android/data/com.hotsausagecompany.app.hotsausagecompanytillcalculator/files/Documents/"+timestamp5+"SalesData.txt");
        File f6 = new File("/storage/sdcard0/android/data/com.hotsausagecompany.app.hotsausagecompanytillcalculator/files/Documents/"+timestamp6+"SalesData.txt");
        // Upload sdcard file
        FTPClient client = new FTPClient();

        try {

            client.connect(FTP_HOST, 21);
            client.login(FTP_USER, FTP_PASS);
            client.setType(FTPClient.TYPE_BINARY);
            client.changeDirectory("/" + sitename + "/");


            client.upload(f);
            client.upload(f1);
            client.upload(f2);
            client.upload(f3);
            client.upload(f4);
            client.upload(f5);
            client.upload(f6);
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

    public void setSitename(String sitename){
        this.sitename=sitename;
    }

    public String getSitename(){
        return this.sitename;
    }

}
