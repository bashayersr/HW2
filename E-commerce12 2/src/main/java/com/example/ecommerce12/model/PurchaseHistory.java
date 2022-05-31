package com.example.ecommerce12.model;


import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Positive;
import javax.validation.constraints.Size;

import lombok.Data;

@Data
public class PurchaseHistory {



    @NotEmpty(message = "id is required")
    @Size(min = 3,max = 3,message = "Size the id is 3")
    private Integer ID;

    @NotEmpty(message = "userId is required")
    @Size(min = 3,max = 3,message = "Size the userId is 3")
    private Integer userId;

    @NotEmpty(message = "productid is required")
    @Size(min = 3,max = 3,message = "Size the productid is 3")
    private Integer productid;

    @NotEmpty(message = "price is required")
    @Positive(message = "price must be positive")
    private Integer price;

    public PurchaseHistory(
            @NotEmpty(message = "id is required") @Size(min = 3, max = 3, message = "Size the id is 3") Integer iD,
            @NotEmpty(message = "userId is required") @Size(min = 3, max = 3, message = "Size the userId is 3") Integer userId,
            @NotEmpty(message = "productid is required") @Size(min = 3, max = 3, message = "Size the productid is 3") Integer productid,
            @NotEmpty(message = "price is required") @Positive(message = "price must be positive") Integer price) {

        ID = iD;
        this.userId = userId;
        this.productid = productid;
        this.price = price;
    }

    public Integer getID() {
        return ID;
    }

    public void setID(Integer iD) {
        ID = iD;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Integer getProductid() {
        return productid;
    }

    public void setProductid(Integer productid) {
        this.productid = productid;
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }



}
