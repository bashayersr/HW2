package com.example.ecommerce12.Service;

import java.util.ArrayList;

import com.example.ecommerce12.model.Comment;
import org.springframework.stereotype.Service;

@Service
public class CommentService {

    private ArrayList<Comment> Commentlist=new ArrayList<>();
    public  CommentService() {
        Commentlist.add(new Comment(1,1,"Hi",1));
        Commentlist.add(new Comment(2,1,"Hello",5));
    }

    public ArrayList<Comment> getallList(){
        return Commentlist;
    }

    public Comment getComment(int _id) {
        for (Comment prd:Commentlist) {
            if(prd.getID()==(_id)){
                return prd;
            }
        }
        return null;
    }
}
