<%--
  Created by IntelliJ IDEA.
  User: matteo
  Date: 13/07/21
  Time: 15:38
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>HomeGym - Ordini</title>
    <link rel="icon" href="./images/icons/logo.ico">
    <link rel="stylesheet" href="./css/ordini.css" type="text/css">
</head>
<body>

<%@include file="header.jsp"%>

<c:choose>
    <c:when test="${ordini.isEmpty()}">
        <div id="empty-message">
            <h3>Non ci sono ordini effettuati!</h3>
            <p>Effettua almeno un ordine e potrai visualizzare qui il suo stato.</p>
        </div>
    </c:when>
    <c:otherwise>
        <section class="lista-ordini">
            <h1 id="title">I tuoi ordini</h1>

            <div class="container-ordini">
                <c:forEach items="${ordini}" var="ordine">
                    <h3>Ordine n.${ordine.id}</h3>
                    <div class="card-ordine">
                        <c:forEach items="${ordine.prodotti}" var="prodottoCarrello">
                            <div class="card-prodotto">
                                <img src="${prodottoCarrello.prodotto.getFirstImmagine()}">
                                <div id="container-text">
                                    <h3>${prodottoCarrello.prodotto.nome}</h3>
                                    <p>${prodottoCarrello.prodotto.prezzo}€</p>
                                    <p>Quantità: ${prodottoCarrello.quantita}</p>
                                </div>
                            </div>
                        </c:forEach>

                        <div id="container-riepilogo">
                            <h2 style="color: #272559">Dettaglio ordine</h2>
                            <p>Data ordine:<span style="font-weight: bold "> ${ordine.dataOrdine}</span></p>
                            <p>Prezzo totale: <span style="font-weight: bold ">${ordine.getPrezzoTotale()}€</span></p>

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
