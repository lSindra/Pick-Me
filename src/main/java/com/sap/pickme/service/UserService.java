package com.sap.pickme.service;

import com.sap.pickme.models.User;

public interface UserService {

    User userValid(String email, String password);

}
