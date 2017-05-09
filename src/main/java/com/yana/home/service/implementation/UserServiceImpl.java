package com.yana.home.service.implementation;

import com.yana.home.entity.User;
import com.yana.home.repository.UserRepo;
import com.yana.home.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;


import java.util.ArrayList;
import java.util.List;

/**
 * Created by Admin on 28.04.2017.
 */
@Service
public class UserServiceImpl implements UserService,UserDetailsService {
    @Autowired
    UserRepo userRepo;

    @Override
    public void add(String name, String secondName, String email, String phone, String login, String password) {
        User user=new User(name,secondName,email,phone,login,password);
        userRepo.save(user);}

    @Override
    public void delete(int id) {
userRepo.delete(id);
    }

    @Override
    public User find(int id) {
;
        return userRepo.findOne(id);
    }

    @Override
    public void edit(int id, String name, String secondName, String email, String phone, String login, String password) {
userRepo.save(userRepo.findOne(id));
    }

    @Override
    public List<User> findAll() {
        return userRepo.findAll();
    }

    @Override
    public User findByLogin(String login) {
return userRepo.findByLogin(login);
    }

    @Override
    public UserDetails loadUserByUsername(String login) throws UsernameNotFoundException {
        User user=userRepo.findByLogin(login);
        List<GrantedAuthority> authorities= new ArrayList<>();
        authorities.add(new SimpleGrantedAuthority("ROLE_USER"));
        return new org.springframework.security.core.userdetails.User(user.getLogin(),user.getPassword(),authorities);
    }
}
