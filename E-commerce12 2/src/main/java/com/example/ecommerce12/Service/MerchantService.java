package com.example.ecommerce12.Service;


import java.util.ArrayList;

import com.example.ecommerce12.model.Merchant;
import org.springframework.stereotype.Service;



@Service
public class MerchantService {

    private ArrayList<Merchant> Merchantslist=new ArrayList<>();


    public  MerchantService() {
        Merchantslist.add(new Merchant(1,"Merchant1"));
        Merchantslist.add(new Merchant(2,"Merchant2"));
    }
    public ArrayList<Merchant> getallList(){
        return Merchantslist;
    }

    public Merchant getMerchant(int _id) {
        for (Merchant prd:Merchantslist) {
            if(prd.getID()==(_id)){
                return prd;
            }
        }
        return null;
    }

    public boolean addMerchant(Merchant newcat){
        return Merchantslist.add(newcat);
    }
    public void updateMerchant(Merchant catg)
    {
        for (Merchant st:Merchantslist) {
            if(st.getID()==(catg.getID())){
                st.setName(catg.getName());
            }
        }

    }


    public void deleteMerchant(int id)
    {
        for (Merchant catg:Merchantslist) {
            if(catg.getID()==(id)){
                this.Merchantslist.remove(catg);
                break;
            }
        }

    }

}
