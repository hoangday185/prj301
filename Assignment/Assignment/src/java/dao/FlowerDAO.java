/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import constraints.StatusAvailable;
import dto.CategoryFlower;
import dto.Flower;
import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import utils.Convert;
import utils.DBConnection;

/**
 *
 * @author hoanghamhoc
 */
public class FlowerDAO {

    public static ArrayList<Flower> getListFlower() throws Exception {
        ArrayList<Flower> listFlower = new ArrayList<>();
        Connection cn = DBConnection.makeConnection();
        if (cn != null) {
            String sql = "select flowerID,flowerName,\n"
                    + "		categoryID, price, amout, urlImg, status  \n"
                    + "			from flower";
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(sql);
            if (rs != null) {
                while (rs.next()) {
                    Flower fw = null;
                    BigDecimal flowerID = rs.getBigDecimal("flowerID");
                    String flowerName = rs.getString("flowerName");
                    BigDecimal categoryID = rs.getBigDecimal("categoryID");
                    CategoryFlower cf = null;
                    String sqlCF = "select CategoryId, CategoryName from categoryFlower where CategoryId = ? ";
                    PreparedStatement pstCF = cn.prepareCall(sqlCF);
                    pstCF.setBigDecimal(1, categoryID);
                    ResultSet rsCF = pstCF.executeQuery();
                    if (rsCF != null && rsCF.next()) {
                        categoryID = rsCF.getBigDecimal("CategoryId");
                        String categoryName = rsCF.getString("CategoryName");
                        cf = new CategoryFlower(categoryID, categoryName);
                    }
                    double price = rs.getDouble("price");
                    BigDecimal amount = rs.getBigDecimal("amout");
                    String urlImg = rs.getString("urlImg");
                    StatusAvailable status = Convert.mapInToStatusAvailable(rs.getInt("status"));
                    fw = new Flower(flowerID, flowerName, cf, price, amount, urlImg, status);
                    listFlower.add(fw);
                }
                cn.close();
            }
        }
        return listFlower;
    }

    public static Flower getFlower(BigDecimal flowerId) throws Exception {
        Flower flower = null;
        Connection cn = DBConnection.makeConnection();
        if (cn != null) {
            String sql = "select flowerID,flowerName,\n"
                    + "		categoryID, price, amout, urlImg, status  \n"
                    + "			from flower where flowerID = " + flowerId;
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(sql);
            if (rs != null && rs.next()) {
                String flowerName = rs.getString("flowerName");
                BigDecimal categoryID = rs.getBigDecimal("categoryID");
                CategoryFlower cf = null;
                String sqlCF = "select CategoryId, CategoryName from categoryFlower where CategoryId = ? ";
                PreparedStatement pstCF = cn.prepareCall(sqlCF);
                pstCF.setBigDecimal(1, categoryID);
                ResultSet rsCF = pstCF.executeQuery();
                if (rsCF != null && rsCF.next()) {
                    categoryID = rsCF.getBigDecimal("CategoryId");
                    String categoryName = rsCF.getString("CategoryName");
                    cf = new CategoryFlower(categoryID, categoryName);
                }
                double price = rs.getDouble("price");
                BigDecimal amount = rs.getBigDecimal("amout");
                String urlImg = rs.getString("urlImg");
                StatusAvailable status = Convert.mapInToStatusAvailable(rs.getInt("status"));
                flower = new Flower(flowerId, flowerName, cf, price, amount, urlImg, status);
            }
            cn.close();
        }
        return flower;
    }

    public static ArrayList<CategoryFlower> getListCategory() throws Exception {
        ArrayList<CategoryFlower> listCategory = new ArrayList<>();
        Connection cn = DBConnection.makeConnection();
        if (cn != null) {
            String sql = "select CategoryId, CategoryName from categoryFlower";
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(sql);
            if (rs != null) {
                while (rs.next()) {
                    BigDecimal categoryId = rs.getBigDecimal("CategoryId");
                    String categoryFlower = rs.getString("CategoryName");
                    CategoryFlower categotyFlower = new CategoryFlower(categoryId, categoryFlower);
                    listCategory.add(categotyFlower);
                }
            }
            cn.close();
        }
        return listCategory;
    }
}
