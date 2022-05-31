package com.example.ecommerce12.model;


import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

import lombok.Data;

@Data
public class Category {


    @NotEmpty(message = "id is required")
    @Size(min = 3,max = 3,message = "Size the id is 3")
    private Integer ID;

    @NotEmpty(message = "name is required")
    @Size(min = 3,max = 3,message = "Size the id is 3")
    private String name;


    public Category(
            @NotEmpty(message = "id is required") @Size(min = 3, max = 3, message = "Size the id is 3") Integer iD,
            @NotEmpty(message = "name is required") @Size(min = 3, max = 3, message = "Size the id is 3") String name) {

        ID = iD;
        this.name = name;
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


}
