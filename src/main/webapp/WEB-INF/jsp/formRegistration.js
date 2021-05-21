function validate(){
    var email = document.getElementById("emailId");
    var password = document.getElementById("passwordId");
    var repeat = document.getElementById("repeatId");
    var errorBox = document.getElementById("errorMessage");


    if(email.value == ""){
        alert('Hai dimenticato di inserire l\'email');
        //errorBox.innerHTML = 'Hai dimenticato di inserire l\'email';
        email.focus();
        email.style.borderColor = "red";
    }

    if(password.value == ""){
        errorBox.innerHTML = 'Hai dimenticato di inserire la password';
    }

    if(repeat.value == ""){
        errorBox.innerHTML = 'Hai dimenticato di ripetere la password';
    }


}


