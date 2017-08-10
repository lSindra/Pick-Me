package com.sap.pickme.services.impl;

import com.sap.pickme.daos.PoolDao;
import com.sap.pickme.daos.VoteDao;
import com.sap.pickme.models.Pool;
import com.sap.pickme.models.Vote;
import com.sap.pickme.services.PoolService;
import com.sap.pickme.services.VoteService;
import com.sap.pickme.services.utils.Utils;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.Date;

public class DefaultPoolService implements PoolService {

    @Resource
    private PoolDao poolDao;

    @Override
    public Pool getActivePool() {
        Date time = Utils.getEndOfDay();
        Pool pool = poolDao.getActivePool();

        if(pool == null || pool.getDate() != time) {
            createPool();
            return poolDao.getActivePool();
        }
        return pool;
    }

    @Transactional
    @Override
    public void createPool() {
        Date time = Utils.getEndOfDay();
        Pool pool = new Pool();

        pool.setDate(time);
        poolDao.createPool(pool);
    }
}
