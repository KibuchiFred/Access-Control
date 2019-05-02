package com.example.demo.controllers;

import com.example.demo.models.User;
import com.example.demo.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;
import java.util.List;

@Controller
public class IndexController {

    @Autowired
    private UserService userService;

  public User user;

    @GetMapping(value="newUser")
    public String newUser(Model model){
        model.addAttribute("user", new User());
        model.addAttribute("ROLE", userRoles());

        return "pages/index";
    }

    @PostMapping(value="/registerUser")
    public String createUser(@ModelAttribute(value = "user") User user){

        //if the user selects client
       userService.createClient(user);


       //if the user selects supplier
        userService.createSupplier(user);                                           

    return "pages/login";
    }
    @RequestMapping(value="/showForm",method = RequestMethod.GET)
    public ModelAndView index(){
        User user=new User();
        ModelAndView mv=new ModelAndView();
    mv.addObject("user",user);
    mv.setViewName("fragments/index");
        return mv;
   }

    private List<String> userRoles(){
        List<String> ROLE = new ArrayList<>();
        ROLE.add("CLIENT");
        ROLE.add("SUPPLIER");

        return ROLE;
    }
}
