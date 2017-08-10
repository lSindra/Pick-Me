package com.sap.pickme.services.impl;

import com.sap.pickme.daos.UserDao;
import com.sap.pickme.models.User;
import com.sap.pickme.services.UserService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

public class DefaultUserService implements UserService {

    @Resource
    private UserDao userDao;

    @Resource
    private BCryptPasswordEncoder passwordEncoder;

    @Override
    public User getUser(int id) {
        return userDao.getUser(id);
    }

    @Transactional
    @Override
    public User getUserByEmail(String email) {
        return userDao.getUserByEmail(email);
    }

    @Transactional
    @Override
    public void registerUser(User user) {
        userDao.registerUser(encryptPassword(user));
    }

    @Override
    public User encryptPassword(User user) {
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        return user;
    }
}
