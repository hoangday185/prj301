/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dto;

import java.io.Serializable;

/**
 *
 * @author hoanghamhoc
 */
public class OrderDetail implements Serializable {

    //field
    private Order order;
    private Flower flower;
    private int quantity;

    //constructor
    public OrderDetail(Order order, Flower flower, int quantity) {
        this.order = order;
        this.flower = flower;
        this.quantity = quantity;
    }

    //constructor này sẽ được đặt vào trong arraylist
    public OrderDetail(Flower flower, int quantity) {
        this.flower = flower;
        this.quantity = quantity;
    }

    //getter and setter
    public Order getOrder() {
        return order;
    }

    public void setOrder(Order order) {
        this.order = order;
    }

    public Flower getFlower() {
        return flower;
    }

    public void setFlower(Flower flower) {
        this.flower = flower;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

}
