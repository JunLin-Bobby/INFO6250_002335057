/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.ass3part9;

import javax.servlet.jsp.tagext.SimpleTagSupport;
import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.servlet.jsp.PageContext;

/**
 *
 * @author bobby
 */
public class CsvDataTag  extends SimpleTagSupport{
    private String fileName;
    
    public void setfileName(String name){
       this.fileName=name;
    }
    
    @Override
    public void doTag() throws JspException, IOException {
        JspWriter out = getJspContext().getOut();
        //Check if the file name is empty
        if (fileName == null || fileName.trim().isEmpty()) {
            out.println("<p style='color:red;'>Error: No CSV file specified.</p>");
            return;
        }
        //load CSV file path
        PageContext pageContext = (PageContext) getJspContext();
        String csvDirectory = pageContext.getServletContext().getRealPath("/WEB-INF/data");
        String jdbcUrl = "jdbc:relique:csv:" + csvDirectory;
        
        try {
            // load csvDriver
            Class.forName("org.relique.jdbc.csv.CsvDriver");
            Connection conn = DriverManager.getConnection(jdbcUrl);
            Statement stmt = conn.createStatement();
            
            //SQL query
            String tableName = fileName.replace(".csv", "");
            String query = "SELECT * FROM " + tableName;
            ResultSet rs = stmt.executeQuery(query);
            
            // Start building HTML
            out.println("<table border='1''>");

            
            int columnCount = rs.getMetaData().getColumnCount();
            out.println("<tr>");
            for (int i = 1; i <= columnCount; i++) {
                out.println("<th border='1''>" + rs.getMetaData().getColumnName(i) + "</th>");
            }
            out.println("</tr>");
            while (rs.next()) {
                out.println("<tr>");
                for (int i = 1; i <= columnCount; i++) {
                    out.println("<td>" + rs.getString(i) + "</td>");
                }
                out.println("</tr>");
            }

            out.println("</table>");

            rs.close();
            stmt.close();
            conn.close();
        } catch (Exception e) {
            
             out.println("<p style='color:red;'>Error: " + e.getMessage() + "</p>");
        }
    }
}
