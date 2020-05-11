package com.practise.bhoj.demo.model;



import javax.persistence.*;
import java.io.Serializable;
import java.util.Set;

@Entity
@Table(name = "BOOK")
@IdClass(BookID.class)
public class Book implements Serializable {
    @Id  @GeneratedValue(strategy=GenerationType.AUTO)
    @Column(name="BOOK_ID")
    Integer bookId;
    @Id
    @Column(name="LIB_ID")
    Integer libId;
    @Column(name="BOOK_NAME")
    String bookName;
    @Column(name="BOOK_CATEGORY")
    String category;
    @Column(name="BOOK_AUTHOR")
    String author;



    public Book(Integer bookId, Integer libId, String bookName, String category, String author) {
        this.bookId = bookId;
        this.libId = libId;
        this.bookName = bookName;
        this.category = category;
        this.author = author;
    }

    public Book(Integer libId, String bookName, String category, String author) {
        this.libId = libId;
        this.bookName = bookName;
        this.category = category;
        this.author = author;
    }

    public Book() {
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
