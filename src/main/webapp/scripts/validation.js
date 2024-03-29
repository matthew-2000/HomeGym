
function emailValidate(email) {
    const emailRegEx = /^[a-zA-Z0-9.!#$%&’*+/=?^_`{|}~-]+@[a-zA-Z0-9-]+(?:\.[a-zA-Z0-9-]+)+$/;
    const emailResult = emailRegEx.test(email);

    if (!emailResult) {
        alert("Email non valida!");
        return false;
    }

    return true
}

function passwordValidate(password) {
    const passwordRegEx = /^(?=.*?[A-Z])(?=.*?[a-z])(?=.*?[0-9])(?=.*?[#?!@$%^&*-]).{8,}$/;
    const passwordResult = passwordRegEx.test(password);

    if (!passwordResult) {
        alert("Password non valida!\nLa password deve essere di almeno 8 caratteri, deve contenere un numero, una lettera maiuscola, una lettera minuscola e un carattere speciale.");
        return false;
    }

    return true;
}

function textValidate(text, title) {
    const textRegEx = /^[a-zA-Z0-9\s]+$/;
    const textResult = textRegEx.test(text);

    if (!textResult) {
        alert("Valore in '" + title + "' non valido!");
        return false;
    }

    return true;
}

function phoneValidate(phoneNumber) {

    const phoneRegEx = /^[0-9]{10}$/;
    const phoneResult = phoneRegEx.test(phoneNumber);

    if (!phoneResult) {
        alert("Numero di telefono non valido!");
        return false;
    }

    return true;

}

function capValidate(cap) {

    const capRegEx = /^[0-9]{5}$/;
    const capResult = capRegEx.test(cap);

    if (!capResult) {
        alert("CAP non valido!");
        return false;
    }

    return true;

}

function avanti() {
    document.getElementById("errorMessage").innerHTML = "";
    document.getElementById("altro").style.display="block";
    document.getElementById("email-pass").style.display="none";
}

function check() {
    var email = document.getElementById("emailId");
    var password = document.getElementById("passwordId");
    var repeat = document.getElementById("repeatId");
    var errorMessage = document.getElementById("errorMessage")

    if (email.value == "" || password.value == "" || repeat.value == "") {
        errorMessage.innerHTML = "Inserisci tutti gli elementi";

        if (email.value == "") {
            email.focus();
            email.style.borderColor = "red";
        }

        if (password.value == "") {
            password.focus();
            password.style.borderColor = "red";
        }

        if (repeat.value == "") {
            repeat.focus();
            repeat.style.borderColor = "red";
        }
    } else {
        if (password.value == repeat.value) {

            if (emailValidate(email.value) && passwordValidate(password.value)) {
                avanti();
            }

        } else {
            errorMessage.innerHTML = "Le password non coincidono!";
        }
    }
}

function registrazioneValidate() {
    const nome = document.getElementById("nomeId").value;
    const cognome = document.getElementById("cognomeId").value;
    const via = document.getElementById("viaId").value;
    const cap = document.getElementById("capId").value;
    const paese = document.getElementById("paeseId").value;
    const numero = document.getElementById("numeroId").value;

    return textValidate(nome, "Nome") && textValidate(cognome, "Cognome") && textValidate(via, "Via") &&
        capValidate(cap) && textValidate(paese, "Paese") && phoneValidate(numero);

}

