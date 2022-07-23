/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.tdd.repository;

import com.tdd.pojos.Login;
import java.util.List;

/**
 *
 * @author Admin
 */
public interface LoginRepository {
    boolean addLogin(Login user);
    boolean addUserRoleShipper(Login shipper);
    List<Login> getLogin(String username);
    Login getLoginById(int id);
    List<Login> getLoginByUsername(String username);
    List<Login> getLoginByPhone(String phone);
    List<Login> getLoginByEmail(String email);
    Login setUserRole(Login l);
}
