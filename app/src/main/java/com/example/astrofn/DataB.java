package com.example.astrofn;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class DataB extends SQLiteOpenHelper {
 public static final String DNAME="Login.db";

    public DataB( Context context) {
     super(context,"Login.db" , null , 1 );

    }

    @Override
    public void onCreate(SQLiteDatabase DB) {
        DB.execSQL("create Table users(Login TXT primary key , password TEXT)");

    }

    @Override
    public void onUpgrade(SQLiteDatabase DB, int oldVersion, int newVersion) {
        DB.execSQL("drop Table if exists users");

    }
    public boolean insertdata(String username,String password){
        SQLiteDatabase DB=this.getWritableDatabase();
        ContentValues contentValues= new ContentValues();
        contentValues.put("username",username);
        contentValues.put("password",password);
        long result=DB.insert("users", null,contentValues);
        if(result==-1)return false ;
        else
            return true ;


    }

    public boolean checkusername(String username){
      SQLiteDatabase DB=this.getWritableDatabase();
        Cursor cursor =DB.rawQuery("select * from users where username=?", new String[] {username});
        if(cursor.getCount()>0)
            return true ;
        else
            return false ;
    }

    public boolean checkpassword(String username ,String password ){
        SQLiteDatabase DB=this.getWritableDatabase();
        Cursor cursor=DB.rawQuery("select*from users where username=? and password = ?",new String[]{username,password});
        if (cursor.getCount()>0)
            return true ;
        else
            return false ;

    }
}
