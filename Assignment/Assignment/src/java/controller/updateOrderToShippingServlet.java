/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import dao.OrderDAO;
import dao.ShipperDAO;
import dto.FullInforOrder;
import java.io.IOException;
import java.io.PrintWriter;
import java.math.BigDecimal;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author hoanghamhoc
 */
public class updateOrderToShippingServlet extends HttpServlet {

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
            BigDecimal shipperId = new BigDecimal(request.getParameter("shipperId"));
            BigDecimal orderId = new BigDecimal(request.getParameter("orderId"));
            int result = OrderDAO.updateOrderToShipping(orderId, shipperId);
            if (result == 1) {
                ArrayList<FullInforOrder> listFullInforOrder = (ArrayList<FullInforOrder>) request.getSession().getAttribute("listFullInforOrder");
                for (FullInforOrder fullInforOrder : listFullInforOrder) {
                    if (fullInforOrder.getOrder().getOrderID().compareTo(orderId) == 0) {
                        fullInforOrder.getOrder().setShipper(ShipperDAO.getShipperById(shipperId));
                        break;
                    }
                }
                request.getSession().setAttribute("listFullInforOrder", listFullInforOrder);
                request.setAttribute("updateOrder", "Update successfull");
                request.getRequestDispatcher("index.jsp").forward(request, response);
            } else {
                request.setAttribute("updateOrderFail", "Something wrong please update again");
                request.getRequestDispatcher("index.jsp").forward(request, response);
            }

        } catch (Exception err) {
            err.printStackTrace();
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
