package com.hotsausagecompany.app.hotsausagecompanytillcalculator.networking;

import android.app.ProgressDialog;
import android.content.Context;
import android.os.AsyncTask;
import android.widget.Toast;

import com.hotsausagecompany.app.hotsausagecompanytillcalculator.model.SalesDataModel;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.protocol.HTTP;
import org.apache.http.util.EntityUtils;
import org.json.JSONArray;
import org.json.JSONObject;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Admin on 09-10-2017.
 */

public class UploadSalesDataToServerWithoutSqlite extends AsyncTask<SalesDataModel,Void,String> {
    public static String URL_SALESDATA_WEBSERVICE="http://50.62.31.191/~sausage/SalesDataAPI.php";
    Context ctx;
    ProgressDialog progressDialog;

    public UploadSalesDataToServerWithoutSqlite(Context ctx) {
        this.ctx = ctx;
    }

    @Override
    protected void onPreExecute() {
        super.onPreExecute();
        progressDialog = new ProgressDialog(ctx);
        progressDialog.setMessage("Saving online...");
        progressDialog.show();
    }


    @Override
    protected String doInBackground(SalesDataModel... params) {
        SalesDataModel salesDataModel=params[0];
//        try {
//            HttpClient httpclient = new DefaultHttpClient();
//            HttpPost httppost5 = new HttpPost(URL_SALESDATA_WEBSERVICEZ);
//
//            JSONObject data5 = new JSONObject();
//            data5.put("business_user_id", user_id1);
//            data5.put("subscriber_phone", phone);
//            data5.put("login_pin", pin);
//            data5.put("location_id",BusinessUserSingletonModel.getBusinessUserObject().getMerchant_location_id());
//
//            JSONArray jsonArray5 = new JSONArray();
//            jsonArray5.put(data5);
//
//            List<NameValuePair> nvps5 = new ArrayList<NameValuePair>();
//            nvps5.add(new BasicNameValuePair("data", data5.toString()));
//            httppost5.setEntity(new UrlEncodedFormEntity(nvps5, HTTP.UTF_8));
//
//            httppost5.setHeader(HTTP.CONTENT_TYPE, "application/x-www-form-urlencoded;charset=UTF-8");
//            HttpResponse response5 = httpclient5.execute(httppost5);
//            HttpEntity resEntity5 = response5.getEntity();
//            if (resEntity5 != null) {
//                String responseStr5 = EntityUtils.toString(resEntity5).trim();
//                return responseStr5;
//            }
//        } catch (ClientProtocolException e) {
//            e.printStackTrace();
//        } catch (IOException e) {
//            e.printStackTrace();
//        } catch (Throwable t) {
//            Toast.makeText(SignInActivity.this, "Request failed: " + t.toString(),
//                    Toast.LENGTH_LONG).show();
//        }

        return null;
    }


    @Override
    protected void onPostExecute(String s) {
        super.onPostExecute(s);
        if(progressDialog.isShowing())
            progressDialog.dismiss();
    }
}
