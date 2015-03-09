package com.example.payleventest.providers;


import android.content.ContentProvider;
import android.content.ContentValues;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.net.Uri;
import android.support.annotation.NonNull;

import com.example.payleventest.db.DBHelper;


/**
 * Bulk insert implemented here
 */
public abstract class BaseProvider extends ContentProvider {
    protected DBHelper dbHelper;

    @Override
    public boolean onCreate() {
        dbHelper = new DBHelper(getContext());
        return false;
    }

    /**
     * @return table name for current provider. This table name will be used for the bulk insert
     */
    protected abstract String getTableNameForInsert();

    @Override
    public int bulkInsert(Uri uri, @NonNull ContentValues[] values) {
        int numInserted = 0;
        SQLiteDatabase sqlDB = dbHelper.getWritableDatabase();
        sqlDB.beginTransaction();
        try {

            for (ContentValues cv : values) {
                long newID = sqlDB.insertWithOnConflict(getTableNameForInsert(), null, cv, SQLiteDatabase.CONFLICT_REPLACE);
                if (newID <= 0) {
                    throw new SQLException("Failed to insert row into " + uri);
                }
            }
            sqlDB.setTransactionSuccessful();
            getContext().getContentResolver().notifyChange(uri, null);
            numInserted = values.length;
        } finally {
            sqlDB.endTransaction();
        }
        return numInserted;
    }
}
