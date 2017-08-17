package com.sap.pickme.daos.impl;

import com.sap.pickme.daos.VoteDao;
import com.sap.pickme.models.Pool;
import com.sap.pickme.models.Restaurant;
import com.sap.pickme.models.User;
import com.sap.pickme.models.Vote;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.MatchMode;
import org.hibernate.criterion.Restrictions;
import org.springframework.orm.hibernate5.support.HibernateDaoSupport;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;

public class DefaultVoteDao extends HibernateDaoSupport implements VoteDao {

    @Resource
    private SessionFactory sessionFactory;

    @Override
    public Vote getVoteByDate(Date date) {
        try(Session session = sessionFactory.openSession()){
            DetachedCriteria criteria = DetachedCriteria.forClass(Vote.class);
            criteria.add(Restrictions.like("date", date.toString(), MatchMode.EXACT));
            if (criteria.getExecutableCriteria(session).uniqueResult() != null) {
                return (Vote) (criteria.getExecutableCriteria(session).uniqueResult());
            }
        }
        return null;
    }

    @Override
    public Restaurant getRestaurantByUserAndPool(User user, Pool pool) {
        List<Vote> result;
        Session session = getSessionFactory().getCurrentSession();
        result = (List<Vote>) session.createQuery("select v from Vote v where v.pool = :pool and v.user = :user")
                .setParameter("pool", pool)
                .setParameter("user", user).list();

        if (!result.isEmpty()){
             return result.get(0).getRestaurant();
        }else{
            return null;
        }
    }

    @Override
    public Vote getVote(Vote vote) {
        List<Vote> result;
        Session session = getSessionFactory().getCurrentSession();
        result = (List<Vote>) session.createQuery("select v from Vote v where v.pool = :pool and v.user = :user")
                .setParameter("pool", vote.getPool())
                .setParameter("user", vote.getUser()).list();

        if (!result.isEmpty()){
            return result.get(0);
        }else{
            return null;
        }
    }

    @Override
    public List<Vote> getVoteByRestaurant(Restaurant restaurant) {
        List<Vote> result;
        Session session = getSessionFactory().getCurrentSession();
        result = (List<Vote>) session.createQuery("select v from Vote v where v.restaurant = :restaurant")
                .setParameter("restaurant", restaurant).list();
        if (!result.isEmpty()){
            return result;
        }else{
            return null;
        }
    }

    @Override
    public List<Vote> getVoteByRestaurantAndPool(Restaurant restaurant, Pool pool) {
        List<Vote> result;

        Session session = getSessionFactory().getCurrentSession();
        result = (List<Vote>) session.createQuery("select v from Vote v where v.restaurant = :restaurant and v.pool = :pool")
                .setParameter("pool", pool)
                .setParameter("restaurant", restaurant).list();
        if (!result.isEmpty()){
            return result;
        }else{
            return null;
        }
    }

    @Override
    public void vote(Vote vote) {
        getHibernateTemplate().saveOrUpdate(vote);
    }

    @Override
    public void delete(List<Vote> votes) {
        for (Vote vote : votes) {
            getHibernateTemplate().delete(vote);
        }
    }

    @Override
    public List<Vote> voteHistory() {
        return getHibernateTemplate().loadAll(Vote.class);
    }

}
