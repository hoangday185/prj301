/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dto;

import constraints.StatusOrder;
import java.io.Serializable;
import java.math.BigDecimal;
import java.sql.Date;

/**
 *
 * @author hoanghamhoc
 */
public class Order implements Serializable {

    //field
    private BigDecimal orderID;
    private Customer customer;
    private Date dateOrder;
    private double priceShip;
    private Shipper shipper;
    private StatusOrder status;

    //constructor
    public Order(BigDecimal orderID, Customer customer, Date dateOrder, double priceShip, Shipper shipper, StatusOrder status) {
        this.orderID = orderID;
        this.customer = customer;
        this.dateOrder = dateOrder;
        this.priceShip = priceShip;
        this.shipper = shipper;
        this.status = status;
    }

    public BigDecimal getOrderID() {
        return orderID;
    }

    //getter and setter
    public void setOrderID(BigDecimal orderID) {
        this.orderID = orderID;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public Date getDateOrder() {
        return dateOrder;
    }

    public void setDateOrder(Date dateOrder) {
        this.dateOrder = dateOrder;
    }

    public double getPriceShip() {
        return priceShip;
    }

    public void setPriceShip(double priceShip) {
        this.priceShip = priceShip;
    }

    public Shipper getShipper() {
        return shipper;
    }

    public void setShipper(Shipper shipper) {
        this.shipper = shipper;
    }

    public StatusOrder getStatus() {
        return status;
    }

    public void setStatus(StatusOrder status) {
        this.status = status;
    }

}
