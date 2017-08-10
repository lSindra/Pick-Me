package com.sap.pickme.controllers;

import com.sap.pickme.models.Pool;
import com.sap.pickme.models.Vote;
import com.sap.pickme.services.RestaurantService;
import com.sap.pickme.services.UserService;

import com.sap.pickme.services.VoteService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.security.Principal;

@Controller
@RequestMapping(value = "/vote")
public class VoteController {

    @Resource
    private VoteService voteService;

    @Resource
    private RestaurantService restaurantService;

    @Resource
    private UserService userService;

    @ResponseBody
    @RequestMapping(value = "/vote", method = RequestMethod.POST)
    public Vote voteRestaurant(int restaurant_id, Principal principal) {

        int user_ID = userService.getUserByEmail(principal.getName()).getId();

        Vote vote = new Vote();
        vote.setRestaurant(restaurantService.getRestaurant(restaurant_id));
        vote.setUser(userService.getUser(user_ID));

        voteService.vote(vote);

        return vote;
    }






}
