/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dto;

import constraints.Role;
import constraints.StatusAvailable;
import java.io.Serializable;
import java.math.BigDecimal;

/**
 *
 * @author hoanghamhoc
 */
public class Account implements Serializable {

    //muốn so sánh bigdecimal thì compare
    //muốn tạo mới new BigDecimal(account)
    //attribute
    private BigDecimal accountID;
    private String email;
    private String password;
    private Role roleUser;
    private StatusAvailable statusAvailable;

    //constructor
    public Account(BigDecimal accountID, String email, String password, Role roleUser, StatusAvailable statusAvailable) {
        this.accountID = accountID;
        this.email = email;
        this.password = password;
        this.roleUser = roleUser;
        this.statusAvailable = statusAvailable;
    }

    //getter and setter
    public BigDecimal getAccountID() {
        return accountID;
    }

    public void setAccountID(BigDecimal accountID) {
        this.accountID = accountID;
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

    public Role getRoleUser() {
        return roleUser;
    }

    public void setRoleUser(Role roleUser) {
        this.roleUser = roleUser;
    }

    public StatusAvailable getStatusAvailable() {
        return statusAvailable;
    }

    public void setStatusAvailable(StatusAvailable statusAvailable) {
        this.statusAvailable = statusAvailable;
    }

}
