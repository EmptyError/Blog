package com.yana.home.repository;

import com.yana.home.entity.Article;
import com.yana.home.entity.Comments;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

/**
 * Created by Admin on 27.04.2017.
 */
public interface CommentsRepo extends JpaRepository<Comments,Integer> {
    @Query("select c from Comments c where c.article=:article")
    List <Comments> findForArticle(@Param("article") Article article);
}
