function bookTicket(movie) {
    document.getElementById("status").innerHTML = "Ticket booked for " + movie;
}

function openLogin() {
    document.getElementById("loginBox").style.display = "block";
}

function closeLogin() {
    document.getElementById("loginBox").style.display = "none";
}

function login() {
    var email = document.getElementById("email").value;
    var password = document.getElementById("password").value;
    if (email == "" || password == "") {
        alert("Please fill email and password");
    } else {
        alert("Login successful: " + email);
        closeLogin();
    }
}

// HOW TO RUN:
// Linked by index.html. Just open index.html in a browser.
