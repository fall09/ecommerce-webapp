package com.eylul.ecommerce.controllers;

import com.eylul.ecommerce.models.User;
import com.eylul.ecommerce.services.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/user")
public class UserController {

    private final UserService userService;

    @GetMapping("/getAll")
    public List<User> getAllUsers() {
        return userService.fetchAllUsers();
    }

    @PostMapping("/add")
    public void createUser(@RequestBody User user) {
         userService.addUser(user);
    }
    @GetMapping("/getById")
    public User findUserById(@RequestParam("id") Long id) {
        return userService.findUserById(id);
    }
    @PutMapping("/update")
    public ResponseEntity updateUser( @RequestBody User user) {
        userService.updateUser(user);
        return ResponseEntity.ok("User updated successfully");
    }

    @DeleteMapping("/delete")
    public void deleteUser(@RequestParam("id") Long id) {
        User deletedUser = userService.findUserById(id);
        userService.deleteUser(deletedUser);
    }

}