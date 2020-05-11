package com.practise.bhoj.demo.model;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Set;

@Entity
@Table(name = "LIBRARY")
public class Library implements Serializable {
    @Id
    @Column(name="LIB_ID", nullable = false)
    private Integer libId;

    @Column(name="LIB_NAME")
    private String libName;


    public Library(Integer libId, String libName) {
        this.libId = libId;
        this.libName = libName;
    }


    public Library() {
     }

    public Integer getLibId() {
        return libId;
    }

    public void setLibId(Integer libId) {
        this.libId = libId;
    }

    public String getLibName() {
        return libName;
    }

    public void setLibName(String libName) {
        this.libName = libName;
    }



}
