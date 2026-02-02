/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package controllers;

import commons.Common;
import dao.CategoryDAO;
import dao.LogisticsProvidersDAO;
import dao.ReceiptDAO;
import dao.UserDAO;
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
import models.LogisticsProviders;
import models.User;

/**
 *
 * @author ad
 */
@WebServlet(name = "CreateReceiptsController", urlPatterns = {"/create-receipts"})
public class CreateReceiptsController extends HttpServlet {

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
            out.println("<title>Servlet CreateReceiptsController</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet CreateReceiptsController at " + request.getContextPath() + "</h1>");
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
        // Call CategoryDAO class and get all category.
        CategoryDAO categoryDAO  = new CategoryDAO();
        List<Categories> categories = categoryDAO.listCategory();
        LogisticsProvidersDAO logisticsProvidersDAO = new LogisticsProvidersDAO();
        List<LogisticsProviders> providers = logisticsProvidersDAO.listProvider();
        // Add to request data and return to jsp file.
        request.setAttribute("categories", categories);
        request.setAttribute("providers", providers);
        // Redirect html login page
        request.getRequestDispatcher("create_receipts.jsp").forward(request, response);
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
        // GET data request param in form
        String receiptName = request.getParameter("receipt_name");
        int categoryId     = Integer.parseInt(request.getParameter("category"));
        String detail      = request.getParameter("detail");
        String deliveryDate  = request.getParameter("delivery_date");
        int logisticProvider = Integer.parseInt(request.getParameter("logistics_provider"));
        int quantity   = Integer.parseInt(request.getParameter("quantity"));
        int totalPrice = Integer.parseInt(request.getParameter("total_price"));
        int type = Integer.parseInt(request.getParameter("type"));
        // Get email of users logged.
        HttpSession session = request.getSession();
        String email = (String) session.getAttribute("USER_EMAIL_LOGIN");
        System.out.println(email);
        // get storageId and userId from users table.
        UserDAO userDAO = new UserDAO();
        User userInfo = userDAO.findByEmail(email);
        int storageId = userInfo.getStorage_id();
        int userId = userInfo.getId();
        // Call to DAO and insert in to database
        ReceiptDAO receiptDAO = new ReceiptDAO();
        boolean storeReceipt = receiptDAO.store(
             receiptName, categoryId, 
             detail, deliveryDate, logisticProvider,
             quantity, totalPrice,  type, storageId, userId
        );
        if (storeReceipt) {
            session.setAttribute("STORE_RECEIPT_STATUS", true);
        } else {
            session.setAttribute("STORE_RECEIPT_STATUS", false);
        }
        response.sendRedirect("index");
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
