package com.hotsausagecompany.app.hotsausagecompanytillcalculator;

import android.os.AsyncTask;
import android.util.Log;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;

public class MySqlHandler extends AsyncTask<Void, Void, Void> {

    String myDataString;

    public MySqlHandler(String myDataString){
        this.myDataString=myDataString;
    }

    @Override
    protected Void doInBackground(Void... params) {

        Connection connection = null;
        Statement statement = null;
        SimpleDateFormat sdf = new SimpleDateFormat("ddMMyyyy");


        try {
            Class.forName("com.mysql.jdbc.Driver").newInstance();
        } catch (Exception ex) {
            System.out.println("SQLException: " + ex.getMessage());
        }
        try{
            connection = DriverManager.getConnection("jdbc:mysql://107.180.26.70:3306/HotSausage", "HotSausage", "Password1!");
            statement = connection.createStatement();
            //myDataString="INSERT INTO SalesData(time) VALUES('123')";
            Log.d("String In SQLHandler","#"+myDataString+"#");
            statement.execute(myDataString);
            System.out.println("data inserted");
            statement.close();
            connection.close();
        }
        catch (SQLException ex) {
            System.out.println("SQLState: " + ex.getSQLState());
            System.out.println("VendorError: " + ex.getErrorCode());
        }




        return null;


    }


}
