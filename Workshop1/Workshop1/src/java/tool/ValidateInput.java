/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tool;

import dao.EmployeeDAO;
import java.math.BigDecimal;
import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

/**
 *
 * @author hoanghamhoc
 */
public class ValidateInput {

    public static String validateEmpSSN(String empSSN, ArrayList<BigDecimal> listEmpSSN) throws Exception {
        return checkDuplicateEmpSSN(listEmpSSN, empSSN) ? "EmpSSN is duplicate!!!" : "";
    }

    //làm hàm check trùng nào
    public static boolean checkDuplicateEmpSSN(ArrayList<BigDecimal> listEmpSSN, String empSSN) throws Exception {
        for (BigDecimal empId : listEmpSSN) {
            if (empId.toString().equalsIgnoreCase(empSSN)) {
                return true;
            }
        }
        return false;
    }

    //check name : name rỗng => tên ko hợp lệ
    public static String validateName(String name, String regex) {
        return name.matches(regex) ? "" : "Name is not valid!!!";
    }

    //check email : email rỗng => email ko hợp lệ => email trùng
    public static String validateEmail(ArrayList<String> listEmail, String email, String regex) {
        if (email.matches(regex)) {
            return checkDuplicateEmail(listEmail, email) ? "" : "Email is duplicate!!!";
        }
        return "Email is not valid!!!";
    }

    //hàm check trùng email
    public static boolean checkDuplicateEmail(ArrayList<String> listEmail, String email) {
        for (String item : listEmail) {
            if (item.equals(email)) {
                return false;
            }
        }
        return true;
    }

    //check pwd : rỗng => min => max
    public static String validatePwd(String pwd, int min, int max) {
        if (pwd.length() >= min) {
            return pwd.length() <= max ? "" : "Max is " + max;
        }
        return "Min is " + min;
    }

    //check confirm pwd : rỗng => min => max => có khớp với pwd không
    public static String validateConfirmPwd(String pwd, String confirmPwd, int min, int max) {
        if (pwd.length() >= min) {
            if (pwd.length() <= max) {
                return pwd.equalsIgnoreCase(confirmPwd) ? "" : "Confirm password is not same password";
            }
            return "Max is " + max;
        }
        return "Min is " + min;
    }

    public static boolean checkInvalid(String html, String inValid) {
        return html.contains(inValid);
    }

}

/*
//check name : name rỗng => tên ko hợp lệ
    public static String validateName(Error error){
        if(!error.getValue().isEmpty()){
            return error.getValue().matches(error.getRegex()) ? "" : "Name is not valid!!!";
        }
        return "That field is required!!!";
    }

    //check email : email rỗng => email ko hợp lệ => email trùng
    public static String validateEmail(ArrayList<String> listEmail, Error error){
        if(!error.getValue().isEmpty()){
            if(error.getValue().matches(error.getRegex())){
                return checkDuplicateEmail(listEmail, error.getValue()) ? "" : "Email is duplicate!!!";
            }
            return "Email is not valid!!!";
        }
        return "That fieldd is required!!!";
    }

    //hàm check trùng email
    public static boolean checkDuplicateEmail(ArrayList<String> listEmail, String email){
        for (String item : listEmail) {
            if(item.equals(email)){
                return false;
            }
        }
        return true;
    }

    //check pwd : rỗng => min => max
    public static String validatePwd(Error error){
        if(!error.getValue().isEmpty()){
            if(error.getValue().length() >= error.getMin()){
                return error.getValue().length() <= error.getMax() ? "" : "Max is " + error.getMax();
            }
            return "Min is " + error.getMin();
        }
        return "That field is required!!!";
    }
    //check confirm pwd : rỗng => min => max => có khớp với pwd không
    public static String validateConfirmPwd(Error error){
        if(!error.getValue().isEmpty()){
            if(error.getValue().length() >= error.getMin()){
                if(error.getValue().length() <= error.getMax()){
                    return error.getValue().equals(error.getConfirmValue()) ? "" : "Confirm password is not same password";
                }
                return "Max is " + error.getMax();
            }
            return "Min is " + error.getMin();
        }
        return "That field is required!!!";
    }

    //check address : rỗng
    public static String validateAddress(Error error){
        return (!error.getValue().isEmpty()) ? "" : "That field is required!!!";
    }

 */
