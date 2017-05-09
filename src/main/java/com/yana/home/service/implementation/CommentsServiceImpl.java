package com.yana.home.service.implementation;

import com.yana.home.entity.Article;
import com.yana.home.entity.Comments;
import com.yana.home.entity.User;
import com.yana.home.repository.CommentsRepo;
import com.yana.home.service.CommentsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Date;
import java.util.List;

/**
 * Created by Admin on 28.04.2017.
 */
@Service
public class CommentsServiceImpl implements CommentsService{
    @Autowired
 private CommentsRepo commentsRepo;
    @Override
    public void add(String text, String mark, Date date, User user, Article article) {
Comments comments = new Comments(text,mark,date,user,article);
commentsRepo.save(comments);
    }

    @Override
    public void delete(int id) {
commentsRepo.delete(id);
    }

    @Override
    public List<Comments> findAll() {
        return commentsRepo.findAll();
    }

    @Override
    public Comments findOne(int id) {
        return commentsRepo.findOne(id);
    }

     public  List<Comments> findForArticle(Article article){
        return commentsRepo.findForArticle(article);
     }

    @Override
    public void edit(int id, String text, String mark) {
        Comments comments=commentsRepo.findOne(id);
        comments.setText(text);
        comments.setMark(mark);
        commentsRepo.save(comments);
    }
}
