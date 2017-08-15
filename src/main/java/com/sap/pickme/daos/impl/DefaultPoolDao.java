package com.sap.pickme.daos.impl;

import com.sap.pickme.daos.PoolDao;
import com.sap.pickme.models.Pool;
import com.sap.pickme.models.Restaurant;
import com.sap.pickme.services.utils.Utils;
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

public class DefaultPoolDao extends HibernateDaoSupport implements PoolDao {

    @Resource
    private SessionFactory sessionFactory;

    @Override
    public Pool getActivePool() {
        try (Session session = sessionFactory.openSession()) {
            return (Pool) session.createQuery("from Pool ORDER BY id DESC")
                    .setMaxResults(1).uniqueResult();
        }
    }

    @Transactional
    @Override
    public void createPool(Pool pool) {
        getHibernateTemplate().save(pool);
    }
}
