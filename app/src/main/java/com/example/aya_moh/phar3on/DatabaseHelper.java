package com.example.aya_moh.phar3on;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by Aya_Moh on 7/2/2017.
 */

public class DatabaseHelper extends SQLiteOpenHelper {

    public static final String DATABASE_NAME = "museum";
    public static final int DATABASE_VERSION =5;

    public static final String TABLE_NAME = "statue";
    public static final String TABLE_NAME2 = "statue_photo";
    public static final String ID = "_ID";
    public static final String NAME = "name";
    public static final String ADESCRIPTION = "Adescription";
    public static final String EDESCRIPTION = "Edescription";
    public static final String FDESCRIPTION = "Fdescription";


    public static final String NAME_image = "name";
    public static final String IMAGE1= "image1";
    public static final String IMAGE2= "image2";
    public static final String IMAGE3= "image3";


    /*private String query = "create table " + TABLE_NAME + " ( " +
            ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
            NAME + " text not null , " +
            ADESCRIPTION + "  text not null ," +
            EDESCRIPTION + " text not null ," +
            FDESCRIPTION + " text not null );" ;*/

    private String query1 = "create table "+TABLE_NAME+" (_ID INTEGER PRIMARY KEY AUTOINCREMENT,name TEXT NOT NULL,Adescription BLOB NOT NULL,Edescription BLOB NOT NULL,Fdescription BLOB NOT NULL);";

    private String query2 = "create table " +TABLE_NAME2 +" (_ID INTEGER PRIMARY KEY AUTOINCREMENT,name TEXT NOT NULL,image1 TEXT NOT NULL,image2 TEXT NOT NULL,image3 TEXT NOT NULL);";

    public DatabaseHelper(Context context) {
        super(context, DATABASE_NAME , null , DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        try {

            db.execSQL(query1);
            db.execSQL(query2);
            System.out.println("database is created ");
//           databaseOperations.insert_data();
//            System.out.println("database is inserted ");
        }catch (Exception e){
            e.printStackTrace();
//            System.out.println("database is not created ");

        }

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("drop table if exists " +TABLE_NAME );
        db.execSQL("drop table if exists " +TABLE_NAME2 );
        onCreate(db);
    }
}
