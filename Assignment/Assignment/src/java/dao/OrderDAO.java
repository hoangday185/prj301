/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import constraints.Gender;
import constraints.StatusOrder;
import dto.Customer;
import dto.Order;
import dto.Shipper;
import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import utils.Convert;
import utils.DBConnection;

/**
 *
 * @author hoanghamhoc
 */
public class OrderDAO {

    public static Order getOrderByOrderId(BigDecimal orderId) throws SQLException, Exception {
        Order order = null;
        Connection cn = DBConnection.makeConnection();
        if (cn != null) {
            String sql = "select OrderID, CusId, OrderDate, \n"
                    + "		priceShip, shipperID, status from orderFlower where "
                    + "         OrderID = ? and status = 1";
            PreparedStatement pst = cn.prepareCall(sql);
            pst.setBigDecimal(1, orderId);
            ResultSet rs = pst.executeQuery();
            if (rs != null) {
                while (rs.next()) {
                    Customer customer = null;
                    BigDecimal cusID = rs.getBigDecimal("CusId");
                    String sqlCus = "select CutomerID, CusName, \n"
                            + "       address, gender,  \n"
                            + "	   phone , from customer  where CutomerID = ?";
                    PreparedStatement pstCus = cn.prepareCall(sqlCus);
                    pstCus.setBigDecimal(1, cusID);
                    ResultSet rsCus = pstCus.executeQuery();
                    if (rsCus != null && rsCus.next()) {
                        String cusName = rsCus.getString("CusName");
                        String address = rsCus.getString("address");
                        Gender gender = Convert.mapIntToGender(rsCus.getInt("gender"));
                        String phone = rsCus.getString("phone");
                        customer = new Customer(cusID, cusName, address, gender, phone);
                    }
                    Date dateOrder = rs.getDate("OrderDate");
                    double priceShip = rs.getDouble("priceShip");
//                    BigDecimal shipperID = rs.getBigDecimal("shipperID");
                    Shipper shipper = null;
//                    String sqlShipper = "select shipperID, shipperName, gender ,phone from Shipper where shipperID = ?";
//                    PreparedStatement pstShipper = cn.prepareCall(sql);
//                    pstShipper.setBigDecimal(1, shipperID);
//                    ResultSet rsShipper = pstShipper.executeQuery();
//                    if (rsShipper != null && rsShipper.next()) {
//                        String shipperName = rsShipper.getString("shipperName");
//                        Gender gender = Convert.mapIntToGender(rsShipper.getInt("gender"));
//                        String phone = rsShipper.getString("phone");
//                        shipper = new Shipper(shipperID, shipperName, gender, phone);
//                    }
                    StatusOrder status = StatusOrder.OrderSuccessfull;
                    order = new Order(orderId, customer, dateOrder, priceShip, shipper, status);
                }
                cn.close();
            }

        }
        return order;
    }

