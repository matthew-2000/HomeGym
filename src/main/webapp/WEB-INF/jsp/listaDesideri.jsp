<%--
  Created by IntelliJ IDEA.
  User: matteo
  Date: 05/07/21
  Time: 16:10
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>HomeGym - Lista Desideri</title>
    <link rel="icon" href="./images/icons/logo.ico">
    <link rel="stylesheet" href="./css/listaProdotti.css" type="text/css">
</head>
<body>

<%@include file="header.jsp"%>

<section class="lista_prodotti">
    <h1 id="title">La tua lista desideri</h1>

    <div class="container-prodotti">
        <c:forEach items="${desideri}" var="prodotto">
            <div class="card">
                <form action="ProdottoServlet" method="post">
                    <h1 id="nome-prodotto">${prodotto.nome}</h1>
                    <p class="descrizione">${prodotto.descrizione}</p>
                    <img src="./images/prodotti/Categoria 1/Gruppo 1 - Manubri e Pesi/KIT MANUBRI BODYBUILDING 20KG FILETTATI/1.png">
                    <p class="price">€${prodotto.prezzo}</p>
                    <button type="submit" id="visualizza" value="${prodotto.id}" name="idProdotto">Visualizza</button>
                    <button id="aggiungi">Aggiungi</button>
                </form>
            </div>
        </c:forEach>
    </div>
</section>


<%@include file="footer.jsp"%>

</body>
</html>
