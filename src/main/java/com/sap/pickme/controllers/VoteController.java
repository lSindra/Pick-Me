package com.sap.pickme.controllers;

import com.sap.pickme.models.Restaurant;
import com.sap.pickme.models.User;
import com.sap.pickme.models.Vote;
import com.sap.pickme.services.PoolService;
import com.sap.pickme.services.RestaurantService;
import com.sap.pickme.services.UserService;

import com.sap.pickme.services.VoteService;
import com.sap.pickme.services.utils.Utils;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.security.Principal;
import java.util.List;

@Controller
@RequestMapping(value = "/vote")
public class VoteController {

    @Resource
    private VoteService voteService;

    @Resource
    private RestaurantService restaurantService;

    @Resource
    private UserService userService;

    @Resource
    private PoolService poolService;

    @ResponseBody
    @RequestMapping(value = "/vote", method = RequestMethod.POST)
    public Vote voteRestaurant(int restaurant_id, Principal principal) {

        int user_ID = userService.getUserByEmail(principal.getName()).getId();
        Vote vote = new Vote();

        try {
            vote.setRestaurant(restaurantService.getRestaurant(restaurant_id));
            vote.setUser(userService.getUser(user_ID));
            vote.setPool(poolService.getActivePool());
        } catch (Exception e) {
            e.printStackTrace();
        }
        vote.setDate(Utils.getCurrentTime());
        voteService.vote(vote);

        return vote;
    }

    @ResponseBody
    @RequestMapping(value = "/voted-restaurant")
    public Restaurant getVotedRestaurant(Principal principal) {
        User user = userService.getUserByEmail(principal.getName());
        return voteService.getVotedRestaurant(user);
    }

    @RequestMapping(value = "/history")
    public String voteHistory(Model model) {
        model.addAttribute("votes", voteService.voteHistory());
        return "vote/vote-history";
    }

}
