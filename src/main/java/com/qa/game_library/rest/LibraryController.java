package com.qa.game_library.rest;

import com.qa.game_library.domain.Game;
import com.qa.game_library.domain.Library;
import com.qa.game_library.dto.LibraryDTO;
import com.qa.game_library.service.LibraryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class LibraryController {

    private final LibraryService libraryService;

    @Autowired
    public LibraryController(LibraryService libraryService) {
        this.libraryService = libraryService;
    }

    @GetMapping("/getLibraries")
    public ResponseEntity<List<LibraryDTO>> getAllLibraries(){
        return ResponseEntity.ok(this.libraryService.readAllLibraries());
    }

    @PostMapping("/createLibrary")
    public ResponseEntity<LibraryDTO> createLibrary(@RequestBody Library library){
        return new ResponseEntity<LibraryDTO>(this.libraryService.createLibrary(library), HttpStatus.CREATED);
    }

    @DeleteMapping("/deleteLibrary/{id}")
    public Boolean deleteLibrary(@PathVariable Long id){
        return this.libraryService.deleteLibrary(id);
    }

    @GetMapping("/getLibraryById/{id}")
    public ResponseEntity<LibraryDTO> getLibraryById(@PathVariable Long id){
        return ResponseEntity.ok(this.libraryService.findLibraryById(id));
    }

    @PutMapping("/updateLibrary/{id}")
    public ResponseEntity<LibraryDTO> updateLibrary(@PathVariable Long id, @RequestBody Library library){
        return ResponseEntity.ok(this.libraryService.updateLibrary(id, library));
    }


}
