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
public class Project {

    private int proNum;
    private String proName;

    public Project() {
        proNum = 0;
        proName = "";
    }

    public Project(int proNum, String proName) {
        this.proNum = proNum;
        this.proName = proName;

    }

    public int getProNum() {
        return proNum;
    }

    public void setProNum(int proNum) {
        this.proNum = proNum;
    }

    public String getProName() {
        return proName;
    }

    public void setProName(String proName) {
        this.proName = proName;
    }

}
