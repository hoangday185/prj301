/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import dao.DepartmentDAO;
import dao.EmployeeDAO;
import dto.Department;
import dto.Employee;
import java.math.BigDecimal;
import java.sql.Date;
import java.util.ArrayList;
import tool.ValidateInput;

/**
 *
 * @author hoanghamhoc
 */
public class RenderHtml {

    //class để đưa các hàm tạo ra các html để cho code gọn
    private static ValidateInput vi = new ValidateInput();

    //quăng html khi mới vào form
    public static String renderFrom() throws Exception {
        String html = "<form action=\"ValidatorServlet\" method=\"post\">\n"
                + "                <div class=\"mb-3\">\n"
                + "                    <label for=\"id-employee\" class=\"form-label\">Id employee</label>\n"
                + "                    <input type=\"text\" name=\"id\" id=\"id-employee\" class=\"form-control\"  required/>\n"
                + "                </div>\n"
                + "                <div class=\"mb-3\">\n"
                + "                    <label for=\"fullname\" class=\"form-label\">Full name</label>\n"
                + "                    <input type=\"text\" name=\"fullname\" id=\"fullname\" class=\"form-control\"  required/>\n"
                + "                </div>\n"
                + "                <div class=\"mb-3\">\n"
                + "                    <label for=\"address\" class=\"form-label\">Address</label>\n"
                + "                    <input type=\"text\" name=\"address\" id=\"adress\" class=\"form-control\"  required/>\n"
                + "                </div>\n"
                + "                <div class=\"mb-3\">\n"
                + "                    <label for=\"gender\" class=\"form-label\">Gender</label>\n"
                + "                    <div class=\"form-check\">\n"
                + "                        <input\n"
                + "                            type=\"radio\"\n"
                + "                            id=\"male\"\n"
                + "                            name=\"gender\"\n"
                + "                            class=\"form-check-input\"\n"
                + "                            value=\"male\"\n"
                + "                            checked />\n"
                + "                        <label for=\"male\" class=\"form-label\">Male</label>\n"
                + "                    </div>\n"
                + "                    <div class=\"form-check\">\n"
                + "                        <input\n"
                + "                            type=\"radio\"\n"
                + "                            id=\"female\"\n"
                + "                            name=\"gender\"\n"
                + "                            class=\"form-check-input\"\n"
                + "                            value=\"female\" />\n"
                + "                        <label for=\"male\" class=\"form-label\">Female</label>\n"
                + "                    </div>\n"
                + "                </div>\n"
                + "                <div class=\"mb-3\">\n"
                + "                    <label for=\"birthday\" class=\"form-label\">Birthday</label>\n"
                + "                    <input type=\"date\" id=\"birthday\" name=\"birthday\" class=\"form-control\" required />\n"
                + "                </div>\n"
                + renderHtmlDepartment()
                + "                <div class=\"mb-3\">\n"
                + "                    <label for=\"basic-salary\" class=\"form-label\">Basic salary</label>\n"
                + "                    <input\n"
                + "                        type=\"number\"\n"
                + "                        name=\"salary\"\n"
                + "                        id=\"basic-salary\"\n"
                + "                        class=\"form-control\" required/>\n"
                + "                </div>\n"
                + "                <div class=\"mb-3\">\n"
                + "                    <label for=\"email\" class=\"form-label\">Email</label>\n"
                + "                    <input type=\"text\" id=\"email\" name=\"email\" class=\"form-control\" required/>\n"
                + "                </div>\n"
                + "                <div class=\"mb-3\">\n"
                + "                    <label for=\"pwd\" class=\"form-label\">Password</label>\n"
                + "                    <input type=\"password\" id=\"pwd\" name=\"pwd\" class=\"form-control\" required/>\n"
                + "                </div>\n"
                + "                <div class=\"mb-3\">\n"
                + "                    <label for=\"confirm-pwd\" class=\"form-label\">Confirm Password</label>\n"
                + "                    <input type=\"password\" id=\"pwd\" name=\"confirm-pwd\" class=\"form-control\" required/>\n"
                + "                </div>\n"
                + renderHtmlListIdSuperVisor()
                + "                <div class=\"mb-3\">\n"
                + "                    <label for=\"date-start\" class=\"form-label\">Date start</label>\n"
                + "                    <input\n"
                + "                        type=\"date\"\n"
                + "                        id=\"date-start\"\n"
                + "                        name=\"dateStart\"\n"
                + "                        class=\"form-control\" required/>\n"
                + "                </div>\n"
                + "                <button class=\"btn btn-primary\" type=\"submit\">Preview</button>\n"
                + "            </form>";
        return html;
    }

