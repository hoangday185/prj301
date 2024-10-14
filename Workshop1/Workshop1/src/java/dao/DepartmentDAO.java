/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import dto.Department;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import myLib.DBUtils;

/**
 *
 * @author hoanghamhoc
 */
public class DepartmentDAO {

    public static ArrayList<Department> getDepartment() throws Exception {
        ArrayList<Department> list = new ArrayList<>();
        Connection cn = DBUtils.makeConnection();
        if (cn != null) {
            String sql = "SELECT depNum,depName FROM tblDepartment";// WHERE mgrAssDate IS NOT NULL";
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(sql);
            while (rs.next()) {
                int depNum = rs.getInt("depNum");
                String depName = rs.getString("depName");
                Department dp = new Department(depNum, depName);
                list.add(dp);
            }
            cn.close();
            return list;
        }
        return null;
    }
}
