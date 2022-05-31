package com.example.ecommerce12.model;


import java.util.ArrayList;


import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Positive;
import javax.validation.constraints.Size;

import lombok.Data;

@Data
public class Product {


    @NotEmpty(message = "id is required")
    @Size(min = 3,max = 3,message = "Size the id is 3")
    private Integer ID;

    @NotEmpty(message = "name is required")
    @Size(min = 3,max = 3,message = "Size the id is 3")
    private String name;

    @NotEmpty(message = "price is required")
    @Positive(message = "price must be positive")
    private Integer price;

    @NotEmpty(message = "categoryID is required")
    @Size(min = 3,max = 3,message = "Size the categoryID is 3")
    private  Integer categoryID ;

    private ArrayList <Comment> comment;


    public Product(@NotEmpty(message = "id is required") @Size(min = 3, max = 3, message = "Size the id is 3") Integer iD,
                   @NotEmpty(message = "name is required") @Size(min = 3, max = 3, message = "Size the id is 3") String name,
                   @NotEmpty(message = "name is required") @Positive(message = "price must be positive") Integer price,
                   @NotEmpty(message = "id is required") @Size(min = 3, max = 3, message = "Size the id is 3") Integer categoryID,
                   ArrayList<Comment> comment) {
        ID = iD;
        this.name = name;
        this.price = price;
        this.categoryID = categoryID;
        this.comment =  new ArrayList<>();
    }
    public Integer getID() {
        return ID;
    }
    public void setID(Integer iD) {
        ID = iD;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public Integer getPrice() {
        return price;
    }
    public void setPrice(Integer price) {
        this.price = price;
    }
    public Integer getCategoryID() {
        return categoryID;
    }
    public void setCategoryID(Integer categoryID) {
        this.categoryID = categoryID;
    }
    public ArrayList<Comment> getComment() {
        return comment;
    }
    public void setComment(ArrayList<Comment> comment) {
        this.comment = comment;
    }
}