    //quan trọng
    //hàm này dùng để lấy danh sách các order
    public static ArrayList<Order> getListOrderStatusOrderSuccessfull() throws Exception {
        ArrayList<Order> listOrder = new ArrayList<>();
        Connection cn = DBConnection.makeConnection();
        if (cn != null) {
            String sql = "select OrderID, CusId, OrderDate, \n"
                    + "		priceShip, shipperID, status from orderFlower where "
                    + "         status = 1";
            Statement pst = cn.createStatement();
            ResultSet rs = pst.executeQuery(sql);
            if (rs != null) {
                while (rs.next()) {
                    BigDecimal orderId = rs.getBigDecimal("OrderID");
                    Customer customer = null;
                    BigDecimal cusID = rs.getBigDecimal("CusId");
                    String sqlCus = "select CutomerID, CusName, \n"
                            + "       address, gender,  \n"
                            + "	   phone from customer  where CutomerID = ?";
                    PreparedStatement pstCus = cn.prepareCall(sqlCus);
                    pstCus.setBigDecimal(1, cusID);
                    ResultSet rsCus = pstCus.executeQuery();
                    if (rsCus != null && rsCus.next()) {
                        String cusName = rsCus.getString("CusName");
                        String address = rsCus.getString("address");
                        Gender gender = Convert.mapIntToGender(rsCus.getInt("gender"));
                        String phone = rsCus.getString("phone");
                        customer = new Customer(cusID, cusName, address, gender, phone);
                    }
                    Date dateOrder = rs.getDate("OrderDate");
                    double priceShip = rs.getDouble("priceShip");
//                    BigDecimal shipperID = rs.getBigDecimal("shipperID");
                    Shipper shipper = null;//chỗ này do là trạng thái là orderSuccessfull admin chưa add shipper vô đơn hàng này nên nó còn là null
//                    String sqlShipper = "select shipperID, shipperName, gender ,phone from Shipper where shipperID = ?";
//                    PreparedStatement pstShipper = cn.prepareCall(sql);
//                    pstShipper.setBigDecimal(1, shipperID);
//                    ResultSet rsShipper = pstShipper.executeQuery();
//                    if (rsShipper != null && rsShipper.next()) {
//                        String shipperName = rsShipper.getString("shipperName");
//                        Gender gender = Convert.mapIntToGender(rsShipper.getInt("gender"));
//                        String phone = rsShipper.getString("phone");
//                        shipper = new Shipper(shipperID, shipperName, gender, phone);
//                    }
                    StatusOrder status = StatusOrder.OrderSuccessfull;
                    Order order = new Order(orderId, customer, dateOrder, priceShip, shipper, status);
                    listOrder.add(order);
                }

            }
            cn.close();
        }
        return listOrder;
    }

    //hàm này dùng để gán shipper cho dơn hàng và chuyển trạng thái của đơn hàng
    public static int updateOrderToShipping(BigDecimal orderId, BigDecimal shipperId) throws Exception {
        int result = 0;
        Connection cn = DBConnection.makeConnection();
        if (cn != null) {
            String sql = "UPDATE orderFlower\n"
                    + "SET shipperID = ?, status = ?\n"
                    + "WHERE OrderID = ?";
            PreparedStatement pst = cn.prepareCall(sql);
            pst.setBigDecimal(1, shipperId);
            pst.setInt(2, StatusOrder.Shipping.getStatusCode());
            pst.setBigDecimal(3, orderId);
            result = pst.executeUpdate();
        }
        cn.close();
        return result;
    }

    public static ArrayList<Order> getListOrder() throws Exception {
        ArrayList<Order> listOrder = new ArrayList<>();
        Connection cn = DBConnection.makeConnection();
        if (cn != null) {
            String sql = "select OrderID, CusId, OrderDate, \n"
                    + "		priceShip, shipperID, status from orderFlower";
            Statement pst = cn.createStatement();
            ResultSet rs = pst.executeQuery(sql);
            if (rs != null) {
                while (rs.next()) {
                    BigDecimal orderId = rs.getBigDecimal("OrderID");
                    Customer customer = null;
                    BigDecimal cusID = rs.getBigDecimal("CusId");
                    String sqlCus = "select CutomerID, CusName, \n"
                            + "       address, gender,  \n"
                            + "	   phone from customer  where CutomerID = ?";
                    PreparedStatement pstCus = cn.prepareCall(sqlCus);
                    pstCus.setBigDecimal(1, cusID);
                    ResultSet rsCus = pstCus.executeQuery();
                    if (rsCus != null && rsCus.next()) {
                        String cusName = rsCus.getString("CusName");
                        String address = rsCus.getString("address");
                        Gender gender = Convert.mapIntToGender(rsCus.getInt("gender"));
                        String phone = rsCus.getString("phone");
                        customer = new Customer(cusID, cusName, address, gender, phone);
                    }
                    Date dateOrder = rs.getDate("OrderDate");
                    double priceShip = rs.getDouble("priceShip");
                    BigDecimal shipperID = rs.getBigDecimal("shipperID");
                    Shipper shipper = null;
                    if (shipperID != null) {
                        shipper = ShipperDAO.getShipperById(shipperID);
                    }
                    StatusOrder status = Convert.mapIntToStatusOrder(rs.getInt("status"));
                    Order order = new Order(orderId, customer, dateOrder, priceShip, shipper, status);
                    listOrder.add(order);
                }

            }
            cn.close();
        }
        return listOrder;
    }
}
