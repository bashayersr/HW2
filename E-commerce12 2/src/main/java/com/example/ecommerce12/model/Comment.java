package com.example.ecommerce12.model;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;
import org.hibernate.validator.constraints.Range;

import lombok.Data;

@Data
    public class Comment {
    @NotEmpty(message = "id is required")
    @Size(min = 3, max = 3, message = "Size the id is 3")
    private Integer ID;

    @NotEmpty(message = "userId is required")
    @Size(min = 5, max = 5, message = "Size the userId is 5")
    private Integer userId;

    @NotEmpty(message = "message is required")
    @Size(min = 5, max = 5, message = "Size the message is 6")
    private String message;

    @NotEmpty(message = "rate is required")
    @Range(min = 1, max = 5)
    private Integer rate;

    public Comment(
            @NotEmpty(message = "id is required") @Size(min = 3, max = 3, message = "Size the id is 3") Integer iD,
            @NotEmpty(message = "userId is required") @Size(min = 5, max = 5, message = "Size the userId is 5") Integer userId,
            @NotEmpty(message = "message is required") @Size(min = 5, max = 5, message = "Size the message is 6") String message,
            @NotEmpty(message = "rate is required") @Range(min = 1, max = 5) Integer rate) {

        ID = iD;
        this.userId = userId;
        this.message = message;
        this.rate = rate;
    }

    public Integer getID() {
        return ID;
    }
}