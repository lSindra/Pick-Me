package com.sap.pickme.controllers;

import com.sap.pickme.models.Restaurant;
import com.sap.pickme.services.RestaurantService;
import com.sap.pickme.services.VoteService;
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
@RequestMapping(value = "/restaurant")
public class RestaurantController {

    @Resource
    private RestaurantService restaurantService;

    @Resource
    private VoteService voteService;

    @RequestMapping(value = "/")
    public String start(Model model){
        model.addAttribute("restaurants", restaurantService.listRestaurant());
        return "restaurant/list";
    }

    @ResponseBody
    @RequestMapping(value = "/list")
    public List<Restaurant> getRestaurant() {
        return restaurantService.listRestaurant();
    }

    @ResponseBody
    @RequestMapping(value = "/get")
    public Restaurant getRestaurant(int id) {
        return restaurantService.getRestaurant(id);
    }

    @ResponseBody
    @RequestMapping(value = "/restaurant-count", method = RequestMethod.POST)
    public int getRestaurantVoteCount(Restaurant restaurant) {
        return voteService.countNumberOfVotes(restaurant); }

    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public String createRestaurant( @Valid Restaurant restaurant, BindingResult bindingResult,
                                   RedirectAttributes redirectAttributes) {
        if (bindingResult.hasErrors()) {
            return "redirect:/restaurant/";
        }
        restaurantService.addRestaurant(restaurant);
        redirectAttributes.addFlashAttribute("success", true);
        return "redirect:/restaurant/";
    }

    @RequestMapping(value = "/edit", method = RequestMethod.POST)
    public String editRestaurant(@Valid Restaurant restaurant, BindingResult bindingResult,
                               Model model, RedirectAttributes redirectAttributes, HttpServletRequest req) {

        if (bindingResult.hasErrors()) {
            return "redirect:/restaurant/";
        }
        restaurantService.editTraining(restaurant);
        redirectAttributes.addFlashAttribute("success", true);
        return "redirect:/restaurant/";
    }

    @RequestMapping(value = "/delete", method = RequestMethod.GET)
    public String deleteRestaurant(HttpServletRequest request){
        int id = Integer.parseInt(request.getParameter("id"));
        restaurantService.deleteRestaurant(id);
        return "redirect:/restaurant/";
    }
}
