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
public class Admin implements Serializable {

    //attribute
    private BigDecimal adminID;
    private String name;
    private String address;
    private Gender sex;
    private Date birthdate;
    private String phone;
    private double salary;
    private Date dateStart;
    private Account account;

    //constructor
    public Admin(BigDecimal adminID, String name, String address, Gender sex, Date birthdate, String phone, double salary, Date dateStart, Account account) {
        this.adminID = adminID;
        this.name = name;
        this.address = address;
        this.sex = sex;
        this.birthdate = birthdate;
        this.phone = phone;
        this.salary = salary;
        this.dateStart = dateStart;
        this.account = account;
    }

    //getter and setter
    public BigDecimal getAdminID() {
        return adminID;
    }

    public void setAdminID(BigDecimal adminID) {
        this.adminID = adminID;
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

    public Date getBirthdate() {
        return birthdate;
    }

    public void setBirthdate(Date birthdate) {
        this.birthdate = birthdate;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
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
