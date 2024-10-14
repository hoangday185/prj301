/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import dto.Employee;
import dto.Project;
import dto.TimeWork;
import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import myLib.DBUtils;

/**
 *
 * @author hoanghamhoc
 */
public class TimeworkDAO {

    public static ArrayList<TimeWork> getListTimeWork(BigDecimal empSSN) throws Exception {
        ArrayList<TimeWork> listTimeWork = new ArrayList<>();
        Connection cn = DBUtils.makeConnection();
        if (cn != null) {
            String sql = "select proNum, workHours from tblWorksOn "
                    + "   where empSSN =  ? ";
            PreparedStatement pst = cn.prepareStatement(sql);
            pst.setBigDecimal(1, empSSN);
            ResultSet rs = pst.executeQuery();
            if (rs != null) {
                while (rs.next()) {
                    int proNum = rs.getInt("proNum");
                    String proName = "";
                    String sqlProject = "select proName from tblProject where proNum = ? ";
                    PreparedStatement pstPro = cn.prepareCall(sqlProject);
                    pstPro.setInt(1, proNum);
                    ResultSet rsProject = pstPro.executeQuery();
                    while (rsProject.next()) {
                        if (rsProject.getString("proName") != null) {
                            proName = rsProject.getString(1);
                        }
                    }
                    Project project = new Project(proNum, proName);
                    int time = rs.getInt("workHours");
                    TimeWork timeWork = new TimeWork(project, empSSN, time);
                    listTimeWork.add(timeWork);
                }
            }
            cn.close();
        }
        return listTimeWork;
    }
}
