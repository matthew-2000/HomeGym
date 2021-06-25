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
<!--
<main class="container">

    <div class="left-column">
        <img data-image="black" src="images/black.png" alt="">
        <img data-image="blue" src="images/blue.png" alt="">
        <img data-image="red" class="active" src="images/red.png" alt="">
    </div>


    <div class="right-column">

        <div class="product-description">
            <span>Headphones</span>
            <h1>Beats EP</h1>
            <p>The preferred choice of a vast range of acclaimed DJs. Punchy, bass-focused sound and high isolation. Sturdy headband and on-ear cushions suitable for live performance</p>
        </div>

        <div class="product-configuration">

            <div class="product-color">
                <span>Color</span>

                <div class="color-choose">
                    <div>
                        <input data-image="red" type="radio" id="red" name="color" value="red" checked>
                        <label for="red"><span></span></label>
                    </div>
                    <div>
                        <input data-image="blue" type="radio" id="blue" name="color" value="blue">
                        <label for="blue"><span></span></label>
                    </div>
                    <div>
                        <input data-image="black" type="radio" id="black" name="color" value="black">
                        <label for="black"><span></span></label>
                    </div>
                </div>

            </div>

            <div class="cable-config">
                <span>Cable configuration</span>

                <div class="cable-choose">
                    <button>Straight</button>
                    <button>Coiled</button>
                    <button>Long-coiled</button>
                </div>

                <a href="#">How to configurate your headphones</a>
            </div>
        </div>

        <div class="product-price">
            <span>148$</span>
            <a href="#" class="cart-btn">Add to cart</a>
        </div>
    </div>
</main>
-->
    <%@include file="header.jsp"%>


    <div id="immagine">
        <img src="./images/prodotti/Categoria 1/Gruppo 1 - Manubri e Pesi/KIT MANUBRI BODYBUILDING 20KG FILETTATI/1.png">
    </div>

    <div id="descrizione">
        <h1 id="nome-prodotto">${prodotto.nome}</h1>
        <p id="prezzo-prodotto">Prezzo: ${prodotto.prezzo}</p>
        <p id="quantita-prodotto">Disponibilità: ${prodotto.quantita}</p>
        <p id="data-prodotto">Data di consegna: 26/06/2021</p>
        <button id="aggiungi-carrello">Aggiungi al Carrello</button>
    </div>

    <%@include file="footer.jsp"%>
</body>
</html>
