package com.sap.pickme.daos.impl;

import com.sap.pickme.daos.UserDao;
import com.sap.pickme.daos.VoteDao;
import com.sap.pickme.models.User;
import com.sap.pickme.models.Vote;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.MatchMode;
import org.hibernate.criterion.Restrictions;
import org.springframework.orm.hibernate5.support.HibernateDaoSupport;

import javax.annotation.Resource;
import java.util.Date;

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
            return null;
        }
    }

    @Override
    public void vote(Vote vote) {
        getHibernateTemplate().save(vote);
    }
}
