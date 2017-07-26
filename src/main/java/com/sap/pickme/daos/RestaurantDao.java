package com.sap.pickme.daos;

import com.sap.pickme.models.Restaurant;
import java.util.List;


public interface RestaurantDao {


    List<Restaurant> listRestaurants();

    Restaurant getRestaurantByName (String roomName);

    boolean isAlelo(String roomName);

    void addRestaurant (Restaurant restaurant);
}
