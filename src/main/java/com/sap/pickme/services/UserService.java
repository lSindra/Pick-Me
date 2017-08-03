package com.sap.pickme.services;

import com.sap.pickme.models.User;

public interface UserService {

    User getUserByEmail (String email);

    void registerUser (User user);
}
