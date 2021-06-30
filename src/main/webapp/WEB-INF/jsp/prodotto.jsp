<%--
  Created by IntelliJ IDEA.
  User: matteo
  Date: 14/06/21
  Time: 17:40
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>HomeGym - ${prodotto.nome}</title>
    <link rel="stylesheet" href="./css/prodotto.css" type="text/css">
</head>
<body>

    <%@include file="header.jsp"%>

    <div class="card">
        <div id="container">
            <div id="immagine">
                <img src="./images/prodotti/Categoria 1/Gruppo 1 - Manubri e Pesi/KIT MANUBRI BODYBUILDING 20KG FILETTATI/1.png">
            </div>

            <div id="prodotto">
                <h1>${prodotto.nome}</h1>
                <p>Prezzo: ${prodotto.prezzo}</p>
                <p>Disponibilità: ${prodotto.quantita}</p>
                <button>Aggiungi al Carrello</button>
            </div>
        </div>

        <div id="container-descrizione">
            <h3>Descrizione prodotto: </h3>
            <br>
            <p>${prodotto.descrizione}</p>
        </div>
    </div>

    <%@include file="footer.jsp"%>
</body>
</html>
