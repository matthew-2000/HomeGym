<%@ page import="model.Utente" %><%--
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
    <link rel="stylesheet" href="./css/myaccount.css" type="text/css">
    <script src="./scripts/jquery.js"></script>
    <script src="./scripts/myAccount.js"></script>
</head>
<body>

    <%@include file="header.jsp"%>
    <script>
        var isChange = '${isChange}';
        if (isChange) {
            $(document).ready(function () {
                $(".lista_card").css("filter", "blur(5px)");
                $("#check").show();
            });
        }
    </script>

    <div id="check">
        <img src="./images/icons/spuntaBlu.png" id="checkImg">
        <p id="checkTesto">Modifica avvenuta con successo</p>
    </div>

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
    <div id="container-myaccount">
        <div id="box-myaccount">
            <img src="./images/icons/exit.png" id="exit">
            <h1 id="title-myaccount">Il Mio Account</h1>
            <form id="MyAccountForm" action="MyAccountServlet" method="post">
                <input type="hidden" name="id" value="${utente.id}">
                <input type="hidden" name="email" value="${utente.email}">
                <input type="hidden" name="password" value="${utente.passwordHash}">

                <label for="nomeId" id="nomelbl">Nome </label>
                <input type="text" name="nome" id="nomeId" value="${utente.nome}"><br>

                <label for="cognomeId" id="cognomelbl">Cognome </label>
                <input type="text" name="cognome" id="cognomeId" value="${utente.cognome}"><br>

                <label for="indirizzoId" id="indirizzolbl">Indirizzo </label>
                <input type="text" name="indirizzo" id="indirizzoId" value="${utente.via}"><br>

                <label for="capId" id="caplbl">CAP </label>
                <input type="text" name="cap" id="capId" value="${utente.cap}"><br>

                <label for="paeseId" id="paeselbl">Paese </label>
                <input type="text" name="paese" id="paeseId" value="${utente.paese}"><br>

                <label for="telefonoId" id="telefonolbl">Numero di telefono </label>
                <input type="text" name="telefono" id="telefonoId" value="${utente.numero}"><br>

                <button type="button" id="modificaButton">Modifica Account</button>
                <div id="bottoni2">
                    <button type="button" id="annulla">Annulla</button>
                    <input type="submit" value="Salva Modifiche" id="salvaModifiche">
                </div>
            </form>
        </div>
    </div>

    <%@include file="footer.jsp"%>

</body>
</html>
