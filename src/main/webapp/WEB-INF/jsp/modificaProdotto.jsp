<%--
  Created by IntelliJ IDEA.
  User: jacop
  Date: 08/07/2021
  Time: 12:58
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
  <title>HomeGym - Modifica ${prodotto.nome}</title>
  <link rel="stylesheet" href="./css/modificaProdotto.css">
</head>
<body>
  <%@include file="header.jsp"%>

  <div class="card">
    <h1 class="title">Qui puoi modificare il Prodotto ${prodotto.nome}</h1>
    <form action="SalvaModificheServlet" method="post">
      <input type="hidden" name="id" value="${prodotto.id}">

      <label for="nomeId">Nome: </label><br>
      <input type="text" name="nomeProdotto" id="nomeId" value="${prodotto.nome}"><br>

      <label for="prezzoId">Prezzo: </label><br>
      <input type="text" name="prezzoProdotto" id="prezzoId" value="${prodotto.prezzo}"><br>

      <label for="descrizioneId">Descrizione: </label><br>
      <input type="text" name="descrizioneProdotto" id="descrizioneId" value="${prodotto.descrizione}"> <br>

      <label for="gruppoId">ID Gruppo</label><br>
      <input type="text" name="idGruppo" id="gruppoId" value="${prodotto.idGruppo}"><br>

      <button type="submit" name="azione" value="prodotto">Modifica</button>
    </form>
    <button onclick="location.href='${pageContext.request.contextPath}/ModProdottiServlet'">Annulla</button>
  </div>

  <%@include file="footer.jsp"%>
</body>
</html>
