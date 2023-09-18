package com.thoriq.assesmengenap;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class DBManager extends SQLiteOpenHelper{

    public DBManager(@Nullable Context context){
        super(context, "crud.db", null,1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String table = "Create Table Pendaftaran (" +
                "id_pendaftaran integer primary key autoincrement, "+
                "nama text, " +
                "email text, " +
                "notelp text, " +
                "gender integer ," +
                "alamat text)";
        db.execSQL(table);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}

