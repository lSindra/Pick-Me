package com.sap.pickme.daos;

import com.sap.pickme.models.User;

public interface UserDao {

    User getUserByEmail (String email);

    void registerUser (User user);
}
