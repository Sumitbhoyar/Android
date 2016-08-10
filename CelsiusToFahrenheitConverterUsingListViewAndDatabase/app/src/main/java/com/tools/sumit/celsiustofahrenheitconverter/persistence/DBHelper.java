package com.tools.sumit.celsiustofahrenheitconverter.persistence;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DBHelper extends SQLiteOpenHelper {
    public static final String TABLE_CONVERSIONS = "coversions";
    public static final String COLUMN_ID = "_id";
    public static final String COLUMN_CONVERSION = "conversion";

    private static final String DATABASE_NAME = "coversions.db";
    private static final int DATABASE_VERSION = 1;
    private static final String DATABASE_CREATE = "create table "
            + TABLE_CONVERSIONS + "( " + COLUMN_ID
            + " integer primary key autoincrement, " + COLUMN_CONVERSION
            + " text not null);";


    public DBHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL(DATABASE_CREATE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS " + TABLE_CONVERSIONS);
        onCreate(sqLiteDatabase );
    }
}
