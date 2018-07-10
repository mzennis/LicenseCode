package com.novia.licencecode.db;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;
import java.util.List;

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

    public int insert(PlatNomor item) {

        //Open connection to write data
        SQLiteDatabase db = dbHelper.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(KEY_area, item.area);
        values.put(KEY_code, item.code);
        values.put(KEY_country, item.country);

        // Inserting Row
        long samsat_Id = db.insert(TABLE, null, values);
        db.close(); // Closing database connection
        return (int) samsat_Id;
    }

    public List<PlatNomor> getPlatNomorList() {
        List<PlatNomor> list = new ArrayList<>();
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

        cursor.moveToFirst();
        while (!cursor.isAfterLast()) {
            String area = cursor.getString(cursor.getColumnIndex(KEY_area));
            String code  = cursor.getString(cursor.getColumnIndex(KEY_code));
            String country  = cursor.getString(cursor.getColumnIndex(KEY_country));
            list.add(new PlatNomor(code, area, country));
            cursor.moveToNext();
        }

        cursor.close();
        return list;
    }

    public List<PlatNomor> getPlatNomorListByKeyword(String search) {
        List<PlatNomor> list = new ArrayList<>();
        SQLiteDatabase db = dbHelper.getReadableDatabase();
        String selectQuery =  "SELECT  rowid as " +
                KEY_ROWID + "," +
                KEY_ID + "," +
                KEY_area + "," +
                KEY_code + "," +
                KEY_country +
                " FROM " + TABLE +
                " WHERE " +  KEY_country + "  LIKE  '%" +search + "%' "
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
            String area = cursor.getString(cursor.getColumnIndex(KEY_area));
            String code  = cursor.getString(cursor.getColumnIndex(KEY_code));
            String country  = cursor.getString(cursor.getColumnIndex(KEY_country));
            list.add(new PlatNomor(code, area, country));
            cursor.moveToNext();
        }

        cursor.close();
        return list;
    }
}