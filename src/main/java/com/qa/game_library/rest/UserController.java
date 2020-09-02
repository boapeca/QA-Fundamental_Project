package com.qa.game_library.rest;


import com.qa.game_library.domain.User;
import com.qa.game_library.dto.UserDTO;
import com.qa.game_library.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.websocket.server.PathParam;
import java.util.List;

@RestController
public class UserController {

    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/getUsers")
    public ResponseEntity<List<UserDTO>> getAllUsers(){
        return ResponseEntity.ok(this.userService.readAllUsers());
    }

    @PostMapping("/createUser")
    public ResponseEntity<UserDTO> createUser(@RequestBody User user){
        return new ResponseEntity<UserDTO>(this.userService.createUser(user), HttpStatus.CREATED);
    }

    @DeleteMapping("/deleteUser/{id}")
    public ResponseEntity<?> deleteUser(@PathVariable Long id){
        return this.userService.deleteUser(id)
                ? ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build()
                : ResponseEntity.noContent().build();
    }

    @GetMapping("/getUserById/{id}")
    public ResponseEntity<UserDTO> getUserById(@PathVariable Long id){
        return ResponseEntity.ok(this.userService.findUserById(id));

    }

    @PutMapping("/updateUser/{id}")
    public ResponseEntity<UserDTO> updateUser(@PathVariable Long id, @RequestBody User user){
        return ResponseEntity.ok(this.userService.updateUser(id, user));
    }



}
