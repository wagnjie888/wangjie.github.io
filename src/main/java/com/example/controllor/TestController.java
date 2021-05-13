package com.example.controllor;

import com.example.entity.User;
import com.example.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(value="/test")
public class TestController {
    @Autowired
    private UserService userService;

    @GetMapping(value = "/tl/{id}")
    public String test(@PathVariable(name="id")Integer id, Model ml){
        User user =  userService.getUseById(id);
        System.err.println("id="+id);
        ml.addAttribute("user",user);
        return "index";
    }
}
