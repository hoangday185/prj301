/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dto;

import java.io.Serializable;
import java.util.ArrayList;

/**
 *
 * @author hoanghamhoc
 */
public class FullInforOrder implements Serializable {

    private Order order;
    private ArrayList<OrderDetail> listOrderDetail;

    public FullInforOrder(Order order, ArrayList<OrderDetail> listOrderDetail) {
        this.order = order;
        this.listOrderDetail = listOrderDetail;
    }

    public Order getOrder() {
        return order;
    }

    public void setOrder(Order order) {
        this.order = order;
    }

    public ArrayList<OrderDetail> getListOrderDetail() {
        return listOrderDetail;
    }

    public void setListOrderDetail(ArrayList<OrderDetail> listOrderDetail) {
        this.listOrderDetail = listOrderDetail;
    }

}
