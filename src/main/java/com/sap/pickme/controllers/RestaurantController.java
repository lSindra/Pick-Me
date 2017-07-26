package com.sap.pickme.controllers;

import com.sap.pickme.daos.RestaurantDao;
import com.sap.pickme.daos.impls.DefaultRestaurantDao;
import com.sap.pickme.models.Restaurant;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

@RestController
@RequestMapping("/restaurant")
public class RestaurantController {

    @Resource
    DefaultRestaurantDao defaultRestaurantDao;

    @RequestMapping(value = "/isBooked", method = RequestMethod.GET)
    public boolean isAlelo(@RequestParam("restaurantName") String restaurantName){
        return defaultRestaurantDao.isAlelo(restaurantName);
    }

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public List<Restaurant> listRestaurants(){
        return defaultRestaurantDao.listRestaurants();
    }

    @RequestMapping(value = "/create")
    public void addRestaurant() {
        Restaurant restaurant = new Restaurant();
        restaurant.setName("Pizzaria");
        restaurant.setAlelo(true);
        restaurant.setLocation("Rua 123");
        restaurant.setImage("www.google.com/imagem");
        restaurant.setId(1);
        defaultRestaurantDao.addRestaurant(restaurant);
    }

}
