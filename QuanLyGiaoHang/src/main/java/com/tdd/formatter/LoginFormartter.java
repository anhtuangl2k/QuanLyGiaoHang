/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.tdd.formatter;

import com.tdd.pojos.Login;
import java.text.ParseException;
import java.util.Locale;
import org.springframework.format.Formatter;

/**
 *
 * @author Admin
 */
public class LoginFormartter implements Formatter<Login>{

    @Override
    public String print(Login object, Locale locale) {
        return String.valueOf(object.getId());
    }

    @Override
    public Login parse(String id, Locale locale) throws ParseException {
        Login l = new Login();
        l.setId(Integer.parseInt(id));
        
        return l;
    }
    
}
