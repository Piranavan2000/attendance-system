document.getElementById("loginForm").addEventListener("submit", async function(event) {
    event.preventDefault();

    const username = document.getElementById("username").value;
    const password = document.getElementById("password").value;
    const errorMessage = document.getElementById("error-message");

    // Basic validations
    if (username.trim() === "") {
        errorMessage.textContent = "Username is required.";
        return;
    }

    if (password.trim() === "") {
        errorMessage.textContent = "Password is required.";
        return;
    }

    if (password.length < 6) {
        errorMessage.textContent = "Password must be at least 6 characters.";
        return;
    }

    if (!/^[a-zA-Z0-9_]+$/.test(username)) {
        errorMessage.textContent = "Username can only contain letters, numbers, and underscores.";
        return;
    }

    try {
        const response = await fetch("http://localhost:8080/api/login", {
            method: "POST",
            headers: { "Content-Type": "application/json" },
            body: JSON.stringify({ username, password })
        });

        const data = await response.json();

        if (response.ok && data.token) {
            localStorage.setItem("jwt_token", data.token);
            localStorage.setItem("username", data.username);
            window.location.href = "home.html";
        } else {
            errorMessage.textContent = data.error || "Invalid username or password!";
        }
    } catch (error) {
        errorMessage.textContent = "Error connecting to server!";
    }
});
