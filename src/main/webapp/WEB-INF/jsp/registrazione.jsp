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
    <link rel="icon" href="./images/icons/logo.ico">
    <link rel="stylesheet" href="./css/registrazione.css" type="text/css">
    <script type="application/javascript" src="./scripts/validation.js"></script>
</head>
<body>
    <%@include file="header.jsp"%>

    <div class="container-registrazione">
        <div class="box">
            <h1 id="title">Registrazione</h1>
            <form action="RegistrazioneServlet" method="post" onsubmit="return registrazioneValidate()">
                <div id="errorMessage"></div>
                <div id="email-pass">
                    <input type="email" id="emailId" name="email" placeholder="E-mail" required><br>
                    <input type="password" id="passwordId" name="password" placeholder="Password" required><br>
                    <input type="password" id="repeatId" name="repeat" placeholder="Ripeti password" required>
                    <input type="button" id="buttonId" value="Continua" onclick="check()">
                </div>
                <div id="altro">
                    <input type="text" id="nomeId" name="nome" placeholder="Nome" required>
                    <input type="text" id="cognomeId" name="cognome" placeholder="Cognome" required>
                    <input type="text" id="viaId" name="via" placeholder="Via" required>
                    <input type="number" id="capId" name="cap" placeholder="CAP" required>
                    <input type="text" id="paeseId" name="paese" placeholder="Paese" required>
                    <input type="tel" id="numeroId" name="numero" placeholder="Numero di Telefono" required>
                    <input type="submit" value="Completa">
                </div>
            </form>

        </div>
    </div>
</body>
</html>
