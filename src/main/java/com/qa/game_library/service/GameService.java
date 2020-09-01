package com.qa.game_library.service;

import com.qa.game_library.domain.Game;
import com.qa.game_library.dto.GameDTO;
import com.qa.game_library.exceptions.GameNotFoundException;
import com.qa.game_library.repo.GameRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.ModelMap;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class GameService {

    private final GameRepository gameRepository;
    private final ModelMapper mapper;


    @Autowired
    public GameService(GameRepository gameRepository, ModelMapper mapper) {
        this.gameRepository = gameRepository;
        this.mapper = mapper;
    }

    private GameDTO mapToDTO(Game game){
        return this.mapper.map(game, GameDTO.class);
    }

    public List<GameDTO> readAllGames(){
        return this.gameRepository.findAll().stream().map(this::mapToDTO).collect(Collectors.toList());
    }

    public GameDTO createGame(Game game ){
        return this.mapToDTO(this.gameRepository.save(game));
    }

    public GameDTO findGameById(Long id){
        return this.mapToDTO(this.gameRepository.findById(id).orElseThrow(GameNotFoundException::new));
    }

    public GameDTO updateGame(Long id, Game game){
        Game update = this.gameRepository.findById(id).orElseThrow(GameNotFoundException::new);
        update.setName(game.getName());
        update.setGenre(game.getGenre());

        return this.mapToDTO(this.gameRepository.save(game));
    }

    public boolean deleteGame(Long id){
       if(!this.gameRepository.existsById(id)){
           throw new GameNotFoundException();
       }
       this.gameRepository.deleteById(id);
       return this.gameRepository.existsById(id);
       }

    // Before DTO
//    public List<Game> readAllGames(){
//        return this.gameRepository.findAll();
//    }
//
//    public Game createGame (Game game){
//        return this.gameRepository.save(game);
//    }
//
//    public Game findGameById(Long id){
//        return this.gameRepository.findById(id).orElseThrow(GameNotFoundException::new);
//    }
//
//    public Game updateGame(Long id, Game game){
//        Game update = findGameById(id);
//        update.setName(game.getName());
//        update.setGenre(game.getGenre());
//        return this.gameRepository.save(update);
//
//    }
//
//    public boolean deleteGame(Long id){
//        if(!this.gameRepository.existsById(id)){
//            throw new GameNotFoundException();
//        }
//        this.gameRepository.deleteById(id);
//        return !this.gameRepository.existsById(id);
//    }

}
