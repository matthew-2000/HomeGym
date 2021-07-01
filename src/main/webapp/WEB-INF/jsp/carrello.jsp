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

    <%int count = 0;%>
    <script>

        var totPrezzo = 0;
    </script>
    <%@include file="header.jsp"%>

    <div class="container-card">
        <c:forEach items="${prodottiCarrello}" var="prodotto">
            <div class="card">
                <img src="./images/prodotti/Categoria 1/Gruppo 1 - Manubri e Pesi/KIT MANUBRI BODYBUILDING 20KG FILETTATI/1.png">
                <div id="container-text">
                    <h3>${prodotto.nome}</h3>
                    <p>${prodotto.prezzo}</p>
                </div>
            </div>
            <%count++;%>
            <script>
                totPrezzo += ${prodotto.prezzo};
            </script>
        </c:forEach>
        <div class="riepilogo">
            <h2>Dettagli ordine</h2>
            <p>Numero articoli: <%=count%></p>
            <p>Prezzo totale: DA CALCOLARE</p>
            <button>Procedi all'acquisto</button>
        </div>
    </div>


    <%@include file="footer.jsp"%>
</body>
</html>
