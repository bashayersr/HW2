package com.example.ecommerce12.Service;

import java.util.ArrayList;

import com.example.ecommerce12.model.Merchant;
import com.example.ecommerce12.model.MerchantStock;
import com.example.ecommerce12.model.Product;
import org.springframework.stereotype.Service;

@Service
public class MerchantStockService {

    private ArrayList<MerchantStock> MerchantStockslist=new ArrayList<>();
    private MerchantService merchantService=new MerchantService();
    private ProductService productService=new ProductService();
    public  MerchantStockService() {
        MerchantStockslist.add(new MerchantStock(1,2,1,3));
        MerchantStockslist.add(new MerchantStock(2,2,1,3));
    }
    public ArrayList<MerchantStock> getallList(){
        return MerchantStockslist;
    }

    public MerchantStock getMerchantStock(int _id) {
        for (MerchantStock prd:MerchantStockslist) {
            if(prd.getID()==(_id)){
                return prd;
            }
        }
        return null;
    }

    public boolean addMerchantStock(MerchantStock newcat){
        return MerchantStockslist.add(newcat);
    }
    public void updateMerchantStock(MerchantStock catg)
    {
        for (MerchantStock st:MerchantStockslist) {
            if(st.getID()==(catg.getID())){
                st.setMerchantid(catg.getMerchantid());
                st.setProductid(catg.getProductid());
                st.setStock(catg.getStock());
            }
        }

    }


    public void deleteMerchantStock(int id)
    {
        for (MerchantStock catg:MerchantStockslist) {
            if(catg.getID()==(id)){
                this.MerchantStockslist.remove(catg);
                break;
            }
        }

    }

    public Integer AddStock(int prodctid, int merchantid, int stock) {
        Merchant merchant=merchantService.getMerchant(merchantid);
        Product prodct=productService.getProduct(prodctid);
        if(merchant ==null || prodct ==null)
        {
            return -1;
        }

        MerchantStock ss=new MerchantStock(MerchantStockslist.size()+1, prodctid, merchantid, stock);
        MerchantStockslist.add(ss);
        return 1;
    }
}
