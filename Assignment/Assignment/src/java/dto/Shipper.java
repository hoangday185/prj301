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
public class Shipper implements Serializable {

    //field
    private BigDecimal shipperId;
    private String name;
    private String address;
    private Gender sex;
    private Date birthday;
    private double salary;
    private String phone;
    private Date dateStart;
    private Account account;

    //constructor
    public Shipper(BigDecimal shipperId, String name, String address, Gender sex, Date birthday, double salary, String phone, Date dateStart, Account account) {
        this.shipperId = shipperId;
        this.name = name;
        this.address = address;
        this.sex = sex;
        this.birthday = birthday;
        this.salary = salary;
        this.phone = phone;
        this.dateStart = dateStart;
        this.account = account;
    }

    //constructor này cho việc hiển thị order
    public Shipper(BigDecimal shipperId, String name, Gender sex, String phone) {
        this.shipperId = shipperId;
        this.name = name;
        this.sex = sex;
        this.phone = phone;
    }

    //constructor này để cho việc chọn shipper của 1 đơn hàng
    public Shipper(BigDecimal shipperId, String name) {
        this.shipperId = shipperId;
        this.name = name;
    }

    //getter and setter
    public BigDecimal getShipperId() {
        return shipperId;
    }

    public void setShipperId(BigDecimal shipperId) {
        this.shipperId = shipperId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Gender getSex() {
        return sex;
    }

    public void setSex(Gender sex) {
        this.sex = sex;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public Date getDateStart() {
        return dateStart;
    }

    public void setDateStart(Date dateStart) {
        this.dateStart = dateStart;
    }

    public Account getAccount() {
        return account;
    }

    public void setAccount(Account account) {
        this.account = account;
    }

}
