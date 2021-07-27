<%@ page import="model.Carrello" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>HomeGym - Carrello</title>
    <link rel="icon" href="./images/icons/logo.ico">
    <link rel="stylesheet" href="./css/carrello.css">
</head>
<body>

    <%Carrello carrello = (Carrello) session.getAttribute("carrello");%>

    <%@include file="header.jsp"%>

    <% if (!carrello.getProdotti().isEmpty()) { %>
    <h1 id="title">Il mio carrello</h1>
    <div id="container">
            <div id="container-card">
                <c:forEach items="${carrello.prodotti}" var="prodottoCarrello">
                    <div class="card">
                        <img src="${prodottoCarrello.prodotto.getFirstImmagine()}">
                        <div id="container-text">
                            <h3>${prodottoCarrello.prodotto.nome}</h3>
                            <p>${prodottoCarrello.prodotto.prezzo}€</p>
                            <p>Quantità: ${prodottoCarrello.quantita}</p>
                            <form action="CarrelloServlet" method="post">
                                <input type="hidden" value="${prodottoCarrello.prodotto.id}" name="cancellaProdotto">
                                <button>Rimuovi</button>
                            </form>
                        </div>
                    </div>
                </c:forEach>
            </div>
            <div id="container-riepilogo">
                <h2 style="color: #272559">Dettaglio ordine</h2>
                <p>Numero articoli:<span style="font-weight: bold "> <%=carrello.getQuantitaTotale()%></span></p>
                <p>Prezzo totale: <span style="font-weight: bold "> <%=carrello.getPrezzoTotale()%>€</span></p>
                <c:choose>
                    <c:when test="${sessionScope.isLogged}">
                        <form action="EffettuaOrdineServlet" method="post">
                            <button>Procedi all'acquisto</button>
                        </form>
                    </c:when>
                    <c:otherwise>
                        <form action="LogServlet" method="get">
                            <button>Procedi all'acquisto</button>
                        </form>
                    </c:otherwise>
                </c:choose>
            </div>
        </div>
    <% } else { %>

        <div id="empty-message">
            <h3>Non ci sono articoli nel carrello!</h3>
            <p>Aggiungi gli articoli per effettuare un ordine.</p>
        </div>

    <% } %>

    <%@include file="footer.jsp"%>

</body>
</html>
