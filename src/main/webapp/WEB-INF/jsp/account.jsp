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

    <section class="lista_card">
        <h1 id="title">Account</h1>
        <div class="container-card">

            <div class="card" id="accountCard">
                <h1 class="nome-card">Il mio Account</h1>
                <p class="descrizione">Qui puoi visualizzare tutti i dati del tuo account</p>
                <img src="./images/icons/account.png">
            </div>

            <div class="card" id="ordiniCard">
                <h1 class="nome-card">I miei ordini</h1>
                <p class="descrizione">Qui puoi visualizzare tutti i tuoi ordini</p>
                <img src="./images/icons/orders.png">
            </div>

            <div class="card" id="listaDesideriCard">
                <h1 class="nome-card">Lista Desideri</h1>
                <p class="descrizione">Qui puoi visualizzare la tua lista dei desideri</p>
                <img src="./images/icons/wishlist.png">
            </div>

            <div class="card" id="logoutCard">
                <h1 class="nome-card">Logout</h1>
                <p class="descrizione">Qui puoi effettuare il logout</p>
                <img src="./images/icons/logout.png">
            </div>

        </div>
    </section>

    <%@include file="footer.jsp"%>

</body>
</html>
