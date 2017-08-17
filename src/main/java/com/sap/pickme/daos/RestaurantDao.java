package com.sap.pickme.daos;

import com.sap.pickme.models.Restaurant;
import java.util.List;


public interface RestaurantDao {

    Restaurant getRestaurant (int id);

    void addRestaurant (Restaurant restaurant);

    void deleteRestaurant (int id);

    void editRestaurant (Restaurant restaurant);

    List<Restaurant> searchForRestaurant(String searchText) throws Exception;
}
