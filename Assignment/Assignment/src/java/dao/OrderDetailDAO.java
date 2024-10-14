/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import dto.Flower;
import dto.FullInforOrder;
import dto.Order;
import dto.OrderDetail;
import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import utils.DBConnection;

/**
 *
 * @author hoanghamhoc
 */
public class OrderDetailDAO {

    /*
    chúng ta sẽ làm hàm lấy danh sách order bên orderDAO
    và từ đó chạy vòng for order dùng orderID lấy ra từng arraylist<orderDetail>
    orderDetail này chỉ có 2 thông tin là flower and quantity
    và như thế ta có thấy lấy đủ bộ thông tin của 1 order
    order sẽ chứ id của customer và shipper, tiền ship của shiper
    order detail sẽ bao gồm số lượng của bông hoa đó
    và trong bông hoa thì sẽ có giá cả
     */
    //hàm này trả ra danh sách orderDetail cái loại hoa đc order và số lượng của từng loại
    public static ArrayList<OrderDetail> getListOrderDetailByID(BigDecimal orderID) throws Exception {
        ArrayList<OrderDetail> listOrderDetail = new ArrayList<>();
        Connection cn = DBConnection.makeConnection();
        if (cn != null) {
            String sql = "select floID, quantity from orderDetail \n"
                    + "         where OrderID = " + orderID;
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(sql);
            if (rs != null) {
                while (rs.next()) {
                    BigDecimal flowerId = rs.getBigDecimal("floID");
                    Flower flower = FlowerDAO.getFlower(flowerId);
                    int quantity = rs.getInt("quantity");
                    OrderDetail orderDetail = new OrderDetail(flower, quantity);
                    listOrderDetail.add(orderDetail);
                }
            }
            cn.close();
        }
        return listOrderDetail;
    }

    //hàm này là hàm trả ra danh sách các loài hoa và order, QUAN TRỌNG
    public static ArrayList<FullInforOrder> getlistFullInforOrder(ArrayList<Order> listOrder) throws Exception {
        ArrayList<FullInforOrder> listFullInforOrder = new ArrayList<>();
        for (Order order : listOrder) {
            ArrayList<OrderDetail> listOrderDetail = getListOrderDetailByID(order.getOrderID());
            FullInforOrder newFullInforOrder = new FullInforOrder(order, listOrderDetail);
            listFullInforOrder.add(newFullInforOrder);
        }
        return listFullInforOrder;
    }
}

//hàm này do em Hoàng non tay làm thấy ko hợp nên cmt
//xử lý lấy nhiều order đang có trạng thái 1
//    public static ArrayList<fullInforOrder> getListFullInforOrder() throws Exception {
//        ArrayList<fullInforOrder> listFullInforOrder = new ArrayList<>();
//        Connection cn = DBConnection.makeConnection();
//        if (cn != null) {
//            String sql = "select OrderID, floID, quantity from orderDetail\n"
//                    + "         where OrderID in \n"
//                    + "		( select OrderID from orderFlower where status = 1 )";
//            Statement st = cn.createStatement();
//            ResultSet rs = st.executeQuery(sql);
//            if (rs != null) {
//                while (rs.next()) {
//                    BigDecimal orderId = rs.getBigDecimal("OrderID");
//                    Order order = OrderDAO.getOrderByOrderId(orderId);
//                    ArrayList<OrderDetail> listOrderDetail = new ArrayList<>();
//                    String sqlOrderDetail = "select floID, quantity from orderDetail where OrderID = " + orderId;
//                    Statement tsOrderDetail = cn.createStatement();
//                    ResultSet rsOrderDetail = tsOrderDetail.executeQuery(sql);
//                    if (rsOrderDetail != null) {
//                        while (rsOrderDetail.next()) {
//                            BigDecimal flowerID = rsOrderDetail.getBigDecimal("floID");
//                            Flower flower = FlowerDAO.getFlower(flowerID);
//                            int quantity = rsOrderDetail.getInt("quantity");
//                            OrderDetail orderDetail = new OrderDetail(flower, quantity);
//                            listOrderDetail.add(orderDetail);
//                        }
//                    }
//                    fullInforOrder fulInforOrder = new fullInforOrder(order, listOrderDetail);
//                    listFullInforOrder.add(fulInforOrder);
//                }
//            }
//        }
//    }
