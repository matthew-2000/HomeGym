$(document).ready(function (){
    $("#aggiungiProdotto").click(function (){
        $("#aggiungi-prodotto").show("slow");
        $(".bottoni").hide();
    });

    $(".annullaModifiche").click(function (){
        $("#aggiungi-prodotto").hide();
        $("#modifica-prodotto").hide();
        $("#elimina-prodotto").hide();
        $(".bottoni").show("slow");
    });

    $("#modificaProdotto").click(function (){
        $("#modifica-prodotto").show("slow");
        $(".bottoni").hide();
    });

    $("#eliminaProdotto").click(function (){
        $("#elimina-prodotto").show("slow");
        $(".bottoni").hide();
    });
});