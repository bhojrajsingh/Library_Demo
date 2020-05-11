package com.practise.bhoj.demo.dto;


public class BookDTO {
    Integer bookId;
    String bookName;
    String category;
    String author;

    public BookDTO(Integer bookId, String bookName, String category, String author) {
        this.bookId = bookId;
        this.bookName = bookName;
        this.category = category;
        this.author = author;
    }

    public BookDTO() {
    }

    public Integer getBookId() {
        return bookId;
    }

    public void setBookId(Integer bookId) {
        this.bookId = bookId;
    }

    public String getBookName() {
        return bookName;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }
    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }
}
