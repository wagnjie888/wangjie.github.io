package com.example.controllor;

import com.example.entity.User;
import com.example.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;


@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserService userService;

    @RequestMapping("/getUser")
    public List<User> getUsers(){
        return userService.getUsers();
    }
//传参方式1 get ---http://localhost:8080/user/getUserid?id=1
    @GetMapping("/getUserid")
    public User getUserById(Integer id){
        return userService.getUseById(id);
    }
//传参方式2 post---http://localhost:8080/user/getUserid2/1
    @GetMapping("/getUserid2/{id}")
    public User getUserById2(@PathVariable(name="id")Integer id){
        return userService.getUseById(id);
    }

    @GetMapping(value = "/test/{id}")
    public ModelAndView test(@PathVariable(name="id")Integer id){
       User user =  userService.getUseById(id);
       System.err.println("id="+id);
       ModelAndView mv = new ModelAndView();
       mv.addObject("user",user);
       mv.setViewName("/show");
       return mv;
    }

// test thymeleaf
    @RequestMapping("/test2")
    public String index(ModelMap mp){
        mp.addAttribute("test","text");
        return "index";
    }

}
