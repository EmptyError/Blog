<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 28.04.2017
  Time: 2:43
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <link rel="stylesheet" href="/resources/css/homeStyle.css">
    <link rel="stylesheet" href="/resources/css/loginStyle.css">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
</head>
<body class="background1">
<div class="home ">
<button class="d" id="addArticle">Add new Article</button>
    <button class="d " id="viewArticles">View All Articles</button>
    <div class="profile"><i class="fa fa-user" aria-hidden="true"> </i> ${user.login}</div>
    <a  href="/logout">  <div class="b"> LogOut</div></a>

</div>


<div class="addArticle">
    <form action="/add/article" method="post">
    <div class="input-group">
        <input id="subject" name="subject" type="text" placeholder="Subject">
    </div>
    <div class="input-group"><textarea name="text" id="text" ></textarea></div>

        <button class="d" id="addArticleButton" type="submit">Add</button>
    </form>

</div>

<div class="viewArticles ">
<c:forEach items="${articles}" var="article">
    <div class="article">
<div class="title">${article.subject}</div>

       <a  href="/read/article/${article.id}"> <button  class="button" >Read Article</button></a>
        <button  class="button addCommentButton">Add Comment</button>
       <a href="/delete/article/${article.id}"> <button  class="button">Delete Article</button></a>
        <a href="/edit/article/${article.id}"> <button class="button">Edit Article</button></a>
       <a href="/read/article/${article.id}"><button class="button">View Comments</button></a>
        <div class="addComment">
            <form action="/adding/comment/${article.id}" method="post">
            <div class="input-group"><input name="comment" id="textComment" placeholder="Comment " ></div>
                <span class="mark">Your Mark</span>
                <select name="mark" class="mark" >
                    <option value="1">1</option>
                    <option value="2">2</option>
                    <option value="3">3</option>
                    <option value="4">4</option>
                    <option value="5">5</option>

                </select>
            <button id="addButton" type="submit" >Add Comment</button>
            </form>
        </div>
        <div class="author">${article.user.login}  </div>
        <div class="date">${article.date}</div>
    </div>
</c:forEach>
</div>




<script src="/resources/js/jquery-3.2.1.min.js"></script>
<script src="/resources/js/homeJS.js"></script>
</body>
</html>
