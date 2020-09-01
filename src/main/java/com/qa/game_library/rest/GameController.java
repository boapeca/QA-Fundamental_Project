package com.qa.game_library.rest;

import com.qa.game_library.domain.Game;
import com.qa.game_library.domain.User;
import com.qa.game_library.dto.GameDTO;
import com.qa.game_library.service.GameService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.websocket.server.PathParam;
import java.util.List;

@RestController
public class GameController {

    private final GameService gameService;

    @Autowired
    public GameController(GameService gameService) {
        this.gameService = gameService;
    }

    @GetMapping("/getGames")
    public ResponseEntity<List<GameDTO>> getAllGames(){
        return ResponseEntity.ok(this.gameService.readAllGames());
    }

    @PostMapping("/createGame")
    public ResponseEntity<GameDTO> createGame(@RequestBody Game game){
        return new ResponseEntity<GameDTO>(this.gameService.createGame(game), HttpStatus.CREATED);
    }

    @DeleteMapping("/deleteGame/{id}")
    public ResponseEntity<?> deleteGame(@PathVariable Long id){
        return this.gameService.deleteGame(id)
                ? ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build()
                : ResponseEntity.noContent().build();
    }

    @GetMapping("/getGameById/{id}")
    public ResponseEntity<GameDTO> getGameById(@PathVariable Long id){
        return ResponseEntity.ok(this.gameService.findGameById(id));

    }

    @PutMapping("/updateGame/{id}")
    public ResponseEntity<GameDTO> updateGame(@PathVariable Long id, @RequestBody Game game){
        return ResponseEntity.ok(this.gameService.updateGame(id, game));
    }

    @PutMapping("/updateGameWithPathParam")
    public ResponseEntity<GameDTO> updateGameWithPathParam(@PathParam("id") Long id, @RequestBody Game game){
        // localhost:8080/updateNoteWithPathParam?id=1
        return ResponseEntity.ok(this.gameService.updateGame(id, game));
    }


}
