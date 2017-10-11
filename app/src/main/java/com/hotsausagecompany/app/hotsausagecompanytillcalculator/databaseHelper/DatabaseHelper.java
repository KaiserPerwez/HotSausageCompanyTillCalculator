package com.hotsausagecompany.app.hotsausagecompanytillcalculator.databaseHelper;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.widget.Toast;

import com.hotsausagecompany.app.hotsausagecompanytillcalculator.model.SalesDataModel;

/**
 * Created by Admin on 09-10-2017.
 */

public class DatabaseHelper extends SQLiteOpenHelper {

    //database version
    private static final int DB_VERSION = 1;

    //Constants for Database name, table name, and column names
    public static final String DB_NAME = "SalesDataSqliteDB";
    public static final String TABLE_NAME = "SalesDataTable";

    public static final String COLUMN_ID = "id";
    public static final String COLUMN_STATUS = "status";
    public static final String COLUMN_DATECOL = "datecol";
    public static final String COLUMN_TIMECOL = "timecol";
    public static final String COLUMN_SITE = "site";
    public static final String COLUMN_REGULAR = "regular";
    public static final String COLUMN_REGULAR_AND_CHEESE = "regular_and_cheese";
    public static final String COLUMN_LARGE = "large";
    public static final String COLUMN_LARGE_AND_CHEESE = "large_and_cheese";
    public static final String COLUMN_FOOTLONG = "footlong";
    public static final String COLUMN_FOOTLONG_AND_CHEESE = "footlong_and_cheese";
    public static final String COLUMN_SPECIAL = "special";
    public static final String COLUMN_SPECIAL_AND_CHEESE = "special_and_cheese";
    public static final String COLUMN_DRINK = "drink";
    public static final String COLUMN_EXTRA_CHEESE = "extra_cheese";
    public static final String COLUMN_NO_BUN = "no_bun";
    public static final String COLUMN_HALF_REGULAR = "half_regular";
    public static final String COLUMN_HALF_REGULAR_AND_CHEESE = "half_regular_and_cheese";
    public static final String COLUMN_HALF_LARGE = "half_large";
    public static final String COLUMN_HALF_LARGE_AND_CHEESE = "half_large_and_cheese";
    public static final String COLUMN_HALF_FOOTLONG = "half_footlong";
    public static final String COLUMN_HALF_FOOTLONG_AND_CHEESE = "half_footlong_and_cheese";
    public static final String COLUMN_HALF_SPECIAL = "half_special";
    public static final String COLUMN_HALF_SPECIAL_AND_CHEESE = "half_special_and_cheese";
    public static final String COLUMN_HALF_DRINK = "half_drink";
    public static final String COLUMN_FULL_REGULAR = "full_regular";
    public static final String COLUMN_FULL_REGULAR_AND_CHEESE = "full_regular_and_cheese";
    public static final String COLUMN_FULL_LARGE = "full_large";
    public static final String COLUMN_FULL_LARGE_AND_CHEESE = "full_large_and_cheese";
    public static final String COLUMN_FULL_FOOTLONG = "full_footlong";
    public static final String COLUMN_FULL_FOOTLONG_AND_CHEESE = "full_footlong_and_cheese";
    public static final String COLUMN_FULL_SPECIAL = "full_special";
    public static final String COLUMN_FULL_SPECIAL_AND_CHEESE = "full_special_and_cheese";
    public static final String COLUMN_FULL_DRINK = "full_drink";
    public static final String COLUMN_STAFF_REGULAR = "staff_regular";
    public static final String COLUMN_STAFF_REGULAR_AND_CHEESE = "staff_regular_and_cheese";
    public static final String COLUMN_STAFF_LARGE = "staff_large";
    public static final String COLUMN_STAFF_LARGE_AND_CHEESE = "staff_large_and_cheese";
    public static final String COLUMN_STAFF_FOOTLONG = "staff_footlong";
    public static final String COLUMN_STAFF_FOOTLONG_AND_CHEESE = "staff_footlong_and_cheese";
    public static final String COLUMN_STAFF_SPECIAL = "staff_special";
    public static final String COLUMN_STAFF_SPECIAL_AND_CHEESE = "staff_special_and_cheese";
    public static final String COLUMN_STAFF_DRINK = "staff_drink";
    public static final String COLUMN_REGULAR_WASTE = "regular_waste";
    public static final String COLUMN_LARGE_WASTE = "large_waste";
    public static final String COLUMN_FOOTLONG_WASTE = "footlong_waste";
    public static final String COLUMN_SPECIAL_WASTE = "special_waste";
    public static final String COLUMN_SMALL_BUN_WASTE = "small_bun_waste";
    public static final String COLUMN_LARGE_BUN_WASTE = "large_bun_waste";
    public static final String COLUMN_TOTAL = "total";

