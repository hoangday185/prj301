/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dto;

import constraints.StatusAvailable;
import java.io.Serializable;
import java.math.BigDecimal;

/**
 *
 * @author hoanghamhoc
 */
public class Flower implements Serializable {

    //field
    private BigDecimal flowerrId;
    private String flowerName;
    private CategoryFlower category;
    private double price;
    private BigDecimal amount;
    private String imageUrl;
    private StatusAvailable status;

    //constructor
    public Flower(BigDecimal flowerrId, String flowerName, CategoryFlower category, double price, BigDecimal amount, String imageUrl, StatusAvailable status) {
        this.flowerrId = flowerrId;
        this.flowerName = flowerName;
        this.category = category;
        this.price = price;
        this.amount = amount;
        this.imageUrl = imageUrl;
        this.status = status;
    }

    //getter and setter
    public BigDecimal getFlowerrId() {
        return flowerrId;
    }

    public void setFlowerrId(BigDecimal flowerrId) {
        this.flowerrId = flowerrId;
    }

    public String getFlowerName() {
        return flowerName;
    }

    public void setFlowerName(String flowerName) {
        this.flowerName = flowerName;
    }

    public CategoryFlower getCategory() {
        return category;
    }

    public void setCategory(CategoryFlower category) {
        this.category = category;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public StatusAvailable getStatus() {
        return status;
    }

    public void setStatus(StatusAvailable status) {
        this.status = status;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    //hàm này để test code
//    @Override
//    public String toString() {
//        return flowerrId + ", " + flowerName + ", " + category.toString() + ", " + price + ", " + amount + ", " + imageUrl + ", " + status;
//    }
    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }
}
