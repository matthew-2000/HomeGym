
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>HomeGym - Gestione Prodotti</title>
    <link rel="icon" href="./images/icons/logo.ico">
    <link rel="stylesheet" href="./css/adminProdotti.css">

    <script src="./scripts/jquery.js"></script>
    <script src="./scripts/adminProdotti.js"></script>
</head>
<body>
    <%@include file="header.jsp"%>

    <div class="card">
        <h2>Qui puoi modificare, aggiungere o eliminare i Prodotti</h2>
        <div class="bottoni">
            <button id="aggiungiProdotto">Aggiungi Prodotto</button>
            <button id="modificaProdotto">Modifica Prodotto</button>
            <button id="eliminaProdotto">Elimina Prodotto</button>
        </div>

        <div id="aggiungi-prodotto">
            <form action="ModificaProdottoServlet" method="post">
                <p>Nome: </p>
                <input type="text" name="nomeProdotto" id="nomeId" required><br>

                <p>Prezzo: </p>
                <input type="text" name="prezzoProdotto" id="prezzoId" required>

                <p>Descrizione: </p>
                <textarea name="descrizioneProdotto" id="descrizioneId" required></textarea> <br>

                <p>ID Gruppo</p>
                <input type="text" name="idGruppo" id="gruppoId" required><br>

                <button class="confermaModifiche" type="submit" name="azione" value="aggiungi">Conferma</button>
            </form>
            <button class="annullaModifiche">Annulla</button>
        </div>

        <div id="modifica-prodotto">
            <table>
                <tr>
                    <th>ID</th>
                    <th>Nome</th>
                    <th>Prezzo</th>
                    <th>ID Gruppo</th>
                </tr>

                <c:forEach items="${prodotti}" var="prodotto">
                    <tr>
                        <td>${prodotto.id}</td>
                        <td>${prodotto.nome}</td>
                        <td>${prodotto.prezzo}€</td>
                        <td>${prodotto.idGruppo}</td>
                        <td>
                            <form action="ModificaProdottoServlet" method="post">
                                <input type="hidden" value="${prodotto.id}" name="id">
                                <button name="azione" value="modifica">-></button>
                            </form>
                        </td>
                    </tr>
                </c:forEach>
            </table>
            <button class="annullaModifiche">Annulla</button>
        </div>

        <div id="elimina-prodotto">
            <table>
                <tr>
                    <th>ID</th>
                    <th>Nome</th>
                    <th>Prezzo</th>
                    <th>ID Gruppo</th>
                </tr>

                <c:forEach items="${prodotti}" var="prodotto">
                    <tr>
                        <td>${prodotto.id}</td>
                        <td>${prodotto.nome}</td>
                        <td>${prodotto.prezzo}€</td>
                        <td>${prodotto.idGruppo}</td>
                        <td>
                            <form action="ModificaProdottoServlet" method="post">
                                <input type="hidden" value="${prodotto.id}" name="id">
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
