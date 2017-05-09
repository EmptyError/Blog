package com.yana.home.controllers;

import com.yana.home.entity.Article;
import com.yana.home.entity.Comments;
import com.yana.home.entity.User;
import com.yana.home.service.ArticleService;
import com.yana.home.service.CommentsService;
import com.yana.home.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.security.Principal;
import java.sql.Date;
import java.util.Calendar;

/**
 * Created by Admin on 01.05.2017.
 */
@Controller
public class CommentController {
    @Autowired
    UserService userService;
    @Autowired
    CommentsService commentsService;
    @Autowired
    ArticleService articleService;

    @RequestMapping(value = "/delete/comment/{id}", method = RequestMethod.GET)
    public String deleteComment(@PathVariable Integer id, Principal principal) {
        User user = userService.findByLogin(principal.getName());
        Comments comments=commentsService.findOne(id);
        Article article=comments.getArticle();
        User author= article.getUser();
        if (user.getId() == commentsService.findOne(id).getUser().getId()||user.getId()==author.getId()) {
            commentsService.delete(id);
        }
        return "redirect:/";
    }

    @RequestMapping(value = "/edit/comment/{id}", method = RequestMethod.GET)
    public String editComment(@PathVariable Integer id, Model model) {
        Comments comments = commentsService.findOne(id);
        model.addAttribute("comment", comments);
        return "editComment";
    }


    @RequestMapping(value = "/editing/comment/{id}", method = RequestMethod.POST)
    public String addingComment(@PathVariable Integer id, Principal principal,
                                @RequestParam("comment") String comment, @RequestParam("mark") String mark) {
        java.util.Calendar cal = Calendar.getInstance();
        Date date = new Date(cal.getTime().getTime());
        User user = userService.findByLogin(principal.getName());
        if (user.getId() == commentsService.findOne(id).getUser().getId()) {
commentsService.edit(id,comment,mark);

        }
return "redirect:/";
    }


}