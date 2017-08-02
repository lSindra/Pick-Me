package com.sap.pickme.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomeController {

    @RequestMapping(value = "/")
    public String Start() { return "redirect:/homepage"; }

    @RequestMapping(value = "/homepage")
    public String HomePage() {
        return "homepage";
    }

}