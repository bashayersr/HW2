package com.example.ecommerce12.Controller;

import com.example.ecommerce12.Service.CartService;
import com.example.ecommerce12.model.Cart;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import lombok.RequiredArgsConstructor;

import java.util.ArrayList;

@RestController
@RequestMapping("/carts")
@RequiredArgsConstructor
@Controller
public class CartController {

    @Autowired
    private CartService cartService;

    //@RequestMapping(value ="/cart",method = RequestMethod.GET)
    //@ResponseBody
    @GetMapping
    public ArrayList<Cart> getCart() {
        System.out.println("Show Cart");
        return cartService.getallList();
    }

    @RequestMapping(value ="/{id}",method = RequestMethod.GET)
    @ResponseBody
    public Cart getCartbyId(@PathVariable("id") int id) {
        System.out.println("serach cart id ="+id);
        return cartService.getCart(id);

    }

    @RequestMapping(value ="/addprudctcart/{userid}/{prdctid}",method = RequestMethod.GET)
    @ResponseBody

    public ResponseEntity<String> AddUsrPrudctCart(@PathVariable int userid,@PathVariable int prdctid){
        Integer carCase=cartService.AddUsrPrudctCart(userid,prdctid);
        switch (carCase){
            case -1:
                return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("User id or product id is wrong");
            case 0:
                return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("You Prudoct and user avialabel");
            case 1:
                return ResponseEntity.status(HttpStatus.OK).body("Add Product and user for Cart ");
            default:
                return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Server error !");
        }
    }

    @RequestMapping(value ="/removeprudctcart/{userid}/{prdctid}",method = RequestMethod.GET)
    @ResponseBody

    public ResponseEntity<String> RemoveUsrPrudctCart(@PathVariable int userid,@PathVariable int prdctid){
        Integer carCase=cartService.RemovUsrPrudctCart(userid,prdctid);
        switch (carCase){
            case -1:
                return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("User id or product id is wrong");
            case 0:
                return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("You Prudoct and user Unavialabel");
            case 1:
                return ResponseEntity.status(HttpStatus.OK).body("Remove Product and user for Cart ");
            default:
                return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Server error !");
        }
    }

}
