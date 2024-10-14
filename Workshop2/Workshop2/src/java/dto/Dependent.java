/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dto;

import constrants.Gender;
import java.math.BigDecimal;
import java.sql.Date;

/**
 *
 * @author hoanghamhoc
 */
public class Dependent {

    private String depName;
    private BigDecimal empSSN;
    private Gender depSex;
    private Date depBirthday;
    private String depRelationship;

    public Dependent(String depName, BigDecimal empSSN, Gender depSex, Date depBirthday, String depRelationship) {
        this.depName = depName;
        this.empSSN = empSSN;
        this.depSex = depSex;
        this.depBirthday = depBirthday;
        this.depRelationship = depRelationship;
    }

    public String getDepName() {
        return depName;
    }

    public void setDepName(String depName) {
        this.depName = depName;
    }

    public BigDecimal getEmpSSN() {
        return empSSN;
    }

    public void setEmpSSN(BigDecimal empSSN) {
        this.empSSN = empSSN;
    }

    public Gender getDepSex() {
        return depSex;
    }

    public void setDepSex(Gender depSex) {
        this.depSex = depSex;
    }

    public Date getDepBirthday() {
        return depBirthday;
    }

    public void setDepBirthday(Date depBirthday) {
        this.depBirthday = depBirthday;
    }

    public String getDepRelationship() {
        return depRelationship;
    }

    public void setDepRelationship(String depRelationship) {
        this.depRelationship = depRelationship;
    }

}
