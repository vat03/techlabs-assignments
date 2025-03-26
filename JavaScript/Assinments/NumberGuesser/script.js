var circle = document.querySelector("#circleDiv")

var numberPromt = prompt("Enter number of blocks !!", "Eg.: 5")

createCircle(numberPromt)

function createCircle(numberPromt) {
    if (numberPromt < 10) {
        alert("Number should be greater than 10")
        return
    }

    for (let index = 0; index < numberPromt; index++) {
        var para1 = document.createElement("p")
        para1.classList.add("para")
        para1.innerText = index+1
        circle.appendChild(para1)
    }
}