/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package com.mycompany.ass2part4;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import org.relique.jdbc.csv.CsvDriver;
/**
 *
 * @author bobby
 */
//@WebServlet(name = "CsvServlet", urlPatterns = {"/csvservlet"})
@WebServlet("/CsvServlet.xls")
public class CsvServlet extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
         // get csv file path
        String csvFileName = request.getParameter("csvFileName");
        String filePathPath = getServletContext().getRealPath("/WEB-INF/data"); // csv file path
        String jdbcUrl = "jdbc:relique:csv:" + filePathPath;
        
        try (PrintWriter out = response.getWriter()) {
            out.println("<h1>Servlet Connected Successfully</h1>");
            out.println("CSV Directory Path: " + filePathPath);
            /* TODO output your page here. You may use following sample code. */
            
            
            Class.forName("org.relique.jdbc.csv.CsvDriver");
            Connection conn = DriverManager.getConnection(jdbcUrl);
            Statement stmt = conn.createStatement();

            // SQL query
            String query = "SELECT * FROM " + csvFileName.replace(".csv", "");
            ResultSet rs = stmt.executeQuery(query);

            // HTML 
            out.println("<html><body>");
            out.println("<h1>Data from " + csvFileName + "</h1>");
            out.println("<table border='1'>");
            int columnCount = rs.getMetaData().getColumnCount();

            // table head
            out.println("<tr>");
            for (int i = 1; i <= columnCount; i++) {
                out.println("<th>" + rs.getMetaData().getColumnName(i) + "</th>");
            }
            out.println("</tr>");

            // table content
            while (rs.next()) {
                out.println("<tr>");
                for (int i = 1; i <= columnCount; i++) {
                    out.println("<td>" + rs.getString(i) + "</td>");
                }
                out.println("</tr>");
            }
            out.println("</table>");
            out.println("</body></html>");

            rs.close();
            stmt.close();
            conn.close();
        } catch (Exception e) {
            e.printStackTrace(response.getWriter());
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
