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
   <!-- <script type="text/javascript" src="formRegistration.js"></script> -->

</head>
<body>
    <%@include file="header.jsp"%>>

    <script>
        function mostra(){
            document.getElementById("altro").style.display="block";
        }

        function nascondi(){
            document.getElementById("email-pass").style.display="none";
        }


        function validate(){
            var email = document.getElementById("emailId");
            var password = document.getElementById("passwordId");
            var repeat = document.getElementById("repeatId");
            var errorMessage = document.getElementById("errorMessage")

            if(email.value == "" || password.value == "" || repeat.value == ""){
                errorMessage.innerHTML = "Inserisci tutti gli elementi"

                if(email.value == ""){
                    email.focus();
                    email.style.borderColor = "red";
                }

                if(password.value == ""){
                    password.focus();
                    password.style.borderColor = "red";
                }

                if(repeat.value == ""){
                    repeat.focus();
                    repeat.style.borderColor = "red";
                }
            }
            if(password.value == repeat.value){
                mostra();
                nascondi();
            }

        }
    </script>


    <div class="container-registrazione">
        <div class="box">
            <h1 id="title">Registrazione</h1>
            <form action="RegistrazioneServlet" method="post">
                <div id="errorMessage"></div>
                <div id="email-pass">
                    <input type="email" id="emailId" name="email" placeholder="E-mail"><br>
                    <input type="password" id="passwordId" name="password" placeholder="Password"><br>
                    <input type="password" id="repeatId" name="repeat" placeholder="Ripeti password">
                    <input type="button" id="buttonId" value="Continua" onclick="validate()">
                </div>
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
