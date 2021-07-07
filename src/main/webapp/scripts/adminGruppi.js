$(document).ready(function (){
    $("#aggiungiGruppo").click(function (){
        $("#aggiungi-gruppo").show("slow");
        $(".bottoni").hide();
    });

    $(".annullaModifiche").click(function (){
        $("#aggiungi-gruppo").hide();
        $("#modifica-gruppo").hide();
        $("#elimina-gruppo").hide();
        $(".bottoni").show("slow");
    });

    $("#modificaGruppo").click(function (){
        $("#modifica-gruppo").show("slow");
        $(".bottoni").hide();
    });

    $("#eliminaGruppo").click(function (){
        $("#elimina-gruppo").show("slow");
        $(".bottoni").hide();
    });
});