
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>HomeGym - Lista Desideri</title>
    <link rel="icon" href="./images/icons/logo.ico">
    <link rel="stylesheet" href="./css/listaProdotti.css" type="text/css">
</head>
<body>

<%@include file="header.jsp"%>

<c:choose>
    <c:when test="${desideri.isEmpty()}">
        <div id="empty-message">
            <h3>Non ci sono articoli nella lista desideri!</h3>
            <p>Aggiungi gli articoli che più desideri per visualizzare la lista.</p>
        </div>
    </c:when>

    <c:otherwise>
        <section class="lista_prodotti">
            <h1 id="title">La tua lista desideri</h1>

            <div class="container-prodotti">
                <c:forEach items="${desideri}" var="prodotto">
                    <div class="card">
                        <h1 id="nome-prodotto">${prodotto.nome}</h1>
                        <p class="descrizione">${prodotto.descrizione}</p>
                        <img src="${prodotto.getFirstImmagine()}">
                        <p class="price">€${prodotto.prezzo}</p>
                        <div id="button-container">
                            <form action="ProdottoServlet" method="get">
                                <button type="submit" id="visualizza" value="${prodotto.id}" name="idProdotto">Visualizza</button>
                            </form>
                            <form action="RimuoviListaDesideriServlet" method="post">
                                <button type="submit" id="aggiungi" value="${prodotto.id}" name="idProdotto">Rimuovi</button>
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
