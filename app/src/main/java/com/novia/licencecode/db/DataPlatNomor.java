package com.novia.licencecode.db;

import android.content.Context;

/**
 * Created by meta on 10/07/18.
 */
public class DataPlatNomor {

    public static void save(Context context) {
        PlatNomorDb db = new PlatNomorDb(context);

        PlatNomor item = new PlatNomor();
        item.code = "A";
        item.area = "Sample";
        item.country = "Indonesia";
        db.insert(item);

        item.code = "A";
        item.area = "Sample";
        item.country = "Indonesia";
        db.insert(item);

        item.code = "A";
        item.area = "Sample";
        item.country = "Indonesia";
        db.insert(item);

        item.code = "A";
        item.area = "Sample";
        item.country = "Indonesia";
        db.insert(item);

        item.code = "A";
        item.area = "Sample";
        item.country = "Indonesia";
        db.insert(item);

        item.code = "A";
        item.area = "Sample";
        item.country = "Indonesia";
        db.insert(item);

        item.code = "A";
        item.area = "Sample";
        item.country = "Indonesia";
        db.insert(item);

        item.code = "B";
        item.area = "Sample B";
        item.country = "Singapore";
        db.insert(item);

        item.code = "B";
        item.area = "Sample B";
        item.country = "Singapore";
        db.insert(item);

        item.code = "B";
        item.area = "Sample B";
        item.country = "Singapore";
        db.insert(item);

        item.code = "B";
        item.area = "Sample B";
        item.country = "Singapore";
        db.insert(item);

        item.code = "B";
        item.area = "Sample B";
        item.country = "Singapore";
        db.insert(item);
    }
}
