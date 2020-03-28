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
        hashMap.put("HTML & CSS", "Jon Duckett");
        hashMap.put("JavaScript & JQuery", "Jon Duckett");
        hashMap.put("Pro Git: everything you need to know about Git", "Scott Chacom");
        hashMap.put("The Hunger Games", "Suzanne Collins");
        hashMap.put("Catching Fire", "Suzanne Collins");
        hashMap.put("Mockingjay", "Suzanne Collins");
        hashMap.put("Twilight", "Stephenie Meyer");
        hashMap.put("Peeps", "Scott Westerfeld");
        hashMap.put("Python for Everybody", "Charles Severance");
        hashMap.put("Git In Practice", "Mike McQuaid");
        hashMap.put("Pragmatic Guide to Git", "Travis Swicegood");
        hashMap.put("Mastering Sublime Text", "Dan Peleg");
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
            fragmentManager.beginTransaction().replace(R.id.container_1, bookDetailsFragment.newInstance(book)).addToBackStack(null).commit();
        }
        else {
            bookDetailsFragment.displayBook(book);
        }
    }
}
