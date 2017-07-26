package com.sap.pickme.controllers;

import com.sap.pickme.daos.RestaurantDao;
import com.sap.pickme.daos.impls.DefaultRestaurantDao;
import com.sap.pickme.models.Restaurant;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import java.util.List;

@Controller
public class RestaurantController {

    @Resource
    RestaurantDao restaurantDao;

    @RequestMapping(value = "/")
    public String start(){ return "redirect:/list"; }

    @RequestMapping(value = "/list")
    public String listRestaurants(Model model){
        model.addAttribute("restaurants", restaurantDao.listRestaurants());
        return "list-restaurants";
    }

    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public String createTraining(@Valid Restaurant restaurant, BindingResult bindingResult,
                                 Model model, RedirectAttributes redirectAttributes, HttpServletRequest req) {

        if (bindingResult.hasErrors()) {
            return "add-training";
        }
        restaurantDao.addRestaurant(restaurant);
        redirectAttributes.addFlashAttribute("success", true);
        return "redirect:/list";
    }

    @RequestMapping(value = "/create")
    public String addRestaurant() {
        Restaurant restaurant = new Restaurant();
        restaurant.setName("Pizzaria");
        restaurant.setPrice(20);
        restaurant.setAlelo(true);
        restaurant.setLocation("Rua 123");
        restaurant.setImage("www.google.com/imagem");
        restaurantDao.addRestaurant(restaurant);
        return "redirect:/list";
    }
}
