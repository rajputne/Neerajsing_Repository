function checkZipCode() {
    var sZip, text;

    // Get the value of the input field with id="numb"
    sZip = document.getElementById("txtZip").value;

    // If x is Not a Number or less than one or greater than 10
    if (/^\d{5}(-\d{4})?$/.test(sZip)) {
        text = "Input valid";
    } else {
        text = "Input not OK";

    }
    document.getElementById("zipError").innerHTML = text;
}

function phonenumber() {
    var inputtxt = document.getElementById("txtPhoneNumber").value;

    var text = "";
    if (/^\(?([0-9]{3})\)?[-. ]?([0-9]{3})[-. ]?([0-9]{4})$/.test(inputtxt)) {
        text = "Input valid";
    }
    else {
        text = "Input not OK";
    }

    document.getElementById("phoneError").innerHTML = text;
}

function phonenumber2() {
    var inputtxt = document.getElementById("txtPhoneNumber1").value;

    var text = "";
    if (/^\(?([0-9]{3})\)?[-. ]?([0-9]{3})[-. ]?([0-9]{4})$/.test(inputtxt)) {
        text = "Input valid";
    }
    else {
        text = "Input not OK";
    }

    document.getElementById("phoneError2").innerHTML = text;
}

function checkAge() {
    var inputtxt = document.getElementById("txtAge").value;

    var text = "";
    if (/^\d{1,2}$/.test(inputtxt)) {
        text = "Input valid";
    }
    else {
        text = "Input not OK";

    }

    document.getElementById("ageFactor").innerHTML = text;
}

function accountNumberValidate()
{
    var inputtxt = document.getElementById("txtAccNumber").value;

    var text = "";
    if (!isNaN(inputtxt) ) {
        text = "Input valid";
    }
    else {
        text = "Input not OK";
    }

    document.getElementById("accountNumber").innerHTML = text;

}

function amountValidate() {
    var inputtxt = document.getElementById("txtAmount").value;

    var text = "";
    if (!isNaN(inputtxt) && /^[0-9]*\.[0-9]{2}$/.test(inputtxt)) {
        text = "Input valid";
    }
    else {
        text = "Input not OK";
    }

    document.getElementById("AmountError").innerHTML = text;

}

function faxValidate() {
    var inputtxt = document.getElementById("txtFax").value;

    var text = "";
    if (!isNaN(inputtxt)) {
        text = "Input valid";
    }
    else {
        text = "Input not OK";
    }

    document.getElementById("FaxError").innerHTML = text;

}
function validateForm() {

    var ageFactor = document.getElementById("ageFactor").innerHTML;
    var phoneError2 = document.getElementById("phoneError2").innerHTML;
    var phoneError = document.getElementById("phoneError").innerHTML;
    var zipError = document.getElementById("zipError").innerHTML;

    var accountNumberError = document.getElementById("accountNumber").innerHTML;
    var amountError = document.getElementById("AmountError").innerHTML;
    var faxError = document.getElementById("FaxError").innerHTML;

    if ((ageFactor == "Input not OK") || (phoneError2 == "Input not OK") || (phoneError == "Input not OK") || (zipError == "Input not OK") || (accountNumberError == "Input not OK") || (amountError == "Input not OK") || (faxError == "Input not OK")) {
        alert("Please correct the errors on Page");
        return false;
    }

}
