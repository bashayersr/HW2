package com.example.ecommerce12.Service;


import java.util.ArrayList;

import com.example.ecommerce12.model.Category;
import org.springframework.stereotype.Service;

@Service
public class CategoryService {

    private ArrayList<Category> categoryslist=new ArrayList<>();

    public  CategoryService() {
        categoryslist.add(new Category(1,"Category1"));
        categoryslist.add(new Category(2,"Category2"));
    }
    public ArrayList<Category> getallList(){
        return categoryslist;
    }

    public Category getCategory(int _id) {
        for (Category prd:categoryslist) {
            if(prd.getID()==(_id)){
                return prd;
            }
        }
        return null;
    }

    public boolean addCategory(Category newcat){
        return categoryslist.add(newcat);
    }
    public void updateCategory(Category catg)
    {
        for (Category st:categoryslist) {
            if(st.getID()==(catg.getID())){
                st.setName(catg.getName());
            }
        }

    }


    public void deleteCategory(int id)
    {
        for (Category catg:categoryslist) {
            if(catg.getID()==(id)){
                this.categoryslist.remove(catg);
                break;
            }
        }

    }
}
