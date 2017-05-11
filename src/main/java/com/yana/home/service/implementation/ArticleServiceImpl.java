package com.yana.home.service.implementation;

import com.yana.home.entity.Article;
import com.yana.home.entity.User;
import com.yana.home.repository.ArticleRepo;
import com.yana.home.service.ArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Date;
import java.util.List;

/**
 * Created by Admin on 28.04.2017.
 */
@Service
public class ArticleServiceImpl implements ArticleService{
    @Autowired
   private ArticleRepo articleRepo;
    @Override
    public void add(String subject, String text, Date date, User user) {
        Article article= new Article(subject,text,date,user);
      articleRepo.save(article);
    }

    @Override
    public void delete(int id) {
articleRepo.delete(id);
    }

    @Override
    public List<Article> findAll() {
        return articleRepo.findAll();
    }

    @Override
    public Article findOne(int id) {
        return articleRepo.findOne(id);
    }

    @Override
    public void edit(int id, String subject, String text) {
        Article article=articleRepo.findOne(id);
        if(subject!=null){
        article.setSubject(subject);}
        if(text!=null){
        article.setText(text);}
        articleRepo.save(article);

    }
}
