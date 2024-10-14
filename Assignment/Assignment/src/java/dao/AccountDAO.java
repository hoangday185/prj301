/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import constraints.Role;
import constraints.StatusAvailable;
import dto.Account;
import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import utils.Convert;
import utils.DBConnection;

/**
 *
 * @author hoanghamhoc
 */
public class AccountDAO {

    public static Account getAccount(String email, String pwd) throws Exception {
        Account account = null;
        Connection cn = DBConnection.makeConnection();
        if (cn != null) {
            String sql = "select accountID, email, password, role, status "
                    + "from Account where email = ? and password = ?";
            PreparedStatement pst = cn.prepareCall(sql);
            pst.setString(1, email);
            pst.setString(2, pwd);
            ResultSet rs = pst.executeQuery();
            if (rs != null && rs.next()) {
                BigDecimal accountId = rs.getBigDecimal("accountID");
                Role role = Convert.mapIntToRole(rs.getInt("role"));
                StatusAvailable status = Convert.mapInToStatusAvailable(rs.getInt("status"));
                account = new Account(accountId, email, pwd, role, status);
            }
            cn.close();
        }
        return account;
    }

    public static Account getAccountByAccountId(BigDecimal accountId) throws Exception {
        Account account = null;
        Connection cn = DBConnection.makeConnection();
        if (cn != null) {
            String sql = "select accountID, email, password, role "
                    + " from Account where accountID = ? ";
            PreparedStatement pst = cn.prepareCall(sql);
            pst.setBigDecimal(1, accountId);
            ResultSet rs = pst.executeQuery();
            if (rs != null && rs.next()) {
                Role role = Convert.mapIntToRole(rs.getInt("role"));
                String email = rs.getString("email");
                String pwd = rs.getString("password");
                StatusAvailable status = StatusAvailable.Available;
                account = new Account(accountId, email, pwd, role, status);
            }
            cn.close();
        }
        return account;
    }

    public static Account getAccountCusByAccountId(BigDecimal accountId) throws Exception {
        Account account = null;
        Connection cn = DBConnection.makeConnection();
        if (cn != null) {
            String sql = "select accountID, email, password, status "
                    + " from Account where accountID = ? ";
            PreparedStatement pst = cn.prepareCall(sql);
            pst.setBigDecimal(1, accountId);
            ResultSet rs = pst.executeQuery();
            if (rs != null && rs.next()) {
                Role role = Role.CUSTOMER;
                String email = rs.getString("email");
                String pwd = rs.getString("password");
                StatusAvailable status = Convert.mapInToStatusAvailable(rs.getInt("status"));
                account = new Account(accountId, email, pwd, role, status);
            }
            cn.close();
        }
        return account;
    }

    public static int updateAccountUser(BigDecimal accountId, int status) throws Exception {
        int result = 0;
        Connection cn = DBConnection.makeConnection();
        if (cn != null) {
            String sql = "UPDATE Account\n"
                    + "SET status = ? where accountID =  ? ";
            PreparedStatement pst = cn.prepareCall(sql);
            pst.setInt(1, status);
            pst.setBigDecimal(2, accountId);
            result = pst.executeUpdate();
        }
        return result;
    }
}