    //getdata form db and render list deparment
    public static String renderHtmlDepartment() throws Exception {
        ArrayList<Department> listDepartment = DepartmentDAO.getDepartment();
        String htmlDepartment = "";
        for (Department department : listDepartment) {
            htmlDepartment += "  <option value=\"" + department.getDepID() + "\">\n"
                    + department.getDepName()
                    + "                        </option>";
        }
        return "<div class=\"mb-3\">\n"
                + "<label for=\"department\" class=\"form-label\">Department</label>\n"
                + "<select name=\"department\" id=\"department\" class=\"form-select\">\n"
                + htmlDepartment
                + "</select>\n"
                + "</div>";
    }

    //getdata form db and render list id supervisor
    public static String renderHtmlListIdSuperVisor() throws Exception {
        ArrayList<Employee> listSupervisor = EmployeeDAO.getListSupervisor();
        String htmlIdSupervisor = " <option value=\"none\">None</option>";
        for (Employee employee : listSupervisor) {
            htmlIdSupervisor += "  <option value=\"" + employee.getEmpId() + "\">\n"
                    + employee.getName()
                    + "                        </option>";
        }
        return "<div class=\"mb-3\">\n"
                + "      <label for=\"idSupervisor\" class=\"form-label\">Id Supervisor</label>\n"
                + "      <select\n"
                + "        name=\"idSupervisor\"\n"
                + "        id=\"idSupervisor\"\n"
                + "        class=\"form-select\">"
                + htmlIdSupervisor
                + "        </select>\n"
                + "    </div>";
    }

    //renderhtml Error
    public static String renderNodeEmpSSN(String empSSN, ArrayList<BigDecimal> listEmpSSN) throws Exception {
        String isError = vi.validateEmpSSN(empSSN, listEmpSSN);
        if (!isError.isEmpty()) {
            return "                <div class=\"mb-3\">\n"
                    + "                    <label for=\"id-employee\" class=\"form-label\">Id employee</label>\n"
                    + "                    <input type=\"text\" name=\"id\" id=\"id-employee\" class=\"form-control is-invalid\" value=\"" + empSSN + "\" required/>\n"
                    + "        <div class=\"invalid-feedback\">" + isError + "</div>\n"
                    + "                </div>\n";
        }
        return "                <div class=\"mb-3\">\n"
                + "                    <label for=\"id-employee\" class=\"form-label\">Id employee</label>\n"
                + "                    <input type=\"text\" name=\"id\" id=\"id-employee\" class=\"form-control\" value=\"" + empSSN + "\" required/>\n"
                + "                </div>\n";
    }

    //hàm này dùng cho name, address, email,
    public static String renderNodeName(String name, String regex) {
        String isError = vi.validateName(name, regex);
        if (!isError.isEmpty()) {
            return "<div class=\"mb-3\">\n"
                    + "        <label for=\"fullname\" class=\"form-label\">Full name</label>\n"
                    + "        <input\n"
                    + "          type=\"text\"\n"
                    + "          name=\"fullname\"\n"
                    + "          id=\"fullname\"\n"
                    + "          class=\"form-control is-invalid\"\n"
                    + "          value=\"" + name + "\" required/>\n"
                    + "        <div class=\"invalid-feedback\">" + isError + "</div>\n"
                    + "      </div>";
        }
        return "<div class=\"mb-3\">\n"
                + "        <label for=\"fullname\" class=\"form-label\">Full name</label>\n"
                + "        <input\n"
                + "          type=\"text\"\n"
                + "          name=\"fullname\"\n"
                + "          id=\"fullname\"\n"
                + "          class=\"form-control\" required\n"
                + "          value=\"" + name + "\" />\n"
                + "      </div>";

    }

