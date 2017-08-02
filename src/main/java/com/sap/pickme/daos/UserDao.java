package com.sap.pickme.daos;

import com.sap.pickme.models.User;

public interface UserDao {

    User userValid (String email, String password);

}
