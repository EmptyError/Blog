package com.yana.home.validation.implementation;

import com.yana.home.entity.User;
import com.yana.home.exceptions.ValidationException;
import com.yana.home.utill.ValidationMessages;
import com.yana.home.utill.ValidationPatterns;
import com.yana.home.validation.Validator;

/**
 * Created by Admin on 02.05.2017.
 */
public class UserValidator implements Validator {
    @Override
    public String validate(Object object) {
        User user= (User) object;
        if(!user.getName().matches(ValidationPatterns.NAME_PATTERN)){
throw  new ValidationException(ValidationMessages.USER_INVALID_FIRST_NAME);
        }
        if(!user.getSecondName().matches(ValidationPatterns.NAME_PATTERN)){
            throw new ValidationException(ValidationMessages.USER_INVALID_LAST_NAME);
        }
        if(!user.getEmail().matches(ValidationPatterns.EMAIL_PATTERN)){
            throw  new ValidationException(ValidationMessages.USER_INVALID_EMAIL);
        }
        if(user.getPhone().length() != 13){
            throw new ValidationException(ValidationMessages.USER_INVALID_PHONE);
        }
        if(!user.getPassword().matches(ValidationPatterns.PASSWORD_PATTERN)){
            throw new ValidationException(ValidationMessages.USER_INVALID_PASSWORD);
        }

        return "";
    }
}
