package com.example.projectse.controller.login;

import com.example.projectse.dto.UserDTO;
import com.example.projectse.entity.UserEntity;
import com.example.projectse.service.UserService;
import com.example.projectse.service.impl.UserServiceimpl;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
@AllArgsConstructor
public class UserRegistrationController {
    private UserServiceimpl userServiceimpl;
    @GetMapping("/registration")
    public String showform(Model model){
        model.addAttribute("userdto",new UserDTO());
        return "registration";
    }
    @PostMapping("/registration/save")
    public  String save(UserEntity userEntity){
        userServiceimpl.save(userEntity);
        return "redirect:/registration";
    }


}
