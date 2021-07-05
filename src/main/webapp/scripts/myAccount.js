$(document).ready(function (){
    $("#accountCard").click(function (){
        $("#container-myaccount").show("slow");
        $(".lista_card").css("filter", "blur(5px)");
    });

    $("#exit").click(function (){
        $("#container-myaccount").hide("slow");
        $(".lista_card").css("filter", "blur(0px)");
    });

    $("#modificaButton").click(function (){
        $(".lista_card").css("filter", "blur(5px)");
    });

    $("#annulla").click(function (){
        $("#container-myaccount").hide("slow");
        $(".lista_card").css("filter", "blur(0px)");
    });

    $("#checkImg").click(function () {
        $("#check").hide("slow");
        $(".lista_card").css("filter", "blur(0px)");
    });

    $("#logoutCard").click(function (){
        $("#logout").show("slow");
        $(".lista_card").css("filter", "blur(5px)");
    });

    $("#annulla-logout").click(function (){
        $("#logout").hide("slow");
        $(".lista_card").css("filter", "blur(0px)");
    });

});