<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>HomeGym</title>
    <link rel="icon" href="./images/icons/logo.ico">
    <link rel="stylesheet" href="./css/header.css" type="text/css">
    <link rel="stylesheet" href="./css/index.css" type="text/css">
    <link rel="stylesheet" href="./css/listaProdotti.css" type="text/css">
    <link rel="stylesheet" href="./css/footer.css">
</head>
<body>

    <%@include file="header.jsp"%>

    <br>

    <div class="landing-page">

        <img id="home-image" src="./images/sliderIndex/allenamento1.jpg">
        <div id="image-text-div">
            <h1>HomeGym, la palestra a casa tua.</h1>
            <p>Scopri tutti gli attrezzi per migliorare il tuo benessere fisico e psicologico.</p>
            <a href="#title">Visualizza prodotti</a>
        </div>

    </div>

    <br>

    <section class="lista_prodotti">
        <h1 id="title">I più venduti</h1>
        <div class="container-prodotti">

            <c:forEach items="${venduti}" var="venduto">
                <div class="card">
                    <h1 id="nome-prodotto">${venduto.nome}</h1>
                    <p class="descrizione">${venduto.descrizione}</p>
                    <img src="${venduto.getFirstImmagine()}">
                    <p class="price">€${venduto.prezzo}</p>
                    <div id="button-container">
                        <form action="ProdottoServlet" method="get">
                            <button type="submit" id="visualizza" value="${venduto.id}" name="idProdotto">Visualizza</button>
                        </form>
                        <form action="AggiungiCarrelloServlet" method="post">
                            <button type="submit" id="aggiungi" value="${venduto.id}" name="idProdotto">Aggiungi</button>
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