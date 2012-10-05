
package com.hrw.ahibernate.example.service;

import java.util.List;
import java.util.Map;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

import com.hrw.ahibernate.example.db.DatabaseHelper;
import com.hrw.ahibernate.example.domain.Book;
import com.hrw.framework.ahibernate.dao.AhibernateDao;

public class DatabaseService {
    private Context mContext;

    private DatabaseHelper mDatabaseHelper;

    private SQLiteDatabase mSQLiteDatabase;

    private AhibernateDao<Book> mBookDao;

    public DatabaseService(Context context) {
        this.mContext = context;
        this.mDatabaseHelper = new DatabaseHelper(mContext);
        this.mSQLiteDatabase = mDatabaseHelper.getWritableDatabase();

        this.mBookDao = new AhibernateDao<Book>(this.mSQLiteDatabase);
    }

    // ===================book begin===========================
    public List<Book> getBooksByWhere(Map<String, String> where) {
        List<Book> bookList = mBookDao.queryList(Book.class, where);
        return bookList;
    }

    public List<Book> getBooks(Book book) {
        List<Book> bookList = mBookDao.queryList(book);
        return bookList;
    }

    public int addBook(Book book) {
        return mBookDao.insert(book);
    }

    public void updateBook(Book book, Map<String, String> where) {
        mBookDao.update(book, where);
    }

    public void deleteBook(Map<String, String> where) {
        mBookDao.delete(Book.class, where);
    }
    // ===================book end===============================

}
