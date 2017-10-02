package com.hotsausagecompany.app.hotsausagecompanytillcalculator;

import android.widget.Toast;

import it.sauronsoftware.ftp4j.FTPDataTransferListener;

public class MyTransferListener implements FTPDataTransferListener {

    public void started() {
        System.out.println("The FTP upload has started");

    }

    public void transferred(int length) {
        // Yet other length bytes has been transferred since the last time this
        // method was called
    }

    public void completed() {
        System.out.println("The FTP upload has Finished!!!!!!!!!!!!!!!!!!!!!");
    }

    public void aborted() {
        // Transfer aborted
    }

    public void failed() {
        // Transfer failed
    }

}