package com.tools.sumit.celsiustofahrenheitconverter.persistence;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;

import com.tools.sumit.celsiustofahrenheitconverter.domain.Conversion;

import java.util.ArrayList;
import java.util.List;

public class ConversionDataSource {
    private SQLiteDatabase database;
    private DBHelper dbHelper;
    private String[] allColumns = { DBHelper.COLUMN_ID,
            DBHelper.COLUMN_CONVERSION };

    public ConversionDataSource(Context context) {
        dbHelper = new DBHelper(context);
        open();
    }

    public void open() throws SQLException {
        database = dbHelper.getWritableDatabase();
    }

    public void close() {
        dbHelper.close();
    }

    public Conversion createConversion(String conversion) {
        ContentValues values = new ContentValues();
        values.put(DBHelper.COLUMN_CONVERSION, conversion);
        long insertId = database.insert(DBHelper.TABLE_CONVERSIONS, null,
                values);
        Cursor cursor = database.query(DBHelper.TABLE_CONVERSIONS,
                allColumns, DBHelper.COLUMN_ID + " = " + insertId, null,
                null, null, null);
        cursor.moveToFirst();
        Conversion newConversion = cursorToConversion(cursor);
        cursor.close();
        return newConversion;
    }

    public void deleteConversion(Conversion onversion) {
        long id = onversion.getId();
        System.out.println("onversion deleted with id: " + id);
        database.delete(DBHelper.TABLE_CONVERSIONS, DBHelper.COLUMN_ID
                + " = " + id, null);
    }

    public List<String> getAllConversions() {
        List<String> onversions = new ArrayList<String>();

        Cursor cursor = database.query(DBHelper.TABLE_CONVERSIONS,
                allColumns, null, null, null, null, null);
        int count = 0;
        cursor.moveToLast();
        while (!cursor.isBeforeFirst() && count < 10) {
            Conversion conversion = cursorToConversion(cursor);
            onversions.add(conversion.getConversion());
            cursor.moveToPrevious();
            count++;
        }
        // make sure to close the cursor
        cursor.close();
        return onversions;
    }

    private Conversion cursorToConversion(Cursor cursor) {
        Conversion conversion = new Conversion();
        conversion.setId(cursor.getLong(0));
        conversion.setConversion(cursor.getString(1));
        return conversion;
    }
}
