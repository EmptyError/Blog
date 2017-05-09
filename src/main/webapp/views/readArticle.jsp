<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 29.04.2017
  Time: 14:22
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <link rel="stylesheet" href="/resources/css/homeStyle.css">
    <link rel="stylesheet" href="/resources/css/loginStyle.css">
    <link rel="stylesheet" href="/resources/css/readStyle.css">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
</head>
<body class="background1">
<div class="home">

   <a href="/"> <button class="d">Home Page</button></a>
    <div class="profile"><i class="fa fa-user" aria-hidden="true"> </i> ${user.login}</div>
</div>

<div class=" read" id="read">
    <div class="title">${article.subject}</div>
    <div class="text">${article.text}</div>
    <div class="comments"><i class="fa fa-comments" aria-hidden="true"></i> Comments </div><div class="round " >${comments.size()}</div>
    <div >
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
    <div class=" allComments">
    <c:forEach items="${comments}" var="comment">
    <div  class="comment">
        <div id="userName">${comment.user.login}</div>
        <div  id="date">${comment.date}</div>
        <div id="mark"><b>Mark:</b>${comment.mark}</div>

        <div  id="comenttext">${comment.text}</div>
        <a href="/delete/comment/${comment.id}">Delete Comment</a>
        <a   href="/edit/comment/${comment.id}">Edit Comment</a>

    </div>
    </c:forEach>
    </div>
</div>

<script src="/resources/js/jquery-3.2.1.min.js"></script>
<script src="/resources/js/homeJS.js"></script>
<script src="/resources/js/readJS.js"></script>
</body>
</html>
