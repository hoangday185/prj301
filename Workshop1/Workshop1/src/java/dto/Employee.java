/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dto;

import java.math.BigDecimal;
import java.sql.Date;

/**
 *
 * @author hoanghamhoc
 */
public class Employee {

    private BigDecimal empId;
    private String name;
    private String address;
    private String sex;

    private Date birthdate;
    private double salary;
    private Department dep;
    private BigDecimal supervisorId;
    private String email;
    private String password;
    private Date startdate;

    public Employee() {
        empId = BigDecimal.valueOf(0);
        name = "";
        address = "";
        sex = "";
        birthdate = null;
        salary = 0;
        dep = null;
        supervisorId = BigDecimal.valueOf(0);
        email = "";
        password = "";
        startdate = null;
    }

    //constructor này để lấy quản lý của người dùng
    public Employee(BigDecimal empSSN, String name) {
        this.empId = empSSN;
        this.name = name;
    }

    public Employee(BigDecimal empId, String name, String address, String sex, Date birthdate, double salary, Department dep, BigDecimal supervisorId, String email, String password, Date startdate) {
        this.empId = empId;
        this.name = name;
        this.address = address;
        this.sex = sex;
        this.birthdate = birthdate;
        this.salary = salary;
        this.dep = dep;
        this.supervisorId = supervisorId;
        this.email = email;
        this.password = password;
        this.startdate = startdate;
    }

    public BigDecimal getEmpId() {
        return empId;
    }

    public void setEmpId(BigDecimal empId) {
        this.empId = empId;
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

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public Date getBirthdate() {
        return birthdate;
    }

    public void setBirthdate(Date birthdate) {
        this.birthdate = birthdate;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public Department getDep() {
        return dep;
    }

    public void setDep(Department dep) {
        this.dep = dep;
    }

    public BigDecimal getSupervisorId() {
        return supervisorId;
    }

    public void setSupervisorId(BigDecimal supervisorId) {
        this.supervisorId = supervisorId;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Date getStartdate() {
        return startdate;
    }

    public void setStartdate(Date startdate) {
        this.startdate = startdate;
    }

}
