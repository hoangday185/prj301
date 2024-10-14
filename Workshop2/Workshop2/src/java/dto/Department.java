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
public class Department {
    private int depNum;
    private String depName;

    public Department(){
        depNum = 0;
        depName ="";
    }
    
    public Department(int depNum, String depName) {
        this.depNum = depNum;
        this.depName = depName;
    }

    public int getDepNum() {
        return depNum;
    }

    public void setDepNum(int depNum) {
        this.depNum = depNum;
    }

    public String getDepName() {
        return depName;
    }

    public void setDepName(String depName) {
        this.depName = depName;
    }
    
    
}
