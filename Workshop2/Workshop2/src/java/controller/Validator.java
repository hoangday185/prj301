/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import DAO.EmployeeDAO;
import dto.Employee;
import constrants.Gender;
import java.io.IOException;
import java.io.PrintWriter;
import java.math.BigDecimal;
import java.sql.Date;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import view.RenderHtmlUser;
import myLib.ValidateInput;

/**
 *
 * @author hoanghamhoc
 */
public class Validator extends HttpServlet {

    private final static String REGEX_NAME = "^[\\p{L} .'-]+$";
    private final static String REGEX_EMAIL = "[A-Za-z0-9+_.-]+@(.+)";
    private final static String INVALID = "invalid";
    private final static ValidateInput VI = new ValidateInput();
    private final static int MAX = 30;
    private final static int MIN = 8;
    private final static RenderHtmlUser RH = new RenderHtmlUser();

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
            String empSSNString = request.getParameter("empSSN");//nhớ ép kiểu
            BigDecimal empSSN = new BigDecimal(empSSNString);
            String name = request.getParameter("fullname");
            String address = request.getParameter("address");
            String gender = request.getParameter("gender");
            Date birthday = Date.valueOf(request.getParameter("birthday"));
            String email = request.getParameter("email");
            String pwd = request.getParameter("pwd");
            String confirmPwd = request.getParameter("confirm-pwd");
            //check và gán giá trị cho biến html
            //nếu lỗi thì show lỗi luôn
            //còn nếu ko lỗi vẫn gán giá trị bth
            //sau khi gán hết tất cả các biến thì ta sẽ check lại
            //nếu tất cả các hàm validate đều rỗng thì sẽ update  luôn và chuyển về page chính
            //còn ko thì hiển thị lỗi ra userPage

            //**Check biến và gán
            String htmlName = RH.renderNodeName(name, REGEX_NAME);//name
            boolean flagName = VI.checkInvalid(htmlName, INVALID);

            String htmlAddress = RH.renderNodeAddress(address);//adress
            boolean flagAddress = VI.checkInvalid(htmlAddress, INVALID);

            String htmlGender = RH.renderNodeGender(gender);//gender
            gender = gender.equalsIgnoreCase("MALE") ? "M" : "F";
            Gender empSex = VI.mapStringToGender(gender);

            String htmlBirthday = RH.renderNodeBirthday(birthday);//birthday

            ArrayList<String> listEmail = EmployeeDAO.getListEmail(email);
            String htmlEmail = RH.renderNodeEmail(listEmail, email, REGEX_EMAIL); //Email
            boolean flagEmail = VI.checkInvalid(htmlEmail, INVALID);

            String htmlPwd = RH.renderNodePwd(pwd, MIN, MAX);//password
            boolean flagPwd = VI.checkInvalid(htmlPwd, INVALID);

            String htmlConfirmPwd = RH.renderNodeConfirmPwd(pwd, confirmPwd, MIN, MAX);//confirm-pwd
            boolean flagConfirmPwd = VI.checkInvalid(htmlConfirmPwd, INVALID);

