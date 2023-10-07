package com.example.projectse.controller.login;

import com.example.projectse.entity.UserEntity;
import com.example.projectse.service.impl.UserServiceimpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class LoginController  {
    @Autowired
    private UserServiceimpl serviceimpl;
    @GetMapping("/login")
    public String login(){
        return "login";
    }
    @PostMapping("/login")
    public String login1(@RequestParam("email") String email  ,
                         @RequestParam("password") String password,
                         Model model){
        if(serviceimpl.findEandP(email,password)){
            return "redirect:/listCompany";
        }else {
            model.addAttribute("error", "Invalid email or password.");
            return "login";
        }

    };

}
