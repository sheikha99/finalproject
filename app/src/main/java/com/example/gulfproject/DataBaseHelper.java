package com.example.gulfproject;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class DataBaseHelper extends SQLiteOpenHelper {
    public static final String DBNAME ="login.DB";

    public DataBaseHelper( Context context) {
        super(context, "login.DB", null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase MyDB) {
        MyDB.execSQL("create table user(username TEXT primary key, password TEXT)");

    }

    @Override
    public void onUpgrade(SQLiteDatabase MyDB, int i, int i1) {
        MyDB.execSQL("drop table if exists user");
    }
    public  Boolean insertData(String username, String password){
        SQLiteDatabase MyDB=this.getWritableDatabase();
        ContentValues contentValues=new ContentValues();
        contentValues.put("username",username);
        contentValues.put("password",password);
        long result=MyDB.insert("user", null, contentValues);
        if (result==-1)return false;
        else
            return true;
    }
    public  Boolean checkusername(String username){
        SQLiteDatabase MyDB=this.getWritableDatabase();
        Cursor cursor=MyDB.rawQuery("select * from user where username= ?",new String[] {username});
        if (cursor.getCount()>0)
            return true;
        else
            return  false;
    }
    public Boolean checkusernamepassword(String username, String password){
        SQLiteDatabase MyDB=this.getWritableDatabase();
        Cursor cursor=MyDB.rawQuery("select * from user where username = ? and password = ?",new String[] {username, password});
        if (cursor.getCount()>0)
            return true;
        else
            return false;

    }

}
