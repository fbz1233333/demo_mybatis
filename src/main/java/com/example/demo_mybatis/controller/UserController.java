package com.example.demo_mybatis.controller;

import com.example.demo_mybatis.dao.UserDao;
import com.example.demo_mybatis.entity.User;
import org.apache.coyote.http11.HttpOutputBuffer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
@RequestMapping("/user")
public class UserController {
    @Resource
    UserDao userDao;

    @RequestMapping("/login")

    public String login(User user, HttpSession session){
        String s="";
        User loginUser=userDao.login(user);
        System.out.println(user);
        System.out.println(loginUser);
        if(loginUser!=null){
            session.setAttribute("loginUser",loginUser);

            session.setAttribute("loginMsg","登录成功");
            s="index";
        }else{
            session.setAttribute("loginMsg","登录失败");
            s="login";
        }
        return s;
    }

    @RequestMapping("/myInfo/{id}")
    public String Info(@PathVariable("id") int id, Model model){
        User user=userDao.getUserById(id);
        model.addAttribute("user",user);
        return "myInfo";
    }

    @RequestMapping("/exit")
    @ResponseBody
    public String exit(HttpSession session){

        session.removeAttribute("loginUser");
        return "成功退出";
    }


    @RequestMapping("/getUsers")
    @ResponseBody
    public List<User> getUser(){
        return userDao.getUsers();
    }
}
