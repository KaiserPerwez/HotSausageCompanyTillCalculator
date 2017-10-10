package com.hotsausagecompany.app.hotsausagecompanytillcalculator.networking;

import android.app.ProgressDialog;
import android.content.Context;
import android.os.AsyncTask;

/**
 * Created by Admin on 09-10-2017.
 */

public class SyncSalesDataToServer extends AsyncTask<Void,Void,Void> {
    Context ctx;
    ProgressDialog progressDialog;
    public SyncSalesDataToServer(Context ctx) {
        this.ctx = ctx;
    }

    @Override
    protected void onPreExecute() {
        super.onPreExecute();
        progressDialog = new ProgressDialog(ctx);
        progressDialog.setMessage("Synchronizing...");
        progressDialog.show();
    }

    @Override
    protected Void doInBackground(Void... params) {

        //TODO:check which data is unsynced,send all those rows to server,get ids in response,
        // send those ids to postexecute where they are used to update sqlite
        return null;
    }
    @Override
    protected void onPostExecute(Void aVoid) {
        super.onPostExecute(aVoid);
        if(progressDialog.isShowing())
        progressDialog.dismiss();
    }
}

