/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import constrants.Gender;
import dto.Dependent;
import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import myLib.DBUtils;
import myLib.ValidateInput;

/**
 *
 * @author hoanghamhoc
 */
public class DependentDAO {

    public static ArrayList<Dependent> getListDepenent(BigDecimal empSSN) throws Exception {
        ArrayList<Dependent> listDependent = new ArrayList<>();
        Connection cn = DBUtils.makeConnection();
        if (cn != null) {
            String sql = "select depName ,depSex, depBirthdate, depRelationship  from tblDependent\n"
                    + "	     where empSSN in ( select empSSN from tblEmployee \n"
                    + "						  where empSSN = ? )";
            PreparedStatement pst = cn.prepareStatement(sql);
            pst.setBigDecimal(1, empSSN);
            ResultSet rs = pst.executeQuery();
            if (rs != null) {
                while (rs.next()) {
                    String depName = rs.getString("depName");
                    Gender depSex = ValidateInput.mapStringToGender(rs.getString("depSex"));
                    Date birthday = rs.getDate("depBirthdate");
                    String depRelationship = rs.getString("depRelationship");
                    Dependent dependent = new Dependent(depName, empSSN, depSex, birthday, depRelationship);
                    listDependent.add(dependent);
                }
            }
            cn.close();
        }
        return listDependent;
    }

//    public static int deleteDependent(Dependent dependent) throws Exception {
//        int check = 0;
//        Connection cn = DBUtils.makeConnection();
//        if(cn != null){
//            String sql = "";
//        }
//    }
//    public static int updateDependent(Dependent dependent) throws Exception {
//        int check = 0;
//        Connection cn = DBUtils.makeConnection();
//        if(cn != null){
//            String sql = "";
//        }
//    }
}
/*
use ws1
select * from tblEmployee
select depName, empSSN ,depSex, depBirthdate, depRelationship  from tblDependent
	     where empSSN in ( select empSSN from tblEmployee
						  where empSSN = 30121050004 )
Insert into tblDependent ( depName, empSSN ,depSex, depBirthdate, depRelationship )
values (N'name30', 30121050004, 'M', '2023-10-10 00:00:00.000', N'Chồng')

UPDATE tblDependent
SET
WHERE

-DELETE FROM tblDependent WHERE depName = N'name30' and empSSN = 30121050004
 */
