$(document).ready(function (){
    $("#aggiungiCategoria").click(function (){
        $("#aggiungi-categoria").show("slow");
        $(".bottoni").hide();
    });

    $(".annullaModifiche").click(function (){
        $("#aggiungi-categoria").hide();
        $("#modifica-categoria").hide();
        $("#elimina-categoria").hide();
        $(".bottoni").show("slow");
    });

    $("#modificaCategoria").click(function (){
        $("#modifica-categoria").show("slow");
        $(".bottoni").hide();
    });

    $("#eliminaCategoria").click(function (){
        $("#elimina-categoria").show("slow");
        $(".bottoni").hide();
    });
});