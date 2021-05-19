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


    <div class="box">
        <h1 id="title">Benvenuto, accedi per acquistare i nostri prodotti!</h1>
        <form>
            <input type="email" id="emailId" name="email" placeholder="Email"><br>
            <input type="password" id="passwordId" name="password" placeholder="Password"><br>
            <input type="submit" value="Accedi">
        </form>
        <p id="registrati">Non sei ancora registrato? <a href="#">Registrati ora</a></p>
    </div>

    <%@include file="footer.jsp"%>

</body>
</html>
