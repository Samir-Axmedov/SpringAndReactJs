package com.aptek.pharm.Validation;

import com.aptek.pharm.Respository.userRepository;
import com.aptek.pharm.Unique.UniqueUsername;
import com.aptek.pharm.entity.User;
import org.springframework.beans.factory.annotation.Autowired;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import com.aptek.pharm.*;
public class UniqueUsernameValidation implements ConstraintValidator<UniqueUsername,String> {

    @Autowired
    userRepository userRepository;

    @Override
    public void initialize(UniqueUsername constraintAnnotation) {

    }

    @Override
    public boolean isValid(String username, ConstraintValidatorContext constraintValidatorContext) {
       User user= userRepository.findByUsername(username);
       if (user!=null){
           return false;
       }
        return true;
    }
}
