package com.example.androiddatabinding;

import android.os.Bundle;
import android.util.Log;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.androiddatabinding.databinding.ActivityBookListBinding;


import java.util.ArrayList;
import java.util.List;

public class BookListActivity extends AppCompatActivity {

    ActivityBookListBinding activityUserListBinding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        activityUserListBinding = DataBindingUtil.setContentView(this, R.layout.activity_book_list);

        initRecyclerView();
    }


    /**
     * Renders RecyclerView
     */
    private void initRecyclerView() {
        RecyclerView recyclerView = activityUserListBinding.recyclerView;
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setNestedScrollingEnabled(false);

        BooksListAdapter mAdapter = new BooksListAdapter(getPosts(), new BooksListAdapter.RowItemClickListener() {
            @Override
            public void onRowClicked(Book book) {
                Log.d("DNA", "click position"+book.getName());
            }
        });

        recyclerView.setAdapter(mAdapter);
    }


    private List<Book> getPosts() {
        List<Book> userList = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            userList.add(new Book("Book " + 1, "Book " + 1 + "gmail.com"));
        }
        return userList;
    }
}
