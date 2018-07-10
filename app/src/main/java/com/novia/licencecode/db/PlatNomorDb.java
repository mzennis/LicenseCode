package com.novia.licencecode.db;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

public class PlatNomorDb {
    
    public static final String TABLE = "PlatNomor";

    public static final String KEY_ROWID = "_id";
    public static final String KEY_ID = "id";
    public static final String KEY_area = "area";
    public static final String KEY_code = "code";
    public static final String KEY_country = "country";

    public int platnomor_ID;
    public String area;
    public String code;
    public String country;

    private DbHelper dbHelper;

    public PlatNomorDb(Context context) {
        dbHelper = new DbHelper(context);
    }

    public int insert(Samsat samsat) {

        //Open connection to write data
        SQLiteDatabase db = dbHelper.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(KEY_area, area);
        values.put(KEY_code, code);
        values.put(KEY_country, country);

        // Inserting Row
        long samsat_Id = db.insert(TABLE, null, values);
        db.close(); // Closing database connection
        return (int) samsat_Id;
    }

    public Cursor getSamsatList() {
        //Open connection to read only
        SQLiteDatabase db = dbHelper.getReadableDatabase();
        String selectQuery =  "SELECT rowid as " +
                KEY_ROWID + "," +
                KEY_ID + "," +
                KEY_area + "," +
                KEY_code + "," +
                KEY_country +
                " FROM " + TABLE;


        Cursor cursor = db.rawQuery(selectQuery, null);
        // looping through all rows and adding to list

        if (cursor == null) {
            return null;
        } else if (!cursor.moveToFirst()) {
            cursor.close();
            return null;
        }
        return cursor;
    }


    public Cursor getSamsatListByKeyword(String search) {
        //Open connection to read only
        SQLiteDatabase db = dbHelper.getReadableDatabase();
        String selectQuery =  "SELECT  rowid as " +
                KEY_ROWID + "," +
                KEY_ID + "," +
                KEY_area + "," +
                KEY_code + "," +
                KEY_country +
                " FROM " + TABLE +
                " WHERE " +  KEY_area + "  LIKE  '%" +search + "%' "
                ;


        Cursor cursor = db.rawQuery(selectQuery, null);
        // looping through all rows and adding to list

        if (cursor == null) {
            return null;
        } else if (!cursor.moveToFirst()) {
            cursor.close();
            return null;
        }
        return cursor;


    }

    public Samsat getSamsatById(int Id){
        SQLiteDatabase db = dbHelper.getReadableDatabase();
        String selectQuery =  "SELECT " +
                KEY_ID + "," +
                KEY_area + "," +
                KEY_code + "," +
                KEY_country +
                " FROM " + TABLE
                + " WHERE " +
                KEY_ID + "=?";// It's a good practice to use parameter ?, instead of concatenate string

        int iCount = 0;
        Samsat samsat = new Samsat();

        Cursor cursor = db.rawQuery(selectQuery, new String[] { String.valueOf(Id) } );

        if (cursor.moveToFirst()) {
            do {
                platnomor_ID = cursor.getInt(cursor.getColumnIndex(KEY_ID));
                area = cursor.getString(cursor.getColumnIndex(KEY_area));
                code  = cursor.getString(cursor.getColumnIndex(KEY_code));
                country  = cursor.getString(cursor.getColumnIndex(KEY_country));

            } while (cursor.moveToNext());
        }

        cursor.close();
        db.close();
        return samsat;
    }




}