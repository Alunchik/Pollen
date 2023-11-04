package com.Alekperova.Pollen.controller;


import com.Alekperova.Pollen.Service.UserService;
import com.Alekperova.Pollen.model.User;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class UserController {
private final UserService userService;

@PostMapping("/users")
public User createUser(@RequestBody User user){
    userService.saveOrUpdate(user);
    return user;
}
@GetMapping("/users")
public List<User> getAllUsers(){
    return userService.getAllUsers();
}
@PutMapping("/users")
public User updateUser(@RequestBody User user){
    userService.saveOrUpdate(user);
    return user;
}
@DeleteMapping("/users")
public void deleteUser(@RequestParam("id") Long id){
    userService.deleteById(id);
}
}
