package com.yana.home.service;

import com.yana.home.entity.Article;
import com.yana.home.entity.User;

import java.sql.Date;
import java.util.List;

/**
 * Created by Admin on 28.04.2017.
 */
public interface ArticleService {
    public void add(String subject, String text, Date date, User user);
    public void delete(int id);
    public List <Article> findAll();
    public Article findOne(int id);
    public  void edit(int id,String subject,String text);
}
