package edu.temple.bookshelfapp;

import android.content.Context;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.HashMap;

public class BookListFragment extends Fragment {

    private final static String TITLE_KEY = "titleKey";
    private final static String AUTHOR_KEY = "authorKey";
    private View view;
    private OnBookSelectedInterface parent;
    private String title;
    private String author;
    private ArrayList<HashMap<String, String>> books;

    public BookListFragment() {
    }

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        parent = (OnBookSelectedInterface) context;
    }

    @Override
    public void onDetach() {
        super.onDetach();
        parent = null;
    }

     void newInstance(ArrayList<HashMap<String, String>> books) {
        Bundle bundle = new Bundle();
        BookListFragment bookListFragment = new BookListFragment();
        this.books = books;
        bundle.putSerializable("hashMap", books);
        bookListFragment.setArguments(bundle);
     }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Bundle bundle = getArguments();
       if (bundle != null) {
           HashMap hashMap = (HashMap) bundle.getSerializable("HashMap");
           if (hashMap != null) {
               title = (String) hashMap.get(TITLE_KEY);
               author = (String) hashMap.get(AUTHOR_KEY);
           }
       }
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_book_list, container, false);
        ListView listView = view.findViewById(R.id.listView);
        TextView titleTextView = view.findViewById(R.id.titleTextView);
        TextView authorTextView = view.findViewById(R.id.authorTextView);
        ArrayAdapter<HashMap<String, String>> adapter = new ArrayAdapter<>((Context) parent, android.R.layout.simple_list_item_1, books);
        listView.setAdapter(adapter);
        titleTextView.setText(title);
        authorTextView.setText(author);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                BookListFragment.this.parent.bookSelected(position);
            }
        });
        return view;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        view = null;
    }

    interface OnBookSelectedInterface {
        void bookSelected(int index);
    }
}
