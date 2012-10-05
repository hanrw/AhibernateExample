
package com.hrw.ahibernate.example;

import java.util.Random;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.hrw.ahibernate.example.domain.Book;
import com.hrw.ahibernate.example.service.DatabaseService;

public class AhibernateExampleActivity extends Activity {
    /** Called when the activity is first created. */
    DatabaseService mDatabaseService;

    Button mAddButton;

    Button mQueryButton;

    TextView mTextView;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        mAddButton = (Button) findViewById(R.id.add);
        mQueryButton = (Button) findViewById(R.id.query);
        mTextView = (TextView) findViewById(R.id.count);
        mDatabaseService = new DatabaseService(this);
        mAddButton.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View arg0) {
                Book book = new Book();
                Random ra = new Random();
                book.setId(ra.nextLong());
                book.setBookName("demo");
                mDatabaseService.addBook(book);
                Toast.makeText(AhibernateExampleActivity.this, "添加成功", Toast.LENGTH_SHORT).show();
            }
        });

        mQueryButton.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                mTextView.setText("总共有" + mDatabaseService.getBooksByWhere(null).size() + "本书");
            }
        });
    }

}
