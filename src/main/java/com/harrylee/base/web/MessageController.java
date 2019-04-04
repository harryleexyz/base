package com.harrylee.base.web;

import com.harrylee.base.model.User;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;

import javax.servlet.http.HttpServletRequest;

/**
 * @author harrylee
 */
@Controller
public class MessageController {

    @Value("${user.userName}")
    private String userName;


    @GetMapping("/message")
    public String index(ModelMap modelMap, HttpServletRequest httpServletRequest) {
        modelMap.addAttribute("message", "Welcome");
        modelMap.addAttribute("user", new User(userName, "harrylee", "123456", 18, "男", "I'm Harry.Lee"));
        httpServletRequest.getSession().setAttribute("code","xYx uYu");
        httpServletRequest.setAttribute("req","oOo pPp");
        return "message";
    }
}
