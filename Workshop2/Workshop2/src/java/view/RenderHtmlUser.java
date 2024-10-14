package view;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import dto.Employee;
import dto.Project;
import java.sql.Date;
import java.util.ArrayList;
import myLib.ValidateInput;

/**
 *
 * @author hoanghamhoc
 */
public class RenderHtmlUser {

    //class để đưa các hàm tạo ra các html để cho code gọn
    private static ValidateInput vi = new ValidateInput();

    //render view ở đây
    // 3 cái render là Gender, Deparment, Tên của supervisorEmp
    public static String renderViewGender(Employee employee) {
        if ("M".equalsIgnoreCase(employee.getEmpSex().getLabel())) {
            return "<div class=\"mb-3\">\n"
                    + "      <label for=\"gender\" class=\"form-label\">Gender</label>\n"
                    + "        <input\n"
                    + "          type=\"text\"\n"
                    + "          id=\"male\"\n"
                    + "          name=\"gender\"\n"
                    + "          class=\"form-control\"\n"
                    + "          value=\"MALE\"\n"
                    + "          readonly />"
                    + "</div>";
        } else if ("F".equalsIgnoreCase(employee.getEmpSex().getLabel())) {
            return "<div class=\"mb-3\">"
                    + "      <label for=\"gender\" class=\"form-label\">Gender</label>\n"
                    + "<input\n"
                    + "          type=\"text\"\n"
                    + "          id=\"female\"\n"
                    + "          name=\"gender\"\n"
                    + "          class=\"form-control\"\n"
                    + "          value=\"FEMALE\"\n"
                    + "          readonly />\n"
                    + "      </div>";
        }
        return "<div class=\"mb-3\">"
                + "      <label for=\"gender\" class=\"form-label\">Gender</label>\n"
                + "<input\n"
                + "          type=\"text\"\n"
                + "          id=\"none\"\n"
                + "          name=\"gender\"\n"
                + "          class=\"form-control\"\n"
                + "          value=\"none\"\n"
                + "          readonly />\n"
                + "      </div>";

    }

    public static String renderViewDepartment(Employee employee) {
        if (employee.getDep() == null) {
            return "<div class=\"mb-3\">\n"
                    + "      <label for=\"department\" class=\"form-label\">Department</label>\n"
                    + "      <input type=\"text\" readonly class=\"form-control\" value =\"None\"/>\n"
                    + "    </div>";
        }
        return "<div class=\"mb-3\">\n"
                + "      <label for=\"department\" class=\"form-label\">Department</label>\n"
                + "      <input type=\"text\" readonly class=\"form-control\" value =\"" + employee.getDep().getDepName() + "\"/>\n"
                + "    </div>";
    }

    public static String renderViewSupervisorEmp(Employee supervisorEmp) {
        if (supervisorEmp == null) {
            return "                <div class=\"mb-3\">\n"
                    + "                    <label for=\"suppervisor-id\" class=\"form-label\">Id suppervisor</label>\n"
                    + "                    <input\n"
                    + "                        type=\"text\"\n"
                    + "                        name=\"idSuppervisor\"\n"
                    + "                        id=\"suppervisor-id\"\n"
                    + "                        class=\"form-control\" "
                    + "value = \"None\" readonly/>\n";
        }
        return "                <div class=\"mb-3\">\n"
                + "                    <label for=\"suppervisor-id\" class=\"form-label\">Id suppervisor</label>\n"
                + "                    <input\n"
                + "                        type=\"text\"\n"
                + "                        name=\"idSuppervisor\"\n"
                + "                        id=\"suppervisor-id\"\n"
                + "                        class=\"form-control\" "
                + "value = \"" + supervisorEmp.getFullname() + "\" readonly/>\n";
    }

