package edu.temple.bookshelfapp;

import androidx.appcompat.app.AppCompatActivity;

import android.icu.text.CaseMap;
import android.os.Bundle;

import java.util.ArrayList;
import java.util.HashMap;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
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
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
    }
}
