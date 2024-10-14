package DAO;

import dto.Department;
import dto.Employee;
import constrants.Gender;
import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import myLib.DBUtils;
import myLib.ValidateInput;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author hoanghamhoc
 */
public class EmployeeDAO {

    public static Employee getEmployee(String email, String pwd) throws Exception {
        Employee employee = null;
        Connection cn = DBUtils.makeConnection();
        if (cn != null) {
            String sql = "select empSSN, empName, empAddress, empSalary, empSex, empBirthdate, \n"
                    + "depNum, supervisorSSN, Email, Password, empStartdate from tblEmployee \n"
                    + "where Email = ? and Password = ?";
            PreparedStatement pst = cn.prepareCall(sql);
            pst.setString(1, email);
            pst.setString(2, pwd);
            ResultSet rs = pst.executeQuery();
            if (rs != null && rs.next()) {
                BigDecimal empSSN = rs.getBigDecimal("empSSN");
                String fullname = rs.getString("empName");
                String address = rs.getString("empAddress");
                double salary = rs.getDouble("empSalary");
                Gender empSex = ValidateInput.mapStringToGender(rs.getString("empSex"));
                Date empBirthdate = rs.getDate("empBirthdate");
                int depNum = rs.getInt("depNum");
                Department dep = null;
                String sqlDep = "select depNum,depName from tblDepartment where depNum = ?";
                PreparedStatement pstDep = cn.prepareCall(sqlDep);
                pstDep.setInt(1, depNum);
                ResultSet rsDep = pstDep.executeQuery();
                if (rsDep != null && rsDep.next()) {
                    String depName = rsDep.getString("depName");
                    dep = new Department(depNum, depName);
                }
                BigDecimal supervisorSSN = rs.getBigDecimal("supervisorSSN");
                String Email = rs.getString("Email");
                String password = rs.getString("Password");
                Date empStartDate = rs.getDate("empStartdate");
                employee = new Employee(empSSN, fullname, salary, address, empSex, empBirthdate, dep, supervisorSSN, Email, password, empStartDate);
            }
            cn.close();
        }
        return employee;
    }

    public static int updateEmployee(Employee employee) throws Exception {
        //empSSN(const), Salary(do quản lý tăng), depNum(do quản lý thay đổi)
        //supervisorId(do quản lý thay đổi) , StartDate(const)
        //make connection with db
        int check = 0;
        Connection cn = DBUtils.makeConnection();
        if (cn != null) {
            String sql = "UPDATE tblEmployee SET "
                    + "empName =  ? ,"
                    + "empAddress =  ? ,"
                    + "empSex = ?, "
                    + "empBirthdate = ? , "
                    + "Email = ? , "
                    + "Password = ? "
                    + "WHERE empSSN = ?";

            PreparedStatement pst = cn.prepareStatement(sql);

            pst.setString(1, employee.getFullname());
            pst.setString(2, employee.getAddress());
            pst.setString(3, employee.getEmpSex().getLabel());
            pst.setDate(4, employee.getBirthday());
            pst.setString(5, employee.getEmail());
            pst.setString(6, employee.getPassword());
            pst.setBigDecimal(7, employee.getEmpSSN());
            check = pst.executeUpdate();

        }
        return check;
    }

    public static ArrayList<String> getListEmail(String email) throws Exception {
        ArrayList<String> listEmailEmployee = new ArrayList<>();
        Connection cn = DBUtils.makeConnection();
        if (cn != null) {
            String sql = "select Email from tblEmployee where Email is not null and Email <> ?";
            PreparedStatement pst = cn.prepareCall(sql);//câu query đơn giản dùng statement
            pst.setString(1, email);
            ResultSet rs = pst.executeQuery();//lấy dữ liệu từ database lên
            if (rs != null) {
                while (rs.next()) {
                    String newEmail = rs.getString("Email");
                    listEmailEmployee.add(newEmail);
                }
            }
            cn.close();
        }
        return listEmailEmployee;
    }

    public static Employee getSupervisorEmp(BigDecimal supervisorId) throws Exception {
        Employee employee = null;

        Connection cn = DBUtils.makeConnection();
        if (cn != null) {
            String sql = "SELECT empSSN ,empName\n"
                    + "FROM tblEmployee \n"
                    + "     WHERE empSSN in ( select supervisorSSN \n"
                    + "			from tblEmployee \n"
                    + "			WHERE supervisorSSN IS NOT NULL "
                    + "                 and supervisorSSN = ? )";
            PreparedStatement pst = cn.prepareCall(sql);
            pst.setBigDecimal(1, supervisorId);
            ResultSet rs = pst.executeQuery();
            if (rs != null && rs.next()) {
                BigDecimal empSSN = rs.getBigDecimal("empSSN");
                String empName = rs.getNString("empName");
                employee = new Employee(empSSN, empName);
            }
            cn.close();
        }
        return employee;
    }
}
