package com.example.ecommerce12.Controller;

import java.util.ArrayList;

import com.example.ecommerce12.Service.CommentService;
import com.example.ecommerce12.model.Comment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;


@Controller
public class CommentController {

    @Autowired
    private CommentService commentService;

    @RequestMapping(value ="/comment",method = RequestMethod.GET)
    @ResponseBody
    public ArrayList<Comment> getComment() {
        System.out.println("Show comment");
        return commentService.getallList();
    }

    @RequestMapping(value ="/comment/{id}",method = RequestMethod.GET)
    @ResponseBody
    public Comment getCartbyId(@PathVariable("id") int id) {
        System.out.println("serach comment id ="+id);
        return commentService.getComment(id);

    }
}
