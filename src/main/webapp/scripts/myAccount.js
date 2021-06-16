$(document).ready(function (){
    $("#accountCard").click(function (){
        //$("#modificaButton").show();
        $("#container-myaccount").show("slow");
        $(".lista_card").css("filter", "blur(5px)");
        $("#bottoni2").hide();
    });

    $("#exit").click(function (){
        $("#container-myaccount").hide("slow");
        $(".lista_card").css("filter", "blur(0px)");
        $("#bottoni2").hide();
    });

    $("#modificaButton").click(function (){
        $("#bottoni2").show();
        //$("#modificaButton").hide();
        $(".lista_card").css("filter", "blur(5px)");
    });

    $("#annulla").click(function (){
        $("#container-myaccount").hide("slow");
        $(".lista_card").css("filter", "blur(0px)");
        $("#bottoni2").hide();
    });

    $("#checkImg").click(function () {
        $("#check").hide("slow");
        $(".lista_card").css("filter", "blur(0px)");
    });
});