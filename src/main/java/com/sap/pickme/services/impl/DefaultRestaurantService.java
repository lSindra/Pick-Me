package com.sap.pickme.services.impl;

import com.sap.pickme.daos.RestaurantDao;
import com.sap.pickme.daos.VoteDao;
import com.sap.pickme.models.Restaurant;
import com.sap.pickme.models.Vote;
import com.sap.pickme.services.RestaurantService;
import com.sap.pickme.services.VoteService;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.*;

public class DefaultRestaurantService implements RestaurantService {

    @Resource
    private RestaurantDao restaurantDao;

    @Resource
    private VoteService voteService;

    @Resource
    private VoteDao voteDao;

    @Transactional
    @Override
    public void addRestaurant(Restaurant restaurant) {
        restaurantDao.addRestaurant(restaurant);
    }

    @Transactional
    @Override
    public void deleteRestaurant(int id) {
        List<Vote> votes = voteDao.getVoteByRestaurant(getRestaurant(id));
        voteDao.delete(votes);
        restaurantDao.deleteRestaurant(id);
    }

    @Transactional
    @Override
    public void editTraining(Restaurant restaurant) {
        restaurantDao.editRestaurant(restaurant);
    }

    @Override
    public Restaurant getRestaurant(int id) {
        return restaurantDao.getRestaurant(id);
    }

    @Transactional
    @Override
    public List<Restaurant> searchForRestaurant(String searchText) {
        try {
            return getRestaurantVotedList(restaurantDao.searchForRestaurant(searchText));
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    private List<Restaurant> getRestaurantVotedList(List<Restaurant> restaurantList) {
        for (Restaurant restaurant: restaurantList) {
            restaurant.setVotes(voteService.countNumberOfVotes(restaurant));
        }
        return sortRestaurantList(restaurantList);
    }

    private List<Restaurant> sortRestaurantList(List<Restaurant> unsortedList) {
        unsortedList.sort(Comparator.comparing(Restaurant::getVotes, Comparator.reverseOrder()).thenComparing(Restaurant::getName));
        return unsortedList;
    }
}