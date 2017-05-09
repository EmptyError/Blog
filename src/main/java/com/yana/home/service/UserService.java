package com.yana.home.service;

import com.yana.home.entity.User;

import java.util.List;

/**
 * Created by Admin on 27.04.2017.
 */
public interface UserService {
    public  void  add(String name, String secondName, String email, String phone, String login, String password);
    public  void  delete(int id);
    public  User  find(int id);
    public  void  edit(int id,String name, String secondName, String email, String phone, String login, String password);
    public List<User> findAll();
    public  User  findByLogin(String login);


}
