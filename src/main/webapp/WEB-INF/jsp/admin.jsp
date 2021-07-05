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
    <link rel="stylesheet" href="./css/admin.css">
    <script src="./scripts/jquery.js"></script>
    <script src="./scripts/adminGestore.js"></script>
</head>
<body>

    <%@include file="header.jsp"%>
    <div class="card">

        <select id="scelta">
            <option value="" disabled selected hidden>Scegli cosa vuoi modificare...</option>
            <option value="categorie">Categorie</option>
            <option value="gruppi">Gruppi</option>
            <option value="prodotti">Prodotti</option>
        </select>

        <div id="container-gestoreCategorie">
            <form>
                Div Categorie
                <input type="submit" value="Modifica">
            </form>
        </div>

        <div id="container-gestoreGruppi">
            <form>
                Div Gruppi
                <input type="submit" value="Modifica">
            </form>
        </div>

        <div id="container-gestoreProdotti">
            <form>
                Div Prodotti
                <input type="submit" value="Modifica">
            </form>
        </div>

    </div>

    <%@include file="footer.jsp"%>
</body>
</html>
