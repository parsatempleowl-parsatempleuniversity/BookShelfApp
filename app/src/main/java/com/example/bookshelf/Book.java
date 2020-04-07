package com.example.bookshelf;

public class Book {

        private String book_id, author, title , cover_url;

        public String getBook_id() {
            return book_id;
        }

        void setBook_id(String book_id) {
            this.book_id = book_id;
        }

        String getAuthor() {
            return author;
        }

        void setAuthor(String author) {
            this.author = author;
        }

        String getTitle() {
            return title;
        }

        void setTitle(String title) {
            this.title = title;
        }

        String getCover_url() {
            return cover_url;
        }

        void setCover_url(String cover_url) {
            this.cover_url = cover_url;
        }
    }

}
