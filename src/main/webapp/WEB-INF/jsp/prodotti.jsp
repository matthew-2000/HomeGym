<%--
  Created by IntelliJ IDEA.
  User: jacop
  Date: 11/06/2021
  Time: 15:55
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>HomeGym - ${gruppo.nome}</title>
    <link rel="stylesheet" href="./css/listaProdotti.css" type="text/css">
</head>
<body>
    <%@include file="header.jsp"%>


    <section class="lista_prodotti">
        <h1 id="title">${gruppo.nome} - Prodotti</h1>
        <div class="container-prodotti">

            <c:forEach items="${prodotti}" var="prodotto">
                <div class="card">
                    <h1 id="nome-prodotto">${prodotto.nome}</h1>
                    <p class="descrizione">${prodotto.descrizione}</p>
                    <img src="./images/prodotti/Categoria 1/Gruppo 1 - Manubri e Pesi/KIT MANUBRI BODYBUILDING 20KG FILETTATI/1.png">
                    <p class="price">€${prodotto.prezzo}</p>
                    <button id="visualizza">Visualizza</button>
                    <button id="aggiungi">Aggiungi</button>
                </div>
            </c:forEach>

        </div>
    </section>


    <%@include file="footer.jsp"%>
</body>
</html>
