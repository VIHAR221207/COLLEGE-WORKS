function checkEmail() {
    var email = document.getElementById("email").value;
    var result = document.getElementById("result");

    var at = email.indexOf("@");
    var dot = email.lastIndexOf(".");

    if (email == "") {
        result.innerHTML = "Email is empty";
    } else if (at < 1) {
        result.innerHTML = "Invalid: '@' is missing (or at the start)";
    } else if (dot < at + 2) {
        result.innerHTML = "Invalid: '.' must come after '@' with some text between";
    } else if (dot == email.length - 1) {
        result.innerHTML = "Invalid: nothing after '.'";
    } else {
        result.innerHTML = "Valid email";
    }
}

// HOW TO RUN:
// Linked by index.html. Just open index.html in a browser.
