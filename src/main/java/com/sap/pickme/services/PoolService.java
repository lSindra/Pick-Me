package com.sap.pickme.services;

import com.sap.pickme.models.Pool;

import java.util.Date;

public interface PoolService {

    Pool getActivePool(Date date);

    void createPool(Pool pool);

}
