package edu.temple.bookshelfapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.icu.text.CaseMap;
import android.os.Bundle;

import java.util.ArrayList;
import java.util.HashMap;

public class MainActivity extends AppCompatActivity implements BookListFragment.OnBookSelectedInterface {

    FragmentManager fragmentManager = getSupportFragmentManager();
    boolean singleContainer;
    BookDetailsFragment bookDetailsFragment;
    BookListFragment bookListFragment;
    HashMap book;
    ArrayList<HashMap <String, String>> hashMapArrayList = new ArrayList<>();
    HashMap<String, String> hashMap = new HashMap<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        fragmentManager.beginTransaction().replace(R.id.container_1, new BookListFragment()).commit();
        singleContainer = findViewById(R.id.container_2) == null;
        if (!singleContainer) {
            bookDetailsFragment = new BookDetailsFragment();
            fragmentManager.beginTransaction().replace(R.id.container_2, bookDetailsFragment).commit();
        }
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
        hashMapArrayList.add(hashMap);
       bookListFragment.newInstance(hashMapArrayList);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        fragmentManager = null;
        bookDetailsFragment = null;
        book = null;
        hashMapArrayList = null;
    }

    @Override
    public void bookSelected(int index) {
        book = hashMapArrayList.get(index);
        if (singleContainer) {
            fragmentManager.beginTransaction().replace(R.id.container_1, bookDetailsFragment.newInstance().addToBackStack(null).commit();
        }
        else {
            bookDetailsFragment.displayBook(book);
        }
    }
}
