var circleDiv = document.querySelector("#circleDiv");

var numberPrompt = prompt("Enter number of blocks !!", "Eg.: 10");
numberPrompt = parseInt(numberPrompt);

if (isNaN(numberPrompt) || numberPrompt < 10) {
    alert("Please enter a number greater than or equal to 10.");
} else {
    createCircle(numberPrompt);
}

var randomNumber = Math.floor(Math.random() * numberPrompt) + 1;
console.log("Random Number (For Testing):", randomNumber);

var attempts = 0;
var maxAttempts = 5;

function createCircle(numberPrompt) {
    for (let index = 1; index <= numberPrompt; index++) {
        let para = document.createElement("p");
        para.classList.add("para");
        para.innerText = index;

        para.addEventListener("click", function () {
            handleGuess(index, para);
        });

        circleDiv.appendChild(para);
    }
}

function handleGuess(userGuess, element) {
    if (attempts >= maxAttempts) {
        alert("Maximum 5 chances allowed! The correct number was: " + randomNumber);
        return;
    }

    attempts++;

    if (userGuess === randomNumber) {
        element.style.backgroundColor = "green";
        document.body.innerHTML += "<h2 style='text-align: center; color: green;'> You Won! </h2>";
    } else if (userGuess < randomNumber) {
        element.style.backgroundColor = "yellow";
    } else {
        element.style.backgroundColor = "red";
    }
}