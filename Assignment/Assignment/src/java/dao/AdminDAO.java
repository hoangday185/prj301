/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import constraints.Gender;
import dto.Account;
import dto.Admin;
import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.Statement;
import utils.Convert;
import utils.DBConnection;

/**
 *
 * @author hoanghamhoc
 */
public class AdminDAO {

    public static Admin getAdmin(Account account) throws Exception {
        Admin admin = null;
        Connection cn = DBConnection.makeConnection();
        if (cn != null) {
            String sql = "select  AdminID, AdminName, address, \n"
                    + "	   gender,birthday, salary, phone,dateStart \n"
                    + "	   from Admin where accountId = " + account.getAccountID();
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(sql);
            if (rs != null && rs.next()) {
                BigDecimal adminID = rs.getBigDecimal("AdminID");
                String adminName = rs.getString("AdminName");
                String address = rs.getString("address");
                Gender gender = Convert.mapIntToGender(rs.getInt("gender"));
                Date birthday = rs.getDate("birthday");
                double salary = rs.getDouble("salary");
                String phone = rs.getString("phone");
                Date dateStart = rs.getDate("dateStart");
                admin = new Admin(adminID, adminName, address, gender, birthday, phone, salary, dateStart, account);
            }
            cn.close();
        }
        return admin;
    }
}
