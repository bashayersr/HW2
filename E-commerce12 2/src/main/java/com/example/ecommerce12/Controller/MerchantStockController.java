package com.example.ecommerce12.Controller;


import java.util.ArrayList;

import com.example.ecommerce12.Service.MerchantStockService;
import com.example.ecommerce12.model.MerchantStock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;


import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/carts")
@RequiredArgsConstructor
@Controller
public class MerchantStockController {

    @Autowired
    private MerchantStockService merchantStockService;


    @RequestMapping(value = "/merchantStock", method = RequestMethod.GET)
    @ResponseBody
    public ArrayList<MerchantStock> getMerchantStock() {
        System.out.println("Show MerchantStock");
        return merchantStockService.getallList();
    }

    @RequestMapping(value = "/merchantStock/{id}", method = RequestMethod.GET)
    @ResponseBody
    public MerchantStock getMerchantStockbyId(@PathVariable("id") int id) {
        System.out.println("serach MerchantStock id =" + id);
        return merchantStockService.getMerchantStock(id);

    }

    @RequestMapping(value = "/merchantStock/add", method = RequestMethod.POST)
    @ResponseBody
    public void AddMerchantStock(@RequestBody MerchantStock merchantStock) {
        System.out.println("add MerchantStock new for id =" + merchantStock.getID());
        merchantStockService.addMerchantStock(merchantStock);

    }

    @RequestMapping(value = "/merchantStock/update", method = RequestMethod.PUT)
    @ResponseBody
    public void UpdateMerchantStock(@RequestBody MerchantStock merchantStock) {
        System.out.println("update MerchantStock for id =" + merchantStock.getID());
        merchantStockService.updateMerchantStock(merchantStock);

    }

    @RequestMapping(value = "/merchantStock/delete/{id}", method = RequestMethod.GET)
    @ResponseBody
    public void DeleteMerchantStockbyId(@PathVariable("id") int id) {
        System.out.println("Delete MerchantStock for id =" + id);
        merchantStockService.deleteMerchantStock(id);

    }

    @RequestMapping(value = "/removeprudctcart/{userid}/{prdctid}", method = RequestMethod.GET)
    @ResponseBody
    @PostMapping
    public ResponseEntity<String> AddStock(@PathVariable Integer prodctid, @PathVariable Integer merchantid, @PathVariable Integer stock) {
        Integer carCase = merchantStockService.AddStock(prodctid, merchantid, stock);
        switch (carCase) {
            case -1:
                return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("User id or product id is wrong");
            case 0:
                return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("You Prudoct and user Unavialabel");
            case 1:
                return ResponseEntity.status(HttpStatus.OK).body("add Product and stock for Cart ");
            default:
                return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Server error !");
        }
    }
}

