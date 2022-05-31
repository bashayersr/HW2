package com.example.ecommerce12.Controller;


import com.example.ecommerce12.Service.PurchaseHistoryService;
import com.example.ecommerce12.model.PurchaseHistory;
import org.springframework.stereotype.Controller;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;


@Controller
public class PurchaseHistoryController {

    @Autowired
    private PurchaseHistoryService PurchaseHistoryService;


    @RequestMapping(value ="/purchaseHistory",method = RequestMethod.GET)
    @ResponseBody
    public ArrayList<PurchaseHistory> getPurchaseHistory() {
        System.out.println("Show purchaseHistory");
        return PurchaseHistoryService.getallList();
    }

    @RequestMapping(value ="/purchaseHistory/{id}",method = RequestMethod.GET)
    @ResponseBody
    public PurchaseHistory getPurchaseHistorybyId(@PathVariable("id") int id) {
        System.out.println("serach PurchaseHistory id ="+id);
        return PurchaseHistoryService.getPurchaseHistory(id);

    }
}
