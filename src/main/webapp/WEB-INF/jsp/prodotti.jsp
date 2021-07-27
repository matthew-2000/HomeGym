
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>HomeGym - ${gruppo.nome}</title>
    <link rel="icon" href="./images/icons/logo.ico">
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


    <%@include file="footer.jsp"%>
</body>
</html>
