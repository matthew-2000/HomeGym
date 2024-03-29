
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>HomeGym - Admin</title>
    <link rel="icon" href="./images/icons/logo.ico">
    <link rel="stylesheet" href="./css/account.css" type="text/css">
    <link rel="stylesheet" href="./css/myaccount.css" type="text/css">
    <script src="./scripts/jquery.js"></script>
    <script src="./scripts/myAccount.js"></script>
</head>
<body>
  <%@include file="header.jsp"%>
  <script>
    var isChange = '${isChange}';
    if (isChange) {
      $(document).ready(function () {
        $(".lista_card").css("filter", "blur(5px)");
        $("#check").show();
      });
    }
  </script>

  <div id="check">
    <img src="./images/icons/spuntaBlu.png" id="checkImg">
    <p id="checkTesto">Modifica avvenuta con successo</p>
  </div>

  <section class="lista_card">
    <h1 id="title">Account</h1>
    <div class="container-card">


      <div class="card" id="accountCard">
        <h1 class="nome-card">Il mio Account</h1>
        <p class="descrizione">Qui puoi visualizzare tutti i dati del tuo account</p>
        <img src="./images/icons/account.png">
      </div>

      <div class="card" id="Gestisci">
        <h1 class="nome-card">Gestisci</h1>
        <p class="descrizione">Qui puoi gestire prodotti categorie e gruppi</p>
        <a href="${pageContext.request.contextPath}/AdminServlet"><img src="./images/icons/admin.png"></a>
      </div>

      <div class="card" id="logoutCard">
        <h1 class="nome-card">Logout</h1>
        <p class="descrizione">Qui puoi effettuare il logout</p>
        <img src="./images/icons/logout.png">
      </div>
    </div>
  </section>

  <div id="logout">
    <form action="LogoutServlet" method="get">
      <p>Sicuro di voler effettuare il Logout?</p>
      <button id="annulla-logout" type="button">Annulla</button>
      <button id="logout-button" type="submit">Logout</button>
    </form>
  </div>

  <div id="container-myaccount">
    <div id="box-myaccount">
      <img src="./images/icons/exit.png" id="exit">
      <h1 id="title-myaccount">Il Mio Account</h1>
      <form id="MyAccountForm" action="MyAccountServlet" method="post" onsubmit="return registrazioneValidate()">
        <input type="hidden" name="id" value="${utente.id}">
        <input type="hidden" name="email" value="${utente.email}">
        <input type="hidden" name="password" value="${utente.passwordHash}">

        <label for="nomeId" >Nome </label>
        <input type="text" name="nome" id="nomeId" value="${utente.nome}"><br>

        <label for="cognomeId" >Cognome </label>
        <input type="text" name="cognome" id="cognomeId" value="${utente.cognome}"><br>

        <label for="viaId" >Indirizzo </label>
        <input type="text" name="indirizzo" id="viaId" value="${utente.via}"><br>

        <label for="capId" >CAP </label>
        <input type="text" name="cap" id="capId" value="${utente.cap}"><br>

        <label for="paeseId" >Paese </label>
        <input type="text" name="paese" id="paeseId" value="${utente.paese}"><br>

        <label for="numeroId" >Numero di telefono </label>
        <input type="text" name="telefono" id="numeroId" value="${utente.numero}"><br>

        <div id="bottoni2">
          <button type="button" id="annulla">Annulla</button>
          <input type="submit" value="Salva Modifiche" id="salvaModifiche">
        </div>
      </form>
    </div>
  </div>

  <%@include file="footer.jsp"%>

</body>
</html>
