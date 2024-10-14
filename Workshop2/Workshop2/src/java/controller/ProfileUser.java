/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import DAO.EmployeeDAO;
import dto.Employee;
import constrants.Gender;
import view.RenderHtmlUser;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author hoanghamhoc
 */
public class ProfileUser extends HttpServlet {

    private static final RenderHtmlUser RH = new RenderHtmlUser();

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
        request.setCharacterEncoding("UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            HttpSession session = request.getSession();
            Employee employee = (Employee) session.getAttribute("employee");
            //check xem đang là update hay view
            if (request.getParameter("type").equalsIgnoreCase("view")) {//view này
                String htmlGender = RH.renderViewGender(employee);

                String htmlDepartment = RH.renderViewDepartment(employee);

                //gọi services để lấy supervisor
                //gán vào biến html
                Employee supervisorEmp = EmployeeDAO.getSupervisorEmp(employee.getSupervisorSSN());
                String htmlSupervisorEmp = RH.renderViewSupervisorEmp(supervisorEmp);

                //tạo biến và bắn nó đi
                String htmlContent = RH.renderHtmlFromInformation(employee, htmlSupervisorEmp, htmlGender, htmlDepartment);
                request.setAttribute("viewProfile", htmlContent);
                request.getRequestDispatcher("profile.jsp").forward(request, response);
            } else {//update này
                String htmlGender = RH.renderNodeGender(employee.getEmpSex().toString());

                String htmlContent = RH.renderViewUpdateEmp(htmlGender, employee);
                request.setAttribute("updateProfile", htmlContent);
                request.getRequestDispatcher("profile.jsp").forward(request, response);
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
//        HttpSession session = request.getSession();
//        Employee employee = (Employee) session.getAttribute("employee");
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
