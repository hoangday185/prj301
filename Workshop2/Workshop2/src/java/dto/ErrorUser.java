/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dto;

/**
 *
 * @author hoanghamhoc
 */
public class ErrorUser {
    private String value;
    private String regex;
    private int min;
    private int max;
    private String confirmValue;

    public ErrorUser(String value) {
        this.value = value;
    }
    
    public ErrorUser(String value, String regex) {
        this.value = value;
        this.regex = regex;
    }

    public ErrorUser(String value, int min, int max) {
        this.value = value;
        this.min = min;
        this.max = max;
    }
   
    public ErrorUser(String value, int min, int max, String confirmValue) {
        this.value = value;
        this.min = min;
        this.max = max;
        this.confirmValue = confirmValue;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public String getRegex() {
        return regex;
    }

    public void setRegex(String regex) {
        this.regex = regex;
    }

    public int getMin() {
        return min;
    }

    public void setMin(int min) {
        this.min = min;
    }

    public int getMax() {
        return max;
    }

    public void setMax(int max) {
        this.max = max;
    }

    public String getConfirmValue() {
        return confirmValue;
    }

    public void setConfirmValue(String confirmValue) {
        this.confirmValue = confirmValue;
    }
    
    
}
