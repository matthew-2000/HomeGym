<%--
  Created by IntelliJ IDEA.
  User: matteo
  Date: 10/05/21
  Time: 10:53
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="./css/header.css" type="text/css">
    <script src="./script/jquery.js"></script>
</head>
<body>

<header class="header">
    <nav class="navbar">
        <a href="${pageContext.request.contextPath}/IndexServlet" class="nav-logo">
            <img id="logo" src="./images/logo.png">
        </a>
        <div id="search-bar">
            <form action="">
                <input type="text" placeholder="Cerca prodotti..." name="search">
                <button type="submit">Vai</button>
            </form>
        </div>

        <ul class="nav-menu">
            <li class="nav-item">
                <a href="${pageContext.request.contextPath}/CategorieServlet" class="nav-link">Categorie</a>
            </li>
            <c:choose>
                <c:when test="${utente == null}">
                    <li class="nav-item">
                        <a href="${pageContext.request.contextPath}/LogServlet" class="nav-link">Login</a>
                    </li>
                </c:when>
                <c:when test="${utente != null}">
                    <c:choose>
                        <c:when test="${utente.isAdmin()}">
                            <li class="nav-item">
                                <a href="${pageContext.request.contextPath}/AdminPageServlet" class="nav-link">Admin</a>
                            </li>
                        </c:when>
                        <c:otherwise>
                            <li class="nav-item">
                                <a href="${pageContext.request.contextPath}/AccountServlet" class="nav-link">Account</a>
                            </li>
                        </c:otherwise>
                    </c:choose>
                </c:when>
            </c:choose>
            <li class="nav-item">
                <a href="${pageContext.request.contextPath}/CarrelloServlet" class="nav-link">Carrello</a>
            </li>
        </ul>
        <div class="hamburger">
            <img src="./images/hamburger-menu.png">
        </div>
    </nav>
</header>

<script>
    const hamburger = document.querySelector(".hamburger");
    const navMenu = document.querySelector(".nav-menu");

    hamburger.addEventListener("click", mobileMenu);

    function mobileMenu() {
        hamburger.classList.toggle("active");
        navMenu.classList.toggle("active");
    }
</script>
</body>
</html>
