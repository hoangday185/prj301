/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import constraints.StatusAvailable;
import dao.AccountDAO;
import dao.AdminDAO;
import dao.CustomerDAO;
import dao.ShipperDAO;
import dto.Account;
import dto.Admin;
import dto.Customer;
import dto.Shipper;
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
public class loginServlet extends HttpServlet {

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
            String email = request.getParameter("email");
            String pwd = request.getParameter("pwd");
            //ta lấy account ra đã nha
            Account account = AccountDAO.getAccount(email, pwd);
            if (account.getStatusAvailable().getCodeAvailabel() == 1) {
                //out.println("Ko có account nào cả");
                request.setAttribute("msgLogin", "Tài khoản hoặc mật khẩu ko chính xác");
                request.setAttribute("email", email);
                request.setAttribute("pwd", pwd);
                request.getRequestDispatcher("login.jsp").forward(request, response);
            } else {
                //check role nào rồi chuyển nó về trang chính thôi
                if (account.getRoleUser().getRole() == 1) {//admin nè
                    Admin admin = AdminDAO.getAdmin(account);
                    request.getSession().setAttribute("admin", admin);
                    request.getRequestDispatcher("index.jsp").forward(request, response);
                    //out.println(admin.toString());
                } else if (account.getRoleUser().getRole() == 2) {//shipper
                    Shipper shipper = ShipperDAO.getShipper(account);
                    request.getSession().setAttribute("shipper", shipper);
                    request.getRequestDispatcher("index.jsp").forward(request, response);
                    //out.println(shipper.toString());
                } else if (account.getRoleUser().getRole() == 3) {//customer
                    Customer customer = CustomerDAO.getCustomer(account);
                    request.getSession().setAttribute("customer", customer);
                    request.getRequestDispatcher("index.jsp").forward(request, response);
                    //out.println(customer.toString());
                }
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
