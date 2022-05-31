package com.example.ecommerce12.Service;

import java.util.ArrayList;

import com.example.ecommerce12.model.PurchaseHistory;
import org.springframework.stereotype.Service;



@Service
public class PurchaseHistoryService {

    private ArrayList<PurchaseHistory> PurchaseHistorylist=new ArrayList<>();
    public  PurchaseHistoryService() {
        PurchaseHistorylist.add(new PurchaseHistory(1,1,1,500));
        PurchaseHistorylist.add(new PurchaseHistory(2,1,1,600));
    }

    public ArrayList<PurchaseHistory> getallList(){
        return PurchaseHistorylist;
    }

    public PurchaseHistory getPurchaseHistory(int _id) {
        for (PurchaseHistory prd:PurchaseHistorylist) {
            if(prd.getID()==(_id)){
                return prd;
            }
        }
        return null;
    }
}
