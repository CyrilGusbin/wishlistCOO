package com.example.wishlist.Backend;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import com.example.wishlist.Backend.FeedReaderContract;

import static com.example.wishlist.Backend.FeedReaderContract.FeedEntry.TABLE_USER;
import static com.example.wishlist.Backend.FeedReaderContract.SQL_CREATE_ENTRIES;
import static com.example.wishlist.Backend.FeedReaderContract.SQL_CREATE_ENTRIES2;
import static com.example.wishlist.Backend.FeedReaderContract.SQL_CREATE_ENTRIES3;
import static com.example.wishlist.Backend.FeedReaderContract.SQL_CREATE_ENTRIES4;
import static com.example.wishlist.Backend.FeedReaderContract.SQL_CREATE_ENTRIES5;
import static com.example.wishlist.Backend.FeedReaderContract.SQL_CREATE_ENTRIES6;
import static com.example.wishlist.Backend.FeedReaderContract.SQL_CREATE_ENTRIES7;
import static com.example.wishlist.Backend.FeedReaderContract.SQL_DELETE_ENTRIES;
import static com.example.wishlist.Backend.FeedReaderContract.SQL_DELETE_ENTRIES2;
import static com.example.wishlist.Backend.FeedReaderContract.SQL_DELETE_ENTRIES3;
import static com.example.wishlist.Backend.FeedReaderContract.SQL_DELETE_ENTRIES4;
import static com.example.wishlist.Backend.FeedReaderContract.SQL_DELETE_ENTRIES5;
import static com.example.wishlist.Backend.FeedReaderContract.SQL_DELETE_ENTRIES6;
import static com.example.wishlist.Backend.FeedReaderContract.SQL_DELETE_ENTRIES7;
public class FeedReaderDbHelper extends SQLiteOpenHelper {
    public static final int DATABASE_VERSION = 1;
    public static final String DATABASE_NAME = "FeedReader.db";
    public FeedReaderDbHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);

    }
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(SQL_CREATE_ENTRIES5);
        db.execSQL(SQL_CREATE_ENTRIES);
        db.execSQL(SQL_CREATE_ENTRIES2);
        db.execSQL(SQL_CREATE_ENTRIES3);
        db.execSQL(SQL_CREATE_ENTRIES4);
        db.execSQL(SQL_CREATE_ENTRIES6);
        db.execSQL(SQL_CREATE_ENTRIES7);
        Log.e("Database operations", "Tables created");
    }
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        // This database is only a cache for online data, so its upgrade policy is
        // to simply to discard the data and start over
        db.execSQL(SQL_DELETE_ENTRIES);
        db.execSQL(SQL_DELETE_ENTRIES2);
        db.execSQL(SQL_DELETE_ENTRIES3);
        db.execSQL(SQL_DELETE_ENTRIES4);
        db.execSQL(SQL_DELETE_ENTRIES5);
        db.execSQL(SQL_DELETE_ENTRIES6);
        db.execSQL(SQL_DELETE_ENTRIES7);
        onCreate(db);
    }
    public void onDowngrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        onUpgrade(db, oldVersion, newVersion);
    }



}
