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

    public static BookListFragment newInstance (ArrayList<HashMap> books) {
        Bundle bundle = new Bundle();
        BookListFragment bookListFragment = new BookListFragment();
        bundle.putString(TITLE_KEY, AUTHOR_KEY);
        bookListFragment.setArguments(bundle);
        return bookListFragment;
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
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_book_list, container, false);
        ListView listView = view.findViewById(R.id.listView);
        TextView title = view.findViewById(R.id.title);
        TextView author = view.findViewById(R.id.author);
        HashMap<String, String> hashMap = new HashMap<>();
        hashMap.put("Book 1", "Author 1");
        hashMap.put("Book 2", "Author 2");
        hashMap.put("Book 3", "Author 3");
        hashMap.put("Book 4", "Author 4");
        hashMap.put("Book 5", "Author 5");
        hashMap.put("Book 6", "Author 6");
        hashMap.put("Book 7", "Author 7");
        hashMap.put("Book 8", "Author 8");
        hashMap.put("Book 9", "Author 9");
        hashMap.put("Book 10", "Author 10");
        ArrayList<HashMap <String, String>> hashMapArrayList = new ArrayList<>();
        hashMapArrayList.add(hashMap);
        ArrayAdapter<HashMap<String, String>> adapter = new ArrayAdapter<>((Context) parent, android.R.layout.simple_list_item_1, hashMapArrayList);
        adapter.add(hashMap);
        listView.setAdapter(adapter);
        title.setText(hashMap.get(TITLE_KEY));
        author.setText(hashMap.get(AUTHOR_KEY));
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
