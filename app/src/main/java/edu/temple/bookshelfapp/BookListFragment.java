package edu.temple.bookshelfapp;

import android.content.Context;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.HashMap;

public class BookListFragment extends Fragment {

    private final static String TITLE = "title";
    private final static String AUTHOR = "author";
    private View view;
    private BookListInterface parent;

    public BookListFragment() {
    }

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        parent = (BookListInterface) context;
    }

    @Override
    public void onDetach() {
        super.onDetach();
        parent = null;
    }

    public static BookListFragment newInstance (ArrayList<HashMap<String, String>> books) {
        Bundle bundle = new Bundle();
        BookListFragment bookListFragment = new BookListFragment();
        bundle.putString(TITLE, AUTHOR);
        bookListFragment.setArguments(bundle);
        return bookListFragment;
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
        listView.setAdapter(adapter);
        title.setText(hashMap.get(TITLE));
        author.setText(hashMap.get(AUTHOR));
        return view;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        view = null;
    }

    interface BookListInterface {
        void displayBookList();
    }
}
