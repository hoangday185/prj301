/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import DAO.TimeworkDAO;
import dto.Employee;
import dto.TimeWork;
import java.io.IOException;
import java.io.PrintWriter;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import view.RenderTimeWork;

/**
 *
 * @author hoanghamhoc
 */
public class TimeWorkServlet extends HttpServlet {

    private static final RenderTimeWork RTK = new RenderTimeWork();
    private static final int BONUS = 10;

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
            throws ServletException, IOException, Exception {
        response.setContentType("text/html;charset=UTF-8");
        request.setCharacterEncoding("UTF-8");
        try (PrintWriter out = response.getWriter()) {
            Employee emp = (Employee) request.getSession().getAttribute("employee");
            ArrayList<TimeWork> listTimeWork = TimeworkDAO.getListTimeWork(emp.getEmpSSN());
            if (listTimeWork.isEmpty()) {
                String noti = "<h1 class='text-center'>Bạn chưa tham gia project nào cả</h1>"
                        + "<h2 class='text-center'>Mức lương hiện tại của bạn là" + emp.getSalary() + " </h2>";
                request.setAttribute("noti", noti);
                request.getRequestDispatcher("Report.jsp").forward(request, response);
            } else {
                String htmlBonusAndTotal = RTK.renderTotalAndBonus(listTimeWork, BONUS, emp);
                String htmlTblBody = RTK.renderBodyTable(listTimeWork);
                String htmlTable = RTK.renderTableReport(htmlTblBody, htmlBonusAndTotal);
                request.setAttribute("report", htmlTable);
                request.getRequestDispatcher("Report.jsp").forward(request, response);
            }
        } catch (Exception e) {
            e.printStackTrace();
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
        try {
            processRequest(request, response);
        } catch (Exception ex) {
            Logger.getLogger(TimeWorkServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
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
        try {
            processRequest(request, response);
        } catch (Exception ex) {
            Logger.getLogger(TimeWorkServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
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
