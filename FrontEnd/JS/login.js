function login() {
    const username = document.getElementById('username').value;
    const password = document.getElementById('password').value;

    fetch("http://localhost:8080/api/login", {
        method: "POST",
        headers: {
            "Content-Type": "application/json"
        },
        body: JSON.stringify({ username, password })
    })
        .then(response => response.text())
        .then(data => alert(data))
        .catch(error => alert("Login failed: " + error));
}
