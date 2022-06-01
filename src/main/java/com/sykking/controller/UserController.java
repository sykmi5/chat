package com.sykking.controller;

import com.sykking.entity.User;
import com.sykking.service.UserService;
import com.sykking.utils.UnifiedResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;

@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserService userService;

    @GetMapping("/register")
    public void register(User user, HttpServletResponse response) throws IOException {
        System.out.println("2");
        if (user != null){
            userService.addUser(user);
            response.sendRedirect("/chat/login.html");
        }else {

        }
    }

    @PostMapping("/login")
    public void login(@RequestParam String username,@RequestParam String password, HttpServletRequest request,HttpServletResponse response) throws IOException {
            User user = userService.queryUser(username);
            if(user == null){
                PrintWriter writer = response.getWriter();
                writer.println("用户名或密码错误");
            }else {
                HttpSession session = request.getSession();
                session.setAttribute("LoginUser",user);
                response.sendRedirect("/chat/main.html");
            }

    }

    @GetMapping("/getUsername")
    public String getUsername(HttpServletRequest request){
        HttpSession session = request.getSession();
        User user = (User) session.getAttribute("LoginUser");
        return user.getUsername();
    }


}
