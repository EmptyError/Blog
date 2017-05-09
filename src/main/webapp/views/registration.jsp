<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 28.04.2017
  Time: 2:40
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <link rel="stylesheet" href="/resources/css/loginStyle.css">
</head>
<body>
<div class="registerForm">
    <form method="post" action="/registrationProcessing">
    <div id="errorMessages"></div>
    <div class="input-group">
        <input id="firstName" type="text" name="firstName" placeholder="First Name">
    </div>
    <div class="input-group"><input  id="secondName"  type="text" name="secondName" placeholder="Second Name"></div>
    <div class="input-group">
        <input   type="password" id="passwordUser" name="password" placeholder="Password">
    </div>
    <div  class="input-group"><input id="email" type="text" placeholder="Email" name="email"></div>
    <div class="input-group"><input  id="loginUser"  type="text" placeholder="Login" name="login"></div>
    <div  class="input-group"><input  id="phone"  type="text" placeholder="Phone" name="phone"></div>
    <button type="submit" >Register</button>
    </form>

    <a href="/loginPage">LogIn</a>
</div>

<script src="/resources/js/jquery-3.2.1.min.js"></script>
<script  src="/resources/js/loginJS.js"></script>

</div>
</body>
</html>
