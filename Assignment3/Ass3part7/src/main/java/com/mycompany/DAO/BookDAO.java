/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.DAO;

import static java.lang.Float.parseFloat;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
/**
 *
 * @author bobby
 */
public class BookDAO {
    private static final String URL = "jdbc:mysql://localhost:3306/testdb";
    private static final String USER = "jun6250";  
    private static final String PASSWORD = "0000"; 
    public BookDAO() {
    
    try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            System.out.println(" MySQL JDBC loaded successfully");
        } catch (ClassNotFoundException e) {
            System.err.println("MySQL JDBC loaded fail!");
            e.printStackTrace();
        }
    }
    public void addBooks(String[]isbns,String[]titles,String[]authors,String[]prices){
        String sql = "INSERT INTO books (isbn,title,author,price) VALUE(?,?,?,?)";
        
        //connect to DB       DriverManager
        try(Connection conn = DriverManager.getConnection(URL, USER, PASSWORD);
            PreparedStatement stmt = conn.prepareStatement(sql)){
            for(int i=0 ;i<=isbns.length;i++){
                stmt.setString(1,isbns[i]);
                stmt.setString(2,titles[i]);
                stmt.setString(3,authors[i]);
                stmt.setFloat(4,parseFloat(prices[i]));
                stmt.executeUpdate();
            }
            
        }catch(Exception e){
            e.printStackTrace();
        }
    }
}
