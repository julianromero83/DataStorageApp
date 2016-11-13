package edu.byui.www.datastorageapp;

/**
 * Created by Julian on 11/12/2016.
 */

import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.database.sqlite.SQLiteOpenHelper;
import android.database.Cursor;
import android.content.Context;
import android.content.ContentValues;

import java.io.File;

public class MyDBHandler extends SQLiteOpenHelper{

    private static final int DATABASE_VERSION = 1;
    private static final String DATABASE_NAME = "value.db";
    public static final String TABLE_VALUES = "valuestb";
    private static final String COLUMN_ID = "_id";
    private static final String COLUMN_VALUE = "valuenumber";

    public MyDBHandler(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, DATABASE_NAME, factory, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String query = "CREATE TABLE " + TABLE_VALUES + " (" +
                COLUMN_ID + " INTEGER PRIMARY KEY, " +
                COLUMN_VALUE + " TEXT " +
                ");";
        db.execSQL(query);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_VALUES);
        onCreate(db);
    }

    //Add a new row to the database
    public void addValue(Values values){
        ContentValues dbValues = new ContentValues();
        dbValues.put(COLUMN_VALUE, values.get_value());
        SQLiteDatabase db = getWritableDatabase();
        db.insert(TABLE_VALUES, null, dbValues);
        db.close();
    }

    //Get last value
    public String getValue() throws Exception {
            String dbString = "0";
            SQLiteDatabase db = getWritableDatabase();
            String query = "SELECT * FROM " + TABLE_VALUES + " WHERE 1";
        try {
            //Cursor point to a location in your results
            Cursor c = db.rawQuery(query, null);
            //Move to the last row in your results
            c.moveToLast();

            if (c.getString(c.getColumnIndex("valuenumber")) != null) {
                dbString = c.getString(c.getColumnIndex("valuenumber"));
            }
        } catch (Exception e) { return dbString;}

            db.close();
            return dbString;
    }


}
