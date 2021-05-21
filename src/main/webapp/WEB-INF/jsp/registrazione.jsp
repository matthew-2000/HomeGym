<%--
  Created by IntelliJ IDEA.
  User: jacop
  Date: 18/05/2021
  Time: 16:49
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Home Gym - Registrazione</title>
    <link rel="stylesheet" href="./css/registrazione.css" type="text/css">
    <script type="text/javascript" src="formRegistration.js"></script>

</head>
<body>
    <%@include file="header.jsp"%>>


    <div class="container-registrazione" >
        <div class="box">
            <h1 id="title">Registrazione</h1>
            <form class="email-pass" name="emailPass">
                <div id="errorMessage"></div>
                <input type="email" id="emailId" name="email" placeholder="E-mail"><br>
                <input type="password" id="passwordId" name="password" placeholder="Password"><br>
                <input type="password" id="repeatId" name="repeat" placeholder="Ripeti password">
                <input type="button" id="buttonId" value="Continua" onclick="validate()">
                <div id="altro">
                    <input type="text" id="nomeId" name="nome" placeholder="Nome">
                    <input type="text" id="cognomeId" name="cognome" placeholder="Cognome">
                    <input type="text" id="viaId" name="via" placeholder="Via">
                    <input type="number" id="capId" name="cap" placeholder="CAP">
                    <input type="text" id="paeseId" name="paese" placeholder="Paese">
                    <input type="number" id="numeroId" name="numero" placeholder="Numero di Telefono">
                    <input type="submit" value="Completa">
                </div>
            </form>

        </div>
    </div>
</body>
</html>
