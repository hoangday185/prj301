/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utils;

import constraints.Gender;
import constraints.Role;
import constraints.StatusAvailable;
import constraints.StatusOrder;

/**
 *
 * @author hoanghamhoc class chứ các hàm để chuyển các biến int thành enum
 */
public class Convert {

    //gender
    public static Gender mapIntToGender(int genderStr) {
        switch (genderStr) {
            case 1:
                return Gender.Male;
            case 2:
                return Gender.Female;
        }
        return Gender.Unknow;
    }

    //status flower, account
    public static StatusAvailable mapInToStatusAvailable(int codeAvailable) {
        return codeAvailable == 0 ? StatusAvailable.Available : StatusAvailable.NotAvailable;
    }

    //role
    public static Role mapIntToRole(int codeRole) {
        switch (codeRole) {
            case 1:
                return Role.ADMIN;
            case 2:
                return Role.SHIPPER;
        }
        return Role.CUSTOMER;
    }

    //status order
    public static StatusOrder mapIntToStatusOrder(int codeOrder) {
        switch (codeOrder) {
            case 1:
                return StatusOrder.OrderSuccessfull;
            case 2:
                return StatusOrder.Shipping;
            case 3:
                return StatusOrder.ShipSuccessfull;
        }
        return StatusOrder.Fail;
    }
}
