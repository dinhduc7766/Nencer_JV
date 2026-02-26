/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package controllers;

import commons.Common;
import dao.CategoryDAO;
import dao.ReceiptDAO;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import java.util.List;
import models.Categories;
import models.Receipts;

/**
 *
 * @author ad
 */
@WebServlet(name = "IndexController", urlPatterns = {"/index"})
public class IndexController extends HttpServlet {

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
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet IndexController</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet IndexController at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
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
        // Set encoding UTF-8
        Common.setUTF8(request, response);
        HttpSession session = request.getSession();
        if (session == null) {
            // Not login.
            response.sendRedirect("/login");
            //return
        }
        // Logged using email of user query data from db.
        session.getAttribute("USER_EMAIL_LOGIN");
        // Pass search params.
        String id = request.getParameter("id");
        String category = request.getParameter("category");
        String from_date = request.getParameter("from_date");
        String to_date = request.getParameter("to_date");
        
        // List receipts.
        ReceiptDAO receiptDAO = new ReceiptDAO();
        List<Receipts> receipts = receiptDAO.list(id, category, from_date, to_date);
        request.setAttribute("receipts", receipts);
        //List categories
        CategoryDAO categoryDAO  = new CategoryDAO();
        List<Categories> categories = categoryDAO.listCategory();
        // Add to request data and return to jsp file.
        request.setAttribute("categories", categories);
        // Render view file.
        request.getRequestDispatcher("index.jsp").forward(request, response);
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
