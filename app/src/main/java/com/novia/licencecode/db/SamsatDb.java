package com.novia.licencecode.db;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;
import java.util.List;

public class SamsatDb {
    
    // Labels table name
    public static final String TABLE = "Samsat";

    // Labels Table Columns names
    public static final String KEY_ROWID = "_id";
    public static final String KEY_ID = "id";
    public static final String KEY_name = "name";
    public static final String KEY_address = "address";
    public static final String KEY_lat = "lat";
    public static final String KEY_lon = "lon";

    // property help us to keep data
    public int samsat_ID;
    public String name;
    public String address;
    public String lat;
    public String lon;

    private DbHelper dbHelper;

    public SamsatDb(Context context) {
        dbHelper = new DbHelper(context);
    }

    public int insert(Samsat samsat) {

        //Open connection to write data
        SQLiteDatabase db = dbHelper.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(KEY_lat, samsat.lat);
        values.put(KEY_lon, samsat.lon);
        values.put(KEY_address, samsat.address);
        values.put(KEY_name, samsat.name);

        // Inserting Row
        long samsat_Id = db.insert(TABLE, null, values);
        db.close(); // Closing database connection
        return (int) samsat_Id;
    }

    public List<Samsat> getSamsatList() {
        List<Samsat> list = new ArrayList<>();
        SQLiteDatabase db = dbHelper.getReadableDatabase();
        String selectQuery =  "SELECT rowid as " +
                KEY_ROWID + "," +
                KEY_ID + "," +
                KEY_name + "," +
                KEY_lat + "," +
                KEY_lon + "," +
                KEY_address +
                " FROM " + TABLE;


        Cursor cursor = db.rawQuery(selectQuery, null);
        // looping through all rows and adding to list

        if (cursor == null) {
            return null;
        } else if (!cursor.moveToFirst()) {
            cursor.close();
            return null;
        }
        cursor.moveToFirst();
        while (!cursor.isAfterLast()) {
            String name = cursor.getString(cursor.getColumnIndex(KEY_name));
            String address  = cursor.getString(cursor.getColumnIndex(KEY_address));
            String lat  = cursor.getString(cursor.getColumnIndex(KEY_lat));
            String lon  = cursor.getString(cursor.getColumnIndex(KEY_lon));
            list.add(new Samsat(name, address, Double.parseDouble(lat), Double.parseDouble(lon)));
            cursor.moveToNext();
        }

        cursor.close();
        return list;
    }

    public List<Samsat> getSamsatListByKeyword(String search) {
        List<Samsat> list = new ArrayList<>();
        SQLiteDatabase db = dbHelper.getReadableDatabase();
        String selectQuery =  "SELECT  rowid as " +
                KEY_ROWID + "," +
                KEY_ID + "," +
                KEY_name + "," +
                KEY_lat + "," +
                KEY_lon + "," +
                KEY_address +
                " FROM " + TABLE +
                " WHERE " +  KEY_name + "  LIKE  '%" +search + "%' "
                ;


        Cursor cursor = db.rawQuery(selectQuery, null);
        // looping through all rows and adding to list

        if (cursor == null) {
            return null;
        } else if (!cursor.moveToFirst()) {
            cursor.close();
            return null;
        }
        cursor.moveToFirst();
        while (!cursor.isAfterLast()) {
            String name = cursor.getString(cursor.getColumnIndex(KEY_name));
            String address  = cursor.getString(cursor.getColumnIndex(KEY_address));
            String lat  = cursor.getString(cursor.getColumnIndex(KEY_lat));
            String lon  = cursor.getString(cursor.getColumnIndex(KEY_lon));
            list.add(new Samsat(name, address, Double.parseDouble(lat), Double.parseDouble(lon)));
            cursor.moveToNext();
        }

        cursor.close();
        return list;
    }

    public Samsat getSamsatById(int Id){
        SQLiteDatabase db = dbHelper.getReadableDatabase();
        String selectQuery =  "SELECT " +
                KEY_ID + "," +
                KEY_name + "," +
                KEY_lat + "," +
                KEY_lon + "," +
                KEY_address +
                " FROM " + TABLE
                + " WHERE " +
                KEY_ID + "=?";// It's a good practice to use parameter ?, instead of concatenate string

        int iCount = 0;
        Samsat samsat = new Samsat();

        Cursor cursor = db.rawQuery(selectQuery, new String[] { String.valueOf(Id) } );

        if (cursor.moveToFirst()) {
            do {
                samsat_ID = cursor.getInt(cursor.getColumnIndex(KEY_ID));
                name = cursor.getString(cursor.getColumnIndex(KEY_name));
                address  = cursor.getString(cursor.getColumnIndex(KEY_address));
                lat  = cursor.getString(cursor.getColumnIndex(KEY_lat));
                lon  = cursor.getString(cursor.getColumnIndex(KEY_lon));

            } while (cursor.moveToNext());
        }

        cursor.close();
        db.close();
        return samsat;
    }
}