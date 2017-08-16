package com.sap.pickme.services;

import com.sap.pickme.models.Restaurant;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface RestaurantService {

    List<Restaurant> listSortedRestaurant();

    void addRestaurant (Restaurant restaurant);

    void deleteRestaurant (int id);

    void editTraining (Restaurant restaurant);

    Restaurant getRestaurant(int id);

    @Transactional
    List<Restaurant> searchForRestaurant(String searchText) throws Exception;
}
