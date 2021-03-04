package com.app.model;

import com.app.annotation.UniqueCode;

import javax.persistence.*;

@Entity
public class BorrowManager {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(unique = true)
    private String borrowCode;

    public BorrowManager() {
    }

    public BorrowManager(String borrowCode) {
        this.borrowCode = borrowCode;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getBorrowCode() {
        return borrowCode;
    }

    public void setBorrowCode(String borrowCode) {
        this.borrowCode = borrowCode;
    }
}
