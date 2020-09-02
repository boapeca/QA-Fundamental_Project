package com.qa.game_library.service;

import com.qa.game_library.domain.Game;
import com.qa.game_library.domain.User;
import com.qa.game_library.dto.GameDTO;
import com.qa.game_library.dto.UserDTO;
import com.qa.game_library.exceptions.GameNotFoundException;
import com.qa.game_library.exceptions.UserNotFoundException;
import com.qa.game_library.repo.UserRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserService {

    private final UserRepository repo;
    private final ModelMapper mapper;

    @Autowired
    public UserService(UserRepository repo, ModelMapper mapper) {
        this.repo = repo;
        this.mapper =mapper;
    }

    private UserDTO mapToDTO(User user){
        return this.mapper.map(user, UserDTO.class);
    }

    public List<UserDTO> readAllUsers(){
        return this.repo.findAll().stream().map(this::mapToDTO).collect(Collectors.toList());
    }

    public UserDTO createUser(User user ){
        return this.mapToDTO(this.repo.save(user));
    }

    public UserDTO findUserById(Long id){
        return this.mapToDTO(this.repo.findById(id).orElseThrow(UserNotFoundException::new));
    }

    public UserDTO updateUser(Long id, User user){
        User update = this.repo.findById(id).orElseThrow(UserNotFoundException::new);
        update.setPassword(user.getPassword());

        return this.mapToDTO(this.repo.save(user));
    }

    public boolean deleteUser(Long id){
        if(!this.repo.existsById(id)){
            throw new UserNotFoundException();
        }
        this.repo.deleteById(id);
        return this.repo.existsById(id);
    }


//    Before DTO
//    public List<User> readAllUsers(){
//        return this.repo.findAll();
//    }
//
//    public User createUser(User user) {
//        return this.repo.save(user);
//    }
//
//    public User findUserById(Long id){
//        return this.repo.findById(id).orElseThrow(UserNotFoundException::new);
//    }
//
//    public User updateUser(Long id, User user){
//        User update = findUserById(id);
//        update.setUsername(user.getUsername());
//        update.setPassword(user.getPassword());
//        return this.repo.save(update);
//    }
//
//    public boolean deleteUserById(Long id){
//        if(!this.repo.existsById(id)){
//            throw new UserNotFoundException();
//        }
//        this.repo.deleteById(id);
//        return !this.repo.existsById(id);
//    }
}
