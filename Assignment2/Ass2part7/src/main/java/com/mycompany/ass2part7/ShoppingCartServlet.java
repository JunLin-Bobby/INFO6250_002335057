/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package com.mycompany.ass2part7;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author bobby
 */
@WebServlet(name = "ShoppingCartServlet", urlPatterns = {"/shoppingcartservlet"})
public class ShoppingCartServlet extends HttpServlet {

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
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            //Create Session Object
            HttpSession session = request.getSession();
           
            //Create ArrayList for storing Cart
            ArrayList<String> cart = (ArrayList<String>) session.getAttribute("cart");
            if (cart == null) {
            cart = new ArrayList<>();
                }
            
        // 判斷請求類型 (新增商品 or 移除商品)
        String action = request.getParameter("action");

        if ("add".equals(action)) {
            // 取得選擇的商品
            String[] selectedProducts = request.getParameterValues("product");
            if (selectedProducts != null) {
                for (String product : selectedProducts) {
                    cart.add(product);
                }
            }
        } else if ("remove".equals(action)) {
            // 移除商品
            String removeItem = request.getParameter("remove");
            if (removeItem != null) {
               
                cart.remove(removeItem);
            }
        }

        // 更新 Session
        session.setAttribute("cart", cart);

        // 導向購物車頁面
        response.sendRedirect("cart.jsp");
            
            
//            out.println("<!DOCTYPE html>");
//            out.println("<html>");
//            out.println("<head>");
//            out.println("<title>Servlet ShoppingCartServlet</title>");
//            out.println("</head>");
//            
//            out.println("<body>");
//            out.println("<h1>Servlet ShoppingCartServlet at " + request.getContextPath() + "</h1>");
//            out.println("</body>");
//            
//            out.println("</html>");
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
