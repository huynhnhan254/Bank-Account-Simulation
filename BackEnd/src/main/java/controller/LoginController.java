// backend/src/main/java/com/example/controller/LoginController.java
package controller;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
@CrossOrigin(origins = "*") // allow frontend to connect
public class LoginController {

    @PostMapping("/login")
    public String login(@RequestBody LoginRequest request) {
        String username = request.getUsername();
        String password = request.getPassword();

        if ("user".equals(username) && "pass".equals(password)) {
            return "Login successful!";
        } else {
            return "Invalid credentials.";
        }
    }

    // Simple DTO
    public static class LoginRequest {
        private String username;
        private String password;

        public String getUsername() { return username; }
        public void setUsername(String username) { this.username = username; }

        public String getPassword() { return password; }
        public void setPassword(String password) { this.password = password; }
    }
}
