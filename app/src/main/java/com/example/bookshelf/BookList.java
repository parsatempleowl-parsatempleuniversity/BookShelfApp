package com.example.bookshelf;

import android.os.Bundle;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

public class BookDetailsFragment extends Fragment {
    private static final String BOOK_KEY = "book";
    private static final String BOOK_KEY2 = "book2";
    private Book book;

    TextView titleTextView, authorTextView;

    public BookDetailsFragment() {}
    static BookDetailsFragment newInstance(Book book) {
        BookDetailsFragment fragment = new BookDetailsFragment();
        Bundle args = new Bundle();
        args.putSerializable(BOOK_KEY, book);
        fragment.setArguments(args);
        return fragment;
    }
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if(savedInstanceState ==null){
            if (getArguments() != null) {
                book = (Book) getArguments().getSerializable(BOOK_KEY);
            }
        }else{
            book = (Book) savedInstanceState.getSerializable(BOOK_KEY2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_book_details, container, false);
        titleTextView = v.findViewById(R.id.titleTextView);
        authorTextView = v.findViewById(R.id.authorTextView);
        if (book != null)
            displayBook(book);
        return v;
    }
    void displayBook(Book book) {
        titleTextView.setText(book.getTitle());
        authorTextView.setText(book.getAuthor());
    }
    @Override
    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putSerializable(BOOK_KEY2, book);
    }
}
