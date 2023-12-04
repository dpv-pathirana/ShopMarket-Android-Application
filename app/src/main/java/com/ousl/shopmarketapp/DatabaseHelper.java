package com.ousl.shopmarketapp;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class DatabaseHelper extends SQLiteOpenHelper {

    public static final String DATABASE_NAME = "shopMarket.db";
    public static final String TABLE_ALL_USERS = "allUserDetails";
    public static final String COL_1 = "Username";
    public static final String COL_2 = "Name";
    public static final String COL_3 = "Email";
    public static final String COL_4 = "Password";

    // Create Database
    public DatabaseHelper(@Nullable Context context) {
        super(context, DATABASE_NAME, null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase MyDatabase) {
        MyDatabase.execSQL("CREATE TABLE allUserDetails(Username TEXT PRIMARY KEY, Name TEXT, Email TEXT , Password TEXT)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase MyDatabase, int i, int i1) {
        MyDatabase.execSQL("DROP TABLE IF EXISTS " + TABLE_ALL_USERS);
        onCreate(MyDatabase);
    }

    //Insert Data To Database
    public Boolean insertData(String Username, String Name, String Email, String Password){
        SQLiteDatabase MyDatabase = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(COL_1, Username);
        contentValues.put(COL_2, Name);
        contentValues.put(COL_3, Email);
        contentValues.put(COL_4, Password);
        long result = MyDatabase.insert(TABLE_ALL_USERS,null, contentValues);

        if(result == -1){
            return false;
        }
        else {
            return true;
        }
    }

    // Check Username for sign up
    public Boolean checkUsername(String Username){
        SQLiteDatabase MyDatabase = this.getWritableDatabase();
        Cursor cursor = MyDatabase.rawQuery("SELECT * FROM allUserDetails WHERE Username = ?", new String[]{Username});

        if(cursor.getCount() > 0){
            return true;
        }
        else{
            return false;
        }
    }

    // Check Username And Password for Log in
    public Boolean checkUsernamePassword(String Username, String Password){
        SQLiteDatabase MyDatabase = this.getWritableDatabase();
        Cursor cursor = MyDatabase.rawQuery("SELECT * FROM allUserDetails WHERE Username = ? AND Password = ?", new String[]{Username, Password});

        if (cursor.getCount() > 0){
            return true;
        }else{
            return false;
        }
    }

    // Update Profile Details in Profile
    public boolean updateData(String Username, String Name, String Email, String Password){
        SQLiteDatabase MyDatabase = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(COL_1, Username);
        contentValues.put(COL_2, Name);
        contentValues.put(COL_3, Email);
        contentValues.put(COL_4, Password);

        MyDatabase.update(TABLE_ALL_USERS, contentValues, "Username = ?", new String[] {Username});
        return true;
    }

    // Delete User Profile form database
    public Integer deleteData(String Username){
        SQLiteDatabase MyDatabase = this.getWritableDatabase();
        return MyDatabase.delete(TABLE_ALL_USERS,"Username = ?", new String[] {Username});
    }
}
