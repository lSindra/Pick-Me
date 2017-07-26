package com.sap.pickme.daos.impls;

import com.sap.pickme.daos.RestaurantDao;
import com.sap.pickme.models.Restaurant;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.MatchMode;
import org.hibernate.criterion.Restrictions;
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

    @Override
    public List<Restaurant> listRestaurants() {
        return (List<Restaurant>) getHibernateTemplate()
                .find("from com.sap.pickme.models.Restaurant");
    }

    @Override
    public Restaurant getRestaurantByName(String restaurantName) {
        try(Session session = sessionFactory.openSession()){
            DetachedCriteria criteria = DetachedCriteria.forClass(Restaurant.class);
            criteria.add(Restrictions.like("name", restaurantName, MatchMode.ANYWHERE));
            return (Restaurant) criteria.getExecutableCriteria(session).uniqueResult();
        }
    }

    @Override
    public boolean isAlelo(String restaurantName) {
        return getRestaurantByName(restaurantName).isAlelo();
    }

    @Transactional
    @Override
    public void addRestaurant(Restaurant restaurant) {
        getHibernateTemplate().save(restaurant);
    }
}
