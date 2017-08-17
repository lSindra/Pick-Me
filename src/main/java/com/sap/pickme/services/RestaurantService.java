package com.sap.pickme.services;

import com.sap.pickme.models.Restaurant;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface RestaurantService {

    void addRestaurant (Restaurant restaurant);

    void deleteRestaurant (int id);

    void editTraining (Restaurant restaurant);

    Restaurant getRestaurant(int id);

    List<Restaurant> searchForRestaurant(String searchText) throws Exception;
}
