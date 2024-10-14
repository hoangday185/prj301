/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dto;
//data type object

import constrants.Gender;
import java.io.Serializable;
import java.math.BigDecimal;
import java.sql.Date;

/**
 *
 * @author hoanghamhoc
 */
public class Employee implements Serializable {

    private BigDecimal empSSN;
    private String fullname;
    private String address;
    private double salary;
    private Gender empSex;
    private Date birthday;
    private Department dep;
    private BigDecimal supervisorSSN;
    private String email;
    private String password;
    private Date empStartDate;

    public Employee() {
        empSSN = BigDecimal.valueOf(0);
        fullname = "";
        address = "";
        empSex = Gender.NONE;
        birthday = null;
        dep = null;
        supervisorSSN = BigDecimal.valueOf(0);
        email = "";
        password = "";
        empStartDate = null;
    }

    //constructor này chỉ có nhiệm vụ để hiển thị xếp của nhân viên đó là ai
    //nếu none thì sẽ là ko có xếp
    public Employee(BigDecimal empSSN, String fullname) {
        this.empSSN = empSSN;
        this.fullname = fullname;
    }

    //constructor cho việc update dữ liệu
    public Employee(BigDecimal empSSN, String fullname, String address, Gender empSex, Date birthday, String email, String password) {
        this.empSSN = empSSN;
        this.fullname = fullname;
        this.address = address;
        this.empSex = empSex;
        this.birthday = birthday;
        this.email = email;
        this.password = password;
    }

    //này là lấy hết
    public Employee(BigDecimal empSSN, String fullname, double salary, String address, Gender empSex, Date birthday, Department dep, BigDecimal supervisorSSN, String email, String password, Date empStartDate) {
        this.empSSN = empSSN;
        this.fullname = fullname;
        this.address = address;
        this.salary = salary;
        this.empSex = empSex;
        this.birthday = birthday;
        this.dep = dep;
        this.supervisorSSN = supervisorSSN;
        this.email = email;
        this.password = password;
        this.empStartDate = empStartDate;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public BigDecimal getEmpSSN() {
        return empSSN;
    }

    public void setEmpSSN(BigDecimal empSSN) {
        this.empSSN = empSSN;
    }

    public String getFullname() {
        return fullname;
    }

    public void setFullname(String fullname) {
        this.fullname = fullname;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Gender getEmpSex() {
        return empSex;
    }

    public void setEmpSex(Gender empSex) {
        this.empSex = empSex;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public Department getDep() {
        return dep;
    }

    public void setDep(Department dep) {
        this.dep = dep;
    }

    public BigDecimal getSupervisorSSN() {
        return supervisorSSN;
    }

    public void setSupervisorSSN(BigDecimal supervisorSSN) {
        this.supervisorSSN = supervisorSSN;
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

    public Date getEmpStartDate() {
        return empStartDate;
    }

    public void setEmpStartDate(Date empStartDate) {
        this.empStartDate = empStartDate;
    }

    //hàm này để ép kiểu dữ liệu từ String về Gender
    public static Gender mapStringToGender(String genderStr) {
        switch (genderStr) {
            case "M":
                return Gender.MALE;
            case "F":
                return Gender.FEMALE;
        }
        return Gender.NONE;
    }
}
