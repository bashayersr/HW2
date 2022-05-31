package com.example.ecommerce12.model;


import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;
import org.hibernate.validator.constraints.Range;
import lombok.Data;

@Data
public class MerchantStock {


    @NotEmpty(message = "id is required")
    @Size(min = 3,max = 3,message = "Size the id is 3")
    private Integer ID;

    @NotEmpty(message = "productid is required")
    @Size(min = 3,max = 3,message = "Size the productid is 3")
    private Integer productid;

    @NotEmpty(message = "merchantid is required")
    @Size(min = 3,max = 3,message = "Size the merchantid is 3")
    private Integer merchantid;

    @NotEmpty(message = "stock is required")
    @Range(min = 10)
    private Integer stock;


    public MerchantStock(
            @NotEmpty(message = "id is required") @Size(min = 3, max = 3, message = "Size the id is 3") Integer iD,
            @NotEmpty(message = "productid is required") @Size(min = 3, max = 3, message = "Size the productid is 3") Integer productid,
            @NotEmpty(message = "merchantid is required") @Size(min = 3, max = 3, message = "Size the merchantid is 3") Integer merchantid,
            @NotEmpty(message = "stock is required") @Range(min = 10) Integer stock) {

        ID = iD;
        this.productid = productid;
        this.merchantid = merchantid;
        this.stock = stock;
    }

    public Integer getID() {
        return ID;
    }

    public void setID(Integer iD) {
        ID = iD;
    }

    public Integer getProductid() {
        return productid;
    }

    public void setProductid(Integer productid) {
        this.productid = productid;
    }

    public Integer getMerchantid() {
        return merchantid;
    }

    public void setMerchantid(Integer merchantid) {
        this.merchantid = merchantid;
    }

    public Integer getStock() {
        return stock;
    }

    public void setStock(Integer stock) {
        this.stock = stock;
    }

}
