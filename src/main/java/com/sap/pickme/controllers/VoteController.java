package com.sap.pickme.controllers;

import com.sap.pickme.models.Vote;
import com.sap.pickme.services.UserService;

import com.sap.pickme.services.VoteService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.annotation.Resource;
import java.security.Principal;

@Controller
@RequestMapping(value = "/vote")
public class VoteController {

    @Resource
    private VoteService voteService;

    @Resource
    private UserService userService;

    @RequestMapping(value = "/vote", method = RequestMethod.POST)
    public String voteRestaurant(@RequestParam("Restaurant_ID") int restaurant_ID, Principal principal) {

        int user_ID = userService.getUserByEmail(principal.getName()).getId();

        Vote vote = new Vote();
        vote.setRestaurant_id(restaurant_ID);
        vote.setUser_id(user_ID);

        voteService.vote(vote);

        return "page";
    }






}
