package com.sap.pickme.service.impl;

import com.sap.pickme.daos.RestaurantDao;
import com.sap.pickme.models.Restaurant;
import com.sap.pickme.service.RestaurantService;

import javax.annotation.Resource;
import java.util.List;

public class DefaultRestaurantService implements RestaurantService {

    @Resource
    private RestaurantDao restaurantDao;

    @Override
    public List<Restaurant> listRestaurant() {
        return restaurantDao.listRestaurants();
    }

    @Override
    public void addRestaurant(Restaurant restaurant) {
        restaurantDao.addRestaurant(restaurant);
    }

    @Override
    public void deleteRestaurant(int id) {
        restaurantDao.deleteRestaurant(id);
    }

    @Override
    public void editTraining(Restaurant restaurant) {
        restaurantDao.editRestaurant(restaurant);
    }

    @Override
    public Restaurant getRestaurant(int id) {
        return restaurantDao.getRestaurant(id);
    }
}