    public static String renderHtmlFromInformation(Employee employee, String htmlSupervisorEmp, String htmlGender, String htmlDepartment) {
        return "<form action=\"ProfileUser\" method=\"post\">\n"
                + "                <div class=\"mb-3\">\n"
                + "                    <label for=\"id-employee\" class=\"form-label\">Id employee</label>\n"
                + "                    <input type=\"text\" name=\"id\" id=\"id-employee\" class=\"form-control\" value = \"" + employee.getEmpSSN() + "\" readonly/>\n"
                + "                </div>\n"
                + "                <div class=\"mb-3\">\n"
                + "                    <label for=\"fullname\" class=\"form-label\">Full name</label>\n"
                + "                    <input type=\"text\" name=\"fullname\" id=\"fullname\" class=\"form-control\"  value = \"" + employee.getFullname() + "\" readonly/>\n"
                + "                </div>\n"
                + "                <div class=\"mb-3\">\n"
                + "                    <label for=\"address\" class=\"form-label\">Address</label>\n"
                + "                    <input type=\"text\" name=\"address\" id=\"adress\" class=\"form-control\"  value = \"" + employee.getAddress() + "\" readonly />\n"
                + "                </div>\n"
                + htmlGender
                + "                <div class=\"mb-3\">\n"
                + "                    <label for=\"birthday\" class=\"form-label\">Birthday</label>\n"
                + "                    <input type=\"text\" id=\"birthday\" name=\"birthday\" class=\"form-control\" value = \"" + employee.getBirthday() + "\" readonly/>\n"
                + "                </div>\n"
                + htmlDepartment
                + "<div class=\"mb-3\">"
                + "                    <label for=\"basic-salary\" class=\"form-label\">Basic salary</label>\n"
                + "                    <input\n"
                + "                        type=\"number\"\n"
                + "                        name=\"salary\"\n"
                + "                        id=\"basic-salary\"\n"
                + "                        class=\"form-control\" "
                + "                        value = \"" + employee.getSalary() + "\" readonly/>\n"
                + "                </div>\n"
                + "                <div class=\"mb-3\">\n"
                + "                    <label for=\"email\" class=\"form-label\">Email</label>\n"
                + "                    <input type=\"text\" id=\"email\" name=\"email\" class=\"form-control\" value = \"" + employee.getEmail() + "\" readonly/>\n"
                + "                </div>\n"
                + "                <div class=\"mb-3\">\n"
                + "                    <label for=\"pwd\" class=\"form-label\">Password</label>\n"
                + "                    <input type=\"password\" id=\"pwd\" name=\"pwd\" class=\"form-control\" value = \"" + employee.getPassword() + "\" readonly />\n"
                + "                </div>\n"
                + htmlSupervisorEmp
                + "                </div>\n"
                + "                <div class=\"mb-3\">\n"
                + "                    <label for=\"date-start\" class=\"form-label\">Date start</label>\n"
                + "                    <input\n"
                + "                        type=\"text\"\n"
                + "                        id=\"date-start\"\n"
                + "                        name=\"dateStart\"\n"
                + "                        class=\"form-control\" "
                + "value = \"" + employee.getEmpStartDate() + "\" readonly/>\n"
                + "                </div>\n"
                + "                <button class=\"btn btn-primary\" name = \"type\" value =\"update\" type=\"submit\">Update profile</button>\n"
                + "            </form>";
    }

