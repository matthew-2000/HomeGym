<%--
  Created by IntelliJ IDEA.
  User: jacop
  Date: 05/07/2021
  Time: 17:36
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>HomeGym - Gestione</title>
    <link rel="icon" href="./images/icons/logo.ico">
    <link rel="stylesheet" href="./css/admin.css">
</head>
<body>

    <%@include file="header.jsp"%>
    <div class="container-card">
        <div class="card">
            <h1>Gestisci Categorie</h1>
            <p>Qui puoi modificare le categorie</p>
            <a href="${pageContext.request.contextPath}/ModCategorieServlet"><img src="./images/icons/categorie.png"></a>
        </div>
        <div class="card">
            <h1>Gestisci Gruppi</h1>
            <p>Qui puoi modificare i gruppi</p>
            <a href="${pageContext.request.contextPath}/ModGruppiServlet"><img src="./images/icons/gruppi.png"></a>
        </div>
        <div class="card">
            <h1>Gestisci Prodotti</h1>
            <p>Qui puoi modificare i prodotti</p>
            <a href="${pageContext.request.contextPath}/ModProdottiServlet"><img src="./images/icons/prodotti.png"></a>
        </div>
    </div>

    <%@include file="footer.jsp"%>
</body>
</html>
