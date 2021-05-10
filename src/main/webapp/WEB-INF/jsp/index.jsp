<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>HomeGym</title>
    <link rel="stylesheet" href="./css/header.css" type="text/css">
    <link rel="stylesheet" href="./css/index.css" type="text/css">
</head>
<body>
    <%@include file="header.jsp"%>

    <br>

    <div class="slideshow-container">

        <div class="mySlides fade">
            <img src="./images/sliderIndex/allenamento1.jpg" style="width:100%; height: 600px; border-radius: 10%">
            <div class="text">Caption Text</div>
        </div>

        <div class="mySlides fade">
            <img src="./images/sliderIndex/allenamento2.jpg" style="width:100%; height: 600px; border-radius: 10%">
            <div class="text">Caption Two</div>
        </div>

        <div class="mySlides fade">
            <img src="./images/sliderIndex/allenamento3.jpg" style="width:100%; height: 600px; border-radius: 10%">
            <div class="text">Caption Three</div>
        </div>

        <a class="prev" onclick="plusSlides(-1)">&#10094;</a>
        <a class="next" onclick="plusSlides(1)">&#10095;</a>

    </div>
    <br>

    <div style="text-align:center">
        <span class="dot" onclick="currentSlide(1)"></span>
        <span class="dot" onclick="currentSlide(2)"></span>
        <span class="dot" onclick="currentSlide(3)"></span>
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


    <section class="lista_prodotti">
        <h1 id="title">I più venduti</h1>
        <div class="container-prodotti">

            <c:forEach items="${venduti}" var="venduto">
                <div class="card">
                    <h1 id="nome-prodotto">${venduto.nome}</h1>
                    <img src="./images/prodotti/Categoria 1/Gruppo 1 - Manubri e Pesi/KIT MANUBRI BODYBUILDING 20KG FILETTATI/1.png">
                    <p class="price">${venduto.prezzo}</p>
                    <p class="descrizione">${venduto.descrizione}</p>
                    <button id="visualizza">Visualizza</button>
                    <button id="aggiungi">Aggiungi al carrello</button>
                </div>
            </c:forEach>

        </div>
    </section>




</body>
</html>