    //Constructor
    public DatabaseHelper(Context context) {
        super(context, DB_NAME, null, DB_VERSION);
    }

    //creating the database
    @Override
    public void onCreate(SQLiteDatabase db) {
        String sql = "CREATE TABLE " + TABLE_NAME
                + "(" + COLUMN_STATUS + " TINYINT, " +
                COLUMN_DATECOL + " VARCHAR, " +
                COLUMN_TIMECOL + " VARCHAR, " +
                COLUMN_SITE + " VARCHAR, " +
                COLUMN_REGULAR + " VARCHAR, " +
                COLUMN_REGULAR_AND_CHEESE + " VARCHAR, " +
                COLUMN_LARGE + " VARCHAR, " +
                COLUMN_LARGE_AND_CHEESE + " VARCHAR, " +
                COLUMN_FOOTLONG + " VARCHAR, " +
                COLUMN_FOOTLONG_AND_CHEESE + " VARCHAR, " +
                COLUMN_SPECIAL + " VARCHAR, " +
                COLUMN_SPECIAL_AND_CHEESE + " VARCHAR, " +
                COLUMN_DRINK + " VARCHAR, " +
                COLUMN_EXTRA_CHEESE + " VARCHAR, " +
                COLUMN_NO_BUN + " VARCHAR, " +
                COLUMN_HALF_REGULAR + " VARCHAR, " +
                COLUMN_HALF_REGULAR_AND_CHEESE + " VARCHAR, " +
                COLUMN_HALF_LARGE + " VARCHAR, " +
                COLUMN_HALF_LARGE_AND_CHEESE + " VARCHAR, " +
                COLUMN_HALF_FOOTLONG + " VARCHAR, " +
                COLUMN_HALF_FOOTLONG_AND_CHEESE + " VARCHAR, " +
                COLUMN_HALF_SPECIAL + " VARCHAR, " +
                COLUMN_HALF_SPECIAL_AND_CHEESE + " VARCHAR, " +
                COLUMN_HALF_DRINK + " VARCHAR, " +
                COLUMN_FULL_REGULAR + " VARCHAR, " +
                COLUMN_FULL_REGULAR_AND_CHEESE + " VARCHAR, " +
                COLUMN_FULL_LARGE + " VARCHAR, " +
                COLUMN_FULL_LARGE_AND_CHEESE + " VARCHAR, " +
                COLUMN_FULL_FOOTLONG + " VARCHAR, " +
                COLUMN_FULL_FOOTLONG_AND_CHEESE + " VARCHAR, " +
                COLUMN_FULL_SPECIAL + " VARCHAR, " +
                COLUMN_FULL_SPECIAL_AND_CHEESE + " VARCHAR, " +
                COLUMN_FULL_DRINK + " VARCHAR, " +
                COLUMN_STAFF_REGULAR + " VARCHAR, " +
                COLUMN_STAFF_REGULAR_AND_CHEESE + " VARCHAR, " +
                COLUMN_STAFF_LARGE + " VARCHAR, " +
                COLUMN_STAFF_LARGE_AND_CHEESE + " VARCHAR, " +
                COLUMN_STAFF_FOOTLONG + " VARCHAR, " +
                COLUMN_STAFF_FOOTLONG_AND_CHEESE + " VARCHAR, " +
                COLUMN_STAFF_SPECIAL + " VARCHAR, " +
                COLUMN_STAFF_SPECIAL_AND_CHEESE + " VARCHAR, " +
                COLUMN_STAFF_DRINK + " VARCHAR, " +
                COLUMN_REGULAR_WASTE + " VARCHAR, " +
                COLUMN_LARGE_WASTE + " VARCHAR, " +
                COLUMN_FOOTLONG_WASTE + " VARCHAR, " +
                COLUMN_SPECIAL_WASTE + " VARCHAR, " +
                COLUMN_SMALL_BUN_WASTE + " VARCHAR, " +
                COLUMN_LARGE_BUN_WASTE + " VARCHAR, " +
                COLUMN_TOTAL + " VARCHAR ," +
                " PRIMARY KEY ( "+COLUMN_DATECOL+" , "+COLUMN_TIMECOL+" , "+COLUMN_SITE+" )"+
                ");";
        db.execSQL(sql);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        String sql = "DROP TABLE IF EXISTS " + TABLE_NAME;
        db.execSQL(sql);
        onCreate(db);
    }


