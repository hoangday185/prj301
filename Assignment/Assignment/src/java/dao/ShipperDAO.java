/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import constraints.Gender;
import dto.Account;
import dto.Shipper;
import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import utils.Convert;
import utils.DBConnection;

/**
 *
 * @author hoanghamhoc
 */
public class ShipperDAO {

    public static Shipper getShipper(Account account) throws Exception {
        Shipper shipper = null;
        Connection cn = DBConnection.makeConnection();
        if (cn != null) {
            String sql = "select shipperID, shipperName, address, \n"
                    + "	   gender,birthday, salary, phone,dateStart \n"
                    + "	   from Shipper where accountId = " + account.getAccountID();
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(sql);
            if (rs != null && rs.next()) {
                BigDecimal shipperID = rs.getBigDecimal("shipperID");
                String shipperName = rs.getString("shipperName");
                String address = rs.getString("address");
                Gender gender = Convert.mapIntToGender(rs.getInt("gender"));
                Date birthday = rs.getDate("birthday");
                double salary = rs.getDouble("salary");
                String phone = rs.getString("phone");
                Date dateStart = rs.getDate("dateStart");
                shipper = new Shipper(shipperID, shipperName, address, gender, birthday, salary, phone, dateStart, account);
            }
            cn.close();
        }
        return shipper;
    }

    public static ArrayList<Shipper> getListShipper() throws Exception {
        ArrayList<Shipper> listShipper = new ArrayList<>();
        Connection cn = DBConnection.makeConnection();
        if (cn != null) {
            String sql = "select shipperID, shipperName from Shipper";
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(sql);
            if (rs != null) {
                while (rs.next()) {
                    BigDecimal shipperId = rs.getBigDecimal("shipperID");
                    String shipperName = rs.getString("shipperName");
                    Shipper shipper = new Shipper(shipperId, shipperName);
                    listShipper.add(shipper);
                }
            }
            cn.close();
        }
        return listShipper;
    }

    public static Shipper getShipperById(BigDecimal shipperId) throws Exception {
        Shipper shipper = null;
        Connection cn = DBConnection.makeConnection();
        if (cn != null) {
            String sql = "select shipperID, shipperName, address, \n"
                    + "	   gender,birthday, salary, phone,dateStart, accountId \n"
                    + "	   from Shipper where shipperID = ?";
            PreparedStatement pst = cn.prepareCall(sql);
            pst.setBigDecimal(1, shipperId);
            ResultSet rs = pst.executeQuery();
            if (rs != null && rs.next()) {
                BigDecimal shipperID = rs.getBigDecimal("shipperID");
                String shipperName = rs.getString("shipperName");
                String address = rs.getString("address");
                Gender gender = Convert.mapIntToGender(rs.getInt("gender"));
                Date birthday = rs.getDate("birthday");
                double salary = rs.getDouble("salary");
                String phone = rs.getString("phone");
                Date dateStart = rs.getDate("dateStart");
                BigDecimal accountId = rs.getBigDecimal("accountId");
                Account account = AccountDAO.getAccountByAccountId(accountId);
                shipper = new Shipper(shipperID, shipperName, address, gender, birthday, salary, phone, dateStart, account);
            }
            cn.close();
        }
        return shipper;
    }
}
