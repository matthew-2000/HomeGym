
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>HomeGym - Gestione Categorie</title>
    <link rel="icon" href="./images/icons/logo.ico">
    <link rel="stylesheet" href="./css/adminCategorie.css">

    <script src="./scripts/jquery.js"></script>
    <script src="./scripts/adminCategorie.js"></script>
</head>
<body>

    <%@include file="header.jsp"%>

    <div class="card">
        <h2>Qui puoi modificare, aggiungere o eliminare una categoria</h2>
        <div class="bottoni">
            <button id="aggiungiCategoria">Aggiungi Categoria</button>
            <button id="modificaCategoria">Modifica Categoria</button>
            <button id="eliminaCategoria">Elimina Categoria</button>
        </div>

        <div id="aggiungi-categoria">
            <form action="ModificaCategoriaServlet" method="post">
                <p>Nome: </p>
                <input type="text" name="nomeCategoria" id="nomeId" required><br>

                <p>Descrizione: </p>
                <textarea name="descrizioneCategoria" id="descrizioneId" required></textarea> <br>
                <button class="confermaModifiche" type="submit" name="azione" value="aggiungi">Conferma</button>
            </form>
            <button class="annullaModifiche">Annulla</button>
        </div>

        <div id="modifica-categoria">
            <table>
                <tr>
                    <th>ID</th>
                    <th>Nome</th>
                    <th>Descrizione</th>
                </tr>

                <c:forEach items="${cat}" var="cat">
                    <tr>
                        <td>${cat.id}</td>
                        <td>${cat.nome}</td>
                        <td>${cat.descrizione}</td>
                        <td>
                            <form action="ModificaCategoriaServlet" method="post">
                                <input type="hidden" value="${cat.id}" name="id">
                                <button style="min-width: 60px" name="azione" value="modifica">-></button>
                            </form>
                        </td>
                    </tr>
                </c:forEach>
            </table>
            <button class="annullaModifiche">Annulla</button>
        </div>

        <div id="elimina-categoria">
            <table>
                <tr>
                    <th>ID</th>
                    <th>Nome</th>
                    <th>Descrizione</th>
                </tr>

                <c:forEach items="${cat}" var="cat">
                    <tr>
                        <td>${cat.id}</td>
                        <td>${cat.nome}</td>
                        <td>${cat.descrizione}</td>
                        <td>
                            <form action="ModificaCategoriaServlet" method="post">
                                <input type="hidden" value="${cat.id}" name="id">
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
