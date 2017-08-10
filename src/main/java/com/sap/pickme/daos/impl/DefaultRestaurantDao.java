package com.sap.pickme.daos.impl;

import com.sap.pickme.daos.RestaurantDao;
import com.sap.pickme.models.Restaurant;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.support.HibernateDaoSupport;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


public class DefaultRestaurantDao extends HibernateDaoSupport implements RestaurantDao{

    private SessionFactory sessionFactory;

    @Autowired
    public DefaultRestaurantDao(SessionFactory sessionFactory){
        this.sessionFactory = sessionFactory;
    }

    @Transactional
    @Override
    public List<Restaurant> listRestaurants() {
        return (List<Restaurant>) getHibernateTemplate()
                .find("from com.sap.pickme.models.Restaurant");
    }

    @Override
    public Restaurant getRestaurant(int id) {
        return getHibernateTemplate().get(Restaurant.class, id);
    }

    @Override
    public void addRestaurant(Restaurant restaurant) {
        getHibernateTemplate().save(restaurant);
    }

    @Transactional
    @Override
    public void deleteRestaurant(int id) {
        Restaurant restaurant = new Restaurant();
        restaurant.setId(id);

        getHibernateTemplate().delete(restaurant);
    }

    @Transactional
    @Override
    public void editRestaurant(Restaurant restaurant) {
        getHibernateTemplate().update(restaurant);
    }
}
