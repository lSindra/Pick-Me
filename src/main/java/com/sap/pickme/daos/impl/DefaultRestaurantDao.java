package com.sap.pickme.daos.impl;

import com.sap.pickme.daos.RestaurantDao;
import com.sap.pickme.models.Pool;
import com.sap.pickme.models.Restaurant;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.search.FullTextSession;
import org.hibernate.search.Search;
import org.hibernate.search.jpa.FullTextEntityManager;
import org.hibernate.search.query.dsl.QueryBuilder;
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
    public Restaurant getRestaurant(int id) {
        return getHibernateTemplate().get(Restaurant.class, id);
    }

    @Override
    public void addRestaurant(Restaurant restaurant) {
        restaurant.setVotes(0);
        getHibernateTemplate().save(restaurant);
    }

    @Override
    public void deleteRestaurant(int id) {
        Restaurant restaurant = new Restaurant();
        restaurant.setId(id);

        getHibernateTemplate().delete(restaurant);
    }

    @Override
    public void editRestaurant(Restaurant restaurant) {
        getHibernateTemplate().update(restaurant);
    }


    @Override
    public List<Restaurant> searchForRestaurant(String searchText) {

        try {
            FullTextSession fullTextSession = Search.getFullTextSession(getSessionFactory().getCurrentSession());

            QueryBuilder qb = fullTextSession.getSearchFactory()
                    .buildQueryBuilder().forEntity(Restaurant.class)
                    .overridesForField("name", "customanalyzer_query")
                    .overridesForField("description", "customanalyzer_query")
                    .overridesForField("location", "customanalyzer_query")
                    .get();
            org.apache.lucene.search.Query query = qb
                    .keyword()
                    .wildcard()
                    .onFields("name", "description", "location")
                    .matching(searchText + "*")
                    .createQuery();

            org.hibernate.Query hibQuery =
                    fullTextSession.createFullTextQuery(query, Restaurant.class);

            return (List<Restaurant>) hibQuery.list();
        }catch (Exception e){
            e.printStackTrace();
        }

        return null;
    }

}
