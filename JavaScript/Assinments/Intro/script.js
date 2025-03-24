// alert("JavaScript is amazing")

// Variables in js ----------------------------------------------------------------------------------
// age = 25
// console.log(age," -> ",typeof(age))

// age = 25 + "Vatsal"
// console.log(age," -> ",typeof(age))

// console.log(age)



// datatypes is js - number, string, boolean, undefined, null, object ----------------------------------------------------------------------------------

// let age
// console.log(age)
// console.log(typeof(age))


// firstname = 'Vatsal'
// let lastname = "soni"

// console.log(firstname+lastname)

// console.log(lastname.toUpperCase())

// let message = `Firstname is ${firstname} and lastname is ${lastname}`

// console.log(message)




//Arrays ----------------------------------------------------------------------------------

// let players = ['Rohit', 'Virat', 'Shubhman']
// console.log(players)
// console.log("Size: "+players.length)
// let newPlayers = ['Pant', 'Bumrah']

// let updatedPlayers = players.concat(newPlayers)
// console.log(updatedPlayers)
// console.log("Size: "+updatedPlayers.length)

// updatedPlayers.push("Dhoni")
// console.log(updatedPlayers)

// updatedPlayers.pop("Pant")
// console.log(updatedPlayers)

// updatedPlayers.reverse()
// console.log(updatedPlayers)

// console.log(updatedPlayers.join("-"))







//Comparison in js - loose and strict comparison ----------------------------------------------------------------------------------
// loose comparison - only checks the value
// strict comparison - checks value as well as the type

// let age = 25
// console.log(age == 25)       //true
// console.log(age == "25")     //true
// console.log(age === 25)      //true
// console.log(age === "25")    //flase









// type conversion in js ----------------------------------------------------------------------------------

// let score = '100'
// console.log(typeof(score))

// score = Number(score)
// console.log(typeof(score))

// let firstname = "Vatsal"
// console.log(typeof(firstname))

// firstname = Number(firstname)
// console.log(firstname)


// let b = Boolean(0)
// console.log(b)                  //false  because js cosiders 0 as false and anything else as true
// b = Boolean('')
// console.log(b)                  //false  because js considers empty strings as false
// b = Boolean(-1)
// console.log(b)                  //true


















// functions in js ----------------------------------------------------------------------------------

//Normal way of function in js

// function greet(x)
// {
//     console.log("Hello "+x)
// }

// greet("Vatsal")


// function expression in js - you can assign function to a variable

// let greet = function(x)
// {
//     console.log("Hello "+x)
// }

// greet("Vatsal")




// function hoisting in js - we can call the function before its declaration. it doesn't matter the order of function declaration 
// greet("Vatsal")

// function greet(x)
// {
//     console.log("Hello "+x)
// }









// arrow function in js - similar to lambda expression in java. here no need to write the function keyword instead simply use an =>
// let area = (radius) =>{
//     return 3.14 * radius * radius
// }

// console.log(area(5))













// Bill Calculator ----------------------------------------------------------------------------------
// let bill = (productPrice, tax) => {
//     let taxedValue = 0
//     let totalBill = 0
//     let taxValue = tax / 100
//     for (let index = 0; index < productPrice.length; index++) {
//         taxedValue = productPrice[index] + productPrice[index] * taxValue     //calculate product price of                                                                                 each product with tax added 

//         totalBill = totalBill + taxedValue                                    
//     }

//     return totalBill
// }

// console.log(bill([100, 150, 250], 10))







// Call back function ----------------------------------------------------------------------------------
// const myFunc = (callbackfunc) => {
//     let value = 50;
//     callbackfunc(value)
// }

// const callback = function (value) {
//     console.log(value)
// }

// myFunc(callback)








//for each in js ----------------------------------------------------------------------------------
// let players = ['Rohit', 'Virat', 'Bumrah']

// players.forEach(player=>console.log(player))

// players.forEach((player, index)=>console.log(player,index))














//Object literals ----------------------------------------------------------------------------------

let user={
    firstname:"Vatsal",
    lastname:"Soni",
    age: 21,
    address:{
        city:"Mumbai",
        pincode:"400001"
    },
    blogs:[{
        title:"Java",
        likes:50,
        dislikes:10
    },
    {
        title:".Net",
        likes:150
    }
    ]
}

// console.log(user)

// console.log(user.firstname)
// console.log(user.age)
// console.log(user.address.pincode)

// user.address.city = "Pune"
// console.log(user.address.city)


// let printblogs = (user)=>{
//     user.blogs.forEach(blog => console.log(blog))
// }

// printblogs(user)


let printblogsarray = (user)=>{
    user.blogs.forEach((blog) => console.log(`${blog.title}\t${blog.likes}\t${blog.dislikes}`))
}

printblogsarray(user)