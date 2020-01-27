package com.example.basketmall;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DatabaseHelper extends SQLiteOpenHelper {

    private static final String TABLE_NAME = "item_table";
    private static final String Col0 = "ID";
    private static final String Col1 = "name";

    public DatabaseHelper(Context context){
        super(context, TABLE_NAME, null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String createTable = "CREATE TABLE " + TABLE_NAME + " (ID INTEGER PRIMARY KEY AUTOINCREMENT, " +
                Col1 + " TEXT)";
        db.execSQL( createTable );
    }

    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL( "DROP TABLE IF EXISTS " + TABLE_NAME );
        onCreate( db );
    }

    public boolean addProduct(String item){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put( Col1, item );

        long result = db.insert( TABLE_NAME, null, contentValues );

        //if incorrectly added data then -1
        if(result == -1) {
            return false;
        }
        else{
            return true;
        }
    }

    public Cursor getData(){
        SQLiteDatabase db = this.getWritableDatabase();
        String query = "SELECT * FROM " + TABLE_NAME;
        Cursor data = db.rawQuery( query, null );
        return data;
    }

    public Cursor getItemID(String item){
        SQLiteDatabase db = this.getWritableDatabase();
        String query = "SELECT " + Col0 + " FROM " + TABLE_NAME + " WHERE " + Col1 + " = '" + item + "'";
        Cursor data = db.rawQuery( query, null );
        return data;
    }

    public void deleteItem(int id, String name){
        SQLiteDatabase db = this.getWritableDatabase();
        String query = "DELETE FROM " + TABLE_NAME + " WHERE " + Col0 + " = '" + id + "'" +
        " AND " + Col1 + " = '" + name + "'";
        db.execSQL( query );
    }


    public void deleteAll(){
        SQLiteDatabase db = this.getWritableDatabase();
        db.execSQL( "DELETE FROM " + TABLE_NAME + " WHERE 1" );
    }
}

