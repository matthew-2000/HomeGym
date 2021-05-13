<%--
  Created by IntelliJ IDEA.
  User: jacop
  Date: 13/05/2021
  Time: 12:09
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>HomeGym - Account</title>
    <link rel="stylesheet" href="./css/header.css" type="text/css">
    <link rel="stylesheet" href="./css/account.css" type="text/css">
</head>
<body>
    <%@include file="header.jsp"%>

    <%String log = "Login";%>
    <%if(isLogged == true){
        log = "Logout";
    }%>


    <section class="lista_card">
        <h1 id="title">Account</h1>
        <div class="container-card">

            <div class="card">
                <h1 class="nome-card">Il mio Account</h1>
                <p class="descrizione">Qui puoi visualizzare tutti i dati del tuo account</p>
                <img src="./images/prodotti/Categoria 1/Gruppo 1 - Manubri e Pesi/KIT MANUBRI BODYBUILDING 20KG FILETTATI/1.png">
                <button class="visualizza">Visualizza</button>
            </div>

            <div class="card">
                <h1 class="nome-card">I miei ordini</h1>
                <p class="descrizione">Qui puoi visualizzare tutti i tuoi ordini</p>
                <img src="./images/prodotti/Categoria 1/Gruppo 1 - Manubri e Pesi/KIT MANUBRI BODYBUILDING 20KG FILETTATI/1.png">
                <button class="visualizza">Visualizza</button>
            </div>

            <div class="card">
                <h1 class="nome-card">Lista Desideri</h1>
                <p class="descrizione">Qui puoi visualizzare la tua lista dei desideri</p>
                <img src="./images/prodotti/Categoria 1/Gruppo 1 - Manubri e Pesi/KIT MANUBRI BODYBUILDING 20KG FILETTATI/1.png">
                <button class="visualizza">Visualizza</button>
            </div>

            <div class="card">
                <h1 class="nome-card"><%=log%></h1>
                <p class="descrizione">Qui puoi effettuare il <%=log%></p>
                <img src="./images/prodotti/Categoria 1/Gruppo 1 - Manubri e Pesi/KIT MANUBRI BODYBUILDING 20KG FILETTATI/1.png">
                <button class="visualizza">Visualizza</button>
            </div>

        </div>
    </section>

</body>
</html>
