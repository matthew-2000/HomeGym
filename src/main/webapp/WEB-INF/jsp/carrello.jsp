<%@ page import="model.Carrello" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: jacop
  Date: 01/07/2021
  Time: 11:42
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>HomeGym - Carrello</title>
    <link rel="stylesheet" href="./css/carrello.css">
</head>
<body>

    <%Carrello carrello = (Carrello) session.getAttribute("carrello");%>

    <%@include file="header.jsp"%>

    <h1 id="title">Il mio carrello</h1>

    <div id="container">
        <div id="container-card">
            <c:forEach items="${carrello.prodotti}" var="prodottoCarrello">
                <div class="card">
                    <img src="./images/prodotti/Categoria 1/Gruppo 1 - Manubri e Pesi/KIT MANUBRI BODYBUILDING 20KG FILETTATI/1.png">
                    <div id="container-text">
                        <h3>${prodottoCarrello.prodotto.nome}</h3>
                        <p>${prodottoCarrello.prodotto.prezzo}</p>
                    </div>
                </div>
            </c:forEach>
        </div>
        <div id="container-riepilogo">
            <h2>Dettagli ordine</h2>
            <p>Numero articoli: <%=carrello.getQuantitaTotale()%></p>
            <p>Prezzo totale: <%=carrello.getPrezzoTotale()%>></p>
            <button>Procedi all'acquisto</button>
        </div>
    </div>

    <%@include file="footer.jsp"%>

</body>
</html>
