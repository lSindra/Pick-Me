package com.sap.pickme.daos.impl;

import com.sap.pickme.daos.PoolDao;
import com.sap.pickme.models.Pool;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.MatchMode;
import org.hibernate.criterion.Restrictions;
import org.springframework.orm.hibernate5.support.HibernateDaoSupport;

import javax.annotation.Resource;
import java.util.Date;

public class DefaultPoolDao extends HibernateDaoSupport implements PoolDao {

    @Resource
    private SessionFactory sessionFactory;

    @Override
    public Pool getActivePool(Date date) {
        try(Session session = sessionFactory.openSession()){
            DetachedCriteria criteria = DetachedCriteria.forClass(Pool.class);
            criteria.add(Restrictions.like("DATE", date.toString(), MatchMode.EXACT));
            if (criteria.getExecutableCriteria(session).uniqueResult() != null) {
                return (Pool) (criteria.getExecutableCriteria(session).uniqueResult());
            }
        }
        return null;
    }

    @Override
    public void createPool(Pool pool) {
        getHibernateTemplate().save(pool);
    }
}
