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
        List<Pool> pools = (List<Pool>) getHibernateTemplate().find("from com.sap.pickme.models.Pool");
        int size = pools.size();
        if(size != 0) {
            return pools.get(size - 1);
        }
        return null;
    }

    @Transactional
    @Override
    public void createPool(Pool pool) {
        getHibernateTemplate().save(pool);
    }
}
