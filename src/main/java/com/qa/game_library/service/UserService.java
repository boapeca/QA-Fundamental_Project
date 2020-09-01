package com.qa.game_library.service;

import com.qa.game_library.domain.User;
import com.qa.game_library.exceptions.UserNotFoundException;
import com.qa.game_library.repo.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    private final UserRepository repo;

    @Autowired
    public UserService(UserRepository repo) {
        this.repo = repo;
    }
    
    public List<User> readAllUsers(){
        return this.repo.findAll();
    }

    public User createUser(User user) {
        return this.repo.save(user);
    }

    public User findUserById(Long id){
        return this.repo.findById(id).orElseThrow(UserNotFoundException::new);
    }

    public User updateUser(Long id, User user){
        User update = findUserById(id);
        update.setUsername(user.getUsername());
        update.setPassword(user.getPassword());
        return this.repo.save(update);
    }

    public boolean deleteUserById(Long id){
        if(!this.repo.existsById(id)){
            throw new UserNotFoundException();
        }
        this.repo.deleteById(id);
        return !this.repo.existsById(id);
    }
}
