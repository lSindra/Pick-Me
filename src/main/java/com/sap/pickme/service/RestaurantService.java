package com.sap.pickme.service;

import com.sap.pickme.models.Restaurant;

import java.util.List;

public interface RestaurantService {

    List<Restaurant> listRestaurant ();

    void addRestaurant (Restaurant restaurant);

    void deleteRestaurant (int id);

    void editTraining (Restaurant restaurant);

    Restaurant getRestaurant(int id);
}
