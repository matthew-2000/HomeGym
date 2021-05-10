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


    <div id="slider">
        <!--<script src="./script/slider.js"></script>-->
        <script>
        var i = 0;
        var images = [];
        var times = 3000;
        //Lista di immagini
        images[0] = "./images/sliderIndex/allenamento1.jpg";
        images[1] = "./images/sliderIndex/allenamento2.jpg";
        images[2] = "./images/sliderIndex/allenamento3.jpg";

        //Funzione per cambiare immagine
        function changeImg(){
            document.slide.src = images[i];
            if(i < images.length - 1){
                i++;
            }else{
                i = 0;
            }
            setTimeout("changeImg()", times);
        }
        window.onload = changeImg;
    </script>
        <img name="slide" width="100%" height="500px" alt={slider}>
    </div>


    <section class="lista_prodotti">
        <h1 id="title">I più venduti</h1>
        <div class="container-prodotti">

            <c:forEach items="${venduti}" var="venduto">
                <div class="card">
                    <h1 id="nome-prodotto">${venduto.nome}</h1>
                    <img src="./images/prodotti/Categoria 1/Gruppo 1 - Manubri e Pesi/KIT MANUBRI BODYBUILDING 20KG FILETTATI/1.png">
                    <p class="price">${venduto.prezzo}</p>
                    <p class="text">${venduto.descrizione}</p>
                    <button id="visualizza">Visualizza</button>
                    <button id="aggiungi">Aggiungi al carrello</button>
                </div>
            </c:forEach>

        </div>
    </section>




</body>
</html>