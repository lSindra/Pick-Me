package com.sap.pickme.service.impl;

import com.sap.pickme.daos.UserDao;
import com.sap.pickme.models.User;
import com.sap.pickme.service.UserService;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

public class DefaultUserService implements UserService {

    @Resource
    private UserDao userDao;

    @Transactional
    @Override
    public User userValid(String email, String password) {
        return userDao.userValid(email, password);
    }
}
