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
import java.sql.Date;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import tool.ValidateInput;
import view.RenderHtml;

/**
 *
 * @author hoanghamhoc
 */
public class ValidatorServlet extends HttpServlet {

    private final static ValidateInput VI = new ValidateInput();
    private final static RenderHtml RH = new RenderHtml();
    private final static String REGEX_EMAIL = "[A-Za-z0-9+_.-]+@(.+)";
    private final static String REGEX_NAME = "^[\\p{L} .'-]+$";
    private final static int MAX = 30;
    private final static int MIN = 8;
    private final static String INVALID = "invalid";

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
            /* TODO output your page here. You may use following sample code. */
            //lấy biến từ request ra này
            String idEmloyeeStr = request.getParameter("id");
            String name = request.getParameter("fullname");
            String address = request.getParameter("address");
            String gender = request.getParameter("gender");
            String birthdayStr = request.getParameter("birthday");
            String depNumStr = request.getParameter("department");
            String salaryStr = request.getParameter("salary");
            String email = request.getParameter("email");
            String pwd = request.getParameter("pwd");
            String confirmPwd = request.getParameter("confirm-pwd");
            String idSupervisorStr = request.getParameter("idSupervisor");
            String dateStartStr = request.getParameter("dateStart");

            //id
            ArrayList<BigDecimal> listEmpSSN = EmployeeDAO.getListEmpId();
            String htmlId = RH.renderNodeEmpSSN(idEmloyeeStr, listEmpSSN);
            boolean isErrorEmpId = VI.checkInvalid(htmlId, INVALID);
            //out.println(htmlId);

            //name
            String htmlName = RH.renderNodeName(name, REGEX_NAME);
            boolean isErrorName = VI.checkInvalid(htmlName, INVALID);
            //out.println(htmlName);

            //address
            String htmlAddress = RH.renderNodeValue(address, "address");
            //out.println(htmlAddress);

            String htmlGender = RH.renderNodeGender(gender);

            //birthday
            String htmlBirthday = RH.renderNodeDate(birthdayStr, "birthday");
            //out.println(htmlBirthday);

            //department
            String htmlDepartment = RH.renderHtmlDepartment();
            //out.println(htmlDepartment);

            String htmlSalary = RH.renderNodeValue(salaryStr, "salary");
            //out.println(htmlSalary);

            ArrayList<String> listEmail = EmployeeDAO.getListEmailEmployee();
            String htmlEmail = RH.renderNodeEmail(listEmail, email, REGEX_EMAIL);
            boolean isErrorEmail = VI.checkInvalid(htmlEmail, INVALID);
            //out.println(htmlEmail);

            String htmlPwd = RH.renderNodePwd(pwd, MIN, MAX);
            boolean isErrorPwd = VI.checkInvalid(htmlPwd, INVALID);
            //out.println(htmlPwd);

            String htmlConfirmPwd = RH.renderNodeConfirmPwd(pwd, confirmPwd, MIN, MAX);
            boolean isErrorConfirmPwd = VI.checkInvalid(htmlConfirmPwd, INVALID);
            //out.println(htmlConfirmPwd);

            String htmlIdSupervisor = RH.renderHtmlListIdSuperVisor();
            //out.println(htmlIdSupervisor);

            String htmlDateStart = RH.renderNodeDate(dateStartStr, "dateStart");
            //out.println(htmlDateStart);

            //dùng các biến isError để check lỗi nếu có thì bắn ngược về
            if (!isErrorEmpId && !isErrorName && !isErrorPwd && !isErrorEmail && !isErrorConfirmPwd) {
                //nếu mọi thứ đã ổn thì ta ép kiểu để truyền xuống database
                Date birthday = Date.valueOf(birthdayStr);
                Date dateStart = Date.valueOf(dateStartStr);
                Double salary = Double.parseDouble(salaryStr);
                int depNum = Integer.parseInt(depNumStr);
                String empSex = gender.equalsIgnoreCase("MALE") ? "M" : "F";
                BigDecimal idSupervisor = idSupervisorStr.equalsIgnoreCase("None") ? null : (new BigDecimal(idSupervisorStr));
                Department dep = this.getDepartmentById(depNum);
                Employee newEmployee = new Employee(new BigDecimal(idEmloyeeStr),
                        name, address, empSex, birthday, salary, dep,
                        idSupervisor, email, pwd, dateStart);
                request.setAttribute("newEmployee", newEmployee);
                request.getRequestDispatcher("Servlet4").forward(request, response);
            } else {//ko thì bắn ra lỗi cho người dùng tự xử
                String htmlError = "<form action=\"ValidatorServlet\" method=\"post\">\n"
                        + htmlId + htmlName + htmlAddress + htmlGender + htmlBirthday + htmlDepartment + htmlSalary + htmlEmail + htmlPwd
                        + htmlConfirmPwd + htmlIdSupervisor + htmlDateStart
                        + "                <button class=\"btn btn-primary\" type=\"submit\">Preview</button>\n"
                        + "            </form>";
                request.setAttribute("htmlError", htmlError);
                request.getRequestDispatcher("Servlet5").forward(request, response);
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
            Logger.getLogger(ValidatorServlet.class.getName()).log(Level.SEVERE, null, ex);
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
            Logger.getLogger(ValidatorServlet.class.getName()).log(Level.SEVERE, null, ex);
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

    public static Department getDepartmentById(int depNum) throws Exception {
        ArrayList<Department> listDep = DepartmentDAO.getDepartment();
        for (Department department : listDep) {
            if (department.getDepID() == depNum) {
                return department;
            }
        }
        return null;
    }

}
