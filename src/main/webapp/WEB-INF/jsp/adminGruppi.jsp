<%--
  Created by IntelliJ IDEA.
  User: jacop
  Date: 07/07/2021
  Time: 12:56
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
  <title>HomeGym - Gestione Gruppi</title>
  <link rel="icon" href="./images/icons/logo.ico">
  <link rel="stylesheet" href="./css/adminGruppi.css">

  <script src="./scripts/jquery.js"></script>
  <script src="./scripts/adminGruppi.js"></script>
</head>
<body>
  <%@include file="header.jsp"%>

  <div class="card">
    <h2>Qui puoi modificare, aggiungere o eliminare un Gruppo</h2>
    <div class="bottoni">
      <button id="aggiungiGruppo">Aggiungi Gruppo</button>
      <button id="modificaGruppo">Modifica Gruppo</button>
      <button id="eliminaGruppo">Elimina Gruppo</button>
    </div>

    <div id="aggiungi-gruppo">
      <form action="ModificaGruppoServlet" method="post">
        <p>Nome: </p>
        <input type="text" name="nomeGruppo" id="nomeId" required><br>

        <p>ID Categoria: </p>
        <input type="text" name="idCategoria" id="categoriaId" required><br>
        <button class="confermaModifiche" type="submit" name="azione" value="aggiungi">Conferma</button>
      </form>
      <button class="annullaModifiche">Annulla</button>
    </div>

    <div id="modifica-gruppo">
      <table>
        <tr>
          <th>ID</th>
          <th>Nome</th>
          <th>ID Categoria</th>
        </tr>

        <c:forEach items="${gruppi}" var="gruppo">
          <tr>
            <td>${gruppo.id}</td>
            <td>${gruppo.nome}</td>
            <td>${gruppo.idCategoria}</td>
            <td>
              <form action="ModificaGruppoServlet" method="post">
                <input type="hidden" value="${gruppo.id}" name="id">
                <button name="azione" value="modifica">-></button>
              </form>
            </td>
          </tr>
        </c:forEach>
      </table>
      <button class="annullaModifiche">Annulla</button>
    </div>

    <div id="elimina-gruppo">
      <table>
        <tr>
          <th>ID</th>
          <th>Nome</th>
          <th>ID Categoria</th>
        </tr>

        <c:forEach items="${gruppi}" var="gruppo">
          <tr>
            <td>${gruppo.id}</td>
            <td>${gruppo.nome}</td>
            <td>${gruppo.idCategoria}</td>
            <td>
              <form action="ModificaGruppoServlet" method="post">
                <input type="hidden" value="${gruppo.id}" name="id">
                <button name="azione" value="elimina">-></button>
              </form>
            </td>
          </tr>
        </c:forEach>
      </table>
      <button class="annullaModifiche">Annulla</button>
    </div>
  </div>

  <%@include file="footer.jsp"%>
</body>
</html>
