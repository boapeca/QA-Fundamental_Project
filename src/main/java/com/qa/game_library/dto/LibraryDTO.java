package com.qa.game_library.dto;

import java.util.ArrayList;
import java.util.List;

public class LibraryDTO {

    private Long id;
    private String name;
    private List<GameDTO> games = new ArrayList<>();

    public LibraryDTO() {
    }

    public List<GameDTO> getGames() {
        return games;
    }

    public void setGames(List<GameDTO> games) {
        this.games = games;
    }

    public LibraryDTO(String name) {
        this.name = name;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
