package com.example.ecommerce12.Service;


import java.util.ArrayList;

import com.example.ecommerce12.model.Cart;
import com.example.ecommerce12.model.Product;
import com.example.ecommerce12.model.User;
import org.springframework.stereotype.Service;


@Service
public class CartService {

    private ArrayList<Cart> Cartslist=new ArrayList<>();
    private UserService userService=new UserService();
    private ProductService productService=new ProductService();

    public  CartService() {
        Cartslist.add(new Cart(1,0,null));
        Cartslist.add(new Cart(2,0,null));
    }

    public ArrayList<Cart> getallList(){
        return Cartslist;
    }

    public Cart getCart(int _id) {
        for (Cart prd:Cartslist) {
            if(prd.getID()==(_id)){
                return prd;
            }
        }
        return null;
    }
    public Integer AddUsrPrudctCart(int userid,int prodctid) {
        Cart cart;
        User user=userService.getUser(userid);
        Product prodct=productService.getProduct(prodctid);
        if(user ==null || prodct ==null)
        {
            return -1;
        }
        boolean IsFound=false;
        for (Cart prd:Cartslist)
        {
            if(prd.getUserId()==(userid))
            {
                for (Product prod:prd.getProducts())
                {
                    if(prod.getID() ==(prodctid))
                    {
                        IsFound=true;
                        break;
                    }
                }
            }
            if(IsFound)
                break;
        }

        if(IsFound)
        {
            return 0;
        }

        cart=new Cart(Cartslist.size()+1, userid,null);

        cart.getProducts().add(prodct);
        Cartslist.add(cart);
        return 1;
    }
    public Integer RemovUsrPrudctCart(int userid,int prodctid) {

        User user=userService.getUser(userid);
        Product prodct=productService.getProduct(prodctid);
        if(user ==null || prodct ==null)
        {
            return -1;
        }
        boolean IsFound=false;
        for (Cart prd:Cartslist)
        {
            if(prd.getUserId()==(userid))
            {
                int index=0;
                if(prd.getProducts()!=null)

                {
                    for (Product prod:prd.getProducts())
                    {
                        if(prod.getID() ==(prodctid))
                        {
                            IsFound=true;
                            prd.getProducts().remove(index);
                            break;
                        }
                        index++;
                    }
                }
            }
            if(IsFound)
                break;
        }


        if(IsFound)
        {

            return 1;
        }
        else
        {
            return 0;
        }

    }

}