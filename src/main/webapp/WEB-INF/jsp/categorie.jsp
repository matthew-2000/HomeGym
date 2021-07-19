<%@ page import="model.Gruppo" %>
<%@ page import="model.GruppoDAO" %>
<%@ page import="java.util.List" %><%--
  Created by IntelliJ IDEA.
  User: jacop
  Date: 14/05/2021
  Time: 17:25
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>HomeGym - Categorie</title>
    <link rel="icon" href="./images/icons/logo.ico">
    <link rel="stylesheet" href="./css/categorie.css" type="text/css">
</head>
<body>

    <%@include file="header.jsp"%>

    <%int count = 1;%>

    <h1 id="title">Lista categorie</h1>

    <div class="container-categorie">

        <div class="box">

                <c:forEach items="${categorie}" var="categoria">
                    <div class="categoria">

                                <h3><span><%=count%></span>${categoria.nome}</h3>
                                <br><p>${categoria.descrizione}</p><br>

                                <ul>
                                    <c:forEach items="${categoria.listaGruppi}" var="gruppo">
                                        <li>
                                            <form action="GruppoServlet" method="get">
                                                <input type="hidden" name="categoriaId" value="${categoria.id}">
                                                <input type="hidden" name="gruppoId" value="${gruppo.id}">
                                                <input id="gruppo-button" type="submit" value="${gruppo.nome}">
                                            </form>
                                        </li>
                                    </c:forEach>

                                </ul>

                            <%count++;%>
                    </div>
                </c:forEach>

        </div>

    </div>

    <%@include file="footer.jsp"%>

</body>
</html>
