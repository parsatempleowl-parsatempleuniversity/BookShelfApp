package com.example.bookshelf;

import java.io.Serializable;

public class Book implements Serializable {
    private String title, author;

    public Book( String author, String title){
        this.title=title;
        this.author=author;
    }

    String getAuthor(){
        return author;
    }
    String getTitle(){
        return title;
    }
}
