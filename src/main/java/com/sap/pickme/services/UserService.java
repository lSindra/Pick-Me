package com.sap.pickme.services;

import com.sap.pickme.models.Restaurant;
import com.sap.pickme.models.User;

public interface UserService {

    User getUser (int id);

    User getUserByEmail (String email);

    void registerUser (User user);

    User encryptPassword (User user);
}
