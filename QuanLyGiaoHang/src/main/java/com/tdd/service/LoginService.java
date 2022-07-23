/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.tdd.service;

import com.tdd.pojos.Login;
import java.util.List;
import org.springframework.security.core.userdetails.UserDetailsService;

/**
 *
 * @author Admin
 */
public interface LoginService extends UserDetailsService {
    boolean addLogin(Login user);
    boolean addUserRoleShipper(Login shipper);
    List<Login> getLogin(String username);
    Login getLoginById(int id);
    List<Login> getLoginByUsername(String username);
    List<Login> getLoginByPhone(String phone);
    List<Login> getLoginByEmail(String email);
    Login setUserRole(int id);
}
