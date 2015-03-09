package com.example.payleventest.model;

import android.database.sqlite.SQLiteDatabase;

/**
 * @author <a href="mailto:iBersh20@gmail.com">Iliya Bershadskiy</a>
 * @since 09.03.2015
 */
public class CategoryTable extends BaseTable {
    public static final String TABLE_NAME = "categories";

    public static final String PRODUCTS = "products";
    // Database creation SQL statement
    private static final String DATABASE_CREATE = "create table "
            + TABLE_NAME
            + "("
            + ID + " text primary key, "
            + NAME + " text not null, "
            + PRODUCTS + " text not null"
            + ");";

    public static void onCreate(SQLiteDatabase database) {
        database.execSQL(DATABASE_CREATE);
    }

    public static void onUpgrade(SQLiteDatabase database, int oldVersion,
                                 int newVersion) {
        database.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
        onCreate(database);
    }
}