    public long addSalesData(SalesDataModel salesDataModel) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();

        contentValues.put(COLUMN_STATUS, salesDataModel.getStatus());
        contentValues.put(COLUMN_DATECOL, salesDataModel.getDatecol());
        contentValues.put(COLUMN_TIMECOL, salesDataModel.getTimecol());
        contentValues.put(COLUMN_SITE, salesDataModel.getSite());
        contentValues.put(COLUMN_REGULAR, salesDataModel.getRegular());
        contentValues.put(COLUMN_REGULAR_AND_CHEESE, salesDataModel.getRegular_and_cheese());
        contentValues.put(COLUMN_LARGE, salesDataModel.getLarge());
        contentValues.put(COLUMN_LARGE_AND_CHEESE, salesDataModel.getLarge_and_cheese());
        contentValues.put(COLUMN_FOOTLONG, salesDataModel.getFootlong());
        contentValues.put(COLUMN_FOOTLONG_AND_CHEESE, salesDataModel.getFootlong_and_cheese());
        contentValues.put(COLUMN_SPECIAL, salesDataModel.getSpecial());
        contentValues.put(COLUMN_SPECIAL_AND_CHEESE, salesDataModel.getSpecial_and_cheese());
        contentValues.put(COLUMN_DRINK, salesDataModel.getDrink());
        contentValues.put(COLUMN_EXTRA_CHEESE, salesDataModel.getExtra_cheese());
        contentValues.put(COLUMN_NO_BUN, salesDataModel.getNo_bun());
        contentValues.put(COLUMN_HALF_REGULAR, salesDataModel.getHalf_regular());
        contentValues.put(COLUMN_HALF_REGULAR_AND_CHEESE, salesDataModel.getHalf_regular_and_cheese());
        contentValues.put(COLUMN_HALF_LARGE, salesDataModel.getHalf_large());
        contentValues.put(COLUMN_HALF_LARGE_AND_CHEESE, salesDataModel.getHalf_large_and_cheese());
        contentValues.put(COLUMN_HALF_FOOTLONG, salesDataModel.getHalf_footlong());
        contentValues.put(COLUMN_HALF_FOOTLONG_AND_CHEESE, salesDataModel.getHalf_footlong_and_cheese());
        contentValues.put(COLUMN_HALF_SPECIAL, salesDataModel.getHalf_special());
        contentValues.put(COLUMN_HALF_SPECIAL_AND_CHEESE, salesDataModel.getHalf_special_and_cheese());
        contentValues.put(COLUMN_HALF_DRINK, salesDataModel.getHalf_drink());
        contentValues.put(COLUMN_FULL_REGULAR, salesDataModel.getFull_regular());
        contentValues.put(COLUMN_FULL_REGULAR_AND_CHEESE, salesDataModel.getFull_regular_and_cheese());
        contentValues.put(COLUMN_FULL_LARGE, salesDataModel.getFull_large());
        contentValues.put(COLUMN_FULL_LARGE_AND_CHEESE, salesDataModel.getFull_large_and_cheese());
        contentValues.put(COLUMN_FULL_FOOTLONG, salesDataModel.getFull_footlong());
        contentValues.put(COLUMN_FULL_FOOTLONG_AND_CHEESE, salesDataModel.getFull_footlong_and_cheese());
        contentValues.put(COLUMN_FULL_SPECIAL, salesDataModel.getFull_special());
        contentValues.put(COLUMN_FULL_SPECIAL_AND_CHEESE, salesDataModel.getFull_special_and_cheese());
        contentValues.put(COLUMN_FULL_DRINK, salesDataModel.getFull_drink());
        contentValues.put(COLUMN_STAFF_REGULAR, salesDataModel.getStaff_regular());
        contentValues.put(COLUMN_STAFF_REGULAR_AND_CHEESE, salesDataModel.getStaff_regular_and_cheese());
        contentValues.put(COLUMN_STAFF_LARGE, salesDataModel.getStaff_large());
        contentValues.put(COLUMN_STAFF_LARGE_AND_CHEESE, salesDataModel.getStaff_large_and_cheese());
        contentValues.put(COLUMN_STAFF_FOOTLONG, salesDataModel.getStaff_footlong());
        contentValues.put(COLUMN_STAFF_FOOTLONG_AND_CHEESE, salesDataModel.getStaff_footlong_and_cheese());
        contentValues.put(COLUMN_STAFF_SPECIAL, salesDataModel.getStaff_special());
        contentValues.put(COLUMN_STAFF_SPECIAL_AND_CHEESE, salesDataModel.getStaff_special_and_cheese());
        contentValues.put(COLUMN_STAFF_DRINK, salesDataModel.getStaff_drink());
        contentValues.put(COLUMN_REGULAR_WASTE, salesDataModel.getRegular_waste());
        contentValues.put(COLUMN_LARGE_WASTE, salesDataModel.getLarge_waste());
        contentValues.put(COLUMN_FOOTLONG_WASTE, salesDataModel.getFootlong_waste());
        contentValues.put(COLUMN_SPECIAL_WASTE, salesDataModel.getSpecial_waste());
        contentValues.put(COLUMN_SMALL_BUN_WASTE, salesDataModel.getSmall_bun_waste());
        contentValues.put(COLUMN_LARGE_BUN_WASTE, salesDataModel.getLarge_bun_waste());
        contentValues.put(COLUMN_TOTAL, salesDataModel.getTotal());

        long result=db.insert(TABLE_NAME, null, contentValues);
        db.close();
        return result;
    }

    public boolean updateSalesDataStatus(int id) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(COLUMN_STATUS, 1);
        db.update(TABLE_NAME, contentValues, COLUMN_ID + "=" + id, null);
        //db.delete(TABLE_NAME, COLUMN_ID + "=" + id, null);
        db.close();
        return true;
    }

    public Cursor getUnsyncedSalesData() {
        SQLiteDatabase db = this.getReadableDatabase();
        String sql = "SELECT * FROM " + TABLE_NAME + " WHERE " + COLUMN_STATUS + " = 0;";
        Cursor c =null;
        try {
            c = db.rawQuery(sql, null);
        }
        catch (Exception e){
        }
        return c;
    }
    public int deleteSalesData(SalesDataModel salesDataModel){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(COLUMN_STATUS, 1);
        int result=0;
        try{
            result=db.delete(TABLE_NAME,COLUMN_DATECOL + "=? AND "+COLUMN_TIMECOL + "=? AND "+COLUMN_SITE + "=?",new String[]{salesDataModel.getDatecol(),salesDataModel.getTimecol(),salesDataModel.getSite()});}
        catch (Exception e){}

        db.close();

       return result;
    }
}