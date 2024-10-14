/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import dao.OrderDAO;
import dao.OrderDetailDAO;
import dao.ShipperDAO;
import dto.FullInforOrder;
import dto.Order;
import dto.Shipper;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author hoanghamhoc
 */
public class AdminOrderSuccessfull extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    //servlet sẽ lấy ra các ra đầy đủ thông tin đơn hàng
    //từ shipper, customer, flower, quantity
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            ArrayList<Order> listOrder = OrderDAO.getListOrderStatusOrderSuccessfull();
            ArrayList<FullInforOrder> listFullInforOrder = OrderDetailDAO.getlistFullInforOrder(listOrder);
            request.setAttribute("showListOrder", "listOrder");
            //lệnh này để chúng ta xài cùng 1 trang jsp để hiển thị code
            request.getSession().setAttribute("listFullInforOrder", listFullInforOrder);
            //lưu biến này lên session vì nếu update thì chỉ cần xóa phần bị update và truy cập vào database lấy
            //phần tử mới lên add vô list và set lại giá trị trong session
            request.getRequestDispatcher("AdminOrderSuccessfull.jsp").forward(request, response);
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
