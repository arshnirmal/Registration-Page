package com.example.registrationpage;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class MyDataBase extends SQLiteOpenHelper {
    public static final String TABLE = "Table";
    public static final String COLUMN_NAME = "Name";
    public static final String COLUMN_DOB = "Date Of Birth";
    public static final String COLUMN_EMAIL = "Email ID";

    public MyDataBase(@Nullable Context context) {
        super(context,"register.db", null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
//        String createTableStatement = " CREATE TABLE "+TABLE+" ("+
//                COLUMN_NAME+" TEXT NOT NULL, "+
//                COLUMN_DOB+" TEXT NOT NULL, "+
//                COLUMN_EMAIL+" TEXT NOT NULL );"
        sqLiteDatabase.execSQL(" CREATE TABLE "+TABLE+" ("+
                COLUMN_NAME+" TEXT NOT NULL, "+
                COLUMN_DOB+" TEXT NOT NULL, "+
                COLUMN_EMAIL+" TEXT NOT NULL );"
        );
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }
    public boolean addOne(RegisterationInput registerationInput){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues cv = new ContentValues();
        cv.put(COLUMN_NAME,registerationInput.getName());
        cv.put(COLUMN_DOB,registerationInput.getDate());
        cv.put(COLUMN_EMAIL,registerationInput.getEmail());

        long ins = db.insert(TABLE,null,cv);
        return ins != -1;
    }
}
