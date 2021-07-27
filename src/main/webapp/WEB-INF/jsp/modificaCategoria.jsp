
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>HomeGym - Modifica ${categoria.nome}</title>
    <link rel="stylesheet" href="./css/modificaCategoria.css">
</head>
<body>

    <%@include file="header.jsp"%>

    <div class="card">
        <h1 class="title">Qui puoi modificare la Categoria ${categoria.nome}</h1>
        <form action="SalvaModificheServlet" method="post">
            <input type="hidden" name="id" value="${categoria.id}">

            <label for="nomeId">Nome: </label><br>
            <input type="text" name="nome" id="nomeId" value="${categoria.nome}"><br>

            <label for="descrizioneId">Descrizione: </label><br>
            <input type="text" name="descrizione" id="descrizioneId" value="${categoria.descrizione}"><br>

            <button type="submit" name="azione" value="categoria">Modifica</button>
        </form>
        <button onclick="location.href='${pageContext.request.contextPath}/ModCategorieServlet'">Annulla</button>
    </div>

    <%@include file="footer.jsp"%>
</body>
</html>
