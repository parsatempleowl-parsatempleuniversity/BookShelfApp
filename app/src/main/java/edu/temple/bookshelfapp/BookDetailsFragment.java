package edu.temple.bookshelfapp;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.HashMap;

public class BookDetailsFragment extends Fragment {

    private final static String TITLE_KEY = "titleKey";
    private final static String AUTHOR_KEY = "authorKey";
    private String title;
    private String author;
    private View view;
    private TextView titleTextView;
    private TextView authorTextView;
    private HashMap book;


    public BookDetailsFragment() {
    }

    BookDetailsFragment newInstance(HashMap book) {
        this.book = book;
        BookDetailsFragment bookDetailsFragment = new BookDetailsFragment();
        Bundle bundle = new Bundle();
        title = (String) book.get(TITLE_KEY);
        author = (String) book.get(AUTHOR_KEY);
        bundle.putString(title, author);
        bookDetailsFragment.setArguments(bundle);
        return bookDetailsFragment;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Bundle bundle = getArguments();
        if (bundle != null) {
            title = bundle.getString(TITLE_KEY);
            author = bundle.getString(AUTHOR_KEY);
        }
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        title = null;
        author = null;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_book_details, container, false);
        titleTextView = view.findViewById(R.id.titleTextView);
        authorTextView = view.findViewById(R.id.authorTextView);
        if ((titleTextView != null) && (authorTextView != null)) {
            displayBook(book);
        }
        return view;
    }

    void displayBook(HashMap book) {
        titleTextView.setText(title);
        authorTextView.setText(author);
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        view = null;
    }
}
