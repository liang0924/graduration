package com.edu.guraduration.controller;

import com.edu.guraduration.entity.User;
import com.edu.guraduration.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

@Controller
@Slf4j
@RequestMapping("/login")
public class LoginContrller {
    @Resource
    private UserService userService;

    @RequestMapping("/index")
    public String login(){
        return "loginAndRegister/login";
    }

    @RequestMapping("/check")
    public String check(HttpServletRequest request){
        String username=request.getParameter("username");
        String password=request.getParameter("password");
        log.info(username+":"+password);
        User user = userService.queryByNameAndPassword(username,password);
        if(user!=null)
            return "index";
        return "loginAndRegister/login";
    }

    @RequestMapping("/register")
    public String register(HttpServletRequest request){
        User user = new User();
        user.setUserName(request.getParameter("username"));
        user.setUserPassword(request.getParameter("password"));
        user.setUserEmail(request.getParameter("email"));
        userService.insert(user);
        return "loginAndRegister/login";
    }
}
