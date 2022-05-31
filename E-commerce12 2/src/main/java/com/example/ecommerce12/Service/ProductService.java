package com.example.ecommerce12.Service;


import java.util.ArrayList;

import com.example.ecommerce12.model.Product;
import org.springframework.stereotype.Service;



@Service
public class ProductService {

    private ArrayList<Product> productslist=new ArrayList<>();

    public  ProductService() {
        productslist.add(new Product(1,"Item1",23,1,null));
        productslist.add(new Product(2,"Item2",50,2,null));
    }
    public ArrayList<Product> getallList(){
        return productslist;
    }

    public Product getProduct(int _id) {
        for (Product prd:productslist) {
            if(prd.getID()==(_id)){
                return prd;
            }
        }
        return null;
    }

    public boolean addProduct(Product newprd){
        return productslist.add(newprd);
    }
    public void updateProduct(Product prdct)
    {
        for (Product st:productslist) {
            if(st.getID()==(prdct.getID())){
                st.setName(prdct.getName());
                st.setPrice(prdct.getPrice());
                st.setCategoryID(prdct.getCategoryID());
                st.setComment(prdct.getComment());
            }
        }

    }


    public void deleteProduct(int id)
    {
        for (Product prdc:productslist) {
            if(prdc.getID()==(id)){
                this.productslist.remove(prdc);
                break;
            }
        }

    }
}
