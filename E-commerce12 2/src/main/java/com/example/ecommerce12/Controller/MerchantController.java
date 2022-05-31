package com.example.ecommerce12.Controller;

import java.util.ArrayList;

import com.example.ecommerce12.Service.MerchantService;
import com.example.ecommerce12.model.Merchant;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class MerchantController {

    @Autowired
    private MerchantService merchantService;


    @RequestMapping(value ="/Merchant",method = RequestMethod.GET)
    @ResponseBody
    public ArrayList<Merchant> getMerchant() {
        System.out.println("Show Merchant");
        return merchantService.getallList();
    }

    @RequestMapping(value ="/merchant/{id}",method = RequestMethod.GET)
    @ResponseBody
    public Merchant getMerchantbyId(@PathVariable("id") int id) {
        System.out.println("serach Merchant id ="+id);
        return merchantService.getMerchant(id);

    }

    @RequestMapping(value ="/merchant/add",method = RequestMethod.POST)
    @ResponseBody
    public void AddMerchant(@RequestBody Merchant merchant) {
        System.out.println("add Merchant new for id ="+merchant.getID());
        merchantService.addMerchant(merchant);

    }

    @RequestMapping(value ="/merchant/update",method = RequestMethod.PUT)
    @ResponseBody
    public void UpdateMerchant(@RequestBody Merchant merchant) {
        System.out.println("update Merchant for id ="+merchant.getID());
        merchantService.updateMerchant(merchant);

    }
    @RequestMapping(value ="/merchant/delete/{id}",method = RequestMethod.GET)
    @ResponseBody
    public void DeleteMerchantbyId(@PathVariable("id") int id) {
        System.out.println("Delete Merchant for id ="+id);
        merchantService.deleteMerchant(id);

    }
}
