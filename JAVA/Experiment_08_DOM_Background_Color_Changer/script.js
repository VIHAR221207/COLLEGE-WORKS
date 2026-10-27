var colors = ["red", "green", "blue", "yellow", "pink", "orange"];
var i = 0;

function changeColor() {
    document.body.style.backgroundColor = colors[i];
    document.getElementById("name").innerHTML = "Current color: " + colors[i];
    i = i + 1;
    if (i == colors.length) {
        i = 0;
    }
}

changeColor();
setInterval(changeColor, 5000);

// HOW TO RUN:
// Linked by index.html. Just open index.html in a browser.
