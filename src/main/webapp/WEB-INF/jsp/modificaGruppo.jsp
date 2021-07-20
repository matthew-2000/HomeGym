<%--
  Created by IntelliJ IDEA.
  User: jacop
  Date: 07/07/2021
  Time: 17:20
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>HomeGym - Modifica ${gruppo.nome}</title>
    <link rel="stylesheet" href="./css/modificaGruppo.css">
</head>
<body>
    <%@include file="header.jsp"%>

    <div class="card">
        <h1 class="title">Qui puoi modificare il Gruppo ${gruppo.nome}</h1>
        <form action="SalvaModificheServlet" method="get">
            <input type="hidden" name="id" value="${gruppo.id}">

            <label for="nomeId">Nome: </label><br>
            <input type="text" name="nome" id="nomeId" value="${gruppo.nome}"><br>

            <label for="categoriaId">ID Categoria: </label><br>
            <input type="text" name="idCategoria" id="categoriaId" value="${gruppo.idCategoria}"><br>

            <button type="submit" name="azione" value="gruppo">Modifica</button>
        </form>
        <button onclick="location.href='${pageContext.request.contextPath}/ModGruppiServlet'">Annulla</button>
    </div>

    <%@include file="footer.jsp"%>
</body>
</html>
