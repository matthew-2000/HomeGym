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
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>HomeGym - Categorie</title>
    <link rel="stylesheet" href="./css/categorie.css" type="text/css">
</head>
<body>

    <%@include file="header.jsp"%>

    <%int count = 1;%>
    <%List<Gruppo> listaGruppi = GruppoDAO.doRetrieveAll();%>

    <div class="container-categorie">
        <div class="box">
            <h2>Categorie HomeGym</h2>

                <c:forEach items="${categorie}" var="categoria">
                    <div class="categoria">
                            <form>
                                <input type="hidden" name="idCategoria" value="${categoria.id}">
                                <h3><span><%=count%></span>${categoria.nome}</h3>
                                <p>${categoria.descrizione}</p>
                                <ul>
                                    <form>
                                        <input type="hidden" name="gruppoId" value="${gruppo.id}">
                                        <li><a href="#">Gruppo</a></li>
                                    </form>

                                </ul>
                            </form>
                            <%count++;%>
                    </div>
                </c:forEach>




        </div>

    </div>


    <%@include file="footer.jsp"%>

</body>
</html>
