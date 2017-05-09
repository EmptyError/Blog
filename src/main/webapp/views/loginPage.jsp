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
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
</head>
<body  class="background">

<div class="login">
    <form method="post" action="/loginProcessing" >

    <div class="input-group">
        <i class=" fa fa-user-circle"></i>
         <input id="username" type="text" name="username" placeholder="Login">
    </div>

        <div class="input-group"><i class="fa fa-unlock-alt  "></i>
        <input  id="password" type="password" name="password" placeholder="Password">
    </div>
    <button id="logIn" type="submit">LogIn</button>
    </form>
    <div id="register">Have no Profile?<span> Register</span></div>
</div>
<div class="registerForm">
    <%--<form method="post" action="/registrationProcessing">--%>
        <div id="errorMessages"></div>
        <div class="input-group">
            <input id="firstName" type="text" name="firstName" placeholder="First Name">
        </div>
        <div class="input-group"><input  id="secondName"  type="text" name="secondName" placeholder="Second Name"></div>

        <div class="input-group"><i class="fa fa-key fa-fw"></i>
            <input   type="password" id="passwordUser" name="password" placeholder="Password">
        </div>

        <div  class="input-group"><i class="fa fa-envelope-o fa-fw"></i>
            <input id="email" type="text" placeholder="Email" name="email"></div>
        <div class="input-group"><input  id="loginUser"  type="text" placeholder="Login" name="login"></div>
        <div  class="input-group"><i class="fa fa-phone" aria-hidden="true"></i><input  id="phone"  type="text" placeholder="Phone" name="phone"></div>
        <button id="registerButton" >Register</button>
    <%--</form>--%>
    <div id="singIn">Login</div>
</div>

<script src="/resources/js/jquery-3.2.1.min.js"></script>
<script  src="/resources/js/loginJS.js"></script>
</body>
</html>