    //==============================================================================================================================
    //phần này sẽ dùng để check lỗi và update
    //hàm này dùng cho name, address, email,
    public static String renderViewUpdateEmp(String htmlGender, Employee employee) {
        return "<form action=\"Validator\" method=\"post\">\n"
                + "<input type=\"hidden\" name=\"empSSN\" value=\"" + employee.getEmpSSN() + "\">\n"
                + "      <div class=\"mb-3\">\n"
                + "        <label for=\"fullname\" class=\"form-label\">Full name</label>\n"
                + "        <input type=\"text\" name=\"fullname\" id=\"fullname\" class=\"form-control\" value = \"" + employee.getFullname() + "\" />\n"
                + "      </div>\n"
                + "      <div class=\"mb-3\">\n"
                + "        <label for=\"address\" class=\"form-label\">Address</label>\n"
                + "        <input type=\"text\" name=\"address\" id=\"adress\" class=\"form-control\" value = \"" + employee.getAddress() + "\" />\n"
                + "      </div>\n"
                + htmlGender
                + "      <div class=\"mb-3\">\n"
                + "        <label for=\"birthday\" class=\"form-label\">Birthday</label>\n"
                + "        <input type=\"date\" id=\"birthday\" name=\"birthday\" class=\"form-control\" value = \"" + employee.getBirthday() + "\"/>\n"
                + "      </div>\n"
                + "      <div class=\"mb-3\">\n"
                + "        <label for=\"email\" class=\"form-label\">Email</label>\n"
                + "        <input type=\"text\" id=\"email\" name=\"email\" class=\"form-control\" value = \"" + employee.getEmail() + "\" />\n"
                + "      </div>\n"
                + "      <div class=\"mb-3\">\n"
                + "        <label for=\"pwd\" class=\"form-label\">Password</label>\n"
                + "        <input type=\"password\" id=\"pwd\" name=\"pwd\" class=\"form-control\" value = \"" + employee.getPassword() + "\"/>\n"
                + "      </div>\n"
                + "<div class=\"mb-3\">\n"
                + "        <label for=\"confirm-pwd\" class=\"form-label\">Confirm Password</label>\n"
                + "        <input\n"
                + "          type=\"password\"\n"
                + "          id=\"confirm-pwd\"\n"
                + "          name=\"confirm-pwd\"\n"
                + "          class=\"form-control\" value = \"" + employee.getPassword() + "\"/>\n"
                + "      </div>"
                + "      <button class=\"btn btn-primary\" type=\"submit\">Save</button>\n"
                + "    </form>";
    }

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
                    + "          value=\"" + name + "\" />\n"
                    + "        <div class=\"invalid-feedback\">" + isError + "</div>\n"
                    + "      </div>";
        }
        return "<div class=\"mb-3\">\n"
                + "        <label for=\"fullname\" class=\"form-label\">Full name</label>\n"
                + "        <input\n"
                + "          type=\"text\"\n"
                + "          name=\"fullname\"\n"
                + "          id=\"fullname\"\n"
                + "          class=\"form-control\"\n"
                + "          value=\"" + name + "\" />\n"
                + "      </div>";

    }

    public static String renderNodeAddress(String address) {
        String isError = vi.validateAddress(address);
        if (!isError.isEmpty()) {
            return "<div class=\"mb-3\">\n"
                    + "        <label for=\"address\" class=\"form-label\">Address</label>\n"
                    + "        <input\n"
                    + "          type=\"text\"\n"
                    + "          name=\"address\"\n"
                    + "          id=\"address\"\n"
                    + "          class=\"form-control is-invalid\"\n"
                    + "          value=\"" + address + "\" />\n"
                    + "        <div class=\"invalid-feedback\">" + isError + "</div>\n"
                    + "      </div>";
        }
        return "<div class=\"mb-3\">\n"
                + "        <label for=\"address\" class=\"form-label\">Address</label>\n"
                + "        <input\n"
                + "          type=\"text\"\n"
                + "          name=\"address\"\n"
                + "          id=\"address\"\n"
                + "          class=\"form-control\"\n"
                + "          value=\"" + address + "\" />\n"
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

    public static String renderNodeBirthday(Date birthday) {
        return "<div class=\"mb-3\">\n"
                + "                    <label for=\"birthday\" class=\"form-label\">Birthday</label>\n"
                + "                    <input type=\"date\" id=\"birthday\" name=\"birthday\" class=\"form-control\""
                + "                     value =\"" + birthday + "\" />\n"
                + "                </div>";
    }

    public static String renderNodeEmail(ArrayList<String> listEmail, String email, String regex) {
        String isError = vi.validateEmail(listEmail, email, regex);
        if (!isError.isEmpty()) {
            return "<div class=\"mb-3\">\n"
                    + "                    <label for=\"email\" class=\"form-label\">Email</label>\n"
                    + "                    <input type=\"text\" id=\"email\" name=\"email\" class=\"form-control is-invalid\" value =\"" + email + "\" />\n"
                    + "                   <div class=\"invalid-feedback\">" + isError + "</div>"
                    + "                </div>";
        }
        return "<div class=\"mb-3\">\n"
                + "                    <label for=\"email\" class=\"form-label\">Email</label>\n"
                + "                    <input type=\"text\" id=\"email\" name=\"email\" class=\"form-control\" value =\"" + email + "\" />\n"
                + "                </div>";
    }

    public static String renderNodePwd(String pwd, int min, int max) {
        String isError = vi.validatePwd(pwd, min, max);
        if (!isError.isEmpty()) {
            return "<div class=\"mb-3\">\n"
                    + "        <label for=\"pwd\" class=\"form-label\">Password</label>\n"
                    + "        <input type=\"password\" id=\"pwd\" name=\"pwd\" class=\"form-control is-invalid\" value = \"" + pwd + "\"/>\n"
                    + "        <div class=\"invalid-feedback\">" + isError + "</div>"
                    + "      </div>\n";
        }
        return "<div class=\"mb-3\">\n"
                + "        <label for=\"pwd\" class=\"form-label\">Password</label>\n"
                + "        <input type=\"password\" id=\"pwd\" name=\"pwd\" class=\"form-control\" value = \"" + pwd + "\"/>\n"
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
                    + "          class=\"form-control is-invalid\" value = \"" + confirmPwd + "\"/>\n"
                    + "        <div class=\"invalid-feedback\">" + isError + "</div>"
                    + "      </div>";
        }
        return "<div class=\"mb-3\">\n"
                + "        <label for=\"confirm-pwd\" class=\"form-label\">Confirm Password</label>\n"
                + "        <input\n"
                + "          type=\"password\"\n"
                + "          id=\"confirm-pwd\"\n"
                + "          name=\"confirm-pwd\"\n"
                + "          class=\"form-control\" value = \"" + confirmPwd + "\"/>\n"
                + "      </div>";
    }

}
