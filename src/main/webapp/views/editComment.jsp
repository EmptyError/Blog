<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 01.05.2017
  Time: 16:16
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <link rel="stylesheet" href="/resources/css/editStyle.css">
    <link rel="stylesheet" href="/resources/css/homeStyle.css">
    <link rel="stylesheet" href="/resources/css/loginStyle.css">
    <link rel="stylesheet" href="/resources/css/readStyle.css">
</head>
<body>
<div class="home">

    <a href="/"> <button class="d">Home Page</button></a>

</div>
<div >
    <form action="/editing/comment/${comment.id}" method="post">
        <div class="input-group"><input name="comment" id="textComment" value="${comment.text}" ></div>
        <span class="mark">Your Mark</span>
        <select name="mark" class="mark" >

            <option value="1">1</option>
            <option value="2">2</option>
            <option value="3">3</option>
            <option value="4">4</option>
            <option value="5">5</option>

        </select>
        <button id="addButton" type="submit" >Edit Comment</button>
    </form>

    </div>
</form>
<script src="/resources/js/jquery-3.2.1.min.js"></script>
<script src="/resources/js/homeJS.js"></script>
</body>
</html>

