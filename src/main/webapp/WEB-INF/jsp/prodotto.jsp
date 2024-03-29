
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>HomeGym - ${prodotto.nome}</title>
    <link rel="icon" href="./images/icons/logo.ico">
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
                    <label for="quantita" style="font-size: 1.3em; margin-right: 5px">Quantità:</label>
                    <input style="font-size: 1.3em" type="number" id="quantita" name="quantita" min="1" max="20" value="1"><br>
                    <button type="submit">Aggiungi al carrello</button>
                </form>
                <form action="AggiungiListaDesideriServlet" method="post">
                    <input type="hidden" value="${prodotto.id}" name="idProdotto">
                    <button type="submit">Aggiungi alla lista desideri</button>
                </form>
            </div>
        </div>

        <div id="container-descrizione">
            <h2>Descrizione prodotto: </h2>
            <br>
            <p style="font-size: 20px">${prodotto.descrizione}</p>
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
            const slides = document.getElementsByClassName("mySlides");
            const dots = document.getElementsByClassName("dot");

            //se n è maggiore del numero di immagini allora l'indice diventa 1
            if (n > slides.length) {
                slideIndex = 1
            }

            //se n è minore di 1 allora l'indice punterà all'ultima immagine
            if (n < 1) {
                slideIndex = slides.length
            }

            //eliminiamo tutte le immagini
            for (i = 0; i < slides.length; i++) {
                slides[i].style.display = "none";
            }

            //rendiamo 'inattivi' tutti i dots
            for (i = 0; i < dots.length; i++) {
                dots[i].className = dots[i].className.replace(" active", "");
            }

            //rendiamo visibile l'immagine che corrisponde all'indice
            slides[slideIndex-1].style.display = "block";
            //rendimo attivo il dot che corrisponde all'indice
            dots[slideIndex-1].className += " active";
        }


    </script>

    <%@include file="footer.jsp"%>
</body>
</html>
