package com.sap.pickme.services.impl;

import com.sap.pickme.daos.RestaurantDao;
import com.sap.pickme.daos.VoteDao;
import com.sap.pickme.models.Restaurant;
import com.sap.pickme.models.Vote;
import com.sap.pickme.services.RestaurantService;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

public class DefaultRestaurantService implements RestaurantService {

    @Resource
    private RestaurantDao restaurantDao;

    @Resource
    private VoteDao voteDao;

    @Override
    public List<Restaurant> listRestaurant() {
        return restaurantDao.listRestaurants();
    }

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
}
