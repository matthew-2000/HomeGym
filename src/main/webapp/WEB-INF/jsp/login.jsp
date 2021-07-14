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
    <link rel="icon" href="./images/icons/logo.ico">
    <link rel="stylesheet" href="./css/login.css" type="text/css">
</head>
<body>
    <%@include file="header.jsp"%>


    <div class="container-login">
        <div class="box">
            <h1 id="title">Login</h1>
            <form action="LoginServlet" method="post" onsubmit="return validate()">
                <input type="email" id="emailId" name="email" placeholder="E-mail" required><br>
                <input type="password" id="passwordId" name="password" placeholder="Password" required><br>
                <p id="registrati"><a href="${pageContext.request.contextPath}/RegServlet">Non sei ancora registrato? Registrati ora</a></p>
                <input type="submit" value="Login">
            </form>
        </div>

    </div>

<script>

    function validate() {
        var email = document.getElementById("emailId").value;

        var emailRegEx = /^[\w-\.]+@([\w-]+\.)+[\w-]{2,4}$/;
        var emailResult = emailRegEx.test(email);


        var password = document.getElementById("passwordId").value;
        var passwordRegEx = /^(?=.*[A-Za-z])(?=.*\d)[A-Za-z\d]{8,}$/; //Minimum eight characters, at least one letter and one number

        var passwordResult = passwordRegEx.test(password);

        if (!emailResult) {
            alert("Email non valida!");
            return false;
        }

        if (!passwordResult) {
            alert("Password non valida!");
            return false
        }

        return true
    }

</script>
</body>
</html>
