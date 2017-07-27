package com.sap.pickme.controllers;

import com.sap.pickme.models.Restaurant;
import com.sap.pickme.service.RestaurantService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

@Controller
public class RestaurantController {

    @Resource
    RestaurantService restaurantService;

    @RequestMapping(value = "/")
    public String start(){ return "redirect:/list"; }

    @RequestMapping(value = "/list")
    public String listRestaurants(Model model){
        model.addAttribute("restaurants", restaurantService.listRestaurant());
        return "list-restaurants";
    }

    @RequestMapping(value = "/add", method = RequestMethod.GET)
    public String createRestaurantForm(Model model) {
        model.addAttribute("restaurant", new Restaurant());
        return "add-restaurant";
    }

    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public String createRestaurant(@Valid Restaurant restaurant, BindingResult bindingResult,
                                 Model model, RedirectAttributes redirectAttributes, HttpServletRequest req) {

        if (bindingResult.hasErrors()) {
            return "add-restaurant";
        }
        restaurantService.addRestaurant(restaurant);
        redirectAttributes.addFlashAttribute("success", true);
        return "redirect:/list";
    }

    @RequestMapping(value = "/delete", method = RequestMethod.GET)
    public String deleteTrainings(HttpServletRequest request){
        int id = Integer.parseInt(request.getParameter("id"));
        restaurantService.deleteRestaurant(id);
        return "redirect:/list";
    }

    @RequestMapping(value = "/edit", method = RequestMethod.GET)
    public String editTrainingForm(Model model, HttpServletRequest request){
        int id = Integer.parseInt(request.getParameter("id"));
        Restaurant restaurant = restaurantService.getRestaurant(id);
        model.addAttribute("restaurant", restaurant);
        return "/edit-restaurant";
    }

    //    Saving edit-training
    @RequestMapping(value = "/edit", method = RequestMethod.POST)
    public String editTraining(@Valid Restaurant restaurant, BindingResult bindingResult,
                               Model model, RedirectAttributes redirectAttributes, HttpServletRequest req) {

        if (bindingResult.hasErrors()) {
            return "/edit-restaurant";
        }
        restaurantService.editTraining(restaurant);
        redirectAttributes.addFlashAttribute("success", true);
        return "redirect:/list";
    }

}
