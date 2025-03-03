/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.ass4part4.model;

/**
 *
 * @author bobby
 */
public class Movie {
    private String title;
    private String actor;
    private String actress;
    private String genre;
    private int year;

    @Override
    public String toString() {
        return "Movie{" + "title=" + title + ", actor=" + actor + ", actress=" + actress + ", genre=" + genre + ", year=" + year + '}';
    }

    public Movie() {
    }
     public Movie( String title, String actor, String actress, String genre, int year) {
       
        this.title = title;
        this.actor = actor;
        this.actress = actress;
        this.genre = genre;
        this.year = year;
    }
   

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getActor() {
        return actor;
    }

    public void setActor(String actor) {
        this.actor = actor;
    }

    public String getActress() {
        return actress;
    }

    public void setActress(String actress) {
        this.actress = actress;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }
}
