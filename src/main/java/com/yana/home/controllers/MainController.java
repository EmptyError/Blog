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
import org.springframework.web.bind.annotation.*;

import java.security.Principal;
import java.sql.Date;
import java.util.Calendar;
import java.util.List;

/**
 * Created by Admin on 28.04.2017.
 */
@Controller
public class MainController {
    @Autowired
    private CommentsService commentsService;
    @Autowired
   private ArticleService articleService;
    @Autowired
    private UserService userService;
    @RequestMapping(value = "/",method = RequestMethod.GET)
      public  String home(Model model,Principal principal){
        List<Article> articles=articleService.findAll();
        User user= userService.findByLogin(principal.getName());
        model.addAttribute("articles",articles);
        model.addAttribute("user",user);


        return "home";
      }

    @RequestMapping(value = "/loginPage", method = RequestMethod.GET)
    public String login(){

        return "loginPage";
    }
//    @RequestMapping(value = "/registration" ,method = RequestMethod.GET)
//    public  String registration(){
//        return "registration";
//    }
//    @RequestMapping(value = "/registrationProcessing" ,method = RequestMethod.POST)
//    public String registrationProcessing(@RequestParam("firstName" )String name, @RequestParam("secondName") String secondName,
//                                         @RequestParam("password") String password,
//                                         @RequestParam("email") String email,
//                                         @RequestParam("login") String login,
//                                         @RequestParam("phone") String phone){
//
//        userService.add(name,secondName,email,phone,login,password);
//
//        return "redirect:/loginPage";
//    }


    @RequestMapping(value = "/users/add", method = RequestMethod.POST)
    @ResponseBody
    public void addNewUser(@RequestBody User user){

        userService.add(user.getName(),user.getSecondName(),user.getEmail(),user.getPhone(),user.getLogin(),user.getPassword());

    }



@RequestMapping(value = "/add/article" ,method = RequestMethod.POST)
public  String addArticle(@RequestParam("subject") String subject,@RequestParam("text")String text,Principal principal){
    User user= userService.findByLogin(principal.getName());
    System.out.println(user.getLogin());
    java.util.Calendar cal = Calendar.getInstance();
    Date date=new Date(cal.getTime().getTime());
    articleService.add(subject,text,date,user);
    return "redirect:/";
}
@RequestMapping(value = "/delete/article/{id}", method = RequestMethod.GET)
public String deleteArticle(@PathVariable Integer id,Principal principal){
    User user=userService.findByLogin(principal.getName());
    Article article=articleService.findOne(id);
    System.out.println(id);
    System.out.println(user.getId());
    if(article.getUser().getId()==user.getId()){
        articleService.delete(id);
    }
    return "redirect:/";
}

@RequestMapping(value = "/adding/comment/{id}" ,method = RequestMethod.POST)
    public  String addingComment(@PathVariable Integer id,Principal principal,Model model,
                                 @RequestParam("comment") String comment,@RequestParam ("mark")String mark){
    java.util.Calendar cal = Calendar.getInstance();
    Date date=new Date(cal.getTime().getTime());
    User user=userService.findByLogin(principal.getName());
    Article article=articleService.findOne(id);
    commentsService.add(comment,mark,date,user,article);


    return "redirect:/";
}
@RequestMapping(value = "/read/article/{id}" ,method = RequestMethod.GET)
public String readArticle(@PathVariable Integer id,Model model,Principal principal){
    User user= userService.findByLogin(principal.getName());
        Article article= articleService.findOne(id);
        model.addAttribute("article",article);
        List<Comments> commentss=commentsService.findForArticle(article);
        model.addAttribute("comments" ,commentss);
model.addAttribute("user",user);
        return "readArticle";
}
@RequestMapping(value = "/edit/article/{id}" ,method = RequestMethod.GET)
public String editArticle(@PathVariable Integer id,Model model){
    Article article= articleService.findOne(id);
    model.addAttribute("article",article);
    return "editArticle";
}

@RequestMapping(value = "/editing/article/{id}" ,method = RequestMethod.POST)
    public  String editArticleProcessing(Principal principal,@PathVariable Integer id,@RequestParam("text") String text,
                                         @RequestParam("subject") String subject) {
    Article article = articleService.findOne(id);
    User user = userService.findByLogin(principal.getName());
   if(article.getUser().getId()==user.getId()){

    articleService.edit(id, subject, text);
}
    return "redirect:/read/article/{id}";
}
}
