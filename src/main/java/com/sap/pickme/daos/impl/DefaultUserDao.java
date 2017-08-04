package com.sap.pickme.daos.impl;

import com.sap.pickme.daos.UserDao;
import com.sap.pickme.models.User;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.MatchMode;
import org.hibernate.criterion.Restrictions;
import org.springframework.orm.hibernate5.support.HibernateDaoSupport;

import javax.annotation.Resource;
import java.util.Objects;

public class DefaultUserDao extends HibernateDaoSupport implements UserDao {

    @Resource
    private SessionFactory sessionFactory;

    @Override
    public User getUserByEmail(String email) {
        try(Session session = sessionFactory.openSession()){
            DetachedCriteria criteria = DetachedCriteria.forClass(User.class);
            criteria.add(Restrictions.like("email", email, MatchMode.EXACT));
            if (criteria.getExecutableCriteria(session).uniqueResult() != null) {
                return (User) (criteria.getExecutableCriteria(session).uniqueResult());
            }
            return null;
        }
    }

    @Override
    public void registerUser(User user) {
        if (getUserByEmail(user.getEmail()) == null){
            getHibernateTemplate().save(user);
        }
    }
}
