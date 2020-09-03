function editLibrary(){

    let elements = document.getElementById("editLibrary").elements;
    let obj ={};
    for(let i = 0 ; i < elements.length - 1 ; i++){
        let item = elements.item(i);
        obj[item.name] = item.value;
    }

    const req = new XMLHttpRequest();
    let myId = Number(obj.myLibraryId);
    req.open("PUT", "http://localhost:8080/updateLibrary/" + myId);
    req.onload = () => {
        if (req.status === 200 && req.readyState === 4) {
            console.log("Server Responded with: " + req.responseText);
        } else {
            console.log("Oops...");
        }
    };
    req.setRequestHeader("Content-Type", "application/json;charset=UTF-8");
    req.send(JSON.stringify({ name:obj.libraryName, user:{id: Number(obj.userId)}}));
}

function deleteLibrary(){

    let elements = document.getElementById("editLibrary").elements;
    let obj ={};
    for(let i = 0 ; i < elements.length - 1 ; i++){
        let item = elements.item(i);
        obj[item.name] = item.value;
    }
    const req = new XMLHttpRequest();
    let myId = Number(obj.myLibraryId);
    req.open("DELETE", "http://localhost:8080/deleteLibrary/" + myId);
    req.onload = () => {
        if (req.status === 200 && req.readyState === 4) {
            console.log("Server Responded with: " + req.responseText);
        } else {
            console.log("Oops...");
        }
    };
    req.setRequestHeader("Content-Type", "application/json;charset=UTF-8");
    req.send(JSON.stringify({ name:obj.libraryName, user:{id: Number(obj.userId)}}));
}

function editGame(){

    let elements = document.getElementById("editGame").elements;
    let obj ={};
    for(let i = 0 ; i < elements.length - 1 ; i++){
        let item = elements.item(i);
        obj[item.name] = item.value;
    }

    const req = new XMLHttpRequest();
    let myId = Number(obj.myGameId);
    req.open("PUT", "http://localhost:8080/updateGame/" + myId);
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

function deleteGame(){
    let elements = document.getElementById("editGame").elements;
    let obj ={};
    for(let i = 0 ; i < elements.length - 1 ; i++){
        let item = elements.item(i);
        obj[item.name] = item.value;
    }
    const req = new XMLHttpRequest();
    let myId = Number(obj.myGameId);
    req.open("DELETE", "http://localhost:8080/deleteGame/" + myId);
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