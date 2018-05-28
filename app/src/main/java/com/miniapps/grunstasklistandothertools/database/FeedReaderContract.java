package com.miniapps.grunstasklistandothertools.database;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.provider.BaseColumns;

public final class FeedReaderContract {

    private FeedReaderContract() {}

    public static class FeedEntry implements BaseColumns {

        public static final String TABLE_TASKS_NAME = "tasks_table";
        public static final String TABLE_CLIENTS_NAME = "client_table";
        public static final String TB_CLI_COL_1= "NAME";
        public static final String TB_CLI_COL_2 = "CPF";
        public static final String TB_CLI_COL_3 = "EMAIL";
        public static final String TB_CLI_COL_4 = "PHONE";
        public static final String TB_CLI_COL_5 = "CEL";


    }
}

