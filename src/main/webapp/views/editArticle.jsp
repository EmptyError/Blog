<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 30.04.2017
  Time: 14:22
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <link rel="stylesheet" href="/resources/css/editStyle.css">
    <link rel="stylesheet" href="/resources/css/homeStyle.css">
    <link rel="stylesheet" href="/resources/css/loginStyle.css">
</head>
<body>
<div class="home">

    <a href="/"> <button class="d">Home Page</button></a>

</div>
<form action="/editing/article/${article.id}" method="post">
<div class="editArticle">
    <div class="input-group">
        <input name="subject" value="${article.subject}" type="text"  >
    </div>
    <div class="input-group"><textarea id="edit-text" name="text" >${article.text}</textarea ></div>
    <button id="editArticleButton"  class="button" type="submit">Add</button>

</div>
</form>
<script src="/resources/js/jquery-3.2.1.min.js"></script>
<script src="/resources/js/homeJS.js"></script>
</body>
</html>
