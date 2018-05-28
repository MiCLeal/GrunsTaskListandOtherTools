package com.miniapps.grunstasklistandothertools.database;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import com.miniapps.grunstasklistandothertools.database.FeedReaderContract.FeedEntry;

public class FeedReaderDBHelper extends SQLiteOpenHelper {

    private static final int DATABASE_VERSION = 1;
    private static final String DATABASE_NAME = "gruntet.db";

    private static final String SQL_CREATE_CLIENTS_ENTRIES =
            "CREATE TABLE " + FeedEntry.TABLE_CLIENTS_NAME + " (" +
                    FeedEntry._ID + " INTEGER PRIMARY KEY," +
                    FeedEntry.TB_CLI_COL_1 + " TEXT NOT NULL," +
                    FeedEntry.TB_CLI_COL_2 + " TEXT NOT NULL," +
                    FeedEntry.TB_CLI_COL_3 + " TEXT," +
                    FeedEntry.TB_CLI_COL_4 + " TEXT," +
                    FeedEntry.TB_CLI_COL_5 + " TEXT)";

    private static final String SQL_DELETE_CLIENTS_ENTRIES =
            "DROP TABLE IF EXISTS " + FeedEntry.TABLE_CLIENTS_NAME;

    public FeedReaderDBHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(SQL_CREATE_CLIENTS_ENTRIES);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL(SQL_DELETE_CLIENTS_ENTRIES);
        onCreate(db);
    }

    public boolean insertClientData(String name, String cpf, String email, String phone, String cel) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(FeedEntry.TB_CLI_COL_1, name);
        contentValues.put(FeedEntry.TB_CLI_COL_2, cpf);
        contentValues.put(FeedEntry.TB_CLI_COL_3, email);
        contentValues.put(FeedEntry.TB_CLI_COL_4, phone);
        contentValues.put(FeedEntry.TB_CLI_COL_5, cel);
        long result = db.insert(FeedEntry.TABLE_CLIENTS_NAME, null, contentValues);
        if (result == -1)
            return false;
        else
            return true;
    }

    public Cursor getAllClientData() {
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor res = db.rawQuery("select * from " + FeedEntry.TABLE_CLIENTS_NAME, null);
        return res;
    }

    public boolean updateClientData(String name, String cpf, String email, String phone, String cel) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(FeedEntry.TB_CLI_COL_1, name);
        contentValues.put(FeedEntry.TB_CLI_COL_2, cpf);
        contentValues.put(FeedEntry.TB_CLI_COL_3, email);
        contentValues.put(FeedEntry.TB_CLI_COL_4, phone);
        contentValues.put(FeedEntry.TB_CLI_COL_5, cel);
        db.update(FeedEntry.TABLE_CLIENTS_NAME, contentValues, "CPF = ?", new String[]{cpf});
        return true;
    }

    public Integer deleteClientData(String id) {
        SQLiteDatabase db = this.getWritableDatabase();
        return db.delete(FeedEntry.TABLE_CLIENTS_NAME, "ID = ?", new String[]{id});
    }
}
