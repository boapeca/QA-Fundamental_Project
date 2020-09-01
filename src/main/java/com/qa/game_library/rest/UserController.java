package com.qa.game_library.rest;

import com.qa.game_library.domain.User;
import com.qa.game_library.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class UserController {

    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/")
    public List<User> getAllUsers(){
        return this.userService.readAllUsers();
    }

    @PostMapping("/createUser")
    public User createUser(@RequestBody User user){

        return  this.userService.createUser(user);
    }

    @DeleteMapping("/deleteUser/{id}")
    public Boolean deleteUser(@PathVariable Long id){
        return this.userService.deleteUserById(id);
    }

    @GetMapping("/getUserById/{id}")
    public User getUserById(@PathVariable Long id){
        return this.userService.findUserById(id);
    }

    @PutMapping("/updateUser/{id}")
    public User updateUser(@PathVariable Long id, @RequestBody User User){
        return this.userService.updateUser(id, User);
    }

}
