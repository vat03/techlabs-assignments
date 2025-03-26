taskArray = []
completedTaskArray = []
var inputText = document.querySelector("#inputText")
var addButton = document.querySelector("#addButton")
var unorderedList = document.querySelector("#taskGiven")
var unorderedListCompleted = document.querySelector("#completedTask")

addButton.addEventListener("click", () => {
    alert(inputText.value)
    text = inputText.value
    taskArray.push(text)
    unorderedList.innerHTML = ""
    taskArray.forEach(element => {
        addListElement(element)
    });
})

function addListElement(element) {
    var divForList = document.createElement("div")
    var listItem = document.createElement("li")
    var textSpan = document.createElement("span")
    var checkButton = document.createElement("button")
    checkButton.innerText = "Check"
    var deleteButton = document.createElement("button")
    deleteButton.innerText = "Delete"

    textSpan.textContent = element
    listItem.appendChild(textSpan)
    listItem.appendChild(checkButton)
    listItem.appendChild(deleteButton)

    divForList.appendChild(listItem)

    unorderedList.appendChild(divForList)

    checkButton.addEventListener("click", () => {
        taskArray = taskArray.filter(task => task !== element);
        unorderedList.innerHTML = "";
        taskArray.forEach(addListElement);
        completedTaskArray.push(element);
        unorderedListCompleted.innerHTML = "";
        completedTaskArray.forEach(element => {
            updateCompletedTasks(element);
        })
    })

    deleteButton.addEventListener("click", () => {
        taskArray = taskArray.filter(task => task !== element);
        unorderedList.innerHTML = "";
        taskArray.forEach(addListElement)
    })
}

function updateCompletedTasks(element) {
    
    var divForList = document.createElement("div")
    var listItem = document.createElement("li")
    var textSpan = document.createElement("span")
    var deleteButton = document.createElement("button")
    deleteButton.innerText = "Delete"

    textSpan.textContent = element
    listItem.appendChild(textSpan)
    listItem.appendChild(deleteButton)

    divForList.appendChild(listItem)
    unorderedListCompleted.appendChild(divForList)

    deleteButton.addEventListener("click", () => {
        completedTaskArray = completedTaskArray.filter(task => task !== element);
        unorderedListCompleted.innerHTML = "";
        completedTaskArray.forEach(updateCompletedTasks)
    })
}