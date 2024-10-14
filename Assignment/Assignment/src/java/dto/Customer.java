/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dto;

import constraints.Gender;
import java.io.Serializable;
import java.math.BigDecimal;
import java.sql.Date;

/**
 *
 * @author hoanghamhoc
 */
public class Customer implements Serializable {

    //attribute
    private BigDecimal cusId;
    private String cusName;
    private String address;
    private Gender gender;
    private String phone;
    private Date birthday;
    private Date createAt;
    private Account account;

    //constructor
    public Customer(BigDecimal cusId, String cusName, String address, Gender gender, String phone, Date birthday, Date createAt, Account account) {
        this.cusId = cusId;
        this.cusName = cusName;
        this.address = address;
        this.gender = gender;
        this.phone = phone;
        this.birthday = birthday;
        this.createAt = createAt;
        this.account = account;
    }

    //constructor này lấy những thông tin cần thiết cho 1 đơn hàng
    public Customer(BigDecimal cusId, String cusName, String address, Gender gender, String phone) {
        this.cusId = cusId;
        this.cusName = cusName;
        this.address = address;
        this.gender = gender;
        this.phone = phone;
    }

    //getter and setter
    public BigDecimal getCusId() {
        return cusId;
    }

    public void setCusId(BigDecimal cusId) {
        this.cusId = cusId;
    }

    public String getCusName() {
        return cusName;
    }

    public void setCusName(String cusName) {
        this.cusName = cusName;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public Account getAccount() {
        return account;
    }

    public void setAccount(Account account) {
        this.account = account;
    }

    public Date getCreateAt() {
        return createAt;
    }

    public void setCreateAt(Date createAt) {
        this.createAt = createAt;
    }

    public Gender getGender() {
        return gender;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }

}
