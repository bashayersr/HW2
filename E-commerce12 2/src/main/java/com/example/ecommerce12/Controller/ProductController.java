package com.example.ecommerce12.Controller;


import java.util.ArrayList;

import com.example.ecommerce12.Service.ProductService;
import com.example.ecommerce12.model.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;



@Controller
public class ProductController {

    @Autowired
    private ProductService productService;


    @RequestMapping(value ="/product",method = RequestMethod.GET)
    @ResponseBody
    public ArrayList<Product> getProduct() {
        System.out.println("Show Product");
        return productService.getallList();
    }

    @RequestMapping(value ="/product/{id}",method = RequestMethod.GET)
    @ResponseBody
    public Product getProductbyId(@PathVariable("id") int id) {
        System.out.println("serach Product id ="+id);
        return productService.getProduct(id);

    }

    @RequestMapping(value ="/product/add",method = RequestMethod.POST)
    @ResponseBody
    public void AddProduct(@RequestBody Product product) {
        System.out.println("add product new for id ="+product.getID());
        productService.addProduct(product);

    }

    @RequestMapping(value ="/product/update",method = RequestMethod.PUT)
    @ResponseBody
    public void UpdateProduct(@RequestBody Product product) {
        System.out.println("update product for id ="+product.getID());
        productService.updateProduct(product);

    }
    @RequestMapping(value ="/product/delete/{id}",method = RequestMethod.GET)
    @ResponseBody
    public void DeleteProductbyId(@PathVariable("id") int id) {
        System.out.println("Delete product for id ="+id);
        productService.deleteProduct(id);

    }
}