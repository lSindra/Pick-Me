package com.sap.pickme.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class DefaultController {

    @RequestMapping(value = "/")
    public String start() {
        return "redirect:/restaurant/";
    }

}
