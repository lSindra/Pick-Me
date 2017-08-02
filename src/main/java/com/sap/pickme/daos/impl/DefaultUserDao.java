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
    public User userValid(String email, String password) {
        try(Session session = sessionFactory.openSession()){
            DetachedCriteria criteria = DetachedCriteria.forClass(User.class);
            criteria.add(Restrictions.like("email", email, MatchMode.EXACT));
            if (criteria.getExecutableCriteria(session).uniqueResult() != null) {
                User user = (User) (criteria.getExecutableCriteria(session).uniqueResult());
                if(user.getPassword().equals(password)) {
                    return user;
                }
            }
            return null;
        }
    }
}
