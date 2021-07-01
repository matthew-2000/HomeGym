<%--
  Created by IntelliJ IDEA.
  User: matteo
  Date: 14/06/21
  Time: 17:40
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>HomeGym - ${prodotto.nome}</title>
    <link rel="stylesheet" href="./css/prodotto.css" type="text/css">
</head>
<body>

    <%@include file="header.jsp"%>

    <div class="card">
        <div id="container">
            <div id="immagine">
                <div class="slideshow-container">

                    <c:forEach items="${prodotto.immagini}" var="immagine">
                        <div class="mySlides fade">
                            <img src="${immagine}" style="width:100%;">
                        </div>
                    </c:forEach>

                    <a class="prev" onclick="plusSlides(-1)">&#10094;</a>
                    <a class="next" onclick="plusSlides(1)">&#10095;</a>

                </div>
                <br>

                <div style="text-align:center">
                    <span class="dot" onclick="currentSlide(1)"></span>
                    <span class="dot" onclick="currentSlide(2)"></span>
                    <span class="dot" onclick="currentSlide(3)"></span>
                </div>
            </div>

            <div id="prodotto">
                <form action="AggiungiCarrelloServlet" method="post">
                    <input type="hidden" value="${prodotto.id}" name="idProdotto">
                    <h1>${prodotto.nome}</h1>
                    <p>Prezzo: ${prodotto.prezzo}</p>
                    <p>Disponibilità: ${prodotto.quantita}</p>
                    <button type="submit">Aggiungi al Carrello</button>
                </form>
            </div>
        </div>

        <div id="container-descrizione">
            <h3>Descrizione prodotto: </h3>
            <br>
            <p>${prodotto.descrizione}</p>
        </div>
    </div>

    <script>

        var slideIndex = 1;
        showSlides(slideIndex);

        function plusSlides(n) {
            showSlides(slideIndex += n);
        }

        function currentSlide(n) {
            showSlides(slideIndex = n);
        }

        function showSlides(n) {
            var i;
            var slides = document.getElementsByClassName("mySlides");
            var dots = document.getElementsByClassName("dot");
            if (n > slides.length) {slideIndex = 1}
            if (n < 1) {slideIndex = slides.length}
            for (i = 0; i < slides.length; i++) {
                slides[i].style.display = "none";
            }
            for (i = 0; i < dots.length; i++) {
                dots[i].className = dots[i].className.replace(" active", "");
            }
            slides[slideIndex-1].style.display = "block";
            dots[slideIndex-1].className += " active";
        }


    </script>

    <%@include file="footer.jsp"%>
</body>
</html>
