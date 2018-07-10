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

        String CREATE_TABLE_SAMSAT = "CREATE TABLE " + SamsatRepo.TABLE  + "("
                + SamsatRepo.KEY_ID  + " INTEGER PRIMARY KEY AUTOINCREMENT ,"
                + SamsatRepo.KEY_name + " TEXT, "
                + SamsatRepo.KEY_lat + " TEXT, "
                + SamsatRepo.KEY_lon + " TEXT, "
                + SamsatRepo.KEY_address + " TEXT )";

        String CREATE_TABLE_PLATNOMOR = "CREATE TABLE " + PlatNomorRepo.TABLE  + "("
                + PlatNomorRepo.KEY_ID  + " INTEGER PRIMARY KEY AUTOINCREMENT ,"
                + PlatNomorRepo.KEY_area + " TEXT, "
                + PlatNomorRepo.KEY_country + " TEXT, "
                + PlatNomorRepo.KEY_code + " TEXT )";

        db.execSQL(CREATE_TABLE_PLATNOMOR);
        db.execSQL(CREATE_TABLE_SAMSAT);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        // Drop older table if existed, all data will be gone!!!
        db.execSQL("DROP TABLE IF EXISTS " + SamsatRepo.TABLE);
        db.execSQL("DROP TABLE IF EXISTS " + PlatNomorRepo.TABLE);

        // Create tables again
        onCreate(db);

    }

}