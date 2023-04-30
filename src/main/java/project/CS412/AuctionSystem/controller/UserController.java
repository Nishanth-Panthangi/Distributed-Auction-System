package project.CS412.AuctionSystem.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import project.CS412.AuctionSystem.model.RegisterRequest;
import project.CS412.AuctionSystem.model.Role;
import project.CS412.AuctionSystem.model.User;
import project.CS412.AuctionSystem.service.UserService;

@RestController
@RequestMapping("/auth")
public class UserController {
    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/register")
    public ResponseEntity<String> register(@RequestBody RegisterRequest registerRequest) {
        User user = new User();
        user.setUsername(registerRequest.getUsername());
        user.setPassword(registerRequest.getPassword());
        user.setRole(registerRequest.getRole());
        userService.registerUser(user);
        return new ResponseEntity<>("User registered successfully!", HttpStatus.OK);
    }
}
