/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dto;

import java.math.BigDecimal;

/**
 *
 * @author hoanghamhoc
 */
public class TimeWork {

    private Project project;
    private BigDecimal empSSN;
    private int time;

    public TimeWork(Project project, BigDecimal empSSN, int time) {
        this.project = project;
        this.empSSN = empSSN;
        this.time = time;
    }

    public Project getProject() {
        return project;
    }

    public void setProject(Project project) {
        this.project = project;
    }

    public BigDecimal getEmpSSN() {
        return empSSN;
    }

    public void setEmpSSN(BigDecimal empSSN) {
        this.empSSN = empSSN;
    }

    public int getTime() {
        return time;
    }

    public void setTime(int time) {
        this.time = time;
    }

}
