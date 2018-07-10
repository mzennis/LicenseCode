package com.novia.licencecode.db;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;


public class DbHelper extends SQLiteOpenHelper {
    //version number to upgrade database version
    //each time if you Add, Edit table, you need to change the
    //version number.
    private static final int DATABASE_VERSION = 1;

    // Database Name
    private static final String DATABASE_NAME = "noviadatabase.db";

    public DbHelper(Context context ) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        //All necessary tables you like to create will create here

        String CREATE_TABLE_SAMSAT = "CREATE TABLE " + SamsatDb.TABLE  + "("
                + SamsatDb.KEY_ID  + " INTEGER PRIMARY KEY AUTOINCREMENT ,"
                + SamsatDb.KEY_name + " TEXT, "
                + SamsatDb.KEY_lat + " TEXT, "
                + SamsatDb.KEY_lon + " TEXT, "
                + SamsatDb.KEY_address + " TEXT )";

        String CREATE_TABLE_PLATNOMOR = "CREATE TABLE " + PlatNomorDb.TABLE  + "("
                + PlatNomorDb.KEY_ID  + " INTEGER PRIMARY KEY AUTOINCREMENT ,"
                + PlatNomorDb.KEY_area + " TEXT, "
                + PlatNomorDb.KEY_country + " TEXT, "
                + PlatNomorDb.KEY_code + " TEXT )";

        db.execSQL(CREATE_TABLE_PLATNOMOR);
        db.execSQL(CREATE_TABLE_SAMSAT);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        // Drop older table if existed, all data will be gone!!!
        db.execSQL("DROP TABLE IF EXISTS " + SamsatDb.TABLE);
        db.execSQL("DROP TABLE IF EXISTS " + PlatNomorDb.TABLE);

        // Create tables again
        onCreate(db);

    }

}