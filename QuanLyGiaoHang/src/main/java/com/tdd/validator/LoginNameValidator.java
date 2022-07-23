/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tdd.validator;

import com.tdd.pojos.Login;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

/**
 *
 * @author DAVADO
 */
@Component
public class LoginNameValidator implements Validator{

    @Override
    public boolean supports(Class<?> clazz) {
        return Login.class.isAssignableFrom(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {
        Login login= (Login) target;
        if(!login.getEmail().contains("@gmail.com") && !login.getEmail().contains("@Gmail.com"))
            errors.rejectValue("email", "login.email.Err");
        if(login.getFile().isEmpty())
            errors.rejectValue("file", "login.file.Err");
        if (!login.getPassword().equals(login.getConfirmPassword()))
            errors.rejectValue("confirmPassword", "login.confirmPassword.Err");
    }   
}
