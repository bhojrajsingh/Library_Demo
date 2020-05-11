package com.practise.bhoj.demo.model;

import java.io.Serializable;

public class BookID implements Serializable {
    private Integer bookId;
    private Integer libId;

    public BookID(Integer bookId, Integer libId) {
        this.bookId = bookId;
        this.libId = libId;
    }

    public BookID() {
    }

    public Integer getBookId() {
        return bookId;
    }

    public void setBookId(Integer bookId) {
        this.bookId = bookId;
    }

    public Integer getLibId() {
        return libId;
    }

    public void setLibId(Integer libId) {
        this.libId = libId;
    }
}
