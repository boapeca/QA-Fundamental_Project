function submitUser(){
    let elements = document.getElementById("signUpForm").elements;
    let obj ={};
    for(let i = 0 ; i < elements.length - 1 ; i++){
        let item = elements.item(i);
        obj[item.name] = item.value;
    }

    const req = new XMLHttpRequest();
    req.open("POST", "http://localhost:9000/createUser");
    req.onload = () => {
        if (req.status === 200 && req.readyState === 4) {
            console.log("Server Responded with: " + req.responseText);
        } else {
            console.log("Oops...");
        }
    };

    req.setRequestHeader("Content-Type", "application/json;charset=UTF-8");
    req.send(JSON.stringify({ username: obj.username, password: obj.password, email:obj.email, dateOfBirth:obj.dateOfBirth}));
}