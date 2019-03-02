package com.harrylee.base.web;

import com.harrylee.base.model.User;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

/**
 * @author harrylee
 */
@RestController
@RequestMapping("/api/user")
public class UserController {

    @Value("${user.userName}")
    private String userName;

    @PostMapping
    public String save(@Valid User user, BindingResult result) {
        System.out.println("user" + user);
        if (result.hasErrors()) {
            result.getAllErrors().forEach(error -> System.out.println(error.getCode() + "::" + error.getDefaultMessage()));
            return "failure";
        }
        return "success";
    }

    @GetMapping
    public User select() {
        User user = new User();
        user.setUserName(userName);
        return user;
    }

}
