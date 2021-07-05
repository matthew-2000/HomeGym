$(document).ready(function (){
    //Se scelgo Categorie
    $("#scelta").get(0).selectedIndex(function (){
        $("#container-gestoreCategorie").show();
        $("#container-gestoreGruppi").hide();
        $("#container-gestoreProdotti").hide();
    });

    //Se scelgo Gruppi
    $("#scelta").get(1).selectedIndex(function (){
        $("#container-gestoreCategorie").hide();
        $("#container-gestoreGruppi").show();
        $("#container-gestoreProdotti").hide();
    });

    //Se scelgo Prodotti
    $("#scelta").get(1).selectedIndex(function (){
        $("#container-gestoreCategorie").hide();
        $("#container-gestoreGruppi").hide();
        $("#container-gestoreProdotti").show();
    });
});