            String htmlError = "";
            if (!flagName && !flagAddress && !flagEmail && !flagPwd && !flagConfirmPwd) {
                Employee updateEmployee = new Employee(empSSN, name, address, empSex, birthday, email, pwd);
                request.setAttribute("updateEmployee", updateEmployee);
                request.getRequestDispatcher("UpdateProfile").forward(request, response);
            } else {
                htmlError = "<form action=\"Validator\" method=\"post\">\n"
                        + "        <input type=\"hidden\" name = \"empSSN\" value=\"" + empSSN + "\" />\n"
                        + htmlName + htmlAddress + htmlGender + htmlBirthday + htmlEmail + htmlPwd + htmlConfirmPwd
                        + "      <button class=\"btn btn-primary\">Save</button>\n"
                        + "    </form>";
                request.setAttribute("htmlError", htmlError);
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

//------------------------------------------------------------------------------------------------------------------
/*
String htmlName = "";//name
            boolean flagName = false;
            if (!validateInp.validateName(name, REGEX_NAME).isEmpty()) {
                flagName = true;
                htmlName = "<div class=\"mb-3\">\n"
                        + "        <label for=\"fullname\" class=\"form-label\">Full name</label>\n"
                        + "        <input\n"
                        + "          type=\"text\"\n"
                        + "          name=\"fullname\"\n"
                        + "          id=\"fullname\"\n"
                        + "          class=\"form-control is-invalid\"\n"
                        + "          value=\"" + name + "\" />\n"
                        + "        <div class=\"invalid-feedback\">" + validateInp.validateName(name, REGEX_NAME) + "</div>\n"
                        + "      </div>";
            } else {
                htmlName = "<div class=\"mb-3\">\n"
                        + "        <label for=\"fullname\" class=\"form-label\">Full name</label>\n"
                        + "        <input\n"
                        + "          type=\"text\"\n"
                        + "          name=\"fullname\"\n"
                        + "          id=\"fullname\"\n"
                        + "          class=\"form-control\"\n"
                        + "          value=\"" + name + "\" />\n"
                        + "      </div>";
            }

            String htmlAddress = "";//adress
            boolean flagAddress = false;
            if (!validateInp.validateAddress(address).isEmpty()) {
                flagAddress = true;
                htmlAddress = "<div class=\"mb-3\">\n"
                        + "        <label for=\"address\" class=\"form-label\">Address</label>\n"
                        + "        <input\n"
                        + "          type=\"text\"\n"
                        + "          name=\"address\"\n"
                        + "          id=\"address\"\n"
                        + "          class=\"form-control is-invalid\"\n"
                        + "          value=\"" + address + "\" />\n"
                        + "        <div class=\"invalid-feedback\">" + validateInp.validateAddress(address) + "</div>\n"
                        + "      </div>";
            } else {
                htmlAddress = "<div class=\"mb-3\">\n"
                        + "        <label for=\"address\" class=\"form-label\">Address</label>\n"
                        + "        <input\n"
                        + "          type=\"text\"\n"
                        + "          name=\"address\"\n"
                        + "          id=\"address\"\n"
                        + "          class=\"form-control\"\n"
                        + "          value=\"" + address + "\" />\n"
                        + "      </div>";
            }

            String htmlGender = "";//gender
            if (gender.equalsIgnoreCase("MALE")) {
                htmlGender = "<div class=\"mb-3\">\n"
                        + "                    <label for=\"gender\" class=\"form-label\">Gender</label>\n"
                        + "                    <div class=\"form-check\">\n"
                        + "                        <input\n"
                        + "                            type=\"radio\"\n"
                        + "                            id=\"male\"\n"
                        + "                            name=\"gender\"\n"
                        + "                            class=\"form-check-input\"\n"
                        + "                            value=\"MALE\"\n"
                        + "                            checked />\n"
                        + "                        <label for=\"male\" class=\"form-label\">Male</label>\n"
                        + "                    </div>\n"
                        + "                    <div class=\"form-check\">\n"
                        + "                        <input\n"
                        + "                            type=\"radio\"\n"
                        + "                            id=\"female\"\n"
                        + "                            name=\"gender\"\n"
                        + "                            class=\"form-check-input\"\n"
                        + "                            value=\"FEMALE\" />\n"
                        + "                        <label for=\"male\" class=\"form-label\">Female</label>\n"
                        + "                    </div>\n"
                        + "                </div>";
            } else {
                htmlGender = "<div class=\"mb-3\">\n"
                        + "                    <label for=\"gender\" class=\"form-label\">Gender</label>\n"
                        + "                    <div class=\"form-check\">\n"
                        + "                        <input\n"
                        + "                            type=\"radio\"\n"
                        + "                            id=\"male\"\n"
                        + "                            name=\"gender\"\n"
                        + "                            class=\"form-check-input\"\n"
                        + "                            value=\"male\"\n"
                        + "                             />\n"
                        + "                        <label for=\"male\" class=\"form-label\">Male</label>\n"
                        + "                    </div>\n"
                        + "                    <div class=\"form-check\">\n"
                        + "                        <input\n"
                        + "                            type=\"radio\"\n"
                        + "                            id=\"female\"\n"
                        + "                            name=\"gender\"\n"
                        + "                            class=\"form-check-input\"\n"
                        + "                            value=\"female\" checked />\n"
                        + "                        <label for=\"male\" class=\"form-label\">Female</label>\n"
                        + "                    </div>\n"
                        + "                </div>";
            }

            String htmlBirthday = "<div class=\"mb-3\">\n"
                    + "                    <label for=\"birthday\" class=\"form-label\">Birthday</label>\n"
                    + "                    <input type=\"date\" id=\"birthday\" name=\"birthday\" class=\"form-control\""
                    + "                     value =\"" + birthday + "\" />\n"
                    + "                </div>";//birthday

            ArrayList<String> listEmail = EmployeeDAO.getListEmail(email);
            String htmlEmail = ""; //Email
            boolean flagEmail = false;
            if (!validateInp.validateEmail(listEmail, email, REGEX_EMAIL).isEmpty()) {
                flagEmail = true;
                htmlEmail = "<div class=\"mb-3\">\n"
                        + "                    <label for=\"email\" class=\"form-label\">Email</label>\n"
                        + "                    <input type=\"text\" id=\"email\" name=\"email\" class=\"form-control is-invalid\" value =\"" + email + "\" />\n"
                        + "                   <div class=\"invalid-feedback\">" + validateInp.validateEmail(listEmail, email, REGEX_EMAIL) + "</div>"
                        + "                </div>";
            } else {
                htmlEmail = "<div class=\"mb-3\">\n"
                        + "                    <label for=\"email\" class=\"form-label\">Email</label>\n"
                        + "                    <input type=\"text\" id=\"email\" name=\"email\" class=\"form-control\" value =\"" + email + "\" />\n"
                        + "                </div>";
            }

            String htmlPwd = "";//password
            boolean flagPwd = false;
            if (!validateInp.validatePwd(pwd, MIN, MAX).isEmpty()) {
                flagEmail = true;
                htmlPwd = "<div class=\"mb-3\">\n"
                        + "        <label for=\"pwd\" class=\"form-label\">Password</label>\n"
                        + "        <input type=\"password\" id=\"pwd\" name=\"pwd\" class=\"form-control is-invalid\" value = \"" + pwd + "\"/>\n"
                        + "        <div class=\"invalid-feedback\">" + validateInp.validatePwd(pwd, MIN, MAX) + "</div>"
                        + "      </div>\n";
            } else {
                htmlPwd = "<div class=\"mb-3\">\n"
                        + "        <label for=\"pwd\" class=\"form-label\">Password</label>\n"
                        + "        <input type=\"password\" id=\"pwd\" name=\"pwd\" class=\"form-control\" value = \"" + pwd + "\"/>\n"
                        + "      </div>\n";
            }

            String htmlConfirmPwd = "";//confirm-pwd
            boolean flagConfirmPwd = false;
            if (!validateInp.validateConfirmPwd(pwd, confirmPwd, MIN, MAX).isEmpty()) {
                flagConfirmPwd = true;
                htmlConfirmPwd = "<div class=\"mb-3\">\n"
                        + "        <label for=\"confirm-pwd\" class=\"form-label\">Confirm Password</label>\n"
                        + "        <input\n"
                        + "          type=\"password\"\n"
                        + "          id=\"confirm-pwd\"\n"
                        + "          name=\"confirm-pwd\"\n"
                        + "          class=\"form-control is-invalid\" value = \"" + confirmPwd + "\"/>\n"
                        + "        <div class=\"invalid-feedback\">" + validateInp.validateConfirmPwd(pwd, confirmPwd, MIN, MAX) + "</div>"
                        + "      </div>";
            } else {
                htmlConfirmPwd = "<div class=\"mb-3\">\n"
                        + "        <label for=\"confirm-pwd\" class=\"form-label\">Confirm Password</label>\n"
                        + "        <input\n"
                        + "          type=\"password\"\n"
                        + "          id=\"confirm-pwd\"\n"
                        + "          name=\"confirm-pwd\"\n"
                        + "          class=\"form-control\" value = \"" + confirmPwd + "\"/>\n"
                        + "      </div>";
            }
 */
