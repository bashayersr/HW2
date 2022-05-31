package com.example.ecommerce12.Controller;

import com.example.ecommerce12.Service.CategoryService;
import com.example.ecommerce12.model.Category;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;

@Controller
public class CategoryController {

    @Autowired
    private CategoryService categoryService;


    @RequestMapping(value ="/category",method = RequestMethod.GET)
    @ResponseBody
    public ArrayList<Category> getCategory() {
        System.out.println("Show category");
        return categoryService.getallList();
    }

    @RequestMapping(value ="/category/{id}",method = RequestMethod.GET)
    @ResponseBody
    public Category getCategorybyId(@PathVariable("id") int id) {
        System.out.println("serach category id ="+id);
        return categoryService.getCategory(id);

    }

    @RequestMapping(value ="/category/add",method = RequestMethod.POST)
    @ResponseBody
    public void AddCategory(@RequestBody Category Category) {
        System.out.println("add category new for id ="+Category.getID());
        categoryService.addCategory(Category);

    }

    @RequestMapping(value ="/category/update",method = RequestMethod.PUT)
    @ResponseBody
    public void UpdateCategory(@RequestBody Category Category) {
        System.out.println("update category for id ="+Category.getID());
        categoryService.updateCategory(Category);

    }
    @RequestMapping(value ="/category/delete/{id}",method = RequestMethod.GET)
    @ResponseBody
    public void DeleteCategorybyId(@PathVariable("id") int id) {
        System.out.println("Delete category for id ="+id);
        categoryService.deleteCategory(id);

    }
}
