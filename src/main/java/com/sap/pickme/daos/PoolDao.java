package com.sap.pickme.daos;

import com.sap.pickme.models.Pool;

import java.util.Date;

public interface PoolDao {

    Pool getActivePool();

    void createPool(Pool pool);


}
