package com.sap.pickme.controllers;

import com.sap.pickme.models.User;
import com.sap.pickme.services.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.annotation.Resource;
import javax.validation.Valid;

@Controller
@RequestMapping(value = "/user")
public class UserController {

    @Resource
    private UserService userService;

    @RequestMapping(value = "/register", method = RequestMethod.POST)
    public String login(@Valid User user, BindingResult bindingResult) {

        if(bindingResult.hasErrors()) {
            return "homepage";
        }else {
            userService.registerUser(user);
            return"redirect:/";
        }
    }
}