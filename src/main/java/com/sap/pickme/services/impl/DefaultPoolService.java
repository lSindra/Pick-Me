package com.sap.pickme.services.impl;

import com.sap.pickme.daos.PoolDao;
import com.sap.pickme.daos.VoteDao;
import com.sap.pickme.models.Pool;
import com.sap.pickme.models.Vote;
import com.sap.pickme.services.PoolService;
import com.sap.pickme.services.VoteService;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.Date;

public class DefaultPoolService implements PoolService {

    @Resource
    private PoolDao poolDao;

    @Override
    public Pool getActivePool(Date date) {
        return poolDao.getActivePool(date);
    }

    @Transactional
    @Override
    public void createPool(Pool pool) {
        poolDao.createPool(pool);
    }

}
