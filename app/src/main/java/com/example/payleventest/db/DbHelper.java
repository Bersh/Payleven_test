package com.example.payleventest.db;

import android.content.Context;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import com.example.payleventest.Constants;
import com.example.payleventest.model.Category;
import com.example.payleventest.model.Product;

/**
 * @author <a href="mailto:iBersh20@gmail.com">Iliya Bershadskiy</a>
 * @since 09.03.2015
 */
public class DBHelper extends SQLiteOpenHelper {
    private static final int DATABASE_VERSION = 1;

    public DBHelper(Context context) {
        super(context, Constants.DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase database) {
        try {
            Category.onCreate(database);
            Product.onCreate(database);
        } catch (SQLException e) {
            Log.e(Constants.LOG_TAG, "Can't create database", e);
            throw new RuntimeException(e);
        }
    }

    @Override
    public void onUpgrade(SQLiteDatabase database, int oldVersion, int newVersion) {
        try {
            Category.onUpgrade(database, oldVersion, newVersion);
            Product.onUpgrade(database, oldVersion, newVersion);
        } catch (SQLException e) {
            Log.e(Constants.LOG_TAG, "Error deleting database", e);
        }
    }
}
