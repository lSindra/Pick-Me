package com.sap.pickme.validators;

import com.sap.pickme.models.User;
import com.sap.pickme.services.UserService;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import javax.annotation.Resource;

@Component
public class UserValidator implements Validator {

    @Resource
    private UserService userService;

    @Override
    public boolean supports(Class<?> aClass) {
        return User.class.equals(aClass);
    }

    @Override
    public void validate(Object target, Errors errors) {
        User user = (User) target;

        if(user.getEmail() != null && !(userService.getUserByEmail(user.getEmail()) == null)){
            errors.rejectValue("email", "Email empty");
        }

        if(!user.getPassword().matches("^(?=.*[A-Za-z])(?=.*\\d)[A-Za-z\\d].{5,}$")){
            errors.rejectValue("password", "Invalid password");
        }
    }
}
