/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dto;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 *
 * @author hoanghamhoc
 */
public class Feedback implements Serializable {

    //field
    private BigDecimal feedbackid;
    private Customer customer;
    private Order order;
    private String descripton;

    //constructor
    public Feedback(BigDecimal feedbackid, Customer customer, String descripton) {
        this.feedbackid = feedbackid;
        this.customer = customer;
        this.descripton = descripton;
    }

    //getter and setter
    public BigDecimal getFeedbackid() {
        return feedbackid;
    }

    public void setFeedbackid(BigDecimal feedbackid) {
        this.feedbackid = feedbackid;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public String getDescripton() {
        return descripton;
    }

    public void setDescripton(String descripton) {
        this.descripton = descripton;
    }

}
