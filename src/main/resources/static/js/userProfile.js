
function submitLibrary(){
    let elements = document.getElementById("createLibrary").elements;
    let obj ={};
    for(let i = 0 ; i < elements.length - 1 ; i++){
        let item = elements.item(i);
        obj[item.name] = item.value;
    }

    const req = new XMLHttpRequest();
    req.open("POST", "http://localhost:8080/createLibrary");
    req.onload = () => {
        if (req.status === 200 && req.readyState === 4) {
            console.log("Server Responded with: " + req.responseText);
        } else {
            console.log("Oops...");
        }
    };
    req.setRequestHeader("Content-Type", "application/json;charset=UTF-8");
    req.send(JSON.stringify({ name:obj.name, user:{id: Number(obj.userId)}}));
}

function submitGame(){
    let elements = document.getElementById("createGame").elements;
    let obj ={};
    for(let i = 0 ; i < elements.length - 1 ; i++){
        let item = elements.item(i);
        obj[item.name] = item.value;
    }
    const req = new XMLHttpRequest();
    req.open("POST", "http://localhost:8080/createGame");
    req.onload = () => {
        if (req.status === 200 && req.readyState === 4) {
            console.log("Server Responded with: " + req.responseText);
        } else {
            console.log("Oops...");
        }
    };
    req.setRequestHeader("Content-Type", "application/json;charset=UTF-8");
    req.send(JSON.stringify({ name:obj.gameName,genre:obj.gameGenre, library:{id: Number(obj.libraryID)}}));
}




function displayLibraries() {
    const req = new XMLHttpRequest();
    req.onreadystatechange = () => {
        // Example handle logic
        if (req.status === 200 && req.readyState === 4) {
            if (req.getResponseHeader("Content-Type") === "application/json") {
                console.log("oh look its some JSON: " + req.responseText);
                // adding an element to the body example
                // let elem = document.createElement('div');
                // elem.textContent = "hello world";
                // document.body.appendChild(elem);

                let stuff = JSON.parse(req.response);
                stuff.forEach(el => {
                    //  console.log(el); // prints whole element
                    // console.log(el.name); // allows access to specific value
                    //adding title to the body of the page
                    let elem = document.createElement('fieldset');
                    elem.getElementsByClassName('myBoxLeft');
                    let header = document.createElement('h4');
                    let hearderId = document.createElement('p');
                    header.textContent = "Library name: " + el.name;
                    hearderId.textContent = "Library ID: " +el.id;
                    elem.appendChild(header);
                    elem.appendChild(hearderId);

                    el.games.forEach(game => {
                        console.log(game) // print all libraries
                        let newElem = document.createElement('fieldset');
                        newElem.getElementsByClassName('myBoxLeft');
                        let name = document.createElement('p');
                        let genre = document.createElement('p');
                        let gameID = document.createElement('p')
                        name.textContent = "Name: " + game.name;
                        genre.textContent = "Genre: " + game.genre;
                        gameID.textContent = "Game ID: " + game.id;
                        newElem.appendChild(name);
                        newElem.appendChild(genre);
                        newElem.appendChild(gameID);
                        // let button = document.createElement("button");
                        // button.innerHTML = "Edit";
                        // newElem.appendChild(button);
                        // button.value = game.id;
                        // button.addEventListener('click',function (){
                        //     getGameEditForm();
                        // });
                        elem.appendChild(newElem);
                    })
                    document.body.appendChild(elem);
                });
            } else {
                console.log(
                    "Looks like its not JSON but lets see what it is... " + req.responseText
                );
            }
        } else {
            console.log("Oh no... handle error");
        }
    };
    req.open("GET", "http://localhost:8080/getLibraries");
    req.send();
}