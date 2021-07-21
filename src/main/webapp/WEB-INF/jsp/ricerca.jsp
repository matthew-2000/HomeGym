<%--
  Created by IntelliJ IDEA.
  User: matteo
  Date: 13/07/21
  Time: 12:07
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>HomeGym - Ricerca</title>
    <link rel="icon" href="./images/icons/logo.ico">
    <link rel="stylesheet" href="./css/listaProdotti.css" type="text/css">
</head>
<body>

<%@include file="header.jsp"%>

<c:choose>
    <c:when test="${prodottiTrovati.isEmpty()}">
        <div id="empty-message">
            <h3>Non abbiamo trovato nessun articolo che corrisponde alla ricerca!</h3>
            <p>Prova a utillizare i suggerimenti.</p>
        </div>
    </c:when>
    <c:otherwise>
        <section class="lista_prodotti">
            <h1 id="title">Risultati della ricerca</h1>

            <div class="container-prodotti">
                <c:forEach items="${prodottiTrovati}" var="prodotto">
                    <div class="card">
                        <h1 id="nome-prodotto">${prodotto.nome}</h1>
                        <p class="descrizione">${prodotto.descrizione}</p>
                        <img src="${prodotto.getFirstImmagine()}">
                        <p class="price">€${prodotto.prezzo}</p>
                        <div id="button-container">
                            <form action="ProdottoServlet" method="get">
                                <button type="submit" id="visualizza" value="${prodotto.id}" name="idProdotto">Visualizza</button>
                            </form>
                            <form action="AggiungiCarrelloServlet" method="post">
                                <button type="submit" id="aggiungi" value="${prodotto.id}" name="idProdotto">Aggiungi</button>
                                <input type="hidden" value="1" name="quantita">
                            </form>
                        </div>
                    </div>
                </c:forEach>
            </div>
        </section>
    </c:otherwise>
</c:choose>

<%@include file="footer.jsp"%>

</body>
</html>
