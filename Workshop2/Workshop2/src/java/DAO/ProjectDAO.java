/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import dto.Employee;
import dto.Project;
import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import myLib.DBUtils;

/**
 *
 * @author hoanghamhoc
 */
public class ProjectDAO {

    public static ArrayList<Project> getListProject(Employee employee) throws Exception {
        ArrayList<Project> listProject = new ArrayList<>();
        Connection cn = DBUtils.makeConnection();
        if (cn != null) {
            String sql = "select proNum, proName from tblProject \n"
                    + "		where depNum in (select depNum from tblEmployee \n"
                    + "				      where empSSN = ? )";
            PreparedStatement pst = cn.prepareCall(sql);
            pst.setBigDecimal(1, employee.getEmpSSN());
            ResultSet rs = pst.executeQuery();
            while (rs != null && rs.next()) {
                Integer proNum = rs.getInt("proNum");
                String proName = rs.getString("proName");
                if (proNum != null && proName != null) {
                    Project project = new Project(proNum, proName);
                    listProject.add(project);
                }

            }
            cn.close();
        }
        return listProject;
    }
}
