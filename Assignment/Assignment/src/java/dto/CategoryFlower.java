/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dto;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 *
 * @author hoanghamhoc
 */
public class CategoryFlower implements Serializable {

    //field
    private BigDecimal categoryID;
    private String categoryName;

    //constructor
    public CategoryFlower(BigDecimal categoryID, String categoryName) {
        this.categoryID = categoryID;
        this.categoryName = categoryName;
    }

    //getter and setter
    public BigDecimal getCategoryID() {
        return categoryID;
    }

    public void setCategoryID(BigDecimal categoryID) {
        this.categoryID = categoryID;
    }

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }

}
