/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import dto.Employee;
import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import myLib.DBUtils;

/**
 *
 * @author hoanghamhoc
 */
public class EmployeeDAO {

    public static int addEmployee(
            //            BigDecimal empId, String name, String address,
            //                                    double salary, String gender, String birthday,
            //                                    int depNum, BigDecimal  supervisorId,
            //                                    String email, String password,
            //                                    String startDate
            Employee e
    ) throws Exception {
        //make connection with db
        int check = 0;
        Connection cn = DBUtils.makeConnection();
        if (cn != null) {
            String sql = "INSERT INTO [dbo].[tblEmployee]\n"
                    + "           ([empSSN]\n"
                    + "           ,[empName]\n"
                    + "           ,[empAddress]\n"
                    + "           ,[empSalary]\n"
                    + "           ,[empSex]\n"
                    + "           ,[empBirthdate]\n"
                    + "           ,[depNum]\n"
                    + "           ,[supervisorSSN]\n"
                    + "           ,[Email]\n"
                    + "           ,[Password]\n"
                    + "           ,[empStartdate])\n"
                    + "     VALUES\n"
                    + "           (?,?,?,?,?,?,?,?,?,?,?)";

            PreparedStatement pst = cn.prepareStatement(sql);

            pst.setBigDecimal(1, e.getEmpId());
            pst.setNString(2, e.getName());
            pst.setNString(3, e.getAddress());
            pst.setDouble(4, e.getSalary());
            pst.setString(5, e.getSex());
            pst.setDate(6, e.getBirthdate());
            pst.setInt(7, e.getDep().getDepID());
            pst.setBigDecimal(8, e.getSupervisorId());
            pst.setString(9, e.getEmail());
            pst.setString(10, e.getPassword());
            pst.setDate(11, e.getStartdate());
            check = pst.executeUpdate();

        }
        return check;
    }

    public static ArrayList<Employee> getListSupervisor() throws Exception {
        ArrayList<Employee> list = new ArrayList<>();

        Connection cn = DBUtils.makeConnection();
        if (cn != null) {
            String sql = "SELECT empSSN ,empName\n"
                    + "FROM tblEmployee \n"
                    + "     WHERE empSSN in ( select supervisorSSN \n"
                    + "			from tblEmployee \n"
                    + "			WHERE supervisorSSN IS NOT NULL )";
            Statement pst = cn.createStatement();
            ResultSet rs = pst.executeQuery(sql);
            if (rs != null) {
                while (rs.next()) {
                    BigDecimal empSSN = rs.getBigDecimal("empSSN");
                    String empName = rs.getNString("empName");
                    Employee managerEmployee = new Employee(empSSN, empName);
                    list.add(managerEmployee);

                }
            }
            cn.close();
        }
        return list;
    }

    public static ArrayList<BigDecimal> getListEmpId() throws Exception {
        ArrayList<BigDecimal> list = new ArrayList<>();
        Connection cn = DBUtils.makeConnection();
        if (cn != null) {
            String sql = "SELECT empSSN FROM tblEmployee";
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(sql);
            if (rs != null) {
                while (rs.next()) {
                    BigDecimal emp = rs.getBigDecimal("empSSN");
                    list.add(emp);
                }
            }
            cn.close();
        }
        return list;
    }

    public static ArrayList<String> getListEmailEmployee() throws Exception {
        ArrayList<String> listEmailEmployee = new ArrayList<>();
        Connection cn = DBUtils.makeConnection();
        if (cn != null) {
            String sql = "select Email from tblEmployee where Email is not null";
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(sql);
            if (rs != null) {
                while (rs.next()) {
                    String email = rs.getString("Email");
                    listEmailEmployee.add(email);
                }
            }
            cn.close();
        }
        return listEmailEmployee;
    }
}
