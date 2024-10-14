/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import DAO.EmployeeDAO;
import dto.Employee;
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
public class Login extends HttpServlet {

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
            out.println("<title>Servlet login</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet login at " + request.getContextPath() + "</h1>");
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
        try {
            String email = request.getParameter("email");
            String pwd = request.getParameter("pwd");
            Employee employee = EmployeeDAO.getEmployee(email, pwd);
            if (employee != null) {
                HttpSession session = request.getSession();
                session.setAttribute("employee", employee);
                session.setAttribute("msg", "Welcome " + employee.getFullname());
                request.getRequestDispatcher("userPage.jsp").forward(request, response);
                //log out thì xóa hầu hết các biến trên session
            } else {
                request.setAttribute("msg", "Tài khoản hoặc mật khẩu không đúng");
                request.setAttribute("email", email);
                request.setAttribute("pwd", pwd);
                request.getRequestDispatcher("login.jsp").forward(request, response);
            }
        } catch (Exception e) {
            e.printStackTrace();
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

/*
use WS1
select * from tblEmployee
select * from tblDependent
select * from tblProject
select * from
(select p.proNum, p.proName, e.empSSN, p.depNum from tblEmployee e left join tblProject p
                    on  p.depNum = e.depNum) as v
where v.empSSN = 30121050336

select * from tblProject
		where depNum in (select depNum from tblEmployee
								  where empSSN = 123231231231)

UPDATE tblEmployee SET Email = 'test2@gmail.com',
                     Password = '12345' WHERE empSSN = 88888

SELECT empSSN ,empName
FROM tblEmployee
     WHERE empSSN in (select supervisorSSN
							from tblEmployee
							WHERE supervisorSSN IS NOT NULL)

 */
