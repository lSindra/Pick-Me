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
@RequestMapping(value = "/restaurant")
public class RestaurantController {

    @Resource
    private RestaurantService restaurantService;

    @RequestMapping(value = "/")
    public String start(Model model){
        model.addAttribute("restaurants", restaurantService.listRestaurant());
        return "homepage";
    }

    @RequestMapping(value = "/get")
    public Restaurant getRestaurant(int id) {
        return restaurantService.getRestaurant(id);
    }

    @RequestMapping(value = "/add", method = RequestMethod.GET)
    public String createRestaurantForm(Model model) {
        model.addAttribute("restaurant", new Restaurant());
        return "restaurant/add";
    }

    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public String createRestaurant( @Valid Restaurant restaurant, BindingResult bindingResult,
                                   RedirectAttributes redirectAttributes) {
        if (bindingResult.hasErrors()) {
            return "restaurant/add";
        }
        restaurantService.addRestaurant(restaurant);
        redirectAttributes.addFlashAttribute("success", true);
        return "redirect:/";
    }

    @RequestMapping(value = "/delete", method = RequestMethod.GET)
    public String deleteRestaurant(HttpServletRequest request){
        int id = Integer.parseInt(request.getParameter("id"));
        restaurantService.deleteRestaurant(id);
        return "redirect:/";
    }

    @RequestMapping(value = "/edit", method = RequestMethod.GET)
    public String editRestaurantForm(Model model, @RequestParam("id") int id) {
        Restaurant restaurant = restaurantService.getRestaurant(id);
        model.addAttribute("restaurant", restaurant);
        return "restaurant/edit";
    }

    //    Saving edit-training
    @RequestMapping(value = "/edit", method = RequestMethod.POST)
    public String editRestaurant(@Valid Restaurant restaurant, BindingResult bindingResult,
                               Model model, RedirectAttributes redirectAttributes, HttpServletRequest req) {

        if (bindingResult.hasErrors()) {
            return "restaurant/edit";
        }
        restaurantService.editTraining(restaurant);
        redirectAttributes.addFlashAttribute("success", true);
        return "redirect:/";
    }

    @RequestMapping(value = "/vote", method = RequestMethod.GET)
    public String voteRestaurant(@RequestParam("id") int id) {
        return "page";
    }
}
