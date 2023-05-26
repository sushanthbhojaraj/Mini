package com.example.mini;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

import java.util.ArrayList;

public class DataBase extends SQLiteOpenHelper {
    String tblname="blooddata";
    String colname="Name";
    String colmob="Mobile";
    String colloc="Location";
    String coldob="DOB";
    String colbldgrp="Blodgrp";


    SQLiteDatabase sq;


    String qry= "create table "+tblname+"("+colname+" text, "+colmob+" text, "+colloc+" text,"+coldob+" text, "+colbldgrp+" text)";


    // create table blooddata (Name text,Mobile text,Location text,DoB text,Blodgrp text);


    public DataBase( Context context) {
        super(context, "blooddb.db",null, 1);
        sq=getWritableDatabase();
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {

        sqLiteDatabase.execSQL(qry);


    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }

    public void savdat(String stname, String stmob, String stloc, String sdob, String sblood) {
        ContentValues cv= new ContentValues();
        cv.put(colname,stname);
        cv.put(colmob,stmob);
        cv.put(colloc,stloc);
        cv.put(coldob,sdob);
        cv.put(colbldgrp,sblood);
        sq.insert(tblname,null,cv);




    }

    public String getdata(String bldary) {





        Cursor c;
        c= sq.query(tblname,null,colbldgrp+ "=?",new String[]{bldary},null,null,null);
        c.moveToFirst();
        if(c.getCount()<1){
            return "no data" ;
        }

        String res=c.getString(c.getColumnIndex(colname))+"\n"+
                c.getString(c.getColumnIndex(colmob))+"\n"+
                c.getString(c.getColumnIndex(colloc))+"\n"+
                c.getString(c.getColumnIndex(coldob));
        return  res;




    }
}
