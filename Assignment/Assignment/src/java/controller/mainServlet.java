/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author hoanghamhoc
 */
public class mainServlet extends HttpServlet {

    private final static String login = "login";

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
            String action = request.getParameter("action");
            String url = "index.jsp";
            if (action == null) {
                action = "";
            }
            switch (action) {
                case "":
                    url = "index.jsp";
                    break;
                case "login":
                    url = "loginServlet";
                    break;
                case "register":
                    url = "registerServlet";
                    break;
                case "find":
                    url = "searchServlet";
                    break;
                case "logout":
                    url = "logoutServlet";
                    break;
                case "listFlower":
                    url = "listFlowerServlet";
                    break;
                case "AdminOrderSuccessfull":
                    url = "AdminOrderSuccessfull";
                    break;
                case "AdminOrder":
                    url = "AdminOrderServlet";
                    break;
                case "setUpOrderFullInfor":
                    url = "setUpOrderFullInforServlet";
                    break;
                case "updateOrderToShipping":
                    url = "updateOrderToShippingServlet";
                    break;
                case "showDetailOrder":
                    url = "showDetailOrderServlet";
                    break;
                case "customer":
                    url = "CustomerServlet";
                    break;
                case "updateUserAccount":
                    url = "updateUserAccountServlet";
                    break;
                case "setUpFlower":
                    url = "setUpFlowerServlet";
                    break;
            }
            request.getRequestDispatcher(url).forward(request, response);
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
