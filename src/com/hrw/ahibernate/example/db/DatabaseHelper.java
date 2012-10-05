
package com.hrw.ahibernate.example.db;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.hrw.ahibernate.example.domain.Book;
import com.hrw.framework.ahibernate.table.TableUtils;

public class DatabaseHelper extends SQLiteOpenHelper {
    public static final String BOOK_TABLE_NAME = "orm_book";

    public static final String DATABASE_NAME = "OrmDemo.db";

    public DatabaseHelper(Context context) {
        super(context, DATABASE_NAME, null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        TableUtils.createTable(db, true, Book.class);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        TableUtils.dropTable(db, Book.class);
        onCreate(db);
    }

}
