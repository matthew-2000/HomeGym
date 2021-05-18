<%--
  Created by IntelliJ IDEA.
  User: jacop
  Date: 13/05/2021
  Time: 16:15
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>HomeGym - Login</title>
    <link rel="stylesheet" href="./css/login.css" type="text/css">
</head>
<body>
    <%@include file="header.jsp"%>


    <div class="container-login">
        <div class="box">
            <h1 id="title">Login</h1>
            <form>
                <input type="email" id="emailId" name="email" placeholder="E-mail"><br>
                <input type="password" id="passwordId" name="password" placeholder="Password"><br>
                <p id="registrati"><a href="#">Non sei ancora registrato? Registrati ora</a></p>
                <input type="submit" value="Login">
            </form>
        </div>

    </div>
</body>
</html>
