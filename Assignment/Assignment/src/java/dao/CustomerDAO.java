/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import constraints.Gender;
import dto.Account;
import dto.Customer;
import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import utils.Convert;
import utils.DBConnection;

/**
 *
 * @author hoanghamhoc
 */
public class CustomerDAO {

    public static Customer getCustomer(Account account) throws Exception {
        Customer customer = null;
        Connection cn = DBConnection.makeConnection();
        if (cn != null) {
            String sql = "select CutomerID, CusName, \n"
                    + "       address, gender, birthday, \n"
                    + "	   phone , dateStart from customer  where accountId = " + account.getAccountID();
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(sql);
            if (rs != null && rs.next()) {
                BigDecimal customerID = rs.getBigDecimal("CutomerID");
                String customerName = rs.getString("CusName");
                String address = rs.getString("address");
                Gender gender = Convert.mapIntToGender(rs.getInt("gender"));
                Date birthday = rs.getDate("birthday");
                String phone = rs.getString("phone");
                Date dateStart = rs.getDate("dateStart");
                customer = new Customer(customerID, customerName, address, gender, phone, birthday, dateStart, account);
            }
            cn.close();
        }
        return customer;
    }

    public static ArrayList<Customer> getListCustomer() throws Exception {
        ArrayList<Customer> listCustomer = new ArrayList<>();
        Connection cn = DBConnection.makeConnection();
        if (cn != null) {
            String sql = "select CutomerID, CusName, \n"
                    + "       address, gender, birthday, \n"
                    + "	   phone , dateStart, accountId  from customer";
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(sql);
            if (rs != null) {
                while (rs.next()) {
                    BigDecimal customerID = rs.getBigDecimal("CutomerID");
                    String customerName = rs.getString("CusName");
                    String address = rs.getString("address");
                    Gender gender = Convert.mapIntToGender(rs.getInt("gender"));
                    Date birthday = rs.getDate("birthday");
                    String phone = rs.getString("phone");
                    Date dateStart = rs.getDate("dateStart");
                    BigDecimal accountID = rs.getBigDecimal("accountID");
                    Account account = AccountDAO.getAccountCusByAccountId(accountID);
                    Customer customer = new Customer(accountID, customerName, address, gender, phone, birthday, dateStart, account);
                    listCustomer.add(customer);
                }
            }
            cn.close();
        }
        return listCustomer;
    }
}
