package com.example.ecommerce12.model;

import java.util.ArrayList;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

import lombok.Data;

@Data
public class Cart {

    //ID, userid, ArrayList < Product >.

    @NotEmpty(message = "id is required")
    @Size(min = 3,max = 3,message = "Size the id is 3")
    private Integer ID;


    @NotEmpty(message = "userId is required")
    @Size(min = 3,max = 3,message = "Size the userId is 3")
    private Integer userId;

    private ArrayList <Product> products;


    public Cart(@NotEmpty(message = "id is required") @Size(min = 3, max = 3, message = "Size the id is 3") Integer iD,
                @NotEmpty(message = "userId is required") @Size(min = 3, max = 3, message = "Size the userId is 3") Integer userId,
                ArrayList<Product> products) {

        ID = iD;
        this.userId = userId;
        this.products = new ArrayList<>();
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

    public ArrayList<Product> getProducts() {
        return products;
    }

    public void setProducts(ArrayList<Product> products) {
        this.products = products;
    }




}
