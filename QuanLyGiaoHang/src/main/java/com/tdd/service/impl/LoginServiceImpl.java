/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.tdd.service.impl;

import com.cloudinary.Cloudinary;
import com.cloudinary.utils.ObjectUtils;
import com.tdd.pojos.Login;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import com.tdd.repository.LoginRepository;
import com.tdd.service.LoginService;
import java.io.IOException;
import java.util.Map;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

/**
 *
 * @author Admin
 */
@Service("userDetailsService")
public class LoginServiceImpl implements LoginService {
    @Autowired
    private LoginRepository loginRepository;
    @Autowired
    private BCryptPasswordEncoder passwordEncoder;
    @Autowired
    private Cloudinary cloudinary;

    @Override
    public boolean addLogin(Login user) {
        try{
            Map r = this.cloudinary.uploader().upload(user.getFile().getBytes(), 
                    ObjectUtils.asMap("resource_type", "auto"));
            user.setAvatar((String) r.get("secure_url"));
            
            String pass = user.getPassword();
            user.setPassword(this.passwordEncoder.encode(pass));
            user.setUserRole(Login.USER);
            
            return this.loginRepository.addLogin(user);
        }catch(IOException ex){
            System.err.println("=== ADD LOGIN ===" +ex.getMessage());
        }
                
        return false;
    }
    
    public boolean addUserRoleShipper(Login shipper){
        shipper.setUserRole(Login.SHIPPER);
        return this.loginRepository.addUserRoleShipper(shipper);
    }

    @Override
    public List<Login> getLogin(String username) {
        return this.loginRepository.getLogin(username);
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        List<Login> users = this.getLogin(username);
        if(users.isEmpty())
            throw new UsernameNotFoundException("User khong ton tai!!!");
        
        Login user = users.get(0);
        
        Set<GrantedAuthority> auth = new HashSet<>();
        auth.add(new SimpleGrantedAuthority(user.getUserRole()));
        
        return new User(user.getUsername(), user.getPassword(), auth);
    }

    @Override
    public Login getLoginById(int i) {
        return this.loginRepository.getLoginById(i);
    }

    @Override
    public List<Login> getLoginByUsername(String string) {
        return this.loginRepository.getLoginByUsername(string);
    }

    @Override
    public List<Login> getLoginByPhone(String string) {
        return this.loginRepository.getLoginByPhone(string);
    }

    @Override
    public List<Login> getLoginByEmail(String string) {
        return this.loginRepository.getLoginByEmail(string);
    }

    @Override
    public Login setUserRole(int id) {
        Login login = this.loginRepository.getLoginById(id);
        
        login.setUserRole(Login.SHIPPER);
        
        return this.loginRepository.setUserRole(login);
    }

}
