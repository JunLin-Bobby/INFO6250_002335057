/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package com.mycompany.ass2part5;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.PrintWriter;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.*;

/**
 *
 * @author bobby
 */
@WebServlet("/excelservlet.xls")
public class ExcelServlet extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    //processRequest
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            
        // get Excel file path
        String filePath = getServletContext().getRealPath("/WEB-INF/data/store.xls");
        File excelFile = new File(filePath);

        // make sure the file path is correct
        if (!excelFile.exists()) {
            out.println("<html><body><h3>Error:  Excel file not found ! file path should be: "+filePath+"</h3></body></html>");
          
            return;
        }else{ out.println("<html><body><h3>File Found successfully, File path: "+ filePath+"</h3></body></html>");
            }
            
            out.println("<!DOCTYPE html>");
            
            try (FileInputStream fis = new FileInputStream(excelFile);
             Workbook workbook = new HSSFWorkbook(fis)) {

            // getting excel sheet
            Sheet sheet = workbook.getSheetAt(0);

           
            out.println("<html><head><title>Excel Data</title></head><body>");
            out.println("<h2>Excel Content</h2>");
            out.println("<table border='1' cellpadding='5'>");

            // Parsing EXCEL Content
            for (Row row : sheet) {
                out.println("<tr>");
                for (Cell cell : row) {
                    out.println("<td>");
                    switch (cell.getCellType()) {
                        case STRING:
                            out.println(cell.getStringCellValue());
                            break;
                        case NUMERIC:
                            out.println(cell.getNumericCellValue());
                            break;
                        case BOOLEAN:
                            out.println(cell.getBooleanCellValue());
                            break;
                        case FORMULA:
                            out.println(cell.getCellFormula());
                            break;
                        default:
                            out.println(" ");
                    }
                    out.println("</td>");
                }
                out.println("</tr>");
            }

           
            out.println("</table></body></html>");

        } catch (Exception e) {
            out.println("<p>Error when loading Excel : " + e.getMessage() + "</p>");
        }
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
