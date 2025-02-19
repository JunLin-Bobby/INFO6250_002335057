/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.ass4part4;

import com.mycompany.ass4part4.model.Movie;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author bobby
 */
public class movieDAO {
    private static final String URL = "jdbc:mysql://localhost:3306/testdb";
    private static final String USER = "jun6250";  
    private static final String PASSWORD = "0000"; 
    
    public movieDAO() {
        try {   
            Class.forName("com.mysql.cj.jdbc.Driver");
            System.out.println(" MySQL JDBC loaded successfully");
        }
        catch (ClassNotFoundException e) {
            System.err.println("MySQL JDBC loaded fail!");
            e.printStackTrace();
        }
    }
    public boolean addMovie(Movie movie) {
        String sql = "INSERT INTO moviespart6 (title, actor, actress, genre, year) VALUES (?, ?, ?, ?, ?)";
        try (Connection conn = DriverManager.getConnection(URL, USER, PASSWORD);
            PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, movie.getTitle());
            stmt.setString(2, movie.getActor());
            stmt.setString(3, movie.getActress());
            stmt.setString(4, movie.getGenre());
            stmt.setInt(5, movie.getYear());

            int rowsInserted = stmt.executeUpdate();
            if (rowsInserted > 0) {
                System.out.println("Insert Successed! " + rowsInserted+" rows have beened inserted.");
                return true;
            } else {
                System.out.println("Insert Failed!");
                return false;
            }

        } catch (SQLException e) {
             System.out.println( e.getMessage());
             System.out.flush();
            e.printStackTrace();
        }
        return false;
    }
    
    public List<Movie> searchMovies(String category,String keyword){
        List<Movie> movies = new ArrayList<>();
        String column = category.equals("title") ? "title" : category.equals("actor") ? "actor" : "actress";
        
        String sql = "SELECT title, actor, actress, genre, year FROM moviespart6 WHERE " + column + " LIKE ?";
        
        try(Connection conn = DriverManager.getConnection(URL,USER, PASSWORD);
            PreparedStatement stmt = conn.prepareStatement(sql)){
            stmt.setString(1, "%" + keyword + "%");
            ResultSet rs  = stmt.executeQuery();
            while(rs.next()){
                movies.add(new Movie(
                           rs.getString("title"),
                           rs.getString("actor"),
                           rs.getString("actress"),
                           rs.getString("genre"),
                           rs.getInt("year")
                ));
            }
        }catch(Exception e){
            e.printStackTrace();
        }
        return movies;
    }
    
}
