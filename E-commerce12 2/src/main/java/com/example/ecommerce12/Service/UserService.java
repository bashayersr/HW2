package com.example.ecommerce12.Service;


import java.util.ArrayList;

import com.example.ecommerce12.model.User;
import org.springframework.stereotype.Service;


@Service
public class UserService {

    private ArrayList<User> Userslist=new ArrayList<>();

    public  UserService() {
        Userslist.add(new User(1,"ali","al1123","aa@gmail.com","Admin",0));
        Userslist.add(new User(2,"ahmed","Ag1123","aha@gmail.com","Customer",0));
    }

    public ArrayList<User> getallList(){
        return Userslist;
    }

    public User getUser(int _id) {
        try
        {
            for (User prd:Userslist) {
                if(prd.getID()==(_id)){
                    return prd;
                }
            }
        }
        catch (Exception e) {

        }
        return null;
    }

    public boolean addUser(User newcat){
        return Userslist.add(newcat);
    }
    public void updateUser(User catg)
    {
        for (User st:Userslist) {
            if(st.getID()==(catg.getID())){
                st.setUsername(catg.getUsername());
                st.setPassword(catg.getPassword());
                st.setEmail(catg.getEmail());
                st.setRole(catg.getRole());
                st.setBalance(catg.getBalance());
            }
        }

    }


    public void deleteUser(int id)
    {
        for (User catg:Userslist) {
            if(catg.getID()==(id)){
                this.Userslist.remove(catg);
                break;
            }
        }

    }


}
