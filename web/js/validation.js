function validateForm(){

    let firstName = document.forms["studentForm"]["firstName"].value;
    let lastName = document.forms["studentForm"]["lastName"].value;
    let email = document.forms["studentForm"]["email"].value;
    let phone = document.forms["studentForm"]["phone"].value;

    if(firstName==""){
        alert("Please enter First Name");
        return false;
    }

    if(lastName==""){
        alert("Please enter Last Name");
        return false;
    }

    if(email==""){
        alert("Please enter Email");
        return false;
    }

    if(phone==""){
        alert("Please enter Phone Number");
        return false;
    }

    return true;
}