package com.hotsausagecompany.app.hotsausagecompanytillcalculator.networking;

import android.app.ProgressDialog;
import android.content.Context;
import android.os.AsyncTask;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.hotsausagecompany.app.hotsausagecompanytillcalculator.databaseHelper.DatabaseHelper;
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
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Admin on 09-10-2017.
 */

public class SaveSalesData {
    public static String URL_SALESDATA_WEBSERVICE = "http://50.62.31.191/~sausage/SalesDataAPI.php";
    Context ctx;

    public SaveSalesData(Context ctx) {
        this.ctx = ctx;
    }

    public void saveDataOnline(final SalesDataModel salesDataModel) {
        final ProgressDialog progressDialog = new ProgressDialog(ctx);
        progressDialog.setMessage("Saving Online...");
        progressDialog.show();


        StringRequest stringRequest = new StringRequest(Request.Method.POST, URL_SALESDATA_WEBSERVICE,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        progressDialog.dismiss();
                        try {
                            JSONObject obj = new JSONObject(response);
                            if (obj.getBoolean("success")) {
                                Toast.makeText(ctx, "Saved Online.Removed from offline", Toast.LENGTH_SHORT).show();
                                DatabaseHelper dbHelper=new DatabaseHelper(ctx);
                                dbHelper.deleteSalesData(salesDataModel.getId());
                                dbHelper.close();
                            } else {
                                //if there is some error
                                Toast.makeText(ctx, "Online server responded error. Saving Locally...", Toast.LENGTH_SHORT).show();
                                saveDataOffline(salesDataModel);
                            }
                        } catch (JSONException e) {
                            e.printStackTrace();
                            Toast.makeText(ctx, "Exception caught. Saving Locally...", Toast.LENGTH_SHORT).show();
                            saveDataOffline(salesDataModel);
                        }
                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        progressDialog.dismiss();
                        Toast.makeText(ctx, "Volley Error. Saving Locally...", Toast.LENGTH_SHORT).show();
                        saveDataOffline(salesDataModel);                    }
                }) {
            @Override
            protected Map<String, String> getParams() throws AuthFailureError {
                Map<String, String> params = new HashMap<>();
                params.put("datecol",salesDataModel.getDatecol());
                params.put("timecol",salesDataModel.getTimecol());
                params.put("site",salesDataModel.getSite());
                params.put("regular",salesDataModel.getRegular());
                params.put("regular_and_cheese",salesDataModel.getRegular_and_cheese());
                params.put("large",salesDataModel.getLarge());
                params.put("large_and_cheese",salesDataModel.getLarge_and_cheese());
                params.put("footlong",salesDataModel.getFootlong());
                params.put("footlong_and_cheese",salesDataModel.getFootlong_and_cheese());
                params.put("special",salesDataModel.getSpecial());
                params.put("special_and_cheese",salesDataModel.getSpecial_and_cheese());
                params.put("drink",salesDataModel.getDrink());
                params.put("extra_cheese",salesDataModel.getExtra_cheese());
                params.put("no_bun",salesDataModel.getNo_bun());
                params.put("half_regular",salesDataModel.getHalf_regular());
                params.put("half_regular_and_cheese",salesDataModel.getHalf_regular_and_cheese());
                params.put("half_large",salesDataModel.getHalf_large());
                params.put("half_large_and_cheese",salesDataModel.getHalf_large_and_cheese());
                params.put("half_footlong",salesDataModel.getHalf_footlong());
                params.put("half_footlong_and_cheese",salesDataModel.getHalf_footlong_and_cheese());
                params.put("half_special",salesDataModel.getHalf_special());
                params.put("half_special_and_cheese",salesDataModel.getHalf_special_and_cheese());
                params.put("half_drink",salesDataModel.getHalf_drink());
                params.put("full_regular",salesDataModel.getFull_regular());
                params.put("full_regular_and_cheese",salesDataModel.getFull_regular_and_cheese());
                params.put("full_large",salesDataModel.getFull_large());
                params.put("full_large_and_cheese",salesDataModel.getFull_large_and_cheese());
                params.put("full_footlong",salesDataModel.getFull_footlong());
                params.put("full_footlong_and_cheese",salesDataModel.getFull_footlong_and_cheese());
                params.put("full_special",salesDataModel.getFull_special());
                params.put("full_special_and_cheese",salesDataModel.getFull_special_and_cheese());
                params.put("full_drink",salesDataModel.getFull_drink());
                params.put("staff_regular",salesDataModel.getStaff_regular());
                params.put("staff_regular_and_cheese",salesDataModel.getStaff_regular_and_cheese());
                params.put("staff_large",salesDataModel.getStaff_large());
                params.put("staff_large_and_cheese",salesDataModel.getStaff_large_and_cheese());
                params.put("staff_footlong",salesDataModel.getStaff_footlong());
                params.put("staff_footlong_and_cheese",salesDataModel.getStaff_footlong_and_cheese());
                params.put("staff_special",salesDataModel.getStaff_special());
                params.put("staff_special_and_cheese",salesDataModel.getStaff_special_and_cheese());
                params.put("staff_drink",salesDataModel.getStaff_drink());
                params.put("regular_waste",salesDataModel.getRegular_waste());
                params.put("large_waste",salesDataModel.getLarge_waste());
                params.put("footlong_waste",salesDataModel.getFootlong_waste());
                params.put("special_waste",salesDataModel.getSpecial_waste());
                params.put("small_bun_waste",salesDataModel.getSmall_bun_waste());
                params.put("large_bun_waste",salesDataModel.getLarge_bun_waste());
                params.put("total",salesDataModel.getTotal());
                return params;
            }
        };

        VolleySingleton.getInstance(ctx).addToRequestQueue(stringRequest);
    }
    public void saveDataOffline(final SalesDataModel salesDataModel){
        DatabaseHelper db= new DatabaseHelper(ctx);
        db.addSalesData(salesDataModel);
        db.close();
    }
}
