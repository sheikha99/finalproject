package com.example.gulfproject;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;



public class DBHelper extends SQLiteOpenHelper {
    public DBHelper(Context context) { super(context, "Gulf.db", null, 1);

    }


    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("create table ItemsDetails(name TEXT primary key, amount TEXT)");

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1) {
        db.execSQL("drop table if exists ItemsDtails");

    }
    public Boolean insertItemsData(String amount,String name)
    {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues =new ContentValues();
        contentValues.put("amount",amount);
        contentValues.put("name",name);
        long result=db.insert("ItemsDetails",null, contentValues);
        if (result==-1){
            return  false;
        }else{
            return true;
        }
    }

    public Boolean updateItemsData(String amount, String name)
    {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues =new ContentValues();
        contentValues.put("amount",amount);
        contentValues.put("name",name);
        Cursor cursor=db.rawQuery("select * from ItemsDetails where name = ?",new String[] {name});
        if (cursor.getCount()>0) {
        long result=db.update("ItemsDetails", contentValues,"name=?",  new String[]{name});

            if (result == -1) {
                return false;
            } else {
                return true;
            }
        }else {
            return  false;
        }

    }

    public Boolean deleteItemsData(String name)
    {
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor=db.rawQuery("select * from ItemsDetails where amount = ?",new String[] {name});
        if (cursor.getCount()>0) {
        long result=db.delete("ItemsDetails", "name = ?",new String[] {name});


            if (result == -1) {
                return false;
            } else {
                return true;
            }
        }else {
            return  false;
        }

    }

    public Cursor getData ()
    {
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor=db.rawQuery("select * from ItemsDetails", null);
      return cursor;

    }


}