    public static String renderNodeValue(String value, String nameValue) {
        return "<div class=\"mb-3\">\n"
                + "        <label for=\"address\" class=\"form-label\">" + nameValue + "</label>\n"
                + "        <input\n"
                + "          type=\"text\"\n"
                + "          name=\"" + nameValue + "\"\n"
                + "          id=\"" + nameValue + "\"\n"
                + "          class=\"form-control\"\n"
                + "          value=\"" + value + "\" required/>\n"
                + "      </div>";
    }

    public static String renderNodeGender(String gender) {
        if (gender.equalsIgnoreCase("MALE")) {
            return "<div class=\"mb-3\">\n"
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
        }
        return "<div class=\"mb-3\">\n"
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

    //check email
    public static String renderNodeEmail(ArrayList<String> listEmail, String email, String regex) {
        String isError = vi.validateEmail(listEmail, email, regex);
        if (!isError.isEmpty()) {
            return "<div class=\"mb-3\">\n"
                    + "                    <label for=\"email\" class=\"form-label\">Email</label>\n"
                    + "                    <input type=\"text\" id=\"email\" name=\"email\" class=\"form-control is-invalid\" value =\"" + email + "\" required/>\n"
                    + "                   <div class=\"invalid-feedback\">" + isError + "</div>"
                    + "                </div>";
        }
        return "<div class=\"mb-3\">\n"
                + "                    <label for=\"email\" class=\"form-label\">Email</label>\n"
                + "                    <input type=\"text\" id=\"email\" name=\"email\" class=\"form-control\" value =\"" + email + "\" required/>\n"
                + "                </div>";
    }

    public static String renderNodePwd(String pwd, int min, int max) {
        String isError = vi.validatePwd(pwd, min, max);
        if (!isError.isEmpty()) {
            return "<div class=\"mb-3\">\n"
                    + "        <label for=\"pwd\" class=\"form-label\">Password</label>\n"
                    + "        <input type=\"password\" id=\"pwd\" name=\"pwd\" class=\"form-control is-invalid\"required value = \"" + pwd + "\"/>\n"
                    + "        <div class=\"invalid-feedback\">" + isError + "</div>"
                    + "      </div>\n";
        }
        return "<div class=\"mb-3\">\n"
                + "        <label for=\"pwd\" class=\"form-label\">Password</label>\n"
                + "        <input type=\"password\" id=\"pwd\" name=\"pwd\" class=\"form-control\" value = \"" + pwd + "\" required/>\n"
                + "      </div>\n";
    }

    public static String renderNodeConfirmPwd(String pwd, String confirmPwd, int min, int max) {
        String isError = vi.validateConfirmPwd(pwd, confirmPwd, min, max);
        if (!isError.isEmpty()) {
            return "<div class=\"mb-3\">\n"
                    + "        <label for=\"confirm-pwd\" class=\"form-label\">Confirm Password</label>\n"
                    + "        <input\n"
                    + "          type=\"password\"\n"
                    + "          id=\"confirm-pwd\"\n"
                    + "          name=\"confirm-pwd\"\n"
                    + "          class=\"form-control is-invalid\" value = \"" + confirmPwd + "\" required/>\n"
                    + "        <div class=\"invalid-feedback\">" + isError + "</div>"
                    + "      </div>";
        }
        return "<div class=\"mb-3\">\n"
                + "        <label for=\"confirm-pwd\" class=\"form-label\">Confirm Password</label>\n"
                + "        <input\n"
                + "          type=\"password\"\n"
                + "          id=\"confirm-pwd\"\n"
                + "          name=\"confirm-pwd\"\n"
                + "          class=\"form-control\" value = \"" + confirmPwd + "\" required/>\n"
                + "      </div>";
    }

    public static String renderNodeDate(String date, String nameDate) {
        return "                <div class=\"mb-3\">\n"
                + "                    <label for=\"" + nameDate + "\" class=\"form-label\">" + nameDate + "</label>\n"
                + "                    <input type=\"date\" id=\"" + nameDate + "\" name=\"" + nameDate + "\" class=\"form-control\" value=\"" + date + "\" required/>\n"
                + "                </div>\n";

    }
}
