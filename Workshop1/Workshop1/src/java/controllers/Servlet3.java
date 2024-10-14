/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import dao.DepartmentDAO;
import dao.EmployeeDAO;
import dto.Department;
import dto.Employee;
import java.io.IOException;
import java.io.PrintWriter;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author user
 */
public class Servlet3 extends HttpServlet {

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
        //code ở servlet này để check lại các node control ở bên kia
        //nếu đúng thì lưu vào database
        //ko đúng thì nhập lại thì quay lại bên kia và nhập lại từ những thứ cần thiết
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            request.setCharacterEncoding("UTF-8");
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html lang='vi'>");
            out.println("<head>");
            out.println("<title>Servlet Servlet3</title>");
            out.println("</head>");
            out.println(" <link \n"
                    + "        href=\"https://cdn.jsdelivr.net/npm/bootstrap@5.3.1/dist/css/bootstrap.min.css\" \n"
                    + "        rel=\"stylesheet\" integrity=\"sha384-4bw+/aepP/YC94hEpVNVgiZdgIC5+VKNBQNGCHeKRQN+PtmoHDEXuppvnDJzQIu9\" \n"
                    + "        crossorigin=\"anonymous\">");
            out.println("<body>");
            out.println("<div class='container'><h1>Part 3</h1>");
            out.println("<a href=\"index.html\" class=\"btn btn-primary mx-2\">Home</a>");
            String empIdStr = request.getParameter("id");
            String name = request.getParameter("fullname");
            String addr = request.getParameter("address");
            String gender = request.getParameter("gender");
            String birthday = request.getParameter("birthday");
            String department = request.getParameter("department");
            String salaryStr = request.getParameter("salary");
            String email = request.getParameter("email");
            String pwd = request.getParameter("pwd");
            String idSuppervisorStr = request.getParameter("idSuppervisor");
            String dateStart = request.getParameter("dateStart");
            out.println("<p> EmployeeId : " + empIdStr + "</p>");
            out.println("<br/><p> Fullname : " + name + "</p>");
            out.println("<br/><p> Address : " + empIdStr + "</p>");
            out.println("<br/><p> Gender : " + gender + "</p>");
            out.println("<br/><p> Birthday : " + birthday + "</p>");
            out.println("<br/><p> Department : " + department + "</p>");
            out.println("<br/><p> Salary : " + salaryStr + "</p>");
            out.println("<br/><p> Email " + email + "</p>");
            out.println("<br/><p> Password : " + pwd + "</p>");
            out.println("<br/><p> Leader ID  " + idSuppervisorStr + "</p>");
            out.println("<br/><p> Datestart : " + dateStart + "</p>");
            out.println("</div>");
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
        try {
            processRequest(request, response);
        } catch (Exception ex) {
            Logger.getLogger(Servlet3.class.getName()).log(Level.SEVERE, null, ex);
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
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            processRequest(request, response);
        } catch (Exception ex) {
            Logger.getLogger(Servlet3.class.getName()).log(Level.SEVERE, null, ex);
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

    public int checkDepValue(ArrayList<Department> depList, String depName) {
        for (int i = 0; i < depList.size(); i++) {
            if (depList.get(i).getDepName().equalsIgnoreCase(depName)) {
                return i;
            }
        }
        return -1;
    }

    public int checkEmail(ArrayList<String> EList, String email) {
        for (int i = 0; i < EList.size(); i++) {
            if (EList.get(i).equalsIgnoreCase(email)) {
                return i;
            }
        }
        return -1;
    }

}
