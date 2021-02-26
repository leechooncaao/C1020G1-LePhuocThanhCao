package com.show_image.model;

import javax.persistence.*;

@Entity
@Table
public class Photo{

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private int rate;
    private String author;
    private String comment;

    public Photo(int id, int rate, String author, String comment) {
        this.id = id;
        this.rate = rate;
        this.author = author;
        this.comment = comment;
    }

    public Photo() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getRate() {
        return rate;
    }

    public void setRate(int rate) {
        this.rate = rate;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }
}
