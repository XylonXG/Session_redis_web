package com.xg.controller;

import com.xg.pojo.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;

@Controller
public class UserController {
    @RequestMapping("/index")
    public ModelAndView index(HttpServletRequest request){
        ModelAndView mav=new ModelAndView();
        User user=(User) request.getSession().getAttribute("user");

        if(user==null){
            mav.setViewName("/login.jsp");
        }else {
            mav.getModel().put("user",user);
            mav.setViewName("/main.jsp");
        }
        return mav;
    }

    @RequestMapping("/login")
    public ModelAndView login(User user,HttpServletRequest request){
        System.out.println("--login--");
        ModelAndView mav=new ModelAndView();
        request.getSession().setAttribute("user",user);
        mav.getModel().put("user",user);
        mav.setViewName("/main.jsp");
        return mav;
    }
}
