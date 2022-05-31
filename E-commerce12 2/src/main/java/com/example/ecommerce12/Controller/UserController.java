package com.example.ecommerce12.Controller;


import java.util.ArrayList;

import com.example.ecommerce12.Service.UserService;
import com.example.ecommerce12.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;




import lombok.RequiredArgsConstructor;


@RestController
@RequestMapping("/users")
@RequiredArgsConstructor
@Controller
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping
    public ResponseEntity<ArrayList<User>> getUser(){
        return ResponseEntity.status(HttpStatus.OK).body(userService.getallList());
    }


    @GetMapping("/{id}")
    public ResponseEntity<User> getUserbyId(@PathVariable int id){
        User users=userService.getUser(id);
        return ResponseEntity.status(HttpStatus.OK).body(users);
    }

    @RequestMapping(value ="/add",method = RequestMethod.POST)
    @ResponseBody
    public void AddUser(@RequestBody User user) {
        System.out.println("add User new for id ="+user.getID());
        userService.addUser(user);

    }

    @RequestMapping(value ="/update",method = RequestMethod.PUT)
    @ResponseBody
    public void UpdateUser(@RequestBody User user) {
        System.out.println("update User for id ="+user.getID());
        userService.updateUser(user);

    }
    @RequestMapping(value ="/delete/{id}",method = RequestMethod.GET)
    @ResponseBody
    public void DeleteUserbyId(@PathVariable("id") int id) {
        System.out.println("Delete User for id ="+id);
        userService.deleteUser(id);

    }


}
